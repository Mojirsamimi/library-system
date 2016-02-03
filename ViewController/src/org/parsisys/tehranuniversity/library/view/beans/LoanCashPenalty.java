package org.parsisys.tehranuniversity.library.view.beans;

import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.component.rich.nav.RichCommandButton;

import oracle.jbo.domain.Number;

import org.parsisys.tehranuniversity.library.model.am.AppModuleImpl;
import org.parsisys.tehranuniversity.library.util.FResult;

import util.JSFUtils;

public class LoanCashPenalty {
  private String title;
   private String popUpText;
   private int penaltyValue;
  private String penaltyDesc;
    private RichPopup popUpInsertYesNo;
    private RichPopup popUpEditYesNo;
    private RichInputText value_clearText;
    private RichInputText desc_clearText;
    private RichCommandButton editbtn_disabled;
    //
  //pt1:r1:2:pe1
    public LoanCashPenalty() {
        super();
    }

    public void setPopUpText(String popUpTExt) {
        this.popUpText = popUpTExt;
    }

    public String getPopUpText() {
        return popUpText;
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

    public String popUpYesbtn_saveLoanPenalty() {
        AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
        boolean result= app.insert_loanCashPenalty(getPenaltyValue(), getPenaltyDesc());
        setPenaltyDesc("");
        setPenaltyValue(0);
        
        if(result)
          JSFUtils.addFacesInfoMessage("جریمه جدید ثبت گردید.");
            
      desc_clearText.setValue(null);    
      value_clearText.setValue(null);
        return "exit_new";
    }

    public void preInsertLoanCashPenalty(ActionEvent actionEvent) {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
      
      FResult result= app.preInsert_loanCashPenalty(getPenaltyValue(), getPenaltyDesc());
        if("error".equalsIgnoreCase(result.getType()))
        {
        JSFUtils.addFacesErrorMessage(result.getText());
          
        }else if("yn_popup".equalsIgnoreCase(result.getType())){
            
            setPopUpText(result.getText());
            //JSFUtils.showPopup("pt1:r1:1:pi1");
            RichPopup.PopupHints ph = new RichPopup.PopupHints(); 
            popUpInsertYesNo.show(ph);
            
            }
       
    }

    public void setPenaltyValue(int penaltyValue) {
        this.penaltyValue = penaltyValue;
    }

    public int getPenaltyValue() {
        return penaltyValue;
    }

    public String popUpYesbtn_editLoanPenalty() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
      boolean result= app.edit_loanCashPenalty(getPenaltyValue(), getPenaltyDesc());
      setPenaltyDesc("");
      setPenaltyValue(0);
      
      if(result)
        JSFUtils.addFacesInfoMessage("جریمه ویرایش  گردید.");
          
        return "exit_edit";
    }

    public void preEditLoanCashPenalty(ActionEvent actionEvent) {
        AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
        
        FResult result= app.preEdit_loanCashPenalty(getPenaltyValue(), getPenaltyDesc());
          if("error".equalsIgnoreCase(result.getType()))
          {
          JSFUtils.addFacesErrorMessage(result.getText());
            
          }else if("yn_popup".equalsIgnoreCase(result.getType())){
              
              setPopUpText(result.getText());
              //JSFUtils.showPopup("pt1:r1:1:pe1");
              RichPopup.PopupHints ph = new RichPopup.PopupHints(); 
              popUpEditYesNo.show(ph);
              }
         
    }

    public void setPopUpInsertYesNo(RichPopup popUpInsertYesNo) {
        this.popUpInsertYesNo = popUpInsertYesNo;
    }

    public RichPopup getPopUpInsertYesNo() {
        return popUpInsertYesNo;
    }

    public void setPopUpEditYesNo(RichPopup popUpEditYesNo) {
        this.popUpEditYesNo = popUpEditYesNo;
    }

    public RichPopup getPopUpEditYesNo() {
        return popUpEditYesNo;
    }

    public void setValue_clearText(RichInputText value_clearText) {
        this.value_clearText = value_clearText;
    }

    public RichInputText getValue_clearText() {
        return value_clearText;
    }

    public void setDesc_clearText(RichInputText desc_clearText) {
        this.desc_clearText = desc_clearText;
    }

    public RichInputText getDesc_clearText() {
        return desc_clearText;
    }

    public void setEditbtn_disabled(RichCommandButton editbtn_disabled) {
        this.editbtn_disabled = editbtn_disabled;
    }

    public RichCommandButton getEditbtn_disabled() {
        return editbtn_disabled;
    }
}
