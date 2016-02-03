package org.parsisys.tehranuniversity.library.view.beans;

import java.sql.SQLException;

import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.event.QueryEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.domain.Number;
import oracle.jbo.server.ViewRowImpl;
import oracle.jbo.uicli.binding.JUCtrlListBinding;

import org.parsisys.tehranuniversity.library.model.am.AppModuleImpl;

import org.parsisys.tehranuniversity.library.util.FResult;

import util.JSFUtils;


public class CidExtend {
    private RichCommandButton save_button;
    private RichInputText inputtext_newEndDate;
    private String popUpText;
    private RichSelectOneChoice newPostSOC;

    public CidExtend() {
    // getSave_button().setDisabled(true);
    }

    public void post_changed(ValueChangeEvent valueChangeEvent) {
  
     
      BindingContainer bindings =
      BindingContext.getCurrent().getCurrentBindingsEntry();
      JUCtrlListBinding listBinding =
      (JUCtrlListBinding)bindings.get("CmemSetupPost"); 
      int index=(Integer)valueChangeEvent.getNewValue();
      if(index==0)
      {
          getInputtext_newEndDate().setValue(null);
          return;
      }
      Number newValue=(Number)((ViewRowImpl)listBinding.getValueFromList(index)).getAttribute("Value");
      
       
        AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      
            app.cid_extend_post_change(newValue);
      
    }

    public void preSearchPerson(QueryEvent queryOperationEvent) {
        // Add event code here...
        
//        BindingContainer bindings = getBindings();
//        OperationBinding operationBinding = bindings.getOperationBinding("cid_extend_post_query");
//        Object result = operationBinding.execute();
//        if (result==null){
//            System.out.println("function executed");
//            }
        
        invokeMethodExpression("#{bindings.searchbarcodeVCQuery.processQuery}",Object.class, QueryEvent.class, queryOperationEvent);
                    AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
           FResult result= app.cid_extend_post_query();
           getSave_button().setDisabled(false);
      getNewPostSOC().setDisabled(false);
           if(result!=null) {
             showError(result,true);
           }
          
    }
  private Object invokeMethodExpression(String expr, Class returnType,

                                            Class argType, Object argument) {

          return JSFUtils.invokeMethodExpression(expr, returnType,

                                        new Class[] { argType },

                                        new Object[] { argument });

      }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public String cb1_action() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("cid_extend_post_query");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        return null;
    }


    public void save_btn_action_listener(ActionEvent actionEvent) {
      BindingContainer bindings =
      BindingContext.getCurrent().getCurrentBindingsEntry();
      JUCtrlListBinding listBinding =
      (JUCtrlListBinding)bindings.get("CmemSetupPost");
      if(listBinding.getSelectedIndex()==0)
      {
          showError(new FResult("error","لطفا یک سمت جدید انتخاب کنید."), false);
          return;
      }
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
      FResult result= app.cid_extend_pre_save_button((String)((ViewRowImpl)listBinding.getValueFromList(listBinding.getSelectedIndex())).getAttribute("Text"));
      if(result!=null) {
          showError(result,false);
      }
    }

   

    public void setSave_button(RichCommandButton save_button) {
        this.save_button = save_button;
    }

    public RichCommandButton getSave_button() {
        return save_button;
    }
    
    private void showError(FResult result,boolean buttonDisable) {
       if(result==null)
           return;
        if("error".equalsIgnoreCase(result.getType()))
        {
      JSFUtils.addFacesErrorMessage(result.getText());
          getSave_button().setDisabled(buttonDisable);
          getNewPostSOC().setDisabled(buttonDisable);
        }
        else if("info".equalsIgnoreCase(result.getType()))
            JSFUtils.addFacesInfoMessage(result.getText());
      else if("yn_popup".equalsIgnoreCase(result.getType()))
            {
                setPopUpText(result.getText());
                boolean confirmSave=true;
                JSFUtils.showPopup("pt1:p1");
                
              
      //          if(confirmSave){           
      //          }
                    
                
                
            }
    }


    public void setInputtext_newEndDate(RichInputText inputtext_newEndDate) {
        this.inputtext_newEndDate = inputtext_newEndDate;
    }

    public RichInputText getInputtext_newEndDate() {
        return inputtext_newEndDate;
    }

    public void popUpYes_btn(ActionEvent actionEvent) {
      BindingContainer bindings =BindingContext.getCurrent().getCurrentBindingsEntry();
      JUCtrlListBinding listBinding =
          (JUCtrlListBinding)bindings.get("CmemSetupPost");
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 

      FResult result2=app.cid_extend_save_button(((Number)((ViewRowImpl)listBinding.getValueFromList(listBinding.getSelectedIndex())).getAttribute("Value")));
      showError(result2,false);
    }

    public void setPopUpText(String popUpText) {
        this.popUpText = popUpText;
    }

    public String getPopUpText() {
        return popUpText;
    }

    public String afterNext_fadak() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
      FResult result= app.cid_extend_post_query();
      getSave_button().setDisabled(false);
      getNewPostSOC().setDisabled(false);
      if(result!=null) {
      showError(result,true);
      }
        return null;
    }

    public String afterPrevious_fadak() {
        AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
        FResult result= app.cid_extend_post_query();
        getSave_button().setDisabled(false);
      getNewPostSOC().setDisabled(false);
        if(result!=null) {
        showError(result,true);
        }
        return null;
    }

    public void setNewPostSOC(RichSelectOneChoice newPostSOC) {
        this.newPostSOC = newPostSOC;
    }

    public RichSelectOneChoice getNewPostSOC() {
        return newPostSOC;
    }
}
