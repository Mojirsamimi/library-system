package org.parsisys.tehranuniversity.library.view.beans;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import org.parsisys.tehranuniversity.library.model.am.AppModuleImpl;
import org.parsisys.tehranuniversity.library.util.FResult;

import util.JSFUtils;

public class BookReserveHistory {
    public BookReserveHistory() {
        super();
    }
  private RichSelectOneChoice activeSlctOneChoice;

  public void active_selectionChanged(ValueChangeEvent valueChangeEvent) {
    
    valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
    
    //      Map p = ((UIComponent)valueChangeEvent.getSource()).getAttributes();
    //      System.out.println("Selected Value"+p.get("rowIndexVal"));
    
    AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));

          FResult fr= app.cid_book_reserve_history_active_selectionChanged();
          if(fr!=null) {
            if("error".equalsIgnoreCase(fr.getType())) {
              JSFUtils.addFacesErrorMessage(fr.getText());
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
