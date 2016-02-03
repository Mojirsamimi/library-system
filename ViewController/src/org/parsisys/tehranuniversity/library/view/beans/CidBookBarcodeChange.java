package org.parsisys.tehranuniversity.library.view.beans;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import org.parsisys.tehranuniversity.library.model.am.AppModuleImpl;
import org.parsisys.tehranuniversity.library.util.FResult;

import util.JSFUtils;

public class CidBookBarcodeChange
{
  private String bookNewBarcode;
  public CidBookBarcodeChange()
  {
    
    super();
  }

  public void setBookNewBarcode(String bookNewBarcode)
  {
    this.bookNewBarcode = bookNewBarcode;
  }

  public String getBookNewBarcode()
  {
    return bookNewBarcode;
  }
 
  public void showErrorResult(ActionEvent actionEvent)
  {
    AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
    
    FResult result=app.saveBookBarcodeChange(getBookNewBarcode());
    if(result!=null){
        if(result.getType().equalsIgnoreCase("error")){
          JSFUtils.addFacesErrorMessage(result.getText());
          }
        else if(result.getType().equalsIgnoreCase("info"))
            JSFUtils.addFacesInfoMessage(result.getText());
        }
    setBookNewBarcode("");

  }
}
