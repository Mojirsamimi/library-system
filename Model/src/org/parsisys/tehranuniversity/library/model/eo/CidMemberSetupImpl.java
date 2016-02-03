package org.parsisys.tehranuniversity.library.model.eo;

import fadak.base.TemplateEntityObject;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Jan 21 15:11:38 GMT+04:00 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CidMemberSetupImpl extends TemplateEntityObject {
    private static EntityDefImpl mDefinitionObject;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        Post {
            public Object get(CidMemberSetupImpl obj) {
                return obj.getPost();
            }

            public void put(CidMemberSetupImpl obj, Object value) {
                obj.setPost((Number)value);
            }
        }
        ,
        ClibLoanQuota {
            public Object get(CidMemberSetupImpl obj) {
                return obj.getClibLoanQuota();
            }

            public void put(CidMemberSetupImpl obj, Object value) {
                obj.setClibLoanQuota((Number)value);
            }
        }
        ,
        LocLoanQuota {
            public Object get(CidMemberSetupImpl obj) {
                return obj.getLocLoanQuota();
            }

            public void put(CidMemberSetupImpl obj, Object value) {
                obj.setLocLoanQuota((Number)value);
            }
        }
        ,
        IlibLoanQuota {
            public Object get(CidMemberSetupImpl obj) {
                return obj.getIlibLoanQuota();
            }

            public void put(CidMemberSetupImpl obj, Object value) {
                obj.setIlibLoanQuota((Number)value);
            }
        }
        ,
        Active {
            public Object get(CidMemberSetupImpl obj) {
                return obj.getActive();
            }

            public void put(CidMemberSetupImpl obj, Object value) {
                obj.setActive((Number)value);
            }
        }
        ,
        ArtId {
            public Object get(CidMemberSetupImpl obj) {
                return obj.getArtId();
            }

            public void put(CidMemberSetupImpl obj, Object value) {
                obj.setArtId((Number)value);
            }
        }
        ,
        LoanDuration {
            public Object get(CidMemberSetupImpl obj) {
                return obj.getLoanDuration();
            }

            public void put(CidMemberSetupImpl obj, Object value) {
                obj.setLoanDuration((Number)value);
            }
        }
        ,
        LocReserveQuota {
            public Object get(CidMemberSetupImpl obj) {
                return obj.getLocReserveQuota();
            }

            public void put(CidMemberSetupImpl obj, Object value) {
                obj.setLocReserveQuota((Number)value);
            }
        }
        ,
        ClibReserveQuota {
            public Object get(CidMemberSetupImpl obj) {
                return obj.getClibReserveQuota();
            }

            public void put(CidMemberSetupImpl obj, Object value) {
                obj.setClibReserveQuota((Number)value);
            }
        }
        ,
        IlibReserveQuota {
            public Object get(CidMemberSetupImpl obj) {
                return obj.getIlibReserveQuota();
            }

            public void put(CidMemberSetupImpl obj, Object value) {
                obj.setIlibReserveQuota((Number)value);
            }
        }
        ,
        FromDate {
            public Object get(CidMemberSetupImpl obj) {
                return obj.getFromDate();
            }

            public void put(CidMemberSetupImpl obj, Object value) {
                obj.setFromDate((Number)value);
            }
        }
        ,
        ToDate {
            public Object get(CidMemberSetupImpl obj) {
                return obj.getToDate();
            }

            public void put(CidMemberSetupImpl obj, Object value) {
                obj.setToDate((Number)value);
            }
        }
        ,
        MlibLoanQuota {
            public Object get(CidMemberSetupImpl obj) {
                return obj.getMlibLoanQuota();
            }

            public void put(CidMemberSetupImpl obj, Object value) {
                obj.setMlibLoanQuota((Number)value);
            }
        }
        ,
        MlibReserveQuota {
            public Object get(CidMemberSetupImpl obj) {
                return obj.getMlibReserveQuota();
            }

            public void put(CidMemberSetupImpl obj, Object value) {
                obj.setMlibReserveQuota((Number)value);
            }
        }
        ,
        Person {
            public Object get(CidMemberSetupImpl obj) {
                return obj.getPerson();
            }

            public void put(CidMemberSetupImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(CidMemberSetupImpl object);

        public abstract void put(CidMemberSetupImpl object, Object value);

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
    public static final int POST = AttributesEnum.Post.index();
    public static final int CLIBLOANQUOTA = AttributesEnum.ClibLoanQuota.index();
    public static final int LOCLOANQUOTA = AttributesEnum.LocLoanQuota.index();
    public static final int ILIBLOANQUOTA = AttributesEnum.IlibLoanQuota.index();
    public static final int ACTIVE = AttributesEnum.Active.index();
    public static final int ARTID = AttributesEnum.ArtId.index();
    public static final int LOANDURATION = AttributesEnum.LoanDuration.index();
    public static final int LOCRESERVEQUOTA = AttributesEnum.LocReserveQuota.index();
    public static final int CLIBRESERVEQUOTA = AttributesEnum.ClibReserveQuota.index();
    public static final int ILIBRESERVEQUOTA = AttributesEnum.IlibReserveQuota.index();
    public static final int FROMDATE = AttributesEnum.FromDate.index();
    public static final int TODATE = AttributesEnum.ToDate.index();
    public static final int MLIBLOANQUOTA = AttributesEnum.MlibLoanQuota.index();
    public static final int MLIBRESERVEQUOTA = AttributesEnum.MlibReserveQuota.index();
    public static final int PERSON = AttributesEnum.Person.index();

    /**
     * This is the default constructor (do not remove).
     */
    public CidMemberSetupImpl() {
    }

    /**
     * Gets the attribute value for Post, using the alias name Post.
     * @return the Post
     */
    public Number getPost() {
        return (Number)getAttributeInternal(POST);
    }

    /**
     * Sets <code>value</code> as the attribute value for Post.
     * @param value value to set the Post
     */
    public void setPost(Number value) {
        setAttributeInternal(POST, value);
    }

    /**
     * Gets the attribute value for ClibLoanQuota, using the alias name ClibLoanQuota.
     * @return the ClibLoanQuota
     */
    public Number getClibLoanQuota() {
        return (Number)getAttributeInternal(CLIBLOANQUOTA);
    }

    /**
     * Sets <code>value</code> as the attribute value for ClibLoanQuota.
     * @param value value to set the ClibLoanQuota
     */
    public void setClibLoanQuota(Number value) {
        setAttributeInternal(CLIBLOANQUOTA, value);
    }

    /**
     * Gets the attribute value for LocLoanQuota, using the alias name LocLoanQuota.
     * @return the LocLoanQuota
     */
    public Number getLocLoanQuota() {
        return (Number)getAttributeInternal(LOCLOANQUOTA);
    }

    /**
     * Sets <code>value</code> as the attribute value for LocLoanQuota.
     * @param value value to set the LocLoanQuota
     */
    public void setLocLoanQuota(Number value) {
        setAttributeInternal(LOCLOANQUOTA, value);
    }

    /**
     * Gets the attribute value for IlibLoanQuota, using the alias name IlibLoanQuota.
     * @return the IlibLoanQuota
     */
    public Number getIlibLoanQuota() {
        return (Number)getAttributeInternal(ILIBLOANQUOTA);
    }

    /**
     * Sets <code>value</code> as the attribute value for IlibLoanQuota.
     * @param value value to set the IlibLoanQuota
     */
    public void setIlibLoanQuota(Number value) {
        setAttributeInternal(ILIBLOANQUOTA, value);
    }

    /**
     * Gets the attribute value for Active, using the alias name Active.
     * @return the Active
     */
    public Number getActive() {
        return (Number)getAttributeInternal(ACTIVE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Active.
     * @param value value to set the Active
     */
    public void setActive(Number value) {
        setAttributeInternal(ACTIVE, value);
    }

    /**
     * Gets the attribute value for ArtId, using the alias name ArtId.
     * @return the ArtId
     */
    public Number getArtId() {
        return (Number)getAttributeInternal(ARTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for ArtId.
     * @param value value to set the ArtId
     */
    public void setArtId(Number value) {
        setAttributeInternal(ARTID, value);
    }

    /**
     * Gets the attribute value for LoanDuration, using the alias name LoanDuration.
     * @return the LoanDuration
     */
    public Number getLoanDuration() {
        return (Number)getAttributeInternal(LOANDURATION);
    }

    /**
     * Sets <code>value</code> as the attribute value for LoanDuration.
     * @param value value to set the LoanDuration
     */
    public void setLoanDuration(Number value) {
        setAttributeInternal(LOANDURATION, value);
    }

    /**
     * Gets the attribute value for LocReserveQuota, using the alias name LocReserveQuota.
     * @return the LocReserveQuota
     */
    public Number getLocReserveQuota() {
        return (Number)getAttributeInternal(LOCRESERVEQUOTA);
    }

    /**
     * Sets <code>value</code> as the attribute value for LocReserveQuota.
     * @param value value to set the LocReserveQuota
     */
    public void setLocReserveQuota(Number value) {
        setAttributeInternal(LOCRESERVEQUOTA, value);
    }

    /**
     * Gets the attribute value for ClibReserveQuota, using the alias name ClibReserveQuota.
     * @return the ClibReserveQuota
     */
    public Number getClibReserveQuota() {
        return (Number)getAttributeInternal(CLIBRESERVEQUOTA);
    }

    /**
     * Sets <code>value</code> as the attribute value for ClibReserveQuota.
     * @param value value to set the ClibReserveQuota
     */
    public void setClibReserveQuota(Number value) {
        setAttributeInternal(CLIBRESERVEQUOTA, value);
    }

    /**
     * Gets the attribute value for IlibReserveQuota, using the alias name IlibReserveQuota.
     * @return the IlibReserveQuota
     */
    public Number getIlibReserveQuota() {
        return (Number)getAttributeInternal(ILIBRESERVEQUOTA);
    }

    /**
     * Sets <code>value</code> as the attribute value for IlibReserveQuota.
     * @param value value to set the IlibReserveQuota
     */
    public void setIlibReserveQuota(Number value) {
        setAttributeInternal(ILIBRESERVEQUOTA, value);
    }

    /**
     * Gets the attribute value for FromDate, using the alias name FromDate.
     * @return the FromDate
     */
    public Number getFromDate() {
        return (Number)getAttributeInternal(FROMDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for FromDate.
     * @param value value to set the FromDate
     */
    public void setFromDate(Number value) {
        setAttributeInternal(FROMDATE, value);
    }

    /**
     * Gets the attribute value for ToDate, using the alias name ToDate.
     * @return the ToDate
     */
    public Number getToDate() {
        return (Number)getAttributeInternal(TODATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for ToDate.
     * @param value value to set the ToDate
     */
    public void setToDate(Number value) {
        setAttributeInternal(TODATE, value);
    }

    /**
     * Gets the attribute value for MlibLoanQuota, using the alias name MlibLoanQuota.
     * @return the MlibLoanQuota
     */
    public Number getMlibLoanQuota() {
        return (Number)getAttributeInternal(MLIBLOANQUOTA);
    }

    /**
     * Sets <code>value</code> as the attribute value for MlibLoanQuota.
     * @param value value to set the MlibLoanQuota
     */
    public void setMlibLoanQuota(Number value) {
        setAttributeInternal(MLIBLOANQUOTA, value);
    }

    /**
     * Gets the attribute value for MlibReserveQuota, using the alias name MlibReserveQuota.
     * @return the MlibReserveQuota
     */
    public Number getMlibReserveQuota() {
        return (Number)getAttributeInternal(MLIBRESERVEQUOTA);
    }

    /**
     * Sets <code>value</code> as the attribute value for MlibReserveQuota.
     * @param value value to set the MlibReserveQuota
     */
    public void setMlibReserveQuota(Number value) {
        setAttributeInternal(MLIBRESERVEQUOTA, value);
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

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getPerson() {
        return (RowIterator)getAttributeInternal(PERSON);
    }

    /**
     * @param artId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Number artId) {
        return new Key(new Object[]{artId});
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("org.parsisys.tehranuniversity.library.model.eo.CidMemberSetup");
        }
        return mDefinitionObject;
    }

    /**
     * Add attribute defaulting logic in this method.
     * @param attributeList list of attribute names/values to initialize the row
     */
    protected void create(AttributeList attributeList) {
        super.create(attributeList);
    }

    /**
     * Add entity remove logic in this method.
     */
    public void remove() {
        super.remove();
    }

    /**
     * Add locking logic here.
     */
    public void lock() {
        super.lock();
    }

    /**
     * Custom DML update/insert/delete logic here.
     * @param operation the operation type
     * @param e the transaction event
     */
    protected void doDML(int operation, TransactionEvent e) {
        super.doDML(operation, e);
    }
}