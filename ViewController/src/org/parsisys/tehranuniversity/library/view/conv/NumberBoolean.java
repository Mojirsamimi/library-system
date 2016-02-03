package org.parsisys.tehranuniversity.library.view.conv;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class NumberBoolean implements Converter {
    public NumberBoolean() {
        super();
    }

    public Object getAsObject(FacesContext facesContext,
                              UIComponent uIComponent, String string) {
       if(string !=null && string.equals("1"))
        return Boolean.valueOf(true);
       else
           return Boolean.valueOf(false);
    }

    public String getAsString(FacesContext facesContext,
                              UIComponent uIComponent, Object object) {
       if (object==null || object.equals(Boolean.FALSE))
           return "0";
       else
           return "1";
               
       // return null;
    }
}
