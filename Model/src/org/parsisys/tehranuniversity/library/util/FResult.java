package org.parsisys.tehranuniversity.library.util;

import java.io.Serializable;

public class FResult implements Serializable {
    private String type;
    private String text;
    private Object result;
  public FResult() {
      
      super();
   
  }
    public FResult(String type,String text) {
        
        super();
      this.type=type;
      this.text=text;
    }
    
  public FResult(String type,Object result) {
      
      super();
    this.type=type;
    this.result=result;
  }
  
  public FResult(String type,String text,Object result) {
      
      super();
    this.type=type;
    this.result=result;
    this.text=text;
  }

    public void setText(String Text) {
        this.text = Text;
    }

    public String getText() {
        return text;
    }

    public void setType(String Type) {
        this.type = Type;
    }

    public String getType() {
        return type;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Object getResult() {
        return result;
    }
}
