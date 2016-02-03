package org.parsisys.tehranuniversity.library.view.beans;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;

import oracle.binding.BindingContainer;

import oracle.jbo.domain.Number;
import oracle.jbo.server.ViewRowImpl;
import oracle.jbo.uicli.binding.JUCtrlListBinding;

import org.parsisys.tehranuniversity.library.model.am.AppModuleImpl;
import org.parsisys.tehranuniversity.library.util.FResult;

import util.JSFUtils;

public class CidBarcodeSearch
{
  private String findBarcode;
  public CidBarcodeSearch()
  {
    super();
  }

  public void setFindBarcode(String findBarcode)
  {
    this.findBarcode = findBarcode;
  }

  public String getFindBarcode()
  {
    return findBarcode;
  }

  public void callSearchBarcode(ActionEvent actionEvent)
  {
    AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
    
     FResult fr= app.searchBarcode(getFindBarcode());
     if(fr!=null) {
       if("error".equals(fr.getType())) {
         JSFUtils.addFacesErrorMessage(fr.getText());
       }
     }
  }
}
