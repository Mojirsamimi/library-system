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
// ---    Wed Oct 17 13:15:57 GST 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SuggestedBookLanguageImpl extends EntityImpl {
    private static EntityDefImpl mDefinitionObject;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        ArtId {
            public Object get(SuggestedBookLanguageImpl obj) {
                return obj.getArtId();
            }

            public void put(SuggestedBookLanguageImpl obj, Object value) {
                obj.setArtId((DBSequence)value);
            }
        }
        ,
        Labcol {
            public Object get(SuggestedBookLanguageImpl obj) {
                return obj.getLabcol();
            }

            public void put(SuggestedBookLanguageImpl obj, Object value) {
                obj.setLabcol((Number)value);
            }
        }
        ,
        LanguageArtId {
            public Object get(SuggestedBookLanguageImpl obj) {
                return obj.getLanguageArtId();
            }

            public void put(SuggestedBookLanguageImpl obj, Object value) {
                obj.setLanguageArtId((Number)value);
            }
        }
        ,
        VbookArtId {
            public Object get(SuggestedBookLanguageImpl obj) {
                return obj.getVbookArtId();
            }

            public void put(SuggestedBookLanguageImpl obj, Object value) {
                obj.setVbookArtId((Number)value);
            }
        }
        ,
        SuggestedVirtualBook {
            public Object get(SuggestedBookLanguageImpl obj) {
                return obj.getSuggestedVirtualBook();
            }

            public void put(SuggestedBookLanguageImpl obj, Object value) {
                obj.setSuggestedVirtualBook((SuggestedVirtualBookImpl)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(SuggestedBookLanguageImpl object);

        public abstract void put(SuggestedBookLanguageImpl object,
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
    public static final int LABCOL = AttributesEnum.Labcol.index();
    public static final int LANGUAGEARTID = AttributesEnum.LanguageArtId.index();
    public static final int VBOOKARTID = AttributesEnum.VbookArtId.index();
    public static final int SUGGESTEDVIRTUALBOOK = AttributesEnum.SuggestedVirtualBook.index();

    /**
     * This is the default constructor (do not remove).
     */
    public SuggestedBookLanguageImpl() {
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
     * Gets the attribute value for LanguageArtId, using the alias name LanguageArtId.
     * @return the LanguageArtId
     */
    public Number getLanguageArtId() {
        return (Number)getAttributeInternal(LANGUAGEARTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for LanguageArtId.
     * @param value value to set the LanguageArtId
     */
    public void setLanguageArtId(Number value) {
        setAttributeInternal(LANGUAGEARTID, value);
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
            mDefinitionObject = EntityDefImpl.findDefObject("org.parsisys.tehranuniversity.library.model.eo.SuggestedBookLanguage");
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
            new SequenceImpl("BOOK.SEQ_SUGGESTED_LANG", getDBTransaction());
        setArtId(new DBSequence( si.getSequenceNumber()));
      }
        super.doDML(operation, e);
    }
}
