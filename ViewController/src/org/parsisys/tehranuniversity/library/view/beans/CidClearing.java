package org.parsisys.tehranuniversity.library.view.beans;

import javax.faces.event.ActionEvent;

import oracle.adf.model.AttributeBinding;
import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCBindingContainer;

import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.binding.BindingContainer;

import oracle.adf.view.rich.event.QueryEvent;

import oracle.jbo.ViewObject;
import oracle.jbo.uicli.binding.JUCtrlListBinding;

import org.parsisys.tehranuniversity.library.model.am.AppModuleImpl;

import org.parsisys.tehranuniversity.library.util.FResult;

import org.parsisys.tehranuniversity.library.util.ParsiUtil;

import util.JSFUtils;

public class CidClearing {

    private String thesisLetterNo;
    private String popUpText;
    private Boolean enablebtn=false;
    private String reportPath;
    private String libsName;
    private RichInputText postTextInputText;

    public CidClearing() {
        super();
    }

    public void setThesisLetterNo(String thesisLetterNo) {
        this.thesisLetterNo = thesisLetterNo;
    }

    public String getThesisLetterNo() {
        return thesisLetterNo;
    }
public String getEncodedPostTxt() {
    //System.out.println((String)getPostTextInputText().getValue());
      return ParsiUtil.encodePersianText((String)getPostTextInputText().getValue());
    }
    public void checkPerson(QueryEvent queryOperationEvent) {


        //      BindingContainer bindings2 = BindingContext.getCurrent().getCurrentBindingsEntry();
        //        AttributeBinding attrBindingList =(AttributeBinding) bindings2.get("Barcode");

        invokeMethodExpression("#{bindings.searchbarcodeidQuery.processQuery}",
                               Object.class, QueryEvent.class,
                               queryOperationEvent);

        DCBindingContainer bc =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();

       if(bc.findIteratorBinding("PersonVO1Iterator").getRowSetIterator().getRowCount()>0)
       {
        String barcode =
            (String)bc.findIteratorBinding("PersonVO1Iterator").getCurrentRow().getAttribute("Barcode");


        AppModuleImpl app =
            ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
        
        FResult result = app.cid_clearing_checkPerson((String)barcode);


        if (result != null) {
            if (result.getType().equalsIgnoreCase("error")) {
                JSFUtils.addFacesErrorMessage(result.getText());
            }else  if (result.getType().equalsIgnoreCase("return")) {
              setEnablebtn((Boolean) result.getResult());
          }
        }
       }
       else 
      JSFUtils.addFacesErrorMessage("عضو با مشخصات داده شده در سیستم موجود نمی باشد.");
    }

    private Object invokeMethodExpression(String expr, Class returnType,

        Class argType, Object argument) {

        return JSFUtils.invokeMethodExpression(expr, returnType, new

                Class[] { argType }, new

                Object[] { argument });

    }

    public void preSave(ActionEvent actionEvent) {
        AppModuleImpl app =
            ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
        FResult result = app.cid_clearing_preSave(getThesisLetterNo());

        if (result != null) {
            if (result.getType().equalsIgnoreCase("error")) {
                JSFUtils.addFacesErrorMessage(result.getText());
            }
        }

        if (result != null) {
            if (result.getType().equalsIgnoreCase("yn_popup")) {
                setPopUpText(result.getText());
                JSFUtils.showPopup("pt1:p1");
            }
        }


    }

    public void setPopUpText(String popUpText) {
        this.popUpText = popUpText;
    }

    public String getPopUpText() {
        return popUpText;
    }

    public void savebtn(ActionEvent actionEvent) {
        AppModuleImpl app =
            ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
        FResult result= app.cid_clearing_Save(getThesisLetterNo());
        if(result!=null){
            if ("return".equalsIgnoreCase(result.getType())){
                 setReportPath(getReportPath().concat("&p_libs_name="+result.getText())); 
                }
            }
        
      JSFUtils.showPopup("pt1:reportPop");            
    }

    public String canclPopupbtn(ActionEvent actionEvent) {
        return null;
    }

    
    public String afterNext_fadak() {
      DCBindingContainer bc =
          (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();

      if(bc.findIteratorBinding("PersonVO1Iterator").getRowSetIterator().getRowCount()>0)
      {
      String barcode =
          (String)bc.findIteratorBinding("PersonVO1Iterator").getCurrentRow().getAttribute("Barcode");


      AppModuleImpl app =
          ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      
      FResult result = app.cid_clearing_checkPerson((String)barcode);


      if (result != null) {
          if (result.getType().equalsIgnoreCase("error")) {
              JSFUtils.addFacesErrorMessage(result.getText());
          }else  if (result.getType().equalsIgnoreCase("return")) {
              setEnablebtn((Boolean) result.getResult());
          }
      }
      }
      else
      JSFUtils.addFacesErrorMessage("عضو با مشخصات داده شده در سیستم موجود نمی باشد.");
      
        return null;
    }

    public String afterprevious_fadak() {
      DCBindingContainer bc =
          (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();

      if(bc.findIteratorBinding("PersonVO1Iterator").getRowSetIterator().getRowCount()>0)
      {
      String barcode =
          (String)bc.findIteratorBinding("PersonVO1Iterator").getCurrentRow().getAttribute("Barcode");


      AppModuleImpl app =
          ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      
      FResult result = app.cid_clearing_checkPerson((String)barcode);


      if (result != null) {
          if (result.getType().equalsIgnoreCase("error")) {
              JSFUtils.addFacesErrorMessage(result.getText());
          }else  if (result.getType().equalsIgnoreCase("return")) {
              setEnablebtn((Boolean) result.getResult());
          }
      }
      }
      else
      JSFUtils.addFacesErrorMessage("عضو با مشخصات داده شده در سیستم موجود نمی باشد.");
      
        return null;
    }

    public void setEnablebtn(Boolean enablebtn) {
        this.enablebtn = enablebtn;
    }

    public Boolean getEnablebtn() {
        return enablebtn;
    }

    public void setReportPath(String reportPath) {
        this.reportPath = reportPath;
    }

    public String getReportPath() {
        return reportPath;
    }

    public void setLibsName(String libsName) {
        this.libsName = libsName;
}

    public String getLibsName() {
        return libsName;
    }

    public void setPostTextInputText(RichInputText postTextInputText) {
        this.postTextInputText = postTextInputText;
    }

    public RichInputText getPostTextInputText() {
        return postTextInputText;
    }
}
