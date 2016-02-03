package org.parsisys.tehranuniversity.library.model.am;


//import com.microsoft.sqlserver.jdbc.SQLServerException;



import afe.BoxService;
import afe.BoxServiceSoap;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import fadak.base.TemplateAppModule;
import fadak.base.TemplateViewObject;

import ir.afe.ArrayOfString;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import java.lang.Integer;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.WebServiceRef;

import oracle.jbo.AttrSetValException;
import oracle.jbo.JboException;
import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.RowIterator;
import oracle.jbo.RowSet;
import oracle.jbo.RowSetIterator;
import oracle.jbo.RowValException;
import oracle.jbo.SessionData;
import oracle.jbo.ValidationException;
import oracle.jbo.Variable;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaItem;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;
import oracle.jbo.XMLInterface;
import oracle.jbo.domain.DBSequence;
import oracle.jbo.domain.Number;
import oracle.jbo.server.DBTransaction;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.SequenceImpl;
import oracle.jbo.server.TransactionEvent;
import oracle.jbo.server.ViewLinkImpl;


import oracle.jbo.server.ViewObjectImpl;

import oracle.jheadstart.util.DatabaseProcedure;

import oracle.xml.parser.v2.XMLNode;

import org.parsisys.tehranuniversity.library.model.am.common.AppModule;
import org.parsisys.tehranuniversity.library.model.eo.BookStatusHistoryImpl;
import org.parsisys.tehranuniversity.library.model.eo.BookThesisImpl;
import org.parsisys.tehranuniversity.library.model.eo.CardImpl;
import org.parsisys.tehranuniversity.library.model.eo.CardRowImpl;
import org.parsisys.tehranuniversity.library.model.eo.CatalogDetailImpl;
import org.parsisys.tehranuniversity.library.model.eo.InitMemberImpl;
import org.parsisys.tehranuniversity.library.model.eo.LoanCashPenaltyImpl;
import org.parsisys.tehranuniversity.library.model.eo.MemberExtentionHistoryImpl;
import org.parsisys.tehranuniversity.library.model.eo.MemberImpl;
import org.parsisys.tehranuniversity.library.model.eo.MemberStatusHistoryImpl;
import org.parsisys.tehranuniversity.library.model.eo.PersonImpl;
import org.parsisys.tehranuniversity.library.model.eo.PhysicalBookImpl;
import org.parsisys.tehranuniversity.library.model.eo.ReserveImpl;
import org.parsisys.tehranuniversity.library.model.eo.VbookPublisherImpl;
import org.parsisys.tehranuniversity.library.model.vo.AddressVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.BookBarcodeHistoryVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.BookBarcodeHistoryVORowImpl;
import org.parsisys.tehranuniversity.library.model.vo.BookRequestImpl;
import org.parsisys.tehranuniversity.library.model.vo.BookRequestRowImpl;
import org.parsisys.tehranuniversity.library.model.vo.BookThesisVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.BookThesisVORowImpl;
import org.parsisys.tehranuniversity.library.model.vo.CardVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.CardVORowImpl;
import org.parsisys.tehranuniversity.library.model.vo.CashierListVoImpl;
import org.parsisys.tehranuniversity.library.model.vo.CashierListVoRowImpl;
import org.parsisys.tehranuniversity.library.model.vo.CashierVoImpl;
import org.parsisys.tehranuniversity.library.model.vo.CashierVoRowImpl;
import org.parsisys.tehranuniversity.library.model.vo.CatalogDetailVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.CatalogDetailVORowImpl;
import org.parsisys.tehranuniversity.library.model.vo.CidConstVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.CommonVOs.LibRoleVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.CommonVOs.LibRoleVORowImpl;
import org.parsisys.tehranuniversity.library.model.vo.CommonVOs.LibUserRoleVoImpl;
import org.parsisys.tehranuniversity.library.model.vo.CommonVOs.LibUserRoleVoRowImpl;
import org.parsisys.tehranuniversity.library.model.vo.CommonVOs.LibUserVoImpl;
import org.parsisys.tehranuniversity.library.model.vo.CommonVOs.LibUserVoRowImpl;
import org.parsisys.tehranuniversity.library.model.vo.CommonVOs.MenuListVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.CommonVOs.MenuListVORowImpl;
import org.parsisys.tehranuniversity.library.model.vo.EmailVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.ExtraChargeVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.ExtraChargeVORowImpl;
import org.parsisys.tehranuniversity.library.model.vo.FloatSubjectVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.InitMemberVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.InitMemberVORowImpl;
import org.parsisys.tehranuniversity.library.model.vo.IntroductionLetterVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.IntroductionLetterVORowImpl;
import org.parsisys.tehranuniversity.library.model.vo.LibraryImpl;
import org.parsisys.tehranuniversity.library.model.vo.LibraryRowImpl;
import org.parsisys.tehranuniversity.library.model.vo.LoanAtLibListVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.LoanCashPenaltyVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.LoanCashPenaltyVORowImpl;
import org.parsisys.tehranuniversity.library.model.vo.LoanVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.LoanVORowImpl;
import org.parsisys.tehranuniversity.library.model.vo.MainSeeAlsoProviderImpl;
import org.parsisys.tehranuniversity.library.model.vo.MainSeeAlsoProviderRowImpl;
import org.parsisys.tehranuniversity.library.model.vo.MainSeeAlsoSubjectVoImpl;
import org.parsisys.tehranuniversity.library.model.vo.MainSeeAlsoSubjectVoRowImpl;
import org.parsisys.tehranuniversity.library.model.vo.MainSeeAlsoUniformTitleVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.MainSeeAlsoUniformTitleVORowImpl;
import org.parsisys.tehranuniversity.library.model.vo.MainSeeProviderImpl;
import org.parsisys.tehranuniversity.library.model.vo.MainSeeProviderRowImpl;
import org.parsisys.tehranuniversity.library.model.vo.MainSeeSubjectVoImpl;
import org.parsisys.tehranuniversity.library.model.vo.MainSeeSubjectVoRowImpl;
import org.parsisys.tehranuniversity.library.model.vo.MainSeeUniformTitleImpl;
import org.parsisys.tehranuniversity.library.model.vo.MainSeeUniformTitleRowImpl;
import org.parsisys.tehranuniversity.library.model.vo.MemberBarcodeHistoryVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.MemberBarcodeHistoryVORowImpl;
import org.parsisys.tehranuniversity.library.model.vo.MemberExtensionHistoryRowImpl;
import org.parsisys.tehranuniversity.library.model.vo.MemberSetUpVoImpl;
import org.parsisys.tehranuniversity.library.model.vo.MemberStatusHistoryVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.MemberStatusHistoryVORowImpl;
import org.parsisys.tehranuniversity.library.model.vo.MemberVoImpl;
import org.parsisys.tehranuniversity.library.model.vo.MemberVoRowImpl;
import org.parsisys.tehranuniversity.library.model.vo.OtherTitleVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.PenaltyPaymentVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.PenaltyPaymentVORowImpl;
import org.parsisys.tehranuniversity.library.model.vo.PenaltyTypeVoImpl;
import org.parsisys.tehranuniversity.library.model.vo.PenaltyTypeVoRowImpl;
import org.parsisys.tehranuniversity.library.model.vo.PersonVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.PersonVORowImpl;
import org.parsisys.tehranuniversity.library.model.vo.PhysicalBookVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.PhysicalBookVORowImpl;
import org.parsisys.tehranuniversity.library.model.vo.PrintVirtualBookImpl;
import org.parsisys.tehranuniversity.library.model.vo.PrintVirtualBookRowImpl;
import org.parsisys.tehranuniversity.library.model.vo.ProviderRoleVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.ProviderVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.ProviderVORowImpl;
import org.parsisys.tehranuniversity.library.model.vo.PublicCashPenaltyImpl;
import org.parsisys.tehranuniversity.library.model.vo.PublicCashPenaltyRowImpl;
import org.parsisys.tehranuniversity.library.model.vo.PublicNonCashPenaltyVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.PublicNonCashPenaltyVORowImpl;
import org.parsisys.tehranuniversity.library.model.vo.Publisher_PersianVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.RO.AllPersonVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.RO.AllPhysicalBooksVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.RO.DummyVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.RO.DummyVORowImpl;
import org.parsisys.tehranuniversity.library.model.vo.RO.PP_BookBarcodeSearchResultVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.RO.PP_BookBarcodeSearchResultVORowImpl;
import org.parsisys.tehranuniversity.library.model.vo.RO.PP_CashierVoImpl;
import org.parsisys.tehranuniversity.library.model.vo.RO.PP_CashierVoRowImpl;
import org.parsisys.tehranuniversity.library.model.vo.RO.PP_LoanVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.RO.PP_LoanVORowImpl;
import org.parsisys.tehranuniversity.library.model.vo.RO.PP_PersonBarcodeSearchResultVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.RO.PP_PersonBarcodeSearchResultVORowImpl;
import org.parsisys.tehranuniversity.library.model.vo.RO.PhysicalBookVolPartVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.RO.PhysicalBookVolPartVORowImpl;
import org.parsisys.tehranuniversity.library.model.vo.RO.RafReportVoImpl;
import org.parsisys.tehranuniversity.library.model.vo.RO.pp_ReqBlkVoImpl;
import org.parsisys.tehranuniversity.library.model.vo.RO.pp_ReqBlkVoRowImpl;
import org.parsisys.tehranuniversity.library.model.vo.RegisterLostVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.RegisterLostVORowImpl;
import org.parsisys.tehranuniversity.library.model.vo.ReserveVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.ReserveVORowImpl;
import org.parsisys.tehranuniversity.library.model.vo.ReturnBookVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.ReturnBookVORowImpl;
import org.parsisys.tehranuniversity.library.model.vo.SeeAlsoProviderVoImpl;
import org.parsisys.tehranuniversity.library.model.vo.SeeAlsoProviderVoRowImpl;
import org.parsisys.tehranuniversity.library.model.vo.SeeAlsoSubjectVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.SeeAlsoSubjectVORowImpl;
import org.parsisys.tehranuniversity.library.model.vo.SeeAlsoUniformTitleVoImpl;
import org.parsisys.tehranuniversity.library.model.vo.SeeAlsoUniformTitleVoRowImpl;
import org.parsisys.tehranuniversity.library.model.vo.SeeProviderImpl;
import org.parsisys.tehranuniversity.library.model.vo.SeeProviderRowImpl;
import org.parsisys.tehranuniversity.library.model.vo.SeeSubjectVoImpl;
import org.parsisys.tehranuniversity.library.model.vo.SeeSubjectVoRowImpl;
import org.parsisys.tehranuniversity.library.model.vo.SeeUniformTitleImpl;
import org.parsisys.tehranuniversity.library.model.vo.SeeUniformTitleRowImpl;
import org.parsisys.tehranuniversity.library.model.vo.SeriesVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.SocialBarcodeViewImpl;
import org.parsisys.tehranuniversity.library.model.vo.SocialBarcodeViewRowImpl;
import org.parsisys.tehranuniversity.library.model.vo.SubjectVoImpl;
import org.parsisys.tehranuniversity.library.model.vo.SubjectVoRowImpl;
import org.parsisys.tehranuniversity.library.model.vo.TelephoneVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.UniformTitleVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.UniformTitleVORowImpl;
import org.parsisys.tehranuniversity.library.model.vo.VbookLanguageVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.VbookProviderVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.VbookPublisherVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.VbookPublisherVORowImpl;
import org.parsisys.tehranuniversity.library.model.vo.VbookRankVORowImpl;
import org.parsisys.tehranuniversity.library.model.vo.VbookSubjectVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.VbookUniTtlVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.VirtualBookVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.VirtualBookVORowImpl;
import org.parsisys.tehranuniversity.library.model.vo.VwCardSubjectVORowImpl;
import org.parsisys.tehranuniversity.library.model.vo.report.Rep_LanguagesVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.report.Rep_NotesVoImpl;
import org.parsisys.tehranuniversity.library.model.vo.report.Rep_PhysicalBookVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.report.Rep_PhysicalBookVORowImpl;
import org.parsisys.tehranuniversity.library.model.vo.report.Rep_ProviderVoImpl;
import org.parsisys.tehranuniversity.library.model.vo.report.Rep_PublisherVoImpl;
import org.parsisys.tehranuniversity.library.model.vo.report.Rep_SeriesVoImpl;
import org.parsisys.tehranuniversity.library.model.vo.report.Rep_VirtualBookFarsiCardImpl;
import org.parsisys.tehranuniversity.library.model.vo.report.Rep_VirtualBookVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.report.VirtualBookListVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.report.VirtualBookListVORowImpl;
import org.parsisys.tehranuniversity.library.util.FResult;
import org.parsisys.tehranuniversity.library.util.PDate;
import org.parsisys.tehranuniversity.library.util.ParsiUtil;
import org.parsisys.tehranuniversity.library.util.ReportItems;
import org.parsisys.tehranuniversity.library.util.mail.SendMail;

import org.parsisys.tehranuniversity.library.util.report.ReportGenerator;

import util.FDate;
import util.JSFUtils;


// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Jan 14 16:35:49 IRST 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class AppModuleImpl extends TemplateAppModule implements AppModule {
    private Map pakage_variables;
    private String baseBookFileDir="c:\\vbookfiles";
  @WebServiceRef
  private static BoxService boxService;

    /**
     * This is the default constructor (do not remove).
     */
    public AppModuleImpl() {
        
      
    }
  public FResult rolePermission_checkNullUser(){
          LibUserVoRowImpl currUser = (LibUserVoRowImpl)getLibUserVo_UserTab().getCurrentRow();
            if( currUser==null || currUser.getUserName()==null){
                        return new FResult("error",
                                           "ابتدا یک کاربر را جستجو کنید ");
            }
  return null;
  }
    public FResult rolePermission_changePassword(String pass,String repPass){
        LibUserVoRowImpl currUser = (LibUserVoRowImpl)getLibUserVo_UserTab().getCurrentRow();
         
          
          if(pass==null || "".equals(pass) || repPass==null || "".equals(repPass)){

                      return new FResult("error","رمزجدید و تکرار رمز را وارد نمایید.");

          }
          if (!(pass.equals(repPass))){

                      return new FResult("error","رمز جدید و تکرار رمز جدید یکسان نیستند.");

          }
                                    
          currUser.setPassword(pass);
          getDBTransaction().commit();
          return new FResult("info","رمز جدید ثبت گردید.");

        }
  public void bookFarsiLabel_setLatinFarsiVc(String lang){
      
      VirtualBookListVOImpl bookFarsiCardVo = (VirtualBookListVOImpl)getVirtualBookList_FarsiLabelVO1();
        bookFarsiCardVo.setApplyViewCriteriaName("farsi".equals(lang)?"PersianBooksVC":"LatinBooksVC");
                 bookFarsiCardVo.executeQuery();
      
      }

  public void bookFarsiCard_setFarsiLatinVc(String lang){
      
      VirtualBookListVOImpl bookFarsiCardVo = (VirtualBookListVOImpl)getVirtualBookList_farsiCardVO1();
      bookFarsiCardVo.setApplyViewCriteriaName("farsi".equals(lang)?"PersianBooksVC":"LatinBooksVC");
                 bookFarsiCardVo.executeQuery();
//                 Rep_VirtualBookFarsiCardImpl rep= getRep_VirtualBookFarsiCardVo1();
//                 rep.setparam_readingOrder("farsi".equals(lang)?new Number(1):new Number(2));
//                 rep.setApplyViewCriteriaName("ReadingOrderVC");
//        rep.executeQuery();
      
      }
    public void createSampleXmlfromView(String view,String filePath) {
        ViewObject vo = findViewObject(view);
       // vo.executeQuery();
       // getPrintVirtualBook1().executeQuery();
      try {
          ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
          //The following statement will generate xml representation of the view data.
          //the first param of writeXML takes the number of levels of child nodes to consider.
          //the entire xml is then printed into the outputStream.
          ((XMLNode)vo.writeXML(2, XMLInterface.XML_OPT_ASSOC_CONSISTENT)).print(outputStream);
          //Simple and Dirty way to generate sample XML data is to print the outputStream to log
          //Then copy the data into xml file.
          //However it will not be possible to generate large xml file in this way
      //            System.out.println(""+outputStream.toString());
        writeXmlToFile(outputStream,filePath);
         
         
      } catch (IOException e) {
          e.printStackTrace();
      } catch (Exception e) {
        e.printStackTrace();
      } 
      
    }
  private  void writeXmlToFile(ByteArrayOutputStream outputStream,String filePath) {
      OutputStream out;
      try {
          out = new FileOutputStream(filePath);
          outputStream.writeTo(out);
          out.close();
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      } catch (IOException e) {
          e.printStackTrace();
      }
  }
    public byte[] rep_all_language(String outFileType) {
      return ReportGenerator.getReport("view",1,"c:\\Artid.rtf", outFileType, getRep_LanguagesVO1());
    }
    
  public byte[] rep_bookFarsiCard_main_all_books(String outFileType) {
    return ReportGenerator.getReport("view",1,"c:\\Artid.rtf", outFileType, getPrintVirtualBook1());
  }
  
  public byte[] rep_card_curr_row(String outFileType) {
    return ReportGenerator.getReport("row",1,"d:\\card.rtf", outFileType, getCardVO1());
  }
  
 
  
  public void publicNonCashPenaltyChangeActive(Integer active){
      PublicNonCashPenaltyVORowImpl currRow = (PublicNonCashPenaltyVORowImpl)getPublicNonCashPenaltyVO1().getCurrentRow();
        try {
            currRow.setActive(new Number(active));
        } catch (SQLException e) {
        }
        getDBTransaction().commit();
       
      }
  public void publicNonCashPenaltyAfterActiveChanged(){

        InitMemberVORowImpl currInitMem = (InitMemberVORowImpl)getInitMemberCurrLibVO().getCurrentRow();     
        PublicNonCashPenaltyVORowImpl currRow = (PublicNonCashPenaltyVORowImpl)getPublicNonCashPenaltyVO1().getCurrentRow();

             DummyVOImpl dummyVo=getDummyVO1();
         dummyVo.setQuery("SELECT * FROM   public_non_cash_penalty"+
        " WHERE  mem_art_id="+currInitMem.getArtId()+
        " AND   art_id!="+currRow.getArtId().getSequenceNumber()+
        " AND active=1 And labcol="+(Number)getSession().getUserData().get("labcolno"));
         dummyVo.executeQuery();
         if(dummyVo.getRowCount()==0){
              
                               
               currInitMem.setDebitNonCash(new Number (2));
               getDBTransaction().commit();

             }
        
      }  
  public FResult cardFarsi_setCode(Number from,Number to) {
   FResult fr= labelFarsi_checkCode(from, to);
   if(fr!=null)
       return fr;
      Rep_VirtualBookFarsiCardImpl vbookVOImpl = (Rep_VirtualBookFarsiCardImpl)getRep_VirtualBookFarsiCardVo1();
      vbookVOImpl.setparam_art_id_from(from);
      vbookVOImpl.setparam_art_id_to(to);
    //vbookVOImpl.setparam_readingOrder(new Number(1));
   
      vbookVOImpl.setApplyViewCriteriaName("BetweenTwoArtIdVC",true);
      vbookVOImpl.executeQuery();
   
      return null;
  }
  
    public FResult bookFarsiCard_filterVbook(Number from,Number to,String type) {
           
        
      FResult fr= labelFarsi_checkCode(from, to);
      if(fr!=null)
          return fr;
      
        if("serial".equalsIgnoreCase(type)){
            
            Rep_VirtualBookFarsiCardImpl vbookVOImpl = getRep_VirtualBookFarsiCardVo1();
              vbookVOImpl.setWhereClause("1=1");
              vbookVOImpl.executeQuery();
            
                 vbookVOImpl.setparam_art_id_from(from);
                 vbookVOImpl.setparam_art_id_to(to);
                 //Number readingOrder=((VirtualBookListVORowImpl)getVirtualBookList_farsiCardVO1().getCurrentRow()).getReadingOrder();
                 vbookVOImpl.setparam_readingOrder(((VirtualBookListVOImpl) getVirtualBookList_farsiCardVO1()).currentReadingOrder());
                 vbookVOImpl.setApplyViewCriteriaName("BetweenTwoArtIdVC");
                 vbookVOImpl.executeQuery();
            }else  if("row".equalsIgnoreCase(type)){
              getRep_VirtualBookFarsiCardVo1().removeApplyViewCriteriaName("BetweenTwoArtIdVC");
        RowSet RS = getVirtualBookList_farsiCardVO1().createRowSet("a"); 
      long i=1;
      String artIds="";
        for(;i<from.longValue();i++) {
          RS.next();
        }
       
        for(;i<=to.longValue();i++)  
        {
       artIds+= ","+RS.next().getAttribute("ArtId");
        }
      RS.closeRowSet();
      artIds=artIds.replaceFirst(",", "");
      getRep_VirtualBookFarsiCardVo1().setWhereClause("VirtualBook.ART_ID in ("+artIds+")");
      getRep_VirtualBookFarsiCardVo1().executeQuery();
            }
        return null;
    }
    
    public void bookFarsicard_setrow(Number from,Number to){
        RowSetIterator RSI = getVirtualBookList_farsiCardVO1().createRowSetIterator("a");
      long i=1;
      String artIds="";
        for(;i<from.longValue();i++) {
          RSI.next();
        }
       
        for(;i<=to.longValue();i++)  
        {
       artIds+= ","+RSI.next().getAttribute("ArtId");
        }
      RSI.closeRowSetIterator();
      artIds=artIds.replaceFirst(",", "");
      getRep_VirtualBookFarsiCardVo1().setWhereClause("VirtualBook.ART_ID in ("+artIds+")");
      getRep_VirtualBookFarsiCardVo1().executeQuery();
            }
    
    public void bookFarsiCard_(){
  PrintVirtualBookRowImpl currVbook = (PrintVirtualBookRowImpl)getPrintVirtualBook1().getCurrentRow();
  CardVORowImpl newCard = (CardVORowImpl)getCardVO1().createRow();
  getCardVO1().insertRow(newCard);
  newCard.setVbookArtId(currVbook.getArtId());
    newCard.setCrdtypeArtId(new Number(1));
  newCard.setUserName((String) getSession().getUserData().get("username"));
  newCard.setCardDate(ParsiUtil.DateToNumber());
//  newCard.setStatus(allcrd_status);
  newCard.setLabcol((Number)getSession().getUserData().get("labcolno"));
  getDBTransaction().commit();
    DatabaseProcedure mcgFarsi = DatabaseProcedure.define("FUNCTION parsi_pkg_catalog.MCG_FARSI(CARD_ART_ID NUMBER,BOOK_ART_IDIN NUMBER,ROW_IdIN NUMBER,labcolno number) RETURN VARCHAR2;");
    String chjoin =
    (String)mcgFarsi.call(getDBTransaction(),newCard.getArtId().getSequenceNumber(),currVbook.getArtId(),new Number(1),getSession().getUserData().get("labcolno")).getReturnValue();
  
    }
    
    
  public void bookFarsiCard_setPrintSettingsParameters(Boolean mCheck,Boolean uCheck,Boolean sCheck,Boolean pCheck,
  Boolean nCheck,Boolean fCheck,Boolean utCheck)
  {
        pakage_variables.put("mCheck",mCheck);
        pakage_variables.put("uCheck",uCheck);
        pakage_variables.put("sCheck",sCheck);
        pakage_variables.put("pCheck",pCheck);
        pakage_variables.put("nCheck",nCheck);
        pakage_variables.put("fCheck",fCheck);
        pakage_variables.put("utCheck",utCheck);
        }
    

    public FResult bookFarsiCard_sel_book_scope(String voName, Number artId1,
                                                Number artId2, Number code1,
                                                Number code2) {
//      String vWhere="";
//      
//    DummyVOImpl dummyVo=getDummyVO1();
//    dummyVo.setQuery(" select role_name from vw_lib_user_role"+
//          " where vw_lib_user_role.libuser_user_name='"+ getSession().getUserData().get("username") +"'  and vw_lib_user_role.role_name in ('SYSTEM_ADMIN','BOOK_CARD_ADMIN')");
//    dummyVo.executeQuery();
//    String roleName="";
//    if (dummyVo.first().getAttribute("Dummy") != null){
//     
//    roleName=(String) dummyVo.getCurrentRow().getAttribute("Dummy");
//    }
//      
//      if( new Number(0).equals(ParsiUtil.NVL(code1)) && new Number(0).equals( ParsiUtil.NVL(code2)) ){
//          if(new Number(0).compareTo(ParsiUtil.NVL(artId1))==1 ||  ParsiUtil.NVL(artId1).compareTo(ParsiUtil.NVL(artId2))==1 ){
//                return new FResult("Bad_Sel_Id",(String)getMessageVO1().findByKey(new Key(new Object[] { "save_completed".toUpperCase() }),
//                                                -1)[0].getAttribute("Message"));
//            } else {
//              vWhere=" virtualbook.ART_ID BETWEEN "+ artId1 + " AND "+ artId2+"";
//                if ("SYSTEM_ADMIN".equals(roleName) ||
//                    "BOOK_CARD_ADMIN".equals(roleName)) {
//                      vWhere=vWhere +" AND virtualbook.READING_ORDER=1";
//                      
//                } else {
//                    vWhere =
//                            vWhere + "AND USER_NAME='" + getSession().getUserData().get("username") +
//                            "' AND READING_ORDER=1";
//                      }
//                else{
//                      vWhere=vWhere + "AND virtualbook.USER_NAME='"+ getSession().getUserData().get("username") + "' AND virtualbook.READING_ORDER=1";
//                    }
//              ViewObject vo=findViewObject(voName);
//              vo.setWhereClause(vWhere);
//              vo.executeQuery();
//              }
//        } else {
//          if(ParsiUtil.NVL(artId2).compareTo(ParsiUtil.NVL(artId1))==-1 )
//                return new FResult("Bad_Sel_Id",
//                                   (String)getMessageVO1().findByKey(new Key(new Object[] { "save_completed".toUpperCase() }),
//                                            -1)[0].getAttribute("Message"));
//          if(code1 ==null || new Number(0).compareTo(code1)==1){
//              code1=new Number(0);
//              }
//           
//          
//          	if :COD_ID2>:LIST_BOOK.rdf then
//						:COD_ID2:=:LIST_BOOK.rdf;
//				end if;
//				V1:=:COD_ID1;
//				V2:=:COD_ID2;
//				V_WHERE:='WHERE ART_ID IN (';
//				FOR I IN V1..V2 LOOP
//						GO_BLOCK('LIST_BOOK');
//						GO_RECORD(I);	 
//						V_WHERE:=V_WHERE||:LIST_BOOK.ART_ID||',';
//				END LOOP;
//				if :ROLE_NAME IN('BOOK_CARD_ADMIN','SYSTEM_ADMIN') then 
//						V_WHERE := SUBSTR(V_WHERE,1,LENGTH(V_WHERE)-1) || ')'||' AND READING_ORDER=1';
//				else
//						V_WHERE := SUBSTR(V_WHERE,1,LENGTH(V_WHERE)-1) || ')'||' AND USER_NAME='''||:key_block.book_ses||''' AND READING_ORDER=1';
//				end if;
//				SET_BLOCK_PROPERTY(NAME_BLOCK,DEFAULT_WHERE,V_WHERE);
//				SET_BLOCK_PROPERTY(NAME_BLOCK,ORDER_BY ,pkg_variable.sort_ordering);
//				go_block(NAME_BLOCK);
//				execute_query;
 //         }
  return null;
  }    
  public FResult bookFarsiCard_printAllCard( Number artId1,Number artId2,Number code1,Number code2){
      Number allcrd_status=new Number(0);
      String whereClause="";
      whereClause="VirtualBook.art_id>=" +artId1 + 
      "	     					and VirtualBook.art_id<="+ artId2 ;//+ 
//      "	     					and (VirtualBook.user_name='"+  getSession().getUserData().get("username") +"'";//+ or admin_flag=1)";
      getVBook_book_farsi_Card().setWhereClause(whereClause);
        getVBook_book_farsi_Card().executeQuery();
        RowSetIterator vBookRowSet =
            getVBook_book_farsi_Card().createRowSetIterator("vBook");
        while(vBookRowSet.hasNext()){
            VirtualBookVORowImpl currVbook =
                (VirtualBookVORowImpl)vBookRowSet.next();
           
            if((Boolean) pakage_variables.get("mCheck")==true){
            CardVORowImpl newCard = (CardVORowImpl)getCardVO1().createRow();
            getCardVO1().insertRow(newCard);
            newCard.setVbookArtId(currVbook.getArtId());
              newCard.setCrdtypeArtId(new Number(1));
            newCard.setUserName((String) getSession().getUserData().get("username"));
            newCard.setCardDate(ParsiUtil.DateToNumber());
            newCard.setStatus(allcrd_status);
            newCard.setLabcol((Number)getSession().getUserData().get("labcolno"));
            getDBTransaction().commit();
              DatabaseProcedure mcgFarsi = DatabaseProcedure.define("FUNCTION parsi_pkg_catalog.MCG_FARSI(CARD_ART_ID NUMBER,BOOK_ART_IDIN NUMBER,ROW_IdIN NUMBER,labcolno number) RETURN VARCHAR2;");
              String chjoin =
              (String)mcgFarsi.call(getDBTransaction(),newCard.getArtId().getSequenceNumber(),currVbook.getArtId(),new Number(1),getSession().getUserData().get("labcolno")).getReturnValue();
        
              String fromStr="";
              fromStr =
                           "/reports/rwservlet?"+"utdbuser&destype=cache&report=book_farsi_card.rdf&UP_card_Art_Idf="+newCard.getArtId().getSequenceNumber()+
                           "&UP_TJoin="+(chjoin==null?"":chjoin)+"&UP_card_Art_Ids="+newCard.getArtId().getSequenceNumber()+"&p_day_date="+ParsiUtil.DateToNumber()+"&UP_Vbook_Art_Id="+currVbook.getArtId()+
                           "&UP_CALL_NO="+currVbook.getCallNo()+"&UP_TITLE"+currVbook.getTitle()+"&UP_PROVIDER"+currVbook.getProviderName()+
                 
                           currVbook.getArtId()+"&UP_PUB_DATE="+currVbook.getPubDate()+ "&paramform=no" + "&labcol="+getSession().getUserData().get("labcol");
              return new FResult("return", fromStr); 
            }
            if((Boolean) pakage_variables.get("uCheck")==true){
           String rowText="  ";
                if(new Number(1).equals(currVbook.getTitlePrintable())){
                    rowText=rowText+currVbook.getTitle();
                      CardVORowImpl newCard = (CardVORowImpl)getCardVO1().createRow();
                      getCardVO1().insertRow(newCard);
                      newCard.setVbookArtId(currVbook.getArtId());
                      newCard.setCrdtypeArtId(new Number(1));
                      newCard.setUserName((String) getSession().getUserData().get("username"));
                      newCard.setCardDate(ParsiUtil.DateToNumber());
                      newCard.setStatus(allcrd_status);
                      newCard.setLabcol((Number)getSession().getUserData().get("labcolno"));
                      getDBTransaction().commit();
        
                      EntityDefImpl cardDef =
                          EntityDefImpl.findDefObject("org.parsisys.tehranuniversity.library.model.eo.CardRow");
                      CardRowImpl cardRow =
                          (CardRowImpl)cardDef .createInstance2(getDBTransaction(),null);

                      
                    cardRow.setCrdArtId(newCard.getArtId().getSequenceNumber());
                    cardRow.setItem(rowText);
                    cardRow.setRowNo(new Number(1));
                    cardRow.setLabcol((Number)getSession().getUserData().get("labcolno"));
                      getDBTransaction().commit();

                      DatabaseProcedure mcgFarsi = DatabaseProcedure.define("FUNCTION parsi_pkg_catalog.MCG_FARSI(CARD_ART_ID NUMBER,BOOK_ART_IDIN NUMBER,ROW_IdIN NUMBER,labcolno number) RETURN VARCHAR2;");
                      String chjoin =
                      (String)mcgFarsi.call(getDBTransaction(),newCard.getArtId().getSequenceNumber(),currVbook.getArtId(),new Number(1),getSession().getUserData().get("labcolno")).getReturnValue();
                      
                      String fromStr="";
                      fromStr ="/reports/rwservlet?"+"utdbuser&destype=cache&report=book_farsi_card.rdf&UP_card_Art_Idf="+newCard.getArtId().getSequenceNumber()+
                                   "&UP_TJoin="+(chjoin==null?"":chjoin)+"&UP_card_Art_Ids="+newCard.getArtId().getSequenceNumber()+"&p_day_date="+ParsiUtil.DateToNumber()+"&UP_Vbook_Art_Id="+currVbook.getArtId()+
                                   "&UP_CALL_NO="+currVbook.getCallNo()+"&UP_TITLE"+currVbook.getTitle()+"&UP_PROVIDER"+currVbook.getProviderName()+
                                    currVbook.getArtId()+"&UP_PUB_DATE="+currVbook.getPubDate()+ "&paramform=no" + "&labcol="+getSession().getUserData().get("labcol");
                      return new FResult("return", fromStr); 
    }
                
                }
                if((Boolean) pakage_variables.get("sCheck")==true){
                  ViewObject cardSubjectVO= getVwCardSubjectVO1();
                  cardSubjectVO.setWhereClause(" BOOK_VW_CARD_SUBJECT.ART_ID="+currVbook.getArtId());
                  cardSubjectVO.executeQuery();
                  String rowText="  ";
                  while(cardSubjectVO.hasNext()){
                    VwCardSubjectVORowImpl curCardSub = (VwCardSubjectVORowImpl)cardSubjectVO.next();
                      rowText=rowText+curCardSub.getSubject();
                      
                  CardVORowImpl newCard = (CardVORowImpl)getCardVO1().createRow();
                  getCardVO1().insertRow(newCard);
                  newCard.setVbookArtId(currVbook.getArtId());
                  newCard.setCrdtypeArtId(new Number(4));
                  newCard.setUserName((String) getSession().getUserData().get("username"));
                  newCard.setCardDate(ParsiUtil.DateToNumber());
                  newCard.setStatus(allcrd_status);
                  newCard.setLabcol((Number)getSession().getUserData().get("labcolno"));
                  getDBTransaction().commit();
                  
                  EntityDefImpl cardDef =
                      EntityDefImpl.findDefObject("org.parsisys.tehranuniversity.library.model.eo.CardRow");
                  CardRowImpl cardRow =
                      (CardRowImpl)cardDef .createInstance2(getDBTransaction(),null);

                  
                  cardRow.setCrdArtId(newCard.getArtId().getSequenceNumber());
                  cardRow.setItem(rowText);
                  cardRow.setRowNo(new Number(1));
                  cardRow.setLabcol((Number)getSession().getUserData().get("labcolno"));
                  getDBTransaction().commit();

                  DatabaseProcedure mcgFarsi = DatabaseProcedure.define("FUNCTION parsi_pkg_catalog.MCG_FARSI(CARD_ART_ID NUMBER,BOOK_ART_IDIN NUMBER,ROW_IdIN NUMBER,labcolno number) RETURN VARCHAR2;");
                  String chjoin =
                  (String)mcgFarsi.call(getDBTransaction(),newCard.getArtId().getSequenceNumber(),currVbook.getArtId(),new Number(1),getSession().getUserData().get("labcolno")).getReturnValue();
                  
                  String fromStr="";
                  fromStr ="/reports/rwservlet?"+"utdbuser&destype=cache&report=book_farsi_card.rdf&UP_card_Art_Idf="+newCard.getArtId().getSequenceNumber()+
                               "&UP_TJoin="+(chjoin==null?"":chjoin)+"&UP_card_Art_Ids="+newCard.getArtId().getSequenceNumber()+"&p_day_date="+ParsiUtil.DateToNumber()+
                               "&UP_CALL_NO="+currVbook.getCallNo()+"&UP_TITLE"+currVbook.getTitle()+"&UP_PROVIDER"+currVbook.getProviderName()+
                                currVbook.getArtId()+"&UP_PUB_DATE="+currVbook.getPubDate()+ "&paramform=no" + "&labcol="+getSession().getUserData().get("labcol");
                  return new FResult("return", fromStr); 
                }
                
                }
              
              vBookRowSet.closeRowSetIterator();
              }
     return null;   
    }
    public void bookFarsiCard_setWhere(Number artId1,Number artId2)   {
        DummyVOImpl dummyVo = getDummyVO1();
          dummyVo.setQuery(" select role_name from vw_lib_user_role"+
                         " where libuser_user_name=" +
                         getSession().getUserData().get("username") +
                         "  and role_name in ('SYSTEM_ADMIN','BOOK_CARD_ADMIN')");
          dummyVo.executeQuery();
          String roleName="";
          if (dummyVo.first().getAttribute("Dummy") != null){
           
          roleName=(String) dummyVo.getCurrentRow().getAttribute("Dummy");
          
            if ("SYSTEM_ADMIN".equals(roleName) ||
                "BOOK_CARD_ADMIN".equals(roleName)) {
              getVBook_ListBook().setWhereClause("user_name=:key_block.book_ses and READING_ORDER=1");  
//              getVBookVo1().setWhereClause("art_id>="+ artId1 + " and art_id<="+ artId2 + "and user_name=" + getSession().getUserData().get("username") + " and READING_ORDER=1");
//              getVBookVo2().setWhereClause("art_id>="+ artId1 + " and art_id<="+ artId2 + "and user_name=" + getSession().getUserData().get("username") + " and READING_ORDER=1");
//              getVBookVo3().setWhereClause("art_id>="+ artId1 + " and art_id<="+ artId2 + "and user_name=" + getSession().getUserData().get("username") + " and READING_ORDER=1");
//              getVBookVo4().setWhereClause("art_id>="+ artId1 + " and art_id<="+ artId2 + "and user_name=" + getSession().getUserData().get("username") + " and READING_ORDER=1");
//              getVBookVo5().setWhereClause("art_id>="+ artId1 + " and art_id<="+ artId2 + "and user_name=" + getSession().getUserData().get("username") + " and READING_ORDER=1");
//              getVBookVo6().setWhereClause("art_id>="+ artId1 + " and art_id<="+ artId2 + "and user_name=" + getSession().getUserData().get("username") + " and READING_ORDER=1");
                }
          else{
                getVBook_ListBook().setWhereClause("user_name=:key_block.book_ses and READING_ORDER=1");  
//                getVBookVo1().setWhereClause("art_id>="+ artId1 + " and art_id<="+ artId2 + " and READING_ORDER=1");
//                getVBookVo2().setWhereClause("art_id>="+ artId1 + " and art_id<="+ artId2 + " and READING_ORDER=1");
//                getVBookVo3().setWhereClause("art_id>="+ artId1 + " and art_id<="+ artId2 + " and READING_ORDER=1");
//                getVBookVo4().setWhereClause("art_id>="+ artId1 + " and art_id<="+ artId2 + " and READING_ORDER=1");
//                getVBookVo5().setWhereClause("art_id>="+ artId1 + " and art_id<="+ artId2 + " and READING_ORDER=1");
//                getVBookVo6().setWhereClause("art_id>="+ artId1 + " and art_id<="+ artId2 + " and READING_ORDER=1");

              }
          
          }
        }
    
  public byte[] bookLatinCard_madar_printAll() {
    return ReportGenerator.getReport("view",2,"d:\\latin card all.rtf", "rtf", getRep_VirtualBookFarsiCardVo1());
  }
  
  public byte[] bookLatinCard_madar_printOne() {
    return ReportGenerator.getReport("row",2,"d:\\latin card.rtf", "rtf", getRep_VirtualBookFarsiCardVo1());
  }
    public byte[] bookFarsiCard_madar_printAll() {
      return ReportGenerator.getReport("view",2,"d:\\farsi card all.rtf", "rtf", getRep_VirtualBookFarsiCardVo1());
    }
    
  public byte[] bookFarsiCard_madar_printOne() {
    return ReportGenerator.getReport("row",2,"d:\\farsi card.rtf", "rtf", getRep_VirtualBookFarsiCardVo1());
  }
      public byte[] labelFarsi_printAllTitles() {
      return ReportGenerator.getReport("view",2,"d:\\farsi label all titles "+getSession().getUserData().get("LabelFarsi.Setting.print_column")+".rtf", "rtf", getRep_VirtualBook_FarsiLabelVO1());
    }
    
  public byte[] labelFarsi_printTitle() {
    return ReportGenerator.getReport("row",2,"d:\\farsi label title "+getSession().getUserData().get("LabelFarsi.Setting.print_column")+".rtf", "rtf", getRep_VirtualBook_FarsiLabelVO1());
  }
  public byte[] labelFarsi_printVolNo() {
        Rep_PhysicalBookVOImpl Phbook_FarsiLabelVO = (Rep_PhysicalBookVOImpl)getRep_PhysicalBook_FarsiLabelVO1();
    Rep_PhysicalBookVORowImpl currPhook = (Rep_PhysicalBookVORowImpl)Phbook_FarsiLabelVO.getCurrentRow();
    if(currPhook==null)
        return new byte[]{};
   
      Phbook_FarsiLabelVO.setparam_volNo(currPhook.getVolNo());
      Phbook_FarsiLabelVO.setApplyViewCriteriaName("VolNoVC");
      Phbook_FarsiLabelVO.executeQuery();
   
   byte[] result= ReportGenerator.getReport("view",1,"d:\\farsi label volno "+getSession().getUserData().get("LabelFarsi.Setting.print_column")+".rtf", "rtf", getRep_PhysicalBook_FarsiLabelVO1());
    Phbook_FarsiLabelVO.removeApplyViewCriteriaName("VolNoVC");
    Phbook_FarsiLabelVO.executeQuery();
        return result;
  }
  public byte[] labelFarsi_printPartNo() {
        Rep_PhysicalBookVOImpl Phbook_FarsiLabelVO = (Rep_PhysicalBookVOImpl)getRep_PhysicalBook_FarsiLabelVO1();
    Rep_PhysicalBookVORowImpl currPhook = (Rep_PhysicalBookVORowImpl)Phbook_FarsiLabelVO.getCurrentRow();
    if(currPhook==null)
        return new byte[]{};
    
  
       
      Phbook_FarsiLabelVO.setparam_volNo(currPhook.getVolNo());
      Phbook_FarsiLabelVO.setparam_partNo(currPhook.getPartNo());
      Phbook_FarsiLabelVO.setApplyViewCriteriaName("PartNoVC");
      Phbook_FarsiLabelVO.executeQuery();
    
   byte[] result= ReportGenerator.getReport("view",1,"d:\\farsi label volno "+getSession().getUserData().get("LabelFarsi.Setting.print_column")+".rtf", "rtf", getRep_PhysicalBook_FarsiLabelVO1());
    Phbook_FarsiLabelVO.removeApplyViewCriteriaName("PartNoVC");
    Phbook_FarsiLabelVO.executeQuery();
        return result;
  }
  
  public byte[] labelFarsi_printRepNo() {
        Rep_PhysicalBookVOImpl Phbook_FarsiLabelVO = (Rep_PhysicalBookVOImpl)getRep_PhysicalBook_FarsiLabelVO1();
    Rep_PhysicalBookVORowImpl currPhook = (Rep_PhysicalBookVORowImpl)Phbook_FarsiLabelVO.getCurrentRow();
    if(currPhook==null)
        return new byte[]{};
    
  String vcName="";
       if(currPhook.getReplicateNo()!=null)
       {
         vcName="RepNoVC";
      Phbook_FarsiLabelVO.setparam_volNo(currPhook.getVolNo());
      Phbook_FarsiLabelVO.setparam_partNo(currPhook.getPartNo());
    Phbook_FarsiLabelVO.setparam_repNo(currPhook.getReplicateNo());
       }else {
         vcName="ArtIdVC";
         Phbook_FarsiLabelVO.setparam_artId(currPhook.getArtId());
       }
      Phbook_FarsiLabelVO.setApplyViewCriteriaName(vcName);
      Phbook_FarsiLabelVO.executeQuery();
    
   byte[] result= ReportGenerator.getReport("view",1,"d:\\farsi label volno "+getSession().getUserData().get("LabelFarsi.Setting.print_column")+".rtf", "rtf", getRep_PhysicalBook_FarsiLabelVO1());
    Phbook_FarsiLabelVO.removeApplyViewCriteriaName(vcName);
    Phbook_FarsiLabelVO.executeQuery();
        return result;
  }
  
    public FResult labelFarsi_beforeAtfeKetab(Number from,Number to) {
     FResult fr= labelFarsi_checkCode(from, to);
     if(fr!=null)
         return fr;
        Rep_VirtualBookVOImpl vbookVOImpl = getRep_VirtualBook_FarsiLabelVO1();
        vbookVOImpl.setparam_art_id_from(from);
        vbookVOImpl.setparam_art_id_to(to);
        vbookVOImpl.setApplyViewCriteriaName("BetweenTwoArtIdVC");
        vbookVOImpl.executeQuery();
      labelFarsi_initialPrintSettings();
        return null;
    }
 
    private void labelFarsi_initialPrintSettings() {
      Number p_latin_farsi = (Number)getSession().getUserData().get("LabelFarsi.Setting.p_latin_farsi");
      if(p_latin_farsi==null) {
        getSession().getUserData().put("LabelFarsi.Setting.p_latin_farsi",new Number(1));
      }
    }
private  FResult labelFarsi_checkCode(Number from,Number to) {
  if(from==null || to==null) {
    return new FResult("error","بازه کتابهای انتخابی باید پر شود.");
  }
  if(from.compareTo(to)>0) {
    return new FResult("error","بازه کتابهای انتخابی نامعتبر است.");
  }
  if(from.longValue()<=0 || to.longValue()<=0 ) {
    return new FResult("error","بازه کتابهای انتخابی نامعتبر است.");
  }
  return null;
}
    public void labelFarsi_labelLoan(Number artid1,Number artid2){
       
          if(artid1!=null && artid2!=null ){
            if (artid1.compareTo(artid2) == 1) {
            Number tempArtId=new Number(0);
              tempArtId=artid1;
              artid1=artid2;
              artid2=tempArtId;
        }
            }
          DummyVOImpl dummyVo=getDummyVO1();

          Number count =new Number(0);
        if(artid1!=null && artid2!=null ){

            dummyVo.setQuery("select count(*) from virtual_book where art_id>=" +
                             artid1 + " and art_id<=" + artid2 +
                             " and reading_order=1");
            dummyVo.executeQuery();
          if (dummyVo.first().getAttribute("Dummy") != null){
             
                count =
                        ParsiUtil.convert_dec_to_number((BigDecimal)dummyVo.getCurrentRow().getAttribute("Dummy"));
            }
        }
          if(artid1!=null && artid2==null ){
            dummyVo.setQuery("select count(*) from virtual_book where art_id>=" +
                             artid1 + " and reading_order=1");
            dummyVo.executeQuery();
            if (dummyVo.first().getAttribute("Dummy") != null){
               
                count =
                        ParsiUtil.convert_dec_to_number((BigDecimal)dummyVo.getCurrentRow().getAttribute("Dummy"));

              }
            
          }
          if(artid1==null && artid2!=null ){
            dummyVo.setQuery("select count(*) from virtual_book where art_id<=" +
                             artid2 + " and reading_order=1");
          dummyVo.executeQuery();
            if (dummyVo.first().getAttribute("Dummy") != null){
               
                count =
                        ParsiUtil.convert_dec_to_number((BigDecimal)dummyVo.getCurrentRow().getAttribute("Dummy"));

              }
        } else if (artid1 == null && artid2 == null) {

          dummyVo.setQuery("select count(*) from virtual_book where reading_order=1");
          dummyVo.executeQuery();
            if (dummyVo.first().getAttribute("Dummy") != null){
               
                count =
                        ParsiUtil.convert_dec_to_number((BigDecimal)dummyVo.getCurrentRow().getAttribute("Dummy"));

              }
          }
          
          if(new Number(0).compareTo(count)==-1){
              VirtualBookVOImpl labelFarsiVo= getLabelFarsi_label_virtualBook();
                if(artid1!=null && artid2!=null ){
                labelFarsiVo.setWhereClause(" VirtualBook.art_id>= " + artid1 +
                                            " and VirtualBook.art_id<=" +
                                            artid2 +
                                            " and VirtualBook.reading_order=1");
                            labelFarsiVo.executeQuery();
                }
                  if(artid1!=null && artid2==null ){
                labelFarsiVo.setWhereClause(" VirtualBook.art_id>= " + artid1 +
                                            " and VirtualBook.reading_order=1");
                    labelFarsiVo.executeQuery();
                    
                  }
                  if(artid1==null && artid2!=null ){
                labelFarsiVo.setWhereClause("  VirtualBook.art_id<=" + artid2 +
                                            " and VirtualBook.reading_order=1");
                    labelFarsiVo.executeQuery();
            } else if (artid1 == null && artid2 == null) {

                    labelFarsiVo.setWhereClause("  VirtualBook.reading_order=1");
                    labelFarsiVo.executeQuery();
                  }
              }
          
        }
    
    public FResult dataEntry_insertBookPlace(String bookPlaceName) {
      DummyVOImpl dummyVo=getDummyVO1();
      dummyVo.setQuery("SELECT MAX(VALUE) FROM CATALOG_DETAIL WHERE CAT_ART_ID=(SELECT ART_ID FROM CID_LIBRARY_CATALOG " + 
      "  		WHERE UPPER(CATALOG_NAME)=UPPER('BOOK_PLACE')) and labcol="+getSession().getUserData().get("labcolno"));
      dummyVo.executeQuery();
      dummyVo.first();
      
      
        Number MAX_VAL =null;
        if (dummyVo.first().getAttribute("Dummy") != null){
            //MAX_VAL =(Number) (dummyVo.getCurrentRow().getAttribute("Dummy"));
            
            MAX_VAL =
                    ParsiUtil.convert_dec_to_number((BigDecimal)dummyVo.getCurrentRow().getAttribute("Dummy"));
        }
        
        MAX_VAL =new Number(1).add(MAX_VAL );
        CatalogDetailVORowImpl newCatalog =
            (CatalogDetailVORowImpl)getCatalogPlaceVo().createRow();
        getCatalogPlaceVo().insertRow(newCatalog);
        
        newCatalog.setCatArtId(new Number(9));
        newCatalog.setValue(MAX_VAL);
        newCatalog.setLabcol((Number) getSession().getUserData().get("labcolno"));
        newCatalog.setActive(new Number(1));
        newCatalog.setEnglishText(null);
        newCatalog.setText(bookPlaceName);
        getDBTransaction().commit();
      //MAX_VAL save_completed
        return new FResult("info",
                           (String)getMessageVO1().findByKey(new Key(new Object[] { "save_completed".toUpperCase() }),
                                      -1)[0].getAttribute("Message"));
      }
  public FResult dataEntry_makhzanType_valueChanged(Boolean makhzanType ){
      
      pakage_variables.put("insertMakhzan", true);
    String loanableMakhzanString = (String)pakage_variables.get("LoanableMakhzanString");
    if(loanableMakhzanString==null)
    {
        DummyVOImpl dummyVO1 = getDummyVO1();
        dummyVO1.setQuery("SELECT TEXT FROM CATALOG_DETAIL  WHERE CAT_ART_ID=17 AND VALUE=1 AND labcol="+getSession().getUserData().get("labcolno"));
    dummyVO1.executeQuery();
    loanableMakhzanString =(dummyVO1.first()==null?",": (String)dummyVO1.first().getAttribute("Dummy"));
     pakage_variables.put("LoanableMakhzanString", loanableMakhzanString);
    }
 
      
  CatalogDetailVORowImpl currCatalog = (CatalogDetailVORowImpl)getCatalogPlaceVo().getCurrentRow();
  
  if(makhzanType){
      if(!ParsiUtil.contains(loanableMakhzanString,",",currCatalog .getValue().toString())){
          if(",".equals(loanableMakhzanString))
             pakage_variables.put("LoanableMakhzanString",currCatalog.getValue().toString());
          else
            pakage_variables.put("LoanableMakhzanString",loanableMakhzanString+","+ currCatalog.getValue().toString()) ;

          }
      
      
      }
    else{
          if(ParsiUtil.contains(loanableMakhzanString,",",currCatalog .getValue().toString())){
        
            if(currCatalog.getValue().toString().equals(loanableMakhzanString))
             pakage_variables.put("LoanableMakhzanString",",");
            else{
                   pakage_variables.put("LoanableMakhzanString",ParsiUtil.deleteWordFromText(loanableMakhzanString, ",", currCatalog.getValue().toString()) );
                }
        }
        }
  
  return null;
  }
  public FResult dataEntry_insertCatalogDetail(){
      if(pakage_variables.get("insertMakhzan")!=null &&  (Boolean)pakage_variables.get("insertMakhzan")==true){
           // CatalogDetailVORowImpl currCatalog = (CatalogDetailVORowImpl)getCatalogPlaceVo().getCurrentRow();

          ViewObjectImpl dummyVo=getDummyVO1();
            dummyVo.setQuery("SELECT * FROM CATALOG_DETAIL  WHERE CAT_ART_ID=17 AND VALUE=1 AND labcol=" + getSession().getUserData().get("labcolno"));
          dummyVo.executeQuery();
          int cnt=dummyVo.getRowCount();
          
          if(cnt==0)
          {
           
          CatalogDetailVORowImpl newCatalog=(CatalogDetailVORowImpl) getCatalogDetailVO1().createRow();
          getCatalogDetailVO1().insertRow(newCatalog);
           newCatalog.setLabcol((Number) getSession().getUserData().get("labcolno"));
          newCatalog.setValue(new Number(1));
          newCatalog.setActive(new Number(1));
          newCatalog.setCatArtId(new Number(17));
          newCatalog.setText((String)pakage_variables.get("LoanableMakhzanString"));
          }
          else{
                
                    
                     ViewCriteria vc = getCatalogDetailVO1().createViewCriteria();
                     ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
                vcRow.setAttribute("CatArtId", "=17");
                vcRow.setAttribute("Value", "=1");
                vcRow.setAttribute("Labcol", "="+getSession().getUserData().get("labcolno"));
              vc.add(vcRow);
                
//                     ViewCriteriaItem cat_art_id = vcRow1.ensureCriteriaItem("CatArtId");
//                     cat_art_id.setOperator("=");
//                     cat_art_id.getValues().get(0).setValue(new Number(17));
//                     vc.add(vcRow1);
//
//                     ViewCriteriaRow vcRow2 = vc.createViewCriteriaRow();
//                     ViewCriteriaItem Value = vcRow2.ensureCriteriaItem("Value");
//                     Value.setOperator("=");
//                     Value.getValues().get(0).setValue(new Number(1));
//                     vc.add(vcRow2);
//              
//               ViewCriteriaRow vcRow3 = vc.createViewCriteriaRow();
//                ViewCriteriaItem Labcol = vcRow3.ensureCriteriaItem("Labcol");
//                Labcol.setOperator("=");
//                Labcol.getValues().get(0).setValue(getSession().getUserData().get("labcolno"));
//                vc.add(vcRow3);

                    
              RowIterator ri=  getCatalogDetailVO1().findByViewCriteria(vc, -1, ViewObject.QUERY_MODE_SCAN_DATABASE_TABLES);
              if(ri.hasNext()) {
                CatalogDetailVORowImpl currCatalog = (CatalogDetailVORowImpl)ri.next();
                currCatalog.setText((String)pakage_variables.get("LoanableMakhzanString"));
              }
             
              }
          //getDBTransaction().commit();
          }
      return null;
      }
  
  public FResult dataEntry_insertPenaltyType1(Number penaltyStatus){
        PenaltyTypeVoRowImpl currRow =
            (PenaltyTypeVoRowImpl)getPenaltyType_1().getCurrentRow();
        if (new Number(2).equals(penaltyStatus)) {
      currRow.setDayPenalty(new Number(0));
     }
      getDBTransaction().commit();
      return null;
      }

  public FResult dataEntry_insertPenaltyType2(Number penaltyStatus){
        PenaltyTypeVoRowImpl currRow =
            (PenaltyTypeVoRowImpl)getPenaltyType_2().getCurrentRow();
        if (new Number(2).equals(penaltyStatus)) {
      currRow.setDayPenalty(new Number(0));
     }
      getDBTransaction().commit();
      return null;
      }

  public FResult dataEntry_catalogPassClassValue(){
        CatalogDetailVORowImpl currRow =
            (CatalogDetailVORowImpl)getCatalogPassClassVo().first();
    if(currRow==null || currRow.getText()==null)
        return null;
        if (currRow.getText().equals("فعال")) {
        return new FResult("return",new Number(1));
        } else if (currRow.getText().equals("غیر فعال")) {
        return new FResult("return",new Number(2));
    }
    return null;
  }

  public FResult dataEntry_catalogShelfDelayValue(){
        CatalogDetailVORowImpl currRow =
            (CatalogDetailVORowImpl)getCatalogShelfDelayVo().first();
    if(currRow==null || currRow.getText()==null)
        return null;
        if (currRow.getText().equals("فعال")) {
        return new FResult("return",new Number(2));
        } else if (currRow.getText().equals("غير فعال")) {
        return new FResult("return",new Number(1));
    }
    return null;
  }

  public FResult dataEntry_penaltyType1Value(){
        PenaltyTypeVoRowImpl currRow =
            (PenaltyTypeVoRowImpl)getPenaltyType_1().first();
    
    if(currRow==null || currRow.getPenaltyStatus()==null)
        return null;
        if (currRow.getPenaltyStatus().equals(new Number(1))) {
        return new FResult("return",new Number(1));
        } else if (currRow.getPenaltyStatus().equals(new Number(2))) {
        return new FResult("return",new Number(2));
    }
    return null;
  }

  public FResult dataEntry_penaltyType2Value(){
        PenaltyTypeVoRowImpl currRow =
            (PenaltyTypeVoRowImpl)getPenaltyType_2().first();
    
    if(currRow==null || currRow.getPenaltyStatus()==null)
        return null;
        if (currRow.getPenaltyStatus().equals(new Number(1))) {
        return new FResult("return",new Number(1));
        } else if (currRow.getPenaltyStatus().equals(new Number(2))) {
        return new FResult("return",new Number(2));
    }
    return null;
  }

  public FResult dataEntry_checkLastToDate() {
        DummyVOImpl dummyVO1 = getDummyVO1();
        CatalogDetailVORowImpl currPrivatePost =
            (CatalogDetailVORowImpl)getCatalogPrivatePostVo().getCurrentRow();
      if(currPrivatePost==null)
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "post_record_not_release".toUpperCase() }),
                                        -1)[0].getAttribute("Message"));
        dummyVO1.setQuery("SELECT TO_DATE  \n" + 
        "					FROM MEMBER_SETUP WHERE ACTIVE=1\n" + 
                "							 AND POST=" + currPrivatePost.getValue() +
                " and labcol=" + getSession().getUserData().get("labcolno"));
        DummyVORowImpl dummy = (DummyVORowImpl)dummyVO1.first();
        if(dummy==null)
            return null;
       Number to_date=null;
        try {
            to_date = new Number( dummy.getDummy());
            if(ParsiUtil.DateToNumber().compareTo(to_date)<=0)
                return new FResult("error",
                                   (String)getMessageVO1().findByKey(new Key(new Object[] { "post_record_not_release".toUpperCase() }),
                                              -1)[0].getAttribute("Message"));
        } catch (SQLException e) {
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "post_record_not_release".toUpperCase() }),
                                          -1)[0].getAttribute("Message"));
        }
      return null;
    }
  
  public FResult dataEntry_catalogPassClass(Number passClassStatus){
        CatalogDetailVORowImpl currRow =
            (CatalogDetailVORowImpl)getCatalogPassClassVo().first();
    
    currRow.setCatArtId(new Number(5));
        if (new Number(1).equals(passClassStatus)) {
      currRow.setText("فعال");
        } else if (new Number(2).equals(passClassStatus)) {
      currRow.setText("غیر فعال");
     }
     
     
      getDBTransaction().commit();
      return null;
      }

  public FResult dataEntry_catalogShelfDelay(Number passClassStatus){
        CatalogDetailVORowImpl currRow =
            (CatalogDetailVORowImpl)getCatalogShelfDelayVo().first();
    
    currRow.setCatArtId(new Number(13));
        if (new Number(1).equals(passClassStatus)) {
      currRow.setText("فعال");
        } else if (new Number(2).equals(passClassStatus)) {
      currRow.setText("غیر فعال");
     }
     
     
      getDBTransaction().commit();
      return null;
      }
 
  public FResult dataEntry_insertMemSetUp(String s)  

  {
        CatalogDetailVORowImpl currCatalog =
            (CatalogDetailVORowImpl)getCatalogPrivatePostVo().getCurrentRow();
        DummyVOImpl dummyVo=getDummyVO1();
        dummyVo.setQuery(" SELECT TO_DATE " + 
        "         FROM MEMBER_SETUP WHERE ACTIVE=1" + 
        "              AND POST="+currCatalog.getValue() +" AND labcol="+ getSession().getUserData().get("labcolno") );
        dummyVo.executeQuery();
        dummyVo.first();
        Number m_release_date =null;
        if (dummyVo.first().getAttribute("Dummy") != null){
           
            m_release_date =
                    ParsiUtil.convert_dec_to_number((BigDecimal)dummyVo.getCurrentRow().getAttribute("Dummy"));
          }
        
        if (m_release_date.compareTo(ParsiUtil.DateToNumber()) >= 0) {
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "post_record_not_release".toUpperCase() }),
                                              -1)[0].getAttribute("Message"));
            }
            

      return null;
      } 
 
    public FResult dataEntry_insertPost(String postName) {
      //
      if(postName==null)
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "ent_post".toUpperCase() }),
                                        -1)[0].getAttribute("Message"));
       // CatalogDetailVORowImpl currCatalog = (CatalogDetailVORowImpl)getCatalogPrivatePostVo().getCurrentRow();

        DummyVOImpl dummyVo=getDummyVO1();
          
          
        dummyVo.setQuery("SELECT MAX(VALUE)   FROM CATALOG_DETAIL WHERE labcol="+  getSession().getUserData().get("labcolno")   +" AND CAT_ART_ID=(SELECT ART_ID FROM CID_LIBRARY_CATALOG " + 
        " WHERE UPPER(CATALOG_NAME)=UPPER('PRIVATE_POST'))");
        dummyVo.executeQuery();
        dummyVo.first();
        
        
          Number MAX_POST =null;
          if (dummyVo.first().getAttribute("Dummy") != null){
           
            MAX_POST =
                    ParsiUtil.convert_dec_to_number((BigDecimal)dummyVo.getCurrentRow().getAttribute("Dummy"));
          }
        MAX_POST =new Number(1).add(MAX_POST );
        CatalogDetailVORowImpl newCatalog =
            (CatalogDetailVORowImpl)getCatalogPrivatePostVo().createRow();
          getCatalogPrivatePostVo().insertRow(newCatalog);
          
          newCatalog.setCatArtId(new Number(281));
          newCatalog.setValue(MAX_POST);
          newCatalog.setLabcol((Number) getSession().getUserData().get("labcolno"));
          newCatalog.setActive(new Number(1));
          newCatalog.setEnglishText(null);
          newCatalog.setText(postName);
          getDBTransaction().commit();
      
        return new FResult("info",
                           (String)getMessageVO1().findByKey(new Key(new Object[] { "save_completed".toUpperCase() }),
                                        -1)[0].getAttribute("Message"));
      }

    private void removeAllVC(ViewObjectImpl vo,ArrayList ignoreVC) {
     System.out.println(vo.getName());
        String[] applyVCNames = vo.getApplyViewCriteriaNames();
        for(String s:applyVCNames) {
            if(ignoreVC!=null && ignoreVC.contains(s))
                continue;
          vo.removeApplyViewCriteriaName(s);
        }
        vo.executeQuery();
    }

    public void removeAllReserveVC() {
      removeAllVC(getReserveVO1(), null);
    }
   
    public void removeAllBookLoanHistoryVC() {
        ArrayList ignr=new ArrayList();
        ignr.add("NullRetDateVC");
      removeAllVC(getBookLoanHistoryVo1(), ignr);
    }

    public void removeAllBookLoanHistory_mVC() {
      removeAllVC(getBookLoanHistoryVo_M(), null);
    }

    public void removeAllVbookPublisherVC() {
      removeAllVC(getVbookPublisherVO1(), null);
    }

    public void removeAllVirtualBookVC() {
      ArrayList ignrList=new ArrayList();
      ignrList.add("LabcolFilterVirtualBookVC");
      removeAllVC(getVirtualBookVO1(), ignrList);
    }

  public void removeAllVBookProviderVC() {
    removeAllVC(getVbookProviderVO1(), null);
  }

  public void removeAllInitMemberVC() {
    removeAllVC(getInitMemberVO1(), null);
  }

    public void removeAllInitMemCurrLibVC() {
    
      removeAllVC(getInitMemberCurrLibVO(), null);
    }

    public void removeAllPersonVC() {
      
        removeAllVC(getPersonVO1(), null);
        
//        clearVOCaches(null, true);
//      getPersonVO1().clearCache();
//      getPersonVO1().executeEmptyRowSet();
    } 
    
    public void removeAllBookBarcodeChangeVC() {
      
        ArrayList ignoreList=new ArrayList();
        ignoreList.add("LabcolVC");
        removeAllVC(getBookBarcodeChange(), ignoreList );
       
    }
    public void removeAllPP_LoanRecords() {
      getPP_LoanVO1().executeEmptyRowSet();
    }

  public void removeAllPhysicalBookVC() {
    
      ArrayList ignoreList=new ArrayList();
      ignoreList.add("LabcolVC");
      removeAllVC(getPhysicalBookVO1(), ignoreList );
     
  }

  public void removeAllMemberBarcodeHistoryVC() {
    removeAllVC(getMemberBarcodeHistory1(), null);
  }

  public void removeAllMemLoanHistoryVC() {
    removeAllVC(getMemLoanHistoryVO(), null);
  }

  public void removeAllPhysicalBook3VC() {
    
      ArrayList ignoreList=new ArrayList();
      ignoreList.add("LabcolVC");
      removeAllVC(getPhysicalBookVO3(), ignoreList );
     
  }

    public void sendEmail(String to,String subject,String body) {
        SendMail sm =
            new SendMail("mojir.s@gmail.com", to, subject, body, "mojir.s@gmail.com",
                         "");
      sm.send();
    }

 public void raf_refreshRafReport(Boolean allPlace) {
     
        Number place =
            (allPlace == true ? null : (Number)getBookPlaceLOV().getCurrentRow().getAttribute("Value"));
   ((RafReportVoImpl)getRafReportVo1()).setp_place(place);
   getRafReportVo1().executeQuery();
 }

 public Number extraCharge_calculateSum(){
     Number result=new Number(0);
        RowSetIterator chargeRI =
            getExtraChargeReportVO().createRowSetIterator("charge");
     while(chargeRI.hasNext()){
            ExtraChargeVORowImpl currROW =
                (ExtraChargeVORowImpl)chargeRI.next();
        
         result= result.add(ParsiUtil.NVL( currROW.getChargeValue()));
         }
       chargeRI.closeRowSetIterator();
//     System.out.println("value is "+result);
     return result;
     }
 
 public FResult persianCataloging_preview_btn(){
        VirtualBookVORowImpl currVirtualBook =
            (VirtualBookVORowImpl)getVirtualBookVO1().getCurrentRow();
        if(currVirtualBook ==null)
     return new FResult("","");
       
       EntityDefImpl bookFarsiCardDef =
           EntityDefImpl.findDefObject("org.parsisys.tehranuniversity.library.model.eo.Card");
       CardImpl bookFarsiCard =
            (CardImpl)bookFarsiCardDef.createInstance2(getDBTransaction(),
                                                       null);

       bookFarsiCard.setCardDate(currVirtualBook.getInsertDate());
       bookFarsiCard.setUserName((String)getSession().getUserData().get("username"));
       bookFarsiCard.setLabcol((Number)(getDBTransaction().getSession().getUserData().get("labcolno")));
       bookFarsiCard.setVbookArtId(currVirtualBook.getArtId());
       bookFarsiCard.setCrdtypeArtId(new Number(1));
       bookFarsiCard.setStatus(new Number(0));
       getDBTransaction().commit();
       
        DatabaseProcedure mcgFarsi =
            DatabaseProcedure.define("FUNCTION parsi_pkg_catalog.MCG_FARSI(CARD_ART_ID NUMBER,BOOK_ART_IDIN NUMBER,ROW_IdIN NUMBER,labcolno number) RETURN VARCHAR2;");
                                                               
       String chjoin =
            (String)mcgFarsi.call(getDBTransaction(), bookFarsiCard.getArtId().getSequenceNumber(),
                                  currVirtualBook.getArtId(), new Number(0),
                                  getSession().getUserData().get("labcolno")).getReturnValue();
       
//       chjoin:=parsi_pkg_catalog.MCG_FARSI(CardId_Var,:VIRTUAL_BOOK.ART_ID,0);
       //UP_TJoin
       

       String fromStr="";
       
       
            fromStr =
                "/reports/rwservlet?" + "utdbuser&destype=cache&report=BOOK_FARSI_CARD.rdf&UP_card_Art_Idf=" +
                bookFarsiCard.getArtId().getSequenceNumber() + "&UP_TJoin=" +
                (chjoin == null ? "" : chjoin) + "&UP_card_Art_Ids=" +
                bookFarsiCard.getArtId().getSequenceNumber() + "&p_day_date=" +
                ParsiUtil.DateToNumber() + "&UP_Vbook_Art_Id=" +
                currVirtualBook.getArtId() + "&UP_PUB_DATE=" +
                currVirtualBook.getPubDate() + "&labcol=" +
                getSession().getUserData().get("labcol");
        
        return new FResult("return", fromStr);
     }
 
 public void print_reserve_list_btn(){
     
     
     }

public FResult book_file_download() {
        PhysicalBookVORowImpl currPhBook =
            (PhysicalBookVORowImpl)getPhysicalBookVO1().getCurrentRow();
  if(currPhBook==null)
            return new FResult("error",
                               "لطفا یکی از نسخه های کتاب را انتخاب کنید.");
  File f=new File(currPhBook.getFileAddress());
  InputStream is=null;
        try {
            is = new FileInputStream(f);
            return new FResult("return",is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new FResult("error","خطا در دانلود فایل.");
        }
    }

 public FResult book_file_upload(InputStream is,String fileName) {
        PhysicalBookVORowImpl currPhBook =
            (PhysicalBookVORowImpl)getPhysicalBookVO1().getCurrentRow();
   if(currPhBook==null)
            return new FResult("error",
                               "لطفا یکی از نسخه های کتاب را انتخاب کنید.");
   
  
          try {
            
          
            new File(baseBookFileDir + "\\" + currPhBook.getLabcol() + "\\" +
                     currPhBook.getVbookArtId() + "\\" +
                     currPhBook.getArtId()).mkdirs();
            OutputStream out =
                new FileOutputStream(new File(baseBookFileDir + "\\" +
                                              currPhBook.getLabcol() + "\\" +
                                              currPhBook.getVbookArtId() +
                                              "\\" + currPhBook.getArtId() +
                                              "\\" + fileName));
  byte[] b=new byte[1024];
              int size=0;
              while((size=is.read(b))!=-1)
                  out.write(b,0,size);
              out.flush();
              out.close();
              is.close();
            currPhBook.setFileAddress(baseBookFileDir + "\\" +
                                      currPhBook.getLabcol() + "\\" +
                                      currPhBook.getVbookArtId() + "\\" +
                                      currPhBook.getArtId() + "\\" + fileName);
            currPhBook.setFileName(fileName);
            getDBTransaction().commit();
            return new FResult("info","فایل با موفقیت ذخیره شد.");
        } catch (IOException e) {
            e.printStackTrace();
            return new FResult("error","خطا در بارگذاری فایل.");
        }
       
   
    }
   
  public FResult raf_upload(InputStream is) {
    InputStreamReader isr=new InputStreamReader(is);
      
    BufferedReader r=new BufferedReader(isr);
        SocialBarcodeViewImpl socialBarcode =
            (SocialBarcodeViewImpl)getSocialBarcodeView1();
        Number labcol =
            new Number((Number)getSession().getUserData().get("labcolno")); // (Number)getSession().getUserData().get("labcolno");
   Row[] rows=null;
   long dupB=0;
   long newB=0;
   long abnormB=0;
   String temp;
        try {
            w:
            while ((temp = r.readLine()) != null) {
              if(ParsiUtil.clearString(temp)==null) {
                  abnormB++;
                continue w;
              }
                rows =
socialBarcode.findByKey(new Key(new Object[] { temp, labcol }), -1);
                if(rows.length>0) {
                    dupB++;
                  continue w;
                }
                newB++;
                SocialBarcodeViewRowImpl newSocBar =
                    (SocialBarcodeViewRowImpl)socialBarcode.createRow();
                socialBarcode.insertRow(newSocBar);
                newSocBar.setBarcode(temp);
                newSocBar.setLabcol(labcol);
            }
   
        } catch (IOException e) {
            e.printStackTrace();
            return new FResult("error","خواندن فایل با مشکل مواجه شد.");
        }
        getDBTransaction().commit();
        return new FResult("return",new long[]{newB,dupB,abnormB});
    }
  

  public void vbook_ranak_insert(Number rank){
        ReturnBookVORowImpl retBook =
            (ReturnBookVORowImpl)getReturnBookVO1().getCurrentRow();
      
        VbookRankVORowImpl rankRow =
            (VbookRankVORowImpl)getVbookRankVO1().createRow();
        getVbookRankVO1().insertRow(rankRow);
        rankRow.setVbookArtId(retBook.getArtId2());
        rankRow.setRank(rank);
        rankRow.setLabcol((Number)getSession().getUserData().get("labcolno"));
        getDBTransaction().commit();
      
      }
 
  public FResult sandoogh_saveFunc(String mode){
      
        PersonVORowImpl currPerson =
            (PersonVORowImpl)getPersonVO1().getCurrentRow();
        if (currPerson == null || currPerson.getBarcode() == null) {
          
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "barcode_not_null".toUpperCase() }),
                                      -1)[0].getAttribute("Message"));
        } 
        InitMemberVORowImpl currInitMem =
            (InitMemberVORowImpl)currPerson.getInitMemberCurrLibVO1();
        PP_CashierVoRowImpl pp_cashierRow =
            (PP_CashierVoRowImpl)getPP_CashierVo1().first();
        
        CashierVoRowImpl currCashier=null ;
        if ("ENTER".equalsIgnoreCase(mode)) {
          if (pp_cashierRow.getKeyNumber() == null ||
              new Number(0).equals(pp_cashierRow.getKeyNumber())) {
              return new FResult("error",
                                 (String)getMessageVO1().findByKey(new Key(new Object[] { "keynumber_not_null".toUpperCase() }),
                                              -1)[0].getAttribute("Message"));
              
              } 
         currCashier=(CashierVoRowImpl) currInitMem.getCashierVo().createRow();
          currInitMem.getCashierVo().insertRow(currCashier);
          //currCashier=(CashierVoRowImpl) getCashierVo1().createRow();
         // getCashierVo1().insertRow(currCashier);
          currCashier.setKeyNumber(pp_cashierRow.getKeyNumber());
          currCashier.setReceiptTime(ParsiUtil.stringTimeToNumber( pp_cashierRow.getReceiptTime()));
          
          currCashier.setCasheType(pp_cashierRow.getCashType());
        } else if ("EXIT".equalsIgnoreCase(mode)) {

                   currCashier =  (CashierVoRowImpl)getCashierVo1().getCurrentRow();
                      }
       
       
        Number returnTime=null;
        if("ENTER".equalsIgnoreCase(mode)){
            DummyVOImpl dummyVo=getDummyVO1();
            dummyVo.setQuery("SELECT * FROM CASHIER WHERE RETURN_DATE IS NULL AND KEY_NUMBER=" +
                             currCashier.getKeyNumber() +
                             "	AND CASHE_TYPE=" +
                             currCashier.getCasheType() +" AND labcol="+ getSession().getUserData().get("labcolno") );
                dummyVo.executeQuery();
                int cnt=dummyVo.getRowCount();
                
            if (cnt > 0 ||
                currCashier.getKeyNumber().compareTo(new Number(999)) == 1 ||
                new Number(1).compareTo(currCashier.getKeyNumber()) == 1) {
                return new FResult("error",
                                   (String)getMessageVO1().findByKey(new Key(new Object[] { "select_another_key".toUpperCase() }),
                                                    -1)[0].getAttribute("Message"));
                    
                    }
                }
        Number late=null;
        if("ENTER".equalsIgnoreCase(mode)){
        currCashier.setMemArtId(currInitMem.getArtId() );
        currCashier.setReceiptDate(ParsiUtil.DateToNumber());
        currCashier.setReceiptUser((String)getSession().getUserData().get("username"));
        currCashier.setLabcol((Number)getSession().getUserData().get("labcolno"));
        } else if ("EXIT".equalsIgnoreCase(mode)) {
              currCashier.setReturnDate(ParsiUtil.DateToNumber());
              currCashier.setReturnUser((String)getSession().getUserData().get("username"));
            returnTime =
                    ParsiUtil.stringTimeToNumber(pp_cashierRow.getReturnTime());
             ((PP_CashierVoRowImpl)getPP_CashierVo1().getCurrentRow()).setReturnTime(ParsiUtil.numberTimeToString( returnTime));
             currCashier.setReturnTime(returnTime);
            late =
new Number(ParsiUtil.daysBetween2Dates(currCashier.getReceiptDate(),
                                       ParsiUtil.DateToNumber()));
            if (ParsiUtil.DateToNumber().compareTo(currCashier.getReceiptDate()) ==
                1) {
                    
                PDate mdate =
                    ParsiUtil.monthAndDayBetweenTwoDate(currCashier.getReceiptDate(),
                                                        ParsiUtil.DateToNumber());
                    //: residence_durity(:CASHIER.RECEIPT_DATE,:person.DAY_date,:PENALTY.DELAY_MONTH,:PENALTY.DELAY_DAY);
                       
                
                        currCashier.setDelayDay(mdate.getDay());
                        currCashier.setDelayMonth(mdate.getMonth());
                currCashier.setHolyWeek(weekend(currCashier.getReceiptDate(),
                                                ParsiUtil.DateToNumber()).add(holiday(currCashier.getReceiptDate(),
                                                                                      ParsiUtil.DateToNumber())));
                         currCashier.setPenalty(late.subtract(currCashier.getHolyWeek()).multiply(new Number(10000)));
                    currCashier.setPenaltyOffer(ParsiUtil.NVL(currCashier.getPenalty()));
                         return new FResult("penaltyPopUp","");
                  }
            }
        if (new Number(1).equals(currPerson.getPersType()) &&
            (Boolean)pakage_variables.get("rasmi_mem_first_loan") == true) {
              MemberVoImpl memberVo=(MemberVoImpl)getMemberVo1();
                MemberVoRowImpl newMember=(MemberVoRowImpl)memberVo.createRow();
                memberVo.insertRow(newMember);
                newMember.setLabcol((Number) getSession().getUserData().get("labcolno"));
                newMember.setDescription("استفاده از صندوق امانت");
                newMember.setArtId((currInitMem.getArtId()));      
            
            }
        getDBTransaction().commit();
       
          getPersonVO1().executeEmptyRowSet();
          getPP_CashierVo1().executeEmptyRowSet();
       
        return new FResult("info",
                           (String)getMessageVO1().findByKey(new Key(new Object[] { "save_completed".toUpperCase() }),
                                 -1)[0].getAttribute("Message"));
    
   
      }


  public FResult sandoogh_penalty(Number penaltyValue,String description){
      if(penaltyValue==null){
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "correct_penalty_value".toUpperCase() }),
                                       -1)[0].getAttribute("Message"));
            
        } else if (new Number(0).compareTo(penaltyValue) == -1) {
            return new FResult("yn_popup",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "returning_key_register_penalty".toUpperCase() }),
                                         -1)[0].getAttribute("Message"));
                   
        } else if (new Number(0).compareTo(penaltyValue) == 1) {
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "correct_penalty_value".toUpperCase() }),
                                         -1)[0].getAttribute("Message"));              
            }
      return null;
  }

    public FResult sandoogh_penalty_yesbtn(Number penaltyValue,
                                           String description) {
        ViewObject vo = getPublicCashPenaltyVO();
        PublicCashPenaltyRowImpl newRec =
            (PublicCashPenaltyRowImpl)vo.createRow();
        vo.insertRow(newRec);

        PersonVORowImpl currPerson =
            (PersonVORowImpl)getPersonVO1().getCurrentRow();
        
        InitMemberVORowImpl currInitMem =
            (InitMemberVORowImpl)currPerson.getInitMemberCurrLibVO1();
        
      
        newRec.setDayDate( ParsiUtil.DateToNumber());
        newRec.setDescription( description);
        newRec.setLabcol((Number)getSession().getUserData().get("labcolno"));
        newRec.setMemArtId( currInitMem.getArtId());
        newRec.setUserName((String)getDBTransaction().getSession().getUserData().get("username"));
        newRec.setValue( penaltyValue);

        Number val =currInitMem.getDebitSum();
        currInitMem.setDebitSum(ParsiUtil.NVL(val).plus(penaltyValue));
       
        if (new Number(1).equals(currPerson.getPersType()) &&
            (Boolean)pakage_variables.get("rasmi_mem_first_loan") == true) {
              MemberVoImpl memberVo=(MemberVoImpl)getMemberVo1();
                MemberVoRowImpl newMember=(MemberVoRowImpl)memberVo.createRow();
                memberVo.insertRow(newMember);
                newMember.setLabcol((Number) getSession().getUserData().get("labcolno"));
                newMember.setDescription("استفاده از صندوق امانت");
                newMember.setArtId((currInitMem.getArtId()));      
            
            }
        getTransaction().commit();        
        return new FResult("info",
                           (String)getMessageVO1().findByKey(new Key(new Object[] { "save_completed".toUpperCase() }),
                                 -1)[0].getAttribute("Message"));
   
      }
  
  public FResult sandoogh_fillForm(){
        CashierListVoRowImpl currRow =
            (CashierListVoRowImpl)getCashierListVo1().getCurrentRow();
     Number currPersonArtId= currRow.getArtId1();
  
     PersonVOImpl persVo= (PersonVOImpl )getPersonVO1();
     persVo.removeApplyViewCriteriaName("search_barcode_id");
     persVo.executeQuery();
    // System.out.println(persVo.getRowCount());
        persVo.findAndSetCurrentRowByKey(new Key(new Object[] { currPersonArtId }),
                                         1);
           
     return null;
      }
  
  public FResult sandoogh_clearForm(){
      
        PersonVOImpl persVo= (PersonVOImpl )getPersonVO1();
        persVo.removeApplyViewCriteriaName("search_barcode_id");
        persVo.executeEmptyRowSet();
        getCashierVo1().executeEmptyRowSet();
        getPP_CashierVo1().executeEmptyRowSet();
        return new FResult("return",true);
      }

  public FResult sandoogh_initPerson(String type){
    //Boolean IS_MEM_OF_CUR_LIB=false;
   pakage_variables.put("rasmi_mem_first_loan",false);
    Boolean exit_after_tasfie=false;  
    CashierListVoRowImpl currCashierList=null;
    CashierVoRowImpl currCashier=null;
    InitMemberVORowImpl currInitMem=null;
    PersonVORowImpl currPerson=null;
    getPP_CashierVo1().executeEmptyRowSet();
        if ("list".equals(type)) {
            currCashierList =
                    (CashierListVoRowImpl)getCashierListVo1().getCurrentRow();
     currCashier = (CashierVoRowImpl)currCashierList.getCashierVo();
     currInitMem = (InitMemberVORowImpl)currCashier.getInitMemberVO();
     currPerson = (PersonVORowImpl)currInitMem.getPersonVO();
        } else i:
        if ("search".equals(type)) {
      currPerson = (PersonVORowImpl)getPersonVO1().getCurrentRow();
      if(currPerson==null)
          break i;
            currInitMem =
                    (InitMemberVORowImpl)currPerson.getInitMemberCurrLibVO1();
      if(currInitMem==null)
          break i;
      currCashier = (CashierVoRowImpl)currInitMem.getCashierVo().first();
    }

    if (currPerson == null || currPerson.getBarcode()==null) {
      return new FResult("error",
                         (String)getMessageVO1().findByKey(new Key(new Object[] { "no_data".toUpperCase() }),
                           -1)[0].getAttribute("Message"));
    }
    DatabaseProcedure PERS_BARCODE_EXIST2 =
        DatabaseProcedure.define("FUNCTION parsi_pkg_library.PERS_BARCODE_EXIST2(P_BARCODE VARCHAR2)RETURN number;");
    BigDecimal PERS_BARCODE_EXIST2_result =
            (BigDecimal)PERS_BARCODE_EXIST2.call(getDBTransaction(),
                                                 currPerson.getBarcode()).getReturnValue();
    
        if (new BigDecimal(0).equals(PERS_BARCODE_EXIST2_result)) {
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "no_data".toUpperCase() }),
                                 -1)[0].getAttribute("Message"));
    }
    if(new Number(2).equals(currPerson.getPersStatus())) {
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "no_loan_no_active".toUpperCase() }),
                                 -1)[0].getAttribute("Message"));
    }
    DatabaseProcedure IS_MEM_OF_LIB2 =
        DatabaseProcedure.define("FUNCTION parsi_pkg_library.IS_MEM_OF_LIB2(P_ART_ID NUMBER,CUR_LIB_ART_ID NUMBER)RETURN NUMBER;");
    BigDecimal IS_MEM_OF_LIB2_result =new BigDecimal (0);
    
        IS_MEM_OF_LIB2_result =
                (BigDecimal)IS_MEM_OF_LIB2.call(getDBTransaction(),
                                                currPerson.getArtId(),
                                                getSession().getUserData().get("libartid")).getReturnValue();
    DummyVOImpl dummyVo=getDummyVO1();
        dummyVo.setQuery("SELECT * FROM CASHIER WHERE MEM_ART_ID=" +
                         currInitMem.getArtId() +
                         " AND RETURN_DATE is null  and labcol=" +
                         getSession().getUserData().get("labcolno"));
    dummyVo.executeQuery();
    int cnt=dummyVo.getRowCount();
    
    if(new Number(2).equals(currInitMem.getMemshipStatus()) && cnt!=0 ){
      exit_after_tasfie=true;
    }
    if(exit_after_tasfie==false){
          if(new Number(1).equals(currPerson.getPersType())) {///rasmi
            if( new Number(1).equals(IS_MEM_OF_LIB2_result)) {
                    if (new Number(3).equals(currInitMem.getMemshipStatus())) {
              JSFUtils.addFacesWarningMessage((String)getMessageVO1().findByKey(new Key(new Object[] { "incomplete_id".toUpperCase() }),
                                        -1)[0].getAttribute("Message"));
                    } else if (!(new Number(1).equals(currInitMem.getMemshipStatus()) ||
                                 new Number(3).equals(currInitMem.getMemshipStatus()))) {
                        return new FResult("error",
                                           "عضو دارای وضعیت " + currInitMem.getMemshipStatusText() +
                                           " نمی تواند از صندوق امانت کتابخانه استفاده نماید.");
            }
            
              DatabaseProcedure has_mem_rec2 =
                  DatabaseProcedure.define("FUNCTION parsi_pkg_library.HAS_MEM_REC2(P_BARCODE VARCHAR2,T_LIB_ART_ID NUMBER,labcol1 number) RETURN number;");
              BigDecimal has_mem_rec2_result =
                        (BigDecimal)has_mem_rec2.call(getDBTransaction(),
                                                      currPerson.getBarcode(),
                                                      getSession().getUserData().get("libartid"),
                                                      getSession().getUserData().get("labcolno")).getReturnValue();
              if(new BigDecimal(0).equals(has_mem_rec2_result)) {
                pakage_variables.put("rasmi_mem_first_loan",true);
                //PV_RASMI_MEM_FIRST_LOAN=true;
              }

            
                } else {
                    if (ParsiUtil.NVL(currInitMem.getMemshipStatus()).intValue() !=
                        0) {
                        return new FResult("error",
                                           "عضو دارای وضعیت " + currInitMem.getMemshipStatusText() +
                                           " نمی تواند از صندوق امانت کتابخانه استفاده نماید.");
                    
                    } else {
  //                    PERS_LIB_ID:=parsi_pkg_library.GET_LIB_ART_ID(:PERSON.ART_ID);
  //                    PERS_LIB_FATHER_ID:=parsi_pkg_library.GET_LIB_FATHER_ART_ID(PERS_LIB_ID);
                 
              DatabaseProcedure is_mem_of_lib2 =
              DatabaseProcedure.define("FUNCTION parsi_pkg_library.IS_MEM_OF_LIB2(P_ART_ID NUMBER,CUR_LIB_ART_ID NUMBER)RETURN NUMBER;");
          BigDecimal is_mem_of_lib2_result =
                            (BigDecimal)is_mem_of_lib2.call(getDBTransaction(),
                                                            currPerson.getArtId(),
                                                            new Number(1)).getReturnValue();
            if(new BigDecimal(0).equals(is_mem_of_lib2_result)) {
                            return new FResult("error",
                                               (String)getMessageVO1().findByKey(new Key(new Object[] { "no_mem_cent_lib".toUpperCase() }),
                                         -1)[0].getAttribute("Message"));
            }else{
                DatabaseProcedure mem_status =
              DatabaseProcedure.define("FUNCTION parsi_pkg_library.MEM_STATUS(P_BARCODE VARCHAR2,T_LIB_ART_ID NUMBER) RETURN NUMBER;");
          BigDecimal mem_status_result =
                                (BigDecimal)mem_status.call(getDBTransaction(),
                                                            currPerson.getBarcode(),
                                                            new Number(1)).getReturnValue();
                            if (!new BigDecimal(1).equals(mem_status_result) &&
                                !new BigDecimal(3).equals(mem_status_result)) {
                                return new FResult("error",
                                                   (String)getMessageVO1().findByKey(new Key(new Object[] { "illegal_mem_in_cent_lib".toUpperCase() }),
                                             -1)[0].getAttribute("Message"));
                }else {
                                return new FResult("error",
                                                   (String)getMessageVO1().findByKey(new Key(new Object[] { "no_mem_lib".toUpperCase() }),
                                              -1)[0].getAttribute("Message"));
                }
            }
                    }                
                }
          }
          
          else//gheire rasmi
          {
              //////////////////////copy
              if( new Number(1).equals(IS_MEM_OF_LIB2_result)) {
                if(new Number(3).equals(currInitMem.getMemshipStatus())) {
                  JSFUtils.addFacesWarningMessage((String)getMessageVO1().findByKey(new Key(new Object[] { "incomplete_id".toUpperCase() }),
                                                    -1)[0].getAttribute("Message"));
                }else if(!new Number(1).equals(currInitMem.getMemshipStatus())) {
                        return new FResult("error",
                                           "عضو دارای وضعیت " + currInitMem.getMemshipStatusText() +
                                           " نمی تواند از صندوق امانت کتابخانه استفاده نماید.");
                }
                
                } else {
                    return new FResult("error",
                                       (String)getMessageVO1().findByKey(new Key(new Object[] { "no_mem_lib".toUpperCase() }),
                                                -1)[0].getAttribute("Message"));                  
                  
                  }
               }
          }
    if(new Number(0).compareTo( currInitMem.getDebitSum())==-1){
        
          JSFUtils.addFacesWarningMessage((String)getMessageVO1().findByKey(new Key(new Object[] { "mem_cash_penalty".toUpperCase() }),
                                            -1)[0].getAttribute("Message"));
        }
    if(new Number(0).compareTo( currInitMem.getDebitSum())==0){
        
          JSFUtils.addFacesWarningMessage((String)getMessageVO1().findByKey(new Key(new Object[] { "mem_non_cash_penalty".toUpperCase() }),
                                            -1)[0].getAttribute("Message"));
        }
        if (new Number(2).equals(currPerson.getPersType()) &&
            ParsiUtil.DateToNumber().compareTo(ParsiUtil.stringDateToNumber(currPerson.getEndDate())) ==
            1) {
        
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "mem_expied".toUpperCase() }),
                                            -1)[0].getAttribute("Message"));
        }
    
        DatabaseProcedure item_text =
            DatabaseProcedure.define("FUNCTION parsi_pkg_catalog.ITEM_TEXT(CAT_NAME VARCHAR2,ITEM_VAL NUMBER,labcol_no number) RETURN VARCHAR2;");
    String item_text_result =
            (String)item_text.call(getDBTransaction(), "CHECK_MEM_PASS_LIB_CLASS",
                                   new Number(1),
                                   getSession().getUserData().get("labcolno")).getReturnValue();
    
    if("فعال".equalsIgnoreCase(item_text_result) ){
            DatabaseProcedure is_first_loan2 =
                DatabaseProcedure.define("FUNCTION parsi_pkg_library.IS_FIRST_LOAN2(P_BARCODE VARCHAR2,CUR_LIB_ART_ID NUMBER, labcol1 number) RETURN Number;");
          BigDecimal is_first_loan2_result =
                (BigDecimal)is_first_loan2.call(getDBTransaction(),
                                                currPerson.getBarcode(),
                                                getSession().getUserData().get("libartid"),
                                                getSession().getUserData().get("labcolno")).getReturnValue();
          if(new BigDecimal(1).equals(is_first_loan2_result))
                return new FResult("yn_popup",
                                   (String)getMessageVO1().findByKey(new Key(new Object[] { "MEM_PASS_COURSE".toUpperCase() }),
                                             -1)[0].getAttribute("Message"));
          
        
        }
    /////////Makhsoos e sandooghe amanat
    Boolean disableExit=true;
    
    if(cnt==0){
        
        pakage_variables.put("cashier_block_status","ENTER");
            PP_CashierVoRowImpl pp_cashierRow =
                (PP_CashierVoRowImpl)getPP_CashierVo1().createRow();
          getPP_CashierVo1().insertRow(pp_cashierRow);
          pp_cashierRow.setReceiptTime(ParsiUtil.numberTimeToString(ParsiUtil.timeToNumber()));
          pp_cashierRow.setCashType(currPerson.getOrigine());
          disableExit=true;
        } else {
          disableExit=false;
            dummyVo.setQuery("SELECT RECEIPT_DATE  FROM CASHIER WHERE MEM_ART_ID=" +
                             currInitMem.getArtId() +
                             " AND RETURN_DATE is null and labcol=" +
                             getSession().getUserData().get("labcolno"));
        dummyVo.executeQuery();
        dummyVo.first();
          Number receipt_date=new Number (0);
          Number late=new Number(0);
          if (dummyVo.getCurrentRow().getAttribute("Dummy") != null) {
                receipt_date =
                        ParsiUtil.convert_dec_to_number((BigDecimal)dummyVo.getCurrentRow().getAttribute("Dummy"));
                late =
new Number(ParsiUtil.daysBetween2Dates(receipt_date, ParsiUtil.DateToNumber()));

          }
            if (late.intValue() > 0) {

                     JSFUtils.addFacesInfoMessage((String)getMessageVO1().findByKey(new Key(new Object[] { "delay_return_key".toUpperCase() }),
                                 -1)[0].getAttribute("Message"));
           }
          pakage_variables.put("cashier_block_status","EXIT");
        
            PP_CashierVoRowImpl pp_cashierRow =
                (PP_CashierVoRowImpl)getPP_CashierVo1().createRow();
          getPP_CashierVo1().insertRow(pp_cashierRow);
        
          //CashierVoRowImpl currCashier = (CashierVoRowImpl)currInitMem. getCashierVo().first();
          pp_cashierRow.setReceiptTime(ParsiUtil.numberTimeToString(currCashier.getReceiptTime()));
         
         
        pp_cashierRow.setReturnTime(ParsiUtil.numberTimeToString(ParsiUtil.timeToNumber()));
          pp_cashierRow.setKeyNumber(currCashier.getKeyNumber() );
        pp_cashierRow.setCashType(currCashier.getCasheType());
          
        }
      return new FResult("return",disableExit);
  }

  public FResult sandoogh_initPerson_popUpYes_btn(String type){
    
   pakage_variables.put("rasmi_mem_first_loan",false);
    Boolean exit_after_tasfie=false;  
    CashierListVoRowImpl currCashierList=null;
    CashierVoRowImpl currCashier=null;
    InitMemberVORowImpl currInitMem=null;
    PersonVORowImpl currPerson=null;
    getPP_CashierVo1().executeEmptyRowSet();
        if ("list".equals(type)) {
            currCashierList =
                    (CashierListVoRowImpl)getCashierListVo1().getCurrentRow();
     currCashier = (CashierVoRowImpl)currCashierList.getCashierVo();
     currInitMem = (InitMemberVORowImpl)currCashier.getInitMemberVO();
     currPerson = (PersonVORowImpl)currInitMem.getPersonVO();
        } else i:
        if ("search".equals(type)) {
      currPerson = (PersonVORowImpl)getPersonVO1().getCurrentRow();
      if(currPerson==null)
          break i;
            currInitMem =
                    (InitMemberVORowImpl)currPerson.getInitMemberCurrLibVO1();
      if(currInitMem==null)
          break i;
      currCashier = (CashierVoRowImpl)currInitMem.getCashierVo().first();
    }

    DummyVOImpl dummyVo=getDummyVO1();
        dummyVo.setQuery("SELECT * FROM CASHIER WHERE MEM_ART_ID=" +
                         currInitMem.getArtId() +
                         " AND RETURN_DATE is null  and labcol=" +
                         getSession().getUserData().get("labcolno"));
    dummyVo.executeQuery();
    int cnt=dummyVo.getRowCount();
    /////////Makhsoos e sandooghe amanat
    Boolean disableExit=true;
    
    if(cnt==0){
        
        pakage_variables.put("cashier_block_status","ENTER");
            PP_CashierVoRowImpl pp_cashierRow =
                (PP_CashierVoRowImpl)getPP_CashierVo1().createRow();
          getPP_CashierVo1().insertRow(pp_cashierRow);
          pp_cashierRow.setReceiptTime(ParsiUtil.numberTimeToString(ParsiUtil.timeToNumber()));
          pp_cashierRow.setCashType(currPerson.getOrigine());
          disableExit=true;
        } else {
          disableExit=false;
            dummyVo.setQuery("SELECT RECEIPT_DATE  FROM CASHIER WHERE MEM_ART_ID=" +
                             currInitMem.getArtId() +
                             " AND RETURN_DATE is null and labcol=" +
                             getSession().getUserData().get("labcolno"));
        dummyVo.executeQuery();
        dummyVo.first();
          Number receipt_date=new Number (0);
          Number late=new Number(0);
          if (dummyVo.getCurrentRow().getAttribute("Dummy") != null) {
                receipt_date =
                        ParsiUtil.convert_dec_to_number((BigDecimal)dummyVo.getCurrentRow().getAttribute("Dummy"));
                late =
new Number(ParsiUtil.daysBetween2Dates(receipt_date, ParsiUtil.DateToNumber()));

          }
            if (late.intValue() > 0) {

                     JSFUtils.addFacesInfoMessage((String)getMessageVO1().findByKey(new Key(new Object[] { "delay_return_key".toUpperCase() }),
                                 -1)[0].getAttribute("Message"));
           }
          pakage_variables.put("cashier_block_status","EXIT");
        
            PP_CashierVoRowImpl pp_cashierRow =
                (PP_CashierVoRowImpl)getPP_CashierVo1().createRow();
          getPP_CashierVo1().insertRow(pp_cashierRow);
        
          //CashierVoRowImpl currCashier = (CashierVoRowImpl)currInitMem. getCashierVo().first();
          pp_cashierRow.setReceiptTime(ParsiUtil.numberTimeToString(currCashier.getReceiptTime()));
         
         
        pp_cashierRow.setReturnTime(ParsiUtil.numberTimeToString(ParsiUtil.timeToNumber()));
          pp_cashierRow.setKeyNumber(currCashier.getKeyNumber() );
        pp_cashierRow.setCashType(currCashier.getCasheType());
          
        }
      return new FResult("return",disableExit);
  }  


public FResult cid_loan_extent_penalty_save() {
  
        LoanVORowImpl currExtent =
            (LoanVORowImpl)getLoanVO_extend_list().getCurrentRow();

  if(ParsiUtil.NVL(currExtent.getpenalty()).longValue()>=0) {
            return new FResult("yn_popup",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "register_penalty".toUpperCase() }),
                               -1)[0].getAttribute("Message"));
  }
  return  new FResult("error","مقدار جریمه باید بزرگتر از صفر باشد.");
}

  public FResult cid_loan_portal_extent_penalty_save() {
    
        LoanVORowImpl currExtent =
            (LoanVORowImpl)getLoanVO_extend_list().getCurrentRow();
CidConstVOImpl cidConstVo = (CidConstVOImpl)getCidConstVO1();
        Row[] r =
            cidConstVo.findByKey(new Key(new Object[] { "portal_max_extend_penalty" }),
                                 -1);
if(r.length>0) {
            if (currExtent.getpenalty().longValue() >
                Long.valueOf((String)r[0].getAttribute("ConstValue"))) {
                return new FResult("error",
                                   "جریمه شما از حداکثر جریمه مجاز (" +
                                   r[0].getAttribute("ConstValue") +
                                   " تومان) بیشتر می باشد. لطفا برای تمدید به کتابخانه مراجعه کنید.");
  }
}else {
            return new FResult("error",
                               "حداکثر مقدار قابل قبول برای جریمه در سیستم تعریف نشده است. لطفا برای تمدید حضورا به کتابخانه مراجعه کنید.");
}
    if(ParsiUtil.NVL(currExtent.getpenalty()).longValue()>=0) {
            return new FResult("yn_popup",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "register_penalty".toUpperCase() }),
                                 -1)[0].getAttribute("Message"));
        } else {
            return new FResult("error",
                               "مقدار جریمه باید بزرگتر از صفر باشد.");
    }
  }

  public FResult cid_loan_extent_penalty_afterPopup_no() {
      
        LoanVORowImpl currExtent =
            (LoanVORowImpl)getLoanVO_extend_list().getCurrentRow();
        currExtent.setpenalty(new Number(0));
        currExtent.setYesOrNo(false);
        
      
      return null;
    
  }
  
 public FResult cid_loan_loanList_loanTypeChanged(Number newLoanType) {
        PP_LoanVORowImpl currLoan =
            (PP_LoanVORowImpl)getPP_LoanVO1().getCurrentRow();
        PhysicalBookVORowImpl currPhbook =
            (PhysicalBookVORowImpl)currLoan.getPhysicalBookVO().first();
   currLoan.setLoanType(newLoanType);
   //System.out.println(currLoan.getLoanType());
   if(new Number(3).equals(currLoan.getLoanType())) {
            pakage_variables.put("place_loan_cap",
                                 ((Number)pakage_variables.get("place_loan_cap")).add(1));
            pakage_variables.put("loan_cap",
                                 ((Number)pakage_variables.get("loan_cap")).subtract(1));
     currLoan.setRetDate(ParsiUtil.numberDateToString(ParsiUtil.DateToNumber()));
   }else if (new Number(1).equals(currLoan.getLoanType())) {
     if(new Number(2).equals(currPhbook.getLoanStatus())) {
       JSFUtils.addFacesWarningMessage((String)getMessageVO1().findByKey(new Key(new Object[] { "only_study_at_lib".toUpperCase() }),
                                        -1)[0].getAttribute("Message"));
       currLoan.setLoanType(new Number(3));
     }else if (new Number(1).equals(currPhbook.getLoanStatus())) {
                pakage_variables.put("place_loan_cap",
                                     ((Number)pakage_variables.get("place_loan_cap")).subtract(1));
                pakage_variables.put("loan_cap",
                                     ((Number)pakage_variables.get("loan_cap")).add(1));
       DatabaseProcedure mem_loan_durity =
           DatabaseProcedure.define(" FUNCTION parsi_pkg_library.MEM_LOAN_DURITY(P_BARCODE VARCHAR2,CUR_LIB_ART_ID NUMBER) RETURN NUMBER;");
       BigDecimal mem_loan_durity_result =
                    (BigDecimal)mem_loan_durity.call(getDBTransaction(),
                                                     ((PersonVORowImpl)getPersonVO1().getCurrentRow()).getBarcode(),
                                                     getSession().getUserData().get("libartid")).getReturnValue();
                currLoan.setRetDate(ParsiUtil.addDayToPersianDate(ParsiUtil.DateToNumber(),
                                                                  mem_loan_durity_result.intValue()));
       
     }
   }
   return null;
 }

 public FResult cid_loan_loanList_chkDuplicate(String barcode) {
    
     
     if(barcode!=null) {
       RowSet loanListVo=getPP_LoanVO1().createRowSet("loanList");
       PP_LoanVORowImpl currLoan=null;
       while(loanListVo.hasNext()) {
         currLoan = (PP_LoanVORowImpl)loanListVo.next();
           if(barcode.equals(currLoan.getPhBookBarcode())) {
             loanListVo.closeRowSet();
                    return new FResult("error",
                                       (String)getMessageVO1().findByKey(new Key(new Object[] { "dup_barcode_for_loan".toUpperCase() }),
                                        -1)[0].getAttribute("Message"));
           }
       }
       loanListVo.closeRowSet();
     }
   
   return null;
 }

  public FResult cid_loan_loanList_yesno_change(boolean newYesNo) {
        PP_LoanVORowImpl currLoanlist =
            (PP_LoanVORowImpl)getPP_LoanVO1().getCurrentRow();
    currLoanlist.setYesNo(newYesNo);
        if (currLoanlist.getYesNo() == true) {
    if(!new Number(1).equals(currLoanlist.getLoanAllowed())) {
      currLoanlist.setYesNo(false);
                return new FResult("error",
                                   (String)getMessageVO1().findByKey(new Key(new Object[] { "no_loan".toUpperCase() }),
                                 -1)[0].getAttribute("Message"));
    }
   }
    return null;
  }
  

  public FResult cid_loan_init_person() {
      //test
    Boolean IS_MEM_OF_CUR_LIB=false;
    Boolean NON_CASH_PENALTY=false;
    Number MEMSHIP_ST=new Number(0);
    Number LOANED_BOOK=new Number(0);
    Number PLACE_LOANED_BOOK=new Number(0);
    Number LOAN_QUOTA=new Number(0);
    Number PLACE_LOAN_QUOTA=new Number(0);
    pakage_variables.put("rasmi_mem_first_loan", false);
    pakage_variables.put("study_at_place", false);
    pakage_variables.put("capacity_is_full", false);
    pakage_variables.put("place_cap_is_full", false);
    pakage_variables.put("loaned_art_id", "");
    pakage_variables.put("previous_barcode_in_list", "");
  //    Boolean PV_RASMI_MEM_FIRST_LOAN=false;
  //    Boolean PV_STUDY_AT_PLACE=false;
  //    Boolean PV_capacity_is_full=false;
  //    Boolean PV_place_cap_is_full=false;
  //    String PV_loaned_art_id="";
  //    String PV_previous_barcode_in_list="";
   
   //Set_Block_Property('LOAN_LIST',INSERT_ALLOWED,PROPERTY_FALSE);
        PersonVORowImpl currPerson =
            (PersonVORowImpl)getPersonVO1().getCurrentRow();
  
    
//    DatabaseProcedure PERS_BARCODE_EXIST2 =
//        DatabaseProcedure.define("FUNCTION parsi_pkg_library.PERS_BARCODE_EXIST2(P_BARCODE VARCHAR2)RETURN number;");
//    BigDecimal PERS_BARCODE_EXIST2_result =
//        (BigDecimal)PERS_BARCODE_EXIST2.call(getDBTransaction(),currPerson.getBarcode()).getReturnValue();
//    
    if(currPerson==null || currPerson.getBarcode()==null ) {
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "no_data".toUpperCase() }),
                                 -1)[0].getAttribute("Message"));
    }
    
     if(new Number(2).equals(currPerson.getPersStatus())) {
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "no_loan_no_active".toUpperCase() }),
                                  -1)[0].getAttribute("Message"));
     }
        InitMemberVORowImpl currInitMem =
            (InitMemberVORowImpl)currPerson.getInitMemberCurrLibVO1();
    DatabaseProcedure IS_MEM_OF_LIB2 =
        DatabaseProcedure.define("FUNCTION parsi_pkg_library.IS_MEM_OF_LIB2(P_ART_ID NUMBER,CUR_LIB_ART_ID NUMBER)RETURN NUMBER;");
    BigDecimal IS_MEM_OF_LIB2_result =
            (BigDecimal)IS_MEM_OF_LIB2.call(getDBTransaction(),
                                            currPerson.getArtId(),
                                            getSession().getUserData().get("libartid")).getReturnValue();
    
    IS_MEM_OF_CUR_LIB=(new BigDecimal(1).equals(IS_MEM_OF_LIB2_result));
    if(new Number(1).equals(currPerson.getPersType())) {///rasmi
      if(IS_MEM_OF_CUR_LIB==true) {
                if (new Number(3).equals(currInitMem.getMemshipStatus())) {
        JSFUtils.addFacesWarningMessage((String)getMessageVO1().findByKey(new Key(new Object[] { "incomplete_id".toUpperCase() }),
                                  -1)[0].getAttribute("Message"));
                } else if (!(new Number(1).equals(currInitMem.getMemshipStatus()) ||
                             new Number(3).equals(currInitMem.getMemshipStatus()))) {
                    return new FResult("error",
                                       "به اعضای دارای وضعیت " + currInitMem.getMemshipStatusText() +
                                       " کتاب امانت داده نمی شود");
      }
        DatabaseProcedure has_mem_rec2 =
            DatabaseProcedure.define("FUNCTION parsi_pkg_library.HAS_MEM_REC2(P_BARCODE VARCHAR2,T_LIB_ART_ID NUMBER,labcol1 number) RETURN number;");
        BigDecimal has_mem_rec2_result =
                    (BigDecimal)has_mem_rec2.call(getDBTransaction(),
                                                  currPerson.getBarcode(),
                                                  getSession().getUserData().get("libartid"),
                                                  getSession().getUserData().get("labcolno")).getReturnValue();
        if(new BigDecimal(0).equals(has_mem_rec2_result)) {
          pakage_variables.put("rasmi_mem_first_loan",true);
          //PV_RASMI_MEM_FIRST_LOAN=true;
        }
                if (new Number(0).compareTo(currInitMem.getMemshipCategory()) <
                    0 &&
                    new Number(5).compareTo(currInitMem.getMemshipCategory()) >
                    0) {
          DatabaseProcedure loan_capacity_full2 =
              DatabaseProcedure.define("FUNCTION parsi_pkg_library.LOAN_CAPACITY_FULL2(p_BARCODE VARCHAR2,CUR_LIB_ART_ID NUMBER,memship_cat number,labcol1 number) RETURN number;");
          BigDecimal loan_capacity_full2_result =
                        (BigDecimal)loan_capacity_full2.call(getDBTransaction(),
                                                             currPerson.getBarcode(),
                                                             getSession().getUserData().get("libartid"),
                                                             currInitMem.getMemshipCategory(),
                                                             getSession().getUserData().get("labcolno")).getReturnValue();
         // PV_capacity_is_full=(new BigDecimal(1).equals(loan_capacity_full2_result));
                    pakage_variables.put("capacity_is_full",
                                         (new BigDecimal(1).equals(loan_capacity_full2_result)));
          
            DatabaseProcedure lib_study_loan_capacity_full2 =
              DatabaseProcedure.define("FUNCTION parsi_pkg_library.LIB_STUDY_LOAN_CAPACITY_FULL2(P_BARCODE VARCHAR2,CUR_LIB_ART_ID NUMBER,memship_cat number) RETURN number;");
          BigDecimal lib_study_loan_capacity_full2_result =
                        (BigDecimal)lib_study_loan_capacity_full2.call(getDBTransaction(),
                                                                       currPerson.getBarcode(),
                                                                       getSession().getUserData().get("libartid"),
                                                                       currInitMem.getMemshipCategory()).getReturnValue();
          
          //PV_place_cap_is_full=(new BigDecimal(1).equals(lib_study_loan_capacity_full2_result));
                    pakage_variables.put("place_cap_is_full",
                                         new BigDecimal(1).equals(lib_study_loan_capacity_full2_result));
                    pakage_variables.put("loan_cap",
                                         currPerson.getLoanRemindCap());
                    pakage_variables.put("place_loan_cap",
                                         currPerson.getLoanAtPlaceRemindCap());
     }
      }else{//is_mem_of_cur_lib
                if (currInitMem != null &&
                    currInitMem.getMemshipStatus() != null) {
                    return new FResult("error",
                                       "به اعضای دارای وضعیت " + currInitMem.getMemshipStatusText() +
                                       " کتاب امانت داده نمی شود");
        }else {
  //          PERS_LIB_ID:=parsi_pkg_library.GET_LIB_ART_ID(:PERSON.ART_ID);
  //          PERS_LIB_FATHER_ID:=parsi_pkg_library.GET_LIB_FATHER_ART_ID(PERS_LIB_ID);
       DatabaseProcedure is_mem_of_lib2 =
              DatabaseProcedure.define("FUNCTION parsi_pkg_library.IS_MEM_OF_LIB2(P_ART_ID NUMBER,CUR_LIB_ART_ID NUMBER)RETURN NUMBER;");
          BigDecimal is_mem_of_lib2_result =
                        (BigDecimal)is_mem_of_lib2.call(getDBTransaction(),
                                                        currPerson.getArtId(),
                                                        new Number(1)).getReturnValue();
            if(new BigDecimal(0).equals(is_mem_of_lib2_result)) {
                        return new FResult("error",
                                           (String)getMessageVO1().findByKey(new Key(new Object[] { "no_mem_cent_lib".toUpperCase() }),
                                         -1)[0].getAttribute("Message"));
            }else{
                DatabaseProcedure mem_status =
              DatabaseProcedure.define("FUNCTION parsi_pkg_library.MEM_STATUS(P_BARCODE VARCHAR2,T_LIB_ART_ID NUMBER) RETURN NUMBER;");
          BigDecimal mem_status_result =
                            (BigDecimal)mem_status.call(getDBTransaction(),
                                                        currPerson.getBarcode(),
                                                        new Number(1)).getReturnValue();
                        if (!new BigDecimal(1).equals(mem_status_result) &&
                            !new BigDecimal(3).equals(mem_status_result)) {
                            return new FResult("error",
                                               (String)getMessageVO1().findByKey(new Key(new Object[] { "illegal_mem_in_cent_lib".toUpperCase() }),
                                             -1)[0].getAttribute("Message"));
                }else {
                            return new FResult("error",
                                               (String)getMessageVO1().findByKey(new Key(new Object[] { "no_mem_lib".toUpperCase() }),
                                              -1)[0].getAttribute("Message"));
                }
           
            }
           }
      }
        } else { ///gheyre rasmi
        if(IS_MEM_OF_CUR_LIB==true) {
          if(new Number(3).equals(currInitMem.getMemshipStatus())) {
            JSFUtils.addFacesWarningMessage((String)getMessageVO1().findByKey(new Key(new Object[] { "incomplete_id".toUpperCase() }),
                                              -1)[0].getAttribute("Message"));
          }else if(!new Number(1).equals(currInitMem.getMemshipStatus())) {
                    return new FResult("error",
                                       "به اعضای دارای وضعیت " + currInitMem.getMemshipStatusText() +
                                       " کتاب امانت داده نمی شود");
          }
          DatabaseProcedure loan_capacity_full2 =
              DatabaseProcedure.define("FUNCTION parsi_pkg_library.LOAN_CAPACITY_FULL2(p_BARCODE VARCHAR2,CUR_LIB_ART_ID NUMBER,memship_cat number,labcol1 number) RETURN number;");
          BigDecimal loan_capacity_full2_result =
                    (BigDecimal)loan_capacity_full2.call(getDBTransaction(),
                                                         currPerson.getBarcode(),
                                                         getSession().getUserData().get("libartid"),
                                                         currInitMem.getMemshipCategory(),
                                                         getSession().getUserData().get("labcolno")).getReturnValue();
          // PV_capacity_is_full=(new BigDecimal(1).equals(loan_capacity_full2_result));
                pakage_variables.put("capacity_is_full",
                                     (new BigDecimal(1).equals(loan_capacity_full2_result)));
          
            DatabaseProcedure lib_study_loan_capacity_full2 =
              DatabaseProcedure.define("FUNCTION parsi_pkg_library.LIB_STUDY_LOAN_CAPACITY_FULL2(P_BARCODE VARCHAR2,CUR_LIB_ART_ID NUMBER,memship_cat number) RETURN number;");
          BigDecimal lib_study_loan_capacity_full2_result =
                    (BigDecimal)lib_study_loan_capacity_full2.call(getDBTransaction(),
                                                                   currPerson.getBarcode(),
                                                                   getSession().getUserData().get("libartid"),
                                                                   currInitMem.getMemshipCategory()).getReturnValue();
          
          //PV_place_cap_is_full=(new BigDecimal(1).equals(lib_study_loan_capacity_full2_result));
                pakage_variables.put("place_cap_is_full",
                                     new BigDecimal(1).equals(lib_study_loan_capacity_full2_result));
                pakage_variables.put("loan_cap",
                                     currPerson.getLoanRemindCap());
                pakage_variables.put("place_loan_cap",
                                     currPerson.getLoanAtPlaceRemindCap());
          
          DatabaseProcedure mem_loan_quota =
            DatabaseProcedure.define("FUNCTION parsi_pkg_library.MEM_LOAN_QUOTA(P_BARCODE VARCHAR2,CUR_LIB_ART_ID NUMBER,memship_cat number) RETURN NUMBER;");
          BigDecimal mem_loan_quota_result =
                    (BigDecimal)mem_loan_quota.call(getDBTransaction(),
                                                    currPerson.getBarcode(),
                                                    getSession().getUserData().get("libartid"),
                                                    currInitMem.getMemshipCategory()).getReturnValue();
          
          
          DatabaseProcedure mem_loan_durity =
            DatabaseProcedure.define("FUNCTION parsi_pkg_library.MEM_LOAN_DURITY(P_BARCODE VARCHAR2,CUR_LIB_ART_ID NUMBER) RETURN NUMBER;");
          BigDecimal mem_loan_durity_result =
                    (BigDecimal)mem_loan_durity.call(getDBTransaction(),
                                                     currPerson.getBarcode(),
                                                     getSession().getUserData().get("libartid")).getReturnValue();
          
                if (new BigDecimal(0).equals(mem_loan_quota_result) &&
                    new BigDecimal(0).equals(mem_loan_durity_result)) {
          pakage_variables.put("study_at_place", true);
        }
        }else{///is_mem_of_cur_lib
                return new FResult("error",
                                   (String)getMessageVO1().findByKey(new Key(new Object[] { "no_mem_lib".toUpperCase() }),
                                              -1)[0].getAttribute("Message"));
        }
        }
   // :PERSON.PENALTY:=parsi_pkg_library.MEM_CASH_PENALTY(:PERSON.BARCODE,:person.lib_art_id); ---> InitMember.DebitSum
        Number penalty =
            (currInitMem == null ? new Number(0) : ParsiUtil.NVL(currInitMem.getDebitSum()));
    if(penalty.intValue()>0) {
      JSFUtils.addFacesWarningMessage((String)getMessageVO1().findByKey(new Key(new Object[] { "mem_cash_penalty".toUpperCase() }),
                                        -1)[0].getAttribute("Message"));
    } 
    DatabaseProcedure mem_non_cash_penalty2 =
            DatabaseProcedure.define("FUNCTION parsi_pkg_library.MEM_NON_CASH_PENALTY2(P_BARCODE VARCHAR2,CUR_LIB_ART_ID NUMBER) RETURN number;");
          BigDecimal mem_non_cash_penalty2_result =
            (BigDecimal)mem_non_cash_penalty2.call(getDBTransaction(),
                                                   currPerson.getBarcode(),
                                                   getSession().getUserData().get("libartid")).getReturnValue();
        
   if(new BigDecimal(1).equals(mem_non_cash_penalty2_result)) {
     JSFUtils.addFacesWarningMessage((String)getMessageVO1().findByKey(new Key(new Object[] { "mem_non_cash_penalty".toUpperCase() }),
                                       -1)[0].getAttribute("Message"));
   }
    //:PERSON.NON_CASH_PENALTY_TEXT:=parsi_pkg_catalog.ITEM_TEXT('DEBIT_NON_CASH',1); ------>initMember.debitNonCashText
        if (new Number(2).equals(currPerson.getPersType()) &&
            ParsiUtil.compareDates(currPerson.getEndDate(),
                                   ParsiUtil.numberDateToString(ParsiUtil.DateToNumber())) <
            0) {
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "mem_expied".toUpperCase() }),
                                         -1)[0].getAttribute("Message"));
   }
    DatabaseProcedure lib_loan_num =
            DatabaseProcedure.define("FUNCTION parsi_pkg_library.LIB_LOAN_NUM(P_BARCODE VARCHAR2,CUR_LIB_ART_ID NUMBER) RETURN NUMBER;");
          BigDecimal lib_loan_num_result =
            (BigDecimal)lib_loan_num.call(getDBTransaction(),
                                          currPerson.getBarcode(),
                                          getSession().getUserData().get("libartid")).getReturnValue();
       
    DatabaseProcedure lib_study_loan_num =
            DatabaseProcedure.define("FUNCTION parsi_pkg_library.LIB_STUDY_LOAN_NUM(P_BARCODE VARCHAR2,CUR_LIB_ART_ID NUMBER) RETURN NUMBER;");
          BigDecimal lib_study_loan_num_result =
            (BigDecimal)lib_study_loan_num.call(getDBTransaction(),
                                                currPerson.getBarcode(),
                                                getSession().getUserData().get("libartid")).getReturnValue();
       
        Number temp1 =
            (lib_loan_num_result == null ? new Number(0) : ParsiUtil.convert_dec_to_number(lib_loan_num_result));
        Number temp2 =
            (lib_study_loan_num_result == null ? new Number(0) : ParsiUtil.convert_dec_to_number(lib_study_loan_num_result));
          
  Number cur_lib_loan_num=temp1.add(temp2);
  if((Boolean)pakage_variables.get("capacity_is_full")==true) {
            if (new Number(1).equals(getSession().getUserData().get("libartid")) &&
                new Number(19).equals(currPerson.getDeptArtId()) &&
                new Number(90).equals(currPerson.getSecArtId()) &&
                new Number(3).equals(currPerson.getPersCategory())) {
      if(new Number(6).compareTo(cur_lib_loan_num)>0) {
        pakage_variables.put("capacity_is_full", false);
      }
      currPerson.setLoanRemindCap(new Number(6).subtract(cur_lib_loan_num));
                pakage_variables.put("loan_cap",
                                     new Number(6).subtract(cur_lib_loan_num));
    }
  }
    if((Boolean)pakage_variables.get("capacity_is_full")==true) {
        if((Boolean)pakage_variables.get("place_cap_is_full")==true){
          if(new Number(0).equals(cur_lib_loan_num)) {
                    return new FResult("error",
                                       (String)getMessageVO1().findByKey(new Key(new Object[] { "sahmieh".toUpperCase() }),
                                                -1)[0].getAttribute("Message"));
            
          }
        }
    }
        DatabaseProcedure item_text =
            DatabaseProcedure.define("FUNCTION parsi_pkg_catalog.ITEM_TEXT(CAT_NAME VARCHAR2,ITEM_VAL NUMBER,labcol_no number) RETURN VARCHAR2;");
    String item_text_result =
            (String)item_text.call(getDBTransaction(), "CHECK_MEM_PASS_LIB_CLASS",
                                   new Number(1),
                                   getSession().getUserData().get("labcolno")).getReturnValue();
    
    if("فعال".equalsIgnoreCase(item_text_result) ){
            DatabaseProcedure is_first_loan2 =
                DatabaseProcedure.define("FUNCTION parsi_pkg_library.IS_FIRST_LOAN2(P_BARCODE VARCHAR2,CUR_LIB_ART_ID NUMBER, labcol1 number) RETURN Number;");
    BigDecimal is_first_loan2_result =
                (BigDecimal)is_first_loan2.call(getDBTransaction(),
                                                currPerson.getBarcode(),
                                                getSession().getUserData().get("libartid"),
                                                getSession().getUserData().get("labcolno")).getReturnValue();
    if(new BigDecimal(1).equals(is_first_loan2_result))
                return new FResult("popup",
                                   (String)getMessageVO1().findByKey(new Key(new Object[] { "MEM_PASS_COURSE".toUpperCase() }),
                                          -1)[0].getAttribute("Message"));
       
    }
        if ((Boolean)pakage_variables.get("capacity_is_full") == false ||
            (Boolean)pakage_variables.get("place_cap_is_full") == false) {
      return new FResult("success",null);
    }else {
            return new FResult("error",
                               "برای این شخص ظرفیت امانت وجود ندارد.");
    }
   
    
  }
  
  public FResult cid_loan_init_person_after_popup() {
        if ((Boolean)pakage_variables.get("capacity_is_full") == false ||
            (Boolean)pakage_variables.get("place_cap_is_full") == false) {
      return new FResult("success",null);
    }else {
            return new FResult("error",
                               "برای این شخص ظرفیت امانت وجود ندارد.");
    }
    
   
  }
  
  public FResult cid_loan_extent_yesno_change(Boolean newYesNo) {
        LoanVORowImpl currExtent =
            (LoanVORowImpl)getLoanVO_extend_list().getCurrentRow();
        PhysicalBookVORowImpl currPhbook =
            (PhysicalBookVORowImpl)currExtent.getPhysicalBookVO();
        PersonVORowImpl currPers =
            (PersonVORowImpl)getPersonVO1().getCurrentRow();
        InitMemberVORowImpl currInitMem =
            (InitMemberVORowImpl)currPers.getInitMemberCurrLibVO1();
    boolean penaltyForm=false;
    currExtent.setYesOrNo(newYesNo);
    
    if(currExtent.getYesOrNo()==true) {
            if (!new Number(1).equals(currPhbook.getExistenceStatus()) &&
                !new Number(2).equals(currPhbook.getExistenceStatus()) &&
                !new Number(8).equals(currPhbook.getExistenceStatus())) {
        currExtent.setYesOrNo(false);
      DatabaseProcedure item_text =
          DatabaseProcedure.define("FUNCTION parsi_pkg_catalog.ITEM_TEXT(CAT_NAME VARCHAR2,ITEM_VAL NUMBER,labcol_no number) RETURN VARCHAR2;");
                                  
      String item_text_result =
          (String)item_text.call(getDBTransaction(),
                                           "Existence_Status",
                                           currPhbook.getExistenceStatus(),
                                           getSession().getUserData().get("labcolno")).getReturnValue();
        
      String existanceStatText=item_text_result;
      
                return new FResult("error",
                                   "كتاب با وضعيت " + existanceStatText +
                                   " نمي تواند امانت داده شود.");
    }
    if(new Number(2).equals(currPhbook.getLoanStatus())) {
      currExtent.setYesOrNo(false);
                return new FResult("error",
                                   (String)getMessageVO1().findByKey(new Key(new Object[] { "impassible_exis_loan_st".toUpperCase() }),
                                 -1)[0].getAttribute("Message"));
    }
    
    DummyVOImpl dummyVo=getDummyVO1();
      dummyVo.setQuery("select art_id from physical_book \n" + 
      "							where vbook_art_id="+currExtent.getVbookArtId() + 
                    "							      and nvl(vol_no,'0')=nvl('" +
                    currExtent.getVolNo() + "','0')\n" +
                    "							      and nvl(part_no,'0')=nvl('" +
                    currExtent.getPartNo() + "','0')\n" +
      "							      and existence_status=1" + 
                    "							      and loan_status=1 and labcol=" +
                    getSession().getUserData().get("labcolno"));
    
    dummyVo.executeQuery();           
    Number cnt_phb =new Number(dummyVo.getRowCount());
    
    dummyVo.setQuery("select art_id from reserve \n" + 
                    "             where vbook_art_id=" +
                    currExtent.getVbookArtId() +
                    "                   and nvl(vol_no,'0')=nvl('" +
                    currExtent.getVolNo() + "','0')\n" +
                    "                   and nvl(part_no,'0')=nvl('" +
                    currExtent.getPartNo() + "','0')\n" +
                    "							      and active=1 and labcol=" +
                    getSession().getUserData().get("labcolno"));
    
    dummyVo.executeQuery();
    Number cnt_reserve =new Number (dummyVo.getRowCount());
    /*Zaheran estefade nashode ast
      dummyVo.setQuery("select count(art_id) into cnt_mem_reserved from reserve \n" + 
      "							where vbook_art_id="+currExtent.getVbookArtId() + 
      "							      and nvl(vol_no,'0')=nvl('"+  currExtent.getVolNo()  +"','0')" + 
      "							      and nvl(part_no,'0')=nvl('"+ currExtent.getPartNo()  +"','0')" +
      "							      and mem_art_id=" +  currInitMem.getArtId()+
      "							      and active IN (1,2)");
      
      dummyVo.executeQuery();
      Number cnt_mem_reserved=new Number(dummyVo.getRowCount());
      
      
      Number mem_reserve_active=new Number(0);
              if(cnt_mem_reserved.intValue()>0){
                  dummyVo.setQuery("select ACTIVE from reserve " + 
                  "         where art_id=(select max(art_id) from reserve" + 
                  "         where vbook_art_id="+currExtent.getVbookArtId()  + 
                  "         and nvl(vol_no,'0')=nvl('"+  currExtent.getVolNo()  +"','0')" + 
                  "         and nvl(part_no,'0')=nvl('"+ currExtent.getPartNo()  +"','0')" + 
                  "         and mem_art_id=" + currInitMem.getArtId() + ")");
                  
                    dummyVo.executeQuery();
                    dummyVo.first();
                    if (dummyVo.getCurrentRow().getAttribute("Dummy") != null) {
                        mem_reserve_active = (Number)dummyVo.getCurrentRow().getAttribute("Dummy");
                    }
                  
                  }*/
    
            if (new Number(0).equals(ParsiUtil.NVL(cnt_phb)) &&
                !new Number(0).equals(ParsiUtil.NVL(cnt_reserve))) {
        currExtent.setYesOrNo(false);
                return new FResult("error",
                                   (String)getMessageVO1().findByKey(new Key(new Object[] { "no_extend_reserved_book".toUpperCase() }),
                                                -1)[0].getAttribute("Message"));
        
        }
      ///calculating delay and penalty
    currExtent.setpenalty(new Number(0));
    dummyVo.setQuery("SELECT penalty_status " + 
    "							FROM penalty_type " + 
                             "							WHERE book_type=" +
                             currExtent.getLoanStatus() + " and labcol=" +
                             getSession().getUserData().get("labcolno"));
    
    Number T_penalty_status=new Number (2);
    
      dummyVo.executeQuery();
              dummyVo.first();
      
              if (dummyVo.getCurrentRow().getAttribute("Dummy") != null) {
                T_penalty_status =
                        ParsiUtil.convert_dec_to_number((BigDecimal)dummyVo.getCurrentRow().getAttribute("Dummy"));
              }
              
              if(new Number(1).equals(T_penalty_status)){
                if (ParsiUtil.DateToNumber().compareTo(currExtent.getRetDate()) >
                    0) {
                  
                    DatabaseProcedure delayPenalty =
                        DatabaseProcedure.define("FUNCTION parsi_pkg_library.LOAN_DELAY_PENALTY(loan_art_id NUMBER,day_date number, labcol_num NUMBER) RETURN NUMBER;");
                    BigDecimal delayPenalty_result =
                        (BigDecimal)delayPenalty.call(getDBTransaction(),
                                                      currExtent.getArtId().getSequenceNumber(),
                                                      ParsiUtil.DateToNumber(),
                                                      (Number)getSession().getUserData().get("labcolno")).getReturnValue();

                  currExtent.setpenalty(ParsiUtil.convert_dec_to_number(delayPenalty_result));
//                    
                    PDate parsiDate =
                        ParsiUtil.monthAndDayBetweenTwoDate(currExtent.getRetDate(),
                                                            ParsiUtil.DateToNumber());
                  currExtent.setDelayDay(parsiDate.getDay());
                  currExtent.setDelayMonth(parsiDate.getMonth());
                    currExtent.setHolyWeek(weekend(currExtent.getRetDate(),
                                                   ParsiUtil.DateToNumber()).add(holiday(currExtent.getRetDate(),
                                                                                         ParsiUtil.DateToNumber())));
                  
                  
                  }
              
              else{
                  
                    currExtent.setpenalty(new Number(0));                  
                  currExtent.setDelayDay(new Number(0));
                  currExtent.setDelayMonth(new Number(0));
                      
                  }
              currExtent.setPenaltyOffer(ParsiUtil.NVL(currExtent.getpenalty()));
             
             
              if(ParsiUtil.NVL(currExtent.getpenalty()).intValue()!= 0 ){
                  
                 // JSFUtils.addFacesWarningMessage("این کتاب "+ currExtent.getpenalty()+" تومان جریمه دیر کرد دارد");
//      message "no_extend_book_has_penalty" peyda nemishavad             
// JSFUtils.addFacesWarningMessage((String)getMessageVO1().findByKey(new Key(new Object[] { "no_extend_book_has_penalty".toUpperCase() }),
//                                      -1)[0].getAttribute("Message"));
                    penaltyForm=true;
                  }
        }
      DatabaseProcedure mem_loan_durity =
          DatabaseProcedure.define("FUNCTION parsi_pkg_library.MEM_LOAN_DURITY(P_BARCODE VARCHAR2,CUR_LIB_ART_ID NUMBER) RETURN NUMBER;");
                                  
      BigDecimal mem_loan_durity_result =
          (BigDecimal)mem_loan_durity.call(getDBTransaction(),
                                                 currPers.getBarcode(),
                                                 (Number)getSession().getUserData().get("libartid")).getReturnValue();
      
            currExtent.setnextRetDate(ParsiUtil.addDayToPersianDate(ParsiUtil.DateToNumber(),
                                                                    mem_loan_durity_result.intValue()));
        } else {
        currExtent.setnextRetDate(null);
      
    }
    if(penaltyForm==true)
        return new FResult("penalty form",null);
    else
        return null;
  }
  
  
    public FResult cid_loan_initBook() {
          PersonVORowImpl currPers =
              (PersonVORowImpl)getPersonVO1().getCurrentRow();
          if(currPers==null) {
            return new FResult("error","ابتدا یک فرد را جستجو نمایید.");
          }
        PhysicalBookVORowImpl currPhbook =
            (PhysicalBookVORowImpl)getPhysicalBookVO3().getCurrentRow();
        PP_LoanVORowImpl currLoan =
            (PP_LoanVORowImpl)getPP_LoanVO1().getCurrentRow();
        if (currPhbook == null || currPhbook.getBarcode() == null) {
          currLoan.setLoanAllowed(new Number(0));
          currLoan.setLabcol(null);
          currLoan.setLoanType(null);
          currLoan.setPhBookBarcode(null);
          currLoan.setPhbookArtId(null);
          currLoan.setVbookTitle(null);
          currLoan.setProvider(null);
          currLoan.setRetDate(null);
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "barcode_not_null".toUpperCase() }),
                                      -1)[0].getAttribute("Message"));
        }
        FResult fr=cid_loan_loanList_chkDuplicate(currPhbook.getBarcode());
        if(fr!=null) {
          currLoan.setLabcol(null);
          currLoan.setLoanType(null);
          currLoan.setPhBookBarcode(null);
          currLoan.setPhbookArtId(null);
          currLoan.setVbookTitle(null);
          currLoan.setProvider(null);
          currLoan.setRetDate(null);
          return fr;
        }
        VirtualBookVORowImpl currVbook =
            (VirtualBookVORowImpl)currPhbook.getVirtualBookVO();
        
        currLoan.setLoanAllowed(new Number(1));
        currLoan.setPhbookArtId(currPhbook.getArtId());
        currLoan.setPhBookBarcode(currPhbook.getBarcode());
        currLoan.setVbookTitle(currPhbook.getTitle());
        currLoan.setProvider(currVbook.getProviderName());
        
        InitMemberVORowImpl currInitMem =
            (InitMemberVORowImpl)currPers.getInitMemberCurrLibVO1();
       
        
          DummyVOImpl dummyVO1 = getDummyVO1();

        
        dummyVO1.setQuery("select phbook_art_id from loan" + 
        "   where phbook_art_id =" +currPhbook.getArtId() + 
        "  	and real_ret_date is null" + 
                          "		and MEM_ART_ID =" +
                          currInitMem.getArtId());
        
        
          dummyVO1.executeQuery();
          
          
        if (dummyVO1.hasNext()) {
            currLoan.setLabcol(null);
            currLoan.setLoanType(null);
            currLoan.setPhBookBarcode(null);
            currLoan.setPhbookArtId(null);
            currLoan.setVbookTitle(null);
            currLoan.setProvider(null);
            currLoan.setRetDate(null);
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "sel_book_above_extend".toUpperCase() }),
                                        -1)[0].getAttribute("Message"));
          }
          
            
        if (!(new Number(1).equals(currPhbook.getExistenceStatus()) ||
              new Number(8).equals(currPhbook.getExistenceStatus()))) {
              
      DatabaseProcedure item_text =
          DatabaseProcedure.define("FUNCTION parsi_pkg_catalog.ITEM_TEXT(CAT_NAME VARCHAR2,ITEM_VAL NUMBER,labcol_no number) RETURN VARCHAR2;");
                                  
      String item_text_result =
                (String)item_text.call(getDBTransaction(), "Existence_Status",
                                       currPhbook.getExistenceStatus(),
                                       getSession().getUserData().get("labcolno")).getReturnValue();
        
      String existanceStatText=item_text_result;
        currLoan.setLoanAllowed(new Number(0));
      currLoan.setLabcol(null);
      currLoan.setLoanType(null);
      currLoan.setPhBookBarcode(null);
      currLoan.setPhbookArtId(null);
      currLoan.setVbookTitle(null);
      currLoan.setProvider(null);
      currLoan.setRetDate(null);
            return new FResult("error",
                               "کتاب با وضعیت " + existanceStatText + " نمیتواند امانت داده شود.");
    }
    
        if (new Number(2).equals(currPhbook.getLoanStatus())) {
      currLoan.setLabcol(null);
      currLoan.setLoanType(null);
      currLoan.setPhBookBarcode(null);
      currLoan.setPhbookArtId(null);
      currLoan.setVbookTitle(null);
      currLoan.setProvider(null);
      currLoan.setRetDate(null);
            return new FResult("yn_popup",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "study_at_lib1".toUpperCase() }),
                                      -1)[0].getAttribute("Message"));
    }
    
    
        return cid_loan_initBook_popUpYesbtn(false);
        }
    
    public FResult cid_loan_initBook_popUpNobtn() {
        PP_LoanVORowImpl currLoan =
            (PP_LoanVORowImpl)getPP_LoanVO1().getCurrentRow();
        currLoan.setLoanAllowed(new Number(0));
        return null;
          
        }

  public FResult cid_loan_initBook_popUpYesbtn(boolean isYesBtn) {
     
     
        PhysicalBookVORowImpl currPhBook =
            (PhysicalBookVORowImpl)getPhysicalBookVO3().getCurrentRow();
        PersonVORowImpl currPers =
            (PersonVORowImpl)getPersonVO1().getCurrentRow();
        InitMemberVORowImpl currInitMem =
            (InitMemberVORowImpl)currPers.getInitMemberCurrLibVO1();
        PP_LoanVORowImpl currLoan =
            (PP_LoanVORowImpl)getPP_LoanVO1().getCurrentRow();
        if (isYesBtn == true) {
     
      currLoan.setLoanType(new Number(3));
      currLoan.setRetDate(ParsiUtil.numberDateToString(ParsiUtil.DateToNumber()));
        currLoan.setLoanAllowed(new Number(1));
      }
        
        DummyVOImpl dummyVO1 = getDummyVO1();

//        dummyVO1.setQuery("select count(art_id) from physical_book " + 
//        "			where vbook_art_id="+currPhBook.getVbookArtId() + 
//        "			and nvl(vol_no,'0')=nvl('"+ currPhBook.getVolNo() +"','0')" + 
//        "			and nvl(part_no,'0')=nvl('" + currPhBook.getPartNo() + "','0')" + 
//        "			and existence_status=1 and loan_status=1");
//        
//        dummyVO1.executeQuery();
//        dummyVO1.first();
//        
//        int cnt_phb=0;
//        if (dummyVO1.getCurrentRow().getAttribute("Dummy") != null) {
//            cnt_phb =
//                    Integer.valueOf(dummyVO1.getCurrentRow().getAttribute("Dummy").toString());
//        }
        
        
//        dummyVO1.setQuery("	select count(art_id) from reserve " + 
//        "			where vbook_art_id="+currPhBook.getVbookArtId() + 
//        "			      and nvl(vol_no,'0')=nvl('" +  currPhBook.getVolNo()  + "','0')\n" + 
//        "			      and nvl(part_no,'0')=nvl('" + currPhBook.getPartNo() + "','0')\n" + 
//        "			      and active=1");
//        
//        
//        dummyVO1.executeQuery();
//        dummyVO1.first();
//        int cnt_reserve=0;
//        if (dummyVO1.getCurrentRow().getAttribute("Dummy") != null) {
//            cnt_reserve =
//                    Integer.valueOf(dummyVO1.getCurrentRow().getAttribute("Dummy").toString());
//        }
      
        dummyVO1.setQuery(" select art_id from reserve \n" + 
        "     where vbook_art_id="+currPhBook.getVbookArtId() + 
                "           and nvl(vol_no,'0')='" +
               ParsiUtil.stringToZeroValue(currPhBook.getVolNo()) + "'" +
                "           and nvl(part_no,'0')='" +
               ParsiUtil.stringToZeroValue( currPhBook.getPartNo()) + "'" +
        "           and mem_art_id="+ currInitMem.getArtId() +
        "           and active IN (1,2) and labcol="+getSession().getUserData().get("labcolno"));  
        
        dummyVO1.executeQuery();
        Boolean is_mem_reserved=dummyVO1.hasNext();
       
Number mem_reserve_active=null;
        if(is_mem_reserved){
            dummyVO1.setQuery("select ACTIVE from reserve " + 
            "					where art_id=(select max(art_id) from reserve" + 
                              "			  	where vbook_art_id=" +
                              currPhBook.getVbookArtId() +
                              "			    and nvl(vol_no,'0')='" +
                              ParsiUtil.stringToZeroValue(currPhBook.getVolNo()) + "'" +
                              "			    and nvl(part_no,'0')='" +
                             ParsiUtil.stringToZeroValue( currPhBook.getPartNo() )+ "'" +
                              "			    and mem_art_id=" +
                              currInitMem.getArtId() + " and labcol="+ getSession().getUserData().get("labcolno")+") and labcol="+getSession().getUserData().get("labcolno"));
            
              dummyVO1.executeQuery();
             Row r= dummyVO1.first();
              if (r!=null && r.getAttribute("Dummy") != null) {
                mem_reserve_active =
                        ParsiUtil.convert_dec_to_number((BigDecimal)r.getAttribute("Dummy"));
              }
            
            }
        
        dummyVO1.setQuery("select phbook_art_id " + 
                          "      from loan where phbook_art_id =" +
                          currPhBook.getArtId() +
                          " and real_ret_date is null and labcol="+getSession().getUserData().get("labcolno"));
        
      dummyVO1.executeQuery();
      
        
        if(dummyVO1.hasNext()){            
              currLoan.setLoanAllowed(new Number(0));
              currLoan.setLabcol(null);
              currLoan.setLoanType(null);
              currLoan.setPhBookBarcode(null);
              currLoan.setPhbookArtId(null);
              currLoan.setVbookTitle(null);
              currLoan.setProvider(null);
              currLoan.setRetDate(null);
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "no_barcode_return".toUpperCase() }),
                                        -1)[0].getAttribute("Message"));            
            
            }
        
        if(is_mem_reserved){
            if(new Number(2).equals(mem_reserve_active)){
                if(new Number(8).equals(currPhBook.getExistenceStatus()))
                    JSFUtils.addFacesWarningMessage((String)getMessageVO1().findByKey(new Key(new Object[] { "allocate_reserve_book".toUpperCase() }),
                                                -1)[0].getAttribute("Message"));
                  currLoan.setAlloc(new Number(1)); 
            } else if (new Number(1).equals(mem_reserve_active)) {
                  currLoan.setLoanAllowed(new Number(0));
                  currLoan.setLabcol(null);
                  currLoan.setLoanType(null);
                  currLoan.setPhBookBarcode(null);
                  currLoan.setPhbookArtId(null);
                  currLoan.setVbookTitle(null);
                  currLoan.setProvider(null);
                  currLoan.setRetDate(null);
                return new FResult("error",
                                   (String)getMessageVO1().findByKey(new Key(new Object[] { "no_order".toUpperCase() }),
                                                -1)[0].getAttribute("Message"));            
                
                }
            
            
        } else {
            
            if(new Number(8).equals(currPhBook.getExistenceStatus())){
                  currLoan.setLoanAllowed(new Number(0));
                  currLoan.setLabcol(null);
                  currLoan.setLoanType(null);
                  currLoan.setPhBookBarcode(null);
                  currLoan.setPhbookArtId(null);
                  currLoan.setVbookTitle(null);
                  currLoan.setProvider(null);
                  currLoan.setRetDate(null);
                return new FResult("error",
                                   (String)getMessageVO1().findByKey(new Key(new Object[] { "no_loan_reserved_book".toUpperCase() }),
                                                                -1)[0].getAttribute("Message"));            
                }
            }
        Number loan_cap=(Number) pakage_variables.get("loan_cap");
        if(loan_cap!=null && loan_cap.longValue()>0){
            if(new Number(1).equals(currPhBook.getLoanStatus())){
                currLoan.setLoanType(new Number(1));
//                  PERSON.MEM_LOAN_DURITY:=parsi_pkg_library.mem_loan_durity(:person.BARCODE,:PERSON.LIB_ART_ID);
          DatabaseProcedure mem_loan_durity =
              DatabaseProcedure.define("FUNCTION parsi_pkg_library.MEM_LOAN_DURITY(P_BARCODE VARCHAR2,CUR_LIB_ART_ID NUMBER) RETURN NUMBER;");
                                      
          BigDecimal mem_loan_durity_result =
              (BigDecimal)mem_loan_durity.call(getDBTransaction(),
                                                     currPers.getBarcode(),
                                                     (Number)getSession().getUserData().get("libartid")).getReturnValue();
               

                currLoan.setRetDate(ParsiUtil.addDayToPersianDate(ParsiUtil.DateToNumber(),
                                                                  mem_loan_durity_result.intValue()));
                
            pakage_variables.put("loan_cap",loan_cap.subtract(1));
            
            }
            
        } else {
            Number place_loan_cap =
                (Number)pakage_variables.get("place_loan_cap");
            if(place_loan_cap!=null && place_loan_cap.longValue()>0){
            currLoan.setLoanType(new Number(3));
            currLoan.setRetDate(ParsiUtil.numberDateToString(ParsiUtil.DateToNumber()));
                pakage_variables.put("place_loan_cap",
                                     place_loan_cap.subtract(1));
            } else {
                JSFUtils.addFacesWarningMessage((String)getMessageVO1().findByKey(new Key(new Object[] { "sahmieh".toUpperCase() }),
                                                -1)[0].getAttribute("Message"));
  }

        }
        if(new Number(1).equals(currLoan.getLoanAllowed()))
            currLoan.setYesNo(true);
        
            currLoan.setPhbookArtId(currPhBook.getArtId());
            currLoan.setLabcol((Number)getSession().getUserData().get("labcolno"));
            return null;
      }
  

  public FResult cid_loan_loanFunc(){
         pakage_variables.remove("loaned_art_id");
          Number tempRetDate=new Number(0);
        PersonVORowImpl currPers =
            (PersonVORowImpl)getPersonVO1().getCurrentRow();
        InitMemberVORowImpl currInitMem =
            (InitMemberVORowImpl)currPers.getInitMemberCurrLibVO1();

        if (new Number(1).equals(currPers.getPersType()) &&
            (Boolean)pakage_variables.get("rasmi_mem_first_loan") == true) {
                pakage_variables.put("rasmi_mem_first_loan",new Boolean(false));
              MemberVoImpl memberVo=(MemberVoImpl)getMemberVo1();
                MemberVoRowImpl newMember=(MemberVoRowImpl)memberVo.createRow();
                memberVo.insertRow(newMember);
                newMember.setLabcol((Number) getSession().getUserData().get("labcolno"));
                newMember.setDescription(null);
                newMember.setArtId((currInitMem.getArtId()));
              
              }  
         
    RowSet loanlist= getPP_LoanVO1().createRowSet("loanList");
    while(loanlist.hasNext()){
    PP_LoanVORowImpl currLoan=(PP_LoanVORowImpl)loanlist.next();
            if (new Number(1).equals(currLoan.getYesNo()) &&
                new Number(1).equals(currLoan.getLoanAllowed()) &&
                currLoan.getPhbookArtId() != null) {
            pakage_variables.put("insert_flag", true);
                if (new Number(3).equals(currLoan.getLoanType())) {
              tempRetDate=ParsiUtil.DateToNumber();
                } else {
                
                  DatabaseProcedure mem_loan_durity =
                      DatabaseProcedure.define("FUNCTION parsi_pkg_library.MEM_LOAN_DURITY(P_BARCODE VARCHAR2,CUR_LIB_ART_ID NUMBER) RETURN NUMBER;");
                                              
                  BigDecimal mem_loan_durity_result =
                      (BigDecimal)mem_loan_durity.call(getDBTransaction(),
                                                         currPers.getBarcode(),
                                                         (Number)getSession().getUserData().get("libartid")).getReturnValue();
                    tempRetDate =
                            ParsiUtil.stringDateToNumber(ParsiUtil.addDayToPersianDate(ParsiUtil.DateToNumber(),
                                                                                       mem_loan_durity_result.intValue()));

                
                }
                SequenceImpl si =
                    new SequenceImpl("seq_loan_art_id", getDBTransaction());
              Number temp_art_id=si.getSequenceNumber();
                  
          
                LoanVORowImpl newLoan =
                    (LoanVORowImpl)getLoanVO_loan_list().createRow();
              getLoanVO_loan_list().insertRow(newLoan);
              newLoan.setLoanDate(ParsiUtil.DateToNumber());
              newLoan.setRetDate(tempRetDate);
              newLoan.setRealRetDate(null);
              newLoan.setMemArtId(currInitMem.getArtId());
              newLoan.setArtId(new DBSequence( temp_art_id));
              newLoan.setPhbookArtId(currLoan.getPhbookArtId());
              newLoan.setReturnUser(null);                                                                                 
              newLoan.setLoanUser((String)(getSession().getUserData().get("username")));
              newLoan.setLoanType(currLoan.getLoanType());
              newLoan.setReturnType(new Number(1));
              newLoan.setLabcol((Number)getSession().getUserData().get("labcolno"));
             
                PhysicalBookVORowImpl currPhBook =
                    (PhysicalBookVORowImpl)currLoan.getPhysicalBookVO().next();
              currPhBook.setExistenceStatus(new Number(2));
              currPhBook.setStatusChangeDate(ParsiUtil.DateToNumber());
              currPhBook.setStatusChangeUser((String)getSession().getUserData().get("username"));
             
                if (pakage_variables.get("loaned_art_id") == null) {
              ArrayList<ReportItems> arr=new ArrayList<ReportItems>();
                    arr.add(new ReportItems(temp_art_id,
                                            currPhBook.getBarcode()));
                  pakage_variables.put("loaned_art_id",arr);
              }else {
                    ((ArrayList<ReportItems>)pakage_variables.get("loaned_art_id")).add(new ReportItems(temp_art_id,
                                                                                                        currPhBook.getBarcode()));
              }
              
              EntityDefImpl bookStHstDef =
                  EntityDefImpl.findDefObject("org.parsisys.tehranuniversity.library.model.eo.BookStatusHistory");
              BookStatusHistoryImpl bookStHist =
                  (BookStatusHistoryImpl)bookStHstDef.createInstance2(getDBTransaction(),
                                                                      null);

              bookStHist.setDayDate(ParsiUtil.DateToNumber());
              bookStHist.setLoanStatus(currPhBook.getLoanStatus());
              bookStHist.setSafetyStatus(currPhBook.getSafetyStatus());
              bookStHist.setExistenceStatus(currPhBook.getExistenceStatus());
              bookStHist.setPlace(currPhBook.getPlace());
              bookStHist.setPhbookArtId(currPhBook.getArtId());
              bookStHist.setUserName((String)getSession().getUserData().get("username"));
              bookStHist.setLabcol((Number)(getDBTransaction().getSession().getUserData().get("labcolno")));
            
              if(new Number(1).equals(currLoan.getAlloc())){
                    DummyVOImpl dummyVO1 = getDummyVO1();
                    Number reserve_art_id =null;
                    dummyVO1.setQuery("	SELECT art_id from reserve \n" + 
                            " where vbook_art_id=" +
                            currPhBook.getVbookArtId() +
                            " and nvl(vol_no,'0')='" +
                           ParsiUtil.stringToZeroValue( currPhBook.getVolNo()) + "' " +
                            " and nvl(part_no,'0')='" +
                           ParsiUtil.stringToZeroValue( currPhBook.getPartNo()) + "'" +
                    " and mem_art_id="+ currInitMem.getArtId() + 
                    " and active=2	and labcol="+getSession().getUserData().get("labcolno"));
                    dummyVO1.executeQuery();
                    Row r=dummyVO1.first();
                    if (r!=null && r.getAttribute("Dummy") != null) {
                        reserve_art_id =
                                ParsiUtil.convert_dec_to_number((BigDecimal)r.getAttribute("Dummy"));
                        
                        
                        String plsql =
                            "update reserve set active=4  where art_id=" +
                            reserve_art_id.toString()+" and labcol="+getSession().getUserData().get("labcolno");
//                          
                      DBTransaction trans = getDBTransaction();
                      CallableStatement statement = null;
                      statement = trans.createCallableStatement(plsql, 0);


                        try {
                            statement.execute();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }finally {
                          try {
                              if (statement != null)
                                  statement.close();

                          } catch (SQLException s) { /* ignore */
                             s.printStackTrace();
                          }
                        
                      }
                    }    
                    
                  }
              
              
            }
      
    }
    loanlist.closeRowSet();
    getDBTransaction().commit();
  return null;
  }
 

  public FResult cid_loan_extendFunc(){
        PersonVORowImpl currPers =
            (PersonVORowImpl)getPersonVO1().getCurrentRow();
        InitMemberVORowImpl currInitMem =
            (InitMemberVORowImpl)currPers.getInitMemberCurrLibVO1();


    RowSet loanlist= getLoanVO_extend_list().createRowSet("loan");
    while(loanlist.hasNext()){
    LoanVORowImpl currLoan=(LoanVORowImpl)loanlist.next();
      
      if(new Number(1).equals(currLoan.getYesOrNo())){
          pakage_variables.put("insert_flag", true);
        //update loan set real_ret_date=:PERSON.DAY_DATE,RETURN_USER=:PERSON.USER_NAME where art_id=:EXTEND_LIST.art_id;
          currLoan.setRealRetDate(ParsiUtil.DateToNumber());
          currLoan.setReturnUser((String)getSession().getUserData().get("username"));
          //=-=-=-=-=-=-=-=-=-=-
         // getDBTransaction().commit();
          if(ParsiUtil.NVL(currLoan.getpenalty()).longValue()>0){
              
        EntityDefImpl loanCashPenaltyDef =
            EntityDefImpl.findDefObject("org.parsisys.tehranuniversity.library.model.eo.LoanCashPenalty");
        LoanCashPenaltyImpl loanCashPenalty =
            (LoanCashPenaltyImpl)loanCashPenaltyDef.createInstance2(getDBTransaction(),
                                                                    null);
       
        loanCashPenalty.setValue(currLoan.getpenalty());
        loanCashPenalty.setDayDate(ParsiUtil.DateToNumber());
        loanCashPenalty.setDescription(currLoan.getpenaltyDescription());
        loanCashPenalty.setLoanArtId(currLoan.getArtId().getSequenceNumber());
        loanCashPenalty.setUserName((String)getSession().getUserData().get("username"));
        loanCashPenalty.setLoanPenaltyType(new Number(1));
        loanCashPenalty.setLabcol((Number)(getSession().getUserData().get("labcolno")));
          }
          
          
              //=-=-=-=-=-=-=-=-=-=-
            //  getDBTransaction().commit();
        
        DatabaseProcedure mem_loan_durity =
            DatabaseProcedure.define("FUNCTION parsi_pkg_library.MEM_LOAN_DURITY(P_BARCODE VARCHAR2,CUR_LIB_ART_ID NUMBER) RETURN NUMBER;");
                                    
        BigDecimal mem_loan_durity_result =
            (BigDecimal)mem_loan_durity.call(getDBTransaction(),
                                                     currPers.getBarcode(),
                                                     (Number)getSession().getUserData().get("libartid")).getReturnValue();
                Number nextRetDate =
                    ParsiUtil.stringDateToNumber(ParsiUtil.addDayToPersianDate(ParsiUtil.DateToNumber(),
                                                                               mem_loan_durity_result.intValue()));

                SequenceImpl si =
                    new SequenceImpl("seq_loan_art_id", getDBTransaction());
        Number temp_art_id=si.getSequenceNumber();
                LoanVORowImpl newLoan =
                    (LoanVORowImpl)getLoanVO_loan_list().createRow();
          getLoanVO_loan_list().insertRow(newLoan);
          newLoan.setLoanDate(ParsiUtil.DateToNumber());
          newLoan.setRetDate(nextRetDate);
          newLoan.setRealRetDate(null);
          newLoan.setMemArtId(currInitMem.getArtId());
          newLoan.setArtId(new DBSequence(temp_art_id));
          newLoan.setPhbookArtId(currLoan.getPhbookArtId());
          newLoan.setReturnUser(null);                                                                                 
          newLoan.setLoanUser((String)(getSession().getUserData().get("username")));
          newLoan.setLoanType(new Number(2));
          newLoan.setReturnType(new Number(1));
          newLoan.setLabcol((Number)(getSession().getUserData().get("labcolno")));
          
              //=-=-=-=-=-=-=-=-=-=-
           //   getDBTransaction().commit();
              EntityDefImpl bookStHstDef =
                  EntityDefImpl.findDefObject("org.parsisys.tehranuniversity.library.model.eo.BookStatusHistory");
              BookStatusHistoryImpl bookStHist =
                  (BookStatusHistoryImpl)bookStHstDef.createInstance2(getDBTransaction(),
                                                                      null);
                PhysicalBookVORowImpl currPhBook =
                    (PhysicalBookVORowImpl)currLoan.getPhysicalBookVO();
              bookStHist.setDayDate(currPhBook.getStatusChangeDate());
              bookStHist.setLoanStatus(currPhBook.getLoanStatus());
              bookStHist.setSafetyStatus(currPhBook.getSafetyStatus());
              bookStHist.setExistenceStatus(currPhBook.getExistenceStatus());
              bookStHist.setPlace(currPhBook.getPlace());
              bookStHist.setPhbookArtId(currPhBook.getArtId());
              bookStHist.setUserName(currPhBook.getStatusChangeUser());
              bookStHist.setLabcol((Number)(getDBTransaction().getSession().getUserData().get("labcolno")));
              
              //=-=-=-=-=-=-=-=-=-=-
             // getDBTransaction().commit();
                currPhBook.setStatusChangeDate(ParsiUtil.DateToNumber());
                currPhBook.setStatusChangeUser((String)getSession().getUserData().get("username"));
        
          
            }
        
    }
    loanlist.closeRowSet();
getDBTransaction().commit();
      return null;
  }
  
  public FResult cid_loan_saveFunc(){
      pakage_variables.put("insert_flag", false);
        Number countLoanType1=new Number(0);      
        Number countLoanType3=new Number(0); 
        PersonVORowImpl currPers =
            (PersonVORowImpl)getPersonVO1().getCurrentRow();
       
        
        if (currPers == null || currPers.getBarcode() == null) {
          
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "barcode_not_null".toUpperCase() }),
                                      -1)[0].getAttribute("Message"));
        } 
        InitMemberVORowImpl currInitMem =
            (InitMemberVORowImpl)currPers.getInitMemberCurrLibVO1();
        
        RowSet extendList= getLoanVO_extend_list().createRowSet("extendList");
        while(extendList.hasNext()){
        LoanVORowImpl currExtend=(LoanVORowImpl)extendList.next();
        
            if (new Boolean(true).equals(currExtend.getYesOrNo()) &&
                new Number(3).equals(currExtend.getLoanType())) {
                  countLoanType1.add(1) ;
                }
        }//ExtendList While Loop
        extendList.closeRowSet();
          RowSet loanlist= getPP_LoanVO1().createRowSet("loan");
        PP_LoanVORowImpl currLoan=null;
          while(loanlist.hasNext()){
          currLoan=(PP_LoanVORowImpl)loanlist.next();
            
              if(currLoan.getYesNo()==true){
                  
                  if(new Number(1).equals(currLoan.getLoanType())){
                    if (currLoan.getPhbookArtId() != null) {
                           countLoanType1= countLoanType1.add(1) ;

                    } else {
                          currLoan.setYesNo(false);
                          }
                      
                } else if (new Number(3).equals(currLoan.getLoanType())) {
                    if (currLoan.getPhbookArtId() != null) {
                         countLoanType3= countLoanType3.add(1) ;
                    } else {
                            currLoan.setYesNo(false);
                        }
                  
                } else {
                      if(currLoan.getPhbookArtId()!=null ){
                      currLoan.setLoanType(new Number(1));
                      countLoanType1=  countLoanType1.add(1) ;
                      
                    } else {
                        currLoan.setYesNo(false);
                                            }
                  }
          }///main if   
          }/// Loan while List Loop
          loanlist.closeRowSet();
        if ((currPers.getLoanRemindCap().subtract(countLoanType1)).intValue() <
            0 ||
            (currPers.getLoanAtPlaceRemindCap().subtract(countLoanType3)).intValue() <
            0) {
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "attention_remind_cap".toUpperCase() }),
                                           -1)[0].getAttribute("Message"));
              }
        
        
        cid_loan_extendFunc();
        cid_loan_loanFunc();
        if(new Boolean(true).equals(pakage_variables.get("insert_flag"))){

                            DummyVOImpl dummyVo=getDummyVO1();
            dummyVo.setQuery("SELECT * FROM LOAN WHERE MEM_ART_ID=" +
                             currInitMem.getArtId() +
                            " AND REAL_RET_DATE IS NULL AND LOAN_TYPE IN (1,2)");
            dummyVo.executeQuery();
              Number loan_count=new Number(dummyVo.getRowCount());
            
            dummyVo.setQuery("SELECT * FROM LOAN WHERE MEM_ART_ID=" +
                             currInitMem.getArtId() +
        " AND REAL_RET_DATE IS NULL AND LOAN_TYPE=3");                          
                          
              dummyVo.executeQuery();
              Number place_loan_count=new Number(dummyVo.getRowCount());
              
              
              dummyVo.setQuery("SELECT * from reserve \n" + 
                    "					where mem_art_id=" +
                    currInitMem.getArtId() +
                    " AND ACTIVE IN(1,2)");
                       
              dummyVo.executeQuery();                                       
              Number mem_reserve_count=new Number(dummyVo.getRowCount());
                       
            dummyVo.setQuery("SELECT * FROM INTRODUCTION_LETTER WHERE MEM_ART_ID=" +
                             currInitMem.getArtId() +
              " and	CANCELLATION_USER IS NULL AND CANCEL_DATE IS NULL ");                       
              dummyVo.executeQuery();                                       
              Number intro_letter_count=new Number(dummyVo.getRowCount());
              
              dummyVo.setQuery("SELECT SUM(VALUE)  FROM  penalty_payment \n" + 
                    "					WHERE mem_art_id=" +
                    currInitMem.getArtId());
              dummyVo.executeQuery();                                       
              dummyVo.first();
              Number total_mem_payment=new Number(0);
              if (dummyVo.getCurrentRow().getAttribute("Dummy") != null) {
                total_mem_payment =
                        ParsiUtil.convert_dec_to_number((BigDecimal)dummyVo.getCurrentRow().getAttribute("Dummy"));
              }   
              dummyVo.setQuery("SELECT SUM(VALUE) FROM  loan_cash_penalty \n" + 
                    "					WHERE LOAN_ART_ID in (SELECT art_id FROM loan WHERE mem_art_id=" +
                    currInitMem.getArtId() + ")");
              
              dummyVo.executeQuery();                                       
              dummyVo.first();
              
              Number loan_penalty=new Number(0);
              if (dummyVo.getCurrentRow().getAttribute("Dummy") != null) {
                loan_penalty =
                        ParsiUtil.convert_dec_to_number((BigDecimal)dummyVo.getCurrentRow().getAttribute("Dummy"));
              }
              dummyVo.setQuery("SELECT SUM(VALUE)  FROM  public_cash_penalty \n" + 
                    "	WHERE MEM_ART_ID=" +
                    currInitMem.getArtId());
              
              dummyVo.executeQuery();                                       
              dummyVo.first();
              Number public_penalty=new Number(0);
              if (dummyVo.getCurrentRow().getAttribute("Dummy") != null) {
                public_penalty =
                        ParsiUtil.convert_dec_to_number((BigDecimal)dummyVo.getCurrentRow().getAttribute("Dummy"));
              }
              
              Number totalPenalty=loan_penalty.add(public_penalty);
              
              currInitMem.setLoanedCount(loan_count);
              currInitMem.setLoanedInPlaceCount(place_loan_count);
              currInitMem.setReservedCount(mem_reserve_count);
              currInitMem.setIntroductionLetterCount(intro_letter_count);
              currInitMem.setDebitSum(totalPenalty.subtract(total_mem_payment));
       
       getDBTransaction().commit();
       pakage_variables.put("insert_flag", false);
       JSFUtils.addFacesInfoMessage((String)getMessageVO1().findByKey(new Key(new Object[] { "save_completed".toUpperCase() }),
                                           -1)[0].getAttribute("Message"));
        } else {
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "no_change".toUpperCase() }),
                                         -1)[0].getAttribute("Message"));
            }
       
//        RowSet extendList2= getLoanVO_extend_list().createRowSet("loan");
//        while(extendList2.hasNext()){
//        LoanVORowImpl currExtend=(LoanVORowImpl)extendList2.next();
//        
//            if( currExtend.getYesOrNo() && new Number(3).equals(currExtend.getLoanType()) )
//            {}
//            
//        }
     

        ArrayList<ReportItems> reportList =
            (ArrayList<ReportItems>)pakage_variables.get("loaned_art_id");
        reportList =
                (reportList == null ? new ArrayList<ReportItems>() : reportList);
        RowSet PrintExtendList =
            getLoanVO_extend_list().createRowSet("extendList");
        
        while(PrintExtendList.hasNext()){
            LoanVORowImpl currPrintExtend =
                (LoanVORowImpl)PrintExtendList.next();
            if (new Boolean(true).equals(currPrintExtend.getYesOrNo())) {
                reportList.add(new ReportItems(currPrintExtend.getArtId().getSequenceNumber(),
                                               currPrintExtend.getBarcode()));
        }
        }
        PrintExtendList.closeRowSet();
        
       
        getLoanVO_extend_list().executeQuery();
        getPP_LoanVO1().executeEmptyRowSet();
      
        return new FResult("return",reportList);
      }
  
  
    public FResult change_person_save() {
        PersonVORowImpl currPerson =
            (PersonVORowImpl)getPersonVO1().getCurrentRow();
        currPerson.setFname(ParsiUtil.clearString(currPerson.getFname()));
        if(currPerson.getFname()==null) {
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "FNAME_not_null".toUpperCase() }),
                                     -1)[0].getAttribute("Message"));
        }
      currPerson.setLname(ParsiUtil.clearString(currPerson.getLname()));
      if(currPerson.getLname()==null) {
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "LNAME_not_null".toUpperCase() }),
                                   -1)[0].getAttribute("Message"));
      }
       if(new Number(1).equals(currPerson.getPersType())) {
         if(currPerson.getPersCategory()==null) {
                return new FResult("error",
                                   (String)getMessageVO1().findByKey(new Key(new Object[] { "category_not_null".toUpperCase() }),
                                      -1)[0].getAttribute("Message"));
         }
            if (currPerson.getDegree() == null &&
                new Number(1).equals(currPerson.getPersCategory())) {
                return new FResult("error",
                                   (String)getMessageVO1().findByKey(new Key(new Object[] { "degree_not_null".toUpperCase() }),
                                      -1)[0].getAttribute("Message"));
         }
         currPerson.setId(ParsiUtil.clearString(currPerson.getId()));
         if(currPerson.getId()==null) {
                return new FResult("error",
                                   (String)getMessageVO1().findByKey(new Key(new Object[] { "ID_not_null".toUpperCase() }),
                                      -1)[0].getAttribute("Message"));
         }
       }
       PersonImpl person_impl=currPerson.getPerson();
    
       if(!ParsiUtil.NVL(currPerson.getSecArtId()).equals(ParsiUtil.NVL((Number)person_impl.getPostedAttribute2(person_impl.SECARTID)))){
       DatabaseProcedure sec_lib_art_id =
           DatabaseProcedure.define("FUNCTION parsi_pkg_library.SEC_LIB_ART_ID(SEC_ART_ID NUMBER)RETURN NUMBER;");
       BigDecimal sec_lib_art_id_result =
                (BigDecimal)sec_lib_art_id.call(getDBTransaction(),
                                                person_impl.getPostedAttribute2(person_impl.SECARTID)).getReturnValue();
            Number cur_sec_lib_id =
                ParsiUtil.convert_dec_to_number(sec_lib_art_id_result);
       BigDecimal new_sec_lib_art_id_result =
                (BigDecimal)sec_lib_art_id.call(getDBTransaction(),
                                                currPerson.getSecArtId()).getReturnValue();
            Number new_cur_sec_lib_id =
                ParsiUtil.convert_dec_to_number(new_sec_lib_art_id_result);
       if(!ParsiUtil.NVL(cur_sec_lib_id).equals(ParsiUtil.NVL(new_cur_sec_lib_id))) {
                DatabaseProcedure is_mem_of_lib =
                    DatabaseProcedure.define("FUNCTION parsi_pkg_library.IS_MEM_OF_LIB2(P_ART_ID NUMBER,CUR_LIB_ART_ID NUMBER)RETURN NUMBER;");
                BigDecimal is_mem_of_lib_result =
                    (BigDecimal)is_mem_of_lib.call(getDBTransaction(),
                                                   currPerson.getArtId(),
                                                   cur_sec_lib_id).getReturnValue();
                boolean valid_mem =
                    new BigDecimal(1).equals(is_mem_of_lib_result);
         if(valid_mem==true) {
                    DatabaseProcedure get_lib_name =
                        DatabaseProcedure.define("FUNCTION parsi_pkg_library.GET_LIB_NAME(T_LIB_ART_ID NUMBER)RETURN VARCHAR2;");
                    String get_lib_name_result =
                        (String)get_lib_name.call(getDBTransaction(),
                                                  cur_sec_lib_id).getReturnValue();
                    return new FResult("error",
                                       "این شخص در کتابخانه گروه " + get_lib_name_result +
                                       " عضو است.");
         }
       }
      
     }
      currPerson.setBarcode(ParsiUtil.clearString(currPerson.getBarcode()));
//      if(!currPerson.getBarcode().equalsIgnoreCase((String)person_impl.getPostedAttribute2(person_impl.BARCODE)))
//      {
//      if(dupPersBarcode(currPerson.getBarcode())) {
//      
//          return new FResult("error","بارکد شخص تکراری است. یک بارکد دیگر وارد نمایید.");
//        
//      }
//      }
        if (!ParsiUtil.StNVL(ParsiUtil.clearString((String)person_impl.getPostedAttribute2(person_impl.BARCODE)),
                             "0").equals(ParsiUtil.StNVL(currPerson.getBarcode(),
                                                         "0"))) {
        if(dupPersBarcode(currPerson.getBarcode())) {
        
                return new FResult("error",
                                   "بارکد شخص تکراری است. یک بارکد دیگر وارد نمایید.");
          
        }
          DummyVOImpl dummyVo=getDummyVO1();
          dummyVo.setQuery("SELECT * FROM member_barcode_history \n" + 
                    "WHERE PERS_ART_ID=" +
                    currPerson.getArtId());
          dummyVo.executeQuery();
          if(dummyVo.hasNext()) {
                MemberBarcodeHistoryVORowImpl newMemBarcHis =
                    (MemberBarcodeHistoryVORowImpl)currPerson.getMemberBarcodeHistory().createRow();
               currPerson.getMemberBarcodeHistory().insertRow(newMemBarcHis);
               newMemBarcHis.setPersArtId(currPerson.getArtId());
               newMemBarcHis.setDayDate(ParsiUtil.DateToNumber());
               newMemBarcHis.setBarcode(currPerson.getBarcode());
               newMemBarcHis.setUserName((String)getSession().getUserData().get("username"));
            }
      }
      if(new Number(1).equals(currPerson.getPersType())) {
        if(new Number(1).equals(currPerson.getPersCategory())) {
          if(currPerson.getMjrArtId()==null) {
                    return new FResult("error",
                                       (String)getMessageVO1().findByKey(new Key(new Object[] { "mjr_not_null".toUpperCase() }),
                                       -1)[0].getAttribute("Message"));
          }
        }else {
          if(currPerson.getMjrArtId()!=null) {
              currPerson.setMjrArtId(null);
              
        }
      }
      }else {
        currPerson.setCmemsetupArtId(null);
          currPerson.setPersCategory(null);
          currPerson.setDegree(null);
          currPerson.setMjrArtId(null);
          currPerson.setSecArtId(null);
          currPerson.setDeptArtId(null);
      }
      if(currPerson.getInitMemberCurrLibVO1()!=null) {
            DatabaseProcedure mem_post =
                DatabaseProcedure.define("FUNCTION parsi_pkg_library.MEM_POST(P_ART_ID NUMBER,CUR_LIB_ART_ID NUMBER,labcol_no number) RETURN NUMBER;");
            BigDecimal mem_post_result =
                (BigDecimal)mem_post.call(getDBTransaction(),
                                          currPerson.getArtId(),
                                          getSession().getUserData().get("libartid"),
                                          getSession().getUserData().get("labcolno")).getReturnValue();
            Number saved_cmemsetuppost =
                ParsiUtil.convert_dec_to_number(mem_post_result);
            if (new Number(2).equals(currPerson.getPersType()) &&
                !ParsiUtil.NVL(currPerson.getCmemSetupPost()).equals(ParsiUtil.NVL(saved_cmemsetuppost))) {
          currPerson.setCmemsetupArtId(null);
          currPerson.setEndDate(currPerson.getNewEndDate()); 
          
                DatabaseProcedure active_post_art_id =
                    DatabaseProcedure.define("FUNCTION parsi_pkg_library.ACTIVE_POST_ART_ID(POST_CODE NUMBER,labcol_no number)RETURN NUMBER;");
                BigDecimal active_post_art_id_result =
                    (BigDecimal)active_post_art_id.call(getDBTransaction(),
                                                        currPerson.getCmemSetupPost(),
                                                        getSession().getUserData().get("labcolno")).getReturnValue();
                Number mem_setup_art_id =
                    ParsiUtil.convert_dec_to_number(active_post_art_id_result);
                MemberExtensionHistoryRowImpl newMemExtHist =
                    (MemberExtensionHistoryRowImpl)((InitMemberVORowImpl)currPerson.getInitMemberCurrLibVO1()).getMemberExtensionHistory().createRow();
          ((InitMemberVORowImpl) currPerson.getInitMemberCurrLibVO1()).getMemberExtensionHistory().insertRow(newMemExtHist);
          newMemExtHist.setInsertDate(ParsiUtil.DateToNumber());
          newMemExtHist.setRecType(new Number(2));
          newMemExtHist.setMemsetupArtId(mem_setup_art_id);
          newMemExtHist.setMemArtId(((InitMemberVORowImpl)currPerson.getInitMemberCurrLibVO1()).getArtId());
          newMemExtHist.setUserName((String)getSession().getUserData().get("username"));
          newMemExtHist.setLabcol((Number)getSession().getUserData().get("labcolno"));
         
        }
      }
      getDBTransaction().commit();
        return new FResult("info",
                           (String)getMessageVO1().findByKey(new Key(new Object[] { "save_completed".toUpperCase() }),
                                 -1)[0].getAttribute("Message"));
     
    }
    
   public void change_person_role_back() {
        ViewObjectImpl personVO = getPersonVO1();
     Row currPerson = personVO.getCurrentRow();
        getDBTransaction().rollback();
    // personVO.executeEmptyRowSet();
        personVO.findAndSetCurrentRowByKey(new Key(new Object[] { currPerson.getAttribute("ArtId") }),
                                           1);
   }
    
    public FResult change_person_cmemsetuppost_change(Number newValue) {
    
        PersonVORowImpl currPerson =
            (PersonVORowImpl)getPersonVO1().getCurrentRow();
     // currPerson.setCmemSetupPost((Number)currPerson.getpostLOV().getCurrentRow().getAttribute("Value"));
      
            currPerson.setCmemSetupPost(newValue);
        
        DummyVOImpl dummy=getDummyVO1();
        if (new Number(1).equals(currPerson.getPersType())) {
      if(new Number(3).equals(currPerson.getPersStatus())) {
        dummy.setQuery("SELECT MAX(ART_ID) " + 
                               "FROM CID_MEMBER_SETUP WHERE POST=" +
                               currPerson.getCmemSetupPost() + " " +
        "AND ACTIVE=1");
        dummy.executeQuery();
        if(dummy.hasNext()) {
         currPerson.setCmemsetupArtId(ParsiUtil.convert_dec_to_number((BigDecimal)dummy.next().getAttribute("Dummy")));
        
        }else {
          return new FResult("err","dont change");
        }
      }else {
        return new FResult("err","dont change");
      }
      }else if(new Number(2).equals(currPerson.getPersType())) {
        DatabaseProcedure item_text =
            DatabaseProcedure.define("FUNCTION parsi_pkg_catalog.ITEM_TEXT(CAT_NAME VARCHAR2,ITEM_VAL NUMBER,labcol_no number) RETURN VARCHAR2;");
        String item_text_result =
                (String)item_text.call(getDBTransaction(), "PRIVATE_POST",
                                       currPerson.getCmemSetupPost(),
                                       getSession().getUserData().get("labcolno")).getReturnValue();
            if (currPerson.getEndDate() != null &&
                ParsiUtil.compareDates(currPerson.getEndDate(),
                                       ParsiUtil.DateToNumber().toString()) <=
                0) {
                return new FResult("error",
                                   (String)getMessageVO1().findByKey(new Key(new Object[] { "post_change_with_extend".toUpperCase() }),
                                     -1)[0].getAttribute("Message"));
        }

if(currPerson.getNewEndDate()==null) {
                return new FResult("error",
                                   "دوره اعتبار سمت " + item_text_result +
                                   " به سیستم معرفی نشده است.");
}

            if (ParsiUtil.compareDates(currPerson.getNewEndDate(),
                                       ParsiUtil.DateToNumber().toString()) <=
                0) {
                return new FResult("error",
                                   "دوره اعتبار سمت " + item_text_result +
                                   " منقضی شده است.");
        }
        /*
        PKG_VARIABLE.CHANGE_POST0:=FALSE;      
        IF (NVL(:PERSON.SAVED_CMEMSETUP_POST0,'0')!=NVL(:PERSON.CMEMSETUP_POST0,'0')) THEN
            PKG_VARIABLE.CHANGE_POST0:=TRUE;
        END IF;
         */
      }
      return null;
    }
    
   public FResult change_person_init_post() {
        PersonVORowImpl currPerson =
            (PersonVORowImpl)getPersonVO1().getCurrentRow();
     if(new Number(1).equals(currPerson.getPersType())) {
       currPerson.setCmemSetupPost(currPerson.getCmemsetupArtId());
     }else if(new Number(2).equals(currPerson.getPersType())) {
       DatabaseProcedure mem_post =
           DatabaseProcedure.define("FUNCTION parsi_pkg_library.MEM_POST(P_ART_ID NUMBER,CUR_LIB_ART_ID NUMBER,labcol_no number) RETURN NUMBER;");
       BigDecimal mem_post_result =
           (BigDecimal)mem_post.call(getDBTransaction(),
                                          currPerson.getArtId(),
                                          (Number)getSession().getUserData().get("libartid"),
                                          (Number)getSession().getUserData().get("labcolno")).getReturnValue();
      
       currPerson.setCmemSetupPost(ParsiUtil.convert_dec_to_number(mem_post_result));

     }
     
     return null;
   }

    public FResult change_person_prepare_fields() {
        Map<String,Boolean> attributesMap=new HashMap<String, Boolean>();
        final String fname="fname";
        final String lname="lname";
        final String certificate_no="certificate_no";
        final String origine="origine";
        final String affiliation="affiliation";
      final String id="id";
      final String pers_category="pers_category";
      final String dept="dept";
      final String sec="sec";
      final String mjr="mjr";
      final String load_img="load_img";
      final String degree="degree";
      final String pers_type="pers_type";
      final String pers_status="pers_status";
      final String cmemsetup_post="cmemsetup_post";
      
        PersonVORowImpl currPerson =
            (PersonVORowImpl)getPersonVO1().getCurrentRow();
        attributesMap.put(fname, true);
        attributesMap.put(lname, true);
        attributesMap.put(certificate_no,true);
        attributesMap.put(origine, true);
      attributesMap.put(affiliation, true);
      attributesMap.put(id, true);
      attributesMap.put(pers_category, true);
      attributesMap.put(dept, true);
      attributesMap.put(sec, true);
      attributesMap.put(mjr, true);
      attributesMap.put(load_img, true);
      attributesMap.put(degree, true);
      attributesMap.put(cmemsetup_post, true);
      
      
      if(new Number(2).equals(currPerson.getPersType())) {
        attributesMap.put(cmemsetup_post, true);
        attributesMap.put(id, false);
        attributesMap.put(pers_category, false);
        attributesMap.put(dept, false);
        attributesMap.put(sec, false);
        attributesMap.put(mjr, false);
        attributesMap.put(degree, false);
      }
      if(new Number(1).equals(currPerson.getPersType())) {
            if (new Number(2).equals(currPerson.getPersCategory()) ||
                new Number(3).equals(currPerson.getPersCategory())) {
          attributesMap.put(degree, false);
          attributesMap.put(mjr, false);
        }
      }
        DatabaseProcedure is_local_lib =
            DatabaseProcedure.define(" FUNCTION parsi_pkg_library.IS_LOCAL_LIB2(P_ART_ID NUMBER,CUR_LIB_ART_ID NUMBER)RETURN NUMBER;");
        BigDecimal is_local_lib_result =
            (BigDecimal)is_local_lib.call(getDBTransaction(),
                                          currPerson.getArtId(),
                                          getSession().getUserData().get("libartid")).getReturnValue();
      boolean valid_loc=(new BigDecimal(1).equals(is_local_lib_result));
      
        DatabaseProcedure is_mem_of_lib =
            DatabaseProcedure.define("FUNCTION parsi_pkg_library.IS_MEM_OF_LIB2(P_ART_ID NUMBER,CUR_LIB_ART_ID NUMBER)RETURN NUMBER;");
        BigDecimal is_mem_of_lib_result =
            (BigDecimal)is_mem_of_lib.call(getDBTransaction(),
                                           currPerson.getArtId(),
                                           getSession().getUserData().get("libartid")).getReturnValue();
      boolean valid_mem=new BigDecimal(1).equals(is_mem_of_lib_result);
      
      
      attributesMap.put(pers_type, false);
      attributesMap.put(pers_status, false);
        if (valid_mem == false && valid_loc == false) {
      attributesMap.put(fname, false);
      attributesMap.put(lname, false);
      attributesMap.put(certificate_no, false);
      attributesMap.put(origine, false);
      attributesMap.put(affiliation, false);
      attributesMap.put(id, false);
        attributesMap.put(pers_category, false);
        attributesMap.put(dept, false);
        attributesMap.put(sec, false);
        attributesMap.put(mjr, false);
        attributesMap.put(load_img, false);
        attributesMap.put(cmemsetup_post, false);
        attributesMap.put(degree, false);
      }else {
        if(new Number(2).equals(currPerson.getPersType())) {
          attributesMap.put(fname, true);
          attributesMap.put(lname, true);
          attributesMap.put(certificate_no, true);
          attributesMap.put(origine, true);
          attributesMap.put(affiliation, true);
          attributesMap.put(load_img, true);
        }else {
                if (new Number(3).equals(currPerson.getPersStatus()) &&
                    valid_loc == true) {
            attributesMap.put(cmemsetup_post, true);
            attributesMap.put(fname, true);
            attributesMap.put(lname, true);
            attributesMap.put(certificate_no, true);
            attributesMap.put(origine, true);
            attributesMap.put(affiliation, true);
            attributesMap.put(id, true);
            attributesMap.put(pers_category, true);
            attributesMap.put(dept, false);
            attributesMap.put(load_img, true);
            
              if(new Number(1).equals(currPerson.getPersCategory())) {
                attributesMap.put(degree, true);
              }
          }else {
            if(valid_loc==true) {
              attributesMap.put(load_img, true);
            }else {
              attributesMap.put(load_img, false);
            }
            attributesMap.put(fname, false);
            attributesMap.put(lname, false);
            attributesMap.put(certificate_no, false);
            attributesMap.put(origine, false);
            attributesMap.put(id, false);
            attributesMap.put(affiliation, false);
            attributesMap.put(pers_category, false);
            attributesMap.put(dept, false);
            attributesMap.put(sec, false);
            attributesMap.put(mjr, false);
            attributesMap.put(cmemsetup_post, false);
            
          }
            if(new Number(1).equals(currPerson.getPersCategory())) {
              attributesMap.put(degree, false);
            }
        }
      }
        
      return new FResult("return",attributesMap);
    }
    
    
    public void persianSubject_insertMainSeeSubject(String subject,
                                                    String lang) {
      ////Main See Subject
      MainSeeSubjectVoRowImpl newMainSeeSubject;
      if(lang=="fa")
            newMainSeeSubject =
                    (MainSeeSubjectVoRowImpl)getMainSeeSubjectVo1().createRow();
      else
            newMainSeeSubject =
                    (MainSeeSubjectVoRowImpl)getLatinMainSeeSubjectVo().createRow();
          
        getMainSeeSubjectVo1().insertRow(newMainSeeSubject);
        
        newMainSeeSubject.setLabcol((Number) getSession().getUserData().get("labcolno"));
        newMainSeeSubject.setSubject1(subject);
        newMainSeeSubject.setReadingOrder((lang == "fa" ? new Number(1) :
                                           new Number(2)));
        newMainSeeSubject.setReferenceType(new Number(2));
        
        getDBTransaction().commit();
    }
    
    public FResult persianSubject_insertSeeSubject_sub(String subject,
                                                       String lang) {
      ////Sub See Subject 
      MainSeeSubjectVoRowImpl currMainSeeSubject;
      if(lang=="fa")
            currMainSeeSubject =
                    (MainSeeSubjectVoRowImpl)getMainSeeSubjectVo1().getCurrentRow();
      else
            currMainSeeSubject =
                    (MainSeeSubjectVoRowImpl)getLatinMainSeeSubjectVo().getCurrentRow();
          
          if(currMainSeeSubject==null)
              return new FResult("error","ردیف انتخاب شده نامعتبر می باشد.");
          
        Number mainProviderArtId =
            currMainSeeSubject.getArtId().getSequenceNumber();
        ////////Insert Subject 
      MainSeeSubjectVoRowImpl newMainSeeSubject;
      if(lang=="fa")
            newMainSeeSubject =
                    (MainSeeSubjectVoRowImpl)getMainSeeSubjectVo1().createRow();
      else
            newMainSeeSubject =
                    (MainSeeSubjectVoRowImpl)getLatinMainSeeSubjectVo().createRow();
          
        getMainSeeSubjectVo1().insertRow(newMainSeeSubject);
        newMainSeeSubject.setLabcol((Number) getSession().getUserData().get("labcolno"));
        newMainSeeSubject.setSubject1(subject);
       
        newMainSeeSubject.setReadingOrder((lang == "fa" ? new Number(1) :
                                           new Number(2)));
        newMainSeeSubject.setReferenceType(new Number(1));
      getDBTransaction().commit();
//        ////////Insert See Subject
//        RowIterator seeSubjectVo = newMainSeeSubject.getSeeSubjectVo();
//        SeeSubjectVoRowImpl newSeeSubject=(SeeSubjectVoRowImpl)(seeSubjectVo.createRow());
//        seeSubjectVo.insertRow(newSeeSubject);
//        newSeeSubject.setSubjArtIdRelatedTo(newMainSeeSubject.getArtId());
//        newSeeSubject.setLabcol((Number) getSession().getUserData().get("labcolno"));
//        ////// in satr coment shavad artId ra az master mighirad
//        newSeeSubject.setSubjArtId(mainProviderArtId);
//        getDBTransaction().commit();
        return null;
    }
  
    
    public void persianProvider_insertMainSeeProvider(String provider,
                                                      String fName,
                                                      String bdDate,
                                                      int provider_type,
                                                      String lang) {
      ////Main See Provider
      MainSeeProviderRowImpl newMainSeeProvider;
      if(lang=="fa")
            newMainSeeProvider =
                    (MainSeeProviderRowImpl)getMainSeeProvider1().createRow();
      else
            newMainSeeProvider =
                    (MainSeeProviderRowImpl)getLatinMainSeeProvider().createRow();
          
        getMainSeeProvider1().insertRow(newMainSeeProvider);
        
        newMainSeeProvider.setLabcol((Number) getSession().getUserData().get("labcolno"));
        newMainSeeProvider.setProvider1(provider);
        newMainSeeProvider.setBDDate(bdDate);
        newMainSeeProvider.setForeignName(fName);
        newMainSeeProvider.setReadingOrder((lang == "fa" ? new Number(1) :
                                            new Number(2)));
        newMainSeeProvider.setReferenceType(new Number(2));
        
        getDBTransaction().commit();
    }
    
    public FResult persianProvider_insertSeeProvider_sub(String provider,
                                                         String fName,
                                                         String bdDate,
                                                         int provider_type,
                                                         String lang) {
      ////Sub See Provider 
      MainSeeProviderRowImpl currMainSeeProvider;
      if(lang=="fa")
            currMainSeeProvider =
                    (MainSeeProviderRowImpl)getMainSeeProvider1().getCurrentRow();
      else
            currMainSeeProvider =
                    (MainSeeProviderRowImpl)getLatinMainSeeProvider().getCurrentRow();
          
          if(currMainSeeProvider==null)
              return new FResult("error","ردیف انتخاب شده نامعتبر می باشد.");
          
        Number mainProviderArtId = currMainSeeProvider.getArtId().getSequenceNumber();
        ////////Insert Provider  
      MainSeeProviderRowImpl newMainSeeProvider;
      if(lang=="fa")
            newMainSeeProvider =
                    (MainSeeProviderRowImpl)getMainSeeProvider1().createRow();
      else
            newMainSeeProvider =
                    (MainSeeProviderRowImpl)getLatinMainSeeProvider().createRow();
          
        getMainSeeProvider1().insertRow(newMainSeeProvider);
        newMainSeeProvider.setLabcol((Number) getSession().getUserData().get("labcolno"));
        newMainSeeProvider.setProvider1(provider);
        newMainSeeProvider.setBDDate(bdDate);
        newMainSeeProvider.setForeignName(fName);
        newMainSeeProvider.setReadingOrder((lang == "fa" ? new Number(1) :
                                            new Number(2)));
        newMainSeeProvider.setReferenceType(new Number(2));
        
        ////////Insert See Provider
        RowIterator seeProviderVo = newMainSeeProvider.getSeeProvider();
        SeeProviderRowImpl newSeeProvider =
            (SeeProviderRowImpl)(seeProviderVo.createRow());
        seeProviderVo.insertRow(newSeeProvider);
        newSeeProvider.setPrvArtIdRelatedTo(newMainSeeProvider.getArtId().getSequenceNumber());
        newSeeProvider.setLabcol((Number) getSession().getUserData().get("labcolno"));
        ////// in satr coment shavad artId ra az master mighirad
        newSeeProvider.setPrvArtId(mainProviderArtId);
        getDBTransaction().commit();
        return null;
    }
  
    public void persianProvider_insertAlsoMainSeeProvider(String provider,
                                                          String fName,
                                                          String bdDate,
                                                          int provider_type,
                                                          String lang) {
      ////Also Main See Provider
      MainSeeAlsoProviderRowImpl newMainSeeAlsoProvider;
      if(lang=="fa")
            newMainSeeAlsoProvider =
                    (MainSeeAlsoProviderRowImpl)getMainSeeAlsoProvider1().createRow();
      else
            newMainSeeAlsoProvider =
                    (MainSeeAlsoProviderRowImpl)getLatinMainSeeAlsoProvider().createRow();
          
        getMainSeeAlsoProvider1().insertRow(newMainSeeAlsoProvider);
        
        newMainSeeAlsoProvider.setLabcol((Number) getSession().getUserData().get("labcolno"));
        newMainSeeAlsoProvider.setProvider1(provider);
        newMainSeeAlsoProvider.setBDDate(bdDate);
        newMainSeeAlsoProvider.setForeignName(fName);
        newMainSeeAlsoProvider.setReadingOrder((lang == "fa" ? new Number(1) :
                                                new Number(2)));
        newMainSeeAlsoProvider.setReferenceType(new Number(1));
        
        getDBTransaction().commit();
    }
    
    public FResult persianProvider_insertAlsoSeeProvider_sub(String provider,
                                                             String fName,
                                                             String bdDate,
                                                             int provider_type,
                                                             String lang) {
      ////Also Sub See Provider 
      MainSeeAlsoProviderRowImpl currMainSeeProvider;
      if(lang=="fa")
            currMainSeeProvider =
                    (MainSeeAlsoProviderRowImpl)getMainSeeAlsoProvider1().getCurrentRow();
      else
            currMainSeeProvider =
                    (MainSeeAlsoProviderRowImpl)getLatinMainSeeAlsoProvider().getCurrentRow();
          
          if(currMainSeeProvider==null)
              return new FResult("error","ردیف انتخاب شده نامعتبر می باشد.");
          
        Number mainProviderArtId = currMainSeeProvider.getArtId().getSequenceNumber();
        ////////Insert Provider  
      MainSeeAlsoProviderRowImpl newMainSeeProvider;
      if(lang=="fa")
            newMainSeeProvider =
                    (MainSeeAlsoProviderRowImpl)getMainSeeAlsoProvider1().createRow();
      else
            newMainSeeProvider =
                    (MainSeeAlsoProviderRowImpl)getLatinMainSeeAlsoProvider().createRow();
          
        getMainSeeAlsoProvider1().insertRow(newMainSeeProvider);
        newMainSeeProvider.setLabcol((Number) getSession().getUserData().get("labcolno"));
        newMainSeeProvider.setProvider1(provider);
        newMainSeeProvider.setBDDate(bdDate);
        newMainSeeProvider.setForeignName(fName);
        newMainSeeProvider.setReadingOrder((lang == "fa" ? new Number(1) :
                                            new Number(2)));
        newMainSeeProvider.setReferenceType(new Number(2));
        
        ////////Insert See Also Provider
        RowIterator seeAlsoProviderVo =
            newMainSeeProvider.getSeeAlsoProviderVo();
        SeeProviderRowImpl newSeeAlsoProvider =
            (SeeProviderRowImpl)(seeAlsoProviderVo.createRow());
        seeAlsoProviderVo.insertRow(newSeeAlsoProvider);
        newSeeAlsoProvider.setPrvArtIdRelatedTo(newMainSeeProvider.getArtId().getSequenceNumber());
        newSeeAlsoProvider.setLabcol((Number) getSession().getUserData().get("labcolno"));
        ////// in satr coment shavad artId ra az master mighirad
        newSeeAlsoProvider.setPrvArtId(mainProviderArtId);
        getDBTransaction().commit();
        return null;
    }

    public FResult ref_uniformTitle_afterCreate(Number reading_order,
                                     Number reference_type) {
        UniformTitleVORowImpl newUni =
            (UniformTitleVORowImpl)getRefSelectUniTitleVO().getCurrentRow();
   newUni.setReadingOrder(reading_order);
   newUni.setReferenceType(reference_type);
   newUni.setLabcol((Number)getSession().getUserData().get("labcolno"));
    return null;
  }
//  public FResult uniformTitle_beforeDelete(Number reading_order ) {
//    if(new Number(1).equals(reading_order)) {
//     
//    }
//    return null;
//  }
    public void ref_provider_afterCreate(Number readingOrder){
      ProviderVORowImpl currProvider = (ProviderVORowImpl)getRefSelectProviderVO().getCurrentRow();
      currProvider.setLabcol((Number)getSession().getUserData().get("labcolno"));
      currProvider.setReadingOrder(readingOrder);
      currProvider.setReferenceType(new Number(1));
                                                                         
    }
    public void ref_provider_setAccessMode(byte accessMode) {
      getRefSelectProviderVO().setAccessMode(accessMode);
    }

    public void ref_subject_afterCreate(Number readingOrder) {
        SubjectVoRowImpl newSub =
            (SubjectVoRowImpl)getRefSelectSubjectVO().getCurrentRow();
        if (newSub != null) {
            newSub.setReadingOrder(readingOrder);
            newSub.setLabcol((Number)getSession().getUserData().get("labcolno"));
            newSub.setReferenceType(new Number(1));
        }
    }

    public FResult subject_remove_detail(String detail) {
        if ("see".equals(detail) || "latin see".equals(detail)) {
            SeeSubjectVoRowImpl currSeeSub =
                (SeeSubjectVoRowImpl)("see".equals(detail) ?
                                      getSeeSubjectVo().getCurrentRow() :
                                      getLatinSeeSubjectVo().getCurrentRow());
            if (currSeeSub == null)
                return new FResult("error",
                                   "هیچ رکوردی برای حذف انتخاب نشده است.");
            currSeeSub.remove();
            getDBTransaction().commit();
            return new FResult("info", "عنوان با موفقیت حذف گردید.");
        }else if (detail.startsWith("see also") ||detail.startsWith("latin see also") ) {
          SeeAlsoSubjectVORowImpl currSeeSub=null;
            if("see also 1".equals(detail)) {
              currSeeSub = (SeeAlsoSubjectVORowImpl)getSeeAlsoSubjectVO_rtype1().getCurrentRow();
            }else if("see also 2".equals(detail)) {
              currSeeSub = (SeeAlsoSubjectVORowImpl)getSeeAlsoSubjectVO_rtype2().getCurrentRow();
            }else if("see also 3".equals(detail)) {
              currSeeSub = (SeeAlsoSubjectVORowImpl)getSeeAlsoSubjectVO_rtype3().getCurrentRow();
            }else if("latin see also 1".equals(detail)) {
              currSeeSub = (SeeAlsoSubjectVORowImpl)getLatinSeeAlsoSubjectVO_rtype1().getCurrentRow();
            }else if("latin see also 2".equals(detail)) {
              currSeeSub = (SeeAlsoSubjectVORowImpl)getLatinSeeAlsoSubjectVO_rtype2().getCurrentRow();
            }else if("latin see also 3".equals(detail)) {
              currSeeSub = (SeeAlsoSubjectVORowImpl)getLatinSeeAlsoSubjectVO_rtype3().getCurrentRow();
            }
            if (currSeeSub == null)
                return new FResult("error",
                                   "هیچ رکوردی برای حذف انتخاب نشده است.");
            currSeeSub.remove();
            getDBTransaction().commit();
            return new FResult("info", "عنوان با موفقیت حذف گردید.");
        }
        return null;
    }

    public FResult subject_insert_detail(String detail) {
        SubjectVoRowImpl currSubject =
            (SubjectVoRowImpl)getRefSelectSubjectVO().getCurrentRow();
        if (currSubject == null) {
            return new FResult("error", "هیچ موضوعی انتخاب نشده است.");
        }

        if ("see".equals(detail) || "latin see".equals(detail)) {
            MainSeeSubjectVoRowImpl currMain =
                (MainSeeSubjectVoRowImpl)("see".equals(detail) ?
                                          getMainSeeSubjectVo1().getCurrentRow() :
                                          getLatinMainSeeSubjectVo().getCurrentRow());
            if (currMain == null) {
                return new FResult("error",
                                   "ابتدا یک موضوع را جستجو کرده یا یک موضوع جدید ایجاد نمایید.");
            }
            DummyVOImpl dummyVo = getDummyVO1();
            dummyVo.setQuery("select labcol from see_subject where subj_art_id=" +
                             currMain.getArtId() +
                             " and subj_art_id_related_to=" +
                             currSubject.getArtId() + " and labcol=" +
                             getSession().getUserData().get("labcolno"));
            dummyVo.executeQuery();
            if (!new Number(0).equals(dummyVo.getRowCount()))
                return new FResult("error", "این رکورد تکراری است.");
            SeeSubjectVoImpl seeSubjVO =
                (SeeSubjectVoImpl)("see".equals(detail) ? getSeeSubjectVo() :
                                   getLatinSeeSubjectVo());
            SeeSubjectVoRowImpl newSeeSub =
                (SeeSubjectVoRowImpl)seeSubjVO.createRow();
            newSeeSub.setSubjArtIdRelatedTo(currSubject.getArtId().getSequenceNumber());
            seeSubjVO.insertRow(newSeeSub);
//            getDBTransaction().commit();
//            seeSubjVO.executeQuery();
        } else if (detail.startsWith("see also") ||
                   detail.startsWith("latin see also")) {
          MainSeeAlsoSubjectVoRowImpl currMain =
              (MainSeeAlsoSubjectVoRowImpl)(detail.startsWith("see also") ?
                                        getMainSeeAlsoSubjectVo1().getCurrentRow() :
                                        getLatinMainSeeAlsoSubjectVo().getCurrentRow());
          if (currMain == null) {
              return new FResult("error",
                                 "ابتدا یک موضوع را جستجو کرده یا یک موضوع جدید ایجاد نمایید.");
          }
          DummyVOImpl dummyVo = getDummyVO1();
          dummyVo.setQuery("select labcol from see_also_subject where subj_art_id=" +
                           currMain.getArtId() +
                           " and subj_art_id_related_to=" +
                           currSubject.getArtId() + " and labcol=" +
                           getSession().getUserData().get("labcolno"));
          dummyVo.executeQuery();
          if (!new Number(0).equals(dummyVo.getRowCount()))
              return new FResult("error", "این رکورد تکراری است.");
          
            SeeAlsoSubjectVORowImpl newSeeAlso = null;
            SeeAlsoSubjectVOImpl seeAlsoSubVo=null;
            Number relation_type=null;
            
            if( "see also 1".equals(detail))
                {
                   seeAlsoSubVo=getSeeAlsoSubjectVO_rtype1();
                   relation_type=new Number(1);
                }
           else  if( "see also 2".equals(detail))
                {
                  seeAlsoSubVo=getSeeAlsoSubjectVO_rtype2();
                  relation_type=new Number(2);
                }
            else  if( "see also 3".equals(detail))
                {
                  seeAlsoSubVo=getSeeAlsoSubjectVO_rtype3();
                  relation_type=new Number(3);

                }else if( "latin see also 1".equals(detail)) {
              seeAlsoSubVo=getLatinSeeAlsoSubjectVO_rtype1();
              relation_type=new Number(1);
            }else if( "latin see also 2".equals(detail)) {
              seeAlsoSubVo=getLatinSeeAlsoSubjectVO_rtype2();
              relation_type=new Number(2);
            }else if( "latin see also 3".equals(detail)) {
              seeAlsoSubVo=getLatinSeeAlsoSubjectVO_rtype3();
              relation_type=new Number(3);
            }
            
          newSeeAlso =
                  (SeeAlsoSubjectVORowImpl)seeAlsoSubVo.createRow();
          seeAlsoSubVo.insertRow(newSeeAlso);
          newSeeAlso.setRelationType(relation_type);
          newSeeAlso.setSubjArtIdRelatedTo(currSubject.getArtId().getSequenceNumber());
//          getDBTransaction().commit();
//          
//          seeAlsoSubVo.executeQuery();
//         seeAlsoSubVo.setCurrentRow(newSeeAlso);

        }
        return null;
    }
public FResult provider_insert_detail(String detail) {
   ProviderVORowImpl currProvider = (ProviderVORowImpl)getRefSelectProviderVO().getCurrentRow();
   if(currProvider==null) {
     return new FResult("error","هیچ پدید آوری انتخاب نشده است.");
   }
   if("see".equals(detail) || "latin see".equals(detail)) {
       MainSeeProviderRowImpl currMainSee=(MainSeeProviderRowImpl) ("see".equals(detail)?getMainSeeProvider1().getCurrentRow():getLatinMainSeeProvider().getCurrentRow());
     if (currMainSee == null)
         return new FResult("error",
                            "ابتدا یک پدید آور را جستجو کرده یا یک پدید آور جدید ایجاد نمایید.");
     DummyVOImpl dummyVo = getDummyVO1();
     dummyVo.setQuery("select labcol from see_provider where prv_art_id=" +
                      currMainSee.getArtId() +
                      " and prv_art_id_related_to=" +
                      currProvider.getArtId() + " and labcol=" +
                      getSession().getUserData().get("labcolno"));
     dummyVo.executeQuery();
     if (!new Number(0).equals(dummyVo.getRowCount()))
         return new FResult("error", "این رکورد تکراری است.");
    
     SeeProviderImpl seeProviderVo=(SeeProviderImpl)("see".equals(detail)?getSeeProvider1():getLatinSeeProvider());
     SeeProviderRowImpl newSeePro = (SeeProviderRowImpl)seeProviderVo.createRow();
     seeProviderVo.insertRow(newSeePro);
    
     newSeePro.setPrvArtIdRelatedTo(currProvider.getArtId().getSequenceNumber());
//     getDBTransaction().commit();
//     seeProviderVo.executeQuery();
     
   }else if("see also".equals(detail) || "latin see also".equals(detail)) {
       MainSeeAlsoProviderRowImpl currMainSeeAlso=(MainSeeAlsoProviderRowImpl)("see also".equals(detail)?getMainSeeAlsoProvider1().getCurrentRow():getLatinMainSeeAlsoProvider().getCurrentRow());
     if (currMainSeeAlso == null)
         return new FResult("error",
                            "ابتدا یک پدید آور را جستجو کرده یا یک پدید آور جدید ایجاد نمایید.");
     DummyVOImpl dummyVo = getDummyVO1();
     dummyVo.setQuery("select labcol from see_also_provider where prv_art_id=" +
                      currMainSeeAlso.getArtId() +
                      " and prv_art_id_related_to=" +
                      currProvider.getArtId() + " and labcol=" +
                      getSession().getUserData().get("labcolno"));
     dummyVo.executeQuery();
     if (!new Number(0).equals(dummyVo.getRowCount()))
         return new FResult("error", "این رکورد تکراری است.");
     
     SeeAlsoProviderVoImpl seeAlsoProVO=(SeeAlsoProviderVoImpl)("see also".equals(detail)? getSeeAlsoProviderVo1():getLatinSeeAlsoProviderVo());
     SeeAlsoProviderVoRowImpl newSeeAlso = (SeeAlsoProviderVoRowImpl)seeAlsoProVO.createRow();
     seeAlsoProVO.insertRow(newSeeAlso);
     newSeeAlso.setPrvArtIdRelatedTo(currProvider.getArtId().getSequenceNumber());
     getDBTransaction().commit();
     seeAlsoProVO.executeQuery();
   }
    return null;
}

public FResult provider_remove_detail(String detail) {
  if ("see".equals(detail) || "latin see".equals(detail)) {
      SeeProviderRowImpl currSee=(SeeProviderRowImpl)("see".equals(detail)?getSeeProvider1().getCurrentRow():getLatinSeeProvider().getCurrentRow());
    if (currSee == null)
        return new FResult("error",
                           "هیچ رکوردی برای حذف انتخاب نشده است.");
    currSee.remove();
    getDBTransaction().commit();
    return new FResult("info", "پدید آور با موفقیت حذف گردید.");
  }else if ("see also".equals(detail) ||
                   "latin see also".equals(detail)) {
            SeeAlsoProviderVoRowImpl currSeeAlso =
                (SeeAlsoProviderVoRowImpl)("see also".equals(detail) ?
                                               getSeeAlsoProviderVo1().getCurrentRow() :
                                               getLatinSeeAlsoProviderVo().getCurrentRow());
            if (currSeeAlso == null)
                return new FResult("error",
                                   "هیچ رکوردی برای حذف انتخاب نشده است.");
            currSeeAlso.remove();
            getDBTransaction().commit();
            return new FResult("info", "پدید آور با موفقیت حذف گردید.");
        }
  return null;
}
  public FResult uniformTitle_remove_detail(String detail) {
    if("see".equals(detail) || "latin see".equals(detail)) {
            SeeUniformTitleRowImpl currSee =
                (SeeUniformTitleRowImpl)("see".equals(detail) ?
                                         getSeeUniformTitle1().getCurrentRow() :
                                         getLatinSeeUniformTitle().getCurrentRow());
   if(currSee==null)
                return new FResult("error",
                                   "هیچ رکوردی برای حذف انتخاب نشده است.");
    currSee.remove();
    getDBTransaction().commit();
    return new FResult("info","عنوان با موفقیت حذف گردید.");
        } else if ("see also".equals(detail) ||
                   "latin see also".equals(detail)) {
            SeeAlsoUniformTitleVoRowImpl currSeeAlso =
                (SeeAlsoUniformTitleVoRowImpl)("see also".equals(detail) ?
                                               getSeeAlsoUniformTitleVo1().getCurrentRow() :
                                               getLatinSeeAlsoUniformTitleVo().getCurrentRow());
      if(currSeeAlso==null)
                return new FResult("error",
                                   "هیچ رکوردی برای حذف انتخاب نشده است.");
      currSeeAlso.remove();
      getDBTransaction().commit();
      return new FResult("info","عنوان با موفقیت حذف گردید.");
    }
    return null;
  }


  public FResult uniformTitle_insert_detail(String detail) {
     
        UniformTitleVORowImpl currUniTitle =
            (UniformTitleVORowImpl)getRefSelectUniTitleVO().getCurrentRow();
    if(currUniTitle==null)
        return new FResult("error","هیچ عنوانی انتخاب نشده است.");
    
  
     if("see".equals(detail) || "latin see".equals(detail)) {
            MainSeeUniformTitleRowImpl currMain =
                (MainSeeUniformTitleRowImpl)("see".equals(detail) ?
                                             getMainSeeUniformTitle1().getCurrentRow() :
                                             getLatinMainSeeUniformTitle().getCurrentRow());
     if(currMain==null)
                return new FResult("error",
                                   "ابتدا یک عنوان را جستجو کرده یا یک عنوان جدید ایجاد نمایید.");
    DummyVOImpl dummyVo=getDummyVO1();
            dummyVo.setQuery("select labcol from see_uniform_title where uni_title_art_id=" +
                             currMain.getArtId() +
                             " and uni_title_art_id_related_to=" +
                             currUniTitle.getArtId() + " and labcol=" +
                             getSession().getUserData().get("labcolno"));
    dummyVo.executeQuery();
    if(!new Number(0).equals(dummyVo.getRowCount()))
      return new FResult("error","این رکورد تکراری است.");
            SeeUniformTitleImpl seeUniTitleVO =
                (SeeUniformTitleImpl)("see".equals(detail) ?
                                      getSeeUniformTitle1() :
                                      getLatinSeeUniformTitle());
            SeeUniformTitleRowImpl newSee =
                (SeeUniformTitleRowImpl)seeUniTitleVO.createRow();
    newSee.setUniTitleArtIdRelatedTo(currUniTitle.getArtId().getSequenceNumber());
     seeUniTitleVO.insertRow(newSee);
  //  getDBTransaction().commit();
 // seeUniTitleVO.executeQuery();
    
        } else if ("see also".equals(detail) ||
                   "latin see also".equals(detail)) {
            MainSeeAlsoUniformTitleVORowImpl currMain =
                (MainSeeAlsoUniformTitleVORowImpl)("see also".equals(detail) ?
                                                   getMainSeeAlsoUniformTitleVO1().getCurrentRow() :
                                                   getLatinMainSeeAlsoUniformTitleVO().getCurrentRow());
         if(currMain==null)
                return new FResult("error",
                                   "ابتدا یک عنوان را جستجو کرده یا یک عنوان جدید ایجاد نمایید.");
              DummyVOImpl dummyVo=getDummyVO1();
            dummyVo.setQuery("select labcol from see_also_uniform_title where uni_title_art_id=" +
                             currMain.getArtId() +
                             " and uni_title_art_id_related_to=" +
                             currUniTitle.getArtId() + " and labcol=" +
                             getSession().getUserData().get("labcolno"));
              dummyVo.executeQuery();
              if(!new Number(0).equals(dummyVo.getRowCount()))
                return new FResult("error","این رکورد تکراری است.");
            SeeAlsoUniformTitleVoImpl seeAlsoUniTitleVo =
                (SeeAlsoUniformTitleVoImpl)("see also".equals(detail) ?
                                            getSeeAlsoUniformTitleVo1() :
                                            getLatinSeeAlsoUniformTitleVo());
            SeeAlsoUniformTitleVoRowImpl newSeeAlso =
                (SeeAlsoUniformTitleVoRowImpl)seeAlsoUniTitleVo.createRow();
              seeAlsoUniTitleVo.insertRow(newSeeAlso);
              newSeeAlso.setUniTitleArtIdRelatedTo(currUniTitle.getArtId().getSequenceNumber());
//              getDBTransaction().commit();
//              seeAlsoUniTitleVo.executeQuery();
            }
     
   
    return null;
  }
  public void ref_provider_apply_readingOrderVC(Number reading_order) {
      ((ProviderVOImpl)getRefSelectProviderVO()).setparam_readingOrder(reading_order);
      getRefSelectProviderVO().executeQuery();
  }

    public void ref_uniTitle_apply_readingOrderVC(Number reading_order) {
    ((UniformTitleVOImpl)getRefSelectUniTitleVO()).setparam_readingOrder(reading_order);
    getRefSelectUniTitleVO().executeQuery();
  }
  
    public void ref_subject_apply_readingOrderVC(Number reading_order) {
        ((SubjectVoImpl)getRefSelectSubjectVO()).setparam_readingOrder(reading_order);
        getRefSelectSubjectVO().executeQuery();
    }
public FResult ref_init_MainSeeProvider(Number readingOrder,Number referenceType) {
  MainSeeProviderRowImpl newMainSeeProv=null;
  MainSeeAlsoProviderRowImpl newMainSeeAlsoProv=null;
  if(new Number(1).equals(readingOrder)) {
   if(new Number(2).equals(referenceType))
   {
      newMainSeeProv=(MainSeeProviderRowImpl) getMainSeeProvider1().getCurrentRow();
      newMainSeeProv.setReadingOrder(readingOrder);
      newMainSeeProv.setReferenceType(referenceType);
      newMainSeeProv.setLabcol((Number)getSession().getUserData().get("labcolno"));
   }else if (new Number(1).equals(referenceType)) {
     newMainSeeAlsoProv = (MainSeeAlsoProviderRowImpl)getMainSeeAlsoProvider1().getCurrentRow();
     newMainSeeAlsoProv.setReadingOrder(readingOrder);
     newMainSeeAlsoProv.setReferenceType(referenceType);
     newMainSeeAlsoProv.setLabcol((Number)getSession().getUserData().get("labcolno"));
   }
  }else if(new Number(2).equals(readingOrder)) {
    if(new Number(2).equals(referenceType)) {
      newMainSeeProv=(MainSeeProviderRowImpl) getLatinMainSeeProvider().getCurrentRow();
      newMainSeeProv.setReadingOrder(readingOrder);
      newMainSeeProv.setReferenceType(referenceType);
      newMainSeeProv.setLabcol((Number)getSession().getUserData().get("labcolno"));
    }else if(new Number(1).equals(referenceType)) {
      newMainSeeAlsoProv = (MainSeeAlsoProviderRowImpl)getLatinMainSeeAlsoProvider().getCurrentRow();
      newMainSeeAlsoProv.setReadingOrder(readingOrder);
      newMainSeeAlsoProv.setReferenceType(referenceType);
      newMainSeeAlsoProv.setLabcol((Number)getSession().getUserData().get("labcolno"));
    }
  }
    
   
 
  return null;
}
    public FResult ref_init_MainSeeSubject(Number readingOrder,
                                           Number referenceType) {
    MainSeeSubjectVoRowImpl newMainSee=null;
        MainSeeAlsoSubjectVoRowImpl newMainSeeAlso = null;
    if(new Number(1).equals(readingOrder)) {
      if(new Number(2).equals(referenceType)) {
                newMainSee =
                        (MainSeeSubjectVoRowImpl)getMainSeeSubjectVo1().getCurrentRow();
        newMainSee.setReadingOrder(readingOrder);
        newMainSee.setReferenceType(referenceType);
        newMainSee.setLabcol((Number)getSession().getUserData().get("labcolno"));
            } else if (new Number(1).equals(referenceType)) {
                newMainSeeAlso =
                        (MainSeeAlsoSubjectVoRowImpl)getMainSeeAlsoSubjectVo1().getCurrentRow();
                newMainSeeAlso.setReadingOrder(readingOrder);
                newMainSeeAlso.setReferenceType(referenceType);
                newMainSeeAlso.setLabcol((Number)getSession().getUserData().get("labcolno"));
      }
    }else if(new Number(2).equals(readingOrder)) {
      if(new Number(2).equals(referenceType)) {
                newMainSee =
                        (MainSeeSubjectVoRowImpl)getLatinMainSeeSubjectVo().getCurrentRow();
        newMainSee.setReadingOrder(readingOrder);
        newMainSee.setReferenceType(referenceType);
        newMainSee.setLabcol((Number)getSession().getUserData().get("labcolno"));
            } else if (new Number(1).equals(referenceType)) {
                newMainSeeAlso =
                        (MainSeeAlsoSubjectVoRowImpl)getLatinMainSeeAlsoSubjectVo().getCurrentRow();
                newMainSeeAlso.setReadingOrder(readingOrder);
                newMainSeeAlso.setReferenceType(referenceType);
                newMainSeeAlso.setLabcol((Number)getSession().getUserData().get("labcolno"));
      }
    }
    return null;
  }
 
    public FResult ref_init_MainSeeUniTitle(Number readingOrder,
                                            Number referenceType) {
    MainSeeUniformTitleRowImpl newMainSee=null;
    MainSeeAlsoUniformTitleVORowImpl newMainSeeAlso=null;
        if (new Number(1).equals(readingOrder)) {
            if (new Number(2).equals(referenceType)) {
                newMainSee =
                        (MainSeeUniformTitleRowImpl)getMainSeeUniformTitle1().getCurrentRow();
            newMainSee.setReadingOrder(readingOrder);
            newMainSee.setReferenceType(referenceType);
            newMainSee.setLabcol((Number)getSession().getUserData().get("labcolno"));
          }else if(new Number(1).equals(referenceType)) {
                newMainSeeAlso =
                        (MainSeeAlsoUniformTitleVORowImpl)getMainSeeAlsoUniformTitleVO1().getCurrentRow();
            newMainSeeAlso.setReadingOrder(readingOrder);
            newMainSeeAlso.setReferenceType(referenceType);
            newMainSeeAlso.setLabcol((Number)getSession().getUserData().get("labcolno"));
          }
      }else if(new Number(2).equals(readingOrder)) {
            if (new Number(2).equals(referenceType)) {
                newMainSee =
                        (MainSeeUniformTitleRowImpl)getLatinMainSeeUniformTitle().getCurrentRow();
          newMainSee.setReadingOrder(readingOrder);
          newMainSee.setReferenceType(referenceType);
          newMainSee.setLabcol((Number)getSession().getUserData().get("labcolno"));
        }else if(new Number(1).equals(referenceType)) {
                newMainSeeAlso =
                        (MainSeeAlsoUniformTitleVORowImpl)getLatinMainSeeAlsoUniformTitleVO().getCurrentRow();
         
          newMainSeeAlso.setReadingOrder(readingOrder);
          newMainSeeAlso.setReferenceType(referenceType);
          newMainSeeAlso.setLabcol((Number)getSession().getUserData().get("labcolno"));
        }
      }
 
    return null;
  }
 
    public FResult persianUniformTitle_insertAlsoMainUniTitle(String uniTitle,
                                                              String lang) {
   //Main See Also UniformTitle
   MainSeeAlsoUniformTitleVORowImpl newUniTitle;
   if (lang=="fa")
            newUniTitle =
                    (MainSeeAlsoUniformTitleVORowImpl)getMainSeeAlsoUniformTitleVO1().createRow();
   else
            newUniTitle =
                    (MainSeeAlsoUniformTitleVORowImpl)getLatinMainSeeAlsoUniformTitleVO().createRow();
   
      getMainSeeAlsoUniformTitleVO1().insertRow(newUniTitle);
      
        newUniTitle.setLabcol((Number) getSession().getUserData().get("labcolno"));
        newUniTitle.setReadingOrder((lang == "fa" ? new Number(1) :
                                     new Number(2)));
        //newUniTitle.setReadingOrder(new Number(1));
        newUniTitle.setReferenceType(new Number(1));
        newUniTitle.setTitle(uniTitle);
        getDBTransaction().commit();
      
      
      return null;
  }
  
    public FResult persianUniformTitle_insertSeeAlsoUniTitle(String uniTitle,
                                                             String lang) {
  ////Sub See Also UniformTitle
  
      MainSeeAlsoUniformTitleVORowImpl  currRec;
      if(lang=="fa")
            currRec =
                    (MainSeeAlsoUniformTitleVORowImpl)getMainSeeAlsoUniformTitleVO1().getCurrentRow();
      else
            currRec =
                    (MainSeeAlsoUniformTitleVORowImpl)getLatinMainSeeAlsoUniformTitleVO().getCurrentRow();

      
    if(currRec==null)
        return new FResult("error","ابتدا یک موضوع انتخاب کنید.");
      Number mainUniTitleArtId=currRec.getArtId().getSequenceNumber();
            
        //MainSeeAlsoUniformTitleVORowImpl newUniTitle= (MainSeeAlsoUniformTitleVORowImpl)getMainSeeAlsoUniformTitleVO1().createRow();
        
        MainSeeAlsoUniformTitleVORowImpl newUniTitle;
        if (lang=="fa")
            newUniTitle =
                    (MainSeeAlsoUniformTitleVORowImpl)getMainSeeAlsoUniformTitleVO1().createRow();
        else
            newUniTitle =
                    (MainSeeAlsoUniformTitleVORowImpl)getLatinMainSeeAlsoUniformTitleVO().createRow();
        
        
        getMainSeeAlsoUniformTitleVO1().insertRow(newUniTitle);
        
          newUniTitle.setLabcol((Number) getSession().getUserData().get("labcolno"));
          //newUniTitle.setReadingOrder(new Number(1));
        newUniTitle.setReadingOrder((lang == "fa" ? new Number(1) :
                                     new Number(2)));
          newUniTitle.setReferenceType(new Number(1));
          newUniTitle.setTitle(uniTitle);
          getDBTransaction().commit();
          
        RowIterator seeUniTitleVo = newUniTitle.getSeeAlsoUniformTitleVo();
        
        
        SeeAlsoUniformTitleVoRowImpl newSeeUniTitle =
            (SeeAlsoUniformTitleVoRowImpl)(seeUniTitleVo.createRow());
        seeUniTitleVo.insertRow(newSeeUniTitle);
          newSeeUniTitle.setUniTitleArtIdRelatedTo(newUniTitle.getArtId().getSequenceNumber());
          newSeeUniTitle.setLabcol((Number) getSession().getUserData().get("labcolno"));
          newSeeUniTitle.setUniTitleArtId(mainUniTitleArtId);
        getDBTransaction().commit();
    
  
  return null;
  }
    
    public FResult persianUniformTitle_insertMainSeeUniformTitle(String uniTitle,
                                                                 String lang) {
    //Main See UniformTitle
    MainSeeUniformTitleRowImpl newUniTitle;
    if (lang=="fa")
            newUniTitle =
                    (MainSeeUniformTitleRowImpl)getMainSeeUniformTitle1().createRow();
    else
            newUniTitle =
                    (MainSeeUniformTitleRowImpl)getLatinMainSeeUniformTitle().createRow();
        
        
    getMainSeeUniformTitle1().insertRow(newUniTitle);
    
      newUniTitle.setLabcol((Number) getSession().getUserData().get("labcolno"));
    //newUniTitle.setReadingOrder(new Number(1));
        newUniTitle.setReadingOrder((lang == "fa" ? new Number(1) :
                                     new Number(2)));
      newUniTitle.setReferenceType(new Number(2));
      newUniTitle.setTitle(uniTitle);
      getDBTransaction().commit();
   
//    getMainSeeUniformTitle1().setCurrentRow(newUniTitle);
    getMainSeeUniformTitle1().last();
  return null;
  }   
   
  public FResult persianUniformTitle_insert(String uniTitle,String lang){
        ///Sub See UniformTitle
        MainSeeUniformTitleRowImpl  currRec;
      
        if (lang=="fa")
            currRec =
                    (MainSeeUniformTitleRowImpl)getMainSeeUniformTitle1().getCurrentRow();
      else
            currRec =
                    (MainSeeUniformTitleRowImpl)getLatinMainSeeUniformTitle().getCurrentRow();
          
          
          if(currRec==null)
              return new FResult("error","ابتدا یک موضوع انتخاب کنید.");
        
        Number mainUniTitleArtId=currRec.getArtId().getSequenceNumber();
         
          
          MainSeeUniformTitleRowImpl newUniTitle;
          if (lang=="fa")
            newUniTitle =
                    (MainSeeUniformTitleRowImpl)getMainSeeUniformTitle1().createRow();
          else
            newUniTitle =
                    (MainSeeUniformTitleRowImpl)getLatinMainSeeUniformTitle().createRow();
             
          getMainSeeUniformTitle1().insertRow(newUniTitle);
          
            newUniTitle.setLabcol((Number) getSession().getUserData().get("labcolno"));
        newUniTitle.setReadingOrder((lang == "fa" ? new Number(1) :
                                     new Number(2)));
            //newUniTitle.setReadingOrder(new Number(1));
            newUniTitle.setReferenceType(new Number(1));
            newUniTitle.setTitle(uniTitle);
           getDBTransaction().commit();
            
          RowIterator seeUniTitleVo = newUniTitle.getSeeUniformTitle();
        SeeUniformTitleRowImpl newSeeUniTitle =
            (SeeUniformTitleRowImpl)(seeUniTitleVo.createRow());
          seeUniTitleVo.insertRow(newSeeUniTitle);
            newSeeUniTitle.setUniTitleArtIdRelatedTo(newUniTitle.getArtId().getSequenceNumber());
            newSeeUniTitle.setLabcol((Number) getSession().getUserData().get("labcolno"));
            newSeeUniTitle.setUniTitleArtId(mainUniTitleArtId);
          getDBTransaction().commit();
          
         
         return null;
        }
  
 
  public FResult bookRequest_phBookSelection(){
      
    //  VirtualBookVORowImpl currVirtualBook = (VirtualBookVORowImpl)getVirtualBookVO1().getCurrentRow();
        PhysicalBookVORowImpl cuuPhBook =
            (PhysicalBookVORowImpl)getPhysicalBookVO1().getCurrentRow();
    
      pakage_variables.put("param_vol", cuuPhBook.getVolNo());
        if (!(new Number(1).equals(cuuPhBook.getExistenceStatus()) ||
              new Number(9).equals(cuuPhBook.getExistenceStatus()))) {
            return new FResult("error",
                               "کتاب با وضعیت " + cuuPhBook.getExistanseStatusText() +
                               " امانت داده نمی شود.");
          
          }
        
      if(bookRequest_loanableMakhzan(cuuPhBook.getPlace())==false) {
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "MAKHZAN".toUpperCase() }),
                                   -1)[0].getAttribute("Message"));
        
      }
        if (!new Number(1).equals(cuuPhBook.getLoanStatus())) {
            return new FResult("error",
                               "کتاب قابل امانت نمی باشد به وضعیت امانت کتاب توجه کنید.");
          
          }
     
      return null;
      }

  public FResult  bookRequest_insert_bookRequest(Boolean loanAtPlace){
      
        PersonVORowImpl currPers =
            (PersonVORowImpl)getPersonVO1().getCurrentRow();
        VirtualBookVORowImpl currVirtualBook =
            (VirtualBookVORowImpl)getVirtualBookVO1().getCurrentRow();
        PhysicalBookVORowImpl currPhBook =
            (PhysicalBookVORowImpl)getPhysicalBookVO1().getCurrentRow();

        Row[] row =
            getBookRequest1().findByKey(new Key(new Object[] { (Number)getSession().getUserData().get("labcolno"),
                                                               currPers.getBarcode(),
                                                               currVirtualBook.getArtId() }),
                                        1);
        if(row.length>0)
            return new FResult("error",
                               "این کتاب هم اکنون توسط همین دانشجو در صف درخواست قرار دارد.");
        pp_ReqBlkVoRowImpl pp_Reqblk =
            (pp_ReqBlkVoRowImpl)getpp_ReqBlkVo1().getCurrentRow();
      
        BookRequestRowImpl newbookReq =
            (BookRequestRowImpl)getBookRequest1().createRow();
      getBookRequest1().insertRow(newbookReq);
      
      newbookReq.setBarcode(currPers.getBarcode());
      newbookReq.setLabcol((Number)getSession().getUserData().get("labcolno"));
      newbookReq.setSerial(currVirtualBook .getArtId());
      //newbookReq.setReqNo(ParsiUtil.timeWithSecToNumber().toString());
      newbookReq.setReqNo(pp_Reqblk.getReqNum());
      newbookReq.setReqDate( ParsiUtil.DateToNumber().toString());
    newbookReq.setLoanStat("F");
      newbookReq.setLoadStat("F");
      newbookReq.setCustStat(!loanAtPlace?"F":"T");
    newbookReq.setPlace(currPhBook.getPlace());
    newbookReq.setFname(currPers.getFname());
    newbookReq.setLname(currPers.getLname());
    newbookReq.setCallNo(currVirtualBook.getCallNo());
    
   // newbookReq.setVolNo((String) pakage_variables.get("param_vol"));
   newbookReq.setVolNo(ParsiUtil.StNVL( currPhBook.getVolNo(),"0"));
    
        
        getDBTransaction().commit();
        return new FResult("info","درخواست امانت با موفقیت انجام شد.");
  }

  
  public FResult  bookRequest_print_vbook(){
       
//       PersonVORowImpl currPerson = (PersonVORowImpl)getPersonVO1().getCurrentRow();
        PersonVORowImpl currPers =
            (PersonVORowImpl)getPersonVO1().getCurrentRow();
       if(currPers==null || currPers.getBarcode()==null)
       {
             return new FResult("error","ابتدا یک عضو جستجو کنید.");
           
           }       
       
        VirtualBookVORowImpl currVirtualBook =
            (VirtualBookVORowImpl)getVirtualBookVO1().getCurrentRow();
       
        
        if(currVirtualBook==null ||  currVirtualBook.getArtId()==null){
            
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "no_ph_data".toUpperCase() }),
                                         -1)[0].getAttribute("Message"));
            }
        if(getPhysicalBookVO1().getRowCount()<1){
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "copy_info_not_entered".toUpperCase() }),
                                         -1)[0].getAttribute("Message"));
            }

        PhysicalBookVORowImpl selRec =null;
        PhysicalBookVORowImpl firstTrueCopyRec =null;
        PhysicalBookVORowImpl specialPlaceTrueCopyRec=null;
        int trueCopy=0;
        int specialPlaceTrueCopy=0;

        RowSet phBookItirator = getPhysicalBookVO1().createRowSet("phbook");
       // phBookItirator.reset();
        while (phBookItirator.hasNext()) {
            PhysicalBookVORowImpl currPhRow =
                (PhysicalBookVORowImpl)phBookItirator.next();
            if (new Boolean(true).equals(currPhRow.getSelectNoskhe()) &&
                selRec == null)
            selRec=currPhRow;
            
            if (new Number(1).equals(currPhRow.getExistenceStatus()) ||
                new Number(9).equals(currPhRow.getExistenceStatus())) {
                if (bookRequest_loanableMakhzan(currPhRow.getPlace())) {
                trueCopy+=1;
                if(trueCopy==1)
                    firstTrueCopyRec=currPhRow;
                }
                
            else{
                specialPlaceTrueCopy+=1;
                if(specialPlaceTrueCopy==1)
                  specialPlaceTrueCopyRec=currPhRow;
                }
           
            }
            if (new Boolean(true).equals(currPhRow.getSelectNoskhe())) {
                //JSFUtils.addFacesInfoMessage(currPhRow.getPlace().toString());
                getPhysicalBookVO1().setCurrentRow(currPhRow);
                break;
                }
            
            }
     
        phBookItirator.closeRowSet();
       
        String msg=null;
        if(selRec==null){
            if(trueCopy==0){
                
              DatabaseProcedure item_text =
                DatabaseProcedure.define("FUNCTION parsi_pkg_catalog.ITEM_TEXT(CAT_NAME VARCHAR2,ITEM_VAL NUMBER,labcol_no number) RETURN VARCHAR2;");
              
                String item_text_result =
                    (String)item_text.call(getDBTransaction(),
                                           "loanable_book_place",
                                           new Number(1),
                                           getSession().getUserData().get("labcolno")).getReturnValue();
                
                
                msg =
"در حال حاضر هیچ نسخه قابل امانت دهی از این کتاب در مخزن های ";
                msg=msg + item_text_result ;
                msg=msg +" وجود ندارد.";
                
            if(specialPlaceTrueCopy>0)
                    msg =
msg + " در صورت تمایل می توانید به محل های نگهداری کتاب برای مطالعه در محل مراجعه کنید.";
            
            return new FResult("error",msg);
            
            
            }else if(trueCopy==1){
                selRec=firstTrueCopyRec;
               selRec.setSelectNoskhe(true);
               getPhysicalBookVO1().setCurrentRow( firstTrueCopyRec);
                   
            } else {
                return new FResult("error",
                                   (String)getMessageVO1().findByKey(new Key(new Object[] { "sel_copy".toUpperCase() }),
                                     -1)[0].getAttribute("Message"));
            }
        }
        int cnt=0;
        pp_ReqBlkVoRowImpl reqBlk =
            (pp_ReqBlkVoRowImpl)getpp_ReqBlkVo1().createRow();
        getpp_ReqBlkVo1().insertRow(reqBlk);
        
        //InitMemberVORowImpl currInitMem = (InitMemberVORowImpl)currPers.getInitMemberCurrLibVO1();
        DummyVOImpl dummyVo=getDummyVO1();
        
        //تعداد درخواست ها ی عضو در روز جاری
        dummyVo.setQuery("SELECT * FROM BOOK_REQUEST " + "	WHERE BARCODE='" +
                         currPers.getBarcode() + "' AND REQ_DATE='" +
                         ParsiUtil.DateToNumber() + "' and labcol=" +
                         getSession().getUserData().get("labcolno"));
        dummyVo.executeQuery();
         cnt=dummyVo.getRowCount();
        //reqBlk.setReqCount(new Number(cnt));
        Number reqMax =
            currPers.getLoanRemindCap().add(currPers.getLoanAtPlaceRemindCap()).add(1);
        
        if( new Number(cnt).compareTo(reqMax)>=0){
            return new FResult("error",
                               "تعداد درخواست کتاب بیش از حد مجاز برای این عضو است." +
                               "\n" +
                    "حداکثر تعداد درخواست مجاز برای شما: " + reqMax);
            }
        
        //تعداد درخواست منتظر در صف خروج از مخزن
        dummyVo.setQuery("SELECT * FROM BOOK_REQUEST WHERE LOAD_STAT='F' AND REQ_DATE='" +
                         ParsiUtil.DateToNumber() + "' and labcol=" +
                         getSession().getUserData().get("labcolno"));
        dummyVo.executeQuery();
        cnt=dummyVo.getRowCount();
        reqBlk.setDiRecLoad(new Number(cnt+1));
        //تعداد درخواست منتظر در صف امانت
        dummyVo.setQuery("SELECT * FROM BOOK_REQUEST WHERE  LOAN_STAT='F' AND REQ_DATE='" +
                         ParsiUtil.DateToNumber() + "' and labcol=" +
                         getSession().getUserData().get("labcolno"));
        dummyVo.executeQuery();
        cnt=dummyVo.getRowCount();
        reqBlk.setDiRecLoan(new Number(cnt+1));
        
        
        //تعداد کل درخواست های در صف
        dummyVo.setQuery("SELECT * FROM BOOK_REQUEST WHERE (LOAD_STAT='F' OR LOAN_STAT='F') AND REQ_DATE='" +
                         ParsiUtil.DateToNumber() + "' and labcol=" +
                         getSession().getUserData().get("labcolno"));
        dummyVo.executeQuery();
        cnt=dummyVo.getRowCount();
        reqBlk.setDiReqKol(new Number(cnt+1));
        
      reqBlk.setDiReqTime(reqBlk.getDiRecLoad().multiply(new Number(10)).add(reqBlk.getDiRecLoan().multiply(new Number(3))));
        
        reqBlk.setReqNum(ParsiUtil.timeWithSecToNumber().toString());
        reqBlk.setReqTime(ParsiUtil.numberTimeToString(ParsiUtil.timeToNumber()));
        
      return new FResult("popup",null);
      }

  public Boolean bookRequest_loanableMakhzan(Number bookPlace){
      if(bookPlace==null)
          return false;
        DatabaseProcedure item_text =
          DatabaseProcedure.define("FUNCTION parsi_pkg_catalog.ITEM_TEXT(CAT_NAME VARCHAR2,ITEM_VAL NUMBER,labcol_no number) RETURN VARCHAR2;");
        
        String item_text_result =
            (String)item_text.call(getDBTransaction(), "LOANABLE_BOOK_PLACE",
                                   "1",
                                   getSession().getUserData().get("labcolno")).getReturnValue();
          if(item_text_result==null)
              return false;
          String[] listOfBookPlaces =item_text_result.split(",");
        for (String s : listOfBookPlaces) {
          if(bookPlace.toString().equalsIgnoreCase(s))
              return true;
          }
          
          
      return false;
      }
  
    
  public FResult bookRequest_preSearch_barcode(){
        
        PersonVOImpl persVo = (PersonVOImpl)getPersonVO1();
          if(ParsiUtil.clearString(persVo.getBarcodeParam3())==null)
              return new FResult("error","لطفا بارکد خود را وارد کنید.");
          if(ParsiUtil.clearString(persVo.getCNoParam())==null)
            return new FResult("error",
                               "لطفا شماره شناسنامه خود را وارد نمایید.");
        return null;
        
        }

  public FResult bookRequest_preSearch_newCard(){
      
      PersonVOImpl persVo = (PersonVOImpl)getPersonVO1();
        if(ParsiUtil.clearString(persVo.getidParam3())==null)
            return new FResult("error",
                               "لطفا شماره دانشجویی خود را وارد نمایید.");
        if(ParsiUtil.clearString(persVo.getCNoParam2())==null)
            return new FResult("error",
                               "لطفا شماره شناسنامه خود را وارد نمایید.");
        
        
        DummyVOImpl dummyVO=getDummyVO1();
        dummyVO.setQuery("SELECT BARCODE  FROM PERSON WHERE ID='" +
                         persVo.getidParam3() + "'");
        dummyVO.executeQuery();
        String barcode=null;
        if (dummyVO.first().getAttribute("Dummy") != null)
            barcode =
                    (dummyVO.getCurrentRow().getAttribute("Dummy").toString());

        
        if(barcode==null)
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "no_data_std_id".toUpperCase() }),
                                   -1)[0].getAttribute("Message"));
      return null;
      
      }
    
    public FResult bookRequest_initPerson_barcode(){
        PersonVORowImpl currPers =
            (PersonVORowImpl)getPersonVO1().getCurrentRow();
      
       //if(ParsiUtil.clearString( getPersonVO1().getBarcodeParam3())!=null)
        if(currPers==null  || currPers.getBarcode()==null) 
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "no_data".toUpperCase() }),
                                     -1)[0].getAttribute("Message"));
         
        pakage_variables.put("rasmi_mem_first_loan",false);
        pakage_variables.put("place_cap_is_full",0);
          pakage_variables.put("capacity_is_full",0);
        if(new Number(2).equals(currPers.getPersStatus()))
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "no_loan_no_active".toUpperCase() }),
                                     -1)[0].getAttribute("Message"));
          
          DatabaseProcedure is_mem_of_lib =
              DatabaseProcedure.define("FUNCTION parsi_pkg_library.IS_MEM_OF_LIB2(P_ART_ID NUMBER,CUR_LIB_ART_ID NUMBER)RETURN NUMBER;");
          BigDecimal is_mem_of_lib_result =
              (BigDecimal)is_mem_of_lib.call(getDBTransaction(),
                                           currPers.getArtId(),
                                           (Number)getSession().getUserData().get("libartid")).getReturnValue();

        InitMemberVORowImpl currInitMem =
            (InitMemberVORowImpl)currPers.getInitMemberCurrLibVO1();
          //Rasmi ha
          if(new Number(1).equals( currPers.getPersType())){
              if(new Number(1).equals(is_mem_of_lib_result)){
                 
                  if(new Number(3).equals( currInitMem.getMemshipStatus()))
                  
                    JSFUtils.addFacesErrorMessage ((String)getMessageVO1().findByKey(new Key(new Object[] { "incomplete_id".toUpperCase() }),
                                               -1)[0].getAttribute("Message"));
                else if (!(new Number(3).equals(currInitMem.getMemshipStatus()) ||
                           new Number(1).equals(currInitMem.getMemshipStatus())))
                    return new FResult("error",
                                       "به اعضای دارای وضعیت " + currInitMem.getMemshipStatusText() +
                                       " کتاب امانت داده نمی شود.");
                  
                   
                   DatabaseProcedure has_mem_rec2 =
                       DatabaseProcedure.define("FUNCTION parsi_pkg_library.HAS_MEM_REC2(P_BARCODE VARCHAR2,T_LIB_ART_ID NUMBER,labcol1 number) RETURN number;");
                   BigDecimal has_mem_rec2_result =
                    (BigDecimal)has_mem_rec2.call(getDBTransaction(),
                                                  currPers.getBarcode(),
                                                  getSession().getUserData().get("libartid"),
                                                  getSession().getUserData().get("labcolno")).getReturnValue();
                   if(new BigDecimal(0).equals(has_mem_rec2_result)) {
                     pakage_variables.put("rasmi_mem_first_loan",true);
                     //PV_RASMI_MEM_FIRST_LOAN=true;
                   }

                if (new Number(1).equals(currInitMem.getMemshipCategory()) ||
                    new Number(2).equals(currInitMem.getMemshipCategory()) ||
                    new Number(3).equals(currInitMem.getMemshipCategory()) ||
                    new Number(4).equals(currInitMem.getMemshipCategory())) {

                        DatabaseProcedure loan_capacity_full2 =
                            DatabaseProcedure.define("FUNCTION parsi_pkg_library.LOAN_CAPACITY_FULL2(p_BARCODE VARCHAR2,CUR_LIB_ART_ID NUMBER,memship_cat number,labcol1 number) RETURN number;");
                        BigDecimal loan_capacity_full2_result =
                        (BigDecimal)loan_capacity_full2.call(getDBTransaction(),
                                                             currPers.getBarcode(),
                                                             getSession().getUserData().get("libartid"),
                                                             currInitMem.getMemshipCategory(),
                                                             getSession().getUserData().get("labcolno")).getReturnValue();
                        // PV_capacity_is_full=(new BigDecimal(1).equals(loan_capacity_full2_result));
                    pakage_variables.put("capacity_is_full",
                                         (new BigDecimal(1).equals(loan_capacity_full2_result)));
                        
                          DatabaseProcedure lib_study_loan_capacity_full2 =
                            DatabaseProcedure.define("FUNCTION parsi_pkg_library.LIB_STUDY_LOAN_CAPACITY_FULL2(P_BARCODE VARCHAR2,CUR_LIB_ART_ID NUMBER,memship_cat number) RETURN number;");
                        BigDecimal lib_study_loan_capacity_full2_result =
                        (BigDecimal)lib_study_loan_capacity_full2.call(getDBTransaction(),
                                                                       currPers.getBarcode(),
                                                                       getSession().getUserData().get("libartid"),
                                                                       currInitMem.getMemshipCategory()).getReturnValue();
                        
                    pakage_variables.put("place_cap_is_full",
                                         new BigDecimal(1).equals(lib_study_loan_capacity_full2_result));
                    pakage_variables.put("loan_cap",
                                         currPers.getLoanRemindCap());
                      
                      }
                  
                  
                  }
              
              else{
                  if(currInitMem.getMemshipStatus()!=null)
                    return new FResult("error",
                                       "به اعضای دارای وضعیت " + currInitMem.getMemshipStatusText() +
                                       " کتاب امانت داده نمی شود.");
                  else{
                        DatabaseProcedure is_mem_of_currLib =
                            DatabaseProcedure.define("function parsi_pkg_library.IS_MEM_OF_LIB2(P_ART_ID NUMBER,CUR_LIB_ART_ID NUMBER)RETURN NUMBER;");
                        Number is_mem_of_lib2 =
                            ParsiUtil.convert_dec_to_number((BigDecimal)is_mem_of_currLib.call(getDBTransaction(),
                                                                                           currPers.getArtId(),
                                                                                           new Number(1)).getReturnValue());
                      if(new Number(0).equals(is_mem_of_lib2)){
                        return new FResult("error",
                                           (String)getMessageVO1().findByKey(new Key(new Object[] { "no_mem_cent_lib".toUpperCase() }),
                                                           -1)[0].getAttribute("Message"));
                    } else {
                        DatabaseProcedure mem_status =
                            DatabaseProcedure.define("FUNCTION parsi_pkg_library.MEM_STATUS(P_BARCODE VARCHAR2,T_LIB_ART_ID NUMBER) RETURN NUMBER;");
                        Number memStatus =
                            ParsiUtil.convert_dec_to_number((BigDecimal)mem_status.call(getDBTransaction(),
                                                                                        currPers.getBarcode(),
                                                                                        1).getReturnValue());
                        if (!(new Number(1).equals(memStatus) ||
                              new Number(3).equals(memStatus))) {
                                JSFUtils.addFacesErrorMessage ((String)getMessageVO1().findByKey(new Key(new Object[] { "illegal_mem_in_cent_lib".toUpperCase() }),
                                                           -1)[0].getAttribute("Message"));
                              
                        } else {
                                JSFUtils.addFacesErrorMessage ((String)getMessageVO1().findByKey(new Key(new Object[] { "no_mem_lib".toUpperCase() }),
                                                           -1)[0].getAttribute("Message"));
                              }
                          return null;
                      }
                      
                      }
                  
                  }
              
              }
          //Gheyre rasmi ha
          else{
              if(new Number(1).equals(is_mem_of_lib_result)){
                  
                  if(new Number(3).equals( currInitMem.getMemshipStatus()))
                    return new FResult("error",
                                       (String)getMessageVO1().findByKey(new Key(new Object[] { "no_loan_no_active".toUpperCase() }),
                                               -1)[0].getAttribute("Message"));
                else if (!(new Number(3).equals(currInitMem.getMemshipStatus()) ||
                           new Number(1).equals(currInitMem.getMemshipStatus())))
                    return new FResult("error",
                                       "به اعضای دارای وضعیت " + currInitMem.getMemshipStatusText() +
                                       " کتاب امانت داده نمی شود.");
                  
              
                DatabaseProcedure loan_capacity_full2 =
                    DatabaseProcedure.define("FUNCTION parsi_pkg_library.LOAN_CAPACITY_FULL2(p_BARCODE VARCHAR2,CUR_LIB_ART_ID NUMBER,memship_cat number,labcol1 number) RETURN number;");
                BigDecimal loan_capacity_full2_result =
                    (BigDecimal)loan_capacity_full2.call(getDBTransaction(),
                                                         currPers.getBarcode(),
                                                         getSession().getUserData().get("libartid"),
                                                         currInitMem.getMemshipCategory(),
                                                         getSession().getUserData().get("labcolno")).getReturnValue();
                
                pakage_variables.put("capacity_is_full",
                                     (new BigDecimal(1).equals(loan_capacity_full2_result)));
                
                  DatabaseProcedure lib_study_loan_capacity_full2 =
                    DatabaseProcedure.define("FUNCTION parsi_pkg_library.LIB_STUDY_LOAN_CAPACITY_FULL2(P_BARCODE VARCHAR2,CUR_LIB_ART_ID NUMBER,memship_cat number) RETURN number;");
                BigDecimal lib_study_loan_capacity_full2_result =
                    (BigDecimal)lib_study_loan_capacity_full2.call(getDBTransaction(),
                                                                   currPers.getBarcode(),
                                                                   getSession().getUserData().get("libartid"),
                                                                   currInitMem.getMemshipCategory()).getReturnValue();
                
                pakage_variables.put("place_cap_is_full",
                                     new BigDecimal(1).equals(lib_study_loan_capacity_full2_result));
                pakage_variables.put("loan_cap",currPers.getLoanRemindCap());   
              
                           
                DatabaseProcedure mem_loan_quota =
                  DatabaseProcedure.define("FUNCTION parsi_pkg_library.MEM_LOAN_QUOTA(P_BARCODE VARCHAR2,CUR_LIB_ART_ID NUMBER,memship_cat number) RETURN NUMBER;");
                BigDecimal mem_loan_quota_result =
                    (BigDecimal)mem_loan_quota.call(getDBTransaction(),
                                                    currPers.getBarcode(),
                                                    getSession().getUserData().get("libartid"),
                                                    currInitMem.getMemshipCategory()).getReturnValue();
                
                
                DatabaseProcedure mem_loan_durity =
                  DatabaseProcedure.define("FUNCTION parsi_pkg_library.MEM_LOAN_DURITY(P_BARCODE VARCHAR2,CUR_LIB_ART_ID NUMBER) RETURN NUMBER;");
                BigDecimal mem_loan_durity_result =
                    (BigDecimal)mem_loan_durity.call(getDBTransaction(),
                                                     currPers.getBarcode(),
                                                     getSession().getUserData().get("libartid")).getReturnValue();
                
                if (new BigDecimal(0).equals(mem_loan_quota_result) &&
                    new BigDecimal(0).equals(mem_loan_durity_result)) {
                pakage_variables.put("study_at_place", true);
                }
              
            } else
                return new FResult("error",
                                   (String)getMessageVO1().findByKey(new Key(new Object[] { "no_mem_lib".toUpperCase() }),
                                           -1)[0].getAttribute("Message"));
              }
              
              
        Number penalty =
            (currInitMem == null ? new Number(0) : ParsiUtil.NVL(currInitMem.getDebitSum()));
          if(penalty.intValue()>0) {
            JSFUtils.addFacesWarningMessage((String)getMessageVO1().findByKey(new Key(new Object[] { "mem_cash_penalty".toUpperCase() }),
                                              -1)[0].getAttribute("Message"));
          } 
          DatabaseProcedure mem_non_cash_penalty2 =
                  DatabaseProcedure.define("FUNCTION parsi_pkg_library.MEM_NON_CASH_PENALTY2(P_BARCODE VARCHAR2,CUR_LIB_ART_ID NUMBER) RETURN number;");
                BigDecimal mem_non_cash_penalty2_result =
            (BigDecimal)mem_non_cash_penalty2.call(getDBTransaction(),
                                                   currPers.getBarcode(),
                                                   getSession().getUserData().get("libartid")).getReturnValue();
              
          if(new BigDecimal(1).equals(mem_non_cash_penalty2_result)) {
           JSFUtils.addFacesWarningMessage((String)getMessageVO1().findByKey(new Key(new Object[] { "mem_non_cash_penalty".toUpperCase() }),
                                             -1)[0].getAttribute("Message"));
          }
          //:PERSON.NON_CASH_PENALTY_TEXT:=parsi_pkg_catalog.ITEM_TEXT('DEBIT_NON_CASH',1); ------>initMember.debitNonCashText
        if (new Number(2).equals(currPers.getPersType()) &&
            ParsiUtil.compareDates(currPers.getEndDate(),
                                   ParsiUtil.numberDateToString(ParsiUtil.DateToNumber())) <
            0) {
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "mem_expied".toUpperCase() }),
                                               -1)[0].getAttribute("Message"));
          }
          DatabaseProcedure lib_loan_num =
                  DatabaseProcedure.define("FUNCTION parsi_pkg_library.LIB_LOAN_NUM(P_BARCODE VARCHAR2,CUR_LIB_ART_ID NUMBER) RETURN NUMBER;");
                BigDecimal lib_loan_num_result =
            (BigDecimal)lib_loan_num.call(getDBTransaction(),
                                          currPers.getBarcode(),
                                          getSession().getUserData().get("libartid")).getReturnValue();
             
          DatabaseProcedure lib_study_loan_num =
                  DatabaseProcedure.define("FUNCTION parsi_pkg_library.LIB_STUDY_LOAN_NUM(P_BARCODE VARCHAR2,CUR_LIB_ART_ID NUMBER) RETURN NUMBER;");
                BigDecimal lib_study_loan_num_result =
            (BigDecimal)lib_study_loan_num.call(getDBTransaction(),
                                                currPers.getBarcode(),
                                                getSession().getUserData().get("libartid")).getReturnValue();
             
        Number temp1 =
            (lib_loan_num_result == null ? new Number(0) : ParsiUtil.convert_dec_to_number(lib_loan_num_result));
        Number temp2 =
            (lib_study_loan_num_result == null ? new Number(0) : ParsiUtil.convert_dec_to_number(lib_study_loan_num_result));
                
          Number cur_lib_loan_num=temp1.add(temp2);
          if((Boolean)pakage_variables.get("capacity_is_full")==true) {
            if (new Number(1).equals(getSession().getUserData().get("libartid")) &&
                new Number(19).equals(currPers.getDeptArtId()) &&
                new Number(90).equals(currPers.getSecArtId()) &&
                new Number(3).equals(currPers.getPersCategory())) {
            if(new Number(6).compareTo(cur_lib_loan_num)>0) {
              pakage_variables.put("capacity_is_full", false);
            }
            currPers.setLoanRemindCap(new Number(6).subtract(cur_lib_loan_num));
                pakage_variables.put("loan_cap",
                                     new Number(6).subtract(cur_lib_loan_num));
          }
          }
          if((Boolean)pakage_variables.get("capacity_is_full")==true) {
              if((Boolean)pakage_variables.get("place_cap_is_full")==true){
                if(new Number(0).equals(cur_lib_loan_num)) {
                    return new FResult("error",
                                       (String)getMessageVO1().findByKey(new Key(new Object[] { "sahmieh".toUpperCase() }),
                                                      -1)[0].getAttribute("Message"));
                  
                }
              }
          }
              
              
        return null;
        }
 
   
   public void insert_person_init_person() {
        PersonVORowImpl newPerson =
            (PersonVORowImpl)getPersonVO1().getCurrentRow();
      newPerson.setPersType(new Number(2));
      newPerson.setPersStatus(new Number(3));
   }

private boolean dupPersBarcode(String barcode) {
       DummyVOImpl dummy=getDummyVO1();
       dummy.setQuery("select * from person where barcode='"+barcode+"'");
       dummy.executeQuery();
        if (dummy.hasNext()) {
     
       return true;
   }
   
   return false;
    }

   public FResult insert_person_save() {
        PersonVORowImpl newPerson =
            (PersonVORowImpl)getPersonVO1().getCurrentRow();
       if( ParsiUtil.clearString(newPerson.getFname())==null) {
         return new FResult("error",
                            (String)getMessageVO1().findByKey(new Key(new Object[] { "FNAME_not_null".toUpperCase() }),
                                                              -1)[0].getAttribute("Message"));
       }
     if( ParsiUtil.clearString(newPerson.getLname())==null) {
       return new FResult("error",
                          (String)getMessageVO1().findByKey(new Key(new Object[] { "LNAME_not_null".toUpperCase() }),
                                                            -1)[0].getAttribute("Message"));
     }
     newPerson.setBarcode(ParsiUtil.clearString(newPerson.getBarcode())); 
     if(dupPersBarcode(newPerson.getBarcode())) {
            return new FResult("error",
                               "بارکد شخص تکراری است. یک بارکد دیگر وارد نمایید.");
     }
     if(new Number(2).equals(newPerson.getPersType())) {
         if(newPerson.getPostEndDate()==null) {
           DatabaseProcedure item_text =
             DatabaseProcedure.define("FUNCTION parsi_pkg_catalog.ITEM_TEXT(CAT_NAME VARCHAR2,ITEM_VAL NUMBER,labcol_no number) RETURN VARCHAR2;");
           
                String item_text_result =
                    (String)item_text.call(getDBTransaction(), "PRIVATE_POST",
                                           newPerson.getCmemSetupPost(),
                                           getSession().getUserData().get("labcolno")).getReturnValue();
                return new FResult("error",
                                   " به سیستم معرفی نشده است." + item_text_result +
                                   "دوره اعتبار سمت ");
            
         }
            if (ParsiUtil.NVL(newPerson.getPostEndDate()).compareTo(ParsiUtil.DateToNumber()) <
                1) {
       DatabaseProcedure item_text =
         DatabaseProcedure.define("FUNCTION parsi_pkg_catalog.ITEM_TEXT(CAT_NAME VARCHAR2,ITEM_VAL NUMBER,labcol_no number) RETURN VARCHAR2;");
       
                String item_text_result =
                    (String)item_text.call(getDBTransaction(), "PRIVATE_POST",
                                           newPerson.getCmemSetupPost(),
                                           getSession().getUserData().get("labcolno")).getReturnValue();
                return new FResult("error",
                                   " منقضی شده است." + item_text_result +
                                   "دوره اعتبار سمت ");
         }
        newPerson.setCmemsetupArtId(null);
        newPerson.setPersCategory(null);
        newPerson.setDegree(null);
        newPerson.setMjrArtId(null);
        newPerson.setSecArtId(null);
        newPerson.setDeptArtId(null);
     }
     if( ParsiUtil.clearString(newPerson.getBarcode())==null) {
       return new FResult("error",
                          (String)getMessageVO1().findByKey(new Key(new Object[] { "barcode_not_null".toUpperCase() }),
                                                            -1)[0].getAttribute("Message"));
     }
     newPerson.setFname(ParsiUtil.clearString(newPerson.getFname()));
     newPerson.setLname(ParsiUtil.clearString(newPerson.getLname()));
    getDBTransaction().commit();
     return null;
   }

   public FResult insert_person_post_insert() {
    
        PersonVORowImpl newPerson =
            (PersonVORowImpl)getPersonVO1().getCurrentRow();
                                                            
        MemberBarcodeHistoryVORowImpl newMemBarcdHist =
            (MemberBarcodeHistoryVORowImpl)newPerson.getMemberBarcodeHistory().createRow();
     newPerson.getMemberBarcodeHistory().insertRow(newMemBarcdHist);
     
      newMemBarcdHist.setPersArtId(newPerson.getArtId());
        newMemBarcdHist.setDayDate(ParsiUtil.DateToNumber());
        newMemBarcdHist.setBarcode(newPerson.getBarcode());
      
        newMemBarcdHist.setUserName((String)getSession().getUserData().get("username"));
     getDBTransaction().commit();
        if(new Number(2).equals(newPerson.getPersType())) {
            if (ParsiUtil.NVL(newPerson.getPostEndDate()).compareTo(ParsiUtil.DateToNumber()) <
                1) {
          DatabaseProcedure item_text =
            DatabaseProcedure.define("FUNCTION parsi_pkg_catalog.ITEM_TEXT(CAT_NAME VARCHAR2,ITEM_VAL NUMBER,labcol_no number) RETURN VARCHAR2;");
          
                String item_text_result =
                    (String)item_text.call(getDBTransaction(), "PRIVATE_POST",
                                           newPerson.getCmemSetupPost(),
                                           getSession().getUserData().get("labcolno")).getReturnValue();
                return new FResult("error",
                                   " منقضی شده است." + item_text_result +
                                   "دوره اعتبار سمت ");
            }
          
       
        RowIterator initMemberVO = newPerson.getInitMemberVO();
            InitMemberVORowImpl newInitMem =
                (InitMemberVORowImpl)initMemberVO.createRow();
        initMemberVO.insertRow(newInitMem);
        newInitMem.setLibArtId((Number)getSession().getUserData().get("libartid"));
        newInitMem.setPersArtId(newPerson.getArtId());
        newInitMem.setLoanedCount(new Number(0));
        newInitMem.setReservedCount(new Number(0));
        newInitMem.setRecalledCount(new Number(0));
        newInitMem.setMemshipCategory(new Number(2));
        newInitMem.setMemshipStatus(new Number(1));
        newInitMem.setDebitSum(new Number(0));
        newInitMem.setDebitNonCash(new Number(2));
        newInitMem.setLoanedInPlaceCount(new Number(0));
        newInitMem.setIntroductionLetterCount(new Number(0));
        getDBTransaction().commit();
        
            MemberStatusHistoryVORowImpl newMemStHist =
                (MemberStatusHistoryVORowImpl)newInitMem.getMemberStatusHistoryVO().createRow();
       newInitMem.getMemberStatusHistoryVO().insertRow(newMemStHist);
       newMemStHist.setStatus(new Number(1));
       newMemStHist.setDayDate(ParsiUtil.DateToNumber());
       newMemStHist.setUserName((String)getSession().getUserData().get("username"));
       newMemStHist.setIntmemArtId(newInitMem.getArtId());
       newMemStHist.setLibArtId((Number)getSession().getUserData().get("libartid"));
       
            MemberVoRowImpl newMember =
                (MemberVoRowImpl)getMemberVo1().createRow();
      getMemberVo1().insertRow(newMember);
      newMember.setArtId(newInitMem.getArtId());
      newMember.setLabcol((Number)getSession().getUserData().get("labcolno"));
      
          DatabaseProcedure active_post_art_id =
            DatabaseProcedure.define("FUNCTION parsi_pkg_library.ACTIVE_POST_ART_ID(POST_CODE NUMBER,labcol_no number)RETURN NUMBER;");
          
            BigDecimal active_post_art_id_result =
                (BigDecimal)active_post_art_id.call(getDBTransaction(),
                                                    newPerson.getCmemSetupPost(),
                                                    getSession().getUserData().get("labcolno")).getReturnValue();
            Number mem_setup_art_id =
                (active_post_art_id_result == null ? null :
                 new Number(active_post_art_id_result.longValue()));
            MemberExtensionHistoryRowImpl newMemExtHist =
                (MemberExtensionHistoryRowImpl)newInitMem.getMemberExtensionHistory().createRow();
        newInitMem.getMemberExtensionHistory().insertRow(newMemExtHist);
        newMemExtHist.setInsertDate(ParsiUtil.DateToNumber());
        newMemExtHist.setRecType(new Number(1));
        newMemExtHist.setMemsetupArtId(mem_setup_art_id);
        newMemExtHist.setMemArtId(newInitMem.getArtId());
        newMemExtHist.setUserName((String)getSession().getUserData().get("username"));
        newMemExtHist.setLabcol((Number)getSession().getUserData().get("labcolno"));
          getDBTransaction().commit();
        }
     return null;
   }
   
    public void login_apply_LibUser_UserNameVC(String userName) {
        LibUserVoImpl libUserVo = (LibUserVoImpl)getLibUserVo1();
        libUserVo.setuserNameParam(userName);
        libUserVo.setApplyViewCriteriaName("UserName_LibUserVoCriteria");
        libUserVo.executeQuery();
    }

    public void login_apply_person_IDVC(String ID,String type) {
    PersonVOImpl personVO=  getPersonVO_Login();
    personVO.setparam_ID(ID);
    if("student".equals(type)) {
      personVO.setparam_pers_category1(new Number(1));
      personVO.setparam_pers_category2(new Number(1));
    }else if("staff".equals(type)) {
      personVO.setparam_pers_category1(new Number(2));
      personVO.setparam_pers_category2(new Number(3));
    }
      personVO.setApplyViewCriteriaName("search_ID_VC");
      personVO.executeQuery();
    
      personVO.first();
    }

    public void login_apply_person_BarcodeVC(String barcode){
      PersonVOImpl personVo= getPersonVO_Login();
      personVo.setparam_barcode_equal(barcode);
      personVo.setApplyViewCriteriaName("search_unofficial_barcodeVC");
      personVo.executeQuery();
      personVo.first();
    }

    public FResult login_checkUserPass_student(String id,String password) {
      CallableStatement cstmt=null;
      Connection conn =null;
       try {
           id=ParsiUtil.clearString(id);
           password=ParsiUtil.clearString(password);
        
         if (id == null || password == null) {
             return new FResult("error",
                                "شناسه کاربری و رمز عبور را وارد نمایید.");
         }
         int int_id=  Integer.valueOf(id);
         InitMemberVOImpl initMembervo= getInitMemberVO_Login();
            InitMemberVORowImpl currInitMem =
                (InitMemberVORowImpl)initMembervo.getCurrentRow();
         
         if (currInitMem == null) {
                return new FResult("error",
                                   "لطفا یک کتابخانه را انتخاب کنید.");
         }
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           conn = DriverManager.getConnection("jdbc:sqlserver://192.168.111.111:1070;databaseName=UtGol;",
                   "Libuser",  "LB*#17QTS");
                 
        cstmt = conn.prepareCall("{? = call dbo.fx0269_stdauth(?,?,?)}");
       cstmt.registerOutParameter(1, Types.CHAR);
       cstmt.setString(2, id);
         cstmt.setString(3,password);
         cstmt.setInt(4, int_id);
       cstmt.execute();
        if("F".equalsIgnoreCase(cstmt.getString(1))) {
          
                return new FResult("error",
                                   "نام کاربری یا کلمه عبور اشتباه می باشد.");
        }
            PersonVORowImpl currPerson_login =
                (PersonVORowImpl)getPersonVO_Login().getCurrentRow();
           if(currPerson_login==null) {
                return new FResult("error",
                                   "مشخصات شما هنوز به سیستم کتابخانه منتقل نشده است.");
           }
         if (!new Number(1).equals(currPerson_login.getPersStatus())) {
                return new FResult("error", "این نام کاربری غیر فعال است.");
         }
         
         Map<String, String> secMap = new HashMap<String, String>();
         secMap.put("portal_librarysystem", "1");
         secMap.put("portal_loan", "1");
         secMap.put("portal_reserve","1");
         //TODO:write session jobs here
           LibraryRowImpl currLib = (LibraryRowImpl)currInitMem.getLibrary1();
            getSession().getUserData().put("labcol",
                                           currLib.getLibLabel().toString());
         getSession().getUserData().put("labcolno",currLib.getLibLabel());  
         getSession().getUserData().put("securitymap", secMap);
         getSession().getUserData().put("username","PORTAL");
            getSession().getUserData().put("libartid",
                                           currInitMem.getLibArtId());
            getSession().getUserData().put("libname",
                                           currInitMem.getLibName());
         
         PersonVOImpl personVo_orig = (PersonVOImpl)getPersonVO1();
         personVo_orig.setparam_ID(id);
         personVo_orig.setparam_pers_category1(new Number(1));
         personVo_orig.setparam_pers_category2(new Number(1));
         personVo_orig.setApplyViewCriteriaName("search_ID_VC");
         personVo_orig.executeQuery();
         personVo_orig.first();
        
       cstmt.close();
      conn.close();
         return new FResult("return", secMap);
       }catch (NumberFormatException nfe) {
            return new FResult("error",
                               "نام کاربری اشتباه می باشد لطفا شماره دانشجویی خود را وارد نمایید.");
       } 
       catch (SQLServerException e) {
          e.printStackTrace();
        
                 try {
                   if(cstmt!=null)
                     cstmt.close();
                     if(conn!=null)
                         conn.close();
                 } catch (SQLException f) {
                     f.printStackTrace();
                 }
                 return new FResult("error","خطا در اتصال به پایگاه داده سیستم آموزش.");
         } catch (ClassNotFoundException e) {
          e.printStackTrace();
          
                 try {
                   if(cstmt!=null)
                     cstmt.close();
                     if(conn!=null)
                         conn.close();
                 } catch (SQLException f) {
                     f.printStackTrace();
                 }
                 return new FResult("error","خطا در اتصال به پایگاه داده سیستم آموزش.");
        } catch (SQLException e) {
          e.printStackTrace();
          
                 try {
                   if(cstmt!=null)
                     cstmt.close();
                     if(conn!=null)
                         conn.close();
                 } catch (SQLException f) {
                     f.printStackTrace();
                 }
                 return new FResult("error","خطا در اتصال به پایگاه داده سیستم آموزش.");
        }

    }

    public FResult login_checkUserPass_staff(String id,
                                             String certificate_no) {
  id = ParsiUtil.clearString(id);
  certificate_no = ParsiUtil.clearString(certificate_no);

  if (id == null || certificate_no == null) {
      return new FResult("error",
                         "شناسه کاربری و رمز عبور را وارد نمایید.");
  }
  InitMemberVOImpl initMembervo= getInitMemberVO_Login();
        InitMemberVORowImpl currInitMem =
            (InitMemberVORowImpl)initMembervo.getCurrentRow();
 
  if (currInitMem == null) {
      return new FResult("error", "لطفا یک کتابخانه را انتخاب کنید.");
  }
LibraryRowImpl currLib = (LibraryRowImpl)currInitMem.getLibrary1();
  getSession().getUserData().put("labcol",
                                 currLib.getLibLabel().toString());
  getSession().getUserData().put("labcolno", currLib.getLibLabel());

 PersonVOImpl personVo= getPersonVO_Login();
 personVo.setparam_ID(id);
  personVo.setparam_pers_category1(new Number(2));
  personVo.setparam_pers_category2(new Number(3));
 personVo.setApplyViewCriteriaName("search_ID_VC");
 personVo.executeQuery();
 PersonVORowImpl currPerson = (PersonVORowImpl)personVo.first();
 
 
  if (currPerson == null) {

      return new FResult("error",
                         "این نام کاربری در این کتابخانه وجود ندارد.");
  }

  if (!new Number(1).equals(currPerson.getPersStatus())) {
      return new FResult("error",
                         "این نام کاربری در این کتابخانه غیر فعال است.");
  }
  if (!certificate_no.equalsIgnoreCase(currPerson.getCertificateNo())) {
      return new FResult("error", "رمز عبور صحیح نمی باشد.");
  }
  Map<String, String> secMap = new HashMap<String, String>();
  secMap.put("portal_librarysystem", "1");
  secMap.put("portal_loan", "1");
  secMap.put("portal_reserve","1");
  //TODO:write session jobs here
  getSession().getUserData().put("securitymap", secMap);
  getSession().getUserData().put("username","PORTAL");
  getSession().getUserData().put("libartid", currInitMem.getLibArtId());
  getSession().getUserData().put("libname", currInitMem.getLibName());
  
  PersonVOImpl personVo_orig = (PersonVOImpl)getPersonVO1();
  personVo_orig.setparam_ID(id);
  personVo_orig.setparam_pers_category1(new Number(2));
  personVo_orig.setparam_pers_category2(new Number(3));
  personVo_orig.setApplyViewCriteriaName("search_ID_VC");
  personVo_orig.executeQuery();
  personVo_orig.first();
  return new FResult("return", secMap);
}

    public FResult login_checkUserPass_unofficial_member(String barcode,
                                                         String certificate_no) {
    barcode = ParsiUtil.clearString(barcode);
    certificate_no = ParsiUtil.clearString(certificate_no);

    if (barcode == null || certificate_no == null) {
        return new FResult("error",
                           "شناسه کاربری و رمز عبور را وارد نمایید.");
    }
    InitMemberVOImpl initMembervo= getInitMemberVO_Login();
        InitMemberVORowImpl currInitMem =
            (InitMemberVORowImpl)initMembervo.getCurrentRow();
   
    if (currInitMem == null) {
        return new FResult("error", "لطفا یک کتابخانه را انتخاب کنید.");
    }
  LibraryRowImpl currLib = (LibraryRowImpl)currInitMem.getLibrary1();
    getSession().getUserData().put("labcol",
                                   currLib.getLibLabel().toString());
    getSession().getUserData().put("labcolno", currLib.getLibLabel());

   PersonVOImpl personVo= getPersonVO_Login();
   personVo.setparam_barcode_equal(barcode);
   personVo.setApplyViewCriteriaName("search_unofficial_barcodeVC");
   personVo.executeQuery();
   PersonVORowImpl currPerson = (PersonVORowImpl)personVo.first();
   
   
    if (currPerson == null) {

        return new FResult("error",
                           "این نام کاربری در این کتابخانه وجود ندارد.");
    }

    if (!new Number(1).equals(currPerson.getPersStatus())) {
        return new FResult("error",
                           "این نام کاربری در این کتابخانه غیر فعال است.");
    }
    if (!certificate_no.equalsIgnoreCase(currPerson.getCertificateNo())) {
        return new FResult("error", "رمز عبور صحیح نمی باشد.");
    }
    Map<String, String> secMap = new HashMap<String, String>();
    secMap.put("portal_librarysystem", "1");
    secMap.put("portal_loan", "1");
    secMap.put("portal_reserve","1");
    //TODO:write session jobs here
    getSession().getUserData().put("securitymap", secMap);
    getSession().getUserData().put("username","PORTAL");
    getSession().getUserData().put("libartid", currInitMem.getLibArtId());
    getSession().getUserData().put("libname", currInitMem.getLibName());
    
    PersonVOImpl personVo_orig = (PersonVOImpl)getPersonVO1();
   personVo_orig.setparam_barcode_equal(barcode);
    personVo_orig.setApplyViewCriteriaName("search_unofficial_barcodeVC");
    personVo_orig.executeQuery();
    personVo_orig.first();
    return new FResult("return", secMap);
  }

    public FResult login_checkUserPass_libOperator(String userName,
                                                   String password) {
        userName = ParsiUtil.clearString(userName);
        password = ParsiUtil.clearString(password);

        if (userName == null || password == null) {
            return new FResult("error",
                               "شناسه کاربری و رمز عبور را وارد نمایید.");
        }
        LibraryImpl libraryVo = (LibraryImpl)getLibrary2();
        LibraryRowImpl currLibrary = (LibraryRowImpl)libraryVo.getCurrentRow();
        if (currLibrary == null) {
            return new FResult("error", "لطفا یک کتابخانه را انتخاب کنید.");
        }

        getSession().getUserData().put("labcol",
                                       currLibrary.getLibLabel().toString());
        getSession().getUserData().put("labcolno", currLibrary.getLibLabel());

        LibUserVoImpl userVo = (LibUserVoImpl)getLibUserVo1();
        userVo.removeApplyViewCriteriaName("UserNameLabcol_LibUserVoCriteria");
        userVo.executeQuery();

        userVo.setuserNameParam(userName);
        //userVo.setlabcolParam(currLibrary.getMainLabcol());
        userVo.setApplyViewCriteriaName("UserNameLabcol_LibUserVoCriteria");
        userVo.executeQuery();
        LibUserVoRowImpl currUser = (LibUserVoRowImpl)userVo.getCurrentRow();
        if (currUser == null) {

            return new FResult("error",
                               "این نام کاربری در این کتابخانه وجود ندارد.");
        }

        if (!new Number(1).equals(currUser.getEnable())) {
            return new FResult("error",
                               "این نام کاربری در این کتابخانه غیر فعال است.");
        }
        if (!password.equalsIgnoreCase(currUser.getPassword())) {
            return new FResult("error", "رمز عبور صحیح نمی باشد.");
        }
//        MenuListVOImpl menuListVO = (MenuListVOImpl)getMenuListVO1();
//      MenuListVOImpl itemListVO = (MenuListVOImpl)getItemListVO1();
//        char[] securityCode =
//            new char[menuListVO.getRowCount() + itemListVO.getRowCount()];
//        char[] temp = null;
//        for (int i = 0; i < securityCode.length; i++) {
//            securityCode[i] = '0';
//        }
//        RowIterator roleIterator = currUser.getLibRoleVO();
//        LibRoleVORowImpl currLibRole = null;
//        while (roleIterator.hasNext()) {
//            currLibRole = (LibRoleVORowImpl)roleIterator.next();
//            temp = currLibRole.getSecurityCode().toCharArray();
//            for (int i = 0; i < temp.length; i++) {
//                if (securityCode[i] == '1')
//                    continue;
//                securityCode[i] = temp[i];
//            }
//        }
//        Map<String, String> secMap = new HashMap<String, String>();
//        MenuListVORowImpl currMenu = null;
//        while (menuListVO.hasNext()) {
//            currMenu = (MenuListVORowImpl)menuListVO.next();
//            secMap.put(currMenu.getPage(),
//                       String.valueOf(securityCode[currMenu.getSecCodePosition().intValue()]));
//        }
//      while (itemListVO.hasNext()) {
//          currMenu = (MenuListVORowImpl)itemListVO.next();
//          secMap.put(currMenu.getPage(),
//                     String.valueOf(securityCode[currMenu.getSecCodePosition().intValue()]));
//      }
         Map<String, String> secMap =login_createSecMap(currUser);
        //TODO:write session jobs here
        getSession().getUserData().put("securitymap", secMap);
        getSession().getUserData().put("username", currUser.getUserName());
        getSession().getUserData().put("libartid", currLibrary.getArtId());
        getSession().getUserData().put("libname", currLibrary.getLibName());

        userVo.setApplyViewCriteriaName("Labcol_LibUserVoCriteria");
        userVo.executeQuery();
       return new FResult("return", secMap);
       // return null;
    }
    
    public Map<String, String> login_createSecMap(LibUserVoRowImpl currUser) {
      MenuListVOImpl menuListVO = (MenuListVOImpl)getMenuListVO1();
      MenuListVOImpl itemListVO = (MenuListVOImpl)getItemListVO1();
      char[] securityCode =
          new char[menuListVO.getRowCount() + itemListVO.getRowCount()];
      char[] temp = null;
      for (int i = 0; i < securityCode.length; i++) {
          securityCode[i] = '0';
      }
      RowIterator roleIterator = currUser.getLibRoleVO();
      LibRoleVORowImpl currLibRole = null;
      while (roleIterator.hasNext()) {
          currLibRole = (LibRoleVORowImpl)roleIterator.next();
          temp = currLibRole.getSecurityCode().toCharArray();
          for (int i = 0; i < temp.length; i++) {
              if (securityCode[i] == '1')
                  continue;
              securityCode[i] = temp[i];
          }
      }
      Map<String, String> secMap = new HashMap<String, String>();
      MenuListVORowImpl currMenu = null;
      while (menuListVO.hasNext()) {
          currMenu = (MenuListVORowImpl)menuListVO.next();
          secMap.put(currMenu.getPage(),
                     String.valueOf(securityCode[currMenu.getSecCodePosition().intValue()]));
      }
      while (itemListVO.hasNext()) {
        currMenu = (MenuListVORowImpl)itemListVO.next();
        secMap.put(currMenu.getPage(),
                   String.valueOf(securityCode[currMenu.getSecCodePosition().intValue()]));
      }
      return secMap;
    }

    public ArrayList<String> roleAndPermission_getAllUsersItem() {
        ArrayList<String> allItems = new ArrayList<String>();
        ViewObjectImpl libUser = getLibUserVo1();
      libUser.executeQuery();
        libUser.reset();

        String temp = "";
        while (libUser.hasNext()) {
            temp = (String)libUser.next().getAttribute("UserName");
            allItems.add(temp);

        }
        return allItems;
    }

    public void roleAndPermission_initAccessTree() {
        //   System.out.println("in init access tree");
        LibRoleVORowImpl currLibRole =
            (LibRoleVORowImpl)getLibRoleVO1().getCurrentRow();
        if (currLibRole != null) {
            String secCode = currLibRole.getSecurityCode();

            ViewObjectImpl menuList = getMenuListVO1();
            MenuListVORowImpl r = null;
            int position = 0;
            RowSetIterator createRowSetIterator =
                menuList.createRowSetIterator(null);
            while (createRowSetIterator.hasNext()) {
                r = (MenuListVORowImpl)createRowSetIterator.next();
                position =
                        ((Number)r.getAttribute("SecCodePosition")).intValue();
                // r.getEntity(0).populateAttribute(6,(secCode==null?false: secCode.charAt(position) == '1'),false,true,true);
                r.setAttribute("Slct",
                               (secCode == null ? false : secCode.charAt(position) ==
                                '1'));
            }
            createRowSetIterator.closeRowSetIterator();
            
          ViewObjectImpl itemList = getItemListVO1();
        
           position = 0;
          RowSetIterator itemRowSetIterator =
              itemList.createRowSetIterator("item");
          while (itemRowSetIterator.hasNext()) {
              r = (MenuListVORowImpl)itemRowSetIterator.next();
              position =
                      ((Number)r.getAttribute("SecCodePosition")).intValue();
              // r.getEntity(0).populateAttribute(6,(secCode==null?false: secCode.charAt(position) == '1'),false,true,true);
              r.setAttribute("Slct",
                             (secCode == null ? false : secCode.charAt(position) ==
                              '1'));
          }
          itemRowSetIterator.closeRowSetIterator();
        }
    }

    public void roleAndPermission_initAccessTreeForFirst() {
        // System.out.println("in init access tree first row");
        LibRoleVORowImpl currLibRole =
            (LibRoleVORowImpl)getLibRoleVO1().first();
        if (currLibRole != null) {
            String secCode = currLibRole.getSecurityCode();

            ViewObjectImpl menuList = getMenuListVO1();

            MenuListVORowImpl r = null;
            int position = 0;

            RowSetIterator createRowSetIterator =
                menuList.createRowSetIterator(null);


            while (createRowSetIterator.hasNext()) {
                r = (MenuListVORowImpl)createRowSetIterator.next();
                position =
                        ((Number)r.getAttribute("SecCodePosition")).intValue();
                r.setAttribute("Slct",
                               (secCode == null ? false : secCode.charAt(position) ==
                                '1'));
                //r.getEntity(0).populateAttribute(6,(secCode==null?false: secCode.charAt(position) == '1'),false,true,true);
            }
            createRowSetIterator.closeRowSetIterator();
            //        menuList.executeQuery();
            menuList.first();

        }
    }


    public FResult roleAndPermission_insertUserList_role(List userRoleList) {
        List insertedList;
        boolean changeFlag = false;
//        if (userRoleList.size() == 0)
//            return new FResult("info", "لطفا کاربر مورد نظر را انتخاب کنید.");
        //get role ArtId
        LibRoleVOImpl roleVo = (LibRoleVOImpl)getLibRoleVO1();
        LibRoleVORowImpl currRole = (LibRoleVORowImpl)roleVo.getCurrentRow();
        //RowIterator currUserList = currRole.getLibUserVo();
        insertedList =
                findAddedUsers(userRoleList, currRole.getArtId());


        for (int i = 0; i < insertedList.size(); i++) {

            LibUserRoleVoImpl user_roleVo =
                (LibUserRoleVoImpl)getLibUserRoleVo_Role();
            LibUserRoleVoRowImpl newuser_role =
                (LibUserRoleVoRowImpl)user_roleVo.createRow();
            user_roleVo.insertRow(newuser_role);

            newuser_role.setLabcol((Number)getDBTransaction().getSession().getUserData().get("labcolno"));
            newuser_role.setLibuserUserName(insertedList.get(i).toString());


            newuser_role.setLibroleArtId(currRole.getArtId());
            getDBTransaction().commit();
            changeFlag = true;
            user_roleVo.executeQuery();
        }
        changeFlag=(RemoveUsers(userRoleList) || changeFlag);
        if (changeFlag)
            return new FResult("info",
                               "برای نقش " + "\"" + currRole.getDescription() +
                               "\"" + " کاربران انتخاب شده ثبت گردید.");
        else
            return new FResult("info", "تغییری برای ثبت یافت نشد.");
    }

    private Boolean RemoveUsers(List userRoleList) {
        
        LibRoleVORowImpl currRole =
            (LibRoleVORowImpl)getLibRoleVO1().getCurrentRow();
        RowIterator userRoleVo = currRole.getLibUserRoleVo();
        LibUserRoleVoRowImpl currUserRole=null;
        Boolean isAnyRemove=false;
        while(userRoleVo.hasNext()) {
             currUserRole = (LibUserRoleVoRowImpl)userRoleVo.next();
            if (userRoleList == null ||
                !userRoleList.contains(currUserRole.getLibuserUserName())) {
            currUserRole.remove();
            isAnyRemove=true;
          }
        }
        getDBTransaction().commit();
        return isAnyRemove;
    }

    private List findAddedUsers(List userRoleList, Number roleArtId) {
        List toInserList = new ArrayList();

        for (int i = 0; userRoleList!=null && i < userRoleList.size(); i++) {
            DummyVOImpl dummyVO1 = getDummyVO1();
            dummyVO1.setQuery("SELECT LibUser.USER_NAME,LibUserRole.LIBROLE_ART_ID FROM LIB_USER LibUser, LIB_USER_ROLE LibUserRole " +
                              "WHERE((LibUserRole.LIBROLE_ART_ID = " +
                              roleArtId +
                              " AND   LibUser.LABCOL = LibUserRole.LABCOL AND LibUser.USER_NAME = LibUserRole.LIBUSER_USER_NAME) AND " +
                              "LibUser.USER_NAME = '" +
                              userRoleList.get(i).toString() +
                              "') and LibUser.LABCOL=" +
                              getSession().getUserData().get("labcolno"));

            dummyVO1.executeQuery();
            int cnt = dummyVO1.getRowCount();
            if (cnt == 0)
                toInserList.add(userRoleList.get(i).toString());
        }

        return toInserList;
    }

    public FResult roleAndPermission_insertUser(String name, String userName,
                                                String password) {
        //get role ArtId
        LibRoleVOImpl roleVo = (LibRoleVOImpl)getLibRoleVO1();
        LibRoleVORowImpl currRole = (LibRoleVORowImpl)roleVo.getCurrentRow();


        getDBTransaction().rollback();
        if (ParsiUtil.clearString(name) == null ||
            ParsiUtil.clearString(userName) == null ||
            ParsiUtil.clearString(password) == null)
            return new FResult("error", "مشخصات کاربر را کامل کنید.");
        //Insert new user into LibUser
        LibUserVoImpl userVo = (LibUserVoImpl)getLibUserVo_insertUser();
        DummyVOImpl dummyVO1 = getDummyVO1();
        dummyVO1.setQuery("SELECT * FROM LIB_USER LibUser where "+
                          " UPPER(LibUser.USER_NAME)='" +
                          userName.toUpperCase() + "'");

        dummyVO1.executeQuery();
        int cnt = dummyVO1.getRowCount();
        if (cnt > 0)
            return new FResult("error", "نام کاربری تکراری است.");

        LibUserVoRowImpl newRec = (LibUserVoRowImpl)userVo.createRow();

        newRec.setLabcol((Number)getDBTransaction().getSession().getUserData().get("labcolno"));
        newRec.setName(name);
        newRec.setUserName(userName);
        newRec.setPassword(password);
        newRec.setEnable(new Number(1));
        try {
            newRec.validate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return new FResult("error","خطا در ثبت کاربر جدید.");
        }
        userVo.insertRow(newRec);
        getDBTransaction().commit();
        //Insert new user & role into LibUserRole


//        LibUserRoleVoImpl user_roleVo =
//            (LibUserRoleVoImpl)getLibUserRoleVo_Role();
//        //getLibUserRoleVo1();
//        LibUserRoleVoRowImpl newuser_role =
//            (LibUserRoleVoRowImpl)user_roleVo.createRow();
//        user_roleVo.insertRow(newuser_role);
//
//        newuser_role.setLabcol((Number)getDBTransaction().getSession().getUserData().get("labcolno"));
//        newuser_role.setLibuserUserName(userName);
//        newuser_role.setLibroleArtId(new Number(currRole.getArtId().getValue()));
//
//
//        getDBTransaction().commit();

        userVo.executeQuery();

        return new FResult("info", "کاربر جدید ثبت گردید.");
    }


    public FResult roleAndPermission_insertPermision() {
        String secCode = "";
        char[] securityChars = null;
        LibRoleVOImpl roleVo = getLibRoleVO1();
        LibRoleVORowImpl currentRole =
            (LibRoleVORowImpl)roleVo.getCurrentRow();
        ViewObjectImpl menuListVo = getMenuListVO1();
        RowSet menuListRowSet = menuListVo.createRowSet(null);
      ViewObjectImpl itemListVo = getItemListVO1();
      RowSet itemListRowSet = itemListVo.createRowSet("item");
        securityChars =
                new char[menuListVo.getRowCount() + itemListRowSet.getRowCount()];
        securityChars[0] = '1'; //  سیستم جامع کتابخانه
        MenuListVORowImpl currMenuNode = null;
        while (menuListRowSet.hasNext()) {
            currMenuNode = (MenuListVORowImpl)menuListRowSet.next();
            securityChars[currMenuNode.getSecCodePosition().intValue()] =
                    currMenuNode.getSlct() ? '1' : '0';
        }
      while (itemListRowSet.hasNext()) {
          currMenuNode = (MenuListVORowImpl)itemListRowSet.next();
          securityChars[currMenuNode.getSecCodePosition().intValue()] =
                  currMenuNode.getSlct() ? '1' : '0';
      }
      itemListRowSet.closeRowSet();
        menuListRowSet.closeRowSet();
        secCode = String.valueOf(securityChars);
        currentRole.setSecurityCode(secCode);
        getDBTransaction().commit();

        return new FResult("info", "دسترسی با موفقیت ذخیره شد.");

    }

    public void roleAndPermission_CheckChildren(Number rootArtId,
                                                Boolean newValue) {
        MenuListVORowImpl currMenuList =
            (MenuListVORowImpl)getMenuListVO1().findByKey(new Key(new Object[] { rootArtId }),
                                                          -1)[0];
        RowIterator children = currMenuList.getMenuListVO_Children();
        while (children.hasNext()) {
            Row r = children.next();
            r.setAttribute("Slct", newValue);
            roleAndPermission_CheckChildren((Number)r.getAttribute("ArtId"),
                                            newValue);
        }
        // getDBTransaction().commit();
    }

    public void roleAndPermission_CheckParents(Number childArtId) {
        MenuListVORowImpl currMenuList =
            (MenuListVORowImpl)getMenuListVO1().findByKey(new Key(new Object[] { childArtId }),
                                                          -1)[0];
        Row parent = currMenuList.getMenuListVO_Parent();
        if (parent != null) {
            parent.setAttribute("Slct", true);
            roleAndPermission_CheckParents((Number)parent.getAttribute("ArtId"));
        }
    }

    public void roleAndPermission_UncheckParents(Number childArtId) {
        MenuListVORowImpl currMenuList =
            (MenuListVORowImpl)getMenuListVO1().findByKey(new Key(new Object[] { childArtId }),
                                                          -1)[0];
        MenuListVORowImpl parent =
            (MenuListVORowImpl)currMenuList.getMenuListVO_Parent();
        if (parent != null) {
            RowIterator siblings = parent.getMenuListVO_Children();
            Boolean flag = false;
            A:
            while (siblings.hasNext()) {
                Row r = siblings.next();
                if (((Boolean)r.getAttribute("Slct")) == true)
                    if (!childArtId.equals(r.getAttribute("ArtId"))) {
                        flag = true;
                        break A;
                    }

            }
            if (flag == false) {
                parent.setSlct(false);
                roleAndPermission_UncheckParents(parent.getArtId());
            }
        }
    }

  public FResult cid_return_afterSearchBarcode() {

      ReturnBookVORowImpl retBook =
          (ReturnBookVORowImpl)getReturnBookVO1().getCurrentRow();
      if (retBook == null)
          return new FResult("error",
                             (String)getMessageVO1().findByKey(new Key(new Object[] { "barcode_not_exist".toUpperCase() }),
                                                               -1)[0].getAttribute("Message"));

  if(retBook.getBarcode()==null) {
  return new FResult("error",
                   (String)getMessageVO1().findByKey(new Key(new Object[] { "barcode_not_null".toUpperCase() }),
                                                     -1)[0].getAttribute("Message"));

  }
      DummyVOImpl dummyVO1 = getDummyVO1();
      dummyVO1.setQuery(" select *  from loan where phbook_art_id=" +
                          retBook.getArtId() +
                          " and real_ret_date is null and labcol=" +
                          getSession().getUserData().get("labcolno"));
      dummyVO1.executeQuery();
      int cnt = dummyVO1.getRowCount();

      if (cnt == 0)
          return new FResult("error",
                             (String)getMessageVO1().findByKey(new Key(new Object[] { "barcode_not_loaned".toUpperCase() }),
                                                               -1)[0].getAttribute("Message"));
      else if (cnt > 1)
          return new FResult("error",
                             (String)getMessageVO1().findByKey(new Key(new Object[] { "conflict".toUpperCase() }),
                                                               -1)[0].getAttribute("Message"));
      //******calculating Delay and Penalty
     
    retBook.setPenaltyOffer(new Number(0));
    retBook.setDelayDay("0");
    retBook.setDelayMonth("0");
    retBook.setPenaltyValue(new Number(0));
    
        int penaltyStatus =
            (retBook.getPenaltyStatus() == null ? 2 : retBook.getPenaltyStatus().intValue());
      

      LoanVORowImpl currLoan = (LoanVORowImpl)retBook.getLoan_NullRetVO();
      if (penaltyStatus == 1 &&
          currLoan.getRetDate().longValue() < ParsiUtil.DateToNumber().longValue()) {

        
            PDate pd =
                ParsiUtil.monthAndDayBetweenTwoDate(currLoan.getRetDate(),
                                                    ParsiUtil.DateToNumber());
        retBook.setDelayDay(pd.getDay().toString());
        retBook.setDelayMonth(pd.getMonth().toString());
        
            retBook.setHolyWeek(weekend(currLoan.getRetDate(),
                                        ParsiUtil.DateToNumber()).add(holiday(currLoan.getRetDate(),
                                                                              ParsiUtil.DateToNumber())).toString());
        
          DatabaseProcedure delayPenalty =
              DatabaseProcedure.define("FUNCTION parsi_pkg_library.LOAN_DELAY_PENALTY(loan_art_id NUMBER,day_date number, labcol_num NUMBER) RETURN NUMBER;");
          BigDecimal delayPenalty_result =
              (BigDecimal)delayPenalty.call(getDBTransaction(),
                                              currLoan.getArtId().getSequenceNumber(),
                                              ParsiUtil.DateToNumber(),
                                            (Number)getSession().getUserData().get("labcolno")).getReturnValue();

          if(new Number(-1).equals(delayPenalty_result)) {
                JSFUtils.addFacesErrorMessage("برای نوع کتاب " +
                                              retBook.getBookTypeText() +
                                              " جریمه تعریف نشده است.");
            } else {
          retBook.setPenaltyValue(ParsiUtil.NVL(ParsiUtil.convert_dec_to_number(delayPenalty_result)));
            retBook.setPenaltyOffer(retBook.getPenaltyValue());
          }
          //retBook.setPenaltyOffer(new Number(delayPenalty_result.longValue()));
         

          //getDBTransaction().commit();
      }
    //  retBook.setPenaltyOffer(ParsiUtil.NVL(retBook.getPenaltyValue()));
      Boolean hasPenalty=false;
      if (penaltyStatus == 2 || retBook.getPenaltyOffer().intValue() == 0) {
          retBook.setPenaltyValue(new Number(0));
          
         
      }else {
        hasPenalty=true;
      }

      return new FResult("return",hasPenalty);
  }


  public FResult cid_return_preReturn(Number penalty) {
      if (new Number(0).equals(ParsiUtil.NVL(penalty)))
          return new FResult("yn_popup",
                             (String)getMessageVO1().findByKey(new Key(new Object[] { "returning".toUpperCase() }),
                                                               -1)[0].getAttribute("Message"));
      else
          return new FResult("yn_popup",
                             (String)getMessageVO1().findByKey(new Key(new Object[] { "returning_register_penalty".toUpperCase() }),
                                                               -1)[0].getAttribute("Message"));

  }

  public FResult cid_return_return_btn(String description, Number penalty) {


      ReturnBookVORowImpl retBook =
          (ReturnBookVORowImpl)getReturnBookVO1().getCurrentRow();
      if(retBook==null) {
            return new FResult("error", "لطفا اول یک کتاب جستجو کنید.");
        
      }
  
      LoanVORowImpl currLoan = (LoanVORowImpl)retBook.getLoan_NullRetVO();
      if (currLoan == null) {
          return new FResult("error",
                             (String)getMessageVO1().findByKey(new Key(new Object[] { "barcode_not_loaned".toUpperCase() }),
                                                               -1)[0].getAttribute("Message"));
      }
    boolean isReserved = false;
    Number existSt = new Number(1);
      InitMemberVORowImpl currInitMem =
          (InitMemberVORowImpl)currLoan.getInitMemberVO();
      currLoan.setRealRetDate(ParsiUtil.DateToNumber());
      currLoan.setReturnUser((String)getSession().getUserData().get("username"));
      currLoan.setReturnType(new Number(1));


      //***********Reserve


      DummyVOImpl dummyVO1 = getDummyVO1();

      dummyVO1.setQuery("SELECT min(ART_ID) FROM RESERVE " +
                        "WHERE ACTIVE=1 AND VBOOK_ART_ID=" +
                        retBook.getArtId2() + " AND NVL(VOL_NO,'0')= NVL('" +
                        ParsiUtil.stringToZeroValue(retBook.getVolNo()) +
                        "','0')" + " AND NVL(PART_NO,'0')=NVL('" +
                        ParsiUtil.stringToZeroValue(retBook.getPartNo()) +
                          "','0') and labcol=" +
                          getSession().getUserData().get("labcolno"));
      dummyVO1.executeQuery();
      

      int vbookReservedArtId = 0;
      if (dummyVO1.first().getAttribute("Dummy") != null) {
          vbookReservedArtId =
                  Integer.valueOf(dummyVO1.getCurrentRow().getAttribute("Dummy").toString());
     
          isReserved = true;
          existSt = new Number(8);
          ReserveVOImpl reserveVo = (ReserveVOImpl)getReserveCurrLabcolVO();


          //TODO:reserveVo find by key
          //Key labKey = new Key(new Object[] { "labcol", "ArtId" });

          //             Object [] keyValues = new Object[2];
          //
          //              keyValues[0] = (Number)getDBTransaction().getSession().getUserData().get("labcolno");  // All employees
          //              keyValues[1] =vbookReservedArtId;
          ReserveVORowImpl reserveRow =
              (ReserveVORowImpl)reserveVo.findByKey(new Key(new Object[] { (Number)getDBTransaction().getSession().getUserData().get("labcolno"),
                                                                             new Number(vbookReservedArtId) }),
                                                      -1)[0];
          //(ReserveVORowImpl)reserveVo.findByKey(new Key(keyValues),-1)[0];

          reserveRow.setActive(new Number(2));
          reserveRow.setRetDate(ParsiUtil.DateToNumber());
          JSFUtils.addFacesInfoMessage((String)getMessageVO1().findByKey(new Key(new Object[] { "book_has_reserve".toUpperCase() }),
                                                                         -1)[0].getAttribute("Message"));
      } else {

          dummyVO1.setQuery("SELECT max(TEXT) FROM CATALOG_DETAIL " +
                              "WHERE CAT_ART_ID=13 AND VALUE=1 and labcol=" +
                              getSession().getUserData().get("labcolno"));
          dummyVO1.executeQuery();
          
            String text = (String)dummyVO1.first().getAttribute("Dummy");
            if (ParsiUtil.clearString(text) != null &&
                text.equalsIgnoreCase("فعال"))
              existSt = new Number(9);
          else
              existSt = new Number(1);
      }
      //*************Update physicalBook
      String tempStatusChangeUser = retBook.getStatusChangeUser();
      Number tempStatusChangeDate = retBook.getStatusChangeDate();
      Number tempExistanceStatus = retBook.getExistenceStatus();

      retBook.setExistenceStatus(existSt);
      retBook.setStatusChangeDate(ParsiUtil.DateToNumber());
      retBook.setStatusChangeUser((String)getSession().getUserData().get("username"));

      //**********Update BookStatusHistory
      EntityDefImpl bookStHstDef =
          EntityDefImpl.findDefObject("org.parsisys.tehranuniversity.library.model.eo.BookStatusHistory");
      BookStatusHistoryImpl bookStHist =
          (BookStatusHistoryImpl)bookStHstDef.createInstance2(getDBTransaction(),
                                                              null);

      bookStHist.setDayDate(tempStatusChangeDate);
      bookStHist.setLoanStatus(retBook.getLoanStatus());
      bookStHist.setSafetyStatus(retBook.getSafetyStatus());
      bookStHist.setExistenceStatus(tempExistanceStatus);
      bookStHist.setPlace(retBook.getPlace());
      bookStHist.setPhbookArtId(retBook.getArtId());
      bookStHist.setUserName(tempStatusChangeUser);
      bookStHist.setLabcol((Number)(getDBTransaction().getSession().getUserData().get("labcolno")));

      //**********Insert Penalty
      if (penalty != null && penalty.intValue()>=0) { 
          EntityDefImpl loanCashPenaltyDef =
              EntityDefImpl.findDefObject("org.parsisys.tehranuniversity.library.model.eo.LoanCashPenalty");
          LoanCashPenaltyImpl loanCashPenalty =
              (LoanCashPenaltyImpl)loanCashPenaltyDef.createInstance2(getDBTransaction(),
                                                                      null);

          loanCashPenalty.setValue(penalty);
          loanCashPenalty.setDayDate(ParsiUtil.DateToNumber());
          loanCashPenalty.setDescription(description);
          loanCashPenalty.setLoanArtId(currLoan.getArtId().getSequenceNumber());
          loanCashPenalty.setUserName((String)getSession().getUserData().get("username"));
          loanCashPenalty.setLoanPenaltyType(new Number(1));
          loanCashPenalty.setLabcol((Number)(getSession().getUserData().get("labcolno")));
      }
      getDBTransaction().commit();
      //***************update InitMEMBER
      dummyVO1.setQuery("SELECT * FROM LOAN WHERE MEM_ART_ID=" +
                         currInitMem.getArtId() +
                        " AND REAL_RET_DATE IS NULL AND LOAN_TYPE IN (1,2)");
      dummyVO1.executeQuery();
      int cntLoanNum = dummyVO1.getRowCount();

      dummyVO1.setQuery("SELECT * FROM LOAN WHERE MEM_ART_ID=" +
                        currInitMem.getArtId() +
                        "AND REAL_RET_DATE IS NULL AND LOAN_TYPE=3");
      dummyVO1.executeQuery();
      int cntPlaceLoan = dummyVO1.getRowCount();

      dummyVO1.setQuery("SELECT * from reserve  where mem_art_id=" +
                        currInitMem.getArtId() + " AND ACTIVE IN(1,2)");
      dummyVO1.executeQuery();
      int cntMemReserve = dummyVO1.getRowCount();

      dummyVO1.setQuery("SELECT * FROM INTRODUCTION_LETTER WHERE MEM_ART_ID=" +
                        currInitMem.getArtId() +
                        " AND CANCELLATION_USER IS NULL AND CANCEL_DATE IS NULL");
      dummyVO1.executeQuery();
      int cntIntroLetter = dummyVO1.getRowCount();


      dummyVO1.setQuery("SELECT SUM(VALUE) FROM  penalty_payment " +
                        "WHERE mem_art_id=" + currInitMem.getArtId());
      dummyVO1.executeQuery();
      

      int totalPayment = 0;
      if (dummyVO1.first().getAttribute("Dummy") != null)
          totalPayment =
                  Integer.valueOf(dummyVO1.getCurrentRow().getAttribute("Dummy").toString());

      dummyVO1.setQuery("SELECT SUM(VALUE) FROM  loan_cash_penalty " +
                        "WHERE LOAN_ART_ID in (SELECT art_id FROM loan WHERE mem_art_id=" +
                        currInitMem.getArtId() + ")");

      dummyVO1.executeQuery();
      

      int loanPenalty = 0;
      if (dummyVO1.first().getAttribute("Dummy") != null)
          loanPenalty =
                  Integer.valueOf(dummyVO1.getCurrentRow().getAttribute("Dummy").toString());

      dummyVO1.setQuery("SELECT SUM(VALUE)  FROM  public_cash_penalty " +
                        "WHERE MEM_ART_ID=" + currInitMem.getArtId());
      dummyVO1.executeQuery();
      
      int publicPenalty = 0;
      if (dummyVO1.first().getAttribute("Dummy") != null)
          publicPenalty =
                  Integer.valueOf(dummyVO1.getCurrentRow().getAttribute("Dummy").toString());

      int totalPenalty = loanPenalty + publicPenalty;


      //***********Update InitMem
      currInitMem.setLoanedCount(new Number(cntLoanNum));
      currInitMem.setLoanedInPlaceCount(new Number(cntPlaceLoan));
      currInitMem.setReservedCount(new Number(cntMemReserve));
      currInitMem.setIntroductionLetterCount(new Number(cntIntroLetter));
      currInitMem.setDebitSum(ParsiUtil.NVL(new Number(totalPenalty -
                                                       totalPayment))); //debit_sum=total_penalty-NVL(total_mem_payment,0)

      getDBTransaction().commit();
      if(isReserved && vbookReservedArtId!=0){
            return new FResult("return",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "book_returned".toUpperCase() }),
                                                                 -1)[0].getAttribute("Message"),vbookReservedArtId);
          
          }

    return new FResult("info",
                       (String)getMessageVO1().findByKey(new Key(new Object[] { "book_returned".toUpperCase() }),
                                                         -1)[0].getAttribute("Message"));
  }


    public FResult cid_clearing_checkPerson(String barcode) {

        if (ParsiUtil.clearString(barcode) == null)
            return new FResult("error", "بارکد نمی تواند خالی باشد.");

        pakage_variables.put("clearInterLib",  false);
        pakage_variables.put("raiseFlag" , false);
        Boolean enable_btn=false;
        Boolean raiseFlag=false;
        barcode = barcode.trim();
        AllPersonVOImpl allPersVo = (AllPersonVOImpl)getAllPersonRoVO1();
        allPersVo.setbarcode_no(barcode);
        allPersVo.executeQuery();
        int cnt = allPersVo.getRowCount();

        if (cnt == 0)
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "barcode_not_exist".toUpperCase() }),
                                                                 -1)[0].getAttribute("Message"));


        PersonVOImpl personVO = (PersonVOImpl)getPersonVO1();
        PersonVORowImpl currPerson = (PersonVORowImpl)personVO.getCurrentRow();
        InitMemberVORowImpl currInitMem =
            (InitMemberVORowImpl)currPerson.getInitMemberCurrLibVO1();


        if (new Number(2).equals(ParsiUtil.NVL(currInitMem.getMemshipStatus()))){
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "mem_cleared".toUpperCase() }),
                                                                 -1)[0].getAttribute("Message"));
        }
        if (new Number(4).equals(ParsiUtil.NVL(currInitMem.getMemshipStatus()))) {
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "illegal_mem".toUpperCase() }),
                                                                 -1)[0].getAttribute("Message"));
        }
        DatabaseProcedure is_mem_of_lib =
            DatabaseProcedure.define("FUNCTION parsi_pkg_library.IS_MEM_OF_LIB2(P_ART_ID NUMBER,CUR_LIB_ART_ID NUMBER)RETURN NUMBER;");
        BigDecimal is_mem_of_lib_result =
            (BigDecimal)is_mem_of_lib.call(getDBTransaction(),
                                           currPerson.getArtId(),
                                           (Number)getSession().getUserData().get("libartid")).getReturnValue();

        if (currInitMem.getArtId() == null ||
            is_mem_of_lib_result.intValue() == 0) {
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "no_mem_lib".toUpperCase() }),
                                                                 -1)[0].getAttribute("Message"));
        }
//        DatabaseProcedure memship_category =
//            DatabaseProcedure.define("FUNCTION parsi_pkg_library.MEMSHIP_CATEGORY(P_BARCODE VARCHAR2,CUR_LIB_ART_ID NUMBER) RETURN NUMBER;");
//        BigDecimal memship_category_result =
//            (BigDecimal)memship_category.call(getDBTransaction(),
//                                              currPerson.getBarcode(),
//                                              (Number)getSession().getUserData().get("libartid")).getReturnValue();
//        System.out.println("result is " + memship_category_result);


        if (new Number(1).equals(currPerson.getPersType())) //rasmi ha
        {
            if (new Number(1).equals(currInitMem.getMemshipCategory())) {

                DatabaseProcedure get_lib_artId =
                    DatabaseProcedure.define("FUNCTION parsi_pkg_library.GET_LIB_ART_ID(P_ART_ID NUMBER)RETURN NUMBER");
                BigDecimal get_lib_artId_result =
                    (BigDecimal)get_lib_artId.call(getDBTransaction(),
                                                   currPerson.getArtId()).getReturnValue();

                ///loc_mem_status
                DatabaseProcedure mem_status =
                    DatabaseProcedure.define("FUNCTION parsi_pkg_library.MEM_STATUS(P_BARCODE VARCHAR2,T_LIB_ART_ID NUMBER) RETURN NUMBER;");
                BigDecimal mem_status_result =
                    (BigDecimal)mem_status.call(getDBTransaction(),
                                                currPerson.getBarcode(),
                                                get_lib_artId_result).getReturnValue();
                if (mem_status_result == null) {
                  pakage_variables.put("clearInterLib",  true);

                    if (cid_clearing_HasLoanPenaltyLetter(new Number(3)) ==
                        true ||
                        cid_clearing_HasLoanPenaltyLetter(new Number(4)) ==
                        true)
                      raiseFlag= true;
                }
                if (cid_clearing_HasLoanPenaltyLetter(new Number(1)) == true)
              raiseFlag= true;

            } else if (new Number(2).equals(currInitMem.getMemshipCategory())) {
                
              pakage_variables.put( "clearInterLib" , true);

                if (cid_clearing_HasLoanPenaltyLetter(new Number(3)) == true ||
                    cid_clearing_HasLoanPenaltyLetter(new Number(4)) == true ||
                    cid_clearing_HasLoanPenaltyLetter(new Number(2)) == true)
              raiseFlag= true;


            }

        }

        if (new Number(3).equals(currInitMem.getMemshipCategory()) ||
            new Number(4).equals(currInitMem.getMemshipCategory()) ||
            new Number(2).equals(currPerson.getPersType())) {
            
            if (new Number(0).compareTo( currInitMem.getDebitSum())==-1 ){
               JSFUtils.addFacesErrorMessage((String)getMessageVO1().findByKey(new Key(new Object[] { "mem_cash_penalty".toUpperCase() }),
                                                                     -1)[0].getAttribute("Message"));

              raiseFlag= true;
            }
            if (new Number(1).equals(currInitMem.getDebitNonCash().intValue() )){
          JSFUtils.addFacesErrorMessage((String)getMessageVO1().findByKey(new Key(new Object[] { "mem_non_cash_penalty".toUpperCase() }),
                                                                     -1)[0].getAttribute("Message"));
              raiseFlag= true;
            }
            if (new Number(0).compareTo(currPerson.getLoanNumber_cidClearing()) ==
                -1) {
                JSFUtils.addFacesErrorMessage((String)getMessageVO1().findByKey(new Key(new Object[] { "LOAN_NUMBER".toUpperCase() }),
                                                                     -1)[0].getAttribute("Message"));
              raiseFlag= true;
            }
            if (new Number(3).equals(currInitMem.getMemshipCategory())){
                JSFUtils.addFacesErrorMessage((String)getMessageVO1().findByKey(new Key(new Object[] { "inter_lib_mem".toUpperCase() }),
                                                                     -1)[0].getAttribute("Message"));
          raiseFlag= true;
            }
            
          enable_btn=true;
        }
        
        if(raiseFlag){
            return new FResult("return",raiseFlag);
        }
        Row bookThesisVO = currInitMem.getBookThesisVO();

        if ((new Number(3).equals(currPerson.getDegree()) ||
             new Number(6).equals(currPerson.getDegree())) &&
            ((bookThesisVO == null) ||
             (ParsiUtil.clearString((String)bookThesisVO.getAttribute("ThesisLetterNo")) ==
              null))) {
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "not_thesis_letter_no".toUpperCase() }),
                                                                 -1)[0].getAttribute("Message"));
        }


        return new FResult("return",false);
    }


    public boolean cid_clearing_HasLoanPenaltyLetter(Number memCat) {
        String loanLib = "", introductionLetterLib = "", cashPenaltyLib =
            "", nonCashPenaltyLib = "", part1 = "", part2 = "", part3 =
            "", part4 = "", msg = "";

        PersonVOImpl personVO = (PersonVOImpl)getPersonVO1();
        PersonVORowImpl currPerson = (PersonVORowImpl)personVO.getCurrentRow();
        InitMemberVORowImpl currInitMem =
            (InitMemberVORowImpl)currPerson.getInitMemberCurrLibVO1();

        RowIterator currInitMemItirator = currPerson.getInitMemberVO();
        while (currInitMemItirator.hasNext()) {
            InitMemberVORowImpl currRow =
                (InitMemberVORowImpl)currInitMemItirator.next();
            if (memCat.equals(currRow.getMemshipCategory())) {

                if (ParsiUtil.NVL(currRow.getLoanedCount()).intValue() +
                    ParsiUtil.NVL(currRow.getLoanedInPlaceCount()).intValue() >
                    0) {
                    if (ParsiUtil.clearString(loanLib) == null)
                        loanLib = currRow.getLibName();
                    else
                        loanLib = loanLib + "و" + currRow.getLibName();
                    part1 = " بازگرداندن کتاب های در امانت ";
                }
                if (ParsiUtil.NVL(currRow.getDebitSum()).intValue() != 0) {
                    if (ParsiUtil.clearString(cashPenaltyLib) == null)
                        cashPenaltyLib = currRow.getLibName();
                    else
                        cashPenaltyLib =
                                cashPenaltyLib + "و" + currRow.getLibName();

                    part2 = " پرداخت جریمه ها ";
                }
                if (new Number(1).equals(currRow.getDebitNonCash())) {
                    if (ParsiUtil.clearString(cashPenaltyLib) == null)
                        nonCashPenaltyLib = currRow.getLibName();
                    else
                        nonCashPenaltyLib =
                                nonCashPenaltyLib + "و" + currRow.getLibName();
                    part3 = " رفع جرایم غیر نقدی ";
                }


                if (ParsiUtil.NVL(currRow.getIntroductionLetterCount()).intValue() !=
                    0) {
                    if (ParsiUtil.clearString(introductionLetterLib) == null)
                        introductionLetterLib = currRow.getLibName();
                    else
                        introductionLetterLib =
                                introductionLetterLib + "و" + currRow.getLibName();
                    part4 = " تسویه معرفی نامه ها ";

                }
            } //End first if
        } //End While


        if (ParsiUtil.clearString(loanLib) != null)
            msg = " این عضو از " + loanLib + " کتاب امانت دارد. ";

        if (ParsiUtil.clearString(cashPenaltyLib) != null) {
            if (ParsiUtil.clearString(msg) != null)
                msg = msg + " همچنین در ";
            else
                msg = " این شخص در ";

            msg = msg + cashPenaltyLib + " دارای جریمه نقدی ";
        }

        if (ParsiUtil.clearString(nonCashPenaltyLib) != null) {
            if (ParsiUtil.clearString(msg) != null)
                msg = msg + " و در ";
            else
                msg = "این شخص در ";

            msg = msg + nonCashPenaltyLib + " دارای جریمه غیر نقدی ";

        }


        if (ParsiUtil.clearString(introductionLetterLib) != null) {
            if (ParsiUtil.clearString(msg) != null)
                msg = msg + " و در ";
            else
                msg = " این شخص در ";

            msg = msg + introductionLetterLib + " دارای معرفینامه تسویه نشده ";

        }

        if (ParsiUtil.clearString(cashPenaltyLib) != null ||
            ParsiUtil.clearString(nonCashPenaltyLib) != null ||
            ParsiUtil.clearString(introductionLetterLib) != null)
            msg = msg + "است.";

        if (ParsiUtil.clearString(part1) != null)
            if (ParsiUtil.clearString(part2) != null ||
                ParsiUtil.clearString(part3) != null ||
                ParsiUtil.clearString(part4) != null)
                part1 = part1 + " و ";

        if (ParsiUtil.clearString(part2) != null)
            if (ParsiUtil.clearString(part3) != null ||
                ParsiUtil.clearString(part4) != null)
                part2 = part2 + " و ";

        if (ParsiUtil.clearString(part3) != null)
            if (ParsiUtil.clearString(part4) != null)
                part3 = part3 + " و ";

        if (ParsiUtil.clearString(msg) != null) {
            JSFUtils.addFacesInfoMessage(msg + " " +
                                         "برای تسویه ابتدا باید نسبت به " +
                                         part1 + part2 + part3 + part4 +
                                         "اقدام کند");

            return true;

        } else
            return false;
    }

    public FResult cid_clearing_preSave(String thesisNo) {

        PersonVOImpl personVO = (PersonVOImpl)getPersonVO1();
        PersonVORowImpl currPerson = (PersonVORowImpl)personVO.getCurrentRow();
//        InitMemberVORowImpl currInitMem =
//            (InitMemberVORowImpl)currPerson.getInitMemberCurrLibVO1();


        if (currPerson == null ||
            ParsiUtil.clearString(currPerson.getBarcode()) == null)
         
                return new FResult("error",
                                   (String)getMessageVO1().findByKey(new Key(new Object[] { "BARCODE_NOT_NULL".toUpperCase() }),
                                                                     -1)[0].getAttribute("Message"));
            if ((new Number(3).equals(currPerson.getDegree()) ||
                 new Number(6).equals(currPerson.getDegree())) &&
                ParsiUtil.clearString(thesisNo) == null)
                return new FResult("error",
                                   (String)getMessageVO1().findByKey(new Key(new Object[] { "not_thesis_letter_no".toUpperCase() }),
                                                                     -1)[0].getAttribute("Message"));


            return new FResult("yn_popup",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "clearing".toUpperCase() }),
                                                                 -1)[0].getAttribute("Message"));


    }

    public FResult cid_clearing_Save(String thesisLetterNo) {
        
        String libName = "";
       // String libArtIds="";
        PersonVOImpl personVO = (PersonVOImpl)getPersonVO1();
        PersonVORowImpl currPerson = (PersonVORowImpl)personVO.getCurrentRow();
        InitMemberVORowImpl currInitMem =
            (InitMemberVORowImpl)currPerson.getInitMemberCurrLibVO1();
        
        
        Number memshipCategory =null;
        if (currInitMem != null) {
            memshipCategory = currInitMem.getMemshipCategory();
        }
        if ((Boolean) pakage_variables.get("clearInterLib")) {
            //Update InitMember
            RowIterator currInitMemItirator = currPerson.getInitMemberVO();
            while (currInitMemItirator.hasNext()) {
                InitMemberVORowImpl currRow =
                    (InitMemberVORowImpl)currInitMemItirator.next();

                if (!new Number(2).equals(currRow.getMemshipStatus()) &&
                    (new Number(3).equals(currRow.getMemshipCategory()) ||
                     memshipCategory.equals(currRow.getMemshipCategory()))) {
                    currRow.setMemshipStatus(new Number(2));
                    currRow.setReservedCount(new Number(0));
                    currRow.setRecalledCount(new Number(0));


                    //Update MemStatusHistory

                    MemberStatusHistoryVOImpl memStatusHis =
                        (MemberStatusHistoryVOImpl)getMemberStatusHistoryVO1();

                    MemberStatusHistoryVORowImpl newRec =
                        (MemberStatusHistoryVORowImpl)memStatusHis.createRow();
                    memStatusHis.insertRow(newRec);

                    newRec.setIntmemArtId(currRow.getArtId());
                    newRec.setStatus(new Number(2));
                    newRec.setDayDate(ParsiUtil.DateToNumber());
                    newRec.setReason("تسویه حساب");
                    newRec.setLibArtId(currRow.getLibArtId());
                    newRec.setUserName((String)getSession().getUserData().get("username"));

                    if (ParsiUtil.clearString(libName) == null) {
                        libName = " "+currRow.getLibName();
                      //  libArtIds=currRow.getLibArtId();
                    } else {
                        libName = libName + "و " + currRow.getLibName()+" ";
                    }

                }
            } //End loop
        } else {
            currInitMem.setMemshipStatus(new Number(2));
            currInitMem.setReservedCount(new Number(0));
            currInitMem.setRecalledCount(new Number(0));

            MemberStatusHistoryVOImpl memStatusHis =
                (MemberStatusHistoryVOImpl)getMemberStatusHistoryVO1();

            MemberStatusHistoryVORowImpl newRec =
                (MemberStatusHistoryVORowImpl)memStatusHis.createRow();
            memStatusHis.insertRow(newRec);

            newRec.setIntmemArtId(currInitMem.getArtId());
            newRec.setStatus(new Number(2));
            newRec.setDayDate(ParsiUtil.DateToNumber());
            newRec.setReason("تسویه حساب");
            newRec.setLibArtId((Number)getSession().getUserData().get("libartid"));
            newRec.setUserName((String)getSession().getUserData().get("username"));

            libName = (String)getSession().getUserData().get("libname");
        }
        if (thesisLetterNo != null &&
            new Number(1).equals(currPerson.getPersType())) {
            BookThesisVORowImpl bookThesis =
                (BookThesisVORowImpl)currInitMem.getBookThesisVO();
            if (bookThesis == null ||
                ParsiUtil.clearString(bookThesis.getThesisLetterNo()) ==
                null) {
                if (currInitMem.getMemberVo() == null) {
                    EntityDefImpl MemberDef =
                        EntityDefImpl.findDefObject("org.parsisys.tehranuniversity.library.model.eo.Member");
                    MemberImpl Member =
                        (MemberImpl)MemberDef.createInstance2(getDBTransaction(),
                                                              null);


                    Member.setDescription(null);
                    Member.setArtId(currInitMem.getArtId());
                    Member.setLabcol((Number)getSession().getUserData().get("labcolno"));
                }
                EntityDefImpl bookThesisDef =
                    EntityDefImpl.findDefObject("org.parsisys.tehranuniversity.library.model.eo.BookThesis");
                BookThesisImpl bookThesisInstance =
                    (BookThesisImpl)bookThesisDef.createInstance2(getDBTransaction(),
                                                                  null);
                bookThesisInstance.setMemArtId(currInitMem.getArtId());
                bookThesisInstance.setLabcol((Number)getSession().getUserData().get("labcolno"));
                bookThesisInstance.setThesisLetterNo(thesisLetterNo);
            } else if (!bookThesis.getThesisLetterNo().equalsIgnoreCase(thesisLetterNo)) {
                bookThesis.setThesisLetterNo(thesisLetterNo);
            }


        }
        getDBTransaction().commit();
        JSFUtils.addFacesInfoMessage("تسویه حساب عضو در کتابخانه های " +
                                     libName + "انجام شد");
    return new FResult("return",ParsiUtil.encodePersianText(libName));
    }

    public void cid_print_reserve_check_chekboxes(){
      ReserveVOImpl printReserve = (ReserveVOImpl)getPrintReserveVO();
        RowSetIterator printReserveRI =
            printReserve.createRowSetIterator("printReserve");
        
        while(printReserveRI.hasNext()){
            ReserveVORowImpl currRow = (ReserveVORowImpl)printReserveRI.next();
            currRow.setPrint(true);
            }
      printReserveRI.closeRowSetIterator();
    }

    public void cid_print_reserve_UNcheck_chekboxes(){
        
          ReserveVOImpl printReserve = (ReserveVOImpl)getPrintReserveVO();
        RowSetIterator printReserveRI =
            printReserve.createRowSetIterator("printReserve");
            
            while(printReserveRI.hasNext()){
                ReserveVORowImpl currRow = (ReserveVORowImpl)printReserveRI.next();
                currRow.setPrint(false);
                }
          printReserveRI.closeRowSetIterator();
        }

    public FResult cid_book_reserve_history_active_selectionChanged(){

          
        ReserveVORowImpl reserve =
            (ReserveVORowImpl)getReserveVO3().getCurrentRow();
          Number newActive=reserve.getActive();
          System.out.println(newActive);
          ReserveImpl reserveEntity=(ReserveImpl)reserve.getEntity(0);
          Number oldActive =
              (Number)reserveEntity.getPostedAttribute2(reserveEntity.ACTIVE);
        if (newActive == null ||
            (!newActive.equals(oldActive) && (new Number(1).equals(newActive) ||
                                              new Number(2).equals(newActive) ||
                                              new Number(4).equals(newActive)))) {
            //getDBTransaction().rollback();
        reserve.setActive(oldActive);
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "illegal_status_change".toUpperCase() }),
                                                                     -1)[0].getAttribute("Message"));
              
        } else {
              if(new Number(2).equals(oldActive) ){
              
                  DummyVOImpl dummyVo=getDummyVO1();
                  dummyVo.setQuery("SELECT MIN(ART_ID)  FROM RESERVE \n" + 
                        "			    		WHERE VBOOK_ART_ID=" +
                        reserve.getVbookArtId() + "							AND ACTIVE=1" +
                        "                   and nvl(vol_no,'0')=nvl('" +
                        ParsiUtil.stringToZeroValue(reserve.getVolNo()) +
                        "','0') " +
                        "                   and nvl(part_no,'0')=nvl('" +
                    
                        ParsiUtil.stringToZeroValue(reserve.getPartNo()) +
                        "','0') and labcol=" +
                        getSession().getUserData().get("labcolno"));
                  
                  dummyVo.executeQuery();
                 Row r= dummyVo.first();
                  Number next_art_id=null;
                  if(r!=null && r.getAttribute("Dummy")!=null){
                    try {
                        next_art_id =
                                new Number(r.getAttribute("Dummy").toString());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                  if(next_art_id!=null){
                    getReserveVO3().findAndSetCurrentRowByKey(new Key(new Object[] { (Number)getSession().getUserData().get("labcolno"),
                                                                                     next_art_id }),
                                                              1);
                    ReserveVORowImpl currentRow =
                        (ReserveVORowImpl)getReserveVO3().getCurrentRow();
                    currentRow.setActive(new Number(2));
                    
                } else {
                      
                        DBTransaction trans = getDBTransaction();

                        CallableStatement statement = null;
                        
                  
                    String plsql =
                        "UPDATE PHYSICAL_BOOK SET EXISTENCE_STATUS=1 " +
                        "											WHERE VBOOK_ART_ID=" +
                        reserve.getVbookArtId() +
                      "					        					AND EXISTENCE_STATUS=8 " + 
                        "                   and nvl(vol_no,'0')=nvl('" +
                        ParsiUtil.stringToZeroValue(reserve.getVolNo()) +
                        "','0') " +
                        "                   and nvl(part_no,'0')=nvl('" +
                        ParsiUtil.stringToZeroValue(reserve.getPartNo()) +
                        "','0')";
                                    
                        System.out.println(plsql);
                        statement = trans.createCallableStatement(plsql, 2);


                    try {
                        statement.execute();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                  
                  }
        InitMemberVORowImpl currInit = (InitMemberVORowImpl)reserve.getInitMemberVO();
            currInit.setReservedCount((currInit.getReservedCount()==null?new Number(0): currInit.getReservedCount().subtract(1)));
            getDBTransaction().commit();
              }
      
        return new FResult("info","وضعیت با موفقیت تغییر داده شد.");
        }

    public int[] cid_reserve_enable_btns() {
        VirtualBookVORowImpl currBook =
            (VirtualBookVORowImpl)getVirtualBookVO1().getCurrentRow();
        int[] result = null;
        if (currBook != null) {
            int cnt_phb = currBook.getPhysicalBookVO().getRowCount();
            int CNT_VOL_PART_NO =
                currBook.getPhysicalBook_PartOrVolNotNullVO1().getRowCount();
            result = new int[2];
            result[0] = cnt_phb;
            result[1] = CNT_VOL_PART_NO;

        }

        return result;

    }

    public FResult cid_reserve_reserveBook_btn() {

        VirtualBookVOImpl bookVO = (VirtualBookVOImpl)getVirtualBookVO1();


        VirtualBookVORowImpl currVBook =
            (VirtualBookVORowImpl)bookVO.getCurrentRow();

        if (currVBook != null) {
            if (ParsiUtil.clearString(currVBook.getCallNo()) == null) {
                return new FResult("error",
                                   (String)getMessageVO1().findByKey(new Key(new Object[] { "call_no".toUpperCase() }),
                                                                     -1)[0].getAttribute("Message"));
            }


            PhysicalBookVolPartVORowImpl currPhbook1 =
                (PhysicalBookVolPartVORowImpl)getPhysicalBookVolPartVO1().getCurrentRow();
            if (new Number(4).equals(currPhbook1.getFlag()) ||
                new Number(5).equals(currPhbook1.getFlag())) {
                return new FResult("error",
                                   (String)getMessageVO1().findByKey(new Key(new Object[] { "impassible_exis_loan_st".toUpperCase() }),
                                                                     -1)[0].getAttribute("Message"));

            }

            int cnt_phbook = 0;
            DummyVOImpl dummyVO1 = getDummyVO1();
            String VolNo =
                ParsiUtil.StNVL(currPhbook1.getVolNo(), "0").toUpperCase();
            String PartNo =
                ParsiUtil.StNVL(currPhbook1.getPartNo(), "0").toUpperCase();
            if (currPhbook1 != null) {
                dummyVO1.setQuery("SELECT art_id FROM PHYSICAL_BOOK \n" +
                        " WHERE vbook_art_id=" +
                        currVBook.getArtId().toString() +
                        " AND nvl(UPPER(vol_no),'0')='" +
                        ParsiUtil.stringToZeroValue(VolNo) + "'\n" +
                        " AND nvl(UPPER(part_no),'0')='" +
                        ParsiUtil.stringToZeroValue(PartNo) + "'\n" +
                        " AND loan_status=1\n" +
                        " AND existence_status in (1,8) " + " AND labcol=" +
                        getSession().getUserData().get("labcolno").toString());
                dummyVO1.executeQuery();
                int cnt_phb = dummyVO1.getRowCount();
                if (cnt_phb > 0) {
                    dummyVO1.setQuery("SELECT art_id  FROM reserve \n" +
                            " WHERE  vbook_art_id=" +
                            currVBook.getArtId().toString() +
                            " AND nvl(UPPER(vol_no),'0')='" +
                            ParsiUtil.stringToZeroValue(VolNo) + "'\n" +
                            " AND nvl(UPPER(part_no),'0')='" +
                            ParsiUtil.stringToZeroValue(PartNo) + "'\n" +
                            " AND Active in (1,2)" + " AND labcol=" +
                            getSession().getUserData().get("labcolno").toString());
                    dummyVO1.executeQuery();
                    int cnt_reserve = dummyVO1.getRowCount();

                    cnt_phbook = cnt_phb - cnt_reserve;
                }
            }

            if (cnt_phbook > 0) {

                return new FResult("error",
                                   (String)getMessageVO1().findByKey(new Key(new Object[] { "no_reserve_exist_book".toUpperCase() }),
                                                                     -1)[0].getAttribute("Message"));
            }
        } else {
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "call_no".toUpperCase() }),
                                                                 -1)[0].getAttribute("Message"));

        }

        return null;
    }


    public FResult cid_reserve_mem_reserveBtn(Boolean beforePopup,
                                              Boolean inter_lib_new_mem,
                                              Boolean update_memship_st) {
        PersonVOImpl persVo = (PersonVOImpl)getPersonVO1();
        PersonVORowImpl currPerson = (PersonVORowImpl)persVo.getCurrentRow();
        if (beforePopup == true) {

            if (ParsiUtil.clearString(persVo.getbarcode_param2()) == null ||
                currPerson == null || currPerson.getBarcode() == null)
                return new FResult("error",
                                   (String)getMessageVO1().findByKey(new Key(new Object[] { "barcode_not_null".toUpperCase() }),
                                                                     -1)[0].getAttribute("Message"));


            if (currPerson.getEmail() == null)
                return new FResult("yn_popup",
                                   (String)getMessageVO1().findByKey(new Key(new Object[] { "insert_mem_email".toUpperCase() }),
                                                                     -1)[0].getAttribute("Message"));
        }


        DummyVOImpl dummyVO1 = getDummyVO1();
        VirtualBookVORowImpl currVbook =
            (VirtualBookVORowImpl)getVirtualBookVO1().getCurrentRow();
        PhysicalBookVolPartVORowImpl currPhbookVolPart =
            (PhysicalBookVolPartVORowImpl)getPhysicalBookVolPartVO1().getCurrentRow();
        InitMemberVORowImpl currInitmem =
            (InitMemberVORowImpl)currPerson.getInitMemberCurrLibVO1();
        String VolNo = ParsiUtil.StNVL(currPhbookVolPart.getVolNo(), "0");
        String PartNo = ParsiUtil.StNVL(currPhbookVolPart.getPartNo(), "0");
        if (currInitmem != null) {
            dummyVO1.setQuery("SELECT *  FROM reserve \n" +
                    " WHERE vbook_art_id=" + currVbook.getArtId() + "\n" +
                    " AND NVL(UPPER(VOL_NO),'0')='" +
                    ParsiUtil.stringToZeroValue(VolNo) + "'\n" +
                    " AND NVL(UPPER(PART_NO),'0')='" +
                    ParsiUtil.stringToZeroValue(PartNo) + "'\n" +
                    " AND mem_art_id=" + currInitmem.getArtId() + "\n" +
                    " AND active=1 \n" +
                    " And labcol=" +
                    getSession().getUserData().get("labcolno").toString());
            dummyVO1.executeQuery();
            if (dummyVO1.getRowCount() > 0) {
                return new FResult("error",
                                   (String)getMessageVO1().findByKey(new Key(new Object[] { "member_reserved_book".toUpperCase() }),
                                                                     -1)[0].getAttribute("Message"));
            }


            dummyVO1.setQuery("SELECT * FROM PHYSICAL_BOOK,LOAN\n" +
                    " WHERE PHYSICAL_BOOK.labcol=LOAN.labcol and PHYSICAL_BOOK.VBOOK_ART_ID=" +
                    currVbook.getArtId() + "\n" +
                    " AND NVL(UPPER(VOL_NO),'0')='" +
                    ParsiUtil.stringToZeroValue(VolNo) + "'\n" +
                    " AND NVL(UPPER(PART_NO),'0')='" +
                    ParsiUtil.stringToZeroValue(PartNo) + "'\n" +
                    " AND PHYSICAL_BOOK.ART_ID=LOAN.PHBOOK_ART_ID\n" +
                    " AND REAL_RET_DATE IS NULL\n" +
                    " AND MEM_ART_ID=" + currInitmem.getArtId() + " \n" +
                    " And LOAN.labcol=" +
                    getSession().getUserData().get("labcolno").toString());
            dummyVO1.executeQuery();
            if (dummyVO1.getRowCount() != 0) {
                return new FResult("error",
                                   (String)getMessageVO1().findByKey(new Key(new Object[] { "member_loaned_book".toUpperCase() }),
                                                                     -1)[0].getAttribute("Message"));

            }
        }

        /////////////////////////// reserve: pre-insert
        //TODO: reserve pre insert must be implemented.
        Boolean RASMI_MEM_FIRST_RESERVE = false;
        Number DayDate = ParsiUtil.DateToNumber();
        if (inter_lib_new_mem == true) {
            if (update_memship_st == true) {
                currInitmem.setMemshipCategory(new Number(3));
                currInitmem.setMemshipStatus(new Number(1));

            } else {
                InitMemberVORowImpl newInitMem =
                    (InitMemberVORowImpl)currPerson.getInitMemberVO().createRow();
                currPerson.getInitMemberVO().insertRow(newInitMem);
                newInitMem.setLibArtId((Number)getSession().getUserData().get("libartid"));
                //nasiri: chang ARTID in person
                newInitMem.setPersArtId(currPerson.getArtId());
                newInitMem.setLoanedCount(new Number(0));
                newInitMem.setReservedCount(new Number(0));
                newInitMem.setRecalledCount(new Number(0));
                newInitMem.setMemshipCategory(new Number(3));
                newInitMem.setMemshipStatus(new Number(1));
                newInitMem.setDebitSum(new Number(0));
                newInitMem.setDebitNonCash(new Number(2));
                RASMI_MEM_FIRST_RESERVE = true;
                getDBTransaction().commit();

            }
            currInitmem =
                    (InitMemberVORowImpl)currPerson.getInitMemberCurrLibVO1();
            MemberStatusHistoryVORowImpl currMemStatHist =
                (MemberStatusHistoryVORowImpl)currInitmem.getMemberStatusHistoryVO().createRow();
            currInitmem.getMemberStatusHistoryVO().insertRow(currMemStatHist);
            currMemStatHist.setStatus(new Number(1));
            currMemStatHist.setDayDate(DayDate);
            currMemStatHist.setUserName((String)getSession().getUserData().get("username"));
            currMemStatHist.setIntmemArtId(currInitmem.getArtId());
            currMemStatHist.setLibArtId((Number)getSession().getUserData().get("libartid"));
            getDBTransaction().commit();

        }
        /*
 * IF :PERS_TYPE=1 AND PKG_VARIABLE.RASMI_MEM_FIRST_RESERVE=TRUE THEN
		  	   INSERT INTO MEMBER(ART_ID
														 ,DESCRIPTION)
											 VALUES(:PERSON.INIT_MEMBER_ART_ID
		  	   										,NULL);        		
	  END IF;
	  UPDATE INIT_MEMBER SET RESERVED_COUNT=RESERVED_COUNT+1
 								WHERE ART_ID=:PERSON.INIT_MEMBER_ART_ID;
	  select SEQ_RESERVE_ART_ID.NEXTVAL INTO :reserve.art_id FROM dual;
	  :RESERVE.MEM_ART_ID:=:PERSON.INIT_MEMBER_ART_ID;
 */
        if (new Number(1).equals(currPerson.getPersType()) &&
            RASMI_MEM_FIRST_RESERVE == true) {

            EntityDefImpl memberDef =
                EntityDefImpl.findDefObject("org.parsisys.tehranuniversity.library.model.eo.Member");
            MemberImpl currMember =
                (MemberImpl)memberDef.createInstance2(getDBTransaction(),
                                                      null);
            currMember.setArtId(currInitmem.getArtId());
            currMember.setDescription(null);
            currMember.setLabcol((Number)getSession().getUserData().get("labcolno"));
            getDBTransaction().commit();


        }
        currInitmem.setReservedCount(currInitmem.getReservedCount().add(new Number(1)));
        ///////////////////////////

//        ReserveVORowImpl reserve =
//            (ReserveVORowImpl)currInitmem.getReserveVO().createRow();
//        currInitmem.getReserveVO().insertRow(reserve);
         ReserveVORowImpl reserve =
          (ReserveVORowImpl)getReserveVO2().createRow();
      getReserveVO2().insertRow(reserve);

        reserve.setMemArtId(currInitmem.getArtId());
        reserve.setLabcol((Number)getSession().getUserData().get("labcolno"));
        reserve.setVolNo(currPhbookVolPart.getVolNo());
        reserve.setPartNo(currPhbookVolPart.getPartNo());
        reserve.setRetDate(null);
        reserve.setActive(new Number(1));
        reserve.setDayDate(DayDate);
        reserve.setVbookArtId(currVbook.getArtId());
        reserve.setUserName((String)getDBTransaction().getSession().getUserData().get("username"));
        getDBTransaction().commit();
        return null;
    }


    public FResult cid_reserve_mem_after_search_barcode() {
        //PKG_VARIABLE.RASMI_MEM_FIRST_LOAN:=FALSE;

        Boolean UPDATE_MEMSHIP_ST = false;
        Boolean rasmi_mem_first_reserve = false;
        Boolean capacity_full = false;
        Boolean inter_lib = false;
        PersonVOImpl personVO = (PersonVOImpl)getPersonVO1();

        if (personVO.getCurrentRow() == null)
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "no_data".toUpperCase() }),
                                                                 -1)[0].getAttribute("Message"),
                               capacity_full);


        PersonVORowImpl currPerson = (PersonVORowImpl)personVO.getCurrentRow();
        InitMemberVORowImpl currInitMem =
            (InitMemberVORowImpl)currPerson.getInitMemberCurrLibVO1();

        if (new Number(2).equals(currPerson.getPersStatus()))
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "no_loan_no_active".toUpperCase() }),
                                                                 -1)[0].getAttribute("Message"),
                               capacity_full);

        DatabaseProcedure is_mem_of_currLib =
            DatabaseProcedure.define("function parsi_pkg_library.IS_MEM_OF_LIB2(P_ART_ID NUMBER,CUR_LIB_ART_ID NUMBER)RETURN NUMBER;");
        Number is_mem_of_lib =
            ParsiUtil.convert_dec_to_number((BigDecimal)is_mem_of_currLib.call(getDBTransaction(),
                                                                               currPerson.getArtId(),
                                                                               getDBTransaction().getSession().getUserData().get("libartid")).getReturnValue());

        DatabaseProcedure reserve_capacity_full2 =
            DatabaseProcedure.define("FUNCTION parsi_pkg_library.RESERVE_CAPACITY_FULL2(p_BARCODE VARCHAR2,CUR_LIB_ART_ID NUMBER,memship_cat number) RETURN Number;");
        Number reserve_capacity_full2_result = null;

        DatabaseProcedure mem_reserved_book =
            DatabaseProcedure.define("FUNCTION parsi_pkg_library.MEM_RESERVED_BOOK(P_BARCODE VARCHAR2,CUR_LIB_ART_ID NUMBER,memship_cat number) RETURN number;");

        if (new Number(1).equals(currPerson.getPersType())) //Rasmi
        {


            if (new Number(1).equals(is_mem_of_lib)) {
                if (new Number(3).equals(currInitMem.getMemshipStatus()))
                    JSFUtils.addFacesInfoMessage((String)getMessageVO1().findByKey(new Key(new Object[] { "incomplete_id".toUpperCase() }),
                                                                                   -1)[0].getAttribute("Message"));

                //                :PERSON.INIT_MEMBER_ART_ID:=parsi_pkg_library.INIT_MEM_ART_ID(:PERSON.ART_ID,:person.LIB_ART_ID);
                //                              IF parsi_pkg_library.HAS_MEM_REC(:PERSON.BARCODE,:person.LIB_ART_ID)=FALSE THEN
                //                                    PKG_VARIABLE.RASMI_MEM_FIRST_LOAN:=TRUE;
                //                              END IF;

                // if zir piade sazie code balast ke comment shode ast.
                if (currInitMem.getMemberVo() == null)
                    rasmi_mem_first_reserve = true;


                if (new Number(1).equals(currInitMem.getMemshipCategory())) {
                    reserve_capacity_full2_result =
                            ParsiUtil.convert_dec_to_number((BigDecimal)reserve_capacity_full2.call(getDBTransaction(),
                                                                                                    currPerson.getBarcode(),
                                                                                                    getDBTransaction().getSession().getUserData().get("libartid"),
                                                                                                    new Number(1)).getReturnValue());
                    capacity_full =
                            new Number(1).equals(reserve_capacity_full2_result);
                    currInitMem.setReserveNumber(ParsiUtil.convert_dec_to_number((BigDecimal)mem_reserved_book.call(getDBTransaction(),
                                                                                                                    currPerson.getBarcode(),
                                                                                                                    getDBTransaction().getSession().getUserData().get("libartid"),
                                                                                                                    new Number(1)).getReturnValue()));

                } else if (new Number(2).equals(currInitMem.getMemshipCategory())) {
                    reserve_capacity_full2_result =
                            ParsiUtil.convert_dec_to_number((BigDecimal)reserve_capacity_full2.call(getDBTransaction(),
                                                                                                    currPerson.getBarcode(),
                                                                                                    getDBTransaction().getSession().getUserData().get("libartid"),
                                                                                                    new Number(2)).getReturnValue());
                    capacity_full =
                            new Number(1).equals(reserve_capacity_full2_result);
                    currInitMem.setReserveNumber(ParsiUtil.convert_dec_to_number((BigDecimal)mem_reserved_book.call(getDBTransaction(),
                                                                                                                    currPerson.getBarcode(),
                                                                                                                    getDBTransaction().getSession().getUserData().get("libartid"),
                                                                                                                    new Number(2)).getReturnValue()));

                } else {

                    reserve_capacity_full2_result =
                            ParsiUtil.convert_dec_to_number((BigDecimal)reserve_capacity_full2.call(getDBTransaction(),
                                                                                                    currPerson.getBarcode(),
                                                                                                    getDBTransaction().getSession().getUserData().get("libartid"),
                                                                                                    new Number(3)).getReturnValue());
                    capacity_full =
                            new Number(1).equals(reserve_capacity_full2_result);
                    if (currInitMem == null) {
                        currPerson.setReserveNumber(ParsiUtil.convert_dec_to_number((BigDecimal)mem_reserved_book.call(getDBTransaction(),
                                                                                                                       currPerson.getBarcode(),
                                                                                                                       getDBTransaction().getSession().getUserData().get("libartid"),
                                                                                                                       new Number(3)).getReturnValue()));
                    } else {
                        currInitMem.setReserveNumber(ParsiUtil.convert_dec_to_number((BigDecimal)mem_reserved_book.call(getDBTransaction(),
                                                                                                                        currPerson.getBarcode(),
                                                                                                                        getDBTransaction().getSession().getUserData().get("libartid"),
                                                                                                                        new Number(3)).getReturnValue()));
                    }


                }
            }

            else {
                if (currInitMem != null) {

                    Number memship_st = currInitMem.getMemshipStatus();
                    if (memship_st != null &&
                        !(memship_st.intValue() == 1 || memship_st.intValue() ==
                          3)) {
                        DatabaseProcedure is_local_lib2 =
                            DatabaseProcedure.define(" FUNCTION parsi_pkg_library.IS_LOCAL_LIB2(P_ART_ID NUMBER,CUR_LIB_ART_ID NUMBER)RETURN NUMBER;");
                        Number is_local_lib2_result =
                            ParsiUtil.convert_dec_to_number((BigDecimal)is_local_lib2.call(getDBTransaction(),
                                                                                           currPerson.getArtId(),
                                                                                           getDBTransaction().getSession().getUserData().get("libartid")).getReturnValue());
                        boolean valid_loc =
                            new Number(1).equals(is_local_lib2_result);
                        if (memship_st.intValue() != 2 ||
                            (memship_st.intValue() == 2 &&
                             valid_loc == true)) {
                            return new FResult("error",
                                               "برای اعضای دارای وضعیت " +
                                               "\"" +
                                               currInitMem.getMemshipStatusText() +
                                               "\"" + " کتاب رزرو نمی شود.",
                                               capacity_full);
                        } else {
                            //PKG_VARIABLE.UPDATE_MEMSHIP_ST:=TRUE;
                            UPDATE_MEMSHIP_ST = true;
                        }

                    }
                }
                inter_lib = true;
                reserve_capacity_full2_result =
                        ParsiUtil.convert_dec_to_number((BigDecimal)reserve_capacity_full2.call(getDBTransaction(),
                                                                                                currPerson.getBarcode(),
                                                                                                getDBTransaction().getSession().getUserData().get("libartid"),
                                                                                                new Number(3)).getReturnValue());
                capacity_full =
                        new Number(1).equals(reserve_capacity_full2_result);
                if (currInitMem == null) {
                    currPerson.setReserveNumber(ParsiUtil.convert_dec_to_number((BigDecimal)mem_reserved_book.call(getDBTransaction(),
                                                                                                                   currPerson.getBarcode(),
                                                                                                                   getDBTransaction().getSession().getUserData().get("libartid"),
                                                                                                                   new Number(3)).getReturnValue()));
                } else {
                    currInitMem.setReserveNumber(ParsiUtil.convert_dec_to_number((BigDecimal)mem_reserved_book.call(getDBTransaction(),
                                                                                                                    currPerson.getBarcode(),
                                                                                                                    getDBTransaction().getSession().getUserData().get("libartid"),
                                                                                                                    new Number(3)).getReturnValue()));
                }
            }

        } else //Gheyre Rasmi
        {
            if (new Number(1).equals(is_mem_of_lib)) {
                if (new Number(3).equals(currInitMem.getMemshipStatus()))
                    JSFUtils.addFacesInfoMessage((String)getMessageVO1().findByKey(new Key(new Object[] { "incomplete_id".toUpperCase() }),
                                                                                   -1)[0].getAttribute("Message"));


                reserve_capacity_full2_result =
                        ParsiUtil.convert_dec_to_number((BigDecimal)reserve_capacity_full2.call(getDBTransaction(),
                                                                                                currPerson.getBarcode(),
                                                                                                getDBTransaction().getSession().getUserData().get("libartid"),
                                                                                                new Number(2)).getReturnValue());
                capacity_full =
                        new Number(1).equals(reserve_capacity_full2_result);
                if (currInitMem == null) {
                    currPerson.setReserveNumber(ParsiUtil.convert_dec_to_number((BigDecimal)mem_reserved_book.call(getDBTransaction(),
                                                                                                                   currPerson.getBarcode(),
                                                                                                                   getDBTransaction().getSession().getUserData().get("libartid"),
                                                                                                                   new Number(3)).getReturnValue()));
                } else {
                    currInitMem.setReserveNumber(ParsiUtil.convert_dec_to_number((BigDecimal)mem_reserved_book.call(getDBTransaction(),
                                                                                                                    currPerson.getBarcode(),
                                                                                                                    getDBTransaction().getSession().getUserData().get("libartid"),
                                                                                                                    new Number(2)).getReturnValue()));
                }

            } else {

                DatabaseProcedure init_mem_count =
                    DatabaseProcedure.define(" FUNCTION parsi_pkg_library.INIT_MEM_COUNT(P_ART_ID NUMBER,T_LIB_ART_ID NUMBER,MEMSHIP_CAT NUMBER)RETURN NUMBER;");
                Number init_mem_count_result =
                    ParsiUtil.convert_dec_to_number((BigDecimal)init_mem_count.call(getDBTransaction(),
                                                                                    currPerson.getArtId(),
                                                                                    getDBTransaction().getSession().getUserData().get("libartid"),
                                                                                    new Number(2)).getReturnValue());

                if (ParsiUtil.NVL(init_mem_count_result).intValue() > 0) {
                    Number memship_st =
                        ParsiUtil.NVL(currInitMem.getMemshipStatus());
                    if (!(memship_st.intValue() == 1 ||
                          memship_st.intValue() == 3))
                        return new FResult("error",
                                           "برای اعضای دارای وضعیت " + "\"" +
                                           currInitMem.getMemshipStatusText() +
                                           "\"" + " کتاب رزرو نمی شود.",
                                           capacity_full);
                }


                return new FResult("error",
                                   (String)getMessageVO1().findByKey(new Key(new Object[] { "no_mem_lib".toUpperCase() }),
                                                                     -1)[0].getAttribute("Message"),
                                   capacity_full);
            }
        }
        if (currInitMem != null) {
            if (ParsiUtil.NVL(currInitMem.getDebitSum()).intValue() > 0)
                JSFUtils.addFacesInfoMessage((String)getMessageVO1().findByKey(new Key(new Object[] { "mem_cash_penalty".toUpperCase() }),
                                                                               -1)[0].getAttribute("Message"));
            if (ParsiUtil.NVL(currInitMem.getDebitNonCash(),
                              new Number(2)).intValue() != 2)


                JSFUtils.addFacesInfoMessage((String)getMessageVO1().findByKey(new Key(new Object[] { "mem_non_cash_penalty".toUpperCase() }),
                                                                               -1)[0].getAttribute("Message"));
        }
        if (new Number(2).equals(currPerson.getPersType()) &&
            ParsiUtil.NVL(ParsiUtil.stringDateToNumber(currInitMem.getEndDate())).longValue() <
            ParsiUtil.DateToNumber().longValue())
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "mem_expied".toUpperCase() }),
                                                                 -1)[0].getAttribute("Message"),
                               capacity_full);


        //TODO: khate zir piade sazi nashod zira CUR_LIB_LOAN_NUM hich ja estefade nemishod.
        /*:PERSON.CUR_LIB_LOAN_NUM:=parsi_pkg_library.LIB_LOAN_NUM(:PERSON.barcode,:PERSON.LIB_ART_ID)
                          +parsi_pkg_library.LIB_STUDY_LOAN_NUM(:PERSON.barcode,:PERSON.LIB_ART_ID);*/


        if (inter_lib == true) {
            DatabaseProcedure get_lib_art_id =
                DatabaseProcedure.define("FUNCTION parsi_pkg_library.GET_LIB_ART_ID(P_ART_ID NUMBER)RETURN NUMBER;");
            Number get_lib_art_id_result =
                ParsiUtil.convert_dec_to_number((BigDecimal)get_lib_art_id.call(getDBTransaction(),
                                                                                currPerson.getArtId()).getReturnValue());
            DatabaseProcedure is_mem_of_Lib2 =
                DatabaseProcedure.define("function parsi_pkg_library.IS_MEM_OF_LIB2(P_ART_ID NUMBER,CUR_LIB_ART_ID NUMBER)RETURN NUMBER;");


            if (get_lib_art_id_result == null) {
                Number is_mem_of_Lib2_result =
                    ParsiUtil.convert_dec_to_number((BigDecimal)is_mem_of_Lib2.call(getDBTransaction(),
                                                                                    currPerson.getArtId(),
                                                                                    new Number(1)).getReturnValue());
                if (new Number(0).equals(is_mem_of_Lib2_result)) {
                    return new FResult("error",
                                       (String)getMessageVO1().findByKey(new Key(new Object[] { "no_mem_cent_lib".toUpperCase() }),
                                                                         -1)[0].getAttribute("Message"),
                                       capacity_full);

                }

            } else {
                Number is_mem_of_Lib2_result =
                    ParsiUtil.convert_dec_to_number((BigDecimal)is_mem_of_Lib2.call(getDBTransaction(),
                                                                                    currPerson.getArtId(),
                                                                                    get_lib_art_id_result).getReturnValue());

                if (new Number(0).equals(is_mem_of_Lib2_result)) {
                    DatabaseProcedure get_lib_name =
                        DatabaseProcedure.define("FUNCTION parsi_pkg_library.GET_LIB_NAME(T_LIB_ART_ID NUMBER)RETURN VARCHAR2;");
                    String get_lib_name_result =
                        (String)get_lib_name.call(getDBTransaction(),
                                                  get_lib_art_id_result).getReturnValue();

                    return new FResult("error",
                                       "فرد ابتدا باید برای عضویت در کتابخانه محلی خودش (" +
                                       get_lib_name_result +
                                       ") و یا کتابخانه مرکزی اقدام کند.",
                                       capacity_full);
                }
            }

            return new FResult("yn_popup",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "inter_lib_memship".toUpperCase() }),
                                                                 -1)[0].getAttribute("Message"),
                               new Boolean[] { capacity_full,
                                               UPDATE_MEMSHIP_ST });
        }
        //PKG_VARIABLE.CUR_LIB_LOAN_NUM:=parsi_pkg_library.LIB_LOAN_NUM(:PERSON.barcode,:SYSTEM_BLOCK.LIB_ART_ID);

        if (capacity_full == true) {
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "full_reserve_capacity".toUpperCase() }),
                                                                 -1)[0].getAttribute("Message"),
                               capacity_full);

        }

        return new FResult("return", "",
                           new Boolean[] { capacity_full, UPDATE_MEMSHIP_ST });

    }


    public FResult cid_reserve_mem_after_search_barcode_after_popup(Boolean capacity_full) {


        DatabaseProcedure item_text =
            DatabaseProcedure.define("FUNCTION parsi_pkg_catalog.ITEM_TEXT(CAT_NAME VARCHAR2,ITEM_VAL NUMBER,labcol_no number) RETURN VARCHAR2;");
        String item_text_result =
            (String)item_text.call(getDBTransaction(), "MEMSHIP_CATEGORY",
                                   new Number(3),
                                   getDBTransaction().getSession().getUserData().get("labcolno")).getReturnValue();
        PersonVORowImpl currPerson =
            (PersonVORowImpl)getPersonVO1().getCurrentRow();
        InitMemberVORowImpl currInitMember =
            (InitMemberVORowImpl)currPerson.getInitMemberCurrLibVO1();
        currInitMember.setMemshipCategoryText(item_text_result);
        if (capacity_full == true) {
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "full_interlib_reserve".toUpperCase() }),
                                                                 -1)[0].getAttribute("Message"));

        }

        //PKG_VARIABLE.INTER_LIB_NEW_MEM:=TRUE;


        return null;
    }

    public FResult cid_extend_post_query() {
        PersonVOImpl personVO = (PersonVOImpl)getPersonVO1();
        PersonVORowImpl currPerson = (PersonVORowImpl)personVO.getCurrentRow();
        if (currPerson != null) {
            InitMemberVORowImpl currInitMem =
                (InitMemberVORowImpl)currPerson.getInitMemberCurrLibVO1();
            if (currInitMem == null) {
                return new FResult("error",
                                   (String)getMessageVO1().findByKey(new Key(new Object[] { "no_mem_lib".toUpperCase() }),
                                                                     -1)[0].getAttribute("Message"));
            }
            if (new Number(2).equals(currPerson.getPersStatus())) {
                return new FResult("error",
                                   (String)getMessageVO1().findByKey(new Key(new Object[] { "no_extend_no_active".toUpperCase() }),
                                                                     -1)[0].getAttribute("Message"));
            }
            if (new Number(1).equals(currPerson.getPersType()) &&
                (new Number(1).equals(currPerson.getPersStatus()) ||
                 new Number(3).equals(currPerson.getPersStatus()))) {
                return new FResult("error",
                                   (String)getMessageVO1().findByKey(new Key(new Object[] { "no_tamdid_rasmi".toUpperCase() }),
                                                                     -1)[0].getAttribute("Message"));

            }
            if (!new Number(1).equals(currInitMem.getMemshipStatus()) &&
                !new Number(3).equals(currInitMem.getMemshipStatus())) {
                return new FResult("error",
                                   "اعضای با وضعیت " + "\"" + currInitMem.getMemshipStatusText() +
                                   "\"" + " تمدید نمی شوند.");
            }
        }

        return null;
    }

    public void cid_extend_post_change(Number CmemSetup) {
        PersonVOImpl personVO = (PersonVOImpl)getPersonVO1();
        PersonVORowImpl currPerson = (PersonVORowImpl)personVO.getCurrentRow();
        InitMemberVORowImpl currInitMem =
            (InitMemberVORowImpl)currPerson.getInitMemberCurrLibVO1();

        DatabaseProcedure post_duration =
            DatabaseProcedure.define("FUNCTION parsi_pkg_library.POST_DURATION(POST_NUMBER NUMBER,labcol_no number) RETURN NUMBER;");

        BigDecimal post_duration_result =
            (BigDecimal)post_duration.call(getDBTransaction(), CmemSetup,
                                           getDBTransaction().getSession().getUserData().get("labcolno")).getReturnValue();
        Number duration =
            ParsiUtil.convert_dec_to_number(post_duration_result);


        String newEndDate = null;
        if (duration == null) {
            DatabaseProcedure post_exp_date =
                DatabaseProcedure.define("FUNCTION parsi_pkg_library.POST_EXP_DATE(POST_NUMBER NUMBER,labcol_no number) RETURN NUMBER;");

            BigDecimal post_exp_date_result =
                (BigDecimal)post_exp_date.call(getDBTransaction(), CmemSetup,
                                               getDBTransaction().getSession().getUserData().get("labcolno")).getReturnValue();

            newEndDate =
                    ParsiUtil.numberDateToString(ParsiUtil.convert_dec_to_number(post_exp_date_result));

        } else {
            newEndDate =
                    ParsiUtil.addDayToPersianDate(ParsiUtil.DateToNumber(),
                                                  duration.multiply(31).intValue());
        }
        currInitMem.setNewEndDate(newEndDate);
    }

    public FResult cid_extend_pre_save_button(String newPost) {

        PersonVOImpl personVO = (PersonVOImpl)getPersonVO1();
        if (personVO == null || personVO.getCurrentRow() == null)
            return new FResult("internal_error", "current person is null!");

        PersonVORowImpl currPerson = (PersonVORowImpl)personVO.getCurrentRow();
        InitMemberVORowImpl currInitMem =
            (InitMemberVORowImpl)currPerson.getInitMemberCurrLibVO1();

        if (currPerson.getBarcode() == null) {
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "BARCODE_NOT_NULL".toUpperCase() }),
                                                                 -1)[0].getAttribute("Message"));
        }

        if (ParsiUtil.NVL(ParsiUtil.stringDateToNumber(currInitMem.getNewEndDate())).longValue() <=
            ParsiUtil.DateToNumber().longValue()) {

            return new FResult("error",
                               "دوره اعتبار سمت " + "\"" + newPost + "\"" +
                               " منقضی شده است.");
        }


        String endDate = currInitMem.getEndDate();
        String newEndDate = currInitMem.getNewEndDate();
        if (ParsiUtil.NVL(ParsiUtil.stringDateToNumber(endDate)).equals(ParsiUtil.NVL(ParsiUtil.stringDateToNumber(newEndDate)))) {
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "mem_is_extend".toUpperCase() }),
                                                                 -1)[0].getAttribute("Message"));
        }
        return new FResult("yn_popup",
                           (String)getMessageVO1().findByKey(new Key(new Object[] { "extending".toUpperCase() }),
                                                             -1)[0].getAttribute("Message"));
    }
    
    
    public FResult cid_extend_save_button(Number CmemSetup) {

        PersonVOImpl personVO = (PersonVOImpl)getPersonVO1();
        if (personVO == null || personVO.getCurrentRow() == null)
            return new FResult("internal_error", "current person is null!");
        PersonVORowImpl currPerson = (PersonVORowImpl)personVO.getCurrentRow();

        InitMemberVORowImpl currInitMem =
            (InitMemberVORowImpl)currPerson.getInitMemberCurrLibVO1();
        Number mem_setup_art_id = null;
        if (new Number(2).equals(currPerson.getPersType()) &&
            !ParsiUtil.NVL(CmemSetup).equals(currPerson.getTempPost())) {
            DatabaseProcedure active_post_art_id =
                DatabaseProcedure.define("FUNCTION parsi_pkg_library.ACTIVE_POST_ART_ID(POST_CODE NUMBER,labcol_no number)RETURN NUMBER;");
            BigDecimal active_post_art_id_result =
                (BigDecimal)active_post_art_id.call(getDBTransaction(),
                                                    CmemSetup,
                                                    getDBTransaction().getSession().getUserData().get("labcolno")).getReturnValue();

            mem_setup_art_id =
                    ParsiUtil.convert_dec_to_number(active_post_art_id_result);

        } else {
            DatabaseProcedure active_post_art_id =
                DatabaseProcedure.define("FUNCTION parsi_pkg_library.ACTIVE_POST_ART_ID(POST_CODE NUMBER,labcol_no number)RETURN NUMBER;");
            BigDecimal active_post_art_id_result =
                (BigDecimal)active_post_art_id.call(getDBTransaction(),
                                                    currPerson.getTempPost(),
                                                    getDBTransaction().getSession().getUserData().get("labcolno")).getReturnValue();

            mem_setup_art_id =
                    ParsiUtil.convert_dec_to_number(active_post_art_id_result);
        }
        EntityDefImpl memberExtentionHistoryDef =
            EntityDefImpl.findDefObject("org.parsisys.tehranuniversity.library.model.eo.MemberExtentionHistory");
        MemberExtentionHistoryImpl memberExtentionHistory =
            (MemberExtentionHistoryImpl)memberExtentionHistoryDef.createInstance2(getDBTransaction(),
                                                                                  null);

       
        memberExtentionHistory.setInsertDate(ParsiUtil.DateToNumber());
        memberExtentionHistory.setRecType(new Number(2));
       
        memberExtentionHistory.setMemsetupArtId(mem_setup_art_id);
        memberExtentionHistory.setMemArtId(currInitMem.getArtId());
        memberExtentionHistory.setUserName((String)getDBTransaction().getSession().getUserData().get("username"));
        memberExtentionHistory.setLabcol((Number)getDBTransaction().getSession().getUserData().get("labcolno"));
        getDBTransaction().commit();
        return new FResult("info",
                           (String)getMessageVO1().findByKey(new Key(new Object[] { "STATUS_CHANGE_SUC".toUpperCase() }),
                                                             -1)[0].getAttribute("Message"));
    }
    
  public FResult cid_member_pre_update() {
        PersonVORowImpl currPerson =
            (PersonVORowImpl)getPersonVO1().getCurrentRow();
    if(currPerson==null) {
      return new FResult("error",
                         (String)getMessageVO1().findByKey(new Key(new Object[] { "choice_record".toUpperCase() }),
                                                           -1)[0].getAttribute("Message"));
      
    }
      if(new Number(2).equals(currPerson.getPersStatus())) {
        return new FResult("error",
                           (String)getMessageVO1().findByKey(new Key(new Object[] { "no_active_no_change".toUpperCase() }),
                                                             -1)[0].getAttribute("Message"));
      }
     
      
    return null;
  }

    public FResult cid_member_save_membership_button() {
        PersonVORowImpl person =
            (PersonVORowImpl)getPersonVO1().getCurrentRow();
        if (person != null) {


            if (new Number(2).equals(person.getPersStatus())) {
                return new FResult("error",
                                   (String)person.getMessageVO1().findByKey(new Key(new Object[] { "no_accept_no_active".toUpperCase() }),
                                                                            -1)[0].getAttribute("Message"));
            }

            if (person.getBarcode() == null) {
                return new FResult("error",
                                   (String)person.getMessageVO1().findByKey(new Key(new Object[] { "barcode_not_null".toUpperCase() }),
                                                                            -1)[0].getAttribute("Message"));
            }
            Number Lib_Id1 = null;
            Number Lib_Id2 = null;
            Number Lib_Id3 = null;
            boolean insertFlag = false;
            /*RASMI*/
            if (new Number(1).equals(person.getPersType())) {
                if (person.getCmemsetupArtId() == null)
                    return new FResult("error",
                                       (String)person.getMessageVO1().findByKey(new Key(new Object[] { "post_not_null".toUpperCase() }),
                                                                                -1)[0].getAttribute("Message"));

                DatabaseProcedure is_local_lib =
                    DatabaseProcedure.define("FUNCTION parsi_pkg_library.IS_LOCAL_LIB2(P_ART_ID NUMBER,CUR_LIB_ART_ID NUMBER)RETURN NUMBER;");

                DBTransaction dbTransaction = getDBTransaction();

                BigDecimal is_local_lib_result =
                    (BigDecimal)is_local_lib.call(dbTransaction,
                                                  person.getArtId(),
                                                  (Number)dbTransaction.getSession().getUserData().get("libartid")).getReturnValue();

                if (new BigDecimal(0).equals(is_local_lib_result)) {

                    DatabaseProcedure get_lib_art_id =
                        DatabaseProcedure.define("FUNCTION parsi_pkg_library.GET_LIB_ART_ID(P_ART_ID NUMBER)RETURN NUMBER;");

                    BigDecimal get_lib_art_id_result =
                        (BigDecimal)get_lib_art_id.call(dbTransaction,
                                                        person.getArtId()).getReturnValue();
                    
                        Lib_Id2 =
                                ParsiUtil.NVL(ParsiUtil.convert_dec_to_number(get_lib_art_id_result));
                        DatabaseProcedure get_lib_father_art_id =
                            DatabaseProcedure.define(" FUNCTION parsi_pkg_library.GET_LIB_FATHER_ART_ID(T_ART_ID NUMBER)RETURN NUMBER;");

                        BigDecimal get_lib_father_art_id_result =
                            (BigDecimal)get_lib_father_art_id.call(dbTransaction,
                                                                   Lib_Id2).getReturnValue();
                        Lib_Id3 =
                                ParsiUtil.NVL(ParsiUtil.convert_dec_to_number(get_lib_father_art_id_result));
                    
                    DatabaseProcedure is_mem_of_lib1 =
                        DatabaseProcedure.define("FUNCTION parsi_pkg_library.IS_MEM_OF_LIB2(P_ART_ID NUMBER,CUR_LIB_ART_ID NUMBER)RETURN NUMBER;");

                    BigDecimal is_mem_of_lib1_result =
                        (BigDecimal)is_mem_of_lib1.call(dbTransaction,
                                                        person.getArtId(),
                                                        new Number(1)).getReturnValue();


                    DatabaseProcedure is_mem_of_lib2 =
                        DatabaseProcedure.define("FUNCTION parsi_pkg_library.IS_MEM_OF_LIB2(P_ART_ID NUMBER,CUR_LIB_ART_ID NUMBER)RETURN NUMBER;");

                    BigDecimal is_mem_of_lib2_result =
                        (BigDecimal)is_mem_of_lib2.call(dbTransaction,
                                                        person.getArtId(),
                                                        Lib_Id2).getReturnValue();


                    DatabaseProcedure is_mem_of_lib3 =
                        DatabaseProcedure.define("FUNCTION parsi_pkg_library.IS_MEM_OF_LIB2(P_ART_ID NUMBER,CUR_LIB_ART_ID NUMBER)RETURN NUMBER;");

                    BigDecimal is_mem_of_lib3_result =
                        (BigDecimal)is_mem_of_lib3.call(dbTransaction,
                                                        person.getArtId(),
                                                        Lib_Id3).getReturnValue();
                    if (new BigDecimal(0).equals(is_mem_of_lib1_result) &&
                        new BigDecimal(0).equals(is_mem_of_lib2_result) &&
                        new BigDecimal(0).equals(is_mem_of_lib3_result))
                        return new FResult("error",
                                           (String)person.getMessageVO1().findByKey(new Key(new Object[] { "no_mem_no_local_lib".toUpperCase() }),
                                                                                    -1)[0].getAttribute("Message"));


                    boolean has_init_mem =
                        person.getInitMemberCurrLibVO1() != null;
                    DatabaseProcedure lib_type =
                        DatabaseProcedure.define("	FUNCTION parsi_pkg_library.LIB_TYPE(CUR_LIB_ART_ID NUMBER)RETURN NUMBER;");

                    BigDecimal lib_type_result =
                        (BigDecimal)lib_type.call(dbTransaction,
                                                  (Number)dbTransaction.getSession().getUserData().get("libartid")).getReturnValue();
                    Number memshipCat = null;
                    String reason = "";
                    if (new BigDecimal(1).equals(lib_type_result)) {
                        memshipCat = new Number(3);
                        reason = "تبدیل نوع عضویت از محلی به بین کتابخانه ای";
                    }
                    //lib_type=1
                    else {
                        memshipCat = new Number(4);
                        reason = "تبدیل نوع عضویت از محلی به مستقل";
                    }

                    if (has_init_mem) {
                        if (memshipCat.equals(((InitMemberVORowImpl)person.getInitMemberCurrLibVO1()).getMemshipCategory())) {

                            insertFlag =
                                    membershipUpdate(person, (Number)dbTransaction.getSession().getUserData().get("libartid"),
                                                     memshipCat);

                        } else {
                            if (updateInitmember((Number)dbTransaction.getSession().getUserData().get("libartid"),
                                                 memshipCat, reason, person) ==
                                3) {
                                return new FResult("error",
                                                   "افراد دارای سمت " +
                                                   person.getPostText() +
                                                   " در این کتابخانه سهمیه ندارند.");
                                // return 3;  JSFUtils.addFacesErrorMessage(" در این کتابخانه سهمیه ندارند." +person.getPostText()+"افراد دارای سمت ");
                            } else {
                                insertFlag = true;
                            }

                        }
                    }
                    // has_init_mem
                    else {
                        int result =
                            insertInitMember((Number)dbTransaction.getSession().getUserData().get("libartid"),
                                             memshipCat, person);
                        if (result == 4) {
                            return new FResult("error",
                                               "افراد دارای سمت " + person.getPostText() +
                                               " در این کتابخانه سهمیه ندارند.");
                            //  return 4; // JSFUtils.addFacesErrorMessage(" در این کتابخانه سهمیه ندارند." +person.getPostText()+"افراد دارای سمت ");
                        } else {
                            insertFlag = true;
                        }
                    }

                } else {
                    if (new Number(1).equals(dbTransaction.getSession().getUserData().get("libartid"))) {
                        Lib_Id1 = new Number(1);
                        DatabaseProcedure get_lib_art_id =
                            DatabaseProcedure.define("FUNCTION parsi_pkg_library.GET_LIB_ART_ID(P_ART_ID NUMBER)RETURN NUMBER;");

                        BigDecimal get_lib_art_id_result =
                            (BigDecimal)get_lib_art_id.call(dbTransaction,
                                                            person.getArtId()).getReturnValue();
                       
                            Lib_Id2 =
                                    ParsiUtil.NVL(ParsiUtil.convert_dec_to_number(get_lib_art_id_result));
                            DatabaseProcedure get_lib_father_art_id =
                                DatabaseProcedure.define(" FUNCTION parsi_pkg_library.GET_LIB_FATHER_ART_ID(T_ART_ID NUMBER)RETURN NUMBER;");

                            BigDecimal get_lib_father_art_id_result =
                                (BigDecimal)get_lib_father_art_id.call(dbTransaction,
                                                                       Lib_Id2).getReturnValue();
                            Lib_Id3 =
                                    ParsiUtil.NVL(ParsiUtil.convert_dec_to_number(get_lib_father_art_id_result));
                         
                    } else {
                        Lib_Id1 = new Number(1);


                        Lib_Id2 =
                                (Number)dbTransaction.getSession().getUserData().get("libartid");
                        
                            DatabaseProcedure get_lib_father_art_id =
                                DatabaseProcedure.define(" FUNCTION parsi_pkg_library.GET_LIB_FATHER_ART_ID(T_ART_ID NUMBER)RETURN NUMBER;");

                            BigDecimal get_lib_father_art_id_result =
                                (BigDecimal)get_lib_father_art_id.call(dbTransaction,
                                                                       Lib_Id2).getReturnValue();
                            Lib_Id3 =
                                    ParsiUtil.NVL(ParsiUtil.convert_dec_to_number(get_lib_father_art_id_result));

                            if (new Number(0).equals(Lib_Id3)) {
                                DatabaseProcedure get_lib_art_id2 =
                                    DatabaseProcedure.define("FUNCTION parsi_pkg_library.GET_LIB_ART_ID(P_ART_ID NUMBER)RETURN NUMBER;");

                                BigDecimal get_lib_art_id_result2 =
                                    (BigDecimal)get_lib_art_id2.call(dbTransaction,
                                                                     person.getArtId()).getReturnValue();
                                Lib_Id3 =
                                        ParsiUtil.NVL(ParsiUtil.convert_dec_to_number(get_lib_art_id_result2));

                            }
                        
                    }

                    InitMemberVOImpl initMember = getInitMemberVO1();
                
                    
                    initMember.setLib_id1(Lib_Id1);
                    initMember.setLib_id2(Lib_Id2);
                    initMember.setLib_id3(Lib_Id3);

                    initMember.setApplyViewCriteriaName("InitMemberVC_cid_member");
                    initMember.executeQuery();
                 boolean has_spc_init_member = initMember.hasNext();
                    
                    if (has_spc_init_member) {
                        initMember.setOrderByClause("InitMember.LIB_ART_ID");
                        initMember.executeQuery();
                        Number maxLibartid =
                            ((InitMemberVORowImpl)initMember.last()).getLibArtId();
                        Number minLibartid =
                            ((InitMemberVORowImpl)initMember.first()).getLibArtId();
                        String LibName =
                            (String)getSession().getUserData().get("libname");
                        if (maxLibartid != null &&
                            maxLibartid.equals(minLibartid)) {
                            LibName = getLibName(minLibartid);
                        } else {
                            LibName =
                                    getLibName(minLibartid) + " و " + getLibName(maxLibartid);
                        }
                        initMember.setOrderByClause(null);
                        initMember.removeApplyViewCriteriaName("InitMemberVC_cid_member");
                        initMember.executeQuery();
                        return new FResult("error",
                                           "این شخص در کتابخانه (های) محلی دیگری عضو است، برای عضویت در این کتابخانه باید از " +
                                           LibName + " تسویه حساب نماید.");
                        // return 5; // JSFUtils.addFacesErrorMessage(" تسویه حساب نماید."+LibName+"این شخص در کتابخانه (های) محلی دیگری عضو است، برای عضویت در این کتابخانه باید از ");
                    }
                    initMember.setOrderByClause(null);
                    initMember.removeApplyViewCriteriaName("InitMemberVC_cid_member");
                    initMember.executeQuery();
                    DatabaseProcedure init_mem_count =
                        DatabaseProcedure.define(" FUNCTION parsi_pkg_library.INIT_MEM_COUNT(P_ART_ID NUMBER,T_LIB_ART_ID NUMBER,MEMSHIP_CAT NUMBER)RETURN NUMBER;");

                    BigDecimal init_mem_count_result =
                        (BigDecimal)init_mem_count.call(dbTransaction,
                                                        person.getArtId(),
                                                        new Number(1),
                                                        new Number(1)).getReturnValue();
                    if (new Number(0).equals(init_mem_count_result)) {
                        if (insertInitMember(new Number(1), new Number(1),
                                             person) == 4) {
                            return new FResult("error",
                                               "افراد دارای سمت " + person.getPostText() +
                                               " در این کتابخانه سهمیه ندارند.");
                            // return 4; // JSFUtils.addFacesErrorMessage(" در این کتابخانه سهمیه ندارند." +person.getPostText()+"افراد دارای سمت ");
                        } else {
                            insertFlag = true;
                        }
                    } else {

                        insertFlag =
                                membershipUpdate(person, new Number(1), new Number(1));


                    }
                    DatabaseProcedure get_lib_art_id =
                        DatabaseProcedure.define(" FUNCTION parsi_pkg_library.GET_LIB_ART_ID(P_ART_ID NUMBER)RETURN NUMBER;");

                    BigDecimal get_lib_art_id_result =
                        (BigDecimal)get_lib_art_id.call(dbTransaction,
                                                        person.getArtId()).getReturnValue();
                    
                        if (get_lib_art_id_result != null) {
                            DatabaseProcedure init_mem_count2 =
                                DatabaseProcedure.define("FUNCTION parsi_pkg_library.INIT_MEM_COUNT(P_ART_ID NUMBER,T_LIB_ART_ID NUMBER,MEMSHIP_CAT NUMBER)RETURN NUMBER;");

                            BigDecimal init_mem_count2_result =
                                (BigDecimal)init_mem_count2.call(dbTransaction,
                                                                 person.getArtId(),
                                                                 get_lib_art_id_result,
                                                                 new Number(2)).getReturnValue();

                            if (new BigDecimal(0).equals(init_mem_count2_result)) {

                                if (insertInitMember(ParsiUtil.convert_dec_to_number(get_lib_art_id_result),
                                                 new Number(2), person) == 4) {
                                    return new FResult("error",
                                                   "افراد دارای سمت " +
                                                   person.getPostText() +
                                                   " در این کتابخانه سهمیه ندارند.");
                                    //return 4; // JSFUtils.addFacesErrorMessage(" در این کتابخانه سهمیه ندارند." +person.getPostText()+"افراد دارای سمت ");
                                } else {
                                    insertFlag = true;
                                }

                            } else {
                                insertFlag =
                                        membershipUpdate(person, ParsiUtil.convert_dec_to_number(get_lib_art_id_result),
                                                         new Number(2)); //returns 0 or 1 or 2

                            }


                        }
                        DatabaseProcedure get_lib_father_art_id =
                            DatabaseProcedure.define("FUNCTION parsi_pkg_library.GET_LIB_FATHER_ART_ID(T_ART_ID NUMBER)RETURN NUMBER;");

                        BigDecimal get_lib_father_art_id_result =
                            (BigDecimal)get_lib_father_art_id.call(dbTransaction,
                                                                   ParsiUtil.convert_dec_to_number(get_lib_art_id_result)).getReturnValue();
                        if (get_lib_father_art_id_result != null) {
                            DatabaseProcedure init_mem_count2 =
                                DatabaseProcedure.define("FUNCTION parsi_pkg_library.INIT_MEM_COUNT(P_ART_ID NUMBER,T_LIB_ART_ID NUMBER,MEMSHIP_CAT NUMBER)RETURN NUMBER;");

                            BigDecimal init_mem_count2_result =
                                (BigDecimal)init_mem_count2.call(dbTransaction,
                                                                 person.getArtId(),
                                                                 get_lib_father_art_id_result,
                                                                 new Number(2)).getReturnValue();
                            if (new BigDecimal(0).equals(init_mem_count2_result)) {

                                if (insertInitMember(ParsiUtil.convert_dec_to_number(get_lib_father_art_id_result),
                                                 new Number(2), person) == 4) {
                                    return new FResult("error",
                                                   "افراد دارای سمت " +
                                                   person.getPostText() +
                                                   " در این کتابخانه سهمیه ندارند.");
                                    //return 4; // JSFUtils.addFacesErrorMessage(" در این کتابخانه سهمیه ندارند." +person.getPostText()+"افراد دارای سمت ");
                                } else {
                                    insertFlag = true;
                                }

                            } else {
                                insertFlag =
                                        membershipUpdate(person, ParsiUtil.convert_dec_to_number(get_lib_father_art_id_result),
                                                         new Number(2)); //returns 0 or 1 or 2

                            }
                        }

                    
                }

                if (insertFlag == true) {
                    JSFUtils.addFacesInfoMessage((String)person.getMessageVO1().findByKey(new Key(new Object[] { "save_completed".toUpperCase() }),
                                                                                          -1)[0].getAttribute("Message"));
                }
            }
            /*GHEYRE RASMI*/
            else {
                if (person.getCmemsetupArtId() == null){
                
                    return  new FResult("post_popup",null);
               
               
               } else {
                    insertFlag =
                            membershipUpdate(person, (Number)getDBTransaction().getSession().getUserData().get("libartid"),
                                             new Number(2));

                }
                if (insertFlag == true) {
                    JSFUtils.addFacesInfoMessage((String)person.getMessageVO1().findByKey(new Key(new Object[] { "save_completed".toUpperCase() }),
                                                                                          -1)[0].getAttribute("Message"));
                }
            }

        }
        return null;

    }

 public FResult cid_member_save_membership_after_post_popup() {
        PersonVORowImpl currPerson =
            (PersonVORowImpl)getPersonVO1().getCurrentRow();
 if(currPerson==null) {
   return new FResult("error","شخصی انتخاب نشده است.");
 }
 if(currPerson.getCmemSetupPost()==null) {
   return new FResult("error",
                      (String)getMessageVO1().findByKey(new Key(new Object[] { "post_not_null".toUpperCase() }),
                                                        -1)[0].getAttribute("Message"));
   
 }
        if (ParsiUtil.NVL(currPerson.getPostEndDate()).compareTo(ParsiUtil.DateToNumber()) <
            1) {
   DatabaseProcedure item_text =
   DatabaseProcedure.define("FUNCTION parsi_pkg_catalog.ITEM_TEXT(CAT_NAME VARCHAR2,ITEM_VAL NUMBER,labcol_no number) RETURN VARCHAR2;");
   
            String item_text_result =
                (String)item_text.call(getDBTransaction(), "PRIVATE_POST",
                                       currPerson.getCmemSetupPost(),
                                       getSession().getUserData().get("labcolno")).getReturnValue();
            return new FResult("error",
                               "دوره اعتبار سمت " + item_text_result + " منقضی شده است.");
   }
   
   DatabaseProcedure init_mem_count =
       DatabaseProcedure.define(" FUNCTION parsi_pkg_library.INIT_MEM_COUNT(P_ART_ID NUMBER,T_LIB_ART_ID NUMBER,MEMSHIP_CAT NUMBER)RETURN NUMBER;");
   Number init_mem_count_result =
       ParsiUtil.convert_dec_to_number((BigDecimal)init_mem_count.call(getDBTransaction(),
                                                                       currPerson.getArtId(),
                                                                       getDBTransaction().getSession().getUserData().get("libartid"),
                                                                       new Number(2)).getReturnValue());

        if (init_mem_count_result == null ||
            new Number(0).equals(init_mem_count_result)) {
            InitMemberVORowImpl newInitMem =
                (InitMemberVORowImpl)getInitMemberCurrLibVO().createRow();
     getInitMemberCurrLibVO().insertRow(newInitMem);
     newInitMem.setLibArtId((Number)getSession().getUserData().get("libartid"));
     newInitMem.setPersArtId(currPerson.getArtId());
     newInitMem.setLoanedCount(new Number(0));
     newInitMem.setReservedCount(new Number(0));
     newInitMem.setRecalledCount(new Number(0));
     newInitMem.setMemshipCategory(new Number(2));
     newInitMem.setMemshipStatus(new Number(1));
     newInitMem.setDebitSum(new Number(0));
     newInitMem.setDebitNonCash(new Number(2));
     newInitMem.setLoanedInPlaceCount(new Number(0));
     newInitMem.setIntroductionLetterCount(new Number(0));
     
     getDBTransaction().commit();
     
     ///Member Status History
            MemberStatusHistoryVORowImpl newMemStatusHist =
                (MemberStatusHistoryVORowImpl)getMemberStatusHistoryVO1().createRow();
     getMemberStatusHistoryVO1().insertRow(newMemStatusHist);
     newMemStatusHist.setStatus(new Number(1));
     newMemStatusHist.setDayDate(ParsiUtil.DateToNumber());
     newMemStatusHist.setUserName((String)getSession().getUserData().get("username"));
     newMemStatusHist.setIntmemArtId(newInitMem.getArtId());
     newMemStatusHist.setLibArtId((Number)getSession().getUserData().get("libartid"));
   
     //Member
     EntityDefImpl MemberDef =
         EntityDefImpl.findDefObject("org.parsisys.tehranuniversity.library.model.eo.Member");
     MemberImpl newMember =
         (MemberImpl)MemberDef.createInstance2(getDBTransaction(),
                                                              null);
//     MemberVoRowImpl newMember = (MemberVoRowImpl)getMemberVo_InitMemCurLib().createRow();
//     getMemberVo_InitMemCurLib().insertRow(newMember);
     newMember.setArtId(newInitMem.getArtId());
     newMember.setDescription(null);
     newMember.setLabcol((Number)getSession().getUserData().get("labcolno"));
   
     //member extension history
     DatabaseProcedure active_post_art_id =
         DatabaseProcedure.define("FUNCTION parsi_pkg_library.ACTIVE_POST_ART_ID(POST_CODE NUMBER,labcol_no number)RETURN NUMBER;");
     Number active_post_art_id_result =
                ParsiUtil.convert_dec_to_number((BigDecimal)active_post_art_id.call(getDBTransaction(),
                                                                                    currPerson.getCmemSetupPost(),
                                                                                    getSession().getUserData().get("labcolno")).getReturnValue());
     
     EntityDefImpl MemExtHstDef =
         EntityDefImpl.findDefObject("org.parsisys.tehranuniversity.library.model.eo.MemberExtentionHistory");
     MemberExtentionHistoryImpl newMemberExtHist =
         (MemberExtentionHistoryImpl)MemExtHstDef.createInstance2(getDBTransaction(),
                                                              null);
     newMemberExtHist.setInsertDate(ParsiUtil.DateToNumber());
     newMemberExtHist.setRecType(new Number(1));
     newMemberExtHist.setMemsetupArtId(active_post_art_id_result);
     newMemberExtHist.setMemArtId(newInitMem.getArtId());
     newMemberExtHist.setUserName((String)getSession().getUserData().get("username"));
     newMemberExtHist.setLabcol((Number)getSession().getUserData().get("labcolno"));
     getDBTransaction().commit();
     return new FResult("success",
                        (String)getMessageVO1().findByKey(new Key(new Object[] { "save_completed".toUpperCase() }),
                                                          -1)[0].getAttribute("Message"));
   }else {
        
            membershipUpdate(currPerson,
                             (Number)getSession().getUserData().get("libartid"),
                             new Number(2));
       
     return null;
      
   }
  
  
 }

  public FResult cid_member_update_person() {
        PersonVORowImpl currPerson =
            (PersonVORowImpl)getPersonVO1().getCurrentRow();
      if(currPerson==null) {
        return new FResult("error",
                           (String)getMessageVO1().findByKey(new Key(new Object[] { "choice_record".toUpperCase() }),
                                                             -1)[0].getAttribute("Message"));
        
      }
      if(new Number(2).equals(currPerson.getPersStatus())) {
        return new FResult("error",
                           (String)getMessageVO1().findByKey(new Key(new Object[] { "no_active_no_change".toUpperCase() }),
                                                             -1)[0].getAttribute("Message"));
        
      }
    /*
    
      p1_id:=get_parameter_list('input_data');
      IF NOT Id_Null(p1_id) THEN
          destroy_parameter_list(p1_id);
      END IF;
      p1_id:=create_parameter_list('input_data');
      IF Id_Null(p1_id) THEN
         message('Error in creating parameter list ');
         go_item('PERSON.BARCODE');
         RAISE form_trigger_failure;
      END IF;
      ART_ID:=:PERSON.ART_ID;
      add_parameter(p1_id,'ART_ID',Text_parameter,ART_ID);
      call_form('CHANGE_PERSON',nO_hide,no_replace,no_query_only,p1_id);
      set_block_property('person',default_where,' art_id='||ART_ID);
      execute_query;
      go_item('PERSON.BARCODE');
      set_block_property('person',default_where,'');
     */
    return null;
  }

    private int updateInitmember(Number currLib, Number memshipCat,
                                 String reason, PersonVORowImpl person) {
        DatabaseProcedure post_loan_quota =
            DatabaseProcedure.define("FUNCTION parsi_pkg_library.POST_LOAN_QUOTA(P_CSETUP_ID NUMBER,memship_cat number) RETURN NUMBER;");

        BigDecimal post_loan_quota_result =
            (BigDecimal)post_loan_quota.call(getDBTransaction(),
                                             person.getCmemsetupArtId(),
                                             memshipCat).getReturnValue();
        if (post_loan_quota_result != null &&
            post_loan_quota_result.intValue() > 0) {
            ((InitMemberVORowImpl)person.getInitMemberCurrLibVO1()).setMemshipCategory(memshipCat);
            ((InitMemberVORowImpl)person.getInitMemberCurrLibVO1()).setMemshipStatus(new Number(1));

//            SequenceImpl si =
//                new SequenceImpl("LCID_GRANTEE_USER.SEQ_MEM_ST_HIS_ART_ID",
//                                 getDBTransaction());

            EntityDefImpl MemStHstDef =
                EntityDefImpl.findDefObject("org.parsisys.tehranuniversity.library.model.eo.MemberStatusHistory");
            MemberStatusHistoryImpl memberStHist =
                (MemberStatusHistoryImpl)MemStHstDef.createInstance2(getDBTransaction(),
                                                                     null);
            //memberStHist.setArtId(new DBSequence(si.getSequenceNumber()));
            memberStHist.setStatus(new Number(1));
            memberStHist.setDayDate(ParsiUtil.DateToNumber());
            memberStHist.setReason(reason);
            memberStHist.setUserName((String)getDBTransaction().getSession().getUserData().get("username"));
            memberStHist.setIntmemArtId(((InitMemberVORowImpl)person.getInitMemberCurrLibVO1()).getArtId());
            memberStHist.setLibArtId(currLib);
            getDBTransaction().commit();
            return 0;
        } else {
            return 3; // JSFUtils.addFacesErrorMessage(" در این کتابخانه سهمیه ندارند." +person.getPostText()+"افراد دارای سمت ");
        }


    }

    private boolean membershipUpdate(PersonVORowImpl person, Number currLib,
                                     Number memshipCat) {
        DatabaseProcedure init_mem_count_tasfiye =
            DatabaseProcedure.define("FUNCTION parsi_pkg_library.INIT_MEM_COUNT_TASFIYE(P_ART_ID NUMBER,T_LIB_ART_ID NUMBER,MEMSHIP_CAT NUMBER)RETURN NUMBER;");

        BigDecimal init_mem_count_tasfiye_result =
            (BigDecimal)init_mem_count_tasfiye.call(getDBTransaction(),
                                                    person.getArtId(),
                                                    currLib,
                                                    memshipCat).getReturnValue();
        String currLibName =
            (String)getDBTransaction().getSession().getUserData().get("libname");
        if (init_mem_count_tasfiye_result != null &&
            init_mem_count_tasfiye_result.intValue() > 0) {
            ((InitMemberVORowImpl)person.getInitMemberCurrLibVO1()).setMemshipStatus(new Number(1));
            SequenceImpl si =
                new SequenceImpl("SEQ_MEM_ST_HIS_ART_ID",
                                 getDBTransaction());
            EntityDefImpl MemStHstDef =
                EntityDefImpl.findDefObject("org.parsisys.tehranuniversity.library.model.eo.MemberStatusHistory");
            MemberStatusHistoryImpl memberStHist =
                (MemberStatusHistoryImpl)MemStHstDef.createInstance2(getDBTransaction(),
                                                                     null);
            memberStHist.setArtId(si.getSequenceNumber());
            memberStHist.setStatus(new Number(1));
            memberStHist.setDayDate(ParsiUtil.DateToNumber());
            memberStHist.setUserName((String)getDBTransaction().getSession().getUserData().get("username"));
            memberStHist.setIntmemArtId(((InitMemberVORowImpl)person.getInitMemberCurrLibVO1()).getArtId());
            memberStHist.setLibArtId(currLib);
            getDBTransaction().commit();
            JSFUtils.addFacesInfoMessage("وضعیت شخص در کتابخانه " +
                                         currLibName +
                                         " از حالت تسویه به عادی تبدیل شد.");
            return true;

        } else if (((Number)getDBTransaction().getSession().getUserData().get("libartid")).equals(currLib)) {
            JSFUtils.addFacesInfoMessage("برای این فرد عضویت در " +
                                         currLibName +
                                         " در سیستم ثبت شده است.");
        }


        return false;
    }

    private int insertInitMember(Number TLibArtId, Number memshipCat,
                                 PersonVORowImpl person) {

        DatabaseProcedure post_loan_quota =
            DatabaseProcedure.define("FUNCTION parsi_pkg_library.POST_LOAN_QUOTA(P_CSETUP_ID NUMBER,memship_cat number) RETURN NUMBER;");

        BigDecimal post_loan_quota_result =
            (BigDecimal)post_loan_quota.call(getDBTransaction(),
                                             person.getCmemsetupArtId(),
                                             memshipCat).getReturnValue();
        if (post_loan_quota_result != null &&
            post_loan_quota_result.intValue() > 0) {
           

            EntityDefImpl initMemDef =
                EntityDefImpl.findDefObject("org.parsisys.tehranuniversity.library.model.eo.InitMember");
            InitMemberImpl initMember =
                (InitMemberImpl)initMemDef.createInstance2(getDBTransaction(),
                                                           null);
            initMember.setLibArtId(TLibArtId);
            initMember.setPersArtId(person.getArtId());
            initMember.setLoanedCount(new Number(0));
            initMember.setReservedCount(new Number(0));
            initMember.setRecalledCount(new Number(0));
            initMember.setMemshipCategory(memshipCat);
            initMember.setMemshipStatus(new Number(1));


            initMember.setDebitSum(new Number(0));
            initMember.setDebitNonCash(new Number(2));
            initMember.setLoanedInPlaceCount(new Number(0));
            initMember.setIntroductionLetterCount(new Number(0));
            getDBTransaction().commit();
            //TODO: aya inja ham bayad commit soorat begirad ya kheir?


            EntityDefImpl MemStHstDef =
                EntityDefImpl.findDefObject("org.parsisys.tehranuniversity.library.model.eo.MemberStatusHistory");
            MemberStatusHistoryImpl memberStHist =
                (MemberStatusHistoryImpl)MemStHstDef.createInstance2(getDBTransaction(),
                                                                     null);

            memberStHist.setStatus(new Number(1));
            memberStHist.setDayDate(ParsiUtil.DateToNumber());
            memberStHist.setReason("شروع عضویت");
            memberStHist.setUserName((String)getDBTransaction().getSession().getUserData().get("username"));
            memberStHist.setIntmemArtId(initMember.getArtId());
            memberStHist.setLibArtId(TLibArtId);

            getDBTransaction().commit();
            return 0;

        } else {
            return 4; // JSFUtils.addFacesErrorMessage(" در این کتابخانه سهمیه ندارند." +person.getPostText()+"افراد دارای سمت ");
        }

    }

    private String getLibName(Number libArtId) {
        DatabaseProcedure get_lib_name =
            DatabaseProcedure.define("FUNCTION parsi_pkg_library.GET_LIB_NAME(T_LIB_ART_ID NUMBER)RETURN VARCHAR2;");

        String get_lib_name_result =
            (String)get_lib_name.call(getDBTransaction(),
                                      libArtId).getReturnValue();

        return get_lib_name_result;
    }

    public FResult bookStatusBarcodeChange_save(String newBarcode,
                                                Number newExistenceSt,
                                                Number newSafetySt,
                                                Number newLoanSt,
                                                Number newPlace) {
        PhysicalBookVOImpl physicalBookVo =
            (PhysicalBookVOImpl)getBookBarcodeChange(); //Instance of physicalBook
        PhysicalBookVORowImpl phbook =
            (PhysicalBookVORowImpl)physicalBookVo.getCurrentRow();
        PhysicalBookImpl phbookEntity = (PhysicalBookImpl)phbook.getEntity(0);

        if(phbook ==null ){
            return new FResult("error","ابتدا یک کتاب جستجو کنید.");
            }
        
        Number oldExistenceSt =
            (Number)phbookEntity.getPostedAttribute2(phbookEntity.EXISTENCESTATUS);
        Number oldSaftySt =
            (Number)phbookEntity.getPostedAttribute2(phbookEntity.SAFETYSTATUS);
        Number oldLoanSt =
            (Number)phbookEntity.getPostedAttribute2(phbookEntity.LOANSTATUS);
        Number oldPlace =
            (Number)phbookEntity.getPostedAttribute2(phbookEntity.PLACE);

        String oldBarcode = phbook.getBarcode();

        if (phbook.getLoanVO_nullRetDate().getRowCount() > 0 &&
            (!newExistenceSt.equals(oldExistenceSt) ||
             !oldBarcode.equals(newBarcode))) {
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "un_upd_loan_st".toUpperCase() }),
                                                         -1)[0].getAttribute("Message"));
        }

        if (newExistenceSt.equals(new Number(2)) &&
            !oldExistenceSt.equals(new Number(2)))
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "un_upd_phbook_status".toUpperCase() }),
                                                         -1)[0].getAttribute("Message"));

        if (ParsiUtil.clearString(newBarcode) != null &&
            !newBarcode.equalsIgnoreCase(oldBarcode)) {
            AllPhysicalBooksVOImpl allPhysicalBookVo =
                (AllPhysicalBooksVOImpl)getAllPhysicalBooksRoVO1();
            allPhysicalBookVo.setbarcode_no(newBarcode);
            
            allPhysicalBookVo.executeQuery();
            if (allPhysicalBookVo.getRowCount() > 0)
                return new FResult("error",
                                   (String)getMessageVO1().findByKey(new Key(new Object[] { "duplicate_bk_barcode".toUpperCase() }),
                                                             -1)[0].getAttribute("Message"));
            if (oldBarcode == null && new Number(4).equals(oldExistenceSt)) {

                phbook.setExistenceStatus(new Number(1));
            }
            int cnt = phbook.getBookBarcodeHistoryVO().getRowCount();

            if (oldBarcode != null || cnt > 0) {

                RowIterator barcodeHisVo = phbook.getBookBarcodeHistoryVO();

                Row newRec = barcodeHisVo.createRow();
                barcodeHisVo.insertRow(newRec);

                newRec.setAttribute("DayDate", phbook.getBarcodeChangeDate());
                newRec.setAttribute("PhbookArtId", phbook.getArtId());
                newRec.setAttribute("UserName", phbook.getBarcodeChangeUser());
                newRec.setAttribute("Barcode",
                                    ParsiUtil.StNVL(oldBarcode, "خالی"));
                newRec.setAttribute("Labcol",
                                    (Number)getDBTransaction().getSession().getUserData().get("labcolno"));

            }
            phbook.setBarcode(newBarcode);
            phbook.setBarcodeChangeDate(ParsiUtil.DateToNumber());
            phbook.setBarcodeChangeUser((String)getDBTransaction().getSession().getUserData().get("username"));

            getTransaction().commit();

        }
        if (!oldExistenceSt.equals(newExistenceSt) ||
            !oldSaftySt.equals(newSafetySt) || !oldLoanSt.equals(newLoanSt) ||
            !oldPlace.equals(newPlace)) {
            EntityDefImpl MemStHstDef =
                EntityDefImpl.findDefObject("org.parsisys.tehranuniversity.library.model.eo.BookStatusHistory");
            BookStatusHistoryImpl bookStHist =
                (BookStatusHistoryImpl)MemStHstDef.createInstance2(getDBTransaction(),
                                                                   null);
            bookStHist.setDayDate(phbook.getStatusChangeDate());
            bookStHist.setLoanStatus(oldLoanSt);
            bookStHist.setSafetyStatus(oldSaftySt);
            bookStHist.setExistenceStatus(oldExistenceSt);
            bookStHist.setPlace(oldPlace);
            bookStHist.setPhbookArtId(phbook.getArtId());
            bookStHist.setUserName(phbook.getStatusChangeUser());
        
            bookStHist.setLabcol((Number)(getDBTransaction().getSession().getUserData().get("labcolno")));
        }
        phbook.setStatusChangeDate(ParsiUtil.DateToNumber());
        phbook.setStatusChangeUser((String)getDBTransaction().getSession().getUserData().get("username"));

        getTransaction().commit();
        
        return new FResult("info","با موفقیت ثبت گردید.");
    }

    public FResult saveBookBarcodeChange(String newBarcode) {
        PhysicalBookVOImpl physicalBookVo =
            (PhysicalBookVOImpl)getBookBarcodeChange(); //Instance of physicalBook
        PhysicalBookVORowImpl phbook =
            (PhysicalBookVORowImpl)physicalBookVo.getCurrentRow();
        
        if(phbook==null){
            return new FResult("error","ابتدا یک کتاب جستجو کنید.");
            }
        newBarcode=ParsiUtil.clearString(newBarcode);
        if(newBarcode== null || newBarcode.equals(phbook.getBarcode())){
            return new FResult("error","بارکد جدید را وارد نمایید.");
            
            }
       
            
        if (newBarcode != null && phbook != null) {
            //!newBarcode.equals(phbook.getBarcode())
            if (phbook.getLoanVO_nullRetDate().getRowCount() > 0) {
                return new FResult("error",
                                   (String)getMessageVO1().findByKey(new Key(new Object[] { "un_upd_barcode".toUpperCase() }),
                                                             -1)[0].getAttribute("Message"));
            }
            AllPhysicalBooksVOImpl allPhysicalBookVo =
                (AllPhysicalBooksVOImpl)getAllPhysicalBooksRoVO1();
            allPhysicalBookVo.setbarcode_no(newBarcode);
            allPhysicalBookVo.executeQuery();

            if (allPhysicalBookVo.getRowCount() > 0) {
                //TODO:satr ha ye comment shode message morede nazar ra peyda nakard
                return new FResult("error", "بارکد تکراری است.");
                //                                   getMessageVO1().findByKey(new Key(new Object[] { "DUPLICATE_BK_BARCODE".toUpperCase() }),
                //                                                             -1)[0].getAttribute("Message"));
            }
            if (phbook.getBarcode() == null &&
                new Number(4).equals(phbook.getExistenceStatus())) {
                phbook.setExistenceStatus(new Number(1));
                getDBTransaction().commit();
            }

            if (phbook.getBarcode() != null ||
                phbook.getBookBarcodeHistoryVO().getRowCount() > 0) {


                RowIterator barcodeHisVo = phbook.getBookBarcodeHistoryVO();
                //PhysicalBookVORowImpl phBook=(PhysicalBookVORowImpl)physicalBookVo.getCurrentRow();
                // Number physicalBookArtID =(Number)(physicalBookVo.getCurrentRow().getAttribute("ArtId"));

                Row newRec = barcodeHisVo.createRow();
                barcodeHisVo.insertRow(newRec);

                newRec.setAttribute("DayDate", phbook.getBarcodeChangeDate());
                newRec.setAttribute("PhbookArtId", phbook.getArtId());

                newRec.setAttribute("UserName", phbook.getBarcodeChangeUser());
                newRec.setAttribute("Barcode",
                                    ParsiUtil.StNVL(phbook.getBarcode(),
                                                    "خالی"));
                //newRec.setAttribute("Labcol", getDBTransaction().getSession().getUserData().get("labcolno"));

            }
            phbook.setAttribute("Barcode", newBarcode);
            phbook.setAttribute("BarcodeChangeDate", ParsiUtil.DateToNumber());
            phbook.setAttribute("BarcodeChangeUser",
                                (String)getDBTransaction().getSession().getUserData().get("username"));

            getTransaction().commit();

        }
        return new FResult("info", "بارکد جدید ثبت گردید.");

    }


    public FResult select_publisher_mainpage() {
      VbookPublisherVORowImpl r=null;
        try{
        Row pub = getPublisherVO1().getCurrentRow();
       // Row r = getVbookPublisherVO1().getCurrentRow();
        //   if(r==null)
        create_new_row(getVbookPublisherVO1());
        r = (VbookPublisherVORowImpl)getVbookPublisherVO1().getCurrentRow();
        r.setAttribute("PubArtId", pub.getAttribute("ArtId"));
        
        r.validate();
        }catch(RowValException e) {
         r.remove();
       return new FResult("error", ((AttrSetValException) e.getDetails()[0]).getBaseMessage());


           
               // throw  ((AttrSetValException) e.getDetails()[0]).getDetails()[0];
           
        }
        return null;
    }

    public FResult select_subject() {
      Row vs=null;
        try{
        Row curr = getSubjectVO1().getCurrentRow();
        vs = getVbookSubjectVO1().createRow();
          getVbookSubjectVO1().insertRow(vs);
       
        vs.setAttribute("SubjArtId", curr.getAttribute("ArtId"));
            vs.validate();
        }
      catch(RowValException e) {
               vs.remove();
             return new FResult("error", ((AttrSetValException) e.getDetails()[0]).getBaseMessage());


                 
                     // throw  ((AttrSetValException) e.getDetails()[0]).getDetails()[0];
                 
              }
        return null;
    }

    public void select_float_subject() {
        Row curr = getFloatSubjectVO1().getCurrentRow();
        Row vs = getVbookSubjectVO1().getCurrentRow();
        vs.setAttribute("FloatSubjArtId", curr.getAttribute("ArtId"));
        //  System.out.println(curr.getAttribute("ArtId"));
    }

    private void create_new_row(ViewObject vo) {
        //        vo.last();
        //        vo.insertRow(vo.createRow());
        Row row = vo.createRow();
        Row lastRow = vo.last();
        if (lastRow != null) {
            //insert new row at the end and make it current
            int indx = vo.getRangeIndexOf(lastRow) + 1;
            vo.insertRowAtRangeIndex(indx, row);
            vo.setCurrentRow(row);
        } else { // empty Rowset
            vo.insertRow(row);
        }
    }

    public Number getCurrentLibArtId() {
        //TODO: retrive current lib art id from session and return it.
        return null;
    }
    
    public void removeUniformTitleFromCurrVbook() {
      VirtualBookVORowImpl currVbook = (VirtualBookVORowImpl)getVirtualBookVO1().getCurrentRow();
      if(currVbook!=null)
          currVbook.setUniformTitle1(null);
    }

    public FResult select_other_uniform_title() {
      Row r=null;
        try{
        Row rv = getUniformTitleVO1().getCurrentRow();
         r = getVbookUniTtlVO1().createRow();
      getVbookUniTtlVO1().insertRow(r);
        r.setAttribute("UniTitleArtId",rv.getAttribute("ArtId"));
            r.validate();
        }      catch(RowValException e) {
               r.remove();
             return new FResult("error", ((AttrSetValException) e.getDetails()[0]).getBaseMessage());

                 
              }
        return null;
   
    }

    public void copy_uniform_title() {
        Row rv = getUniformTitleVO1().getCurrentRow();
        if (rv != null) {
          
            getVirtualBookVO1().getCurrentRow().setAttribute("UniformTitle1",
                                                             rv.getAttribute("ArtId"));
        }
    }

    public void virtubalBookFilter(String name){
       if(name==null) {
         getVirtualBookVO1().removeApplyViewCriteriaName("English");
          getVirtualBookVO1().removeApplyViewCriteriaName("Persian");
       }else
         getVirtualBookVO1().setApplyViewCriteriaName(name);
       
    
  getVirtualBookVO1().executeQuery();
    }

   public void copy_provider_other() {
        Object artid = getProviderVO1().getCurrentRow().getAttribute("ArtId");
        Row r = getVbookOtherProviderVO1().createRow();
      getVbookOtherProviderVO1().insertRow(r);
        r.setAttribute("PrvArtId",artid);
       r.setAttribute("EntryKind",new oracle.jbo.domain.Number(2));

    }

    public int copy_provider_main_page() {
//    getVirtualBookVO1().executeQuery();
//      getVirtualBookVO1().setRangeStart(rngStrt);
//        getVirtualBookVO1().setCurrentRowAtRangeIndex(rngIndx);// getVirtualBookVO1().sc(arg0, arg1)
       // getVirtualBookVO1().setRangeStart(rngStrt);
     // getVirtualBookVO1().findAndSetCurrentRowByKey(currVbook.getKey(), rngIndx);
      // VirtualBookVORowImpl currVB = (VirtualBookVORowImpl)getVirtualBookVO1().getCurrentRow();
//     VirtualBookVORowImpl currVB= (VirtualBookVORowImpl)currVbook;
//        RowIterator iterator = currVB.getVbookProviderVO();
       
        Row r = getVbookMainProviderVO1().getCurrentRow();
       
        if (r == null) {
            create_new_row(getVbookMainProviderVO1());
            r = getVbookMainProviderVO1().getCurrentRow();
//         r= getVbookProviderVO2().createRow();
//          getVbookProviderVO2().insertRow(r);
            r.setAttribute("PrvArtId",
                           getProviderVO1().getCurrentRow().getAttribute("ArtId"));
            r.setAttribute("EntryKind", new oracle.jbo.domain.Number(1));
//            r.setAttribute("VbookArtId", currVbook.getAttribute("ArtId"));
//            r.setAttribute("Labcol",(Number) getSession().getUserData().get("labcolno"));
        }
        //change all row...
        else {
            //            r.setAttribute("PrvArtId", getProviderVO1().getCurrentRow().getAttribute("ArtId"));
            Object artid =
                getProviderVO1().getCurrentRow().getAttribute("ArtId");
           RowSet rowSet = getVbookMainProviderVO1().createRowSet("null");
          // mainProvider.getVari;
            while (rowSet.hasNext()) {
                Row rp = rowSet.next();
                rp.setAttribute("PrvArtId", artid);
                // rp.setAttribute("Provider1", "amir");

            }
            rowSet.closeRowSet();
        }
   // System.out.println( getVbookMainProviderVO1().getCurrentRow());
        return 1;
    }

    public void select_role() {
        Object artid =
            getProviderRoleVO1().getCurrentRow().getAttribute("ArtId");
        getVbookOtherProviderVO1().getCurrentRow().setAttribute("PrvroleArtId",
                                                                artid);


    }

    public int copy_role_main_page() {
        Row r = getVbookMainProviderVO1().getCurrentRow();
        if (r == null)
            return 0;
        if (r.getAttribute("PrvroleArtId") != null)
            create_new_row(getVbookMainProviderVO1());
        r = getVbookMainProviderVO1().getCurrentRow();
        r.setAttribute("PrvroleArtId",
                       getProviderRoleVO1().getCurrentRow().getAttribute("ArtId"));
        r.setAttribute("EntryKind", new oracle.jbo.domain.Number(1));
        r.setAttribute("PrvArtId",
                       getVbookMainProviderVO1().first().getAttribute("PrvArtId"));
        return 1;
    }

    public FResult registerLost_preInsert(int value) {

        PersonVORowImpl currPers =
            (PersonVORowImpl)getPersonVO1().getCurrentRow();
        if (currPers.getBarcode() == null)
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "BARCODE_NOT_NULL".toUpperCase() }),
                                                                 -1)[0].getAttribute("Message"));

        if (value == 0)
            return new FResult("error", "لطفا مقدار جریمه را وارد کنید.");


        RegisterLostVORowImpl currRec =
            (RegisterLostVORowImpl)getRegisterLostVO1().getCurrentRow();

        if (!new Number(0).equals(ParsiUtil.NVL(currRec.getRealRetDate())))
            return new FResult("error",
                               "ابتدا کتاب باید به عنوان گم شده ثبت شود سپس جریمه برای آن درج شود.");

        if (!new Number(0).equals(ParsiUtil.NVL(currRec.getValue())))
            return new FResult("error",
                               "جریمه برای رکورد جاری درج شده است .جهت تغییر آن از کلید ویرایش جریمه استفاده کنید.");

        return new FResult("yn_popup", "آیا می خواهید  جریمه جدید ثبت شود؟");
    }

    public boolean registerLost_insert(Integer value, String description) {
        DBTransaction trans = getDBTransaction();

        CallableStatement statement = null;
        int rows = 0;


        ViewObject registerLostVo = getRegisterLostVO1();
        RegisterLostVORowImpl currRec =
            (RegisterLostVORowImpl)registerLostVo.getCurrentRow();


        currRec.getInitMemberVO().getAttribute("DebitSum");

        Number loan_Artid =
            (Number)((RegisterLostVORowImpl)registerLostVo.getCurrentRow()).getArtId2().getSequenceNumber();
        String plsql =
            " INSERT INTO loan_cash_penalty(VALUE,DAY_DATE,DESCRIPTION,LOAN_PENALTY_TYPE,LOAN_ART_ID,LABCOL,USER_NAME) " +
            "VALUES (?," + ParsiUtil.DateToNumber() + ",?," + 1 + "," +
            loan_Artid.intValue() + "," +
            Integer.parseInt(getSession().getUserData().get("labcol").toString()) +
            ",'" + (String)getSession().getUserData().get("username") + "')";
        statement = trans.createCallableStatement(plsql, 2);
        try {
            statement.setInt(1, value);
            statement.setString(2, description);
            statement.execute();
            //rows = statement.executeUpdate();
            //execute the update...
            Number debit =
                (Number)((RegisterLostVORowImpl)registerLostVo.getCurrentRow()).getInitMemberVO().getAttribute("DebitSum");
            Number val = new Number(value.intValue());
            ((RegisterLostVORowImpl)registerLostVo.getCurrentRow()).getInitMemberVO().setAttribute("DebitSum",
                                                                                                   val.add(debit));
            //when every thin is finished..
            getDBTransaction().commit();
            registerLostVo.executeQuery();
        } catch (SQLException s) {
            System.err.println(s.getMessage() + this.getClass().getName());
            return false;
        } finally {
            try {
                if (statement != null)
                    statement.close();

            } catch (SQLException s) { /* ignore */
                return false;
            }

        }
        // return true;
        return true;
    }


    public FResult registerLost_preEdit(Integer value, String description) {

        PersonVORowImpl currPers =
            (PersonVORowImpl)getPersonVO1().getCurrentRow();
        if (currPers.getBarcode() == null) {
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "BARCODE_NOT_NULL".toUpperCase() }),
                                                                 -1)[0].getAttribute("Message"));
        }
        if (value == 0)
            return new FResult("error", "لطفا مقدار جریمه را وارد کنید.");
        RegisterLostVORowImpl currLost =
            (RegisterLostVORowImpl)getRegisterLostVO1().getCurrentRow();

        if (ParsiUtil.NVL(currLost.getValue()).intValue() == 0)
            return new FResult("error",
                               "هنوز برای رکورد جاری جریمه درج نشده است، لطفا ابتدا جریمه را ثبت کنید.");


        return new FResult("yn_popup", "آیا می خواهید تغییرات جریمه ثبت شود؟");
    }


    public boolean registerLost_edit(Integer value, String description) {
        DBTransaction trans = getDBTransaction();

        CallableStatement statement = null;
        int rows = 0;
        // ViewObject loanCashPenaltyVo = getLoanCashPenaltyVO1();
        ViewObject registerLostVo = getRegisterLostVO1();

        String plsql =
            " Update loan_cash_penalty SET VALUE = ?,DAY_DATE=" + ParsiUtil.DateToNumber() +
            ",DESCRIPTION=? ,USER_NAME='" +
            (String)getDBTransaction().getSession().getUserData().get("username") +
            "' where loan_art_id=" +
            ((RegisterLostVORowImpl)registerLostVo.getCurrentRow()).getLoanArtId();
        System.out.println(plsql);
        statement = trans.createCallableStatement(plsql, 2);
        try {
            statement.setInt(1, value);
            statement.setString(2, description);
            statement.execute();
            //rows = statement.executeUpdate();
            //execute the update...
            Number debit =
                (Number)((RegisterLostVORowImpl)registerLostVo.getCurrentRow()).getInitMemberVO().getAttribute("DebitSum");
            Number val = new Number(value.intValue());
            Number delayPenalty =
                (Number)(registerLostVo.getCurrentRow().getAttribute("Value"));
            Number finalDebitSum =
                ParsiUtil.NVL(debit).plus(val.subtract(delayPenalty));
            ((RegisterLostVORowImpl)registerLostVo.getCurrentRow()).getInitMemberVO().setAttribute("DebitSum",
                                                                                                   finalDebitSum);
            //when every thing is finished..
            getDBTransaction().commit();
            registerLostVo.executeQuery();
        } catch (SQLException s) {
            System.err.println(s.getMessage() + this.getClass().getName());
            return false;
        } finally {
            try {
                if (statement != null)
                    statement.close();

            } catch (SQLException s) { /* ignore */
                return false;
            }

        }
        // return true;
        return true;
    }

    public FResult preInsert_loanCashPenalty(int value, String description) {

        PersonVORowImpl currPers =
            (PersonVORowImpl)getPersonVO1().getCurrentRow();
        if (currPers.getBarcode() == null) {
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "BARCODE_NOT_NULL".toUpperCase() }),
                                                                 -1)[0].getAttribute("Message"));
        }
        if (value == 0)
            return new FResult("error", "لطفا مقدار جریمه را وارد کنید.");

        ViewObject loanCashPenaltyVo = getLoanCashPenaltyVO1();
        LoanCashPenaltyVORowImpl currRec =
            (LoanCashPenaltyVORowImpl)loanCashPenaltyVo.getCurrentRow();
        if (currRec != null &&
            !new Number(0).equals(ParsiUtil.NVL(currRec.getValue())))
            return new FResult("error",
                               "برای کتاب جاری جریمه درج شده است .برای ویرایش آن می توانید از دگمه ویرایش جریمه استفاده کنید.");


        return new FResult("yn_popup", "آیا می خواهید  جریمه جدید ثبت شود؟");

    }

    public boolean insert_loanCashPenalty(Integer value, String description) {
        DBTransaction trans = getDBTransaction();

        CallableStatement statement = null;
        int rows = 0;
        ViewObject loanCashPenaltyVo = getLoanCashPenaltyVO1();

        LoanCashPenaltyVORowImpl currRec =
            (LoanCashPenaltyVORowImpl)loanCashPenaltyVo.getCurrentRow();
        currRec.getInitMemberVO().getAttribute("DebitSum");
        //int mytestParam=Integer.valueOf(currRec.getInitMemberVO().getAttribute("DebitSum").toString());
        Number loan_Artid =
            (Number)((LoanCashPenaltyVORowImpl)loanCashPenaltyVo.getCurrentRow()).getArtId2().getSequenceNumber();
        String plsql =
            " INSERT INTO loan_cash_penalty(VALUE,DAY_DATE,DESCRIPTION,LOAN_PENALTY_TYPE,LOAN_ART_ID,LABCOL,USER_NAME) " +
            "VALUES (?," + ParsiUtil.DateToNumber() + ",?," + 1 + "," +
            loan_Artid.intValue() + "," +
            Integer.parseInt(getSession().getUserData().get("labcol").toString()) +
            ",'" + (String)getSession().getUserData().get("username") + "')";
        statement = trans.createCallableStatement(plsql, 2);
        try {
            statement.setInt(1, value);
            statement.setString(2, description);
            statement.execute();
            //rows = statement.executeUpdate();
            //execute the update...
            Number debit =
                (Number)((LoanCashPenaltyVORowImpl)loanCashPenaltyVo.getCurrentRow()).getInitMemberVO().getAttribute("DebitSum");
            Number val = new Number(value.intValue());
            ((LoanCashPenaltyVORowImpl)loanCashPenaltyVo.getCurrentRow()).getInitMemberVO().setAttribute("DebitSum",
                                                                                                         val.add(debit));
            //when every thin is finished..
            getDBTransaction().commit();
            loanCashPenaltyVo.executeQuery();
        } catch (SQLException s) {
            System.err.println(s.getMessage() + this.getClass().getName());
            return false;
        } finally {
            try {
                if (statement != null)
                    statement.close();

            } catch (SQLException s) { /* ignore */
                return false;
            }

        }
        // return true;
        return true;
    }

    public FResult preEdit_loanCashPenalty(Integer value, String description) {

        PersonVORowImpl currPers =
            (PersonVORowImpl)getPersonVO1().getCurrentRow();
        if (currPers.getBarcode() == null) {
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "BARCODE_NOT_NULL".toUpperCase() }),
                                                                 -1)[0].getAttribute("Message"));
        }
        if (value == 0)
            return new FResult("error", "لطفا مقدار جریمه را وارد کنید.");


        LoanCashPenaltyVORowImpl currRec =
            (LoanCashPenaltyVORowImpl)getLoanCashPenaltyVO1().getCurrentRow();
        if (ParsiUtil.NVL(currRec.getValue()).intValue() == 0)
            return new FResult("error",
                               "برای کتاب جاری جریمه درج شده است ،برای ویرایش آن می توانید از کلیدویرایش جریمه استفاده کنید.");


        return new FResult("yn_popup", "آیا می خواهید تغییرات جریمه ثبت شود؟");


    }

    public boolean edit_loanCashPenalty(Integer value, String description) {
        DBTransaction trans = getDBTransaction();

        CallableStatement statement = null;
        int rows = 0;
        ViewObject loanCashPenaltyVo = getLoanCashPenaltyVO1();
        if(ParsiUtil.clearString(description)!=null){
        String plsql =
            " Update loan_cash_penalty SET VALUE = ?,DAY_DATE=" + ParsiUtil.DateToNumber() +
            ",DESCRIPTION=? ,USER_NAME='" +
            (String)getDBTransaction().getSession().getUserData().get("username") +
            "' where loan_art_id=" +
            ((LoanCashPenaltyVORowImpl)loanCashPenaltyVo.getCurrentRow()).getLoanArtId();
        System.out.println(plsql);
        statement = trans.createCallableStatement(plsql, 2);
        }
        else{
            String plsql =
                " Update loan_cash_penalty SET VALUE = ?,DAY_DATE=" + ParsiUtil.DateToNumber() +
                " ,USER_NAME='" +
                (String)getDBTransaction().getSession().getUserData().get("username") +
                "' where loan_art_id=" +
                ((LoanCashPenaltyVORowImpl)loanCashPenaltyVo.getCurrentRow()).getLoanArtId();
            System.out.println(plsql);
            statement = trans.createCallableStatement(plsql, 1);
          }
        
        try {
            statement.setInt(1, value);
          if(ParsiUtil.clearString(description)!=null)
            statement.setString(2, description);
            
            statement.execute();
            //rows = statement.executeUpdate();
            //execute the update...
            Number debit =
                (Number)((LoanCashPenaltyVORowImpl)loanCashPenaltyVo.getCurrentRow()).getInitMemberVO().getAttribute("DebitSum");
            Number val = new Number(value.intValue());
            Number delayPenalty =
                (Number)(getLoanCashPenaltyVO1().getCurrentRow().getAttribute("Value"));
            Number finalDebitSum =
                ParsiUtil.NVL(debit).plus(val.subtract(delayPenalty));
            ((LoanCashPenaltyVORowImpl)loanCashPenaltyVo.getCurrentRow()).getInitMemberVO().setAttribute("DebitSum",
                                                                                                         finalDebitSum);
            //when every thing is finished..
            getDBTransaction().commit();
            loanCashPenaltyVo.executeQuery();
        } catch (SQLException s) {
            System.err.println(s.getMessage() + this.getClass().getName());
            return false;
        } finally {
            try {
                if (statement != null)
                    statement.close();

            } catch (SQLException s) { /* ignore */
                return false;
            }

        }
        // return true;
        return true;
    }

    public FResult preInsert_publicPenalty(int value, String description) {

        PersonVORowImpl currPers =
            (PersonVORowImpl)getPersonVO1().getCurrentRow();
        if (currPers.getBarcode() == null) {
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "BARCODE_NOT_NULL".toUpperCase() }),
                                                                 -1)[0].getAttribute("Message"));
        }
        if (ParsiUtil.NVL(new Number(value)) == null)
            return new FResult("error", "لطفا مقدار جریمه را وارد نمایید.");

        return new FResult("yn_popup", "آیا می خواهید  جریمه جدید ثبت شود؟");
    }


    public void insert_publicPenalty(int value, String description) {
        //ADF insert..
        ViewObject vo = getPublicCashPenaltyVO();
        Row newRec = vo.createRow();
        vo.insertRow(newRec);

        Number mem_Artid =
            ((Number)((PublicCashPenaltyRowImpl)vo.getCurrentRow()).getInitMemberVO().getAttribute("ArtId"));
        newRec.setAttribute("DayDate", ParsiUtil.DateToNumber());
        newRec.setAttribute("Description", description);
        newRec.setAttribute("Labcol",
                            Integer.parseInt(getDBTransaction().getSession().getUserData().get("labcol").toString()));
        newRec.setAttribute("MemArtId", mem_Artid);
        newRec.setAttribute("UserName",
                            getDBTransaction().getSession().getUserData().get("username"));
        newRec.setAttribute("Value", value);

        Number val =
            (Number)((PublicCashPenaltyRowImpl)vo.getCurrentRow()).getInitMemberVO().getAttribute("DebitSum");
        ((PublicCashPenaltyRowImpl)vo.getCurrentRow()).getInitMemberVO().setAttribute("DebitSum",
                                                                                      ParsiUtil.NVL(val).plus(value));

        getTransaction().commit();
        JSFUtils.addFacesInfoMessage("جریمه جدید ثبت گردید.");
    }

    public FResult preEdit_publicPenalty(int value, String description) {

        PersonVORowImpl currPers =
            (PersonVORowImpl)getPersonVO1().getCurrentRow();
        if (currPers.getBarcode() == null) {
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "BARCODE_NOT_NULL".toUpperCase() }),
                                                                 -1)[0].getAttribute("Message"));
        }

        if (ParsiUtil.NVL(new Number(value)) == null)
            return new FResult("error", "لطفا مقدار جریمه را وارد نمایید.");

        //        ViewObject vo = getPublicCashPenaltyVO();
        //        PublicCashPenaltyRowImpl curRec =
        //            (PublicCashPenaltyRowImpl)vo.getCurrentRow();
        //
        //
        //        if (curRec.getValue().equals(value) ||
        //            (ParsiUtil.clearString(description) != null &&
        //             description.equalsIgnoreCase(curRec.getDescription())))
        //
        //            return new FResult("error", "تغییراتی برای ثبت وجود ندارد");


        return new FResult("yn_popup", "آیا می خواهید تغییرات جریمه ثبت شود؟");
    }


    public void edit_publicPenalty(int value, String description) {
        ViewObject vo = getPublicCashPenaltyVO();
        Row curRec = vo.getCurrentRow();

        Number val =
            (Number)((PublicCashPenaltyRowImpl)vo.getCurrentRow()).getInitMemberVO().getAttribute("DebitSum");
        ((PublicCashPenaltyRowImpl)vo.getCurrentRow()).getInitMemberVO().setAttribute("DebitSum",
                                                                                      ParsiUtil.NVL(val).plus(value).subtract((Number)(curRec.getAttribute("Value"))));


        curRec.setAttribute("DayDate", ParsiUtil.DateToNumber());
        if( ParsiUtil.clearString( description)!=null){
        curRec.setAttribute("Description", description);
        }
        curRec.setAttribute("UserName",
                            (String)getDBTransaction().getSession().getUserData().get("username"));
        curRec.setAttribute("Value", value);


        getTransaction().commit();
        JSFUtils.addFacesInfoMessage("تغییرات جریمه ثبت گردید.");


    }


    public FResult penaltyPayment_preInsert(Number payValue) {
        PersonVORowImpl currPers =
            (PersonVORowImpl)getPersonVO1().getCurrentRow();
        if (currPers.getBarcode() == null) {
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "BARCODE_NOT_NULL".toUpperCase() }),
                                                                 -1)[0].getAttribute("Message"));
        }
        DummyVOImpl dummyVo=getDummyVO1();
        dummyVo.setQuery("SELECT art_id  FROM MEMBER WHERE  art_id=" +
                         ((InitMemberVORowImpl)currPers.getInitMemberCurrLibVO1()).getArtId());
        dummyVo.executeQuery();
        
        if(dummyVo.getRowCount()==0)
            return new FResult("error",
                               "عضو هنوز در این کتابخانه کتاب به امانت نبرده است .بنابراین نمی توانید پرداخت را درج نمایید.");
        
        if (payValue == null)
            return new FResult("error", "لطفا مقدار پرداخت را وارد نمایید.");
        if(payValue.longValue()<0)
            return new FResult("error","مقدار جریمه نمیتواند منفی باشد.");
        
        return new FResult("yn_popup", "آیا می خواهید  پرداخت جدید ثبت شود؟");

    }


    public FResult penaltyPayment_insert(Number payValue, String payDesc) {
        ViewObject vo = getPenaltyPaymentVO1();
        PenaltyPaymentVORowImpl newRec =
            (PenaltyPaymentVORowImpl)vo.createRow();
        vo.insertRow(newRec);

        Number mem_Artid =
          ((Number)((PenaltyPaymentVORowImpl)vo.getCurrentRow()).getInitMemberVO().getAttribute("ArtId"));


        newRec.setDayDate(ParsiUtil.DateToNumber());
        newRec.setDescription(payDesc);
        newRec.setLabcol((Number)getDBTransaction().getSession().getUserData().get("labcolno"));
        newRec.setMemArtId(mem_Artid);
        newRec.setUserName((String)getDBTransaction().getSession().getUserData().get("username"));
        newRec.setValue(new Number(payValue));

        Number val =
            (Number)((PenaltyPaymentVORowImpl)vo.getCurrentRow()).getInitMemberVO().getAttribute("DebitSum");
        ((PenaltyPaymentVORowImpl)vo.getCurrentRow()).getInitMemberVO().setAttribute("DebitSum",
                                                                                     ParsiUtil.NVL(val).minus(payValue));
        getTransaction().commit();
        return new FResult("info", "پرداخت جدید ثبت گردید.");
    }

    public FResult penaltyPayment_preEdit(Number penaltyValue) {

        PersonVORowImpl currPers =
            (PersonVORowImpl)getPersonVO1().getCurrentRow();
        if (currPers.getBarcode() == null) {
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "BARCODE_NOT_NULL".toUpperCase() }),
                                                                 -1)[0].getAttribute("Message"));
        }

        if (penaltyValue == null)
            return new FResult("error", "لطفا مقدار پرداخت را وارد نمایید.");
      if(penaltyValue.longValue()<0)
          return new FResult("error","مقدار جریمه نمیتواند منفی باشد.");

        return new FResult("yn_popup",
                           "آیا می خواهید تغییرات پرداخت ثبت شود؟");

    }

    public FResult penaltyPayment_edit(Number payValue, String payDesc) {

        ViewObject vo = getPenaltyPaymentVO1();
        PenaltyPaymentVORowImpl curRec =
            (PenaltyPaymentVORowImpl)getPenaltyPaymentVO1().getCurrentRow();
        //Number oldValue=curRec.getValue();

        Number val =
            (Number)((PenaltyPaymentVORowImpl)vo.getCurrentRow()).getInitMemberVO().getAttribute("DebitSum");
        ((PenaltyPaymentVORowImpl)vo.getCurrentRow()).getInitMemberVO().setAttribute("DebitSum",
                                                                                     ParsiUtil.NVL(val).minus((new Number(curRec.getValue().plus(payValue)))));

        curRec.setDayDate(ParsiUtil.DateToNumber());
        if( ParsiUtil.clearString( payDesc)!=null){
        curRec.setDescription(payDesc);
        }
        curRec.setUserName((String)getDBTransaction().getSession().getUserData().get("username"));
        curRec.setValue(new Number(payValue));

        System.out.println("art id ===" +
                           curRec.getArtId().getSequenceNumber());
        getTransaction().commit();
        return new FResult("info", "تغییرات ثبت گردید.");
    }


    public FResult preInsert_publicNonCashPenalty(String payDesc,
                                                  String penaltydescription) {

        PersonVORowImpl currPers =
            (PersonVORowImpl)getPersonVO1().getCurrentRow();
        if (currPers.getBarcode() == null) {
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "BARCODE_NOT_NULL".toUpperCase() }),
                                                                 -1)[0].getAttribute("Message"));
        }
        if ("".equalsIgnoreCase(ParsiUtil.clearString(penaltydescription)))
            return new FResult("error", "لطفا مقدار پرداخت را وارد نمایید.");


        return new FResult("yn_popup", "آیا می خواهید  پرداخت جدید ثبت شود؟");

    }


    public void insert_publicNonCashPenalty(String payDesc,
                                            String description) {

        ViewObject vo = getPublicNonCashPenaltyVO1();
        Row newRec = vo.createRow();
        vo.insertRow(newRec);

        Number mem_Artid =
           ((Number)((PublicNonCashPenaltyVORowImpl)vo.getCurrentRow()).getInitMemberVO().getAttribute("ArtId"));

        newRec.setAttribute("PenaltyDate", ParsiUtil.DateToNumber());
        newRec.setAttribute("PenaltyDesc", description);
        newRec.setAttribute("Labcol",
                            Integer.parseInt(getDBTransaction().getSession().getUserData().get("labcol").toString()));
        newRec.setAttribute("MemArtId", mem_Artid);
        newRec.setAttribute("RegisterUser",
                            (String)getDBTransaction().getSession().getUserData().get("username"));
        newRec.setAttribute("ActionDesc", payDesc);
        newRec.setAttribute("Active", 1);
        ((PublicNonCashPenaltyVORowImpl)vo.getCurrentRow()).getInitMemberVO().setAttribute("DebitNonCash",
                                                                                           1);

        getTransaction().commit();
        JSFUtils.addFacesInfoMessage("جریمه جدید ثبت گردید.");
    }

    public FResult preEdit_publicNonCashPenalty(String payDesc,
                                                String penaltyDescription) {

        PersonVORowImpl currPers =
            (PersonVORowImpl)getPersonVO1().getCurrentRow();
        if (currPers.getBarcode() == null) {
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "BARCODE_NOT_NULL".toUpperCase() }),
                                                                 -1)[0].getAttribute("Message"));
        }

        if (ParsiUtil.clearString(penaltyDescription) == null)
            return new FResult("error", "لطفا مقدار جریمه را وارد نمایید.");

        ViewObject vo = getPublicNonCashPenaltyVO1();
        PublicNonCashPenaltyVORowImpl curRec =
            (PublicNonCashPenaltyVORowImpl)vo.getCurrentRow();

        return new FResult("yn_popup", "آیا می خواهید تغییرات جریمه ثبت شود؟");

    }

    public void edit_publicNonCashPenalty(String payDesc,
                                          String penaltyDescription) {

        ViewObject vo = getPublicNonCashPenaltyVO1();
        Row curRec = vo.getCurrentRow();
        if (ParsiUtil.clearString(penaltyDescription )!= null) {
            curRec.setAttribute("PenaltyDate", ParsiUtil.DateToNumber());
            curRec.setAttribute("PenaltyDesc", penaltyDescription);
            curRec.setAttribute("RegisterUser",
                                (String)getDBTransaction().getSession().getUserData().get("username"));
        }
        if (ParsiUtil.clearString( payDesc) != null) {
            curRec.setAttribute("ActionDesc", payDesc);
        }
        getTransaction().commit();

        JSFUtils.addFacesInfoMessage("تغییرات ثبت گردید.");


    }

    public FResult introductionLetter_initPerson() {

        Boolean rasmi_mem_first_loan = false;
        PersonVOImpl personVO = (PersonVOImpl)getPersonVO1();
        PersonVORowImpl currPerson = (PersonVORowImpl)personVO.getCurrentRow();

        if (currPerson == null ||
            ParsiUtil.clearString(currPerson.getBarcode()) == null)
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "no_data".toUpperCase() }),
                                                                 -1)[0].getAttribute("Message"));

        
        InitMemberVORowImpl currInitMem =
            (InitMemberVORowImpl)currPerson.getInitMemberCurrLibVO1();

        if (new Number(2).equals(currPerson.getPersStatus()))
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "no_loan_no_active".toUpperCase() }),
                                                                 -1)[0].getAttribute("Message"));

        if (new Number(2).equals(currPerson.getPersType()) ||
            ((new Number(1).equals(currPerson.getPersType()) &&
              (currInitMem == null ? true :
               !(new Number(1).equals(currInitMem.getMemshipCategory()) ||
                 new Number(2).equals(currInitMem.getMemshipCategory()))))))
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "intro_letter".toUpperCase() }),
                                                                 -1)[0].getAttribute("Message"));
        DatabaseProcedure is_mem_of_currLib =
            DatabaseProcedure.define("function parsi_pkg_library.IS_MEM_OF_LIB2(P_ART_ID NUMBER,CUR_LIB_ART_ID NUMBER)RETURN NUMBER;");
        Number is_mem_of_lib =
            ParsiUtil.convert_dec_to_number((BigDecimal)is_mem_of_currLib.call(getDBTransaction(),
                                                                               currPerson.getArtId(),
                                                                               getSession().getUserData().get("libartid")).getReturnValue());

        if (new Number(1).equals(currPerson.getPersType())) //Rasmi
        {


            if (new Number(1).equals(is_mem_of_lib)) {
                if (new Number(3).equals(currInitMem.getMemshipStatus()))
                    JSFUtils.addFacesInfoMessage((String)getMessageVO1().findByKey(new Key(new Object[] { "incomplete_id".toUpperCase() }),
                                                                                   -1)[0].getAttribute("Message"));
                else if (!(new Number(1).equals(currInitMem.getMemshipStatus()) ||
                           new Number(3).equals(currInitMem.getMemshipStatus())))
                    return new FResult("error",
                                       "به اعضای دارای وضعیت " + currInitMem.getMemshipStatusText() +
                                       " معرفینامه داده نمی شود");

                //                :PERSON.INIT_MEMBER_ART_ID:=parsi_pkg_library.INIT_MEM_ART_ID(:PERSON.ART_ID,:person.LIB_ART_ID);
                //                              IF parsi_pkg_library.HAS_MEM_REC(:PERSON.BARCODE,:person.LIB_ART_ID)=FALSE THEN
                //                                    PKG_VARIABLE.RASMI_MEM_FIRST_LOAN:=TRUE;
                //                              END IF;

                // if zir piade sazie code balast ke comment shode ast.
                if (currInitMem.getMemberVo() == null)
                    pakage_variables.put( "rasmi_mem_first_loan",  true);
            }

            else {

                //                  function calculates memmshipStatus which i used currInitMem.getMemshipStatus()
                //                  //	MEMSHIP_ST:=parsi_pkg_library.MEM_STATUS(:PERSON.BARCODE,:person.lib_art_id);
                //                  DatabaseProcedure mem_status1 =
                //                      DatabaseProcedure.define("FUNCTION parsi_pkg_library.MEM_STATUS(P_BARCODE VARCHAR2,T_LIB_ART_ID NUMBER) RETURN NUMBER;");
                //                  Number memStatus_result =
                //                      ParsiUtil.convert_dec_to_number((BigDecimal)mem_status1.call(getDBTransaction(),
                //                                                                                  currPerson.getBarcode(), getSession().getUserData().get("libartid")).getReturnValue());

                if (currInitMem.getMemshipStatus() != null)
                    return new FResult("error",
                                       "به اعضای دارای وضعیت " + currInitMem.getMemshipStatusText() +
                                       " معرفینامه داده نمی شود");
                else {
                    //TODO: code haye zir bedoone estefade boodand va comment shodeand.
                    //                    DatabaseProcedure get_lib_artId= DatabaseProcedure.define("FUNCTION GET_LIB_ART_ID(P_ART_ID NUMBER)RETURN NUMBER;");
                    //                     Number persLibArtId=
                    //                     (Number)get_lib_artId.call(getDBTransaction(),currPerson.getArtId()).getReturnValue();
                    //
                    //                    DatabaseProcedure get_father_libId= DatabaseProcedure.define(" FUNCTION GET_LIB_FATHER_ART_ID(T_ART_ID NUMBER)RETURN NUMBER;");
                    //                     Number persLibFatherId=
                    //                     (Number)get_father_libId.call(getDBTransaction(),persLibArtId).getReturnValue();
                    //

                    DatabaseProcedure is_mem_of_Lib2 =
                        DatabaseProcedure.define(" FUNCTION parsi_pkg_library.IS_MEM_OF_LIB2(P_ART_ID NUMBER,CUR_LIB_ART_ID NUMBER)RETURN NUMBER;");
                    Number is_mem_of_Lib2_result =
                        ParsiUtil.convert_dec_to_number((BigDecimal)is_mem_of_Lib2.call(getDBTransaction(),
                                                                                        currPerson.getArtId(),
                                                                                        1).getReturnValue());
                    if (new Number(0).equals(is_mem_of_Lib2_result))
                        return new FResult("error",
                                           (String)getMessageVO1().findByKey(new Key(new Object[] { "no_mem_cent_lib".toUpperCase() }),
                                                                             -1)[0].getAttribute("Message"));
                    else {
                        DatabaseProcedure mem_status =
                            DatabaseProcedure.define("FUNCTION parsi_pkg_library.MEM_STATUS(P_BARCODE VARCHAR2,T_LIB_ART_ID NUMBER) RETURN NUMBER;");
                        Number memStatus =
                            ParsiUtil.convert_dec_to_number((BigDecimal)mem_status.call(getDBTransaction(),
                                                                                        currPerson.getBarcode(),
                                                                                        1).getReturnValue());

                        if (!(new Number(1).equals(memStatus) ||
                              new Number(3).equals(memStatus)))

                            return new FResult("error",
                                               (String)getMessageVO1().findByKey(new Key(new Object[] { "illegal_mem_in_cent_lib".toUpperCase() }),
                                                                                 -1)[0].getAttribute("Message"));
                        else
                            return new FResult("error",
                                               (String)getMessageVO1().findByKey(new Key(new Object[] { "no_mem_lib".toUpperCase() }),
                                                                                 -1)[0].getAttribute("Message"));
                    }


                }

            }

        } else //Gheyre Rasmi
        {
            if (new Number(1).equals(is_mem_of_lib)) {
                if (new Number(3).equals(currInitMem.getMemshipStatus()))
                    JSFUtils.addFacesInfoMessage((String)getMessageVO1().findByKey(new Key(new Object[] { "incomplete_id".toUpperCase() }),
                                                                                   -1)[0].getAttribute("Message"));
                else if (!(new Number(1).equals(currInitMem.getMemshipStatus()) ||
                           new Number(3).equals(currInitMem.getMemshipStatus())))
                    return new FResult("error",
                                       "به اعضای دارای وضعیت " + currInitMem.getMemshipStatusText() +
                                       " معرفینامه داده نمی شود");

            } else
                return new FResult("error",
                                   (String)getMessageVO1().findByKey(new Key(new Object[] { "no_mem_lib".toUpperCase() }),
                                                                     -1)[0].getAttribute("Message"));
        }
        if (ParsiUtil.NVL(currInitMem.getDebitSum()).intValue() > 0)
            JSFUtils.addFacesInfoMessage((String)getMessageVO1().findByKey(new Key(new Object[] { "mem_cash_penalty".toUpperCase() }),
                                                                           -1)[0].getAttribute("Message"));
        if (ParsiUtil.NVL(currInitMem.getDebitNonCash(),
                          new Number(2)).intValue() != 2)


            JSFUtils.addFacesInfoMessage((String)getMessageVO1().findByKey(new Key(new Object[] { "mem_non_cash_penalty".toUpperCase() }),
                                                                           -1)[0].getAttribute("Message"));
        if (new Number(2).equals(currPerson.getPersType()) &&
            ParsiUtil.NVL(ParsiUtil.stringDateToNumber(currInitMem.getEndDate())).longValue() <
            ParsiUtil.DateToNumber().longValue())
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "mem_expied".toUpperCase() }),
                                                                 -1)[0].getAttribute("Message"));


        //TODO: khate zir piade sazi nashod zira CUR_LIB_LOAN_NUM hich ja estefade nemishod.
        /*:PERSON.CUR_LIB_LOAN_NUM:=parsi_pkg_library.LIB_LOAN_NUM(:PERSON.barcode,:PERSON.LIB_ART_ID)
																+parsi_pkg_library.LIB_STUDY_LOAN_NUM(:PERSON.barcode,:PERSON.LIB_ART_ID);*/
        DatabaseProcedure item_text =
            DatabaseProcedure.define("FUNCTION parsi_pkg_catalog.ITEM_TEXT(CAT_NAME VARCHAR2,ITEM_VAL NUMBER,labcol_no number) RETURN VARCHAR2;");
        String item_text_result =
            (String)item_text.call(getDBTransaction(), "CHECK_MEM_PASS_LIB_CLASS",
                                   1,
                                   (Number)getDBTransaction().getSession().getUserData().get("labcolno")).getReturnValue();

        DatabaseProcedure is_first_loan2 =
            DatabaseProcedure.define("FUNCTION parsi_pkg_library.IS_FIRST_LOAN2(P_BARCODE VARCHAR2,CUR_LIB_ART_ID NUMBER, labcol1 number) RETURN Number;");
        Number is_first_loan2_result =
            ParsiUtil.convert_dec_to_number((BigDecimal)is_first_loan2.call(getDBTransaction(),
                                                                            currPerson.getBarcode(),
                                                                            (Number)getDBTransaction().getSession().getUserData().get("libartid"),
                                                                            (Number)getDBTransaction().getSession().getUserData().get("labcolno")).getReturnValue());


        if ("فعال".equalsIgnoreCase(item_text_result) &&
            new Number(1).equals(is_first_loan2_result))
            return new FResult("yn_popup",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "MEM_PASS_COURSE".toUpperCase() }),
                                                                 -1)[0].getAttribute("Message"));


        return null;
    }


    public FResult insert_IntroductionLetter(String goalLib,
                                             String description) {

        if (goalLib == null) {
            return new FResult("error",
                               "لطفا نام کتابخانه مقصد را وارد نمایید");

        }
        ViewObject vo = getIntroductionLetterVO();
        Row newRec = vo.createRow();
        vo.insertRow(newRec);

        Number mem_Artid =
            (Number)((IntroductionLetterVORowImpl)vo.getCurrentRow()).getInitMemberVO().getAttribute("ArtId");


        newRec.setAttribute("IntroduceDate", ParsiUtil.DateToNumber());
        newRec.setAttribute("GoalLibrary", goalLib);
        newRec.setAttribute("IssuanceUser",
                            (String)getDBTransaction().getSession().getUserData().get("username"));
        newRec.setAttribute("Description", description);
        newRec.setAttribute("Labcol",
                            Integer.parseInt(getDBTransaction().getSession().getUserData().get("labcol").toString()));
        newRec.setAttribute("MemArtId", mem_Artid);

        Number val =
            (Number)((IntroductionLetterVORowImpl)vo.getCurrentRow()).getInitMemberVO().getAttribute("IntroductionLetterCount");
        ((IntroductionLetterVORowImpl)vo.getCurrentRow()).getInitMemberVO().setAttribute("IntroductionLetterCount",
                                                                                         val.add(1));
        getTransaction().commit();
       
        return new FResult("return",
                           ((IntroductionLetterVORowImpl)newRec).getArtId().getSequenceNumber());
    }

  public FResult preClearing_IntroductionLetter() {
        
        IntroductionLetterVORowImpl Rec =
            (IntroductionLetterVORowImpl)getIntroductionLetterVO().getCurrentRow();
        if (Rec == null || Rec.getCancelDate() == null ||
            Rec.getCancellationUser() == null) {
            return new FResult("yn_popup",
                               "آیا می خواهید برگه معرفی نامه به " +
                               Rec.getGoalLibrary() + " تسویه شده اعلام شود؟");
                
            
        } else
          return new FResult("error",
                             (String)getMessageVO1().findByKey(new Key(new Object[] { "intro_letter_cleared".toUpperCase() }),
                                                               -1)[0].getAttribute("Message"));
            
     
      }


    public FResult clearing_IntroductionLetter() {

        ViewObject vo = getIntroductionLetterVO();
        Row Rec = vo.getCurrentRow();
        Rec.setAttribute("CancelDate", ParsiUtil.DateToNumber());
        Rec.setAttribute("CancellationUser",
                         (String)getDBTransaction().getSession().getUserData().get("username"));

        Number val =
            (Number)((IntroductionLetterVORowImpl)vo.getCurrentRow()).getInitMemberVO().getAttribute("IntroductionLetterCount");
        ((IntroductionLetterVORowImpl)vo.getCurrentRow()).getInitMemberVO().setAttribute("IntroductionLetterCount",
                                                                                         val.subtract(1));
        Rec.setAttribute("Status", "تسویه");
        getTransaction().commit();

        return  new FResult("info",
                             (String)getMessageVO1().findByKey(new Key(new Object[] { "save_completed".toUpperCase() }),
                                                               -1)[0].getAttribute("Message"));
            
    }

    public FResult save_MemBarcodeChange(String barcode) {

        PersonVOImpl persVo = (PersonVOImpl)getPersonVO1();
        PersonVORowImpl currPerson = (PersonVORowImpl)persVo.getCurrentRow();

        if (currPerson != null && barcode != null) {
            barcode = barcode.trim();
            AllPersonVOImpl allPersVo = (AllPersonVOImpl)getAllPersonRoVO1();
            allPersVo.setbarcode_no(barcode);
            allPersVo.executeQuery();

            int cnt = allPersVo.getRowCount();

            if (cnt > 0) {
                return new FResult("error",
                                   (String)getMessageVO1().findByKey(new Key(new Object[] { "dup_barcode".toUpperCase() }),
                                                                     -1)[0].getAttribute("Message"));

            }
            currPerson.setBarcode(barcode);
            Number persArtID =currPerson.getArtId();

            RowIterator vo = currPerson.getMemberBarcodeHistory();
            Row newRec = vo.createRow();
            vo.insertRow(newRec);

            newRec.setAttribute("DayDate", ParsiUtil.DateToNumber());
            newRec.setAttribute("PersArtId", persArtID);

            newRec.setAttribute("UserName",
                                (String)getDBTransaction().getSession().getUserData().get("username"));
            newRec.setAttribute("Barcode", barcode);


            getTransaction().commit();
        }
        return null;
    }

    public FResult cid_reserve_reserveBtn_newEmail(String email) {

        if (ParsiUtil.clearString(email) == null) {

            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "email_not_null".toUpperCase() }),
                                                                 -1)[0].getAttribute("Message"));
        }

        PersonVORowImpl currPers =
            (PersonVORowImpl)getPersonVO1().getCurrentRow();
       // RowIterator emailvo = currPers.getEmailVO();
EmailVOImpl emailvo = (EmailVOImpl)getEmailVO1();

        RowIterator searchResult =
            emailvo.findByAltKey("EmailAlternateKey", new Key(new Object[] { email.trim() }),
                                 -1, false);

        if (searchResult.hasNext()) {

            return new FResult("error",
                               "این آدرس پست الکترونیکی قبلا وارد شده است ،در صورت تمایل می توانید آنرا فعال کنید. ");
        }


        Row newRec = emailvo.createRow();
        emailvo.insertRow(newRec);


        newRec.setAttribute("Email1", email.trim());
        Number order =
            ParsiUtil.NVL(currPers.getMaxEmailOrderNO()).add(new Number(1));
        newRec.setAttribute("OrderNo", order);
        newRec.setAttribute("Active", new Number(1));
        currPers.setEmail(email.trim());
        currPers.setMaxEmailOrderNO(order);
        getDBTransaction().commit();

        return null;
    }

    public FResult memStatusChange_afterSearch() {
        PersonVORowImpl currPers =
            (PersonVORowImpl)getPersonVO1().getCurrentRow();
        if (currPers.getInitMemberCurrLibVO1().getAttribute("ArtId") == null)
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "no_mem_lib".toUpperCase() }),
                                                                 -1)[0].getAttribute("Message"));
        if (new Number(2).equals(currPers.getPersStatus()) ||
            new Number(2).equals(currPers.getInitMemberCurrLibVO1().getAttribute("MemshipStatus")))
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "no_active_no_change".toUpperCase() }),
                                                                 -1)[0].getAttribute("Message"));
        return null;
    }

    public FResult preSave_MemStatusChange(Number newStatus) {


        PersonVORowImpl currPers =
            (PersonVORowImpl)getPersonVO1().getCurrentRow();
        if (currPers.getBarcode() == null) {
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "BARCODE_NOT_NULL".toUpperCase() }),
                                                                 -1)[0].getAttribute("Message"));
        }
        if (!(newStatus.equals(new Number(1)) ||
              newStatus.equals(new Number(3)) ||
              newStatus.equals(new Number(4)) ||
              newStatus.equals(new Number(5)))) {
            return new FResult("error",
                               (String)getMessageVO1().findByKey(new Key(new Object[] { "ILL_STATUS_CHANGE".toUpperCase() }),
                                                                 -1)[0].getAttribute("Message"));

        }
        if (currPers.getInitMemberCurrLibVO1().getAttribute("MemshipStatus").equals(newStatus)) {

            return new FResult("error", "وضعیت فعلی با وضعیت جدید یکسان است.");
        }


        return new FResult("yn_popup",
                           (String)getMessageVO1().findByKey(new Key(new Object[] { "status_changing".toUpperCase() }),
                                                             -1)[0].getAttribute("Message"));
    }

    public FResult save_MemStatusChange(String reason, Number newStatus) {
        //        InitMemberVOImpl initMemVo =
        //            (InitMemberVOImpl)getInitMemberCurrLibVO();
        InitMemberVORowImpl currInitMem =
            (InitMemberVORowImpl)getInitMemberCurrLibVO().getCurrentRow();
        ViewObject vo = getMemberStatusHistoryVO1();
        Row newRec = vo.createRow();
        vo.insertRow(newRec);
        //((initMemVo.getCurrentRow().getAttribute("ArtId")));
        Number mem_Artid = currInitMem.getArtId();
        newRec.setAttribute("DayDate", ParsiUtil.DateToNumber());
        newRec.setAttribute("UserName",
                            (String)getDBTransaction().getSession().getUserData().get("username"));
        newRec.setAttribute("Reason", reason);
        newRec.setAttribute("Status", newStatus);
        newRec.setAttribute("LibArtId",
                            (Number)(getDBTransaction().getSession().getUserData().get("libartid")));
        newRec.setAttribute("IntmemArtId", mem_Artid);

        // initMemVo.getCurrentRow().setAttribute("MemshipStatus", newStatus);
        currInitMem.setMemshipStatus(newStatus);
        getTransaction().commit();
        return new FResult("info",
                           (String)getMessageVO1().findByKey(new Key(new Object[] { "STATUS_CHANGE_SUC".toUpperCase() }),
                                                             -1)[0].getAttribute("Message"));

    }

   public FResult searchBarcode(String barcode) {
     barcode=ParsiUtil.clearString(barcode);
     if(barcode==null) {
       return new FResult("error","بارکد نمی تواند خالی باشد.");
     }
        PP_BookBarcodeSearchResultVOImpl pp_bkVo =
            getPP_BookBarcodeSearchResultVO1();
        PP_PersonBarcodeSearchResultVOImpl pp_perVo =
            getPP_PersonBarcodeSearchResultVO1();
     pp_bkVo.executeEmptyRowSet();
     pp_perVo.executeEmptyRowSet();
     PersonVOImpl persVo = (PersonVOImpl)getPersonVO1();
     
        MemberBarcodeHistoryVOImpl memBrcdHistVo =
            getMemberBarcodeHistoryVO1();
     PhysicalBookVOImpl PhbookVo=getPhysicalBookVO3();
        BookBarcodeHistoryVOImpl bkBrcdHistVo =
            (BookBarcodeHistoryVOImpl)getBookBarcodeHistoryVO1();
     
     
//     persVo.setparam_barcode_equal(barcode);
//       persVo.setApplyViewCriteriaName("search_barcode_equalVC");
        Variable v =
            persVo.getViewCriteria("search_barcode_equalVC").getAllBindVariables().iterator().next();
        RowIterator persRI =
            persVo.findByViewCriteriaWithBindVars(persVo.getViewCriteria("search_barcode_equalVC"),
                                                  -1,
                                                  persVo.QUERY_MODE_SCAN_DATABASE_TABLES,
                                                  new Variable[] { v },
                    new Object[]{barcode});

        if(persRI.hasNext()) {
       PersonVORowImpl currPers=null;
         while(persRI.hasNext()) {
             currPers = (PersonVORowImpl)persRI.next();
                if (pp_perVo.findByKey(new Key(new Object[] { currPers.getArtId() }),
                                       -1).length == 0) {
                    PP_PersonBarcodeSearchResultVORowImpl newPer =
                        (PP_PersonBarcodeSearchResultVORowImpl)pp_perVo.createRow();
           pp_perVo.insertRow(newPer);
             newPer.setArtId(currPers.getArtId());
             newPer.setBarcode(currPers.getBarcode());
             newPer.setBarcodeType("بارکد جاری عضو");
             newPer.setFname(currPers.getFname());
             newPer.setLname(currPers.getLname());
             }
         }
         
       }else {
//         memBrcdHistVo.setparamBarcodeEqual(barcode);
//         memBrcdHistVo.setApplyViewCriteriaName("SearchBarcodeEqualVC");
            v =
  memBrcdHistVo.getViewCriteria("SearchBarcodeEqualVC").getAllBindVariables().iterator().next();
            RowIterator memBrcdHistRI =
                memBrcdHistVo.findByViewCriteriaWithBindVars(memBrcdHistVo.getViewCriteria("SearchBarcodeEqualVC"),
                                                             -1,
                                                             memBrcdHistVo.QUERY_MODE_SCAN_DATABASE_TABLES,
                                                             new Variable[] { v },
                    new Object[]{barcode});
            PersonVORowImpl currPers=null;
           while(memBrcdHistRI.hasNext()) {
                currPers =
                        (PersonVORowImpl)((MemberBarcodeHistoryVORowImpl)memBrcdHistRI.next()).getPersonVO();
                if (pp_perVo.findByKey(new Key(new Object[] { currPers.getArtId() }),
                                       -1).length == 0) {
                    PP_PersonBarcodeSearchResultVORowImpl newPer =
                        (PP_PersonBarcodeSearchResultVORowImpl)pp_perVo.createRow();
             pp_perVo.insertRow(newPer);
               newPer.setArtId(currPers.getArtId());
               newPer.setBarcode(currPers.getBarcode());
               newPer.setBarcodeType("بارکد بایگانی عضو");
               newPer.setFname(currPers.getFname());
               newPer.setLname(currPers.getLname());
             }
           }
       }
//        PhbookVo.setparamBarcodeEqual(barcode);
//        PhbookVo.setApplyViewCriteriaName("SearchBarcodeEqualVC");
        v =
  PhbookVo.getViewCriteria("SearchBarcodeEqualVC").getAllBindVariables().iterator().next();
        RowIterator PhbookRI =
            PhbookVo.findByViewCriteriaWithBindVars(PhbookVo.getViewCriteria("SearchBarcodeEqualVC"),
                                                    -1,
                                                    PhbookVo.QUERY_MODE_SCAN_DATABASE_TABLES,
                                                    new Variable[] { v },
                    new Object[]{barcode});
        if(PhbookRI.hasNext()) {
        PhysicalBookVORowImpl currPhbook=null;
        VirtualBookVORowImpl currVbook=null;
          while(PhbookRI.hasNext()) {
            currPhbook = (PhysicalBookVORowImpl)PhbookRI.next();
                if (pp_bkVo.findByKey(new Key(new Object[] { currPhbook.getArtId(),
                                                             currPhbook.getLabcol() }),
                                      -1).length == 0) {
                    currVbook =
                            (VirtualBookVORowImpl)currPhbook.getVirtualBookVO();
                    PP_BookBarcodeSearchResultVORowImpl newBk =
                        (PP_BookBarcodeSearchResultVORowImpl)pp_bkVo.createRow();
              pp_bkVo.insertRow(newBk);
              newBk.setArtId(currPhbook.getArtId());
              newBk.setBarcodeType("بارکد فعلی کتاب");
              newBk.setCallNo(currVbook.getCallNo());
              newBk.setLabcol(currPhbook.getLabcol());
              newBk.setTitle(currVbook.getTitle());
            newBk.setBarcode(currPhbook.getBarcode());
            }
          }
        }else {
//          bkBrcdHistVo.setparamBarcodeEqual(barcode);
//            bkBrcdHistVo.setApplyViewCriteriaName("SearchBarcodeEqualVC");
            v =
  bkBrcdHistVo.getViewCriteria("SearchBarcodeEqualVC").getAllBindVariables().iterator().next();
            RowIterator bkBrcdHistRI =
                bkBrcdHistVo.findByViewCriteriaWithBindVars(bkBrcdHistVo.getViewCriteria("SearchBarcodeEqualVC"),
                                                            -1,
                                                            bkBrcdHistVo.QUERY_MODE_SCAN_DATABASE_TABLES,
                                                            new Variable[] { v },
                    new Object[]{barcode});
//            RowIterator bkBrcdHistRI =
//                bkBrcdHistVo.findByAltKey("BarcodeAltKey", new Key(new Object[]{barcode}), -1, false);
            PhysicalBookVORowImpl currPhbook=null;
          VirtualBookVORowImpl currVbook=null;
            while(bkBrcdHistRI.hasNext()) {
                currPhbook =
                        (PhysicalBookVORowImpl)((BookBarcodeHistoryVORowImpl)bkBrcdHistRI.next()).getPhysicalBookVO();
                if (pp_bkVo.findByKey(new Key(new Object[] { currPhbook.getArtId(),
                                                             currPhbook.getLabcol() }),
                                      -1).length == 0) {
                    currVbook =
                            (VirtualBookVORowImpl)currPhbook.getVirtualBookVO();
                    PP_BookBarcodeSearchResultVORowImpl newBk =
                        (PP_BookBarcodeSearchResultVORowImpl)pp_bkVo.createRow();
                pp_bkVo.insertRow(newBk);
                newBk.setArtId(currPhbook.getArtId());
                newBk.setBarcodeType("بارکد بایگانی کتاب");
                newBk.setCallNo(currVbook.getCallNo());
                newBk.setLabcol(currPhbook.getLabcol());
                newBk.setTitle(currVbook.getTitle());
                newBk.setBarcode(currPhbook.getBarcode());
              }
            }
            
        }
//     persVo.removeApplyViewCriteriaName("search_barcode_equalVC");
//     persVo.executeQuery();
   //  PhbookVo.removeApplyViewCriteriaName("SearchBarcodeEqualVC");
    //PhbookVo.executeQuery();
    // memBrcdHistVo.removeApplyViewCriteriaName("SearchBarcodeEqualVC");
    // memBrcdHistVo.executeQuery();
    // bkBrcdHistVo.removeApplyViewCriteriaName("SearchBarcodeEqualVC");
    // bkBrcdHistVo.executeQuery();
        return null;
   }
   

    public void applyLoanAtLibListVc(String selectedValue) {

        ViewObjectImpl loanAtLibVo = getLoanAtLibListVO1();
        if (loanAtLibVo.getApplyViewCriteriaNames() != null) {
            loanAtLibVo.applyViewCriteria(null);
            loanAtLibVo.executeQuery();
        }
        if ("active".equalsIgnoreCase(selectedValue)) {

            loanAtLibVo.applyViewCriteria(loanAtLibVo.getViewCriteria("LoanAtLibActiveListVC"));
            loanAtLibVo.executeQuery();
        } else if ("all".equalsIgnoreCase(selectedValue)) {
            loanAtLibVo.applyViewCriteria(loanAtLibVo.getViewCriteria("LoanAtLibAllListVC"));

            loanAtLibVo.executeQuery();
        }

    }

    public void removeLoanAtLibActiveListVc() {
        ViewObjectImpl loanAtLibVo = getLoanAtLibListVO1();
        loanAtLibVo.removeApplyViewCriteriaName("LoanAtLibActiveListVC");
        loanAtLibVo.executeQuery();

    }

    /**
     * Container's getter for VirtualBookVO1.
     * @return VirtualBookVO1
     */
    public ViewObjectImpl getVirtualBookVO1() {
        return (ViewObjectImpl)findViewObject("VirtualBookVO1");
    }

    /**
     * Container's getter for BookIsbnVO1.
     * @return BookIsbnVO1
     */
    public ViewObjectImpl getBookIsbnVO1() {
        return (ViewObjectImpl)findViewObject("BookIsbnVO1");
    }

    /**
     * Container's getter for NoteVO1.
     * @return NoteVO1
     */
    public ViewObjectImpl getNoteVO1() {
        return (ViewObjectImpl)findViewObject("NoteVO1");
    }

    /**
     * Container's getter for SeriesVO1.
     * @return SeriesVO1
     */
    public ViewObjectImpl getSeriesVO1() {
        return (ViewObjectImpl)findViewObject("SeriesVO1");
    }

    /**
     * Container's getter for VbookLanguageVO1.
     * @return VbookLanguageVO1
     */
    public ViewObjectImpl getVbookLanguageVO1() {
        return (ViewObjectImpl)findViewObject("VbookLanguageVO1");
    }

    /**
     * Container's getter for VbookMainProviderVO1.
     * @return VbookMainProviderVO1
     */
    public ViewObjectImpl getVbookMainProviderVO1() {
        return (ViewObjectImpl)findViewObject("VbookMainProviderVO1");
    }

    /**
     * Container's getter for VbookPublisherVO1.
     * @return VbookPublisherVO1
     */
    public ViewObjectImpl getVbookPublisherVO1() {
        return (ViewObjectImpl)findViewObject("VbookPublisherVO1");
    }

    /**
     * Container's getter for VbookSubjectVO1.
     * @return VbookSubjectVO1
     */
    public ViewObjectImpl getVbookSubjectVO1() {
        return (ViewObjectImpl)findViewObject("VbookSubjectVO1");
    }

    /**
     * Container's getter for VbookOtherProviderVO1.
     * @return VbookOtherProviderVO1
     */
    public ViewObjectImpl getVbookOtherProviderVO1() {
        return (ViewObjectImpl)findViewObject("VbookOtherProviderVO1");
    }

    /**
     * Container's getter for VbookUniTtlVO1.
     * @return VbookUniTtlVO1
     */
    public ViewObjectImpl getVbookUniTtlVO1() {
        return (ViewObjectImpl)findViewObject("VbookUniTtlVO1");
    }

    /**
     * Container's getter for MemshipStatusLOV.
     * @return MemshipStatusLOV
     */
    public ViewObjectImpl getDegreeLOV() {
        return (ViewObjectImpl)findViewObject("DegreeLOV");
    }


    /**
     * Container's getter for CardCardRowVO1.
     * @return CardCardRowVO1
     */
    public ViewObjectImpl getCardCardRowVO1() {
        return (ViewObjectImpl)findViewObject("CardCardRowVO1");
    }

    /**
     * Container's getter for CardCardRowVO2.
     * @return CardCardRowVO2
     */
    public ViewObjectImpl getCardCardRowVO2() {
        return (ViewObjectImpl)findViewObject("CardCardRowVO2");
    }

    /**
     * Container's getter for RoPubLovVO2.
     * @return RoPubLovVO2
     */
    public ViewObjectImpl getOriginLOV() {
        return (ViewObjectImpl)findViewObject("OriginLOV");
    }

    /**
     * Container's getter for PersonVO1.
     * @return PersonVO1
     */
    public ViewObjectImpl getPersonVO1() {
        return (ViewObjectImpl)findViewObject("PersonVO1");
    }

    /**
     * Container's getter for AddressVO1.
     * @return AddressVO1
     */
    public ViewObjectImpl getAddressVO1() {
        return (ViewObjectImpl)findViewObject("AddressVO1");
    }

    /**
     * Container's getter for EmailVO1.
     * @return EmailVO1
     */
    public ViewObjectImpl getEmailVO1() {
        return (ViewObjectImpl)findViewObject("EmailVO1");
    }

    /**
     * Container's getter for TelephoneVO1.
     * @return TelephoneVO1
     */
    public ViewObjectImpl getTelephoneVO1() {
        return (ViewObjectImpl)findViewObject("TelephoneVO1");
    }

    /**
     * Container's getter for InitMemberVO1.
     * @return InitMemberVO1
     */
    public InitMemberVOImpl getInitMemberVO1() {
        return (InitMemberVOImpl)findViewObject("InitMemberVO1");
    }

    /**
     * Container's getter for InitMemberVO2.
     * @return InitMemberVO2
     */
    public InitMemberVOImpl getInitMemberVO2() {
        return (InitMemberVOImpl)findViewObject("InitMemberVO2");
    }

    /**
     * Container's getter for VbookBookIsbnVL1.
     * @return VbookBookIsbnVL1
     */
    public ViewLinkImpl getVbookBookIsbnVL1() {
        return (ViewLinkImpl)findViewLink("VbookBookIsbnVL1");
    }

    /**
     * Container's getter for VbookNoteVL1.
     * @return VbookNoteVL1
     */
    public ViewLinkImpl getVbookNoteVL1() {
        return (ViewLinkImpl)findViewLink("VbookNoteVL1");
    }

    /**
     * Container's getter for VbookSeriesVL1.
     * @return VbookSeriesVL1
     */
    public ViewLinkImpl getVbookSeriesVL1() {
        return (ViewLinkImpl)findViewLink("VbookSeriesVL1");
    }

    /**
     * Container's getter for VbookVbkLangVL1.
     * @return VbookVbkLangVL1
     */
    public ViewLinkImpl getVbookVbkLangVL1() {
        return (ViewLinkImpl)findViewLink("VbookVbkLangVL1");
    }

    /**
     * Container's getter for VbookVbkPrvVL1.
     * @return VbookVbkPrvVL1
     */
    public ViewLinkImpl getVbookVbkPrvVL1() {
        return (ViewLinkImpl)findViewLink("VbookVbkPrvVL1");
    }

    /**
     * Container's getter for VbookVbkPubVL1.
     * @return VbookVbkPubVL1
     */
    public ViewLinkImpl getVbookVbkPubVL1() {
        return (ViewLinkImpl)findViewLink("VbookVbkPubVL1");
    }

    /**
     * Container's getter for VbookVbkSubVL1.
     * @return VbookVbkSubVL1
     */
    public ViewLinkImpl getVbookVbkSubVL1() {
        return (ViewLinkImpl)findViewLink("VbookVbkSubVL1");
    }

    /**
     * Container's getter for VbookVbkPrvVL2.
     * @return VbookVbkPrvVL2
     */
    public ViewLinkImpl getVbookVbkPrvVL2() {
        return (ViewLinkImpl)findViewLink("VbookVbkPrvVL2");
    }

    /**
     * Container's getter for VbookVbkUniTtlVL1.
     * @return VbookVbkUniTtlVL1
     */
    public ViewLinkImpl getVbookVbkUniTtlVL1() {
        return (ViewLinkImpl)findViewLink("VbookVbkUniTtlVL1");
    }

    /**
     * Container's getter for VbookCrdCrdRwVL1.
     * @return VbookCrdCrdRwVL1
     */
    public ViewLinkImpl getVbookCrdCrdRwVL1() {
        return (ViewLinkImpl)findViewLink("VbookCrdCrdRwVL1");
    }

    /**
     * Container's getter for PersonAddressVL1.
     * @return PersonAddressVL1
     */
    public ViewLinkImpl getPersonAddressVL1() {
        return (ViewLinkImpl)findViewLink("PersonAddressVL1");
    }

    /**
     * Container's getter for PersonEmailVL1.
     * @return PersonEmailVL1
     */
    public ViewLinkImpl getPersonEmailVL1() {
        return (ViewLinkImpl)findViewLink("PersonEmailVL1");
    }

    /**
     * Container's getter for PersonTelephoneVL1.
     * @return PersonTelephoneVL1
     */
    public ViewLinkImpl getPersonTelephoneVL1() {
        return (ViewLinkImpl)findViewLink("PersonTelephoneVL1");
    }

    /**
     * Container's getter for PersonInitMemberVL1.
     * @return PersonInitMemberVL1
     */
    public ViewLinkImpl getPersonInitMemberVL1() {
        return (ViewLinkImpl)findViewLink("PersonInitMemberVL1");
    }


    /**
     * Container's getter for InitMemberVO4.
     * @return InitMemberVO4
     */
    public InitMemberVOImpl getInitMemberVO4() {
        return (InitMemberVOImpl)findViewObject("InitMemberVO4");
    }

    /**
     * Container's getter for LoanVO2.
     * @return LoanVO2
     */
    public LoanVOImpl getLoanVO2() {
        return (LoanVOImpl)findViewObject("LoanVO2");
    }

    /**
     * Container's getter for InitMemberLoanVL2.
     * @return InitMemberLoanVL2
     */
    public ViewLinkImpl getInitMemberLoanVL2() {
        return (ViewLinkImpl)findViewLink("InitMemberLoanVL2");
    }

    /**
     * Container's getter for LoanVO3.
     * @return LoanVO3
     */
    public LoanVOImpl getLoanVO3() {
        return (LoanVOImpl)findViewObject("LoanVO3");
    }

    /**
     * Container's getter for UniformTitleVO1.
     * @return UniformTitleVO1
     */
    public TemplateViewObject getUniformTitleVO1() {
        return (TemplateViewObject)findViewObject("UniformTitleVO1");
    }

    @Override
    public void prepareSession(SessionData sessionData) {
        super.prepareSession(sessionData);
       
        pakage_variables=new HashMap();
        //        //TODO: this code must be change with the user actual labcol
//                getSession().getUserData().put("labcol", "1100");
//                getSession().getUserData().put("labcolno", new Number(1100));
        //        //TODO: this code must be change with the actual username
        //        getSession().getUserData().put("username", "testUser");
//                getSession().getUserData().put("libartid", new Number(1));
        //        getSession().getUserData().put("libname","كتابخانه مركزي و مركز اسناد");
        getSession().getUserData().put("LabelFarsi.Setting.p_latin_farsi",new Number(1));
      getSession().getUserData().put("LabelFarsi.Setting.print_column",new Number(1));
        getSession().getUserData().put("validation_policy",
                                       "persian_cataloging1");
        
    }

    /**
     * Container's getter for PhysicalBookVO1.
     * @return PhysicalBookVO1
     */
    public ViewObjectImpl getPhysicalBookVO1() {
        return (ViewObjectImpl)findViewObject("PhysicalBookVO1");
    }

    /**
     * Container's getter for VbookPhysBookVL1.
     * @return VbookPhysBookVL1
     */
    public ViewLinkImpl getVbookPhysBookVL1() {
        return (ViewLinkImpl)findViewLink("VbookPhysBookVL1");
    }

    /**
     * Container's getter for ProviderRoleVO1.
     * @return ProviderRoleVO1
     */
    public TemplateViewObject getProviderRoleVO1() {
        return (TemplateViewObject)findViewObject("ProviderRoleVO1");
    }


    /**
     * Container's getter for ProviderVO1.
     * @return ProviderVO1
     */
    public TemplateViewObject getProviderVO1() {
        return (TemplateViewObject)findViewObject("ProviderVO1");
    }

    /**
     * Container's getter for PublisherVO1.
     * @return PublisherVO1
     */
    public TemplateViewObject getPublisherVO1() {
        return (TemplateViewObject)findViewObject("PublisherVO1");
    }


    /**
     * Container's getter for FloatSubjectVO1.
     * @return FloatSubjectVO1
     */
    public TemplateViewObject getFloatSubjectVO1() {
        return (TemplateViewObject)findViewObject("FloatSubjectVO1");
    }

    /**
     * Container's getter for OtherTitleVO1.
     * @return OtherTitleVO1
     */
    public TemplateViewObject getOtherTitleVO1() {
        return (TemplateViewObject)findViewObject("OtherTitleVO1");
    }

    /**
     * Container's getter for VbookOtherTtlVL1.
     * @return VbookOtherTtlVL1
     */
    public ViewLinkImpl getVbookOtherTtlVL1() {
        return (ViewLinkImpl)findViewLink("VbookOtherTtlVL1");
    }

    /**
     * Container's getter for LoanVO4.
     * @return LoanVO4
     */
    public LoanVOImpl getLoanVO4() {
        return (LoanVOImpl)findViewObject("LoanVO4");
    }

    /**
     * Container's getter for InitMemberLoanVL3.
     * @return InitMemberLoanVL3
     */
    public ViewLinkImpl getInitMemberLoanVL3() {
        return (ViewLinkImpl)findViewLink("InitMemberLoanVL3");
    }


    /**
     * Container's getter for MemberBarcodeHistory1.
     * @return MemberBarcodeHistory1
     */
    public ViewObjectImpl getMemberBarcodeHistory1() {
        return (ViewObjectImpl)findViewObject("MemberBarcodeHistory1");
    }

    /**
     * Container's getter for PersonMemberBarcodeHistoryVL1.
     * @return PersonMemberBarcodeHistoryVL1
     */
    public ViewLinkImpl getPersonMemberBarcodeHistoryVL1() {
        return (ViewLinkImpl)findViewLink("PersonMemberBarcodeHistoryVL1");
    }


    /**
     * Container's getter for BookLoanHistoryVo1.
     * @return BookLoanHistoryVo1
     */
    public ViewObjectImpl getBookLoanHistoryVo1() {
        return (ViewObjectImpl)findViewObject("BookLoanHistoryVo1");
    }

    /**
     * Container's getter for PhysicalbookBookLoanHistoryVL1.
     * @return PhysicalbookBookLoanHistoryVL1
     */
    public ViewLinkImpl getPhysicalbookBookLoanHistoryVL1() {
        return (ViewLinkImpl)findViewLink("PhysicalbookBookLoanHistoryVL1");
    }

    /**
     * Container's getter for InitMemberCurrLibVO.
     * @return InitMemberCurrLibVO
     */
    public InitMemberVOImpl getInitMemberCurrLibVO() {
        return (InitMemberVOImpl)findViewObject("InitMemberCurrLibVO");
    }

    /**
     * Container's getter for PersonInitMem_CurLibVL1.
     * @return PersonInitMem_CurLibVL1
     */
    public ViewLinkImpl getPersonInitMem_CurLibVL1() {
        return (ViewLinkImpl)findViewLink("PersonInitMem_CurLibVL1");
    }

    /**
     * Container's getter for MemberStatusHistoryVO1.
     * @return MemberStatusHistoryVO1
     */
    public ViewObjectImpl getMemberStatusHistoryVO1() {
        return (ViewObjectImpl)findViewObject("MemberStatusHistoryVO1");
    }

    /**
     * Container's getter for InitMemberMemStatusHistoryVL1.
     * @return InitMemberMemStatusHistoryVL1
     */
    public ViewLinkImpl getInitMemberMemStatusHistoryVL1() {
        return (ViewLinkImpl)findViewLink("InitMemberMemStatusHistoryVL1");
    }


    /**
     * Container's getter for LoanVO1.
     * @return LoanVO1
     */
    public LoanVOImpl getMemLoanHistoryVO() {
        return (LoanVOImpl)findViewObject("MemLoanHistoryVO");
    }

    /**
     * Container's getter for InitMemberLoanVL1.
     * @return InitMemberLoanVL1
     */
    public ViewLinkImpl getInitMemberLoanVL1() {
        return (ViewLinkImpl)findViewLink("InitMemberLoanVL1");
    }

    /**
     * Container's getter for LoanAtLibListVO1.
     * @return LoanAtLibListVO1
     */
    public ViewObjectImpl getLoanAtLibListVO1() {
        return (ViewObjectImpl)findViewObject("LoanAtLibListVO1");
    }


    /**
     * Container's getter for PublicNonCashPenaltyVO1.
     * @return PublicNonCashPenaltyVO1
     */
    public ViewObjectImpl getPublicNonCashPenaltyVO1() {
        return (ViewObjectImpl)findViewObject("PublicNonCashPenaltyVO1");
    }

    /**
     * Container's getter for InitMemberPublicNonCashPenalty1.
     * @return InitMemberPublicNonCashPenalty1
     */
    public ViewLinkImpl getInitMemberPublicNonCashPenalty1() {
        return (ViewLinkImpl)findViewLink("InitMemberPublicNonCashPenalty1");
    }

    /**
     * Container's getter for PublicCashPenalty1.
     * @return PublicCashPenalty1
     */
    public ViewObjectImpl getPublicCashPenaltyVO() {
        return (ViewObjectImpl)findViewObject("PublicCashPenaltyVO");
    }

    /**
     * Container's getter for InitMemberPublicCashPenaltyVL1.
     * @return InitMemberPublicCashPenaltyVL1
     */
    public ViewLinkImpl getInitMemberPublicCashPenaltyVL1() {
        return (ViewLinkImpl)findViewLink("InitMemberPublicCashPenaltyVL1");
    }

    /**
     * Container's getter for IntroductionLetterVO.
     * @return IntroductionLetterVO
     */
    public IntroductionLetterVOImpl getIntroductionLetterVO() {
        return (IntroductionLetterVOImpl)findViewObject("IntroductionLetterVO");
    }

    /**
     * Container's getter for InitMemberIntroductionLetterVL1.
     * @return InitMemberIntroductionLetterVL1
     */
    public ViewLinkImpl getInitMemberIntroductionLetterVL1() {
        return (ViewLinkImpl)findViewLink("InitMemberIntroductionLetterVL1");
    }

    /**
     * Container's getter for GoalLibLOV1.
     * @return GoalLibLOV1
     */
    public ViewObjectImpl getGoalLibLOV1() {
        return (ViewObjectImpl)findViewObject("GoalLibLOV1");
    }


    /**
     * Container's getter for VbookProviderVO1.
     * @return VbookProviderVO1
     */
    public ViewObjectImpl getVbookProviderVO1() {
        return (ViewObjectImpl)findViewObject("VbookProviderVO1");
    }

    /**
     * Container's getter for VbookVbkPrvVL3.
     * @return VbookVbkPrvVL3
     */
    public ViewLinkImpl getVbookVbkPrvVL3() {
        return (ViewLinkImpl)findViewLink("VbookVbkPrvVL3");
    }


    /**
     * Container's getter for LoanCashPenaltyVO1.
     * @return LoanCashPenaltyVO1
     */
    public ViewObjectImpl getLoanCashPenaltyVO1() {
        return (ViewObjectImpl)findViewObject("LoanCashPenaltyVO1");
    }

    /**
     * Container's getter for InitMemberLoanCashPenaltyVL1.
     * @return InitMemberLoanCashPenaltyVL1
     */
    public ViewLinkImpl getInitMemberLoanCashPenaltyVL1() {
        return (ViewLinkImpl)findViewLink("InitMemberLoanCashPenaltyVL1");
    }


    /**
     * Container's getter for ReserveVO1.
     * @return ReserveVO1
     */
    public ViewObjectImpl getReserveVO1() {
        return (ViewObjectImpl)findViewObject("ReserveVO1");
    }

    /**
     * Container's getter for VbookReserveVL1.
     * @return VbookReserveVL1
     */
    public ViewLinkImpl getVbookReserveVL1() {
        return (ViewLinkImpl)findViewLink("VbookReserveVL1");
    }

    /**
     * Container's getter for ReserveCurrLabcolVO.
     * @return ReserveCurrLabcolVO
     */
    public ViewObjectImpl getReserveCurrLabcolVO() {
        return (ViewObjectImpl)findViewObject("ReserveCurrLabcolVO");
    }

    /**
     * Container's getter for LoanVO1.
     * @return LoanVO1
     */
    public LoanVOImpl getLoanVO_loan_list() {
        return (LoanVOImpl)findViewObject("LoanVO_loan_list");
    }

    /**
     * Container's getter for InitMemberLoanVL4.
     * @return InitMemberLoanVL4
     */
    public ViewLinkImpl getInitMemberLoanVL4() {
        return (ViewLinkImpl)findViewLink("InitMemberLoanVL4");
    }

    /**
     * Container's getter for LoanVO_CID_LOAN.
     * @return LoanVO_CID_LOAN
     */
    public LoanVOImpl getLoanVO_extend_list() {
        return (LoanVOImpl)findViewObject("LoanVO_extend_list");
    }

    /**
     * Container's getter for BookBarcodeChange.
     * @return BookBarcodeChange
     */
    public ViewObjectImpl getBookBarcodeChange() {
        return (ViewObjectImpl)findViewObject("BookBarcodeChange");
    }

    /**
     * Container's getter for VirtualBookVO2.
     * @return VirtualBookVO2
     */
    public VirtualBookVOImpl getVirtualBookVO2() {
        return (VirtualBookVOImpl)findViewObject("VirtualBookVO2");
    }

    /**
     * Container's getter for PhysicalBookVbookVL1.
     * @return PhysicalBookVbookVL1
     */
    public ViewLinkImpl getPhysicalBookVbookVL1() {
        return (ViewLinkImpl)findViewLink("PhysicalBookVbookVL1");
    }

    /**
     * Container's getter for ReserveVO2.
     * @return ReserveVO2
     */
    public ViewObjectImpl getPrintReserveVO() {
        return (ViewObjectImpl)findViewObject("PrintReserveVO");
    }

    /**
     * Container's getter for SearchMemberBarcodeHistory.
     * @return SearchMemberBarcodeHistory
     */
    public MemberBarcodeHistoryVOImpl getSearchMemberBarcodeHistory() {
        return (MemberBarcodeHistoryVOImpl)findViewObject("SearchMemberBarcodeHistory");
    }


    /**
     * Container's getter for PenaltyPaymentVO1.
     * @return PenaltyPaymentVO1
     */
    public ViewObjectImpl getPenaltyPaymentVO1() {
        return (ViewObjectImpl)findViewObject("PenaltyPaymentVO1");
    }

    /**
     * Container's getter for InitMemPenaltyPayVL1.
     * @return InitMemPenaltyPayVL1
     */
    public ViewLinkImpl getInitMemPenaltyPayVL1() {
        return (ViewLinkImpl)findViewLink("InitMemPenaltyPayVL1");
    }

    /**
     * Container's getter for InitMemberLoanVL5.
     * @return InitMemberLoanVL5
     */
    public ViewLinkImpl getInitMemberLoanVL5() {
        return (ViewLinkImpl)findViewLink("InitMemberLoanVL5");
    }

    /**
     * Container's getter for VwBookBarcodeHistoryVO.
     * @return VwBookBarcodeHistoryVO
     */
    public ViewObjectImpl getVwBookBarcodeHistoryVO() {
        return (ViewObjectImpl)findViewObject("VwBookBarcodeHistoryVO");
    }

    /**
     * Container's getter for PhysicalbookVwBookbarcodHistoryVL1.
     * @return PhysicalbookVwBookbarcodHistoryVL1
     */
    public ViewLinkImpl getPhysicalbookVwBookbarcodHistoryVL1() {
        return (ViewLinkImpl)findViewLink("PhysicalbookVwBookbarcodHistoryVL1");
    }

    /**
     * Container's getter for BookBarcodeHistoryVO1.
     * @return BookBarcodeHistoryVO1
     */
    public ViewObjectImpl getBookBarcodeHistoryVO1() {
        return (ViewObjectImpl)findViewObject("BookBarcodeHistoryVO1");
    }

    /**
     * Container's getter for VwPenaltyHistoryVO1.
     * @return VwPenaltyHistoryVO1
     */
    public ViewObjectImpl getVwPenaltyHistoryVO1() {
        return (ViewObjectImpl)findViewObject("VwPenaltyHistoryVO1");
    }

    /**
     * Container's getter for InitMemberVwPenaltyHistoryVL1.
     * @return InitMemberVwPenaltyHistoryVL1
     */
    public ViewLinkImpl getInitMemberVwPenaltyHistoryVL1() {
        return (ViewLinkImpl)findViewLink("InitMemberVwPenaltyHistoryVL1");
    }

    /**
     * Container's getter for BarcodeSearch_bookVO1.
     * @return BarcodeSearch_bookVO1
     */
    public ViewObjectImpl getBarcodeSearch_bookVO1() {
        return (ViewObjectImpl)findViewObject("BarcodeSearch_bookVO1");
    }

    /**
     * Container's getter for BarcodeSearch_persVO1.
     * @return BarcodeSearch_persVO1
     */
    public ViewObjectImpl getBarcodeSearch_persVO1() {
        return (ViewObjectImpl)findViewObject("BarcodeSearch_persVO1");
    }

    /**
     * Container's getter for DepartmentVO1.
     * @return DepartmentVO1
     */
    public ViewObjectImpl getDepartmentVO1() {
        return (ViewObjectImpl)findViewObject("DepartmentVO1");
    }


    /**
     * Container's getter for VwBookStatusHistoryVO.
     * @return VwBookStatusHistoryVO
     */
    public ViewObjectImpl getVwBookStatusHistoryVO() {
        return (ViewObjectImpl)findViewObject("VwBookStatusHistoryVO");
    }

    /**
     * Container's getter for PhysicalBookVwBookStatusHistoryVL1.
     * @return PhysicalBookVwBookStatusHistoryVL1
     */
    public ViewLinkImpl getPhysicalBookVwBookStatusHistoryVL1() {
        return (ViewLinkImpl)findViewLink("PhysicalBookVwBookStatusHistoryVL1");
    }

    /**
     * Container's getter for MessageVO1.
     * @return MessageVO1
     */
    public ViewObjectImpl getMessageVO1() {
        return (ViewObjectImpl)findViewObject("MessageVO1");
    }

    /**
     * Container's getter for AllPhysicalBooksRoVO1.
     * @return AllPhysicalBooksRoVO1
     */
    public ViewObjectImpl getAllPhysicalBooksRoVO1() {
        return (ViewObjectImpl)findViewObject("AllPhysicalBooksRoVO1");
    }

    /**
     * Container's getter for AllPersonRoVO1.
     * @return AllPersonRoVO1
     */
    public AllPersonVOImpl getAllPersonRoVO1() {
        return (AllPersonVOImpl)findViewObject("AllPersonRoVO1");
    }

    /**
     * Container's getter for LoanVO_Intro_Letter.
     * @return LoanVO_Intro_Letter
     */
    public LoanVOImpl getLoanVO_Intro_Letter() {
        return (LoanVOImpl)findViewObject("LoanVO_Intro_Letter");
    }

    /**
     * Container's getter for InitMemberLoanVL6.
     * @return InitMemberLoanVL6
     */
    public ViewLinkImpl getInitMemberLoanVL6() {
        return (ViewLinkImpl)findViewLink("InitMemberLoanVL6");
    }

    /**
     * Container's getter for BookLoanHistoryVo_M.
     * @return BookLoanHistoryVo_M
     */
    public ViewObjectImpl getBookLoanHistoryVo_M() {
        return (ViewObjectImpl)findViewObject("BookLoanHistoryVo_M");
    }

    /**
     * Container's getter for PhysicalbookBookLoanHistoryVL2.
     * @return PhysicalbookBookLoanHistoryVL2
     */
    public ViewLinkImpl getPhysicalbookBookLoanHistoryVL2() {
        return (ViewLinkImpl)findViewLink("PhysicalbookBookLoanHistoryVL2");
    }


    /**
     * Container's getter for PhysicalBookVolPartVO1.
     * @return PhysicalBookVolPartVO1
     */
    public ViewObjectImpl getPhysicalBookVolPartVO1() {
        return (ViewObjectImpl)findViewObject("PhysicalBookVolPartVO1");
    }

    /**
     * Container's getter for VirtualBookPhbookVolPartVL1.
     * @return VirtualBookPhbookVolPartVL1
     */
    public ViewLinkImpl getVirtualBookPhbookVolPartVL1() {
        return (ViewLinkImpl)findViewLink("VirtualBookPhbookVolPartVL1");
    }

    /**
     * Container's getter for BookThesisVO1.
     * @return BookThesisVO1
     */
    public ViewObjectImpl getBookThesisVO1() {
        return (ViewObjectImpl)findViewObject("BookThesisVO1");
    }

    /**
     * Container's getter for InitMemBookThesisVL1.
     * @return InitMemBookThesisVL1
     */
    public ViewLinkImpl getInitMemBookThesisVL1() {
        return (ViewLinkImpl)findViewLink("InitMemBookThesisVL1");
    }

    /**
     * Container's getter for DummyVO1.
     * @return DummyVO1
     */
    public DummyVOImpl getDummyVO1() {
        return (DummyVOImpl)findViewObject("DummyVO1");
    }

    /**
     * Container's getter for ReturnBookVO1.
     * @return ReturnBookVO1
     */
    public ViewObjectImpl getReturnBookVO1() {
        return (ViewObjectImpl)findViewObject("ReturnBookVO1");
    }

    /**
     * Container's getter for LoanVO1.
     * @return LoanVO1
     */
    public LoanVOImpl getLoanVO1() {
        return (LoanVOImpl)findViewObject("LoanVO1");
    }

    /**
     * Container's getter for ReturnBookLoan_NullRetVL1.
     * @return ReturnBookLoan_NullRetVL1
     */
    public ViewLinkImpl getReturnBookLoan_NullRetVL1() {
        return (ViewLinkImpl)findViewLink("ReturnBookLoan_NullRetVL1");
    }

    /**
     * Container's getter for InitMemberVO3.
     * @return InitMemberVO3
     */
    public InitMemberVOImpl getInitMemberVO3() {
        return (InitMemberVOImpl)findViewObject("InitMemberVO3");
    }

    /**
     * Container's getter for LoanInitMemVL1.
     * @return LoanInitMemVL1
     */
    public ViewLinkImpl getLoanInitMemVL1() {
        return (ViewLinkImpl)findViewLink("LoanInitMemVL1");
    }

    /**
     * Container's getter for PersonVO2.
     * @return PersonVO2
     */
    public PersonVOImpl getPersonVO2() {
        return (PersonVOImpl)findViewObject("PersonVO2");
    }

    /**
     * Container's getter for InitMemPersonVL1.
     * @return InitMemPersonVL1
     */
    public ViewLinkImpl getInitMemPersonVL1() {
        return (ViewLinkImpl)findViewLink("InitMemPersonVL1");
    }

    /**
     * Container's getter for RootMenu.
     * @return RootMenu
     */
    public ViewObjectImpl getRootMenu() {
        return (ViewObjectImpl)findViewObject("RootMenu");
    }

    /**
     * Container's getter for MenuListVO1.
     * @return MenuListVO1
     */
    public ViewObjectImpl getSubMenu() {
        return (ViewObjectImpl)findViewObject("SubMenu");
    }

    /**
     * Container's getter for MenuListRootSubVL1.
     * @return MenuListRootSubVL1
     */
    public ViewLinkImpl getMenuListRootSubVL1() {
        return (ViewLinkImpl)findViewLink("MenuListRootSubVL1");
    }


    /**
     * Container's getter for MenuListVO1.
     * @return MenuListVO1
     */
    public ViewObjectImpl getMenuListVO1() {
        return (ViewObjectImpl)findViewObject("MenuListVO1");
    }

    /**
     * Container's getter for MenuList_ChildrenVO2.
     * @return MenuList_ChildrenVO2
     */
    public ViewObjectImpl getMenuList_ChildrenVO2() {
        return (ViewObjectImpl)findViewObject("MenuList_ChildrenVO2");
    }

    /**
     * Container's getter for MenuListMenuListVL1.
     * @return MenuListMenuListVL1
     */
    public ViewLinkImpl getMenuListMenuListVL1() {
        return (ViewLinkImpl)findViewLink("MenuListMenuListVL1");
    }


    /**
     * Container's getter for MvLibRoleVO1.
     * @return MvLibRoleVO1
     */
    public ViewObjectImpl getMvLibRoleVO1() {
        return (ViewObjectImpl)findViewObject("MvLibRoleVO1");
    }

    /**
     * Container's getter for LibUserVo1.
     * @return LibUserVo1
     */
    public ViewObjectImpl getLibUserVo1() {
        return (ViewObjectImpl)findViewObject("LibUserVo1");
    }

    /**
     * Container's getter for LibRoleVO1.
     * @return LibRoleVO1
     */
    public LibRoleVOImpl getLibRoleVO1() {
        return (LibRoleVOImpl)findViewObject("LibRoleVO1");
    }

    /**
     * Container's getter for LibUserRoleVo1.
     * @return LibUserRoleVo1
     */
    public ViewObjectImpl getLibUserRoleVo_Role() {
        return (ViewObjectImpl)findViewObject("LibUserRoleVo_Role");
    }

    /**
     * Container's getter for LibRole_LibUserRoleVL1.
     * @return LibRole_LibUserRoleVL1
     */
    public ViewLinkImpl getLibRole_LibUserRoleVL1() {
        return (ViewLinkImpl)findViewLink("LibRole_LibUserRoleVL1");
    }


    /**
     * Container's getter for LibUserRoleVO_User.
     * @return LibUserRoleVO_User
     */
    public ViewObjectImpl getLibUserRoleVO_User() {
        return (ViewObjectImpl)findViewObject("LibUserRoleVO_User");
    }

    /**
     * Container's getter for LibUser_LibUserRoleVL1.
     * @return LibUser_LibUserRoleVL1
     */
    public ViewLinkImpl getLibUser_LibUserRoleVL1() {
        return (ViewLinkImpl)findViewLink("LibUser_LibUserRoleVL1");
    }


    /**
     * Container's getter for LibUserVo2.
     * @return LibUserVo2
     */
    public LibUserVoImpl getLibUserVo2() {
        return (LibUserVoImpl)findViewObject("LibUserVo2");
    }

    /**
     * Container's getter for LibRole_LibUserVL1.
     * @return LibRole_LibUserVL1
     */
    public ViewLinkImpl getLibRole_LibUserVL1() {
        return (ViewLinkImpl)findViewLink("LibRole_LibUserVL1");
    }


    /**
     * Container's getter for LibUserVo_insertUser.
     * @return LibUserVo_insertUser
     */
    public LibUserVoImpl getLibUserVo_insertUser() {
        return (LibUserVoImpl)findViewObject("LibUserVo_insertUser");
    }

    /**
     * Container's getter for Library1.
     * @return Library1
     */
    public ViewObjectImpl getLibrary1() {
        return (ViewObjectImpl)findViewObject("Library1");
    }

    /**
     * Container's getter for RegisterLostVO1.
     * @return RegisterLostVO1
     */
    public ViewObjectImpl getRegisterLostVO1() {
        return (ViewObjectImpl)findViewObject("RegisterLostVO1");
    }

    /**
     * Container's getter for InitMemberRegisterLostVl1.
     * @return InitMemberRegisterLostVl1
     */
    public ViewLinkImpl getInitMemberRegisterLostVl1() {
        return (ViewLinkImpl)findViewLink("InitMemberRegisterLostVl1");
    }


    /**
     * Container's getter for Library2.
     * @return Library2
     */
    public ViewObjectImpl getLibrary2() {
        return (ViewObjectImpl)findViewObject("Library2");
    }

    /**
     * Container's getter for LibUserLibraryVL1.
     * @return LibUserLibraryVL1
     */
    public ViewLinkImpl getLibUserLibraryVL1() {
        return (ViewLinkImpl)findViewLink("LibUserLibraryVL1");
    }

    /**
     * Container's getter for RecentBooksVo1.
     * @return RecentBooksVo1
     */
    public ViewObjectImpl getRecentBooksVo1() {
        return (ViewObjectImpl)findViewObject("RecentBooksVo1");
    }

    /**
     * Container's getter for MemberVo1.
     * @return MemberVo1
     */
    public MemberVoImpl getMemberVo1() {
        return (MemberVoImpl)findViewObject("MemberVo1");
    }

    /**
     * Container's getter for InitMemberMemberVL1.
     * @return InitMemberMemberVL1
     */
    public ViewLinkImpl getInitMemberMemberVL1() {
        return (ViewLinkImpl)findViewLink("InitMemberMemberVL1");
    }

    /**
     * Container's getter for MainSeeUniformTitle1.
     * @return MainSeeUniformTitle1
     */
    public ViewObjectImpl getMainSeeUniformTitle1() {
        return (ViewObjectImpl)findViewObject("MainSeeUniformTitle1");
    }

    /**
     * Container's getter for SeeUniformTitle1.
     * @return SeeUniformTitle1
     */
    public ViewObjectImpl getSeeUniformTitle1() {
        return (ViewObjectImpl)findViewObject("SeeUniformTitle1");
    }

    /**
     * Container's getter for MainSeeUniformTitleSeeUniformTitleVL1.
     * @return MainSeeUniformTitleSeeUniformTitleVL1
     */
    public ViewLinkImpl getMainSeeUniformTitleSeeUniformTitleVL1() {
        return (ViewLinkImpl)findViewLink("MainSeeUniformTitleSeeUniformTitleVL1");
    }

    /**
     * Container's getter for MainSeeAlsoUniformTitleVO1.
     * @return MainSeeAlsoUniformTitleVO1
     */
    public ViewObjectImpl getMainSeeAlsoUniformTitleVO1() {
        return (ViewObjectImpl)findViewObject("MainSeeAlsoUniformTitleVO1");
    }

    /**
     * Container's getter for SeeAlsoUniformTitleVo1.
     * @return SeeAlsoUniformTitleVo1
     */
    public ViewObjectImpl getSeeAlsoUniformTitleVo1() {
        return (ViewObjectImpl)findViewObject("SeeAlsoUniformTitleVo1");
    }

    /**
     * Container's getter for SeeAlsoUniformTitleMainSeeAlsoUniformTitleVl1.
     * @return SeeAlsoUniformTitleMainSeeAlsoUniformTitleVl1
     */
    public ViewLinkImpl getSeeAlsoUniformTitleMainSeeAlsoUniformTitleVl1() {
        return (ViewLinkImpl)findViewLink("SeeAlsoUniformTitleMainSeeAlsoUniformTitleVl1");
    }

    /**
     * Container's getter for MainSeeSubjectVo1.
     * @return MainSeeSubjectVo1
     */
    public ViewObjectImpl getMainSeeSubjectVo1() {
        return (ViewObjectImpl)findViewObject("MainSeeSubjectVo1");
    }


    /**
     * Container's getter for MainSeeAlsoSubjectVo1.
     * @return MainSeeAlsoSubjectVo1
     */
    public ViewObjectImpl getMainSeeAlsoSubjectVo1() {
        return (ViewObjectImpl)findViewObject("MainSeeAlsoSubjectVo1");
    }


    /**
     * Container's getter for MainSeeProvider1.
     * @return MainSeeProvider1
     */
    public ViewObjectImpl getMainSeeProvider1() {
        return (ViewObjectImpl)findViewObject("MainSeeProvider1");
    }

    /**
     * Container's getter for SeeProvider1.
     * @return SeeProvider1
     */
    public ViewObjectImpl getSeeProvider1() {
        return (ViewObjectImpl)findViewObject("SeeProvider1");
    }

    /**
     * Container's getter for MainSeeProviderSeeProviderVL1.
     * @return MainSeeProviderSeeProviderVL1
     */
    public ViewLinkImpl getMainSeeProviderSeeProviderVL1() {
        return (ViewLinkImpl)findViewLink("MainSeeProviderSeeProviderVL1");
    }

    /**
     * Container's getter for MainSeeAlsoProvider1.
     * @return MainSeeAlsoProvider1
     */
    public ViewObjectImpl getMainSeeAlsoProvider1() {
        return (ViewObjectImpl)findViewObject("MainSeeAlsoProvider1");
    }

    /**
     * Container's getter for SeeAlsoProviderVo1.
     * @return SeeAlsoProviderVo1
     */
    public ViewObjectImpl getSeeAlsoProviderVo1() {
        return (ViewObjectImpl)findViewObject("SeeAlsoProviderVo1");
    }

    /**
     * Container's getter for MainSeeAlsoProviderSeeAlsoProviderVL1.
     * @return MainSeeAlsoProviderSeeAlsoProviderVL1
     */
    public ViewLinkImpl getMainSeeAlsoProviderSeeAlsoProviderVL1() {
        return (ViewLinkImpl)findViewLink("MainSeeAlsoProviderSeeAlsoProviderVL1");
    }

    /**
     * Container's getter for LatinMainSeeUniformTitle.
     * @return LatinMainSeeUniformTitle
     */
    public ViewObjectImpl getLatinMainSeeUniformTitle() {
        return (ViewObjectImpl)findViewObject("LatinMainSeeUniformTitle");
    }

    /**
     * Container's getter for LatinSeeUniformTitle.
     * @return LatinSeeUniformTitle
     */
    public ViewObjectImpl getLatinSeeUniformTitle() {
        return (ViewObjectImpl)findViewObject("LatinSeeUniformTitle");
    }

    /**
     * Container's getter for MainSeeUniformTitleSeeUniformTitleVL2.
     * @return MainSeeUniformTitleSeeUniformTitleVL2
     */
    public ViewLinkImpl getMainSeeUniformTitleSeeUniformTitleVL2() {
        return (ViewLinkImpl)findViewLink("MainSeeUniformTitleSeeUniformTitleVL2");
    }

    /**
     * Container's getter for LatinMainSeeAlsoUniformTitleVO.
     * @return LatinMainSeeAlsoUniformTitleVO
     */
    public ViewObjectImpl getLatinMainSeeAlsoUniformTitleVO() {
        return (ViewObjectImpl)findViewObject("LatinMainSeeAlsoUniformTitleVO");
    }

    /**
     * Container's getter for LatinSeeAlsoUniformTitleVo.
     * @return LatinSeeAlsoUniformTitleVo
     */
    public ViewObjectImpl getLatinSeeAlsoUniformTitleVo() {
        return (ViewObjectImpl)findViewObject("LatinSeeAlsoUniformTitleVo");
    }

    /**
     * Container's getter for SeeAlsoUniformTitleMainSeeAlsoUniformTitleVl2.
     * @return SeeAlsoUniformTitleMainSeeAlsoUniformTitleVl2
     */
    public ViewLinkImpl getSeeAlsoUniformTitleMainSeeAlsoUniformTitleVl2() {
        return (ViewLinkImpl)findViewLink("SeeAlsoUniformTitleMainSeeAlsoUniformTitleVl2");
    }

    /**
     * Container's getter for EmailVO2.
     * @return EmailVO2
     */
    public EmailVOImpl getEmailVO2() {
        return (EmailVOImpl)findViewObject("EmailVO2");
    }

    /**
     * Container's getter for AddressVO2.
     * @return AddressVO2
     */
    public ViewObjectImpl getAddressVO2() {
        return (ViewObjectImpl)findViewObject("AddressVO2");
    }

    /**
     * Container's getter for LatinMainSeeProvider.
     * @return LatinMainSeeProvider
     */
    public MainSeeProviderImpl getLatinMainSeeProvider() {
        return (MainSeeProviderImpl)findViewObject("LatinMainSeeProvider");
    }


    /**
     * Container's getter for LatinSeeProvider.
     * @return LatinSeeProvider
     */
    public SeeProviderImpl getLatinSeeProvider() {
        return (SeeProviderImpl)findViewObject("LatinSeeProvider");
    }

    /**
     * Container's getter for MainSeeProviderSeeProviderVL2.
     * @return MainSeeProviderSeeProviderVL2
     */
    public ViewLinkImpl getMainSeeProviderSeeProviderVL2() {
        return (ViewLinkImpl)findViewLink("MainSeeProviderSeeProviderVL2");
    }

    /**
     * Container's getter for LatinMainSeeAlsoProvider.
     * @return LatinMainSeeAlsoProvider
     */
    public ViewObjectImpl getLatinMainSeeAlsoProvider() {
        return (ViewObjectImpl)findViewObject("LatinMainSeeAlsoProvider");
    }

    /**
     * Container's getter for LatinSeeAlsoProviderVo.
     * @return LatinSeeAlsoProviderVo
     */
    public ViewObjectImpl getLatinSeeAlsoProviderVo() {
        return (ViewObjectImpl)findViewObject("LatinSeeAlsoProviderVo");
    }

    /**
     * Container's getter for MainSeeAlsoProviderSeeAlsoProviderVL2.
     * @return MainSeeAlsoProviderSeeAlsoProviderVL2
     */
    public ViewLinkImpl getMainSeeAlsoProviderSeeAlsoProviderVL2() {
        return (ViewLinkImpl)findViewLink("MainSeeAlsoProviderSeeAlsoProviderVL2");
    }


    /**
     * Container's getter for LatinMainSeeSubjectVo.
     * @return LatinMainSeeSubjectVo
     */
    public ViewObjectImpl getLatinMainSeeSubjectVo() {
        return (ViewObjectImpl)findViewObject("LatinMainSeeSubjectVo");
    }


    /**
     * Container's getter for LatinMainSeeAlsoSubjectVo.
     * @return LatinMainSeeAlsoSubjectVo
     */
    public ViewObjectImpl getLatinMainSeeAlsoSubjectVo() {
        return (ViewObjectImpl)findViewObject("LatinMainSeeAlsoSubjectVo");
    }

    /**
     * Container's getter for FarsiDescriptorVo1.
     * @return FarsiDescriptorVo1
     */
    public ViewObjectImpl getFarsiDescriptorVo1() {
        return (ViewObjectImpl)findViewObject("FarsiDescriptorVo1");
    }

    /**
     * Container's getter for FarsiKeywordVO1.
     * @return FarsiKeywordVO1
     */
    public ViewObjectImpl getFarsiKeywordVO1() {
        return (ViewObjectImpl)findViewObject("FarsiKeywordVO1");
    }

    /**
     * Container's getter for FarsiDescriptorFarsiKeywordVL1.
     * @return FarsiDescriptorFarsiKeywordVL1
     */
    public ViewLinkImpl getFarsiDescriptorFarsiKeywordVL1() {
        return (ViewLinkImpl)findViewLink("FarsiDescriptorFarsiKeywordVL1");
    }

    /**
     * Container's getter for FarsiEnglishKeywordVo1.
     * @return FarsiEnglishKeywordVo1
     */
    public ViewObjectImpl getFarsiEnglishKeywordVo1() {
        return (ViewObjectImpl)findViewObject("FarsiEnglishKeywordVo1");
    }

    /**
     * Container's getter for FarsiKeywordFarsiEnglishKeywordVL1.
     * @return FarsiKeywordFarsiEnglishKeywordVL1
     */
    public ViewLinkImpl getFarsiKeywordFarsiEnglishKeywordVL1() {
        return (ViewLinkImpl)findViewLink("FarsiKeywordFarsiEnglishKeywordVL1");
    }

    /**
     * Container's getter for SeeFarsiKeywordVo1.
     * @return SeeFarsiKeywordVo1
     */
    public ViewObjectImpl getSeeFarsiKeywordVo1() {
        return (ViewObjectImpl)findViewObject("SeeFarsiKeywordVo1");
    }

    /**
     * Container's getter for FarsiKeywordSeeFasiKeywordVL1.
     * @return FarsiKeywordSeeFasiKeywordVL1
     */
    public ViewLinkImpl getFarsiKeywordSeeFasiKeywordVL1() {
        return (ViewLinkImpl)findViewLink("FarsiKeywordSeeFasiKeywordVL1");
    }


    /**
     * Container's getter for UniformTitleRefrence1.
     * @return UniformTitleRefrence1
     */
    public ViewObjectImpl getUniformTitleRefrence1() {
        return (ViewObjectImpl)findViewObject("UniformTitleRefrence1");
    }

    /**
     * Container's getter for SeeUniTitleUniTitleRefrenceVL1.
     * @return SeeUniTitleUniTitleRefrenceVL1
     */
    public ViewLinkImpl getSeeUniTitleUniTitleRefrenceVL1() {
        return (ViewLinkImpl)findViewLink("SeeUniTitleUniTitleRefrenceVL1");
    }

    /**
     * Container's getter for UniformTitleRefrence2.
     * @return UniformTitleRefrence2
     */
    public ViewObjectImpl getUniformTitleRefrence2() {
        return (ViewObjectImpl)findViewObject("UniformTitleRefrence2");
    }

    /**
     * Container's getter for SeeUniTitleUniTitleRefrenceVL2.
     * @return SeeUniTitleUniTitleRefrenceVL2
     */
    public ViewLinkImpl getSeeUniTitleUniTitleRefrenceVL2() {
        return (ViewLinkImpl)findViewLink("SeeUniTitleUniTitleRefrenceVL2");
    }

    /**
     * Container's getter for UniformTitleRefrence3.
     * @return UniformTitleRefrence3
     */
    public ViewObjectImpl getUniformTitleRefrence3() {
        return (ViewObjectImpl)findViewObject("UniformTitleRefrence3");
    }

    /**
     * Container's getter for SeeAlsoUniTitleUniformTitleRefrenceVL1.
     * @return SeeAlsoUniTitleUniformTitleRefrenceVL1
     */
    public ViewLinkImpl getSeeAlsoUniTitleUniformTitleRefrenceVL1() {
        return (ViewLinkImpl)findViewLink("SeeAlsoUniTitleUniformTitleRefrenceVL1");
    }


    /**
     * Container's getter for MainSeeUniformTitle_test.
     * @return MainSeeUniformTitle_test
     */
    public MainSeeUniformTitleImpl getMainSeeUniformTitle_test() {
        return (MainSeeUniformTitleImpl)findViewObject("MainSeeUniformTitle_test");
    }

//    /**
//     * Container's getter for SeeSubjectVo1.
//     * @return SeeSubjectVo1
//     */
//    public SeeSubjectVoImpl getSeeSubjectVo1() {
//        return (SeeSubjectVoImpl)findViewObject("SeeSubjectVo");
//    }


    public void setPakage_variables(Map pakage_variables) {
        this.pakage_variables = pakage_variables;
    }

    public Map getPakage_variables() {
        return pakage_variables;
    }

    /**
     * Container's getter for PP_LoanVO1.
     * @return PP_LoanVO1
     */
    public PP_LoanVOImpl getPP_LoanVO1() {
        return (PP_LoanVOImpl)findViewObject("PP_LoanVO1");
    }


    /**
     * Container's getter for PhysicalBookVO3.
     * @return PhysicalBookVO3
     */
    public PhysicalBookVOImpl getPhysicalBookVO3() {
        return (PhysicalBookVOImpl)findViewObject("PhysicalBookVO3");
    }
    
    public Number weekend(Number d1,Number d2) {
        Date d =
            FDate.Farsi_to_georgian(d1.divide(10000).intValue(), d1.divide(100).mod(100).intValue(),
                                    d1.mod(100).intValue());
     int chand_shanbe= (d.getDay()+2);
     if(chand_shanbe==8)
         chand_shanbe=1;
    
      DatabaseProcedure weekend =
             DatabaseProcedure.define("FUNCTION  parsi_ut_lib.WEEKEND(date_in1 number,date_in2 number,chand_shanbe number) return number;");
         BigDecimal weekend_result =
            (BigDecimal)weekend.call(getDBTransaction(), d1, d2,
                                     new Number(chand_shanbe)).getReturnValue();
         
      return ParsiUtil.convert_dec_to_number(weekend_result);
    }

  public Number holiday(Number d1,Number d2) {
    DatabaseProcedure holyday =
           DatabaseProcedure.define("FUNCTION  holyday(date_in1 number,date_in2 number) return number;");
       BigDecimal holyday_result =
            (BigDecimal)holyday.call(getDBTransaction(), d1,
                                     d2).getReturnValue();
       
    return ParsiUtil.convert_dec_to_number(holyday_result);
  }


    /**
     * Container's getter for CashierVo1.
     * @return CashierVo1
     */
    public ViewObjectImpl getCashierVo1() {
        return (ViewObjectImpl)findViewObject("CashierVo1");
    }

    /**
     * Container's getter for InitMemCashierVL1.
     * @return InitMemCashierVL1
     */
    public ViewLinkImpl getInitMemCashierVL1() {
        return (ViewLinkImpl)findViewLink("InitMemCashierVL1");
    }

    /**
     * Container's getter for CashTypeVo1.
     * @return CashTypeVo1
     */
    public ViewObjectImpl getCashTypeVo1() {
        return (ViewObjectImpl)findViewObject("CashTypeVo1");
    }
    
  public int testInitCurr() {
      PersonVORowImpl impl = (PersonVORowImpl)getPersonVO1().getCurrentRow();
      PersonImpl pi = (PersonImpl)impl.getEntity(0);
      InitMemberImpl init = pi.getInitMemberCurrLib1();

      System.out.println(init.getAttribute("LibArtId"));

      //              PersonImpl pi=(PersonImpl)impl.getEntity(0);
      //      RowIterator init=pi.getInitMemberCurrentLib2();
      //      while(init.hasNext())
      //          System.out.println(init.next().getAttribute("LibArtId"));
      return 0;
  }

  public boolean test_person_initmem_currlib() {
    PersonVOImpl personvo = (PersonVOImpl)getPersonVO1();
    while (personvo.hasNext()) {
        PersonVORowImpl per = (PersonVORowImpl)personvo.next();
        InitMemberVORowImpl currLibVO1 =
            (InitMemberVORowImpl)per.getInitMemberCurrLibVO1();
        if (currLibVO1 != null && currLibVO1.getLibArtId().intValue() != 1)
            return false;

    }
    return true;

  }

  public Number testDummyVo() {

    System.out.println("initial render");

    DummyVOImpl dummyVO1 = getDummyVO1();
  String s="1100";
        dummyVO1.setQuery("SELECT labcol  FROM virtual_book " + "WHERE NVL('" +
                          s + "','0')=nvl(labcol,'0')");

    //"SELECT SUM(VALUE)  FROM  public_cash_penalty " +
    //      "WHERE MEM_ART_ID=161104"  );
    dummyVO1.executeQuery();
   
   
    // Integer loanPenalty=Integer.valueOf((String) dummyVO1.getCurrentRow().getAttribute("Dummy"));


    return null;

  }
  ///////////////////////////////////////////////////////

public void test(Boolean newYesNo) {
        LoanVORowImpl currExtent =
            (LoanVORowImpl)getLoanVO_extend_list().getCurrentRow();
    currExtent.setYesOrNo(newYesNo);
  System.out.println(currExtent.getYesOrNo());
}

    /**
     * Container's getter for CashierListVo1.
     * @return CashierListVo1
     */
    public ViewObjectImpl getCashierListVo1() {
        return (ViewObjectImpl)findViewObject("CashierListVo1");
    }

    /**
     * Container's getter for IsoSubjectVo1.
     * @return IsoSubjectVo1
     */
    public ViewObjectImpl getIsoSubjectVo1() {
        return (ViewObjectImpl)findViewObject("IsoSubjectVo1");
    }

    /**
     * Container's getter for PP_CashierVo1.
     * @return PP_CashierVo1
     */
    public PP_CashierVoImpl getPP_CashierVo1() {
        return (PP_CashierVoImpl)findViewObject("PP_CashierVo1");
    }

    /**
     * Container's getter for SocialBarcodeView1.
     * @return SocialBarcodeView1
     */
    public ViewObjectImpl getSocialBarcodeView1() {
        return (ViewObjectImpl)findViewObject("SocialBarcodeView1");
    }

    /**
     * Container's getter for BookRequest1.
     * @return BookRequest1
     */
    public BookRequestImpl getBookRequest1() {
        return (BookRequestImpl)findViewObject("BookRequest1");
    }

    /**
     * Container's getter for pp_ReqBlkVo1.
     * @return pp_ReqBlkVo1
     */
    public pp_ReqBlkVoImpl getpp_ReqBlkVo1() {
        return (pp_ReqBlkVoImpl)findViewObject("pp_ReqBlkVo1");
    }

    /**
     * Container's getter for MemberVo2.
     * @return MemberVo2
     */
    public MemberVoImpl getMemberVo_InitMemCurLib() {
        return (MemberVoImpl)findViewObject("MemberVo_InitMemCurLib");
    }

    /**
     * Container's getter for InitMemberMemberVL2.
     * @return InitMemberMemberVL2
     */
    public ViewLinkImpl getInitMemberMemberVL2() {
        return (ViewLinkImpl)findViewLink("InitMemberMemberVL2");
    }

    /**
     * Container's getter for RafReportVo1.
     * @return RafReportVo1
     */
    public ViewObjectImpl getRafReportVo1() {
        return (ViewObjectImpl)findViewObject("RafReportVo1");
    }

    /**
     * Container's getter for BookPlaceLOV.
     * @return BookPlaceLOV
     */
    public ViewObjectImpl getBookPlaceLOV() {
        return (ViewObjectImpl)findViewObject("BookPlaceLOV");
    }

    /**
     * Container's getter for PersonVO_Login.
     * @return PersonVO_Login
     */
    public PersonVOImpl getPersonVO_Login() {
        return (PersonVOImpl)findViewObject("PersonVO_Login");
    }

    /**
     * Container's getter for InitMemberVO_Login.
     * @return InitMemberVO_Login
     */
    public InitMemberVOImpl getInitMemberVO_Login() {
        return (InitMemberVOImpl)findViewObject("InitMemberVO_Login");
    }

    /**
     * Container's getter for PersonInitMemberVL2.
     * @return PersonInitMemberVL2
     */
    public ViewLinkImpl getPersonInitMemberVL2() {
        return (ViewLinkImpl)findViewLink("PersonInitMemberVL2");
    }

    /**
     * Container's getter for SuggestedVirtualBookVo1.
     * @return SuggestedVirtualBookVo1
     */
    public ViewObjectImpl getSuggestedVirtualBookVo1() {
        return (ViewObjectImpl)findViewObject("SuggestedVirtualBookVo1");
    }

    /**
     * Container's getter for SuggestedBookLanguageVo1.
     * @return SuggestedBookLanguageVo1
     */
    public ViewObjectImpl getSuggestedBookLanguageVo1() {
        return (ViewObjectImpl)findViewObject("SuggestedBookLanguageVo1");
    }

    /**
     * Container's getter for SuggestedProviderVo1.
     * @return SuggestedProviderVo1
     */
    public ViewObjectImpl getSuggestedProviderVo1() {
        return (ViewObjectImpl)findViewObject("SuggestedProviderVo1");
    }

    /**
     * Container's getter for SuggestedPublisherVo1.
     * @return SuggestedPublisherVo1
     */
    public ViewObjectImpl getSuggestedPublisherVo1() {
        return (ViewObjectImpl)findViewObject("SuggestedPublisherVo1");
    }

    /**
     * Container's getter for SuggestedSubjectVo1.
     * @return SuggestedSubjectVo1
     */
    public ViewObjectImpl getSuggestedSubjectVo1() {
        return (ViewObjectImpl)findViewObject("SuggestedSubjectVo1");
    }

    /**
     * Container's getter for VbookRankVO1.
     * @return VbookRankVO1
     */
    public ViewObjectImpl getVbookRankVO1() {
        return (ViewObjectImpl)findViewObject("VbookRankVO1");
    }

    /**
     * Container's getter for SuggestedBookSuggestedLangVL1.
     * @return SuggestedBookSuggestedLangVL1
     */
    public ViewLinkImpl getSuggestedBookSuggestedLangVL1() {
        return (ViewLinkImpl)findViewLink("SuggestedBookSuggestedLangVL1");
    }

    /**
     * Container's getter for SuggestedBookSuggestedProviderVL1.
     * @return SuggestedBookSuggestedProviderVL1
     */
    public ViewLinkImpl getSuggestedBookSuggestedProviderVL1() {
        return (ViewLinkImpl)findViewLink("SuggestedBookSuggestedProviderVL1");
    }

    /**
     * Container's getter for SuggestedBookSuggestedPublisherVL1.
     * @return SuggestedBookSuggestedPublisherVL1
     */
    public ViewLinkImpl getSuggestedBookSuggestedPublisherVL1() {
        return (ViewLinkImpl)findViewLink("SuggestedBookSuggestedPublisherVL1");
    }

    /**
     * Container's getter for SuggestedBookSuggestedSubjectVL1.
     * @return SuggestedBookSuggestedSubjectVL1
     */
    public ViewLinkImpl getSuggestedBookSuggestedSubjectVL1() {
        return (ViewLinkImpl)findViewLink("SuggestedBookSuggestedSubjectVL1");
    }

    /**
     * Container's getter for ExtraChargeVO1.
     * @return ExtraChargeVO1
     */
    public ViewObjectImpl getExtraChargeVO1() {
        return (ViewObjectImpl)findViewObject("ExtraChargeVO1");
    }

    /**
     * Container's getter for InitMemberExtraChargeVL1.
     * @return InitMemberExtraChargeVL1
     */
    public ViewLinkImpl getInitMemberExtraChargeVL1() {
        return (ViewLinkImpl)findViewLink("InitMemberExtraChargeVL1");
    }

    /**
     * Container's getter for ExtraChargeReportVO.
     * @return ExtraChargeReportVO
     */
    public ViewObjectImpl getExtraChargeReportVO() {
        return (ViewObjectImpl)findViewObject("ExtraChargeReportVO");
    }

    /**
     * Container's getter for CidConstVO1.
     * @return CidConstVO1
     */
    public ViewObjectImpl getCidConstVO1() {
        return (ViewObjectImpl)findViewObject("CidConstVO1");
    }

    /**
     * Container's getter for PersTypeLOV.
     * @return PersTypeLOV
     */
    public ViewObjectImpl getPersTypeLOV() {
        return (ViewObjectImpl)findViewObject("PersTypeLOV");
    }

    /**
     * Container's getter for RoCidMemberDeptVO1.
     * @return RoCidMemberDeptVO1
     */
    public ViewObjectImpl getDeptLOV() {
        return (ViewObjectImpl)findViewObject("DeptLOV");
    }

    /**
     * Container's getter for CMemSetupPostLOV.
     * @return CMemSetupPostLOV
     */
    public ViewObjectImpl getCMemSetupPostLOV() {
        return (ViewObjectImpl)findViewObject("CMemSetupPostLOV");
    }

    /**
     * Container's getter for MajorLOV.
     * @return MajorLOV
     */
    public ViewObjectImpl getMajorLOV() {
        return (ViewObjectImpl)findViewObject("MajorLOV");
    }

    /**
     * Container's getter for PersStatusLOV.
     * @return PersStatusLOV
     */
    public ViewObjectImpl getPersStatusLOV() {
        return (ViewObjectImpl)findViewObject("PersStatusLOV");
    }

    /**
     * Container's getter for SectLOV.
     * @return SectLOV
     */
    public ViewObjectImpl getSectLOV() {
        return (ViewObjectImpl)findViewObject("SectLOV");
    }

    /**
     * Container's getter for PersCategoryLOV.
     * @return PersCategoryLOV
     */
    public ViewObjectImpl getPersCategoryLOV() {
        return (ViewObjectImpl)findViewObject("PersCategoryLOV");
    }

    /**
     * Container's getter for PlaceLOV.
     * @return PlaceLOV
     */
    public ViewObjectImpl getPlaceLOV() {
        return (ViewObjectImpl)findViewObject("PlaceLOV");
    }

    /**
     * Container's getter for readingOrder1.
     * @return readingOrder1
     */
    public ViewObjectImpl getReadingOrderLOV() {
        return (ViewObjectImpl)findViewObject("ReadingOrderLOV");
    }

    /**
     * Container's getter for SaftyStatusLOV.
     * @return SaftyStatusLOV
     */
    public ViewObjectImpl getSaftyStatusLOV() {
        return (ViewObjectImpl)findViewObject("SaftyStatusLOV");
    }

    /**
     * Container's getter for LoanStatusLOV.
     * @return LoanStatusLOV
     */
    public ViewObjectImpl getLoanStatusLOV() {
        return (ViewObjectImpl)findViewObject("LoanStatusLOV");
    }

    /**
     * Container's getter for ExistanceStatusLOV.
     * @return ExistanceStatusLOV
     */
    public ViewObjectImpl getExistanceStatusLOV() {
        return (ViewObjectImpl)findViewObject("ExistanceStatusLOV");
    }

    /**
     * Container's getter for LanguageLOV.
     * @return LanguageLOV
     */
    public ViewObjectImpl getLanguageLOV() {
        return (ViewObjectImpl)findViewObject("LanguageLOV");
    }

    /**
     * Container's getter for PP_PersonBarcodeSearchResultVO1.
     * @return PP_PersonBarcodeSearchResultVO1
     */
    public PP_PersonBarcodeSearchResultVOImpl getPP_PersonBarcodeSearchResultVO1() {
        return (PP_PersonBarcodeSearchResultVOImpl)findViewObject("PP_PersonBarcodeSearchResultVO1");
}

    /**
     * Container's getter for PP_BookBarcodeSearchResultVO1.
     * @return PP_BookBarcodeSearchResultVO1
     */
    public PP_BookBarcodeSearchResultVOImpl getPP_BookBarcodeSearchResultVO1() {
        return (PP_BookBarcodeSearchResultVOImpl)findViewObject("PP_BookBarcodeSearchResultVO1");
    }

    /**
     * Container's getter for MemberBarcodeHistoryVO1.
     * @return MemberBarcodeHistoryVO1
     */
    public MemberBarcodeHistoryVOImpl getMemberBarcodeHistoryVO1() {
        return (MemberBarcodeHistoryVOImpl)findViewObject("MemberBarcodeHistoryVO1");
    }

    public void sendSms(String number,String body) {
      boxService = new BoxService();
      BoxServiceSoap boxServiceSoap = boxService.getBoxServiceSoap();
      // Add your code to call the desired methods.

      //my code here
      ArrayOfString destPhoneNumbers = new ArrayOfString();
      ArrayOfString sendMessageAnswer;
      destPhoneNumbers.getString().add(number);
      // destPhoneNumbers.getString().add("09390511109");
      

      sendMessageAnswer =
              boxServiceSoap.sendMessage("khanof", "4111498", "30007957950128",
                                         destPhoneNumbers, body, "1");
      System.out.println( sendMessageAnswer.getString());
      System.out.println( destPhoneNumbers.getString());
      
      
      //end of my code
    }

    /**
     * Container's getter for ReportPersonLOV.
     * @return ReportPersonLOV
     */
    public PersonVOImpl getReportPersonLOV() {
        return (PersonVOImpl)findViewObject("ReportPersonLOV");
    }

    /**
     * Container's getter for ReportBookLOV.
     * @return ReportBookLOV
     */
    public PhysicalBookVOImpl getReportBookLOV() {
        return (PhysicalBookVOImpl)findViewObject("ReportBookLOV");
    }

    /**
     * Container's getter for CatalogPlaceVo.
     * @return CatalogPlaceVo
     */
    public ViewObjectImpl getCatalogPlaceVo() {
        return (ViewObjectImpl)findViewObject("CatalogPlaceVo");
    }

    /**
     * Container's getter for CatalogPrivatePostVo.
     * @return CatalogPrivatePostVo
     */
    public ViewObjectImpl getCatalogPrivatePostVo() {
        return (ViewObjectImpl)findViewObject("CatalogPrivatePostVo");
    }

    /**
     * Container's getter for MemberSetUpVo1.
     * @return MemberSetUpVo1
     */
    public ViewObjectImpl getMemberSetUpVo1() {
        return (ViewObjectImpl)findViewObject("MemberSetUpVo1");
    }

    /**
     * Container's getter for CatalogPrivatePostMemberSetupVL1.
     * @return CatalogPrivatePostMemberSetupVL1
     */
    public ViewLinkImpl getCatalogPrivatePostMemberSetupVL1() {
        return (ViewLinkImpl)findViewLink("CatalogPrivatePostMemberSetupVL1");
    }

    /**
     * Container's getter for CatalogPassClassVo.
     * @return CatalogPassClassVo
     */
    public ViewObjectImpl getCatalogPassClassVo() {
        return (ViewObjectImpl)findViewObject("CatalogPassClassVo");
    }

    /**
     * Container's getter for CatalogShelfDelayVo.
     * @return CatalogShelfDelayVo
     */
    public ViewObjectImpl getCatalogShelfDelayVo() {
        return (ViewObjectImpl)findViewObject("CatalogShelfDelayVo");
    }

    /**
     * Container's getter for MemberSetUpVo2.
     * @return MemberSetUpVo2
     */
    public ViewObjectImpl getMemberSetUpVo2() {
        return (ViewObjectImpl)findViewObject("MemberSetUpVo2");
    }

    /**
     * Container's getter for ItemListVO1.
     * @return ItemListVO1
     */
    public MenuListVOImpl getItemListVO1() {
        return (MenuListVOImpl)findViewObject("ItemListVO1");
    }

    /**
     * Container's getter for PenaltyType_1.
     * @return PenaltyType_1
     */
    public ViewObjectImpl getPenaltyType_1() {
        return (ViewObjectImpl)findViewObject("PenaltyType_1");
    }

    /**
     * Container's getter for PenaltyType_2.
     * @return PenaltyType_2
     */
    public ViewObjectImpl getPenaltyType_2() {
        return (ViewObjectImpl)findViewObject("PenaltyType_2");
    }

    /**
     * Container's getter for LibUserVo_UserTab.
     * @return LibUserVo_UserTab
     */
    public LibUserVoImpl getLibUserVo_UserTab() {
        return (LibUserVoImpl)findViewObject("LibUserVo_UserTab");
    }

    /**
     * Container's getter for LibRoleVO_UserTab.
     * @return LibRoleVO_UserTab
     */
    public LibRoleVOImpl getLibRoleVO_UserTab() {
        return (LibRoleVOImpl)findViewObject("LibRoleVO_UserTab");
    }

    /**
     * Container's getter for LibUserLibRoleVL1.
     * @return LibUserLibRoleVL1
     */
    public ViewLinkImpl getLibUserLibRoleVL1() {
        return (ViewLinkImpl)findViewLink("LibUserLibRoleVL1");
    }

    /**
     * Container's getter for refPersianUniTitleVO.
     * @return refPersianUniTitleVO
     */
    public ViewObjectImpl getRefSelectUniTitleVO() {
        return (ViewObjectImpl)findViewObject("RefSelectUniTitleVO");
    }

    /**
     * Container's getter for LabelFarsi_label_virtualBook.
     * @return LabelFarsi_label_virtualBook
     */
    public VirtualBookVOImpl getLabelFarsi_label_virtualBook() {
        return (VirtualBookVOImpl)findViewObject("LabelFarsi_label_virtualBook");
    }

    /**
     * Container's getter for PhysicalBookVO2.
     * @return PhysicalBookVO2
     */
    public PhysicalBookVOImpl getPhysicalBookVO2() {
        return (PhysicalBookVOImpl)findViewObject("PhysicalBookVO2");
    }

    /**
     * Container's getter for VbookPhysBookVL2.
     * @return VbookPhysBookVL2
     */
    public ViewLinkImpl getVbookPhysBookVL2() {
        return (ViewLinkImpl)findViewLink("VbookPhysBookVL2");
    }

    /**
     * Container's getter for VBook_ListBook.
     * @return VBook_ListBook
     */
    public VirtualBookVOImpl getVBook_ListBook() {
        return (VirtualBookVOImpl)findViewObject("VBook_ListBook");
    }


    /**
     * Container's getter for VBook_book_farsi_Card.
     * @return VBook_book_farsi_Card
     */
    public VirtualBookVOImpl getVBook_book_farsi_Card() {
        return (VirtualBookVOImpl)findViewObject("VBook_book_farsi_Card");
    }

    /**
     * Container's getter for CardVO1.
     * @return CardVO1
     */
    public ViewObjectImpl getCardVO1() {
        return (ViewObjectImpl)findViewObject("CardVO1");
    }

    /**
     * Container's getter for RefSelectSubjectVO.
     * @return RefSelectSubjectVO
     */
    public ViewObjectImpl getRefSelectSubjectVO() {
        return (ViewObjectImpl)findViewObject("RefSelectSubjectVO");
    }
/**
     * Container's getter for VwCardSubjectVO1.
     * @return VwCardSubjectVO1
     */
    public ViewObjectImpl getVwCardSubjectVO1() {
        return (ViewObjectImpl)findViewObject("VwCardSubjectVO1");
    }

    /**
     * Container's getter for SeeSubjectViewO1.
     * @return SeeSubjectViewO1
     */
    public ViewObjectImpl getSeeSubjectVo() {
        return (ViewObjectImpl)findViewObject("SeeSubjectVo");
}

    /**
     * Container's getter for SubjSeeSubjViewVL1.
     * @return SubjSeeSubjViewVL1
     */
    public ViewLinkImpl getSubjSeeSubjViewVL1() {
        return (ViewLinkImpl)findViewLink("SubjSeeSubjViewVL1");
    }

    /**
     * Container's getter for LatinSeeSubjectVo.
     * @return LatinSeeSubjectVo
     */
    public SeeSubjectVoImpl getLatinSeeSubjectVo() {
        return (SeeSubjectVoImpl)findViewObject("LatinSeeSubjectVo");
    }

    /**
     * Container's getter for SubjSeeSubjViewVL2.
     * @return SubjSeeSubjViewVL2
     */
    public ViewLinkImpl getSubjSeeSubjViewVL2() {
        return (ViewLinkImpl)findViewLink("SubjSeeSubjViewVL2");
    }

    /**
     * Container's getter for SeeAlsoSubjectVO_rtype1.
     * @return SeeAlsoSubjectVO_rtype1
     */
    public SeeAlsoSubjectVOImpl getSeeAlsoSubjectVO_rtype1() {
        return (SeeAlsoSubjectVOImpl)findViewObject("SeeAlsoSubjectVO_rtype1");
    }

    /**
     * Container's getter for MainSeeAlsoSubjectSeeAlsoSubVL1.
     * @return MainSeeAlsoSubjectSeeAlsoSubVL1
     */
    public ViewLinkImpl getMainSeeAlsoSubjectSeeAlsoSubVL1() {
        return (ViewLinkImpl)findViewLink("MainSeeAlsoSubjectSeeAlsoSubVL1");
    }

    /**
     * Container's getter for SeeAlsoSubjectVO_rtype2.
     * @return SeeAlsoSubjectVO_rtype2
     */
    public SeeAlsoSubjectVOImpl getSeeAlsoSubjectVO_rtype2() {
        return (SeeAlsoSubjectVOImpl)findViewObject("SeeAlsoSubjectVO_rtype2");
    }

    /**
     * Container's getter for MainSeeAlsoSubjectSeeAlsoSubVL2.
     * @return MainSeeAlsoSubjectSeeAlsoSubVL2
     */
    public ViewLinkImpl getMainSeeAlsoSubjectSeeAlsoSubVL2() {
        return (ViewLinkImpl)findViewLink("MainSeeAlsoSubjectSeeAlsoSubVL2");
    }

    /**
     * Container's getter for SeeAlsoSubjectVO_rtype3.
     * @return SeeAlsoSubjectVO_rtype3
     */
    public SeeAlsoSubjectVOImpl getSeeAlsoSubjectVO_rtype3() {
        return (SeeAlsoSubjectVOImpl)findViewObject("SeeAlsoSubjectVO_rtype3");
    }

    /**
     * Container's getter for MainSeeAlsoSubjectSeeAlsoSubVL3.
     * @return MainSeeAlsoSubjectSeeAlsoSubVL3
     */
    public ViewLinkImpl getMainSeeAlsoSubjectSeeAlsoSubVL3() {
        return (ViewLinkImpl)findViewLink("MainSeeAlsoSubjectSeeAlsoSubVL3");
    }

    /**
     * Container's getter for LatinSeeAlsoSubjectVO_rtype1.
     * @return LatinSeeAlsoSubjectVO_rtype1
     */
    public SeeAlsoSubjectVOImpl getLatinSeeAlsoSubjectVO_rtype1() {
        return (SeeAlsoSubjectVOImpl)findViewObject("LatinSeeAlsoSubjectVO_rtype1");
    }

    /**
     * Container's getter for MainSeeAlsoSubjectSeeAlsoSubVL4.
     * @return MainSeeAlsoSubjectSeeAlsoSubVL4
     */
    public ViewLinkImpl getMainSeeAlsoSubjectSeeAlsoSubVL4() {
        return (ViewLinkImpl)findViewLink("MainSeeAlsoSubjectSeeAlsoSubVL4");
    }

    /**
     * Container's getter for LatinSeeAlsoSubjectVO_rtype2.
     * @return LatinSeeAlsoSubjectVO_rtype2
     */
    public SeeAlsoSubjectVOImpl getLatinSeeAlsoSubjectVO_rtype2() {
        return (SeeAlsoSubjectVOImpl)findViewObject("LatinSeeAlsoSubjectVO_rtype2");
    }

    /**
     * Container's getter for MainSeeAlsoSubjectSeeAlsoSubVL5.
     * @return MainSeeAlsoSubjectSeeAlsoSubVL5
     */
    public ViewLinkImpl getMainSeeAlsoSubjectSeeAlsoSubVL5() {
        return (ViewLinkImpl)findViewLink("MainSeeAlsoSubjectSeeAlsoSubVL5");
    }

    /**
     * Container's getter for LatinSeeAlsoSubjectVO_rtype3.
     * @return LatinSeeAlsoSubjectVO_rtype3
     */
    public SeeAlsoSubjectVOImpl getLatinSeeAlsoSubjectVO_rtype3() {
        return (SeeAlsoSubjectVOImpl)findViewObject("LatinSeeAlsoSubjectVO_rtype3");
    }

    /**
     * Container's getter for MainSeeAlsoSubjectSeeAlsoSubVL6.
     * @return MainSeeAlsoSubjectSeeAlsoSubVL6
     */
    public ViewLinkImpl getMainSeeAlsoSubjectSeeAlsoSubVL6() {
        return (ViewLinkImpl)findViewLink("MainSeeAlsoSubjectSeeAlsoSubVL6");
    }

    /**
     * Container's getter for RefSelectProviderVO.
     * @return RefSelectProviderVO
     */
    public ProviderVOImpl getRefSelectProviderVO() {
        return (ProviderVOImpl)findViewObject("RefSelectProviderVO");
    }

    /**
     * Container's getter for CatalogDetailVO1.
     * @return CatalogDetailVO1
     */
    public CatalogDetailVOImpl getCatalogDetailVO1() {
        return (CatalogDetailVOImpl)findViewObject("CatalogDetailVO1");
    }

    /**
     * Container's getter for ReserveVO2.
     * @return ReserveVO2
     */
    public ReserveVOImpl getReserveVO2() {
        return (ReserveVOImpl)findViewObject("ReserveVO2");
    }

    /**
     * Container's getter for InitMemberReserveVL1.
     * @return InitMemberReserveVL1
     */
    public ViewLinkImpl getInitMemberReserveVL1() {
        return (ViewLinkImpl)findViewLink("InitMemberReserveVL1");
    }

    /**
     * Container's getter for PlaceLov_RoSpcLov.
     * @return PlaceLov_RoSpcLov
     */
    public ViewObjectImpl getPlaceLov_RoSpcLov() {
        return (ViewObjectImpl)findViewObject("PlaceLov_RoSpcLov");
    }

    /**
     * Container's getter for BookRequest2.
     * @return BookRequest2
     */
    public BookRequestImpl getBookRequest2() {
        return (BookRequestImpl)findViewObject("BookRequest2");
    }

    /**
     * Container's getter for PlaceLovBookRequestVL1.
     * @return PlaceLovBookRequestVL1
     */
    public ViewLinkImpl getPlaceLovBookRequestVL1() {
        return (ViewLinkImpl)findViewLink("PlaceLovBookRequestVL1");
    }

    /**
     * Container's getter for ProviderVO2.
     * @return ProviderVO2
     */
    public ProviderVOImpl getProviderVO2() {
        return (ProviderVOImpl)findViewObject("ProviderVO2");
    }

    /**
     * Container's getter for VbookPrvPrvVL1.
     * @return VbookPrvPrvVL1
     */
    public ViewLinkImpl getVbookPrvPrvVL1() {
        return (ViewLinkImpl)findViewLink("VbookPrvPrvVL1");
    }

    /**
     * Container's getter for UniformTitleVO2.
     * @return UniformTitleVO2
     */
    public UniformTitleVOImpl getUniformTitleVO2() {
        return (UniformTitleVOImpl)findViewObject("UniformTitleVO2");
    }

    /**
     * Container's getter for VbookUniformTitleVL1.
     * @return VbookUniformTitleVL1
     */
    public ViewLinkImpl getVbookUniformTitleVL1() {
        return (ViewLinkImpl)findViewLink("VbookUniformTitleVL1");
    }

    /**
     * Container's getter for SubjectVO1.
     * @return SubjectVO1
     */
    public SubjectVoImpl getSubjectVO1() {
        return (SubjectVoImpl)findViewObject("SubjectVO1");
    }

    /**
     * Container's getter for VbookProviderVO2.
     * @return VbookProviderVO2
     */
    public VbookProviderVOImpl getVbookProviderVO2() {
        return (VbookProviderVOImpl)findViewObject("VbookProviderVO2");
    }

    /**
     * Container's getter for ReserveVO3.
     * @return ReserveVO3
     */
    public ReserveVOImpl getReserveVO3() {
        return (ReserveVOImpl)findViewObject("ReserveVO3");
    }

    /**
     * Container's getter for PhbookVolPartReserveVL1.
     * @return PhbookVolPartReserveVL1
     */
    public ViewLinkImpl getPhbookVolPartReserveVL1() {
        return (ViewLinkImpl)findViewLink("PhbookVolPartReserveVL1");
    }

    @Override
    public void afterCommit(TransactionEvent transactionEvent) {
        super.afterCommit(transactionEvent);
       
    }

    /**
     * Container's getter for Rep_LanguagesVO1.
     * @return Rep_LanguagesVO1
     */
    public Rep_LanguagesVOImpl getRep_LanguagesVO1() {
        return (Rep_LanguagesVOImpl)findViewObject("Rep_LanguagesVO1");
    }

    /**
     * Container's getter for PrintVirtualBook1.
     * @return PrintVirtualBook1
     */
    public PrintVirtualBookImpl getPrintVirtualBook1() {
        return (PrintVirtualBookImpl)findViewObject("PrintVirtualBook1");
    }

    /**
     * Container's getter for CardRowVO1.
     * @return CardRowVO1
     */
    public ViewObjectImpl getCardRowVO1() {
        return (ViewObjectImpl)findViewObject("CardRowVO1");
    }

    /**
     * Container's getter for CardCardRowVL1.
     * @return CardCardRowVL1
     */
    public ViewLinkImpl getCardCardRowVL1() {
        return (ViewLinkImpl)findViewLink("CardCardRowVL1");
    }

    /**
     * Container's getter for VirtualBookList_FarsiLabelVO1.
     * @return VirtualBookList_FarsiLabelVO1
     */
    public ViewObjectImpl getVirtualBookList_FarsiLabelVO1() {
        return (ViewObjectImpl)findViewObject("VirtualBookList_FarsiLabelVO1");
    }

    /**
     * Container's getter for Rep_VirtualBook_FarsiLabelVO1.
     * @return Rep_VirtualBook_FarsiLabelVO1
     */
    public Rep_VirtualBookVOImpl getRep_VirtualBook_FarsiLabelVO1() {
        return (Rep_VirtualBookVOImpl)findViewObject("Rep_VirtualBook_FarsiLabelVO1");
    }


    /**
     * Container's getter for Rep_PhysicalBook_FarsiLabelVO1.
     * @return Rep_PhysicalBook_FarsiLabelVO1
     */
    public ViewObjectImpl getRep_PhysicalBook_FarsiLabelVO1() {
        return (ViewObjectImpl)findViewObject("Rep_PhysicalBook_FarsiLabelVO1");
    }

    /**
     * Container's getter for RepVbookRepPhbookVL1.
     * @return RepVbookRepPhbookVL1
     */
    public ViewLinkImpl getRepVbookRepPhbookVL1() {
        return (ViewLinkImpl)findViewLink("RepVbookRepPhbookVL1");
    }


    /**
     * Container's getter for Rep_VirtualBookFarsiCard1.
     * @return Rep_VirtualBookFarsiCard1
     */
    public Rep_VirtualBookFarsiCardImpl getRep_VirtualBookFarsiCardVo1() {
        return (Rep_VirtualBookFarsiCardImpl)findViewObject("Rep_VirtualBookFarsiCardVo1");
    }

    /**
     * Container's getter for Rep_BookISBNVo1.
     * @return Rep_BookISBNVo1
     */
    public ViewObjectImpl getRep_BookISBNVo1() {
        return (ViewObjectImpl)findViewObject("Rep_BookISBNVo1");
    }

    /**
     * Container's getter for Rep_VBookFarsiCardBookISBNVL1.
     * @return Rep_VBookFarsiCardBookISBNVL1
     */
    public ViewLinkImpl getRep_VBookFarsiCardBookISBNVL1() {
        return (ViewLinkImpl)findViewLink("Rep_VBookFarsiCardBookISBNVL1");
    }

    /**
     * Container's getter for Rep_NotesVo1.
     * @return Rep_NotesVo1
     */
    public ViewObjectImpl getRep_NotesVo1() {
        return (ViewObjectImpl)findViewObject("Rep_NotesVo1");
    }

    /**
     * Container's getter for Rep_VBookFarsiCardNotesVL1.
     * @return Rep_VBookFarsiCardNotesVL1
     */
    public ViewLinkImpl getRep_VBookFarsiCardNotesVL1() {
        return (ViewLinkImpl)findViewLink("Rep_VBookFarsiCardNotesVL1");
    }

    /**
     * Container's getter for Rep_ProviderVo1.
     * @return Rep_ProviderVo1
     */
    public ViewObjectImpl getRep_ProviderVo1() {
        return (ViewObjectImpl)findViewObject("Rep_ProviderVo1");
    }

    /**
     * Container's getter for Rep_VBookFarsiCardProviderVL1.
     * @return Rep_VBookFarsiCardProviderVL1
     */
    public ViewLinkImpl getRep_VBookFarsiCardProviderVL1() {
        return (ViewLinkImpl)findViewLink("Rep_VBookFarsiCardProviderVL1");
    }

    /**
     * Container's getter for Rep_PublisherVo1.
     * @return Rep_PublisherVo1
     */
    public ViewObjectImpl getRep_PublisherVo1() {
        return (ViewObjectImpl)findViewObject("Rep_PublisherVo1");
    }

    /**
     * Container's getter for Rep_VBookFarsiCardPublisherVL1.
     * @return Rep_VBookFarsiCardPublisherVL1
     */
    public ViewLinkImpl getRep_VBookFarsiCardPublisherVL1() {
        return (ViewLinkImpl)findViewLink("Rep_VBookFarsiCardPublisherVL1");
    }

    /**
     * Container's getter for Rep_SeriesVo1.
     * @return Rep_SeriesVo1
     */
    public ViewObjectImpl getRep_SeriesVo1() {
        return (ViewObjectImpl)findViewObject("Rep_SeriesVo1");
    }

    /**
     * Container's getter for Rep_VBookFarsiCardSeries1.
     * @return Rep_VBookFarsiCardSeries1
     */
    public ViewLinkImpl getRep_VBookFarsiCardSeries1() {
        return (ViewLinkImpl)findViewLink("Rep_VBookFarsiCardSeries1");
    }

    /**
     * Container's getter for VirtualBookList_farsiCardVO1.
     * @return VirtualBookList_farsiCardVO1
     */
    public ViewObjectImpl getVirtualBookList_farsiCardVO1() {
        return (ViewObjectImpl)findViewObject("VirtualBookList_farsiCardVO1");
    }


    /**
     * Container's getter for ProviderKind.
     * @return ProviderKind
     */
    public ViewObjectImpl getProviderKind() {
        return (ViewObjectImpl)findViewObject("ProviderKind");
    }
}
