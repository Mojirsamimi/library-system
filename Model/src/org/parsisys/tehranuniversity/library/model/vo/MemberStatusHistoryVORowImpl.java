package org.parsisys.tehranuniversity.library.model.vo;

import oracle.jbo.Row;
import oracle.jbo.domain.DBSequence;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;

import org.parsisys.tehranuniversity.library.model.eo.MemberStatusHistoryImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Mar 12 17:06:46 GMT+03:30 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class MemberStatusHistoryVORowImpl extends ViewRowImpl {
   

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        ArtId {
            public Object get(MemberStatusHistoryVORowImpl obj) {
                return obj.getArtId();
            }

            public void put(MemberStatusHistoryVORowImpl obj, Object value) {
                obj.setArtId((Number)value);
            }
        }
        ,
        DayDate {
            public Object get(MemberStatusHistoryVORowImpl obj) {
                return obj.getDayDate();
            }

            public void put(MemberStatusHistoryVORowImpl obj, Object value) {
                obj.setDayDate((Number)value);
            }
        }
        ,
        IntmemArtId {
            public Object get(MemberStatusHistoryVORowImpl obj) {
                return obj.getIntmemArtId();
            }

            public void put(MemberStatusHistoryVORowImpl obj, Object value) {
                obj.setIntmemArtId((Number)value);
            }
        }
        ,
        LibArtId {
            public Object get(MemberStatusHistoryVORowImpl obj) {
                return obj.getLibArtId();
            }

            public void put(MemberStatusHistoryVORowImpl obj, Object value) {
                obj.setLibArtId((Number)value);
            }
        }
        ,
        Reason {
            public Object get(MemberStatusHistoryVORowImpl obj) {
                return obj.getReason();
            }

            public void put(MemberStatusHistoryVORowImpl obj, Object value) {
                obj.setReason((String)value);
            }
        }
        ,
        Status {
            public Object get(MemberStatusHistoryVORowImpl obj) {
                return obj.getStatus();
            }

            public void put(MemberStatusHistoryVORowImpl obj, Object value) {
                obj.setStatus((Number)value);
            }
        }
        ,
        StatusEndDate {
            public Object get(MemberStatusHistoryVORowImpl obj) {
                return obj.getStatusEndDate();
            }

            public void put(MemberStatusHistoryVORowImpl obj, Object value) {
                obj.setStatusEndDate((Number)value);
            }
        }
        ,
        UserName {
            public Object get(MemberStatusHistoryVORowImpl obj) {
                return obj.getUserName();
            }

            public void put(MemberStatusHistoryVORowImpl obj, Object value) {
                obj.setUserName((String)value);
            }
        }
        ,
        StatusText {
            public Object get(MemberStatusHistoryVORowImpl obj) {
                return obj.getStatusText();
            }

            public void put(MemberStatusHistoryVORowImpl obj, Object value) {
                obj.setStatusText((String)value);
            }
        }
        ,
        LibName {
            public Object get(MemberStatusHistoryVORowImpl obj) {
                return obj.getLibName();
            }

            public void put(MemberStatusHistoryVORowImpl obj, Object value) {
                obj.setLibName((String)value);
            }
        }
        ,
        ArtId1 {
            public Object get(MemberStatusHistoryVORowImpl obj) {
                return obj.getArtId1();
            }

            public void put(MemberStatusHistoryVORowImpl obj, Object value) {
                obj.setArtId1((Number)value);
            }
        }
        ,
        InitMemberVO {
            public Object get(MemberStatusHistoryVORowImpl obj) {
                return obj.getInitMemberVO();
            }

            public void put(MemberStatusHistoryVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(MemberStatusHistoryVORowImpl object);

        public abstract void put(MemberStatusHistoryVORowImpl object,
                                 Object value);

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

    public static final int ARTID = AttributesEnum.ArtId.index();
    public static final int DAYDATE = AttributesEnum.DayDate.index();
    public static final int INTMEMARTID = AttributesEnum.IntmemArtId.index();
    public static final int LIBARTID = AttributesEnum.LibArtId.index();
    public static final int REASON = AttributesEnum.Reason.index();
    public static final int STATUS = AttributesEnum.Status.index();
    public static final int STATUSENDDATE = AttributesEnum.StatusEndDate.index();
    public static final int USERNAME = AttributesEnum.UserName.index();
    public static final int STATUSTEXT = AttributesEnum.StatusText.index();
    public static final int LIBNAME = AttributesEnum.LibName.index();
    public static final int ARTID1 = AttributesEnum.ArtId1.index();
    public static final int INITMEMBERVO = AttributesEnum.InitMemberVO.index();

    /**
     * This is the default constructor (do not remove).
     */
    public MemberStatusHistoryVORowImpl() {
    }

    /**
     * Gets MemberStatusHistory entity object.
     * @return the MemberStatusHistory
     */
    public MemberStatusHistoryImpl getMemberStatusHistory() {
        return (MemberStatusHistoryImpl)getEntity(0);
    }

    /**
     * Gets Library entity object.
     * @return the Library
     */
    public EntityImpl getLibrary() {
        return (EntityImpl)getEntity(1);
    }

    /**
     * Gets the attribute value for ART_ID using the alias name ArtId.
     * @return the ART_ID
     */
    public Number getArtId() {
        return (Number)getAttributeInternal(ARTID);
    }

    /**
     * Sets <code>value</code> as attribute value for ART_ID using the alias name ArtId.
     * @param value value to set the ART_ID
     */
    public void setArtId(Number value) {
        setAttributeInternal(ARTID, value);
    }

    /**
     * Gets the attribute value for DAY_DATE using the alias name DayDate.
     * @return the DAY_DATE
     */
    public Number getDayDate() {
        return (Number) getAttributeInternal(DAYDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for DAY_DATE using the alias name DayDate.
     * @param value value to set the DAY_DATE
     */
    public void setDayDate(Number value) {
        setAttributeInternal(DAYDATE, value);
    }

    /**
     * Gets the attribute value for INTMEM_ART_ID using the alias name IntmemArtId.
     * @return the INTMEM_ART_ID
     */
    public Number getIntmemArtId() {
        return (Number) getAttributeInternal(INTMEMARTID);
    }

    /**
     * Sets <code>value</code> as attribute value for INTMEM_ART_ID using the alias name IntmemArtId.
     * @param value value to set the INTMEM_ART_ID
     */
    public void setIntmemArtId(Number value) {
        setAttributeInternal(INTMEMARTID, value);
    }

    /**
     * Gets the attribute value for LIB_ART_ID using the alias name LibArtId.
     * @return the LIB_ART_ID
     */
    public Number getLibArtId() {
        return (Number) getAttributeInternal(LIBARTID);
    }

    /**
     * Sets <code>value</code> as attribute value for LIB_ART_ID using the alias name LibArtId.
     * @param value value to set the LIB_ART_ID
     */
    public void setLibArtId(Number value) {
        setAttributeInternal(LIBARTID, value);
    }

    /**
     * Gets the attribute value for REASON using the alias name Reason.
     * @return the REASON
     */
    public String getReason() {
        return (String) getAttributeInternal(REASON);
    }

    /**
     * Sets <code>value</code> as attribute value for REASON using the alias name Reason.
     * @param value value to set the REASON
     */
    public void setReason(String value) {
        setAttributeInternal(REASON, value);
    }

    /**
     * Gets the attribute value for STATUS using the alias name Status.
     * @return the STATUS
     */
    public Number getStatus() {
        return (Number) getAttributeInternal(STATUS);
    }

    /**
     * Sets <code>value</code> as attribute value for STATUS using the alias name Status.
     * @param value value to set the STATUS
     */
    public void setStatus(Number value) {
        setAttributeInternal(STATUS, value);
    }

    /**
     * Gets the attribute value for STATUS_END_DATE using the alias name StatusEndDate.
     * @return the STATUS_END_DATE
     */
    public Number getStatusEndDate() {
        return (Number) getAttributeInternal(STATUSENDDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for STATUS_END_DATE using the alias name StatusEndDate.
     * @param value value to set the STATUS_END_DATE
     */
    public void setStatusEndDate(Number value) {
        setAttributeInternal(STATUSENDDATE, value);
    }

    /**
     * Gets the attribute value for USER_NAME using the alias name UserName.
     * @return the USER_NAME
     */
    public String getUserName() {
        return (String) getAttributeInternal(USERNAME);
    }

    /**
     * Sets <code>value</code> as attribute value for USER_NAME using the alias name UserName.
     * @param value value to set the USER_NAME
     */
    public void setUserName(String value) {
        setAttributeInternal(USERNAME, value);
    }

    /**
     * Gets the attribute value for the calculated attribute StatusText.
     * @return the StatusText
     */
    public String getStatusText() {
        return (String) getAttributeInternal(STATUSTEXT);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute StatusText.
     * @param value value to set the  StatusText
     */
    public void setStatusText(String value) {
        setAttributeInternal(STATUSTEXT, value);
    }

    /**
     * Gets the attribute value for LIB_NAME using the alias name LibName.
     * @return the LIB_NAME
     */
    public String getLibName() {
        return (String) getAttributeInternal(LIBNAME);
    }

    /**
     * Sets <code>value</code> as attribute value for LIB_NAME using the alias name LibName.
     * @param value value to set the LIB_NAME
     */
    public void setLibName(String value) {
        setAttributeInternal(LIBNAME, value);
    }

    /**
     * Gets the attribute value for ART_ID using the alias name ArtId1.
     * @return the ART_ID
     */
    public Number getArtId1() {
        return (Number) getAttributeInternal(ARTID1);
    }

    /**
     * Sets <code>value</code> as attribute value for ART_ID using the alias name ArtId1.
     * @param value value to set the ART_ID
     */
    public void setArtId1(Number value) {
        setAttributeInternal(ARTID1, value);
    }

    /**
     * Gets the associated <code>Row</code> using master-detail link InitMemberVO.
     */
    public Row getInitMemberVO() {
        return (Row)getAttributeInternal(INITMEMBERVO);
    }

    /**
     * Sets the master-detail link InitMemberVO between this object and <code>value</code>.
     */
    public void setInitMemberVO(Row value) {
        setAttributeInternal(INITMEMBERVO, value);
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