package org.parsisys.tehranuniversity.library.view.beans;

import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.jbo.domain.Number;
import oracle.jbo.server.ViewRowImpl;

import org.parsisys.tehranuniversity.library.model.am.AppModuleImpl;
import org.parsisys.tehranuniversity.library.util.FResult;

import util.JSFUtils;

public class PublicNonCashPenalty {
 
  private String penaltyDesc="";
  private String payDesc="";
  private String path;
  private String title;
  private String popupText;
  private RichInputText   penaltyPayInputtxt;

  private RichInputText   penaltyDescInputtxt;
    private RichPopup popUpEditYesNo;
    private RichPopup popUpInsertYesNo;

    public PublicNonCashPenalty() {
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

    public void test(ActionEvent actionEvent) {
System.out.println(getPath());

}

    public void test2(ActionEvent actionEvent) {
      System.out.println(getPath());
    }

    public void setPenaltyDesc(String penaltyDesc) {
        this.penaltyDesc = penaltyDesc;
    }

    public String getPenaltyDesc() {
        return penaltyDesc;
    }

    public void setPayDesc(String payDesc) {
        this.payDesc = payDesc;
    }

    public String getPayDesc() {
        return payDesc;
    }

    public void preEdit_savebtn(ActionEvent actionEvent) {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
      FResult result= app.preEdit_publicNonCashPenalty(getPayDesc(),getPenaltyDesc());
        if("error".equalsIgnoreCase(result.getType()))
        {
        JSFUtils.addFacesErrorMessage(result.getText());
          
        }else if("yn_popup".equalsIgnoreCase(result.getType())){
            //TODO:find pop id to show
            setPopupText(result.getText());
             
              RichPopup.PopupHints ph = new RichPopup.PopupHints(); 
              popUpEditYesNo.show(ph);
            //JSFUtils.showPopup("pt1:r1:1:p2");
            
            }
        
//      penaltyPayInputtxt.setSubmittedValue(null);
//      penaltyDescInputtxt.setSubmittedValue(null);
//     penaltyPayInputtxt.setValue(null);
    }

    public void setPopupText(String popupText) {
        this.popupText = popupText;
    }

    public String getPopupText() {
        return popupText;
    }

   
    public void preInsert_Savebtn(ActionEvent actionEvent) {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
      FResult result= app.preInsert_publicNonCashPenalty(getPayDesc(),getPenaltyDesc());
        if("error".equalsIgnoreCase(result.getType()))
        {
        JSFUtils.addFacesErrorMessage(result.getText());
          
        }else if("yn_popup".equalsIgnoreCase(result.getType())){
           
            setPopupText(result.getText());
            //JSFUtils.showPopup("pt1:r1:1:p3");
            RichPopup.PopupHints ph = new RichPopup.PopupHints(); 
            popUpInsertYesNo.show(ph);      
            }
      
      
//     penaltyPayInputtxt.setSubmittedValue(null);
//     penaltyDescInputtxt.setSubmittedValue(null);
    }

    public String popUpYesbtn_insert() {
        AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
        app.insert_publicNonCashPenalty(getPayDesc(),getPenaltyDesc());
       
       
      return "end_new";
    }

    public String popUpYesbtn_edit() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
      app.edit_publicNonCashPenalty(getPayDesc(),getPenaltyDesc());
      setPenaltyDesc("");
      setPayDesc("");
        
        return "end_edit";
    }

    

    public void setPenaltyPayInputtxt(RichInputText penaltyPayInputtxt) {
        this.penaltyPayInputtxt = penaltyPayInputtxt;
    }

    public RichInputText getPenaltyPayInputtxt() {
        return penaltyPayInputtxt;
    }

    public void setPenaltyDescInputtxt(RichInputText penaltyDescInputtxt) {
        this.penaltyDescInputtxt = penaltyDescInputtxt;
    }

    public RichInputText getPenaltyDescInputtxt() {
        return penaltyDescInputtxt;
    }

    public void setPopUpEditYesNo(RichPopup testPopUp) {
        this.popUpEditYesNo = testPopUp;
    }

    public RichPopup getPopUpEditYesNo() {
        return popUpEditYesNo;
    }

    public void setPopUpInsertYesNo(RichPopup popUpInsertYesNo) {
        this.popUpInsertYesNo = popUpInsertYesNo;
    }

    public RichPopup getPopUpInsertYesNo() {
        return popUpInsertYesNo;
    }

    public void activeValue_changed(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 

        if (new Number (1).equals((Number)valueChangeEvent.getOldValue()))
              
        {
        
            JSFUtils.showPopup("pt1:activeChangePop");
            
            }
        else{
              app.publicNonCashPenaltyChangeActive(1);            
              app.publicNonCashPenaltyAfterActiveChanged();
            
            }
            
    }

    public String popUp_yesbtn_applyChange() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
      app.publicNonCashPenaltyChangeActive(0);            
      app.publicNonCashPenaltyAfterActiveChanged();
        return null;
    }

   
}
