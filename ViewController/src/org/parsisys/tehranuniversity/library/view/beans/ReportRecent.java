package org.parsisys.tehranuniversity.library.view.beans;

import util.JSFUtils;

public class ReportRecent {
 private String newPersianFromDate;
 private String newPersianToDate;
  private String newPersianTitleFromDate;
  private String newPersianTitleToDate;
  private String newPersianProviderFromDate;
  private String newPersianProviderToDate;
 
  private String newLatinFromDate;
  private String newLatinToDate;
  
  private String newLatinTitleFromDate;
  private String newLatinTitleToDate;
  
  private String newLatinProviderFromDate;
  private String newLatinProviderToDate;
 
   private String reportPath;
    public ReportRecent() {
        super();
    }
  public void runReport(){
    JSFUtils.showPopup("pt1:reportPop");
  }
    public void setNewPersianFromDate(String fromDate) {
        this.newPersianFromDate = fromDate;
    }

    public String getNewPersianFromDate() {
        return newPersianFromDate;
    }

    public void setNewPersianToDate(String toDate) {
        this.newPersianToDate = toDate;
    }

    public String getNewPersianToDate() {
        return newPersianToDate;
    }

    public void setReportPath(String reportPath) {
      System.out.println(reportPath);
        this.reportPath = reportPath;
    }

    public String getReportPath() {
        return reportPath;
    }

    public void setNewPersianTitleFromDate(String newPersianTitleFromDate) {
        this.newPersianTitleFromDate = newPersianTitleFromDate;
    }

    public String getNewPersianTitleFromDate() {
        return newPersianTitleFromDate;
    }

    public void setNewPersianTitleToDate(String newPersianTitleToDate) {
        this.newPersianTitleToDate = newPersianTitleToDate;
    }

    public String getNewPersianTitleToDate() {
        return newPersianTitleToDate;
    }

    public void setNewPersianProviderFromDate(String newPersianProviderFromDate) {
        this.newPersianProviderFromDate = newPersianProviderFromDate;
    }

    public String getNewPersianProviderFromDate() {
        return newPersianProviderFromDate;
    }

    public void setNewPersianProviderToDate(String newPersianProviderToDate) {
        this.newPersianProviderToDate = newPersianProviderToDate;
    }

    public String getNewPersianProviderToDate() {
        return newPersianProviderToDate;
    }

    public void setNewLatinFromDate(String newLatinFromDate) {
        this.newLatinFromDate = newLatinFromDate;
    }

    public String getNewLatinFromDate() {
        return newLatinFromDate;
    }

    public void setNewLatinToDate(String newLatinToDate) {
        this.newLatinToDate = newLatinToDate;
    }

    public String getNewLatinToDate() {
        return newLatinToDate;
    }

    public void setNewLatinTitleFromDate(String newLatinTitleFromDate) {
        this.newLatinTitleFromDate = newLatinTitleFromDate;
    }

    public String getNewLatinTitleFromDate() {
        return newLatinTitleFromDate;
    }

    public void setNewLatinTitleToDate(String newLatinTitleToDate) {
        this.newLatinTitleToDate = newLatinTitleToDate;
    }

    public String getNewLatinTitleToDate() {
        return newLatinTitleToDate;
    }

    public void setNewLatinProviderFromDate(String newLatinProviderFromDate) {
        this.newLatinProviderFromDate = newLatinProviderFromDate;
    }

    public String getNewLatinProviderFromDate() {
        return newLatinProviderFromDate;
    }

    public void setNewLatinProviderToDate(String newLatinProviderToDate) {
        this.newLatinProviderToDate = newLatinProviderToDate;
    }

    public String getNewLatinProviderToDate() {
        return newLatinProviderToDate;
    }
}
