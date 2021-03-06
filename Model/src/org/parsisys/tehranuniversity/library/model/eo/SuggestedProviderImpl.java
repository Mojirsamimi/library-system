package org.parsisys.tehranuniversity.library.model.eo;

import oracle.jbo.Key;
import oracle.jbo.domain.DBSequence;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.SequenceImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Oct 17 13:14:03 GST 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SuggestedProviderImpl extends EntityImpl {
    private static EntityDefImpl mDefinitionObject;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        ArtId {
            public Object get(SuggestedProviderImpl obj) {
                return obj.getArtId();
            }

            public void put(SuggestedProviderImpl obj, Object value) {
                obj.setArtId((DBSequence)value);
            }
        }
        ,
        Labcol {
            public Object get(SuggestedProviderImpl obj) {
                return obj.getLabcol();
            }

            public void put(SuggestedProviderImpl obj, Object value) {
                obj.setLabcol((Number)value);
            }
        }
        ,
        Provider {
            public Object get(SuggestedProviderImpl obj) {
                return obj.getProvider();
            }

            public void put(SuggestedProviderImpl obj, Object value) {
                obj.setProvider((String)value);
            }
        }
        ,
        ForeignName {
            public Object get(SuggestedProviderImpl obj) {
                return obj.getForeignName();
            }

            public void put(SuggestedProviderImpl obj, Object value) {
                obj.setForeignName((String)value);
            }
        }
        ,
        BdDate {
            public Object get(SuggestedProviderImpl obj) {
                return obj.getBdDate();
            }

            public void put(SuggestedProviderImpl obj, Object value) {
                obj.setBdDate((String)value);
            }
        }
        ,
        ProviderKind {
            public Object get(SuggestedProviderImpl obj) {
                return obj.getProviderKind();
            }

            public void put(SuggestedProviderImpl obj, Object value) {
                obj.setProviderKind((Number)value);
            }
        }
        ,
        VbookArtId {
            public Object get(SuggestedProviderImpl obj) {
                return obj.getVbookArtId();
            }

            public void put(SuggestedProviderImpl obj, Object value) {
                obj.setVbookArtId((Number)value);
            }
        }
        ,
        ProviderRoleArtId {
            public Object get(SuggestedProviderImpl obj) {
                return obj.getProviderRoleArtId();
            }

            public void put(SuggestedProviderImpl obj, Object value) {
                obj.setProviderRoleArtId((Number)value);
            }
        }
        ,
        SuggestedVirtualBook {
            public Object get(SuggestedProviderImpl obj) {
                return obj.getSuggestedVirtualBook();
            }

            public void put(SuggestedProviderImpl obj, Object value) {
                obj.setSuggestedVirtualBook((SuggestedVirtualBookImpl)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(SuggestedProviderImpl object);

        public abstract void put(SuggestedProviderImpl object, Object value);

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
    public static final int LABCOL = AttributesEnum.Labcol.index();
    public static final int PROVIDER = AttributesEnum.Provider.index();
    public static final int FOREIGNNAME = AttributesEnum.ForeignName.index();
    public static final int BDDATE = AttributesEnum.BdDate.index();
    public static final int PROVIDERKIND = AttributesEnum.ProviderKind.index();
    public static final int VBOOKARTID = AttributesEnum.VbookArtId.index();
    public static final int PROVIDERROLEARTID = AttributesEnum.ProviderRoleArtId.index();
    public static final int SUGGESTEDVIRTUALBOOK = AttributesEnum.SuggestedVirtualBook.index();

    /**
     * This is the default constructor (do not remove).
     */
    public SuggestedProviderImpl() {
    }

    /**
     * Gets the attribute value for ArtId, using the alias name ArtId.
     * @return the ArtId
     */
    public DBSequence getArtId() {
        return (DBSequence)getAttributeInternal(ARTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for ArtId.
     * @param value value to set the ArtId
     */
    public void setArtId(DBSequence value) {
        setAttributeInternal(ARTID, value);
    }

    /**
     * Gets the attribute value for Labcol, using the alias name Labcol.
     * @return the Labcol
     */
    public Number getLabcol() {
        return (Number)getAttributeInternal(LABCOL);
    }

    /**
     * Sets <code>value</code> as the attribute value for Labcol.
     * @param value value to set the Labcol
     */
    public void setLabcol(Number value) {
        setAttributeInternal(LABCOL, value);
    }

    /**
     * Gets the attribute value for Provider, using the alias name Provider.
     * @return the Provider
     */
    public String getProvider() {
        return (String)getAttributeInternal(PROVIDER);
    }

    /**
     * Sets <code>value</code> as the attribute value for Provider.
     * @param value value to set the Provider
     */
    public void setProvider(String value) {
        setAttributeInternal(PROVIDER, value);
    }

    /**
     * Gets the attribute value for ForeignName, using the alias name ForeignName.
     * @return the ForeignName
     */
    public String getForeignName() {
        return (String)getAttributeInternal(FOREIGNNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for ForeignName.
     * @param value value to set the ForeignName
     */
    public void setForeignName(String value) {
        setAttributeInternal(FOREIGNNAME, value);
    }

    /**
     * Gets the attribute value for BdDate, using the alias name BdDate.
     * @return the BdDate
     */
    public String getBdDate() {
        return (String)getAttributeInternal(BDDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for BdDate.
     * @param value value to set the BdDate
     */
    public void setBdDate(String value) {
        setAttributeInternal(BDDATE, value);
    }

    /**
     * Gets the attribute value for ProviderKind, using the alias name ProviderKind.
     * @return the ProviderKind
     */
    public Number getProviderKind() {
        return (Number)getAttributeInternal(PROVIDERKIND);
    }

    /**
     * Sets <code>value</code> as the attribute value for ProviderKind.
     * @param value value to set the ProviderKind
     */
    public void setProviderKind(Number value) {
        setAttributeInternal(PROVIDERKIND, value);
    }

    /**
     * Gets the attribute value for VbookArtId, using the alias name VbookArtId.
     * @return the VbookArtId
     */
    public Number getVbookArtId() {
        return (Number)getAttributeInternal(VBOOKARTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for VbookArtId.
     * @param value value to set the VbookArtId
     */
    public void setVbookArtId(Number value) {
        setAttributeInternal(VBOOKARTID, value);
    }

    /**
     * Gets the attribute value for ProviderRoleArtId, using the alias name ProviderRoleArtId.
     * @return the ProviderRoleArtId
     */
    public Number getProviderRoleArtId() {
        return (Number)getAttributeInternal(PROVIDERROLEARTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for ProviderRoleArtId.
     * @param value value to set the ProviderRoleArtId
     */
    public void setProviderRoleArtId(Number value) {
        setAttributeInternal(PROVIDERROLEARTID, value);
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
     * @return the associated entity SuggestedVirtualBookImpl.
     */
    public SuggestedVirtualBookImpl getSuggestedVirtualBook() {
        return (SuggestedVirtualBookImpl)getAttributeInternal(SUGGESTEDVIRTUALBOOK);
    }

    /**
     * Sets <code>value</code> as the associated entity SuggestedVirtualBookImpl.
     */
    public void setSuggestedVirtualBook(SuggestedVirtualBookImpl value) {
        setAttributeInternal(SUGGESTEDVIRTUALBOOK, value);
    }

    /**
     * @param artId key constituent
     * @param labcol key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(DBSequence artId, Number labcol) {
        return new Key(new Object[]{artId, labcol});
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("org.parsisys.tehranuniversity.library.model.eo.SuggestedProvider");
        }
        return mDefinitionObject;
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
        
      if(operation==DML_INSERT) {
        SequenceImpl si =
            new SequenceImpl("BOOK.SEQ_SUGGESTED_PROVIDER", getDBTransaction());
        setArtId(new DBSequence( si.getSequenceNumber()));
      }
        super.doDML(operation, e);
    }
}
