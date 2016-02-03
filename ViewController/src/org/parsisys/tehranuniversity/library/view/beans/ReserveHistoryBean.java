package org.parsisys.tehranuniversity.library.view.beans;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;

import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.binding.BindingContainer;

import oracle.jbo.domain.Number;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.server.ViewRowImpl;
import oracle.jbo.uicli.binding.JUCtrlListBinding;

import org.parsisys.tehranuniversity.library.model.am.AppModuleImpl;

import org.parsisys.tehranuniversity.library.model.vo.ReserveVORowImpl;

import org.parsisys.tehranuniversity.library.util.FResult;

import util.JSFUtils;

public class ReserveHistoryBean {
    private RichSelectOneChoice activeSlctOneChoice;

    public ReserveHistoryBean() {
        super();
    }

    public void activeValueChangeListener(ValueChangeEvent valueChangeEvent) {

      valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
     
//      Map p = ((UIComponent)valueChangeEvent.getSource()).getAttributes();
//      System.out.println("Selected Value"+p.get("rowIndexVal"));
      
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));

            FResult fr= app.cid_book_reserve_history_active_selectionChanged();
            if(fr!=null) {
              if("error".equalsIgnoreCase(fr.getType())) {
                JSFUtils.addFacesErrorMessage(fr.getText());
                return;
              }else if("info".equals(fr.getType())) {
                JSFUtils.addFacesInfoMessage(fr.getText());
                return;
              }
            }
    }

    public void setActiveSlctOneChoice(RichSelectOneChoice activeSlctOneChoice) {
        this.activeSlctOneChoice = activeSlctOneChoice;
    }

    public RichSelectOneChoice getActiveSlctOneChoice() {
        return activeSlctOneChoice;
    }
}
