package org.parsisys.tehranuniversity.library.view.beans;

import javax.faces.event.ValueChangeEvent;

import util.JSFUtils;

public class ProviderTF {
    public ProviderTF() {
    }

    public void changeProviderKind(ValueChangeEvent valueChangeEvent) {
        
        String pKind=JSFUtils.getViewFromIterator("ProviderVO1Iterator").getCurrentRow().getAttribute("ProviderKind").toString();
        
     System.out.println( "attrr val"+ pKind);   
    }
}
