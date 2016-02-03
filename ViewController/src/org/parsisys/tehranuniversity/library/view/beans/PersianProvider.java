package org.parsisys.tehranuniversity.library.view.beans;

import com.sun.el.ValueExpressionImpl;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.data.RichColumn;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.QueryEvent;

import oracle.binding.BindingContainer;

import oracle.binding.OperationBinding;

import oracle.jbo.domain.Number;

import oracle.jbo.server.ViewObjectImpl;

import org.parsisys.tehranuniversity.library.model.am.AppModuleImpl;
import org.parsisys.tehranuniversity.library.util.FResult;

import util.JSFUtils;

public class PersianProvider {
    
 private String tab;

    public PersianProvider() {
        super();
    }
    
    
  private Object invokeMethodExpression(String expr, Class returnType,

                                            Class argType, Object argument) {

          return JSFUtils.invokeMethodExpression(expr, returnType,

                                        new Class[] { argType },

                                        new Object[] { argument });

      }

   public void searchListener(QueryEvent queryEvent) {
     providerSetAccessMdToRangePg();
     
      invokeMethodExpression("#{bindings.RefSelectProviderVOQuery.processQuery}",
                             Object.class, QueryEvent.class,
                             queryEvent);

 
      
    }
   
  public BindingContainer getBindings() {
      return BindingContext.getCurrent().getCurrentBindingsEntry();
  }
    public String mainSeeProviderCreateInsert() {
      BindingContainer bindings = getBindings();
      OperationBinding operationBinding = bindings.getOperationBinding("CreateInsert");
      Object result = operationBinding.execute();
      if (!operationBinding.getErrors().isEmpty()) {
          JSFUtils.addFacesErrorMessage("ایجاد رکورد جدید با خطا مواجه شد.");
          return null;
      }
        AppModuleImpl app =
          ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
        app.ref_init_MainSeeProvider(new Number(1),new Number(2));
        return null;
    }

    public String mainSeeAlsoProviderCreateInsert() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("CreateInsert1");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            JSFUtils.addFacesErrorMessage("ایجاد رکورد جدید با خطا مواجه شد.");
            return null;
        }
          AppModuleImpl app =
            ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
          app.ref_init_MainSeeProvider(new Number(1),new Number(1));
        
        return null;
    }

    public void setTab(String tab) {
        this.tab = tab;
    }

    public String getTab() {
        return tab;
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

    public void applyReadingOrderVCActionListener(ActionEvent actionEvent) {
      AppModuleImpl app =
        ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      app.ref_provider_apply_readingOrderVC(new Number(1));
    }

    public String providerAfterCreate() {
      AppModuleImpl app =
        ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      app.ref_provider_afterCreate(new Number(1));
    
     
        return null;
    }

    public String providerBeforeCreate() {
         AppModuleImpl app =
        ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      app.ref_provider_setAccessMode(ViewObjectImpl.SCROLLABLE);
      app.getRefSelectProviderVO().executeEmptyRowSet();
    
        return "go";
    }

    public String providerSetAccessMdToRangePg() {
      AppModuleImpl app =
      ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      app.ref_provider_setAccessMode(ViewObjectImpl.RANGE_PAGING);
        return null;
    }

    
}
