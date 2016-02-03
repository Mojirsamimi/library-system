package org.parsisys.tehranuniversity.library.view.beans;

import java.io.IOException;
import java.io.OutputStream;

import java.util.Date;

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

public class ReportFarsiLabel {
    private String timeStamp;
    private Number fromCode;
    private Number toCode;
    private Number currentReadingOrder;
    private Number p_latin_farsi;
    private Number print_column;
    public ReportFarsiLabel() {
        super();
    }




    public void setFromCode(Number fromCode) {
        this.fromCode = fromCode;
    }

    public Number getFromCode() {
        return fromCode;
    }

    public void setToCode(Number toDate) {
        this.toCode = toDate;
    }

    public Number getToCode() {
        return toCode;
    }

   
  public String karteAmanat() {
//        AppModuleImpl app =
//        ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
//        app.labelFarsi_labelLoan(getFromCode(), getToCode());
      return "printLabel_farsi";
  }

    public void bookLabelBtnActionListener(ActionEvent actionEvent) {
      AppModuleImpl app =
      ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      FResult fr=    app.labelFarsi_beforeAtfeKetab(getFromCode(), getToCode());
      if(fr!=null) {
      if("error".equals(fr.getType())) {
      JSFUtils.addFacesErrorMessage(fr.getText());
      return;
      }
      }
      JSFUtils.showPopup("pt1:p1");
      
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
    
  public void handleDownloadAllTitles(FacesContext facesContext, OutputStream outputStream) {
  try {
  Object result = executeMethodWithResult("labelFarsi_printAllTitles");
  outputStream.write((byte[])result);
  } catch (IOException e) {
  System.out.println("Exception "+e);
  }
  }
  
  public void handleDownloadTitle(FacesContext facesContext, OutputStream outputStream) {
  try {
  Object result = executeMethodWithResult("labelFarsi_printTitle");
  outputStream.write((byte[])result);
  } catch (IOException e) {
  System.out.println("Exception "+e);
  }
  }
  
  public void handleDownloadVolNo(FacesContext facesContext, OutputStream outputStream) {
  try {
  Object result = executeMethodWithResult("labelFarsi_printVolNo");
  outputStream.write((byte[])result);
  } catch (IOException e) {
  System.out.println("Exception "+e);
  }
  }
  
  public void handleDownloadPartNo(FacesContext facesContext, OutputStream outputStream) {
  try {
  Object result = executeMethodWithResult("labelFarsi_printPartNo");
  outputStream.write((byte[])result);
  } catch (IOException e) {
  System.out.println("Exception "+e);
  }
  }
  
  public void handleDownloadRepNo(FacesContext facesContext, OutputStream outputStream) {
  try {
  Object result = executeMethodWithResult("labelFarsi_printRepNo");
  outputStream.write((byte[])result);
  } catch (IOException e) {
  System.out.println("Exception "+e);
  }
  }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTimeStamp() {
       // return timeStamp;
      
        return new Timestamp(System.currentTimeMillis()).toString();
    }

    public String setFarsiVc() {
        // Add event code here...
        AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
        app.bookFarsiLabel_setLatinFarsiVc("farsi");
        return null;
    }

    public String setLatinVC() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      app.bookFarsiLabel_setLatinFarsiVc("latin");
        return null;
    }

    public void setCurrentReadingOrder(Number currentReadingOrder) {
        this.currentReadingOrder = currentReadingOrder;
    }

    public Number getCurrentReadingOrder() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      return ((VirtualBookListVOImpl) app.getVirtualBookList_FarsiLabelVO1()).currentReadingOrder();
    }

    public void setP_latin_farsi(Number p_latin_farsi) {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      app.getSession().getUserData().put("LabelFarsi.Setting.p_latin_farsi", p_latin_farsi);
        this.p_latin_farsi = p_latin_farsi;
    }

    public Number getP_latin_farsi() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
     return (Number)app.getSession().getUserData().get("LabelFarsi.Setting.p_latin_farsi");

    }

    public void setPrint_column(Number print_column) {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      app.getSession().getUserData().put("LabelFarsi.Setting.print_column", print_column);
        this.print_column = print_column;
    }

    public Number getPrint_column() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      return (Number)app.getSession().getUserData().get("LabelFarsi.Setting.print_column");
    }
}
