package org.parsisys.tehranuniversity.library.model.vo;

import oracle.jbo.Row;
import oracle.jbo.domain.DBSequence;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Dec 22 14:03:21 GMT+03:30 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class MemberSetUpVoRowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        Active {
            public Object get(MemberSetUpVoRowImpl obj) {
                return obj.getActive();
            }

            public void put(MemberSetUpVoRowImpl obj, Object value) {
                obj.setActive((Number)value);
            }
        }
        ,
        ArtId {
            public Object get(MemberSetUpVoRowImpl obj) {
                return obj.getArtId();
            }

            public void put(MemberSetUpVoRowImpl obj, Object value) {
                obj.setArtId((DBSequence)value);
            }
        }
        ,
        FromDate {
            public Object get(MemberSetUpVoRowImpl obj) {
                return obj.getFromDate();
            }

            public void put(MemberSetUpVoRowImpl obj, Object value) {
                obj.setFromDate((Number)value);
            }
        }
        ,
        Labcol {
            public Object get(MemberSetUpVoRowImpl obj) {
                return obj.getLabcol();
            }

            public void put(MemberSetUpVoRowImpl obj, Object value) {
                obj.setLabcol((Number)value);
            }
        }
        ,
        LoanDuration {
            public Object get(MemberSetUpVoRowImpl obj) {
                return obj.getLoanDuration();
            }

            public void put(MemberSetUpVoRowImpl obj, Object value) {
                obj.setLoanDuration((Number)value);
            }
        }
        ,
        LoanQuota {
            public Object get(MemberSetUpVoRowImpl obj) {
                return obj.getLoanQuota();
            }

            public void put(MemberSetUpVoRowImpl obj, Object value) {
                obj.setLoanQuota((Number)value);
            }
        }
        ,
        MemshipDuration {
            public Object get(MemberSetUpVoRowImpl obj) {
                return obj.getMemshipDuration();
            }

            public void put(MemberSetUpVoRowImpl obj, Object value) {
                obj.setMemshipDuration((Number)value);
            }
        }
        ,
        PloanQuota {
            public Object get(MemberSetUpVoRowImpl obj) {
                return obj.getPloanQuota();
            }

            public void put(MemberSetUpVoRowImpl obj, Object value) {
                obj.setPloanQuota((Number)value);
            }
        }
        ,
        Post {
            public Object get(MemberSetUpVoRowImpl obj) {
                return obj.getPost();
            }

            public void put(MemberSetUpVoRowImpl obj, Object value) {
                obj.setPost((Number)value);
            }
        }
        ,
        ReserveQuota {
            public Object get(MemberSetUpVoRowImpl obj) {
                return obj.getReserveQuota();
            }

            public void put(MemberSetUpVoRowImpl obj, Object value) {
                obj.setReserveQuota((Number)value);
            }
        }
        ,
        ToDate {
            public Object get(MemberSetUpVoRowImpl obj) {
                return obj.getToDate();
            }

            public void put(MemberSetUpVoRowImpl obj, Object value) {
                obj.setToDate((Number)value);
            }
        }
        ,
        CatalogDetailVO {
            public Object get(MemberSetUpVoRowImpl obj) {
                return obj.getCatalogDetailVO();
            }

            public void put(MemberSetUpVoRowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(MemberSetUpVoRowImpl object);

        public abstract void put(MemberSetUpVoRowImpl object, Object value);

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
    public static final int ACTIVE = AttributesEnum.Active.index();
    public static final int ARTID = AttributesEnum.ArtId.index();
    public static final int FROMDATE = AttributesEnum.FromDate.index();
    public static final int LABCOL = AttributesEnum.Labcol.index();
    public static final int LOANDURATION = AttributesEnum.LoanDuration.index();
    public static final int LOANQUOTA = AttributesEnum.LoanQuota.index();
    public static final int MEMSHIPDURATION = AttributesEnum.MemshipDuration.index();
    public static final int PLOANQUOTA = AttributesEnum.PloanQuota.index();
    public static final int POST = AttributesEnum.Post.index();
    public static final int RESERVEQUOTA = AttributesEnum.ReserveQuota.index();
    public static final int TODATE = AttributesEnum.ToDate.index();
    public static final int CATALOGDETAILVO = AttributesEnum.CatalogDetailVO.index();

    /**
     * This is the default constructor (do not remove).
     */
    public MemberSetUpVoRowImpl() {
    }

    /**
     * Gets MemberSetup entity object.
     * @return the MemberSetup
     */
    public EntityImpl getMemberSetup() {
        return (EntityImpl)getEntity(0);
    }

    /**
     * Gets the attribute value for ACTIVE using the alias name Active.
     * @return the ACTIVE
     */
    public Number getActive() {
        return (Number) getAttributeInternal(ACTIVE);
    }

    /**
     * Sets <code>value</code> as attribute value for ACTIVE using the alias name Active.
     * @param value value to set the ACTIVE
     */
    public void setActive(Number value) {
        setAttributeInternal(ACTIVE, value);
    }

    /**
     * Gets the attribute value for ART_ID using the alias name ArtId.
     * @return the ART_ID
     */
    public DBSequence getArtId() {
        return (DBSequence)getAttributeInternal(ARTID);
    }

    /**
     * Sets <code>value</code> as attribute value for ART_ID using the alias name ArtId.
     * @param value value to set the ART_ID
     */
    public void setArtId(DBSequence value) {
        setAttributeInternal(ARTID, value);
    }

    /**
     * Gets the attribute value for FROM_DATE using the alias name FromDate.
     * @return the FROM_DATE
     */
    public Number getFromDate() {
        return (Number) getAttributeInternal(FROMDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for FROM_DATE using the alias name FromDate.
     * @param value value to set the FROM_DATE
     */
    public void setFromDate(Number value) {
        setAttributeInternal(FROMDATE, value);
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
     * Gets the attribute value for LOAN_DURATION using the alias name LoanDuration.
     * @return the LOAN_DURATION
     */
    public Number getLoanDuration() {
        return (Number) getAttributeInternal(LOANDURATION);
    }

    /**
     * Sets <code>value</code> as attribute value for LOAN_DURATION using the alias name LoanDuration.
     * @param value value to set the LOAN_DURATION
     */
    public void setLoanDuration(Number value) {
        setAttributeInternal(LOANDURATION, value);
    }

    /**
     * Gets the attribute value for LOAN_QUOTA using the alias name LoanQuota.
     * @return the LOAN_QUOTA
     */
    public Number getLoanQuota() {
        return (Number) getAttributeInternal(LOANQUOTA);
    }

    /**
     * Sets <code>value</code> as attribute value for LOAN_QUOTA using the alias name LoanQuota.
     * @param value value to set the LOAN_QUOTA
     */
    public void setLoanQuota(Number value) {
        setAttributeInternal(LOANQUOTA, value);
    }

    /**
     * Gets the attribute value for MEMSHIP_DURATION using the alias name MemshipDuration.
     * @return the MEMSHIP_DURATION
     */
    public Number getMemshipDuration() {
        return (Number) getAttributeInternal(MEMSHIPDURATION);
    }

    /**
     * Sets <code>value</code> as attribute value for MEMSHIP_DURATION using the alias name MemshipDuration.
     * @param value value to set the MEMSHIP_DURATION
     */
    public void setMemshipDuration(Number value) {
        setAttributeInternal(MEMSHIPDURATION, value);
    }

    /**
     * Gets the attribute value for PLOAN_QUOTA using the alias name PloanQuota.
     * @return the PLOAN_QUOTA
     */
    public Number getPloanQuota() {
        return (Number) getAttributeInternal(PLOANQUOTA);
    }

    /**
     * Sets <code>value</code> as attribute value for PLOAN_QUOTA using the alias name PloanQuota.
     * @param value value to set the PLOAN_QUOTA
     */
    public void setPloanQuota(Number value) {
        setAttributeInternal(PLOANQUOTA, value);
    }

    /**
     * Gets the attribute value for POST using the alias name Post.
     * @return the POST
     */
    public Number getPost() {
        return (Number) getAttributeInternal(POST);
    }

    /**
     * Sets <code>value</code> as attribute value for POST using the alias name Post.
     * @param value value to set the POST
     */
    public void setPost(Number value) {
        setAttributeInternal(POST, value);
    }

    /**
     * Gets the attribute value for RESERVE_QUOTA using the alias name ReserveQuota.
     * @return the RESERVE_QUOTA
     */
    public Number getReserveQuota() {
        return (Number) getAttributeInternal(RESERVEQUOTA);
    }

    /**
     * Sets <code>value</code> as attribute value for RESERVE_QUOTA using the alias name ReserveQuota.
     * @param value value to set the RESERVE_QUOTA
     */
    public void setReserveQuota(Number value) {
        setAttributeInternal(RESERVEQUOTA, value);
    }

    /**
     * Gets the attribute value for TO_DATE using the alias name ToDate.
     * @return the TO_DATE
     */
    public Number getToDate() {
        return (Number) getAttributeInternal(TODATE);
    }

    /**
     * Sets <code>value</code> as attribute value for TO_DATE using the alias name ToDate.
     * @param value value to set the TO_DATE
     */
    public void setToDate(Number value) {
        setAttributeInternal(TODATE, value);
    }

    /**
     * Gets the associated <code>Row</code> using master-detail link CatalogDetailVO.
     */
    public Row getCatalogDetailVO() {
        return (Row)getAttributeInternal(CATALOGDETAILVO);
    }

    /**
     * Sets the master-detail link CatalogDetailVO between this object and <code>value</code>.
     */
    public void setCatalogDetailVO(Row value) {
        setAttributeInternal(CATALOGDETAILVO, value);
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
