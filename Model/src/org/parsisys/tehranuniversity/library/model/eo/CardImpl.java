package org.parsisys.tehranuniversity.library.model.eo;

import fadak.base.TemplateEntityObject;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.domain.DBSequence;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.SequenceImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Dec 17 16:30:46 GMT+04:00 2011
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CardImpl extends EntityImpl {
    private static EntityDefImpl mDefinitionObject;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        Labcol {
            public Object get(CardImpl obj) {
                return obj.getLabcol();
            }

            public void put(CardImpl obj, Object value) {
                obj.setLabcol((Number)value);
            }
        }
        ,
        ArtId {
            public Object get(CardImpl obj) {
                return obj.getArtId();
            }

            public void put(CardImpl obj, Object value) {
                obj.setArtId((DBSequence)value);
            }
        }
        ,
        UserName {
            public Object get(CardImpl obj) {
                return obj.getUserName();
            }

            public void put(CardImpl obj, Object value) {
                obj.setUserName((String)value);
            }
        }
        ,
        VbookArtId {
            public Object get(CardImpl obj) {
                return obj.getVbookArtId();
            }

            public void put(CardImpl obj, Object value) {
                obj.setVbookArtId((Number)value);
            }
        }
        ,
        CrdtypeArtId {
            public Object get(CardImpl obj) {
                return obj.getCrdtypeArtId();
            }

            public void put(CardImpl obj, Object value) {
                obj.setCrdtypeArtId((Number)value);
            }
        }
        ,
        CardDate {
            public Object get(CardImpl obj) {
                return obj.getCardDate();
            }

            public void put(CardImpl obj, Object value) {
                obj.setCardDate((Number)value);
            }
        }
        ,
        Status {
            public Object get(CardImpl obj) {
                return obj.getStatus();
            }

            public void put(CardImpl obj, Object value) {
                obj.setStatus((Number)value);
            }
        }
        ,
        Lastartid {
            public Object get(CardImpl obj) {
                return obj.getLastartid();
            }

            public void put(CardImpl obj, Object value) {
                obj.setLastartid((Number)value);
            }
        }
        ,
        VirtualBook {
            public Object get(CardImpl obj) {
                return obj.getVirtualBook();
            }

            public void put(CardImpl obj, Object value) {
                obj.setVirtualBook((VirtualBookImpl)value);
            }
        }
        ,
        CardRow {
            public Object get(CardImpl obj) {
                return obj.getCardRow();
            }

            public void put(CardImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(CardImpl object);

        public abstract void put(CardImpl object, Object value);

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
    public static final int ARTID = AttributesEnum.ArtId.index();
    public static final int USERNAME = AttributesEnum.UserName.index();
    public static final int VBOOKARTID = AttributesEnum.VbookArtId.index();
    public static final int CRDTYPEARTID = AttributesEnum.CrdtypeArtId.index();
    public static final int CARDDATE = AttributesEnum.CardDate.index();
    public static final int STATUS = AttributesEnum.Status.index();
    public static final int LASTARTID = AttributesEnum.Lastartid.index();
    public static final int VIRTUALBOOK = AttributesEnum.VirtualBook.index();
    public static final int CARDROW = AttributesEnum.CardRow.index();

    /**
     * This is the default constructor (do not remove).
     */
    public CardImpl() {
    }


    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("org.parsisys.tehranuniversity.library.model.eo.Card");
        }
        return mDefinitionObject;
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
     * Gets the attribute value for UserName, using the alias name UserName.
     * @return the UserName
     */
    public String getUserName() {
        return (String)getAttributeInternal(USERNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for UserName.
     * @param value value to set the UserName
     */
    public void setUserName(String value) {
        setAttributeInternal(USERNAME, value);
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
     * Gets the attribute value for CrdtypeArtId, using the alias name CrdtypeArtId.
     * @return the CrdtypeArtId
     */
    public Number getCrdtypeArtId() {
        return (Number)getAttributeInternal(CRDTYPEARTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for CrdtypeArtId.
     * @param value value to set the CrdtypeArtId
     */
    public void setCrdtypeArtId(Number value) {
        setAttributeInternal(CRDTYPEARTID, value);
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
     * Gets the attribute value for CardDate, using the alias name CardDate.
     * @return the CardDate
     */
    public Number getCardDate() {
        return (Number)getAttributeInternal(CARDDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for CardDate.
     * @param value value to set the CardDate
     */
    public void setCardDate(Number value) {
        setAttributeInternal(CARDDATE, value);
    }

    /**
     * Gets the attribute value for Status, using the alias name Status.
     * @return the Status
     */
    public Number getStatus() {
        return (Number)getAttributeInternal(STATUS);
    }

    /**
     * Sets <code>value</code> as the attribute value for Status.
     * @param value value to set the Status
     */
    public void setStatus(Number value) {
        setAttributeInternal(STATUS, value);
    }

    /**
     * Gets the attribute value for Lastartid, using the alias name Lastartid.
     * @return the Lastartid
     */
    public Number getLastartid() {
        return (Number)getAttributeInternal(LASTARTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for Lastartid.
     * @param value value to set the Lastartid
     */
    public void setLastartid(Number value) {
        setAttributeInternal(LASTARTID, value);
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
     * @return the associated entity VirtualBookImpl.
     */
    public VirtualBookImpl getVirtualBook() {
        return (VirtualBookImpl)getAttributeInternal(VIRTUALBOOK);
    }

    /**
     * Sets <code>value</code> as the associated entity VirtualBookImpl.
     */
    public void setVirtualBook(VirtualBookImpl value) {
        setAttributeInternal(VIRTUALBOOK, value);
    }


    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getCardRow() {
        return (RowIterator)getAttributeInternal(CARDROW);
    }


    /**
     * @param labcol key constituent
     * @param artId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Number labcol, DBSequence artId) {
        return new Key(new Object[]{labcol, artId});
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
        RowIterator cardRow = getCardRow();
        while(cardRow.hasNext()) {
            System.out.println(cardRow.getRowCount());
          cardRow.next().remove();
        }
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
      if(operation==DML_INSERT){
        SequenceImpl si = new SequenceImpl("SEQ_CARD_ART_ID",getDBTransaction());
        setArtId(new DBSequence( si.getSequenceNumber()));
      }        
//     
        super.doDML(operation, e);
    }
}