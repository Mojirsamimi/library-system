package org.parsisys.tehranuniversity.library.view.beans;

import oracle.adf.view.rich.event.QueryEvent;

import oracle.jbo.server.ViewObjectImpl;

import org.parsisys.tehranuniversity.library.model.am.AppModuleImpl;
import org.parsisys.tehranuniversity.library.model.vo.PersonVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.PersonVORowImpl;
import org.parsisys.tehranuniversity.library.util.FResult;

import util.JSFUtils;

public class CidMemberPenaltyHist {
    public CidMemberPenaltyHist() {
        super();
    }
    
  public void preSearchPerson(QueryEvent queryOperationEvent) {
     
   

        invokeMethodExpression("#{bindings.searchnameidbarcodeQuery.processQuery}",Object.class, QueryEvent.class, queryOperationEvent);
    AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
    PersonVOImpl personVO =(PersonVOImpl) app.getPersonVO1();
    PersonVORowImpl currPerson=(PersonVORowImpl)personVO.getCurrentRow();
    if(currPerson!=null && currPerson.getCurrLibInitMemArtId()==null)
        JSFUtils.addFacesErrorMessage("عضو در این کتابخانه یافت نشد.");
        
        
  }
  private Object invokeMethodExpression(String expr, Class returnType,

                                          Class argType, Object argument) {

        return JSFUtils.invokeMethodExpression(expr, returnType,

                                      new Class[] { argType },

                                      new Object[] { argument });

    }

}
