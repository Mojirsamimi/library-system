package org.parsisys.tehranuniversity.library.view.beans;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;

import oracle.adf.controller.v2.lifecycle.Lifecycle;

import oracle.adf.controller.v2.lifecycle.PagePhaseEvent;
import oracle.adf.controller.v2.lifecycle.PagePhaseListener;
import oracle.adf.model.RegionBinding;
import oracle.adf.model.RegionContext;
import oracle.adf.model.RegionController;

import org.parsisys.tehranuniversity.library.model.am.AppModuleImpl;
import org.parsisys.tehranuniversity.library.model.am.common.AppModule;

import util.JSFUtils;

public class PageListenerBean1 implements PagePhaseListener,RegionController{
public PageListenerBean1() {
}

public void afterPhase(PagePhaseEvent pagePhaseEvent) {
}

public void beforePhase(PagePhaseEvent pagePhaseEvent) {
if (pagePhaseEvent.getPhaseId() == Lifecycle.PREPARE_RENDER_ID) {
if (!isPostback()){
//System.out.println("This Will Execute AT Page Load");
AppModuleImpl am=(AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl");
am.virtubalBookFilter("Persian");

}
}

if (pagePhaseEvent.getPhaseId() == Lifecycle.METADATA_COMMIT_ID) {
if (!isPostback()){
  AppModuleImpl am=(AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl");
  am.virtubalBookFilter(null);

}
}

}
private boolean isPostback() {
return Boolean.TRUE.equals(resolveExpression("#{adfFacesContext.postback}"));
}
private Object resolveExpression(String expression) {
FacesContext facesContext = FacesContext.getCurrentInstance();
Application app = facesContext.getApplication();
ExpressionFactory elFactory = app.getExpressionFactory();
ELContext elContext = facesContext.getELContext();
ValueExpression valueExp =
elFactory.createValueExpression(elContext, expression,
Object.class);
return valueExp.getValue(elContext);
}

    public boolean refreshRegion(RegionContext regionContext) {
        regionContext.getRegionBinding().refresh();
        return false;
    }

    public boolean validateRegion(RegionContext regionContext) {
        RegionBinding binding = regionContext.getRegionBinding();
        binding.validate();
        return false;
    }

    public boolean isRegionViewable(RegionContext regionContext) {
        return true;
    }

    public String getName() {
        return null;
    }
}
