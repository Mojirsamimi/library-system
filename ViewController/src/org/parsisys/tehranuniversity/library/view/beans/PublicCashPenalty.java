package org.parsisys.tehranuniversity.library.view.beans;

import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;

import org.parsisys.tehranuniversity.library.model.am.AppModuleImpl;
import org.parsisys.tehranuniversity.library.util.FResult;

import util.JSFUtils;

public class PublicCashPenalty {
    
  private String penaltyDesc;
 
  private String path;
  private String title;
  private String popupText;
  private int penaltyValue;
   
  private RichPopup popUpEditYesNo;
 
    private RichPopup popUpInsertYesNobtn;
    private RichInputText clearText_penalty;
    private RichInputText clearText_penaltyDesc;

    public PublicCashPenalty() {
        super();
    }

    public void setPenaltyDesc(String penaltyDesc) {
        this.penaltyDesc = penaltyDesc;
    }

    public String getPenaltyDesc() {
        return penaltyDesc;
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

    public void setPopupText(String popupText) {
        this.popupText = popupText;
    }

    public String getPopupText() {
        return popupText;
    }

    

    public void popupYesbtnInsert(ActionEvent actionEvent) {
    
     
        
    }

    public void popupYesbtnEdit(ActionEvent actionEvent) {
        
     
    }

    public void preEditSavebtn(ActionEvent actionEvent) {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
      FResult result= app.preEdit_publicPenalty( getPenaltyValue(), getPenaltyDesc());
        if("error".equalsIgnoreCase(result.getType()))
        {
        JSFUtils.addFacesErrorMessage(result.getText());
          
        }else if("yn_popup".equalsIgnoreCase(result.getType())){
            
            setPopupText(result.getText());
            //JSFUtils.showPopup("pt1:r1:2:pe1");
            RichPopup.PopupHints ph = new RichPopup.PopupHints(); 
            popUpEditYesNo.show(ph);
            }
       
    }

    public void preInsertSavebtn(ActionEvent actionEvent) {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
      FResult result= app.preInsert_publicPenalty( getPenaltyValue(), getPenaltyDesc());
        if("error".equalsIgnoreCase(result.getType()))
        {
        JSFUtils.addFacesErrorMessage(result.getText());
          
        }else if("yn_popup".equalsIgnoreCase(result.getType())){
            
            setPopupText(result.getText());
           // JSFUtils.showPopup("pt1:r1:1:pp3");
            RichPopup.PopupHints ph = new RichPopup.PopupHints(); 
            popUpInsertYesNobtn.show(ph);
          
            }
     
    }

    public void setPenaltyValue(int penaltyValue) {
        this.penaltyValue = penaltyValue;
    }

    public int getPenaltyValue() {
        return penaltyValue;
    }

    public String popUpNoBtn_emptyTextBox() {
        
      clearText_penalty.setValue(null);
      clearText_penaltyDesc.setValue(null);
        return "exit_new";
    }

    public String popUpNoBtn_clearText_edit() {
        
      clearText_penalty.setValue(null);
      clearText_penaltyDesc.setValue(null);
        return "exit_edit";
    }

    public String popUpYesbtn_edit() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
      app.edit_publicPenalty( getPenaltyValue(), getPenaltyDesc());
   
      
      clearText_penalty.setValue(null);
      clearText_penaltyDesc.setValue(null);
        return "exit_edit";
    }

    public String popUpYesbtn_insert() {
        AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
        app.insert_publicPenalty( getPenaltyValue(), getPenaltyDesc());
       
      clearText_penalty.setValue(null);
      clearText_penaltyDesc.setValue(null);
        return "exit_new";
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

    public void setClearText_penalty(RichInputText clearText_penalty) {
        this.clearText_penalty = clearText_penalty;
    }

    public RichInputText getClearText_penalty() {
        return clearText_penalty;
    }

    public void setClearText_penaltyDesc(RichInputText clearText_penaltyDesc) {
        this.clearText_penaltyDesc = clearText_penaltyDesc;
    }

    public RichInputText getClearText_penaltyDesc() {
        return clearText_penaltyDesc;
    }
}
