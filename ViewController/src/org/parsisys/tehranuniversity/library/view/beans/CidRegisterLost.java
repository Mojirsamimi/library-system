package org.parsisys.tehranuniversity.library.view.beans;

import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.RichPopup;

import org.parsisys.tehranuniversity.library.model.am.AppModuleImpl;
import org.parsisys.tehranuniversity.library.util.FResult;

import util.JSFUtils;

public class CidRegisterLost {
  
  private String path;
  private String title;
  private String penaltyDesc;
  private String popupText;
  private int penaltyValue;
  private RichPopup popUpEditYesNo;
  private RichPopup popUpInsertYesNobtn;
  
    public CidRegisterLost() {
        super();
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setPenaltyDesc(String penaltyDesc) {
        this.penaltyDesc = penaltyDesc;
    }

    public String getPenaltyDesc() {
        return penaltyDesc;
    }

    public void setPopupText(String popupText) {
        this.popupText = popupText;
    }

    public String getPopupText() {
        return popupText;
    }

    public void setPenaltyValue(int penaltyValue) {
        this.penaltyValue = penaltyValue;
    }

    public int getPenaltyValue() {
        return penaltyValue;
    }

    public void setPopUpEditYesNo(RichPopup popUpEditYesNo) {
        this.popUpEditYesNo = popUpEditYesNo;
    }

    public RichPopup getPopUpEditYesNo() {
        return popUpEditYesNo;
    }

    public void setPopUpInsertYesNobtn(RichPopup popUpInsertYesNobtn) {
        this.popUpInsertYesNobtn = popUpInsertYesNobtn;
    }

    public RichPopup getPopUpInsertYesNobtn() {
        return popUpInsertYesNobtn;
    }

    public void preInsert_insertbtn(ActionEvent actionEvent) {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
      
      FResult result= app.registerLost_preInsert(getPenaltyValue());
        if("error".equalsIgnoreCase(result.getType()))
        {
        JSFUtils.addFacesErrorMessage(result.getText());
          
        }else if("yn_popup".equalsIgnoreCase(result.getType())){
            
            setPopupText(result.getText());
            
            RichPopup.PopupHints ph = new RichPopup.PopupHints(); 
            popUpInsertYesNobtn.show(ph);
            
            }
    }
    
  public String popUpYesbtn_insert() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
      boolean result= app.registerLost_insert( getPenaltyValue(), getPenaltyDesc());
     
    if (result)
        JSFUtils.addFacesInfoMessage("رکورد جدید ثبت گردید.");
      else
        JSFUtils.addFacesErrorMessage("خطا در ثبت تغییرات");

    return "exit";
  }

    public String popUpYesbtn_edit() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
      boolean result= app.registerLost_edit( getPenaltyValue(), getPenaltyDesc());
      
      if (result)
          JSFUtils.addFacesInfoMessage("تغییرات ثبت گردید");
        else
          JSFUtils.addFacesErrorMessage("ثبت تغییرات با مشکل مواجه شد.");

          
        return "exit";
    }

    public void preEdit_savebtn(ActionEvent actionEvent) {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
      
      FResult result= app.registerLost_preEdit(getPenaltyValue(),getPenaltyDesc());
        if("error".equalsIgnoreCase(result.getType()))
        {
        JSFUtils.addFacesErrorMessage(result.getText());
          
        }else if("yn_popup".equalsIgnoreCase(result.getType())){
            
            setPopupText(result.getText());
            
            RichPopup.PopupHints ph = new RichPopup.PopupHints(); 
            popUpEditYesNo.show(ph);
            
            }
    }
}
