package org.parsisys.tehranuniversity.library.view.beans;

import java.io.IOException;
import java.io.OutputStream;

import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class ReportDownloader {
    public ReportDownloader() {
        super();
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
  
  public void handleDeptReportDwd(FacesContext facesContext, OutputStream outputStream) {
  try {
  Object result = executeMethodWithResult("rep_card_curr_row");
  outputStream.write((byte[])result);
  } catch (IOException e) {
  System.out.println("Exception "+e);
  }
  }
}
