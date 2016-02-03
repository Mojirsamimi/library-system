package org.parsisys.tehranuniversity.library.view.beans;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.domain.Number;

import org.parsisys.tehranuniversity.library.model.am.AppModuleImpl;

import org.parsisys.tehranuniversity.library.util.FResult;

import util.JSFUtils;

public class LatinProvider {
 private String tab;
 
    public LatinProvider() {
        super();
    }

  public BindingContainer getBindings() {
      return BindingContext.getCurrent().getCurrentBindingsEntry();
  }
    public String latinMainSeeCreateInsert() {
      BindingContainer bindings = getBindings();
      OperationBinding operationBinding = bindings.getOperationBinding("CreateInsert");
      Object result = operationBinding.execute();
      if (!operationBinding.getErrors().isEmpty()) {
          JSFUtils.addFacesErrorMessage("ایجاد رکورد جدید با خطا مواجه شد.");
          return null;
      }
        AppModuleImpl app =
          ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
        app.ref_init_MainSeeProvider(new Number(2),new Number(2));
      
     
        return null;
    }

    public String latinMainSeeAlsoCreateInsert() {
      BindingContainer bindings = getBindings();
      OperationBinding operationBinding = bindings.getOperationBinding("CreateInsert1");
      Object result = operationBinding.execute();
      if (!operationBinding.getErrors().isEmpty()) {
          JSFUtils.addFacesErrorMessage("ایجاد رکورد جدید با خطا مواجه شد.");
          return null;
      }
        AppModuleImpl app =
          ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
        app.ref_init_MainSeeProvider(new Number(2),new Number(1));
      
      
        return null;
    }
  public String selectProvider() {
    AppModuleImpl app =
      ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
    FResult fr=app.provider_insert_detail(getTab());
    if(fr!=null) {
      if("error".equals(fr.getType())) {
        JSFUtils.addFacesErrorMessage(fr.getText());
        return null;
      }else  if("info".equals(fr.getType())) {
          JSFUtils.addFacesInfoMessage(fr.getText());
      }
    }
      return "end";
  }
  public void removeDetailActionListener(ActionEvent actionEvent) {
    AppModuleImpl app =
      ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
    FResult fr=app.provider_remove_detail(getTab());
    if(fr!=null) {
      if("error".equals(fr.getType())) {
        JSFUtils.addFacesErrorMessage(fr.getText());
        
      }else  if("info".equals(fr.getType())) {
          JSFUtils.addFacesInfoMessage(fr.getText());
      }
    }
  }
  public void applyReadingOrderVCActionListener(ActionEvent actionEvent) {
    AppModuleImpl app =
      ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
    app.ref_provider_apply_readingOrderVC(new Number(2));
  }
  public String providerAfterCreate() {
    AppModuleImpl app =
      ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
    app.ref_provider_afterCreate(new Number(2));
      return null;
  }

    public void setTab(String tab) {
        this.tab = tab;
    }

    public String getTab() {
        return tab;
    }
}
