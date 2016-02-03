package org.parsisys.tehranuniversity.library.view.beans;

import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.event.QueryEvent;

import oracle.jbo.domain.Number;

import org.parsisys.tehranuniversity.library.model.am.AppModuleImpl;

import org.parsisys.tehranuniversity.library.util.FResult;

import util.JSFUtils;

public class Sandoogh {
    private String penaltyDescription;
  private String popUpText;
private String mode;
private boolean errorMode=false;
    private Number penaltyValue;
    private boolean disableExit=true;
    public Sandoogh() {
        super();
    }

    public String selectPerson_btn() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      
       app.sandoogh_fillForm();
       setMode("list");
      FResult result=app.sandoogh_initPerson(getMode());
        if(result!=null)
        {
        if("error".equals(result.getType())) {
          JSFUtils.addFacesErrorMessage(result.getText());
          setErrorMode(true);
        }else if("return".equals(result.getType())){
          setDisableExit((Boolean)result.getResult());
        }else if("yn_popup".equals(result.getType())){
              setPopUpText(result.getText());
              JSFUtils.showPopup("pt1:passcourse");
            
            }
        }
        return null;
    }
    
  public void postSearch_initPerson(QueryEvent queryOperationEvent)
  {
    
    AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
   invokeMethodExpression("#{bindings.searchbarcodeidQuery.processQuery}",Object.class, QueryEvent.class, queryOperationEvent);
      setMode("search");
      FResult result=app.sandoogh_initPerson(getMode());
   
    if(result!=null){
        if(result.getType().equalsIgnoreCase("error")){
        JSFUtils.addFacesErrorMessage(result.getText());
         return;
        }else if("return".equals(result.getType())){
          setDisableExit((Boolean)result.getResult());
        }else if("yn_popup".equals(result.getType())){
              setPopUpText(result.getText());
              JSFUtils.showPopup("pt1:passcourse");
            
            }
    }
    
  }
  private Object invokeMethodExpression(String expr, Class returnType,

                                            Class argType, Object argument) {

          return JSFUtils.invokeMethodExpression(expr, returnType,

                                        new Class[] { argType },

                                        new Object[] { argument });

      }

    public void save_enter(ActionEvent actionEvent) {
        
        if (errorMode){
            JSFUtils.addFacesErrorMessage("عملیات مورد نظر برای این شخص امکان پذیر نمی باشد.");
            return;
            }
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      FResult result=app.sandoogh_saveFunc("ENTER");
      if(result!=null){
          if(result.getType().equalsIgnoreCase("error")){
          JSFUtils.addFacesErrorMessage(result.getText());
           return;
          }else if(result.getType().equalsIgnoreCase("info")){
            JSFUtils.addFacesInfoMessage(result.getText());
            }
      }
      setDisableExit(false);
    }

    public void save_exit(ActionEvent actionEvent) {
        AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
        FResult result=app.sandoogh_saveFunc("EXIT");
        if(result!=null){
            if(result.getType().equalsIgnoreCase("error")){
            JSFUtils.addFacesErrorMessage(result.getText());
             return;
            }   else if(result.getType().equalsIgnoreCase("penaltyPopUp")){
            
            JSFUtils.showPopup("pt1:penalty");
            }else if(result.getType().equalsIgnoreCase("info")){
            JSFUtils.addFacesInfoMessage(result.getText());
              setDisableExit(true);
             return;
            } 
        }
        
      
    }

    public void showListActionListener(ActionEvent actionEvent) {
     
    }

    public String show_penalty_confirmPopUp() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      FResult result=app.sandoogh_penalty(getPenaltyValue(), getPenaltyDescription());
      if(result!=null){
          if(result.getType().equalsIgnoreCase("error")){
            JSFUtils.addFacesErrorMessage(result.getText());

          }else if(result.getType().equalsIgnoreCase("yn_popup")){
            setPopUpText(result.getText());
            JSFUtils.showPopup("pt1:penaltyConfirm");
              
          }

          }     
        return null;
    }

    public void setPenaltyDescription(String penaltyDescription) {
        this.penaltyDescription = penaltyDescription;
    }

    public String getPenaltyDescription() {
        return penaltyDescription;
    }

    public void setPenaltyValue(Number penaltyValue) {
        this.penaltyValue = penaltyValue;
    }

    public Number getPenaltyValue() {
        return penaltyValue;
    }

    public void setPopUpText(String popUpText) {
        this.popUpText = popUpText;
    }

    public String getPopUpText() {
        return popUpText;
    }

    public void setDisableExit(boolean disableEnter) {
        this.disableExit = disableEnter;
    }

    public boolean isDisableExit() {
        return disableExit;
    }

    public void cinfirmbtn_memPassCoursePopUp(ActionEvent actionEvent) {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      FResult result= app.sandoogh_initPerson_popUpYes_btn(getMode());
      
      if("return".equals(result.getType())){
                setDisableExit((Boolean)result.getResult());
              }
      
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getMode() {
        return mode;
    }

    public void penaltyConfirmPopUp_yesbtn(ActionEvent actionEvent) {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      FResult result=app.sandoogh_penalty_yesbtn(getPenaltyValue(), getPenaltyDescription());
      if(result!=null){
          if(result.getType().equalsIgnoreCase("error")){
            JSFUtils.addFacesErrorMessage(result.getText());

          }else if("info".equals(result.getType())) {
            JSFUtils.addFacesInfoMessage(result.getText());
          }
        
      }
      result=app.sandoogh_clearForm();
      if("return".equals(result.getType())){
                setDisableExit((Boolean)result.getResult());
              }
      
    }

    public void setErrorMode(boolean errorMode) {
        this.errorMode = errorMode;
    }

    public boolean isErrorMode() {
        return errorMode;
    }
}
