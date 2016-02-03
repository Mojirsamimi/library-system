package org.parsisys.tehranuniversity.library.view.beans;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;

import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.event.QueryEvent;
import oracle.adf.view.rich.event.QueryOperationEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.domain.Number;
import oracle.jbo.server.ViewRowImpl;

import oracle.jbo.uicli.binding.JUCtrlListBinding;

import org.parsisys.tehranuniversity.library.model.am.AppModuleImpl;
import org.parsisys.tehranuniversity.library.util.FResult;

import org.parsisys.tehranuniversity.library.util.ParsiUtil;

import util.JSFUtils;


public class CidMemStatusChange {
  private Number newStatus;
  private String newStDescription;
  private String popUpText;
  private RichCommandButton disablebtn_create;

    public CidMemStatusChange() {
    }

  public void afterSearchMember(QueryOperationEvent queryOperationEvent) {
    invokeMethodExpression("#{bindings.searchbarcodeidQuery.processQueryOperation}",Object.class, QueryEvent.class, queryOperationEvent);
      
    AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
    
    FResult result =(FResult) app.memStatusChange_afterSearch();
    
    if(app.getPersonVO1().getCurrentRow()!=null)
    {
      disablebtn_create.setDisabled(false);
    }
    
    if (result != null) {
        if (result.getType().equalsIgnoreCase("error")) {
            JSFUtils.addFacesErrorMessage(result.getText());
        }
    }
  }
  private Object invokeMethodExpression(String expr, Class returnType,

                                            Class argType, Object argument) {

          return JSFUtils.invokeMethodExpression(expr, returnType,

                                        new Class[] { argType },

                                        new Object[] { argument });

      }
    public void setNewStatus(Number newStatus) {
        this.newStatus = newStatus;
    }

    public Number getNewStatus() {
        return newStatus;
    }

    public void setNewStDescription(String newStDescription) {
        this.newStDescription = newStDescription;
    }

    public String getNewStDescription() {
        return newStDescription;
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }


    public void save_action_listener(ActionEvent actionEvent) {
        
      BindingContainer bindings =
      BindingContext.getCurrent().getCurrentBindingsEntry();
      JUCtrlListBinding listBinding =(JUCtrlListBinding)bindings.get("NewMemshipStatus");   
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
       
       
      if(listBinding.getSelectedIndex()==0)
       //if( listBinding.getValueFromList().equals(""))
          JSFUtils.addFacesErrorMessage("لطفا وضعیت جدید را انتخاب کنید."); 
       else{
      FResult result=app.preSave_MemStatusChange( (Number)((ViewRowImpl)listBinding.getValueFromList(listBinding.getSelectedIndex())).getAttribute("Value"));
       
       if(result!=null)
       {
      if(result.getType().equalsIgnoreCase("error"))
                JSFUtils.addFacesErrorMessage(result.getText());
      else if(result.getType().equalsIgnoreCase("yn_popup"))
             {
                setPopUpText(result.getText());
               JSFUtils.showPopup("pt1:p1");   
             }
    }
       }
    }
    public void setPopUpText(String popUpText) {
        this.popUpText = popUpText;
    }

    public String getPopUpText() {
        return popUpText;
    }

    public void popUpYes_btn(ActionEvent actionEvent) {
       
      BindingContainer bindings =
      BindingContext.getCurrent().getCurrentBindingsEntry();
      JUCtrlListBinding listBinding =
      (JUCtrlListBinding)bindings.get("NewMemshipStatus");  
    
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
       
        FResult result=app.save_MemStatusChange(getNewStDescription(), (Number)((ViewRowImpl)listBinding.getValueFromList(listBinding.getSelectedIndex())).getAttribute("Value"));
        if(result!=null)
        {
        if(result.getType().equalsIgnoreCase("error"))
        {
           JSFUtils.addFacesErrorMessage(result.getText());
         
        }
        }
        JSFUtils.addFacesInfoMessage("وضعیت جدید ثبت گردید.");
    }


    public String afterNext_fadak() {
        AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
        FResult result =(FResult) app.memStatusChange_afterSearch();
        
        if (result != null) {
            if (result.getType().equalsIgnoreCase("error")) {
                JSFUtils.addFacesErrorMessage(result.getText());
            }
        }
        return null;
    }

    public String afterPrevious_fadak() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
      FResult result =(FResult) app.memStatusChange_afterSearch();
      
      if (result != null) {
          if (result.getType().equalsIgnoreCase("error")) {
              JSFUtils.addFacesErrorMessage(result.getText());
          }
      }
        return null;
    }

    public void setDisablebtn_create(RichCommandButton disablebtn_create) {
        this.disablebtn_create = disablebtn_create;
    }

    public RichCommandButton getDisablebtn_create() {
        return disablebtn_create;
    }
}
