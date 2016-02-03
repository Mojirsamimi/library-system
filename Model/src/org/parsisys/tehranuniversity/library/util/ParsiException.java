package org.parsisys.tehranuniversity.library.util;

public class ParsiException extends Exception {
    private String message;
    private String type;
    private String severity;
    public ParsiException() {
        super();
    }
  public ParsiException(String message) {
      
      super();
      this.message=message;
  }
  public ParsiException(String message,String type,String severity) {
      super();
      this.message=message;
      this.type=type;
      this.severity=severity;
  }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getSeverity() {
        return severity;
    }
}
