package org.parsisys.tehranuniversity.library.view.beans;

import java.math.BigDecimal;

import java.util.Iterator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.adf.view.rich.event.DialogEvent;
import oracle.adf.view.rich.event.QueryEvent;

import oracle.adf.view.rich.event.QueryOperationEvent;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.RowSet;
import oracle.jbo.domain.Number;

import oracle.jbo.server.DBTransaction;

import oracle.jheadstart.util.DatabaseProcedure;

import org.parsisys.tehranuniversity.library.model.am.AppModuleImpl;

import org.parsisys.tehranuniversity.library.model.vo.InitMemberVORowImpl;
import org.parsisys.tehranuniversity.library.model.vo.LoanVORowImpl;
import org.parsisys.tehranuniversity.library.model.vo.PersonVORowImpl;
import org.parsisys.tehranuniversity.library.util.ParsiUtil;

import util.DBUtils;
import util.JSFUtils;

public class CID_LOAN_OLD {
    public CID_LOAN_OLD() {
    }
    String penal_day;
    String penal_month;
    int penalty;
    String holy_week;
    int penalty_offer;
    String penalty_desc;
    Number PERSON_LOAN_REMIND_CAP;
    public void search_person(QueryEvent queryOperationEvent){
        AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
        Number LABCOL=(Number)app.getSession().getUserData().get("labcolno");
             Number libartid=(Number)app.getSession().getUserData().get("libartid");
      invokeMethodExpression("#{bindings.searchbarcodeidQuery.processQuery}",

                                       Object.class, QueryEvent.class, queryOperationEvent);
        
        //variables...
        PersonVORowImpl pr= (PersonVORowImpl)JSFUtils.getCurrentRow("PersonVO1Iterator");
        
        Number PERS_TYPE =  pr.getPersType();
        Number PERS_CATEGORY =  pr.getPersCategory();
        Number PERSON_ART_ID =  pr.getArtId();
        String PERSON_BARCODE = pr.getBarcode();
        Number PERS_STATUS =  pr.getPersStatus();
        System.out.println("libartid:"+libartid);
        Number PERSON_LIB_ART_ID =  libartid;
        Number SEC_ART_ID =  pr.getSecArtId();
        Number DEPT_ART_ID =  pr.getDeptArtId();
        Number PERSON_DAY_DATE =  ParsiUtil.DateToNumber();
        Number LABCOL1 =  LABCOL;
        Number PKG_VARIABLE_LOAN_CAP = new Number(0);
         Number PKG_VARIABLE_PLACE_LOAN_CAP = new Number(0);
         //define procedure... 
        DatabaseProcedure call_init_person = DatabaseProcedure.define("PROCEDURE parsi_ut_lib.init_person( PERS_TYPE                    IN  NUMBER,\n" + 
        "     PERS_CATEGORY                IN  NUMBER,\n" + 
        "    PERSON_ART_ID                IN  NUMBER,\n" + 
        "    PERSON_BARCODE               IN  VARCHAR2,\n" + 
        "    PERS_STATUS                  IN  NUMBER,\n" + 
        "       PERSON_LIB_ART_ID            IN  NUMBER,\n" + 
        "        SEC_ART_ID                   IN  NUMBER,\n" + 
        "    DEPT_ART_ID                  IN  NUMBER,\n" + 
        "    PERSON_DAY_DATE              IN  NUMBER,\n" + 
        "    labcol1 IN NUMBER,\n" +
        " PKG_VAR_LOAN_CAP in out number,\n" + 
        "  PKG_VAR_PLACE_LOAN_CAP in out number,"+                                                              
        "    PERSON_CUR_LIB_LOAN_NUM      out  NUMBER,\n" + 
        "    PERSON_INIT_MEMBER_ART_ID    out  NUMBER,\n" + 
        "    PERSON_MEMSHIP_CAT           out  NUMBER,\n" + 
        "    PERSON_END_DATE              out  NUMBER,\n" + 
        "    PERSON_NEXT_RET_DATE         out  NUMBER,\n" + 
        "   \n" + 
        "    START_DATE                   out  NUMBER,\n" + 
        "    \n" + 
        "    PERSON_LOAN_REMIND_CAP       out  NUMBER,\n" + 
        "    LOAN_NUMBER                  out  NUMBER,\n" + 
        " \n" + 
        "    output_msg                   out  VARCHAR2,\n" + 
        "    PERSON_NON_CASH_PENALTY_TEXT out  VARCHAR2,\n" + 
        "   \n" + 
        "    PERSON_MEM_LOAN_DURITY       out  NUMBER,\n" + 
        "    PERSON_LOAN_PLACE_REMINDCAP  out  NUMBER,\n" + 
        "    \n" + 
        "    PERSON_PENALTY               out  NUMBER,\n" + 
        "    goto_loan OUT NUMBER,\n" + 
        "    \n" + 
        "    P_RASMI_MEM_FIRST_LOAN out number,\n" + 
        "    P_STUDY_AT_PLACE  out number,P_CAPACITY_IS_FULL out number,p_PLACE_CAP_IS_FULL out number)"); 
       
        DBTransaction connection =app.getDBTransaction(); 
         DatabaseProcedure.Result result = call_init_person.call(connection,PERS_TYPE,PERS_CATEGORY,PERSON_ART_ID,PERSON_BARCODE,PERS_STATUS,PERSON_LIB_ART_ID,SEC_ART_ID,DEPT_ART_ID,PERSON_DAY_DATE,LABCOL1,PKG_VARIABLE_LOAN_CAP,PKG_VARIABLE_PLACE_LOAN_CAP);
        Number PERSON_CUR_LIB_LOAN_NUM= ParsiUtil.convert_dec_to_number((BigDecimal) result.getOutputValue("PERSON_CUR_LIB_LOAN_NUM"));
        Number PERSON_INIT_MEMBER_ART_ID= ParsiUtil.convert_dec_to_number((BigDecimal) result.getOutputValue("PERSON_INIT_MEMBER_ART_ID"));
        Number PERSON_MEMSHIP_CAT= ParsiUtil.convert_dec_to_number((BigDecimal) result.getOutputValue("PERSON_MEMSHIP_CAT"));
        Number PERSON_END_DATE= ParsiUtil.convert_dec_to_number((BigDecimal) result.getOutputValue("PERSON_END_DATE"));
        Number PERSON_NEXT_RET_DATE= ParsiUtil.convert_dec_to_number((BigDecimal) result.getOutputValue("PERSON_NEXT_RET_DATE"));
        Number START_DATE= ParsiUtil.convert_dec_to_number((BigDecimal) result.getOutputValue("START_DATE"));
         PERSON_LOAN_REMIND_CAP= ParsiUtil.convert_dec_to_number((BigDecimal) result.getOutputValue("PERSON_LOAN_REMIND_CAP"));
        Number LOAN_NUMBER= ParsiUtil.convert_dec_to_number((BigDecimal) result.getOutputValue("LOAN_NUMBER"));
        String OUTPUT_MSG= (String) result.getOutputValue("OUTPUT_MSG");
        String PERSON_NON_CASH_PENALTY_TEXT= (String) result.getOutputValue("PERSON_NON_CASH_PENALTY_TEXT");
        Number PERSON_MEM_LOAN_DURITY= ParsiUtil.convert_dec_to_number((BigDecimal) result.getOutputValue("PERSON_MEM_LOAN_DURITY"));
        Number PERSON_LOAN_PLACE_REMINDCAP= ParsiUtil.convert_dec_to_number((BigDecimal) result.getOutputValue("PERSON_LOAN_PLACE_REMINDCAP"));
        Number PERSON_PENALTY= ParsiUtil.convert_dec_to_number((BigDecimal) result.getOutputValue("PERSON_PENALTY"));
        Number GOTO_LOAN= ParsiUtil.convert_dec_to_number((BigDecimal) result.getOutputValue("GOTO_LOAN"));
        Number P_RASMI_MEM_FIRST_LOAN= ParsiUtil.convert_dec_to_number((BigDecimal) result.getOutputValue("P_RASMI_MEM_FIRST_LOAN"));
        Number P_STUDY_AT_PLACE= ParsiUtil.convert_dec_to_number((BigDecimal) result.getOutputValue("P_STUDY_AT_PLACE"));
        Number P_CAPACITY_IS_FULL= ParsiUtil.convert_dec_to_number((BigDecimal) result.getOutputValue("P_CAPACITY_IS_FULL"));
        Number P_PLACE_CAP_IS_FULL= ParsiUtil.convert_dec_to_number((BigDecimal) result.getOutputValue("P_PLACE_CAP_IS_FULL"));
        PKG_VARIABLE_LOAN_CAP=ParsiUtil.convert_dec_to_number((BigDecimal) result.getOutputValue("PKG_VAR_LOAN_CAP"));
        PKG_VARIABLE_PLACE_LOAN_CAP=ParsiUtil.convert_dec_to_number((BigDecimal) result.getOutputValue("PKG_VAR_PLACE_LOAN_CAP"));
JSFUtils.addFacesErrorMessage(OUTPUT_MSG);
       
       
       //call the init_book
        //IN variables...    
        String LOAN_LIST_VOL_NO = "-1";
        String LOAN_LIST_PHBOOK_ART_ID = "-1";
        Number LOAN_LIST_VBOOK_ART_ID =  new Number(1);
        String LOAN_LIST_PART_NO = "-1";
        //Number PERSON_INIT_MEMBER_ART_ID =  new Number(1);
        Number LOAN_LIST_LOAN_STATUS =  new Number(1);
       // Number PERSON_MEM_LOAN_DURITY =  new Number(1);
        Number LOAN_LIST_EXISTENCE_STATUS =  new Number(1);
       // Number PERSON_DAY_DATE =  new Number(1);
       // Number LABCOL1 =  new Number(1);
        Number SHOW_POPUP_STUDY_AT_YES =  new Number(1);
         //define procedure... 
        DatabaseProcedure call_init_book = DatabaseProcedure.define("PROCEDURE parsi_ut_lib.init_book(     PKG_VARIABLE_PLACE_LOAN_CAP IN out NUMBER,     PKG_VARIABLE_LOAN_CAP       IN out NUMBER,     LOAN_LIST_VOL_NO        IN VARCHAR2,     LOAN_LIST_PHBOOK_ART_ID IN VARCHAR2,     LOAN_LIST_VBOOK_ART_ID    IN NUMBER,     LOAN_LIST_PART_NO         IN VARCHAR2,     PERSON_INIT_MEMBER_ART_ID IN NUMBER,     LOAN_LIST_LOAN_STATUS     IN NUMBER,     PERSON_MEM_LOAN_DURITY     IN NUMBER,     LOAN_LIST_EXISTENCE_STATUS IN NUMBER,     PERSON_DAY_DATE            IN NUMBER,      labcol1 IN NUMBER,      show_popup_STUDY_at_yes in NUMBER,     LOAN_LIST_PROVIDER OUT VARCHAR2,     LOAN_LIST_ALLOC OUT NUMBER,     LOAN_LIST_RET_DATE OUT NUMBER,         output_msg OUT VARCHAR2,     LOAN_LIST_LOAN_ALLOWED OUT NUMBER,     LOAN_LIST_YES_OR_NO        out NUMBER,          LOAN_LIST_LOAN_TYPE OUT NUMBER    )"); 
        //AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
         connection =app.getDBTransaction(); 
          result = call_init_book.call(connection,PKG_VARIABLE_PLACE_LOAN_CAP,PKG_VARIABLE_LOAN_CAP,LOAN_LIST_VOL_NO,LOAN_LIST_PHBOOK_ART_ID,LOAN_LIST_VBOOK_ART_ID,LOAN_LIST_PART_NO,PERSON_INIT_MEMBER_ART_ID,LOAN_LIST_LOAN_STATUS,PERSON_MEM_LOAN_DURITY,LOAN_LIST_EXISTENCE_STATUS,PERSON_DAY_DATE,LABCOL1,SHOW_POPUP_STUDY_AT_YES);
        // OUT variable...Number PKG_VARIABLE_PLACE_LOAN_CAP= ParsiUtil.convert_dec_to_number((BigDecimal) result.getOutputValue("PKG_VARIABLE_PLACE_LOAN_CAP"));
         PKG_VARIABLE_LOAN_CAP= ParsiUtil.convert_dec_to_number((BigDecimal) result.getOutputValue("PKG_VARIABLE_LOAN_CAP"));
        String LOAN_LIST_PROVIDER= (String) result.getOutputValue("LOAN_LIST_PROVIDER");
        Number LOAN_LIST_ALLOC= ParsiUtil.convert_dec_to_number((BigDecimal) result.getOutputValue("LOAN_LIST_ALLOC"));
        Number LOAN_LIST_RET_DATE= ParsiUtil.convert_dec_to_number((BigDecimal) result.getOutputValue("LOAN_LIST_RET_DATE"));
         OUTPUT_MSG= (String) result.getOutputValue("OUTPUT_MSG");
        Number LOAN_LIST_LOAN_ALLOWED= ParsiUtil.convert_dec_to_number((BigDecimal) result.getOutputValue("LOAN_LIST_LOAN_ALLOWED"));
        Number LOAN_LIST_YES_OR_NO= ParsiUtil.convert_dec_to_number((BigDecimal) result.getOutputValue("LOAN_LIST_YES_OR_NO"));

JSFUtils.addFacesErrorMessage(OUTPUT_MSG);
    }
    private Object invokeMethodExpression(String expr, Class returnType,

                                              Class argType, Object argument) {

            return JSFUtils.invokeMethodExpression(expr, returnType,

                                          new Class[] { argType },

                                          new Object[] { argument });

        }
//    public void tamdid(ValueChangeEvent valueChangeEvent) {
//        // Add event code here...
//        LoanVORowImpl loanRow = (LoanVORowImpl)JSFUtils.getCurrentRow("LoanVO_CID_LOANIterator");
//               // if (valueChangeEvent.getNewValue()) {
//           DatabaseProcedure call_UT_LIB_cid_loan_checkbox =DatabaseProcedure.define("PROCEDURE parsi_ut_lib.cid_loan_checkbox(LIB_ART_ID in number,barcode in varchar2,show_popup_penalty out number,labcol_in in number,DELAY_DAY IN OUT VARCHAR2,EXTEND_LIST_RET_DATE IN OUT number,PERSON_INIT_MEMBER_ART_ID IN OUT number,EXTEND_LIST_LOAN_STATUS IN OUT number,EXTEND_LIST_PENALTY IN OUT number,DELAY_MONTH IN OUT VARCHAR2,EXTEND_LIST_PART_NO IN OUT VARCHAR2,EXTEND_LIST_HOLY_WEEK IN OUT VARCHAR2,output_msg IN OUT VARCHAR2,EXTEND_LIST_PENALTY_OFFER IN OUT number,EXTEND_LIST_VOL_NO IN OUT VARCHAR2,EXTEND_LIST_ART_ID IN OUT number,EXTEND_LIST_NEXT_RET_DATE IN OUT VARCHAR2,EXTEND_LIST_YES_OR_NO IN OUT Number,EXTEND_LIST_VBOOK_ART_ID IN OUT number,PERSON_DAY_DATE IN OUT number,EXTEND_LIST_EXISTENCE_STATUS IN OUT Number)");
//        String DELAY_DAY="-1";
//        Number EXTEND_LIST_RET_DATE=loanRow.getRetDate();
//        Number PERSON_INIT_MEMBER_ART_ID=loanRow.getMemArtId();
//        Number SHOW_POPUP_PENALTY=new Number(0);
//          
//        Number EXTEND_LIST_LOAN_STATUS=loanRow.getLoanStatus();
//        Number EXTEND_LIST_PENALTY=new Number(0);
//        String DELAY_MONTH="-1";
//        String EXTEND_LIST_PART_NO=loanRow.getPartNo();
//        String EXTEND_LIST_HOLY_WEEK="-1";
//        String output_msg="-1";
//        Number EXTEND_LIST_PENALTY_OFFER=new Number(0);
//        String EXTEND_LIST_VOL_NO=loanRow.getVolNo();
//
//        Number EXTEND_LIST_ART_ID=loanRow.getArtId();
//       String barcode=(String)((InitMemberVORowImpl)loanRow.getInitMemberVO()).getPersonVO().getAttribute("Barcode");
//        String EXTEND_LIST_NEXT_RET_DATE="-1";
//        Number EXTEND_LIST_YES_OR_NO=(((Boolean)valueChangeEvent.getNewValue()) == true?new Number(1):new Number(0));
//        Number EXTEND_LIST_VBOOK_ART_ID=loanRow.getVbookArtId();
//        Number PERSON_DAY_DATE=ParsiUtil.DateToNumber();
//        Number EXTEND_LIST_EXISTENCE_STATUS=loanRow.getExistenceStatus();
//     AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
//Number     LABCOL=(Number)app.getSession().getUserData().get("labcolno");
//      Number libartid=(Number)app.getSession().getUserData().get("libartid");
//      DBTransaction connection =app.getDBTransaction(); 
//      
//        DatabaseProcedure.Result result = call_UT_LIB_cid_loan_checkbox.call(connection,libartid,barcode,SHOW_POPUP_PENALTY,LABCOL,DELAY_DAY, EXTEND_LIST_RET_DATE,PERSON_INIT_MEMBER_ART_ID,EXTEND_LIST_LOAN_STATUS,EXTEND_LIST_PENALTY,DELAY_MONTH,EXTEND_LIST_PART_NO,EXTEND_LIST_HOLY_WEEK,output_msg,EXTEND_LIST_PENALTY_OFFER,EXTEND_LIST_VOL_NO,EXTEND_LIST_ART_ID,EXTEND_LIST_NEXT_RET_DATE,EXTEND_LIST_YES_OR_NO,EXTEND_LIST_VBOOK_ART_ID,PERSON_DAY_DATE,EXTEND_LIST_EXISTENCE_STATUS);
//       
//       
//        DELAY_DAY =(String) result.getOutputValue("DELAY_DAY");
//        DELAY_MONTH =(String) result.getOutputValue("DELAY_MONTH");
//        SHOW_POPUP_PENALTY =ParsiUtil.convert_dec_to_number((BigDecimal) result.getOutputValue("SHOW_POPUP_PENALTY"));
//           
//        EXTEND_LIST_HOLY_WEEK =(String) result.getOutputValue("EXTEND_LIST_HOLY_WEEK");
//        output_msg =(String) result.getOutputValue("output_msg");
//        EXTEND_LIST_PENALTY_OFFER =ParsiUtil.convert_dec_to_number((BigDecimal) result.getOutputValue("EXTEND_LIST_PENALTY_OFFER"));
//        EXTEND_LIST_PENALTY =ParsiUtil.convert_dec_to_number((BigDecimal) result.getOutputValue("EXTEND_LIST_PENALTY"));
//        EXTEND_LIST_NEXT_RET_DATE =(String) result.getOutputValue("EXTEND_LIST_NEXT_RET_DATE");
//        EXTEND_LIST_YES_OR_NO =ParsiUtil.convert_dec_to_number((BigDecimal) result.getOutputValue("EXTEND_LIST_YES_OR_NO"));
//this.setHoly_week(EXTEND_LIST_HOLY_WEEK);
//this.setPenal_day(DELAY_DAY);
//this.setPenal_month(DELAY_MONTH);
//this.setPenalty(EXTEND_LIST_PENALTY.intValue());
//this.setPenalty_offer(EXTEND_LIST_PENALTY_OFFER.intValue());
//loanRow.setnextRetDate(EXTEND_LIST_NEXT_RET_DATE);
//loanRow.settamdid(EXTEND_LIST_YES_OR_NO.equals(new Number(1)));
//if(SHOW_POPUP_PENALTY.equals(new Number(1)) || true){
// //System.out.println("before popup...");
////  AdfFacesContext.getCurrentInstance().addPartialTarget(
////                                  findComponentInRoot("penalty"));
//  JSFUtils.showPopup("pt1:penalty");
//  JSFUtils.addFacesErrorMessage(output_msg);
//}
//    }
  public static UIComponent findComponentInRoot(String id) {
          UIComponent component = null;
          FacesContext facesContext = FacesContext.getCurrentInstance();
          if (facesContext != null) {
              UIComponent root = facesContext.getViewRoot();
              component = findComponent(root, id);
          }
          return component;
      }
  public static UIComponent findComponent(UIComponent base, String id) {
          if (id.equals(base.getId()))
              return base;
   
          UIComponent children = null;
          UIComponent result = null;
          Iterator childrens = base.getFacetsAndChildren();
          while (childrens.hasNext() && (result == null)) {
              children = (UIComponent)childrens.next();
              if (id.equals(children.getId())) {
                  result = children;
                  break;
              }
              result = findComponent(children, id);
              if (result != null) {
                  break;
              }
          }
          return result;
      }
    public void setPenal_day(String penal_day) {
        this.penal_day = penal_day;
    }

    public String getPenal_day() {
        //System.out.println("get penal day.."+penal_day);
        return penal_day;
    }

  

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

    public int getPenalty() {
        return penalty;
    }

    public void setHoly_week(String holy_week) {
        this.holy_week = holy_week;
    }

    public String getHoly_week() {
        return holy_week;
    }

    public void setPenalty_offer(int penalty_offer) {
        this.penalty_offer = penalty_offer;
    }

    public int getPenalty_offer() {
        return penalty_offer;
    }

    public void setPenalty_desc(String penalty_desc) {
        this.penalty_desc = penalty_desc;
    }

    public String getPenalty_desc() {
        return penalty_desc;
    }

    public void setPenal_month(String penal_month) {
        this.penal_month = penal_month;
    }

    public String getPenal_month() {
        return penal_month;
    }

    public String cancel_penalty() {
        // Add event code here...
        penalty=0;
        return null;
    }

    public void setPERSON_LOAN_REMIND_CAP(Number PERSON_LOAN_REMIND_CAP) {
        this.PERSON_LOAN_REMIND_CAP = PERSON_LOAN_REMIND_CAP;
    }

    public Number getPERSON_LOAN_REMIND_CAP() {
        return PERSON_LOAN_REMIND_CAP;
    }

    public String register_penalty() {
     if(penalty>0)
        JSFUtils.showPopup("pt1:reg_pen");
        return null;
    }

    public void register_penalty_ok(DialogEvent dialogEvent) {
      penalty=0;
            JSFUtils.getCurrentRow("LoanVO_CID_LOANIterator").setAttribute("tamdid", new Number(0));
            
    }
}
