package org.parsisys.tehranuniversity.library.view.beans;

import util.JSFUtils;

public class BookRequestA {
    
  String reportPath;
  Integer fromRow;
  Integer toRow;

    public BookRequestA() {
    }

    
        public void runReport(){
          JSFUtils.showPopup("pt1:reportPop");
        }

    public void setReportPath(String reportPath) {
        this.reportPath = reportPath;
    }

    public String getReportPath() {
        return reportPath;
    }

    public void setFromRow(Integer fromRow) {
        this.fromRow = fromRow;
    }

    public Integer getFromRow() {
        return fromRow;
    }

    public void setToRow(Integer toRow) {
        this.toRow = toRow;
    }

    public Integer getToRow() {
        return toRow;
    }
}
