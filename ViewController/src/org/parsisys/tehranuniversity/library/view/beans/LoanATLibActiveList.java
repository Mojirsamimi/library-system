package org.parsisys.tehranuniversity.library.view.beans;

import java.math.BigDecimal;

import javax.faces.event.ValueChangeEvent;

import javax.swing.JPanel;

import org.parsisys.tehranuniversity.library.model.am.AppModuleImpl;

import util.JSFUtils;

public class LoanATLibActiveList extends JPanel {
    public LoanATLibActiveList() {
    }
 

    public void activelistValueChanged(ValueChangeEvent valueChangeEvent) {

        //System.out.println("$$$$$$$$first"+valueChangeEvent.getNewValue());
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
        int result=Integer.valueOf(valueChangeEvent.getNewValue().toString());
        if(result==2)
        {
        //System.out.println("in 2 "+result);
        app.applyLoanAtLibListVc("active");
        }
        else if(result==1 )
        {
           // System.out.println("in 1 "+result);
              app.applyLoanAtLibListVc("all");        
            }
    }
}
