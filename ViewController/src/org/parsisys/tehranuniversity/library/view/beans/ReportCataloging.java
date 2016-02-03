package org.parsisys.tehranuniversity.library.view.beans;

import util.JSFUtils;

public class ReportCataloging {
  String reportPath;
  String amarKarkardFromDate;
  String amarKarkardToDate;
  String cntrlExistingFromDate;
  String cntrlExistingToDate;
  String bookNoskheFromArtId;
  String bookNoskheToArtId;
  String bookNoskheFromRegId;
  String bookNoskheToRegId;
  String bookNoskheCallNo;  
  String bookVejinFromDate;
  String bookVejinToDate;
  String bookVejinCallNo;
  String bookBindingFromDate;
  String bookBindingToDate;
  String bookListPreparedFromDate;
  String bookListPreparedToDate;
  String bookAmarOnvanFromDate;
  String bookAmarOnvanToDate;
  String searchBookNote;
  String searchBookPubDate;
  String searchBookSeries;
  String searchBookProvider;
  String searchBookPublisher;
  String searchBookPubPlace;
  String searchBookCallNo;
  String searchBookTitle;
  Boolean amarKarkardPlaceChbx;
  Boolean amarKarkardReadOrdChbx;
  Boolean  cntrlExistingPlaceChbx;
  Boolean  cntrlExistingLoanStChbx;
  Boolean  cntrlExistingBookStChbx;
  Boolean  cntrlExistingExistStChbx;
  Boolean bookNoskheReadOrdChBx;
  Boolean bookNoskhePlaceChBx;
  Boolean  bookVejinPlaceChBx;
  Boolean bookBindingPlaceChBx;
  Boolean catalogingUndefiendPlaceChBx;
  Boolean takNoskhePlaceChBx;
  Boolean bookListPreparedPlaceChBx;
  Boolean bookListPreparedReadOrdChBx;
  Boolean bookAmarPreparedPlaceChBx;
  Boolean bookAmarPreparedReadOrdChBx;
  Boolean bookTitleLangPlaceChBx;
  Boolean bookTitleLangReadOrdChBx;
  Boolean searchBookRoleChBx;
  Boolean searchBookLangChBx;
  Boolean searchBookLangTypeChBx; 
    public ReportCataloging() {
        super();
    }
  public void runReport(){
    JSFUtils.showPopup("pt1:reportPop");
  }
    public void setAmarKarkardFromDate(String amarKArkardFromDate) {
        this.amarKarkardFromDate = amarKArkardFromDate;
    }

    public String getAmarKarkardFromDate() {
        return amarKarkardFromDate;
    }

    public void setReportPath(String reportPath) {
      System.out.println(reportPath);

        this.reportPath = reportPath;
    }

    public String getReportPath() {
        return reportPath;
    }

    public void setAmarKarkardToDate(String amarKarkardToDate) {
        this.amarKarkardToDate = amarKarkardToDate;
    }

    public String getAmarKarkardToDate() {
        return amarKarkardToDate;
    }

    public void setCntrlExistingFromDate(String cntrlExistingFromDate) {
        this.cntrlExistingFromDate = cntrlExistingFromDate;
    }

    public String getCntrlExistingFromDate() {
        return cntrlExistingFromDate;
    }

    public void setCntrlExistingToDate(String cntrlExistingToDate) {
        this.cntrlExistingToDate = cntrlExistingToDate;
    }

    public String getCntrlExistingToDate() {
        return cntrlExistingToDate;
    }

    public void setBookNoskheFromArtId(String bookNoskheFromArtId) {
        this.bookNoskheFromArtId = bookNoskheFromArtId;
    }

    public String getBookNoskheFromArtId() {
        return bookNoskheFromArtId;
    }

    public void setBookNoskheToArtId(String bookNoskheToArtId) {
        this.bookNoskheToArtId = bookNoskheToArtId;
    }

    public String getBookNoskheToArtId() {
        return bookNoskheToArtId;
    }

    public void setBookNoskheFromRegId(String bookNoskheFromRegId) {
        this.bookNoskheFromRegId = bookNoskheFromRegId;
    }

    public String getBookNoskheFromRegId() {
        return bookNoskheFromRegId;
    }

    public void setBookNoskheToRegId(String bookNoskheToRegId) {
        this.bookNoskheToRegId = bookNoskheToRegId;
    }

    public String getBookNoskheToRegId() {
        return bookNoskheToRegId;
    }

    public void setBookNoskheCallNo(String bookNoskheCallNo) {
        this.bookNoskheCallNo = bookNoskheCallNo;
    }

    public String getBookNoskheCallNo() {
        return bookNoskheCallNo;
    }

    public void setBookVejinFromDate(String bookVejinFromDate) {
        this.bookVejinFromDate = bookVejinFromDate;
    }

    public String getBookVejinFromDate() {
        return bookVejinFromDate;
    }

    public void setBookVejinToDate(String bookVejinToDate) {
        this.bookVejinToDate = bookVejinToDate;
    }

    public String getBookVejinToDate() {
        return bookVejinToDate;
    }

    public void setBookVejinCallNo(String bookVejinCallNo) {
        this.bookVejinCallNo = bookVejinCallNo;
    }

    public String getBookVejinCallNo() {
        return bookVejinCallNo;
    }

    public void setBookBindingFromDate(String bookBindingFromDate) {
        this.bookBindingFromDate = bookBindingFromDate;
    }

    public String getBookBindingFromDate() {
        return bookBindingFromDate;
    }

    public void setBookBindingToDate(String bookBindingToDate) {
        this.bookBindingToDate = bookBindingToDate;
    }

    public String getBookBindingToDate() {
        return bookBindingToDate;
    }

    public void setBookListPreparedToDate(String bookListPreparedToDate) {
        this.bookListPreparedToDate = bookListPreparedToDate;
    }

    public String getBookListPreparedToDate() {
        return bookListPreparedToDate;
    }

    public void setBookListPreparedFromDate(String bookListPreparedFromDate) {
        this.bookListPreparedFromDate = bookListPreparedFromDate;
    }

    public String getBookListPreparedFromDate() {
        return bookListPreparedFromDate;
    }

    public void setBookAmarOnvanFromDate(String bookAmarOnvanFromDate) {
        this.bookAmarOnvanFromDate = bookAmarOnvanFromDate;
    }

    public String getBookAmarOnvanFromDate() {
        return bookAmarOnvanFromDate;
    }

    public void setBookAmarOnvanToDate(String bookAmarOnvanToDate) {
        this.bookAmarOnvanToDate = bookAmarOnvanToDate;
    }

    public String getBookAmarOnvanToDate() {
        return bookAmarOnvanToDate;
    }

    public void setSearchBookProvider(String searchBookProvider) {
        this.searchBookProvider = searchBookProvider;
    }

    public String getSearchBookProvider() {
        return searchBookProvider;
    }

    public void setSearchBookNote(String searchBookNote) {
        this.searchBookNote = searchBookNote;
    }

    public String getSearchBookNote() {
        return searchBookNote;
    }

    public void setSearchBookPubDate(String searchBookPubDate) {
        this.searchBookPubDate = searchBookPubDate;
    }

    public String getSearchBookPubDate() {
        return searchBookPubDate;
    }

    public void setSearchBookSeries(String searchBookSeries) {
        this.searchBookSeries = searchBookSeries;
    }

    public String getSearchBookSeries() {
        return searchBookSeries;
    }

    public void setSearchBookPublisher(String searchBookPublisher) {
        this.searchBookPublisher = searchBookPublisher;
    }

    public String getSearchBookPublisher() {
        return searchBookPublisher;
    }

    public void setSearchBookPubPlace(String searchBookPubPlace) {
        this.searchBookPubPlace = searchBookPubPlace;
    }

    public String getSearchBookPubPlace() {
        return searchBookPubPlace;
    }

    public void setSearchBookCallNo(String searchBookCallNo) {
        this.searchBookCallNo = searchBookCallNo;
    }

    public String getSearchBookCallNo() {
        return searchBookCallNo;
    }

    public void setSearchBookTitle(String searchBookTitle) {
        this.searchBookTitle = searchBookTitle;
    }

    public String getSearchBookTitle() {
        return searchBookTitle;
    }

    public void setAmarKarkardPlaceChbx(Boolean amarKarkardPlaceChbx) {
        this.amarKarkardPlaceChbx = amarKarkardPlaceChbx;
    }

    public Boolean getAmarKarkardPlaceChbx() {
        return amarKarkardPlaceChbx;
    }

    public void setCntrlExistingPlaceChbx(Boolean cntrlExistingPlaceChbx) {
        this.cntrlExistingPlaceChbx = cntrlExistingPlaceChbx;
    }

    public Boolean getCntrlExistingPlaceChbx() {
        return cntrlExistingPlaceChbx;
    }

    public void setCntrlExistingLoanStChbx(Boolean cntrlExistingLoanStChbx) {
        this.cntrlExistingLoanStChbx = cntrlExistingLoanStChbx;
    }

    public Boolean getCntrlExistingLoanStChbx() {
        return cntrlExistingLoanStChbx;
    }

    public void setCntrlExistingBookStChbx(Boolean cntrlExistingBookStChbx) {
        this.cntrlExistingBookStChbx = cntrlExistingBookStChbx;
    }

    public Boolean getCntrlExistingBookStChbx() {
        return cntrlExistingBookStChbx;
    }

    public void setCntrlExistingExistStChbx(Boolean cntrlExistingExistStChbx) {
        this.cntrlExistingExistStChbx = cntrlExistingExistStChbx;
    }

    public Boolean getCntrlExistingExistStChbx() {
        return cntrlExistingExistStChbx;
    }

    public void setBookNoskheReadOrdChBx(Boolean bookNoskheReadOrdChBx) {
        this.bookNoskheReadOrdChBx = bookNoskheReadOrdChBx;
    }

    public Boolean getBookNoskheReadOrdChBx() {
        return bookNoskheReadOrdChBx;
    }

    public void setBookNoskhePlaceChBx(Boolean bookNoskhePlaceChBx) {
        this.bookNoskhePlaceChBx = bookNoskhePlaceChBx;
    }

    public Boolean getBookNoskhePlaceChBx() {
        return bookNoskhePlaceChBx;
    }

    public void setBookVejinPlaceChBx(Boolean bookVejinPlaceChBx) {
        this.bookVejinPlaceChBx = bookVejinPlaceChBx;
    }

    public Boolean getBookVejinPlaceChBx() {
        return bookVejinPlaceChBx;
    }

    public void setBookBindingPlaceChBx(Boolean bookBindingPlaceChBx) {
        this.bookBindingPlaceChBx = bookBindingPlaceChBx;
    }

    public Boolean getBookBindingPlaceChBx() {
        return bookBindingPlaceChBx;
    }

    public void setCatalogingUndefiendPlaceChBx(Boolean catalogingUndefiendPlaceChBx) {
        this.catalogingUndefiendPlaceChBx = catalogingUndefiendPlaceChBx;
    }

    public Boolean getCatalogingUndefiendPlaceChBx() {
        return catalogingUndefiendPlaceChBx;
    }

    public void setTakNoskhePlaceChBx(Boolean takNoskhePlaceChBx) {
        this.takNoskhePlaceChBx = takNoskhePlaceChBx;
    }

    public Boolean getTakNoskhePlaceChBx() {
        return takNoskhePlaceChBx;
    }

    public void setBookListPreparedPlaceChBx(Boolean bookListPreparedPlaceChBx) {
        this.bookListPreparedPlaceChBx = bookListPreparedPlaceChBx;
    }

    public Boolean getBookListPreparedPlaceChBx() {
        return bookListPreparedPlaceChBx;
    }

    public void setBookListPreparedReadOrdChBx(Boolean bookListPreparedReadOrdChBx) {
        this.bookListPreparedReadOrdChBx = bookListPreparedReadOrdChBx;
    }

    public Boolean getBookListPreparedReadOrdChBx() {
        return bookListPreparedReadOrdChBx;
    }

    public void setBookAmarPreparedPlaceChBx(Boolean bookAmarPreparedPlaceChBx) {
        this.bookAmarPreparedPlaceChBx = bookAmarPreparedPlaceChBx;
    }

    public Boolean getBookAmarPreparedPlaceChBx() {
        return bookAmarPreparedPlaceChBx;
    }

    public void setBookAmarPreparedReadOrdChBx(Boolean bookAmarPreparedReadOrdChBx) {
        this.bookAmarPreparedReadOrdChBx = bookAmarPreparedReadOrdChBx;
    }

    public Boolean getBookAmarPreparedReadOrdChBx() {
        return bookAmarPreparedReadOrdChBx;
    }

    public void setBookTitleLangPlaceChBx(Boolean bookTitleLangPlaceChBx) {
        this.bookTitleLangPlaceChBx = bookTitleLangPlaceChBx;
    }

    public Boolean getBookTitleLangPlaceChBx() {
        return bookTitleLangPlaceChBx;
    }

    public void setBookTitleLangReadOrdChBx(Boolean bookTitleLangReadOrdChBx) {
        this.bookTitleLangReadOrdChBx = bookTitleLangReadOrdChBx;
    }

    public Boolean getBookTitleLangReadOrdChBx() {
        return bookTitleLangReadOrdChBx;
    }

    public void setSearchBookRoleChBx(Boolean searchBookRoleChBx) {
        this.searchBookRoleChBx = searchBookRoleChBx;
    }

    public Boolean getSearchBookRoleChBx() {
        return searchBookRoleChBx;
    }

    public void setSearchBookLangChBx(Boolean searchBookLangChBx) {
        this.searchBookLangChBx = searchBookLangChBx;
    }

    public Boolean getSearchBookLangChBx() {
        return searchBookLangChBx;
    }

    public void setSearchBookLangTypeChBx(Boolean searchBookLangTypeChBx) {
        this.searchBookLangTypeChBx = searchBookLangTypeChBx;
    }

    public Boolean getSearchBookLangTypeChBx() {
        return searchBookLangTypeChBx;
    }

    public void setAmarKarkardReadOrdChbx(Boolean amarKarkardReadOrdChbx) {
        this.amarKarkardReadOrdChbx = amarKarkardReadOrdChbx;
    }

    public Boolean getAmarKarkardReadOrdChbx() {
        return amarKarkardReadOrdChbx;
    }
}
