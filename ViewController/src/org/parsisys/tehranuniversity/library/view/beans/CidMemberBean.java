package org.parsisys.tehranuniversity.library.view.beans;

import java.io.Serializable;

import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.controller.ControllerContext;
import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCDataControl;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.PopupCanceledEvent;

import org.parsisys.tehranuniversity.library.model.am.AppModuleImpl;

import org.parsisys.tehranuniversity.library.util.FResult;

import util.JSFUtils;

public class CidMemberBean implements Serializable{
    private Boolean readonly;
    private transient RichSelectOneChoice sectSelectOneChoice;
    private transient RichSelectOneChoice mjrSelectOneChoice;

    public CidMemberBean() {
        super();
        setReadonly(true);
    }

    public void setReadonly(Boolean disable) {
        this.readonly = disable;
    }

    public Boolean getReadonly() {
        return readonly;
    }

    public void deptSecDegreeValueChangeListener(ValueChangeEvent valueChangeEvent) {
     if("soc1".equals(valueChangeEvent.getComponent().getId())) {
       getSectSelectOneChoice().resetValue();
       getMjrSelectOneChoice().resetValue();
     }else if("soc4".equals(valueChangeEvent.getComponent().getId())) {
       getMjrSelectOneChoice().resetValue();
     }
    }

    public void setSectSelectOneChoice(RichSelectOneChoice sectSelectOneChoice) {
        this.sectSelectOneChoice = sectSelectOneChoice;
    }

    public RichSelectOneChoice getSectSelectOneChoice() {
        return sectSelectOneChoice;
    }

    public void setMjrSelectOneChoice(RichSelectOneChoice mjrSelectOneChoice) {
        this.mjrSelectOneChoice = mjrSelectOneChoice;
    }

    public RichSelectOneChoice getMjrSelectOneChoice() {
        return mjrSelectOneChoice;
    }

    public void saveInitMemberActionListener(ActionEvent actionEvent) {
      AppModuleImpl app = (AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl");
      FResult fr= app.cid_member_save_membership_button();
      if(fr!=null) {
        if("error".equals(fr.getType())) {
          JSFUtils.addFacesErrorMessage(fr.getText());
        }else if("post_popup".equals(fr.getType())) {
        JSFUtils.showPopup("pt1:post_popup");
        }
        else{
          JSFUtils.addFacesInfoMessage("عضویت شخص با موفقیت در این کتابخانه ثبت شد.");
        }
      }
    }


    public String updateMemberAction() {
       AppModuleImpl app = (AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl");
       FResult fr=app.cid_member_pre_update();
       if(fr!=null) {
         if("error".equalsIgnoreCase(fr.getType())) {
           JSFUtils.addFacesErrorMessage(fr.getText());
           return null;
         }
       }
    
      TaskFlowBean tfBean = (TaskFlowBean)JSFUtils.getManagedBeanValue("pageFlowScope.TFBean");
      //#{pageFlowScope.TFBean.changePerson}
        return tfBean.changePerson();
    }


    public void post_popup_confirm_actionListener(ActionEvent actionEvent) {
      AppModuleImpl app = (AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl");
      FResult fr=app.cid_member_save_membership_after_post_popup();
      if(fr!=null) {
        if("error".equals(fr.getType())) {
          JSFUtils.addFacesErrorMessage(fr.getText());
          return;
        }else if("success".equals(fr.getType())){
          JSFUtils.addFacesInfoMessage(fr.getText());
          return;
        }
      }
    }

    public void post_popup_cancel_actionListener(ActionEvent actionEvent) {
      JSFUtils.closePopup("pt1:post_popup");
    }
}
