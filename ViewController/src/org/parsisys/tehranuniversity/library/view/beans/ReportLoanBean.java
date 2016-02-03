package org.parsisys.tehranuniversity.library.view.beans;

import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;

import oracle.jbo.domain.Number;

import org.parsisys.tehranuniversity.library.util.ParsiUtil;

import util.JSFUtils;

public class ReportLoanBean {
   

    public ReportLoanBean() {
        super();
    }
    String reportPath;

    public void setReportPath(String reportPath) {
        System.out.println(reportPath);
        this.reportPath = reportPath;
    }

    public String getReportPath() {
        return reportPath;
    }
    
  String fromDate;
  String toDate;
  String reserveCnt="5";
  String penaltyPaymentFromDate;
  String penaltyPaymentToDate;
  String penaltyPaymentUsername;
  String reserveMaxFromDate;
  String reserveMaxToDate;
  Integer reserveMaxRecCnt=20;
  String loanMaxFromDate;
  String loanMaxToDate;
  Integer loanMaxMoreThan=20;
  String loanMaxCallNo;
  String memberMaxMinFromDate;
  String memberMaxMinToDate;
  String amarKarkardUsername;
  String memberDelayFromDate;
  String memberDelayToDate;
  String memberDelayCnt="20";
  String memberDelaySort;
  Number libArtId;
  String listDelayTaCurrDate;
  Boolean delayPostChbx;
  Boolean delayPersTypeChbx;
  Boolean delayDepChbx;
  Boolean memCountDepChbx;
  Boolean memCountDegChbx;
  Boolean memCountPersStChbx;
  Boolean memCountAffilChbx;
  Boolean memCountSecChbx;
  Boolean memCountPostChbx;
  Boolean memCountPersTypeChbx;
  Boolean memCountOriginChbx;
  Boolean memCountMjrChbx;
  Boolean memCountPersCatChbx;
  Boolean memberMaxMinDep;
  Boolean memberMaxMinSec;
  Boolean memberMaxMinMjr;
  Boolean memberMaxMinOrigin;
  Boolean memberMaxMinDegree;
  Boolean memNoLoanDepChBx;
 
 
  String usageKeyFromDate;
  String usageKeyToDate;
  
  
  String listDelayKeyFromDate;
  String listDelayKeyToDate;
  Boolean listDelayKeyPstChBx;
  Boolean listDelayKeyPersTypeChbx;
  Boolean listDelayKeyDepChbx;
  
  
    public void runReport(){
      JSFUtils.showPopup("pt1:reportPop");
    }
    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setReserveCnt(String reserveCnt) {
        this.reserveCnt = reserveCnt;
    }

    public String getReserveCnt() {
        return reserveCnt;
    }

    public void setPenaltyPaymentFromDate(String penaltyPaymentFromDate) {
        this.penaltyPaymentFromDate = penaltyPaymentFromDate;
    }

    public String getPenaltyPaymentFromDate() {
        return penaltyPaymentFromDate;
    }

    public void setPenaltyPaymentToDate(String penaltyPaymentToDate) {
        this.penaltyPaymentToDate = penaltyPaymentToDate;
    }

    public String getPenaltyPaymentToDate() {
        return penaltyPaymentToDate;
    }

    public void setPenaltyPaymentUsername(String penaltyPaymentUsername) {
        this.penaltyPaymentUsername = penaltyPaymentUsername;
    }

    public String getPenaltyPaymentUsername() {
        return penaltyPaymentUsername;
    }

    public void setLibArtId(Number libArtId) {

      this.libArtId = libArtId;
    }

    public Number getLibArtId() {
      UserStatus us = (UserStatus)JSFUtils.getManagedBeanValue("sessionUser");
      libArtId= us.getLibartid();
        return libArtId;
    }

    public void setListDelayTaCurrDate(String listDelayTaCurrDate) {
      
        this.listDelayTaCurrDate = listDelayTaCurrDate;
    }

    public String getListDelayTaCurrDate() {
        return ParsiUtil.DateToNumber().toString();
    }

    public void setReserveMaxFromDate(String reserveCntFromDate) {
        this.reserveMaxFromDate = reserveCntFromDate;
    }

    public String getReserveMaxFromDate() {
        return reserveMaxFromDate;
    }

    public void setReserveMaxToDate(String reserveCntToDate) {
        this.reserveMaxToDate = reserveCntToDate;
    }

    public String getReserveMaxToDate() {
        return reserveMaxToDate;
    }

    public void setReserveMaxRecCnt(Integer reserveCntMoreThan) {
        this.reserveMaxRecCnt = reserveCntMoreThan;
    }

    public Integer getReserveMaxRecCnt() {
        return reserveMaxRecCnt;
    }

    public void setLoanMaxFromDate(String loanMaxFromDate) {
        this.loanMaxFromDate = loanMaxFromDate;
    }

    public String getLoanMaxFromDate() {
        return loanMaxFromDate;
    }

    public void setLoanMaxToDate(String loanMaxToDate) {
        this.loanMaxToDate = loanMaxToDate;
    }

    public String getLoanMaxToDate() {
        return loanMaxToDate;
    }

    public void setLoanMaxMoreThan(Integer loanMaxMoreThan) {
        this.loanMaxMoreThan = loanMaxMoreThan;
    }

    public Integer getLoanMaxMoreThan() {
        return loanMaxMoreThan;
    }

    public void setLoanMaxCallNo(String loanMaxCallNo) {
        this.loanMaxCallNo = loanMaxCallNo;
    }

    public String getLoanMaxCallNo() {
        return loanMaxCallNo;
    }

    public void setAmarKarkardUsername(String amarKarkardUsername) {
        this.amarKarkardUsername = amarKarkardUsername;
    }

    public String getAmarKarkardUsername() {
        return amarKarkardUsername;
    }

    public void setMemberDelayFromDate(String memberDelayFromDate) {
        this.memberDelayFromDate = memberDelayFromDate;
    }

    public String getMemberDelayFromDate() {
        return memberDelayFromDate;
    }

    public void setMemberDelayToDate(String memberDelayToDate) {
        this.memberDelayToDate = memberDelayToDate;
    }

    public String getMemberDelayToDate() {
        return memberDelayToDate;
    }

    public void setMemberDelayCnt(String memberDelayCnt) {
        this.memberDelayCnt = memberDelayCnt;
    }

    public String getMemberDelayCnt() {
        return memberDelayCnt;
    }

    public void setMemberMaxMinFromDate(String memberMaxMinFromDate) {
        this.memberMaxMinFromDate = memberMaxMinFromDate;
    }

    public String getMemberMaxMinFromDate() {
        return memberMaxMinFromDate;
    }

    public void setMemberMaxMinToDate(String memberMaxMinToDate) {
        this.memberMaxMinToDate = memberMaxMinToDate;
    }

    public String getMemberMaxMinToDate() {
        return memberMaxMinToDate;
    }

   
    public String getListDelayTaCurrDate1() {
        return listDelayTaCurrDate;
    }

    public void setDelayPostChbx(Boolean delayChbx) {
       
        this.delayPostChbx = delayChbx;
    }

    public Boolean getDelayPostChbx() {
      
        return delayPostChbx;
    }

    public void setDelayPersTypeChbx(Boolean delayPersTypeChbx) {
        this.delayPersTypeChbx = delayPersTypeChbx;
    }

    public Boolean getDelayPersTypeChbx() {
        return delayPersTypeChbx;
    }

    public void setDelayDepChbx(Boolean delayDepChbx) {
        this.delayDepChbx = delayDepChbx;
    }

    public Boolean getDelayDepChbx() {
        return delayDepChbx;
    }

    public void setMemCountDepChbx(Boolean memCountDepChbx) {
        this.memCountDepChbx = memCountDepChbx;
    }

    public Boolean getMemCountDepChbx() {
        return memCountDepChbx;
    }

    public void setMemCountDegChbx(Boolean memCountDegChbx) {
        this.memCountDegChbx = memCountDegChbx;
    }

    public Boolean getMemCountDegChbx() {
        return memCountDegChbx;
    }

    public void setMemCountPersStChbx(Boolean memCountPersStChbx) {
        this.memCountPersStChbx = memCountPersStChbx;
    }

    public Boolean getMemCountPersStChbx() {
        return memCountPersStChbx;
    }

    public void setMemCountAffilChbx(Boolean memCountAffilChbx) {
        this.memCountAffilChbx = memCountAffilChbx;
    }

    public Boolean getMemCountAffilChbx() {
        return memCountAffilChbx;
    }

    public void setMemCountSecChbx(Boolean memCountSecChbx) {
        this.memCountSecChbx = memCountSecChbx;
    }

    public Boolean getMemCountSecChbx() {
        return memCountSecChbx;
    }

    public void setMemCountPostChbx(Boolean memCountPostChbx) {
        this.memCountPostChbx = memCountPostChbx;
    }

    public Boolean getMemCountPostChbx() {
        return memCountPostChbx;
    }

    public void setMemCountPersTypeChbx(Boolean memCountPersTypeChbx) {
        this.memCountPersTypeChbx = memCountPersTypeChbx;
    }

    public Boolean getMemCountPersTypeChbx() {
        return memCountPersTypeChbx;
    }

    public void setMemCountOriginChbx(Boolean memCountOriginChbx) {
        this.memCountOriginChbx = memCountOriginChbx;
    }

    public Boolean getMemCountOriginChbx() {
        return memCountOriginChbx;
    }

    public void setMemCountMjrChbx(Boolean memCountMjrChbx) {
        this.memCountMjrChbx = memCountMjrChbx;
    }

    public Boolean getMemCountMjrChbx() {
        return memCountMjrChbx;
    }

    public void setMemCountPersCatChbx(Boolean memCountPersCatChbx) {
        this.memCountPersCatChbx = memCountPersCatChbx;
    }

    public Boolean getMemCountPersCatChbx() {
        return memCountPersCatChbx;
    }

    public void setMemberMaxMinOrigin(Boolean memberMaxMinOrigin) {
        this.memberMaxMinOrigin = memberMaxMinOrigin;
    }

    public Boolean getMemberMaxMinOrigin() {
        return memberMaxMinOrigin;
    }

    public void setMemberMaxMinDep(Boolean memberMaxMinDep) {
        this.memberMaxMinDep = memberMaxMinDep;
    }

    public Boolean getMemberMaxMinDep() {
        return memberMaxMinDep;
    }

    public void setMemberMaxMinSec(Boolean memberMaxMinSec) {
        this.memberMaxMinSec = memberMaxMinSec;
    }

    public Boolean getMemberMaxMinSec() {
        return memberMaxMinSec;
    }

    public void setMemberMaxMinMjr(Boolean memberMaxMinMjr) {
        this.memberMaxMinMjr = memberMaxMinMjr;
    }

    public Boolean getMemberMaxMinMjr() {
        return memberMaxMinMjr;
    }

    public void setMemberMaxMinDegree(Boolean memberMaxMinDegree) {
        this.memberMaxMinDegree = memberMaxMinDegree;
    }

    public Boolean getMemberMaxMinDegree() {
        return memberMaxMinDegree;
    }

    public void setMemNoLoanDepChBx(Boolean memNoLoanDepChBx) {
        this.memNoLoanDepChBx = memNoLoanDepChBx;
    }

    public Boolean getMemNoLoanDepChBx() {
        return memNoLoanDepChBx;
    }

    public void setUsageKeyFromDate(String usageKeyFromDate) {
        this.usageKeyFromDate = usageKeyFromDate;
    }

    public String getUsageKeyFromDate() {
        return usageKeyFromDate;
    }

    public void setUsageKeyToDate(String usageKeyToDate) {
        this.usageKeyToDate = usageKeyToDate;
    }

    public String getUsageKeyToDate() {
        return usageKeyToDate;
    }

    public void setListDelayKeyFromDate(String listDelayKeyFromDate) {
        this.listDelayKeyFromDate = listDelayKeyFromDate;
    }

    public String getListDelayKeyFromDate() {
        return listDelayKeyFromDate;
    }

    public void setListDelayKeyToDate(String listDelayKeyToDate) {
        this.listDelayKeyToDate = listDelayKeyToDate;
    }

    public String getListDelayKeyToDate() {
        return listDelayKeyToDate;
    }

    public void setListDelayKeyPstChBx(Boolean listDelayKeyPstChBx) {
        this.listDelayKeyPstChBx = listDelayKeyPstChBx;
    }

    public Boolean getListDelayKeyPstChBx() {
        return listDelayKeyPstChBx;
    }

    public void setListDelayKeyPersTypeChbx(Boolean listDelayKeyPersTypeChbx) {
        this.listDelayKeyPersTypeChbx = listDelayKeyPersTypeChbx;
    }

    public Boolean getListDelayKeyPersTypeChbx() {
        return listDelayKeyPersTypeChbx;
    }

    public void setListDelayKeyDepChbx(Boolean listDelayKeyDepChbx) {
        this.listDelayKeyDepChbx = listDelayKeyDepChbx;
    }

    public Boolean getListDelayKeyDepChbx() {
        return listDelayKeyDepChbx;
    }

    public void setMemberDelaySort(String memberDelaySort) {
        this.memberDelaySort = memberDelaySort;
    }

    public String getMemberDelaySort() {
        return memberDelaySort;
    }
}
