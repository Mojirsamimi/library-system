package org.parsisys.tehranuniversity.library.view.beans;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;

import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.binding.BindingContainer;

import oracle.jbo.domain.Number;
import oracle.jbo.server.ViewRowImpl;
import oracle.jbo.uicli.binding.JUCtrlListBinding;

import org.parsisys.tehranuniversity.library.model.am.AppModuleImpl;
import org.parsisys.tehranuniversity.library.util.FResult;

import util.JSFUtils;

public class BookStatusBarcodeChange
{
 private String newBookBarcode;
    private RichPopup yy;

    public BookStatusBarcodeChange()
  {
    super();
  }
  
  public void bookStatusBarcodeChange(ActionEvent actionEvent)
  {
    
    BindingContainer bindings =
    BindingContext.getCurrent().getCurrentBindingsEntry();
    JUCtrlListBinding existenceStatus =(JUCtrlListBinding)bindings.get("ExistenceStatus");   
    JUCtrlListBinding loanStatus =(JUCtrlListBinding)bindings.get("LoanStatus");   
    JUCtrlListBinding safetyStatus =(JUCtrlListBinding)bindings.get("SafetyStatus");   
    JUCtrlListBinding place=(JUCtrlListBinding)bindings.get("Place");   
    if(existenceStatus.getSelectedIndex()==-1 || loanStatus.getSelectedIndex()==-1||safetyStatus.getSelectedIndex()==-1|| place.getSelectedIndex()==-1)
    {
        JSFUtils.addFacesErrorMessage("ابتدا یک کتاب جستجو کنید.");
        return;
    }
    
    AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
    
    FResult result=
      app.bookStatusBarcodeChange_save
      (getNewBookBarcode()
      ,(Number)((ViewRowImpl)existenceStatus.getValueFromList(existenceStatus.getSelectedIndex())).getAttribute("Value")
      ,(Number)((ViewRowImpl)loanStatus.getValueFromList(loanStatus.getSelectedIndex())).getAttribute("Value")
      ,(Number)((ViewRowImpl)safetyStatus.getValueFromList(safetyStatus.getSelectedIndex())).getAttribute("Value")
      ,(Number)((ViewRowImpl)place.getValueFromList(place.getSelectedIndex())).getAttribute("Value")
      );
     
     if(result!=null)
     {
    if(result.getType().equalsIgnoreCase("error"))
    {
        JSFUtils.addFacesErrorMessage(result.getText());
      setNewBookBarcode("");

      return;
    }else if(result.getType().equalsIgnoreCase("info")){
          JSFUtils.addFacesInfoMessage(result.getText());
        }
     }
    setNewBookBarcode(null);
  }

  public void setNewBookBarcode(String newBookBarcode)
  {
    this.newBookBarcode = newBookBarcode;
  }

  public String getNewBookBarcode()
  {
    return newBookBarcode;
  }

    public void setYy(RichPopup yy) {
        this.yy = yy;
    }

    public RichPopup getYy() {
        return yy;
    }
}
