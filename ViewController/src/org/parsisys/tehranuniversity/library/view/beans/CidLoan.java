package org.parsisys.tehranuniversity.library.view.beans;



import java.util.ArrayList;


import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import javax.faces.model.SelectItem;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;

import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.PopupCanceledEvent;

import oracle.adf.view.rich.event.QueryEvent;

import oracle.binding.BindingContainer;

import oracle.jbo.domain.Number;

import oracle.jbo.server.ViewRowImpl;
import oracle.jbo.uicli.binding.JUCtrlListBinding;

import org.parsisys.tehranuniversity.library.model.am.AppModuleImpl;

import org.parsisys.tehranuniversity.library.util.ReportItems;
import org.parsisys.tehranuniversity.library.util.FResult;

import util.JSFUtils;

public class CidLoan {
    private RichSelectBooleanCheckbox chkBoxExtentYesNo;
    private RichOutputText text_ConfirmSave;
    private RichSelectBooleanCheckbox chkBoxLoanYesNo;
    private Boolean disableLoan=true;
    private Boolean disablePrint=true;
    private String tempTxt;
    private Boolean disableCheckPenalty=true;
    private String reportPath;
    private int printCount=1;
    private Boolean errFlag=true;
    private ArrayList<SelectItem> reportSelectItms;
    private String libName;

    public CidLoan() {
        super();
     reportSelectItms=new ArrayList<SelectItem>();

      
    }
    public String getClearCaches() {
      System.out.println("Clear Caches............");
      DCBindingContainer dcbindings =
          (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding PersIterPinding = dcbindings.findIteratorBinding("PersonVO1Iterator");
      PersIterPinding.setCurrentRowIndexInRange(-1);
        return null;
    }
  public void searchPerson(QueryEvent queryOperationEvent){
    invokeMethodExpression("#{bindings.searchbarcodeidQuery.processQuery}",
                                     Object.class, QueryEvent.class, queryOperationEvent);
    
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
    FResult fr= app.cid_loan_init_person();
    if(fr!=null) {
      if("error".equals(fr.getType())) {
        JSFUtils.addFacesErrorMessage(fr.getText());
        setDisableLoan(true);
        setDisablePrint(true);
        return;
      }else if ("popup".equals(fr.getType())) {
          //getText_ConfirmSave().setValue(fr.getText());
          setTempTxt(fr.getText());
       JSFUtils.showPopup("pt1:popup_mem_pass_course");
         return; 
      }
    }
    setDisableLoan(false);
  }
  public void portal_loan_init_person() {
    AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
    FResult fr= app.cid_loan_init_person();
    if(fr!=null) {
    if("error".equals(fr.getType())) {
      JSFUtils.addFacesErrorMessage(fr.getText());
      setDisableLoan(true);
      setDisablePrint(true);      
      return;
    }
    }
    setDisableLoan(false);
  }
  private Object invokeMethodExpression(String expr, Class returnType,

                                            Class argType, Object argument) {

          return JSFUtils.invokeMethodExpression(expr, returnType,

                                        new Class[] { argType },

                                        new Object[] { argument });

      }

    public void extentYesNoValueChangeListener(ValueChangeEvent valueChangeEvent) {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      //System.out.println("listener: new value is: "+valueChangeEvent.getNewValue());
      FResult fr= app.cid_loan_extent_yesno_change((Boolean)valueChangeEvent.getNewValue());
      if(fr!=null) {
        if("error".equals(fr.getType())) {
            getChkBoxExtentYesNo().setValue(false);
          AdfFacesContext.getCurrentInstance().addPartialTarget(getChkBoxExtentYesNo());
          JSFUtils.addFacesErrorMessage(fr.getText());
        }else if("penalty form".equals(fr.getType())) {
           // System.out.println("penal");
        JSFUtils.showPopup("pt1:penaltyp");
        }
      }
    }

    public void setChkBoxExtentYesNo(RichSelectBooleanCheckbox chkBoxExtentYesNo) {
        this.chkBoxExtentYesNo = chkBoxExtentYesNo;
    }

    public RichSelectBooleanCheckbox getChkBoxExtentYesNo() {
        return chkBoxExtentYesNo;
    }

    public void penaltyCancelActionListener(ActionEvent actionEvent) {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      app.cid_loan_extent_penalty_afterPopup_no();
    }

    public void setText_ConfirmSave(RichOutputText text_ConfirmSave) {
        this.text_ConfirmSave = text_ConfirmSave;
    }

    public RichOutputText getText_ConfirmSave() {
        return text_ConfirmSave;
    }

    public void penaltySaveActionListener(ActionEvent actionEvent) {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
     FResult fr= app.cid_loan_extent_penalty_save();
     if(fr!=null) {
       if("error".equals(fr.getType())) {
         JSFUtils.addFacesErrorMessage(fr.getText());
         return;
       }else  if("yn_popup".equals(fr.getType())) {
         //getText_ConfirmSave().setValue(fr.getText());
         setTempTxt(fr.getText());
         JSFUtils.showPopup("pt1:p_confirm_save");
       }
     }
    }
    
  public void portalPenaltySaveActionListener(ActionEvent actionEvent) {
    AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
    FResult fr= app.cid_loan_portal_extent_penalty_save();
    if(fr!=null) {
     if("error".equals(fr.getType())) {
       JSFUtils.addFacesErrorMessage(fr.getText());
       return;
     }else  if("yn_popup".equals(fr.getType())) {
       //getText_ConfirmSave().setValue(fr.getText());
       setTempTxt(fr.getText());
       JSFUtils.showPopup("pt1:p_confirm_save");
     }
    }
  }

    public void chooseBookActionListener(ActionEvent actionEvent) {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      FResult fr1= app.cid_loan_initBook();
      if(fr1!=null) {
        if("error".equals(fr1.getType())) {
          JSFUtils.addFacesErrorMessage(fr1.getText());
          return;
        }else if ("yn_popup".equals(fr1.getType())) {
         // getText_ConfirmSave().setValue(fr1.getText());
         setTempTxt(fr1.getText());
          JSFUtils.showPopup("pt1:popup_study_at_lib");
        }
      }
      JSFUtils.closePopup("pt1:searchphbook");
    }

    public void studyAtLibNoActionListener(ActionEvent actionEvent) {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      app.cid_loan_initBook_popUpNobtn();
    }

    public void studyAtLibYesActionListener(ActionEvent actionEvent) {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      FResult fr= app.cid_loan_initBook_popUpYesbtn(true);
      if(fr!=null) {
        if("error".equals(fr.getText())) {
          JSFUtils.addFacesErrorMessage(fr.getText());
          return;
        }
      }
      JSFUtils.closePopup("pt1:searchphbook");
    }

    public void loanTypeValueChangeListener(ValueChangeEvent valueChangeEvent) {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
       
           // Number loanType=(((Integer)valueChangeEvent.getNewValue())==1?new Number(1))
           BindingContainer bindings =BindingContext.getCurrent().getCurrentBindingsEntry();
           JUCtrlListBinding listBinding =
               (JUCtrlListBinding)bindings.get("LoanType");
            app.cid_loan_loanList_loanTypeChanged(((Number)((ViewRowImpl)listBinding.getValueFromList((Integer)valueChangeEvent.getNewValue())).getAttribute("Value")));
       
    }

    public void loanListYesNoChangeValueListener(ValueChangeEvent valueChangeEvent) {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      FResult fr= app.cid_loan_loanList_yesno_change((Boolean)valueChangeEvent.getNewValue());
      if(fr!=null) {
        if("error".equals(fr.getType())) {
          getChkBoxLoanYesNo().setValue(false);
          AdfFacesContext.getCurrentInstance().addPartialTarget(getChkBoxLoanYesNo());
          JSFUtils.addFacesErrorMessage(fr.getText());
        }
      }
    }

    public void setChkBoxLoanYesNo(RichSelectBooleanCheckbox chkBoxLoanYesNo) {
        this.chkBoxLoanYesNo = chkBoxLoanYesNo;
    }

    public RichSelectBooleanCheckbox getChkBoxLoanYesNo() {
        return chkBoxLoanYesNo;
    }

    public void saveLoanActionListener(ActionEvent actionEvent) {
      
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      FResult fr= app.cid_loan_saveFunc();
      setErrFlag(true);
      if(fr!=null) {
        if("error".equals(fr.getType())) {
          JSFUtils.addFacesErrorMessage(fr.getText());
          setErrFlag(false);
        }else if("return".equals(fr.getType())) {
            ArrayList<ReportItems> printList=(ArrayList<ReportItems>)fr.getResult();
            reportSelectItms.clear();
            setReportPath("");
              setDisablePrint(false);

            for(ReportItems item:printList){
                System.out.println("Art Id=  "+item.getArtId());
             reportSelectItms.add(new SelectItem(item.getArtId(),item.getBarcode()));
             
            }
            }
      }
      setDisablePrint(false);

    }
  public void reportListBoxValueChangeListener(ValueChangeEvent valueChangeEvent) {
    System.out.println(valueChangeEvent.getNewValue());
    String str="";
    UserStatus a = (UserStatus)JSFUtils.getManagedBeanValue("sessionUser");
    if(getPrintCount()==1){
         str="/reports/rwservlet?utdbuser&destype=cache&report=LOAN_PRINT1.rdf&P_ART_ID="+ valueChangeEvent.getNewValue()+"&labcol="+a.getLabcol();
    }
    else if(getPrintCount()==2)
    {
          str="/reports/rwservlet?utdbuser&destype=cache&report=LOAN_PRINT2.rdf&P_ART_ID="+ valueChangeEvent.getNewValue()+"&labcol="+a.getLabcol();
    }
    setReportPath(str);
      
  }
    public void setDisableLoan(Boolean disableLoan) {
        this.disableLoan = disableLoan;
    }

    public Boolean getDisableLoan() {
        return disableLoan;
    }

    public void memPassCourseYesActionListener(ActionEvent actionEvent) {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      FResult fr= app.cid_loan_init_person_after_popup();
      if(fr!=null) {
        if("error".equals(fr.getType())) {
          JSFUtils.addFacesErrorMessage(fr.getText());
          setDisableLoan(true);
          setDisablePrint(true);
          return;
        }
      }
      setDisableLoan(false);
    }

    public void memPassCourseNoActionListener(ActionEvent actionEvent) {
        // Add event code here...
    }

    public void setTempTxt(String tempTxt) {
        this.tempTxt = tempTxt;
    }

    public String getTempTxt() {
        return tempTxt;
    }

    public void checkLoanActionListener(ActionEvent actionEvent) {
      portal_loan_init_person();
    }


    public void portalPenaltyPopupCancelListener(PopupCanceledEvent popupCanceledEvent) {
     // System.out.println("popup cancel");
     AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
     app.cid_loan_extent_penalty_afterPopup_no();
      getChkBoxExtentYesNo().setValue(false);
      AdfFacesContext.getCurrentInstance().addPartialTarget(getChkBoxExtentYesNo());
    }

   

    public void setDisableCheckPenalty(Boolean disableCheckPenalty) {
        this.disableCheckPenalty = disableCheckPenalty;
    }

    public Boolean getDisableCheckPenalty() {
        return disableCheckPenalty;
    }

    public void setReportPath(String reportPath) {
        System.out.println(reportPath);
        this.reportPath = reportPath;
    }

    public String getReportPath() {
        return reportPath;
    }
    
  public String view_popUp_btn() {
      if(getErrFlag()){
    JSFUtils.showPopup("pt1:reportPop");
      }
      return null;
  }

    

    public void setPrintCount(int printCount) {
        this.printCount = printCount;
    }

    public int getPrintCount() {
        return printCount;
    }

    public void setErrFlag(Boolean errFlag) {
        this.errFlag = errFlag;
    }

    public Boolean getErrFlag() {
        return errFlag;
    }

    public void setReportSelectItms(ArrayList<SelectItem> reportSelectItms) {
        this.reportSelectItms = reportSelectItms;
    }

    public ArrayList<SelectItem> getReportSelectItms() {
        return reportSelectItms;
    }


    public void reportCountValueChangeListener(ValueChangeEvent valueChangeEvent) {
       
        setReportPath(getReportPath().replaceFirst("LOAN_PRINT"+valueChangeEvent.getOldValue(), "LOAN_PRINT"+valueChangeEvent.getNewValue()));
    }

    public void setLibName(String libName) {
        this.libName = libName;
    }

    public String getLibName() {
      UserStatus a = (UserStatus)JSFUtils.getManagedBeanValue("sessionUser");
      libName=a.getLibname();
        return libName;
    }

    public void setDisablePrint(Boolean disablePrint) {
        this.disablePrint = disablePrint;
    }

    public Boolean getDisablePrint() {
        return disablePrint;
    }
}
