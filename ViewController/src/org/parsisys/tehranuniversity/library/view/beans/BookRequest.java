package org.parsisys.tehranuniversity.library.view.beans;

import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.servlet.ADFBindingFilter;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanRadio;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.QueryEvent;

import org.parsisys.tehranuniversity.library.model.am.AppModuleImpl;
import org.parsisys.tehranuniversity.library.util.FResult;

import util.JSFUtils;

public class BookRequest {
    private RichSelectBooleanRadio phBook_selection_changed;
    private Boolean loanAtPlace=false;

    public BookRequest() {
        super();
    }
    
    public void afterSearch_call_initperson_barcode(QueryEvent queryOperationEvent) {
        AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
          FResult result=app.bookRequest_preSearch_barcode();
  
       if(result!=null)
       {
       if("error".equals(result.getType())) {
         JSFUtils.addFacesErrorMessage(result.getText());
         return;
       }
       }     
  
  invokeMethodExpression("#{bindings.CertificateNoBarcodeVCQuery.processQuery}",Object.class, QueryEvent.class, queryOperationEvent);

      
      
        
         result=app.bookRequest_initPerson_barcode();
          if(result!=null)
          {
          if("error".equals(result.getType())) {
            JSFUtils.addFacesErrorMessage(result.getText());
            return;
          }
          }     
    }

        public void afterSearch_call_initperson_newCard(QueryEvent queryOperationEvent) {
        AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      FResult result= app.bookRequest_preSearch_newCard();
      
       if(result!=null)
       {
       if("error".equals(result.getType())) {
         JSFUtils.addFacesErrorMessage(result.getText());
         return;
       }
       }     
  invokeMethodExpression("#{bindings.CertificateNoIDVCQuery.processQuery}",Object.class, QueryEvent.class, queryOperationEvent);

      result=app.bookRequest_initPerson_barcode();
        
          if(result!=null)
          {
          if("error".equals(result.getType())) {
            JSFUtils.addFacesErrorMessage(result.getText());
            return;
          }
          }     
    }
    
  private Object invokeMethodExpression(String expr, Class returnType,

                                            Class argType, Object argument) {

          return JSFUtils.invokeMethodExpression(expr, returnType,

                                        new Class[] { argType },

                                        new Object[] { argument });

      }

    public void setPhBook_selection_changed(RichSelectBooleanRadio phBook_selection_changed) {
        this.phBook_selection_changed = phBook_selection_changed;
    }

    public RichSelectBooleanRadio getPhBook_selection_changed() {
        
      return phBook_selection_changed;
    
    }

    public void call_print_vbook(ActionEvent actionEvent) {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
        FResult result=app.bookRequest_print_vbook();
      
      if(result!=null)
      {
      if("error".equals(result.getType())) {
       JSFUtils.addFacesErrorMessage(result.getText());
       return;
            }else if("popup".equals(result.getType())) {
        JSFUtils.showPopup("pt1:p1");
      }
      }
     
      
    }

    public void popUpConfirm_btn_insertBookRequest(ActionEvent actionEvent) {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
        FResult result=app.bookRequest_insert_bookRequest(getLoanAtPlace());
      
      if(result!=null)
      {
      if("error".equals(result.getType())) {
       JSFUtils.addFacesErrorMessage(result.getText());
       return;
            }else if("info".equals(result.getType())) {
        JSFUtils.addFacesInfoMessage(result.getText());
      }
      }
    }

    public void phBookSelection_changed(ValueChangeEvent valueChangeEvent) {
     if((Boolean)valueChangeEvent.getNewValue()==true)
     {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
        FResult result=app.bookRequest_phBookSelection();
      
      if(result!=null)
      {
      if("error".equals(result.getType())) {
       JSFUtils.addFacesErrorMessage(result.getText());
       getPhBook_selection_changed().setValue(false);
       AdfFacesContext.getCurrentInstance().addPartialTarget(getPhBook_selection_changed());
            }
      }
     }
      
    }

    public void setLoanAtPlace(Boolean loanAtPlace) {
        this.loanAtPlace = loanAtPlace;
    }

    public Boolean getLoanAtPlace() {
        return loanAtPlace;
    }
}
