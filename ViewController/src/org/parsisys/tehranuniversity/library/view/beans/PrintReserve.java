package org.parsisys.tehranuniversity.library.view.beans;

import javax.faces.event.ValueChangeEvent;

import javax.swing.JPanel;

import oracle.adf.model.BindingContext;
import oracle.adf.model.OperationBinding;

import oracle.binding.BindingContainer;

import org.parsisys.tehranuniversity.library.model.am.AppModuleImpl;

import util.JSFUtils;


public class PrintReserve extends JPanel {
   
   
   private String reportPath;
    public PrintReserve() {
    }

    public void applyReserveReadyVC(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
       // if(valueChangeEvent.getNewValue()==1)
        {
              BindingContainer bc = (BindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
                      OperationBinding ob =(OperationBinding)bc.getOperationBinding("applyVCPrintReserve");
                      ob.execute();  
                      
                      
             
              
            }
    }
  
    public void check_all_checkBoxes(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        
        AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
        if((Boolean) valueChangeEvent.getNewValue()==true){
        app.cid_print_reserve_check_chekboxes();
        }
        else if((Boolean) valueChangeEvent.getNewValue()==false){
              app.cid_print_reserve_UNcheck_chekboxes();
            }
        
    }

    public void setReportPath(String reportPath) {
        System.out.println(reportPath);
        this.reportPath = reportPath;
    }

    public String getReportPath() {
        return reportPath;
    }

    public String runPopUP() {
        JSFUtils.showPopup("pt1:reportPop");
        return null;
    }
}
