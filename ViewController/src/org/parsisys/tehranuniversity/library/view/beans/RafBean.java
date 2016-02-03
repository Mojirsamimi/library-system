package org.parsisys.tehranuniversity.library.view.beans;



import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;

import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.input.RichInputFile;



import org.apache.myfaces.trinidad.model.UploadedFile;


import org.parsisys.tehranuniversity.library.model.am.AppModuleImpl;

import org.parsisys.tehranuniversity.library.util.FResult;

import util.JSFUtils;


public class RafBean {


    private RichInputFile rafFileInput;
    private Boolean rendered=false;
    private Boolean allPlace=false;

    public RafBean() {
    }
    
  public void uploadActionListener(ActionEvent actionEvent) {
        InputStream is=null;
        InputStreamReader isr=null;
        BufferedReader br=null;
          try {
         UploadedFile uplodedFile=   (UploadedFile) getRafFileInput().getValue();
             if(uplodedFile==null) {
               JSFUtils.addFacesErrorMessage("لطفا یک فایل را انتخاب نمایید.");
               return;
             }
             is=  (uplodedFile).getInputStream();
            AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
              FResult fr=app.raf_upload(is);
              if(fr!=null) {
                if("error".equals(fr.getType())) {
                  JSFUtils.addFacesErrorMessage(fr.getText());
                  return;
                }else if("return".equals(fr.getType())) {
                  long[] result = (long[])fr.getResult();
                  JSFUtils.addFacesInfoMessage("بارگذاری فایل با موفقیت انجام شد.");
                  JSFUtils.addFacesInfoMessage("تعداد کل رکوردهای فایل: "+(result[0]+result[1]+result[2])); 
                  JSFUtils.addFacesInfoMessage("تعداد رکوردهای جدید: "+result[0]);
                  JSFUtils.addFacesInfoMessage("تعداد رکوردهای تکراری: "+result[1]);
                  JSFUtils.addFacesInfoMessage("تعداد رکوردهای نامعتبر: "+result[2]);
                 
                  return;
                }
              }
//            isr=new InputStreamReader(is);
//              br=new BufferedReader(isr);
//              System.out.println( br.readLine());
          } catch (IOException e) {
              e.printStackTrace();
          }
      }


    public void setRafFileInput(RichInputFile rafFileInput) {
        this.rafFileInput = rafFileInput;
    }

    public RichInputFile getRafFileInput() {
        return rafFileInput;
    }


    public void setRendered(Boolean rendered) {
        this.rendered = rendered;
    }

    public Boolean getRendered() {
        return rendered;
    }

    public void runReportActionListener(ActionEvent actionEvent) {
        setRendered(true);
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      app.raf_refreshRafReport(getAllPlace());
    }

    public void setAllPlace(Boolean allPlace) {
        this.allPlace = allPlace;
    }

    public Boolean getAllPlace() {
        return allPlace;
    }
}
