package org.parsisys.tehranuniversity.library.view.beans;

import java.util.List;

import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.data.RichTable;


import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.event.QueryEvent;

import oracle.binding.AttributeBinding;
import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.domain.Number;

import oracle.jbo.uicli.binding.JUCtrlHierNodeBinding;

import org.parsisys.tehranuniversity.library.model.am.AppModuleImpl;

import util.JSFUtils;

public class ExtraCharge {
    private RichTable chargeTable;
    private Number sumValue;
    private RichOutputText sumText;

    public ExtraCharge() {
    }

    public void setChargeTable(RichTable chargeTable) {
        this.chargeTable = chargeTable;
    }

    public RichTable getChargeTable() {
        return  chargeTable;
    }

    public void setSumValue(Number sumValue) {
        this.sumValue = sumValue;
    }

    public Number getSumValue() {
      
      
        return sumValue;
    }
    
//  public Integer calculateColumnSum(String columnName) {
//         Integer result = 0;
//      
//         RichTable rt = this.getChargeTable();
//         for (int i = 0; i < rt.getRowCount(); i++) {
//             JUCtrlHierNodeBinding rowData = (JUCtrlHierNodeBinding)rt.getRowData(i);
//             Row row = rowData.getRow();
//             result += (Integer)(row.getAttribute(columnName));
//         }
//         setSumValue(result);
//         return result;
//     }

    public void postSearch_call_callcalculateSum(QueryEvent queryOperationEvent) {
        invokeMethodExpression("#{bindings.searchbarcodeidQuery.processQuery}",Object.class, QueryEvent.class, queryOperationEvent);
//        AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
//
//        setSumValue( app.extraCharge_calculateSum());
    }
    
    
    public void postSearch_call_callcalculateSum_repprt(QueryEvent queryOperationEvent) {
        invokeMethodExpression("#{bindings.ExtraChargeDateVCQuery.processQuery}",Object.class, QueryEvent.class, queryOperationEvent);
//        AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
//
//        setSumValue( app.extraCharge_calculateSum());
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

    public String calculateSum_commit_action() {
      BindingContainer bindings = getBindings();
      OperationBinding operationBinding = bindings.getOperationBinding("Commit");
      Object result = operationBinding.execute();
//      
//      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
//      setSumValue( app.extraCharge_calculateSum());     
//      sumText.setValue(getSumValue());
      
        if (!operationBinding.getErrors().isEmpty()) {
            JSFUtils.addFacesErrorMessage("عملیات با خطا مواجه گردید.");
        }
        return null;
    }

    public void setSumText(RichOutputText sumText) {
        this.sumText = sumText;
    }

    public RichOutputText getSumText() {
        return sumText;
    }

    public String extraChargeBeforeCreate() {
      BindingContainer bindings = getBindings();
     
      AttributeBinding memArtId = (AttributeBinding)bindings.get("ArtId");
      if(memArtId.getInputValue()==null) {
        JSFUtils.addFacesErrorMessage("شخص عضو این کتابخانه نیست.");
        return "end";
      }
        return "go";
    }
}
