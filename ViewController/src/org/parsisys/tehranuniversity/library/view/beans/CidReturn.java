package org.parsisys.tehranuniversity.library.view.beans;

import java.sql.SQLException;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.QueryEvent;

import oracle.binding.BindingContainer;

import oracle.binding.OperationBinding;

import oracle.jbo.domain.Number;

import org.parsisys.tehranuniversity.library.model.am.AppModuleImpl;
import org.parsisys.tehranuniversity.library.util.FResult;

import util.JSFUtils;

public class CidReturn {
  private Number penaltyValue;
  private String penaltyDescription;
  private String popupText;
  private boolean disablePenalty=true;
  private boolean disableRank=true;
  private Number rank;
  private Integer reserveArtId;
  private String reportPath=null;
  private boolean showPopUp=false;
   
    public CidReturn() {
        super();
    }

    public void afetrSearchBarcode(QueryEvent queryOperationEvent) { BindingContainer bindings = getBindings();

        invokeMethodExpression("#{bindings.SearchBarcodeVCQuery.processQuery}",Object.class, QueryEvent.class, queryOperationEvent);
          

  
                AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
            FResult result = app.cid_return_afterSearchBarcode();
      
        if (result != null) {
            if (result.getType().equalsIgnoreCase("error")) {
                JSFUtils.addFacesErrorMessage(result.getText());
            }else if("return".equals(result.getType())) {
              setDisablePenalty(!(Boolean)result.getResult());
            }
        }
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

    public void returnbtn_clicked(ActionEvent actionEvent) {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
      
        FResult result = app.cid_return_preReturn(getPenaltyValue());
      if (result != null) {
          if (result.getType().equalsIgnoreCase("yn_popup")) {
              setPopupText(result.getText());
              JSFUtils.showPopup("pt1:p1");
          }
      }
    }

  
    public void setPopupText(String popupText) {
        this.popupText = popupText;
    }

    public String getPopupText() {
        return popupText;
    }

    public void return_popupbtn(ActionEvent actionEvent) {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
      FResult result = app.cid_return_return_btn(getPenaltyDescription(), getPenaltyValue());
       
       setPenaltyValue(null);
     
    setPenaltyDescription(null);
    
      if (result != null) {
      if (result.getType().equalsIgnoreCase("error")) {
      JSFUtils.addFacesErrorMessage(result.getText());
      }else if(result.getType().equalsIgnoreCase("info")) {
        JSFUtils.addFacesInfoMessage(result.getText());
        
       
        setDisableRank(false);
      }      else if(result.getType().equalsIgnoreCase("return")) {
        UserStatus a = (UserStatus)JSFUtils.getManagedBeanValue("sessionUser");
        
             setReportPath("/reports/rwservlet?utdbuser&destype=cache&report=Reserve_call.rdf&P_RESERVE_ART_ID="+ (Integer)result.getResult()+"&labcol="+a.getLabcol());
        JSFUtils.showPopup("pt1:reportPop");
        
      //  JSFUtils.addFacesInfoMessage(result.getText());
      
      }
    }
      
    }

    public void cancelbtn_clearForm(ActionEvent actionEvent) {
     setPenaltyDescription(null);
     setPenaltyValue(null);
    
     

    }

   

    public String fadak_toolbar_afterNext() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
      FResult result =(FResult) app.cid_return_afterSearchBarcode();
      
      if (result != null) {
      if (result.getType().equalsIgnoreCase("error")) {
      JSFUtils.addFacesErrorMessage(result.getText());
      }
      }
        return null;
    }

    public String fadak_toolbar_afterPrevious() {
       AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
              FResult result =(FResult) app.cid_return_afterSearchBarcode();
              
              if (result != null) {
              if (result.getType().equalsIgnoreCase("error")) {
              JSFUtils.addFacesErrorMessage(result.getText());
              }
              }
        return null;
    }


    public void setPenaltyValue(Number pnaltyValue) {
        this.penaltyValue = pnaltyValue;
    }

    public Number getPenaltyValue() {
        return penaltyValue;
    }

    public void setPenaltyDescription(String penaltyDescription) {
        this.penaltyDescription = penaltyDescription;
    }

    public String getPenaltyDescription() {
        return penaltyDescription;
    }

    public void setDisablePenalty(boolean disablePenalty) {
        this.disablePenalty = disablePenalty;
    }

    public boolean isDisablePenalty() {
        return disablePenalty;
    }

    public void setRank(Number rank) {
        this.rank = rank;
    }

    public Number getRank() {
        return rank;
    }

    public String insert_vbook_rank() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
       app.vbook_ranak_insert(getRank());
      
        return null;
    }

    public void setDisableRank(boolean disableRank) {
        this.disableRank = disableRank;
    }

    public boolean isDisableRank() {
        return disableRank;
    }

    public void setReserveArtId(Integer reserveArtId) {
        this.reserveArtId = reserveArtId;
    }

    public Integer getReserveArtId() {
        return reserveArtId;
    }

    

    public void setReportPath(String reportPath) {
        this.reportPath = reportPath;
    }

    public String getReportPath() {
        return reportPath;
    }

    public void setShowPopUp(boolean showPopUp) {
        this.showPopUp = showPopUp;
    }

    public boolean isShowPopUp() {
        return showPopUp;
    }
}
