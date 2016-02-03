package org.parsisys.tehranuniversity.library.view.beans;

import java.io.IOException;
import java.io.OutputStream;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.domain.Number;

import oracle.jbo.domain.Timestamp;

import org.parsisys.tehranuniversity.library.model.am.AppModuleImpl;
import org.parsisys.tehranuniversity.library.model.vo.report.VirtualBookListVOImpl;
import org.parsisys.tehranuniversity.library.util.FResult;

import util.JSFUtils;

public class ReportFarsiCard {
    private Number fromCode=new Number(0);
  private Number toCode=new Number(0);
  private Number fromRow;
  private Number toRow;
  private String reportPath;
  private Boolean mCheck;
  private Boolean uCheck;
  private Boolean sCheck;
  private Boolean pCheck;
  private Boolean nCheck;
  private Boolean fCheck;
  private Boolean utCheck;
private String timeStamp;
private String voName;

private Number currentReadingOrder;
private Boolean code;
  private Boolean row;
    public ReportFarsiCard() {
        super();
    
      code=true;
      row=false;
    }

    public void setFromCode(Number fromCode) {
        this.fromCode = fromCode;
    }

    public Number getFromCode() {
        return fromCode;
    }

    public void setToCode(Number toCode) {
        this.toCode = toCode;
    }

    public Number getToCode() {
        return toCode;
    }

    public void setFromRow(Number fromRow) {
        this.fromRow = fromRow;
    }

    public Number getFromRow() {
        return fromRow;
    }

    public void setToRow(Number toRow) {
        this.toRow = toRow;
    }

    public Number getToRow() {
        return toRow;
    }

    public void setReportPath(String reportPath) {
        this.reportPath = reportPath;
    }

    public String getReportPath() {
        return reportPath;
    }

    public String showPrintPopUp() {
        JSFUtils.showPopup("pt1:reportPop");
        return null;
    }

    

    public void SetPrintParameters(ActionEvent actionEvent) {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      
      FResult result=app.bookFarsiCard_printAllCard(new Number(1), new Number(2), new Number(1), new Number(1));
      if(result!=null){
          if(result.getType().equalsIgnoreCase("error")){
            JSFUtils.addFacesErrorMessage(result.getText());
            }
          else if(result.getType().equalsIgnoreCase("return"))
              
              setReportPath(result.getText());
          }
    }

    public void setVoName(String voName) {
        this.voName = voName;
    }

    public String getVoName() {
        return voName;
    }

    public String selBookScope() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      
      FResult result=app.bookFarsiCard_sel_book_scope(getVoName(), getFromCode(), getToCode(), getFromRow(), getToRow());
      
        return null;
    }

    public void setMCheck(Boolean mCheck) {
        this.mCheck = mCheck;
    }

    public Boolean getMCheck() {
        return mCheck;
    }

    public void setUCheck(Boolean uCheck) {
        this.uCheck = uCheck;
    }

    public Boolean getUCheck() {
        return uCheck;
    }

    public void setSCheck(Boolean sCheck) {
        this.sCheck = sCheck;
    }

    public Boolean getSCheck() {
        return sCheck;
    }

    public void setPCheck(Boolean pCheck) {
        this.pCheck = pCheck;
    }

    public Boolean getPCheck() {
        return pCheck;
    }

    public void setNCheck(Boolean nCheck) {
        this.nCheck = nCheck;
    }

    public Boolean getNCheck() {
        return nCheck;
    }

    public void setFCheck(Boolean fCheck) {
        this.fCheck = fCheck;
    }

    public Boolean getFCheck() {
        return fCheck;
    }

    public void setUtCheck(Boolean utCheck) {
        this.utCheck = utCheck;
    }

    public Boolean getUtCheck() {
        return utCheck;
    }

    public String setReportParameters() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      
      app.bookFarsiCard_setPrintSettingsParameters(getMCheck(),getUCheck(),getSCheck(),getPCheck(),getNCheck(),getFCheck(),getUtCheck());      
        return null;
    }

    public String show_mainCardPopUp() {
       JSFUtils.showPopup("pt1:pMainCard");
        return null;
    }

 
  public Object executeMethodWithResult(String methodActionId) {
  BindingContainer bindings = BindingContext.getCurrent().getCurrentBindingsEntry();
  OperationBinding operationBinding = bindings.getOperationBinding(methodActionId);
  Object result = operationBinding.execute();

  if (!operationBinding.getErrors().isEmpty()) {
  throw new RuntimeException("Error while executing.. "+operationBinding.getErrors());
  }
  return result;
  }
    
  public void handleDownloadMadarOne(FacesContext facesContext, OutputStream outputStream) {
  try {
  Object result = executeMethodWithResult("bookFarsiCard_madar_printOne");
  outputStream.write((byte[])result);
  } catch (IOException e) {
  System.out.println("Exception "+e);
  }
  }
  
  public void handleDownloadMadarAll(FacesContext facesContext, OutputStream outputStream) {
  try {
  Object result = executeMethodWithResult("bookFarsiCard_madar_printAll");
  outputStream.write((byte[])result);
  } catch (IOException e) {
  System.out.println("Exception "+e);
  }
  }
  
  public void handleDownloadLatinMadarAll(FacesContext facesContext, OutputStream outputStream) {
  try {
  Object result = executeMethodWithResult("bookLatinCard_madar_printAll");
  outputStream.write((byte[])result);
  } catch (IOException e) {
  System.out.println("Exception "+e);
  }
  }
  
  public void handleDownloadLatinMadarOne(FacesContext facesContext, OutputStream outputStream) {
  try {
  Object result = executeMethodWithResult("bookLatinCard_madar_printOne");
  outputStream.write((byte[])result);
  } catch (IOException e) {
  System.out.println("Exception "+e);
  }
  }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTimeStamp() {
      return new Timestamp(System.currentTimeMillis()).toString();
    }
  public void filter_vBook_codeOrRow(ActionEvent actionEvent) {
    AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
    FResult fr=null;
    if(getRow()==true){
        
      fr= app.bookFarsiCard_filterVbook(getFromRow(), getToRow(), "row");

    }else{    
  fr=app.bookFarsiCard_filterVbook(getFromCode(), getToCode(), "serial");
    
       }
    if(fr!=null) {
    if("error".equals(fr.getType())) {
    JSFUtils.addFacesErrorMessage(fr.getText());
    return;
    }
    }
    JSFUtils.showPopup("pt1:pMainCard");
    
  }
  
    public String setLatinVC() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
app.bookFarsiCard_setFarsiLatinVc("latin");

        return null;
    }

    public String setFarsiVC() {
        AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
        app.bookFarsiCard_setFarsiLatinVc("farsi");
    
        return null;
    }

  

    public void setCurrentReadingOrder(Number currentReadingOrder) {
        this.currentReadingOrder = currentReadingOrder;
    }

    public Number getCurrentReadingOrder() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
     return ((VirtualBookListVOImpl) app.getVirtualBookList_farsiCardVO1()).currentReadingOrder();
    }

    public void setCode(Boolean code) {
        this.code = code;
    }

    public Boolean getCode() {
        return code;
    }

    public void setRow(Boolean row) {
        this.row = row;
    }

    public Boolean getRow() {
        return row;
    }
}
