package org.parsisys.tehranuniversity.library.view.beans;

import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.binding.BindingContainer;
import oracle.adf.model.BindingContext;
import oracle.binding.OperationBinding;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.DialogEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import org.parsisys.tehranuniversity.library.model.am.AppModuleImpl;

import org.parsisys.tehranuniversity.library.util.FResult;

import util.JSFUtils;

public class InsertPersonBean {
    private RichPopup savePersonPopup;
   private Boolean readonly;


    public InsertPersonBean() {
        super();
      readonly=false;
    }
    
    public void initPerson() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      
     UserStatus user = (UserStatus)JSFUtils.getManagedBeanValue("sessionUser");
      app.getSession().getUserData().put("labcolno",user.getLabcol() );
      app.getSession().getUserData().put("username",user.getUsername() );
      app.getSession().getUserData().put("libartid",user.getLibartid() );
      app.insert_person_init_person();
    }

    public void savePersonActionListener(ActionEvent actionEvent) {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      FResult fr=app.insert_person_save();
      if(fr!=null) {
        if("error".equals(fr.getType()))
        {
            JSFUtils.addFacesErrorMessage(fr.getText());
            return;
        }
      }
        FResult fr2=app.insert_person_post_insert();  
        if(fr2!=null) {
          if("error".equals(fr2.getType()))
          {
              JSFUtils.addFacesErrorMessage(fr2.getText());
              return;
          }
      }
       

      RichPopup.PopupHints ph = new RichPopup.PopupHints(); 
     getSavePersonPopup().show(ph);
    
    }

    public void setSavePersonPopup(RichPopup savePersonPopup) {
        this.savePersonPopup = savePersonPopup;
    }

    public RichPopup getSavePersonPopup() {
        return savePersonPopup;
    }

    public void savePersonDialogListener(DialogEvent dialogEvent) {
      
       setReadonly(true);
     
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }


    public void setReadonly(Boolean readonly) {
        this.readonly = readonly;
    }

    public Boolean getReadonly() {
        return readonly;
    }

   
}
