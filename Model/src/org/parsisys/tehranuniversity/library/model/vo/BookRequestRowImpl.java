package org.parsisys.tehranuniversity.library.model.vo;

import fadak.base.TemplateViewRow;

import oracle.jbo.Row;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;

import org.parsisys.tehranuniversity.library.model.eo.BookRequestImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Oct 01 15:45:17 GMT+03:30 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class BookRequestRowImpl extends TemplateViewRow {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        Labcol {
            public Object get(BookRequestRowImpl obj) {
                return obj.getLabcol();
            }

            public void put(BookRequestRowImpl obj, Object value) {
                obj.setLabcol((Number)value);
            }
        }
        ,
        Barcode {
            public Object get(BookRequestRowImpl obj) {
                return obj.getBarcode();
            }

            public void put(BookRequestRowImpl obj, Object value) {
                obj.setBarcode((String)value);
            }
        }
        ,
        Serial {
            public Object get(BookRequestRowImpl obj) {
                return obj.getSerial();
            }

            public void put(BookRequestRowImpl obj, Object value) {
                obj.setSerial((Number)value);
            }
        }
        ,
        ReqNo {
            public Object get(BookRequestRowImpl obj) {
                return obj.getReqNo();
            }

            public void put(BookRequestRowImpl obj, Object value) {
                obj.setReqNo((String)value);
            }
        }
        ,
        CallNo {
            public Object get(BookRequestRowImpl obj) {
                return obj.getCallNo();
            }

            public void put(BookRequestRowImpl obj, Object value) {
                obj.setCallNo((String)value);
            }
        }
        ,
        CustStat {
            public Object get(BookRequestRowImpl obj) {
                return obj.getCustStat();
            }

            public void put(BookRequestRowImpl obj, Object value) {
                obj.setCustStat((String)value);
            }
        }
        ,
        Fname {
            public Object get(BookRequestRowImpl obj) {
                return obj.getFname();
            }

            public void put(BookRequestRowImpl obj, Object value) {
                obj.setFname((String)value);
            }
        }
        ,
        Lname {
            public Object get(BookRequestRowImpl obj) {
                return obj.getLname();
            }

            public void put(BookRequestRowImpl obj, Object value) {
                obj.setLname((String)value);
            }
        }
        ,
        LoadStat {
            public Object get(BookRequestRowImpl obj) {
                return obj.getLoadStat();
            }

            public void put(BookRequestRowImpl obj, Object value) {
                obj.setLoadStat((String)value);
            }
        }
        ,
        LoanStat {
            public Object get(BookRequestRowImpl obj) {
                return obj.getLoanStat();
            }

            public void put(BookRequestRowImpl obj, Object value) {
                obj.setLoanStat((String)value);
            }
        }
        ,
        Place {
            public Object get(BookRequestRowImpl obj) {
                return obj.getPlace();
            }

            public void put(BookRequestRowImpl obj, Object value) {
                obj.setPlace((Number)value);
            }
        }
        ,
        ReqDate {
            public Object get(BookRequestRowImpl obj) {
                return obj.getReqDate();
            }

            public void put(BookRequestRowImpl obj, Object value) {
                obj.setReqDate((String)value);
            }
        }
        ,
        VolNo {
            public Object get(BookRequestRowImpl obj) {
                return obj.getVolNo();
            }

            public void put(BookRequestRowImpl obj, Object value) {
                obj.setVolNo((String)value);
            }
        }
        ,
        RoSpcLovVO {
            public Object get(BookRequestRowImpl obj) {
                return obj.getRoSpcLovVO();
            }

            public void put(BookRequestRowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(BookRequestRowImpl object);

        public abstract void put(BookRequestRowImpl object, Object value);

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int LABCOL = AttributesEnum.Labcol.index();
    public static final int BARCODE = AttributesEnum.Barcode.index();
    public static final int SERIAL = AttributesEnum.Serial.index();
    public static final int REQNO = AttributesEnum.ReqNo.index();
    public static final int CALLNO = AttributesEnum.CallNo.index();
    public static final int CUSTSTAT = AttributesEnum.CustStat.index();
    public static final int FNAME = AttributesEnum.Fname.index();
    public static final int LNAME = AttributesEnum.Lname.index();
    public static final int LOADSTAT = AttributesEnum.LoadStat.index();
    public static final int LOANSTAT = AttributesEnum.LoanStat.index();
    public static final int PLACE = AttributesEnum.Place.index();
    public static final int REQDATE = AttributesEnum.ReqDate.index();
    public static final int VOLNO = AttributesEnum.VolNo.index();
    public static final int ROSPCLOVVO = AttributesEnum.RoSpcLovVO.index();

    /**
     * This is the default constructor (do not remove).
     */
    public BookRequestRowImpl() {
    }

    /**
     * Gets BookRequest entity object.
     * @return the BookRequest
     */
    public BookRequestImpl getBookRequest() {
        return (BookRequestImpl)getEntity(0);
    }

    /**
     * Gets the attribute value for LABCOL using the alias name Labcol.
     * @return the LABCOL
     */
    public Number getLabcol() {
        return (Number) getAttributeInternal(LABCOL);
    }

    /**
     * Sets <code>value</code> as attribute value for LABCOL using the alias name Labcol.
     * @param value value to set the LABCOL
     */
    public void setLabcol(Number value) {
        setAttributeInternal(LABCOL, value);
    }

    /**
     * Gets the attribute value for BARCODE using the alias name Barcode.
     * @return the BARCODE
     */
    public String getBarcode() {
        return (String) getAttributeInternal(BARCODE);
    }

    /**
     * Sets <code>value</code> as attribute value for BARCODE using the alias name Barcode.
     * @param value value to set the BARCODE
     */
    public void setBarcode(String value) {
        setAttributeInternal(BARCODE, value);
    }

    /**
     * Gets the attribute value for SERIAL using the alias name Serial.
     * @return the SERIAL
     */
    public Number getSerial() {
        return (Number) getAttributeInternal(SERIAL);
    }

    /**
     * Sets <code>value</code> as attribute value for SERIAL using the alias name Serial.
     * @param value value to set the SERIAL
     */
    public void setSerial(Number value) {
        setAttributeInternal(SERIAL, value);
    }

    /**
     * Gets the attribute value for REQ_NO using the alias name ReqNo.
     * @return the REQ_NO
     */
    public String getReqNo() {
        return (String) getAttributeInternal(REQNO);
    }

    /**
     * Sets <code>value</code> as attribute value for REQ_NO using the alias name ReqNo.
     * @param value value to set the REQ_NO
     */
    public void setReqNo(String value) {
        setAttributeInternal(REQNO, value);
    }

    /**
     * Gets the attribute value for CALL_NO using the alias name CallNo.
     * @return the CALL_NO
     */
    public String getCallNo() {
        return (String) getAttributeInternal(CALLNO);
    }

    /**
     * Sets <code>value</code> as attribute value for CALL_NO using the alias name CallNo.
     * @param value value to set the CALL_NO
     */
    public void setCallNo(String value) {
        setAttributeInternal(CALLNO, value);
    }

    /**
     * Gets the attribute value for CUST_STAT using the alias name CustStat.
     * @return the CUST_STAT
     */
    public String getCustStat() {
        return (String) getAttributeInternal(CUSTSTAT);
    }

    /**
     * Sets <code>value</code> as attribute value for CUST_STAT using the alias name CustStat.
     * @param value value to set the CUST_STAT
     */
    public void setCustStat(String value) {
        setAttributeInternal(CUSTSTAT, value);
    }

    /**
     * Gets the attribute value for FNAME using the alias name Fname.
     * @return the FNAME
     */
    public String getFname() {
        return (String) getAttributeInternal(FNAME);
    }

    /**
     * Sets <code>value</code> as attribute value for FNAME using the alias name Fname.
     * @param value value to set the FNAME
     */
    public void setFname(String value) {
        setAttributeInternal(FNAME, value);
    }

    /**
     * Gets the attribute value for LNAME using the alias name Lname.
     * @return the LNAME
     */
    public String getLname() {
        return (String) getAttributeInternal(LNAME);
    }

    /**
     * Sets <code>value</code> as attribute value for LNAME using the alias name Lname.
     * @param value value to set the LNAME
     */
    public void setLname(String value) {
        setAttributeInternal(LNAME, value);
    }

    /**
     * Gets the attribute value for LOAD_STAT using the alias name LoadStat.
     * @return the LOAD_STAT
     */
    public String getLoadStat() {
        return (String) getAttributeInternal(LOADSTAT);
    }

    /**
     * Sets <code>value</code> as attribute value for LOAD_STAT using the alias name LoadStat.
     * @param value value to set the LOAD_STAT
     */
    public void setLoadStat(String value) {
        setAttributeInternal(LOADSTAT, value);
    }

    /**
     * Gets the attribute value for LOAN_STAT using the alias name LoanStat.
     * @return the LOAN_STAT
     */
    public String getLoanStat() {
        return (String) getAttributeInternal(LOANSTAT);
    }

    /**
     * Sets <code>value</code> as attribute value for LOAN_STAT using the alias name LoanStat.
     * @param value value to set the LOAN_STAT
     */
    public void setLoanStat(String value) {
        setAttributeInternal(LOANSTAT, value);
    }

    /**
     * Gets the attribute value for PLACE using the alias name Place.
     * @return the PLACE
     */
    public Number getPlace() {
        return (Number) getAttributeInternal(PLACE);
    }

    /**
     * Sets <code>value</code> as attribute value for PLACE using the alias name Place.
     * @param value value to set the PLACE
     */
    public void setPlace(Number value) {
        setAttributeInternal(PLACE, value);
    }

    /**
     * Gets the attribute value for REQ_DATE using the alias name ReqDate.
     * @return the REQ_DATE
     */
    public String getReqDate() {
        return (String) getAttributeInternal(REQDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for REQ_DATE using the alias name ReqDate.
     * @param value value to set the REQ_DATE
     */
    public void setReqDate(String value) {
        setAttributeInternal(REQDATE, value);
    }

    /**
     * Gets the attribute value for VOL_NO using the alias name VolNo.
     * @return the VOL_NO
     */
    public String getVolNo() {
        return (String) getAttributeInternal(VOLNO);
    }

    /**
     * Sets <code>value</code> as attribute value for VOL_NO using the alias name VolNo.
     * @param value value to set the VOL_NO
     */
    public void setVolNo(String value) {
        setAttributeInternal(VOLNO, value);
    }

    /**
     * Gets the associated <code>Row</code> using master-detail link RoSpcLovVO.
     */
    public Row getRoSpcLovVO() {
        return (Row)getAttributeInternal(ROSPCLOVVO);
    }

    /**
     * Sets the master-detail link RoSpcLovVO between this object and <code>value</code>.
     */
    public void setRoSpcLovVO(Row value) {
        setAttributeInternal(ROSPCLOVVO, value);
    }

    /**
     * getAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param attrDef the attribute

     * @return the attribute value
     * @throws Exception
     */
    protected Object getAttrInvokeAccessor(int index,
                                           AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            return AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].get(this);
        }
        return super.getAttrInvokeAccessor(index, attrDef);
    }

    /**
     * setAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param value the value to assign to the attribute
     * @param attrDef the attribute

     * @throws Exception
     */
    protected void setAttrInvokeAccessor(int index, Object value,
                                         AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].put(this, value);
            return;
        }
        super.setAttrInvokeAccessor(index, value, attrDef);
    }
}