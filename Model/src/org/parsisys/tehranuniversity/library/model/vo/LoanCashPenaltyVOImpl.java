package org.parsisys.tehranuniversity.library.model.vo;

import java.sql.CallableStatement;

import java.sql.SQLException;

import oracle.jbo.JboException;
import oracle.jbo.server.DBTransaction;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.domain.Number;

//import org.parsisys.tehranuniversity.library.model.vo.common.LoanCashPenaltyVO;
import org.parsisys.tehranuniversity.library.util.ParsiUtil;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Mar 05 10:29:41 GMT+04:00 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class LoanCashPenaltyVOImpl extends ViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public LoanCashPenaltyVOImpl() {
    }
    //TODO: in the tigger public cash penalty I add the 
    // sequene seq_pub_cash_penalty_art_id.nextval to fill the art_id
   //	INSERT INTO loan_cash_penalty(VALUE,DAY_DATE,DESCRIPTION,LOAN_PENALTY_TYPE,LOAN_ART_ID,USER_NAME)
   // 		VALUES(:PENALTY_EDIT.VALUE,:INFO.DAY_DATE,:PENALTY_EDIT.desc,1,:LOAN.ART_ID,:INFO.USER_NAME);
   // 		UPDATE init_member SET debit_sum=NVL(debit_sum,0) + :PENALTY_EDIT.VALUE
   // 		WHERE art_id=:INIT_MEMBER.ART_ID;
   
//    public boolean insert_loanCashPenalty(Integer value,String description){
//       DBTransaction trans = getDBTransaction();
//       
//            CallableStatement statement = null;
//            int rows = 0;
//          Number mem_Artid= (Number)  ((LoanCashPenaltyVORowImpl)getCurrentRow()).getInitMemberVO().getAttribute("ArtId");
//            String plsql ="  INSERT INTO public_cash_penalty(VALUE,DAY_DATE,DESCRIPTION,MEM_ART_ID,USER_NAME)" +
//                "VALUES(?,"+Util.DateToNumber()+",?,"+mem_Artid.intValue() +","+(String)getDBTransaction().getSession().getUserData().get("username") +")";
//                 
//           
//            statement = trans.createCallableStatement(plsql, 2);
//            try {
//                statement.setInt(1, value);
//                statement.setString(2, description);
//         
//               rows = statement.executeUpdate();
//       //execute the update...
//       Number debit= (Number)((LoanCashPenaltyVORowImpl)getCurrentRow()).getInitMemberVO().getAttribute("DebitSum");
//       Number val= new Number(value.intValue());
//       ((LoanCashPenaltyVORowImpl)getCurrentRow()).getInitMemberVO().setAttribute("DebitSum",val.add(debit) );
//    //when every thin is finished..  
//    getDBTransaction().commit();
//                executeQuery();
//            } catch (SQLException s) {
//                System.err.println(s.getMessage()+this.getClass().getName());
//                return false;
//            } finally {
//                try {
//                    if (statement != null)
//                        statement.close();
//                    return true;
//                } catch (SQLException s) { /* ignore */
//                return false;
//                }
//        
//            }
//   //  return true;   
//    }
}