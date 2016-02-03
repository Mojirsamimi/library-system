package org.parsisys.tehranuniversity.library.view.beans;

import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.event.QueryEvent;

import org.parsisys.tehranuniversity.library.model.am.AppModuleImpl;
import org.parsisys.tehranuniversity.library.model.vo.VirtualBookVOImpl;
import org.parsisys.tehranuniversity.library.util.FResult;

import org.parsisys.tehranuniversity.library.util.ParsiUtil;

import util.JSFUtils;

public class CidMemBarcodeChange {
    private String persNewBarcode;
    private RichCommandButton save_btn;
    private boolean save_btn_disable=true;

    public CidMemBarcodeChange() {
        super();
    }
    
  public void search_person(QueryEvent queryOperationEvent){
    
    //////////////////////////////////////////////////////////////////////////
     invokeMethodExpression("#{bindings.searchnameidbarcodeQuery.processQuery}",

                                     Object.class, QueryEvent.class, queryOperationEvent);
    
    AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
   if(app.getPersonVO1().getCurrentRow()!=null)
   {
      setSave_btn_disable(false);
   }
  }
  private Object invokeMethodExpression(String expr, Class returnType,

                                            Class argType, Object argument) {

          return JSFUtils.invokeMethodExpression(expr, returnType,

                                        new Class[] { argType },

                                        new Object[] { argument });

      }

    public void setPersNewBarcode(String persNewBarcode) {
        this.persNewBarcode = persNewBarcode;
    }

    public String getPersNewBarcode() {
        return persNewBarcode;
    }

    public void showResultMessage(ActionEvent actionEvent) {
        if (ParsiUtil.clearString(getPersNewBarcode()) != null) {
            AppModuleImpl app =
                ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));

            FResult result = app.save_MemBarcodeChange(getPersNewBarcode());
            if (result != null) {
                if (result.getType().equalsIgnoreCase("error")) {
                    JSFUtils.addFacesErrorMessage(result.getText());
                }
            }
            setPersNewBarcode("");
        }else{
            JSFUtils.addFacesErrorMessage("لطفا بارکد جدید را وارد نمایید.");
            }
        JSFUtils.addFacesInfoMessage("بارکد جدید ثبت گردید.");
    }

    public void setSave_btn(RichCommandButton save_btn) {
        this.save_btn = save_btn;
    }

    public RichCommandButton getSave_btn() {
        return save_btn;
    }

    public void setSave_btn_disable(boolean save_btn_disable) {
        this.save_btn_disable = save_btn_disable;
    }

    public boolean isSave_btn_disable() {
        return save_btn_disable;
    }

    public String afterNext_fadak() {
        // Add event code here...
        return null;
    }

    public String afterperevious_fadak() {
        // Add event code here...
        return null;
    }
}
