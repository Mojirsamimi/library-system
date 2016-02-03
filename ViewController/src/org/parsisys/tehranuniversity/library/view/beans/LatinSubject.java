package org.parsisys.tehranuniversity.library.view.beans;

import java.util.List;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;

import oracle.binding.AttributeBinding;
import oracle.binding.BindingContainer;
import oracle.binding.ControlBinding;
import oracle.binding.OperationBinding;

import oracle.jbo.domain.DBSequence;
import oracle.jbo.domain.Number;

import org.parsisys.tehranuniversity.library.model.am.AppModuleImpl;

import org.parsisys.tehranuniversity.library.util.FResult;

import util.JSFUtils;

public class LatinSubject {

  private String mainSubject;
  private String alsoMainSubject;
  private String alsoSubSubject;
  private String subSubject;
  private String path;
  private String tab;

    public LatinSubject() {
        super();
    }
   

    public void setMainSubject(String mainSubject) {
        this.mainSubject = mainSubject;
    }

    public String getMainSubject() {
        return mainSubject;
    }

    public void setAlsoMainSubject(String alsoMainSubject) {
        this.alsoMainSubject = alsoMainSubject;
    }

    public String getAlsoMainSubject() {
        return alsoMainSubject;
    }

    public void setAlsoSubSubject(String alsoSubSubject) {
        this.alsoSubSubject = alsoSubSubject;
    }

    public String getAlsoSubSubject() {
        return alsoSubSubject;
    }

    public void setSubSubject(String subSubject) {
        this.subSubject = subSubject;
    }

    public String getSubSubject() {
        return subSubject;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
  public BindingContainer getBindings() {
      return BindingContext.getCurrent().getCurrentBindingsEntry();
  }
  public String createInsertLatinMainSeeSub() {
      BindingContainer bindings = getBindings();
      OperationBinding operationBinding = bindings.getOperationBinding("CreateInsert");
      Object result = operationBinding.execute();
      if (!operationBinding.getErrors().isEmpty()) {
          JSFUtils.addFacesErrorMessage("ایجاد رکورد جدید با خطا مواجه شد.");
          return null;
      }
    AppModuleImpl app =
        ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));

  app.ref_init_MainSeeSubject(new Number(2), new Number(2));
      return null;
  }
  public String createInsertLatinMainSeeAlsoSub() {
      BindingContainer bindings = getBindings();
      OperationBinding operationBinding = bindings.getOperationBinding("CreateInsert1");
      Object result = operationBinding.execute();
      if (!operationBinding.getErrors().isEmpty()) {
          JSFUtils.addFacesErrorMessage("ایجاد رکورد جدید با خطا مواجه شد.");
          return null;
      }
    AppModuleImpl app =
        ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));

  app.ref_init_MainSeeSubject(new Number(2), new Number(1));
      return null;
  }
  public void applyReadingOrderVCActionListener(ActionEvent actionEvent) {
    AppModuleImpl app =
        ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
  app.ref_subject_apply_readingOrderVC(new Number(2));
  }

    public void setTab(String tab) {
        this.tab = tab;
    }

    public String getTab() {
        return tab;
    }
    public String selectSubjectAction() {
      AppModuleImpl app =
          ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      FResult fr= app.subject_insert_detail(getTab());
      if(fr!=null) {
        if("error".equals(fr.getType())) {
          JSFUtils.addFacesErrorMessage(fr.getText());
          return null;
        }
      }
      return "end";
    }

    public void removeFromDetail(ActionEvent actionEvent) {
      AppModuleImpl app =
          ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      FResult fr= app.subject_remove_detail(getTab());
      if(fr!=null) {
       if("error".equals(fr.getType())) {
         JSFUtils.addFacesErrorMessage(fr.getText());
       }else if ("info".equals(fr.getType())) {
         JSFUtils.addFacesInfoMessage(fr.getText());
       }
      }
    }

    public String subjectAfterCreate() {
      AppModuleImpl app =
          ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      app.ref_subject_afterCreate(new Number(2));
        return null;
    }
}
