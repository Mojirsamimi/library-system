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
// ---    Mon Mar 12 13:43:52 GMT+03:30 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class MemberBarcodeHistoryImpl extends EntityImpl {
    private static EntityDefImpl mDefinitionObject;

    /**
     * Add locking logic here.
     */
    public void lock() {
        super.lock();
    }

    /**
     * Custom DML update/insert/delete logic here.
     * @param i the operation type
     * @param e the transaction event
     */
    protected void doDML(int i, TransactionEvent e) {
      if(i==DML_INSERT){
        SequenceImpl si = new SequenceImpl("SEQ_MEM_BARCODE_HIS_ART_ID",getDBTransaction());
        setArtId( si.getSequenceNumber());
      }
        
        
        super.doDML(i, e);
        
        
    }

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        PersArtId {
            public Object get(MemberBarcodeHistoryImpl obj) {
                return obj.getPersArtId();
            }

            public void put(MemberBarcodeHistoryImpl obj, Object value) {
                obj.setPersArtId((Number)value);
            }
        }
        ,
        ArtId {
            public Object get(MemberBarcodeHistoryImpl obj) {
                return obj.getArtId();
            }

            public void put(MemberBarcodeHistoryImpl obj, Object value) {
                obj.setArtId((Number)value);
            }
        }
        ,
        DayDate {
            public Object get(MemberBarcodeHistoryImpl obj) {
                return obj.getDayDate();
            }

            public void put(MemberBarcodeHistoryImpl obj, Object value) {
                obj.setDayDate((Number)value);
            }
        }
        ,
        Barcode {
            public Object get(MemberBarcodeHistoryImpl obj) {
                return obj.getBarcode();
            }

            public void put(MemberBarcodeHistoryImpl obj, Object value) {
                obj.setBarcode((String)value);
            }
        }
        ,
        UserName {
            public Object get(MemberBarcodeHistoryImpl obj) {
                return obj.getUserName();
            }

            public void put(MemberBarcodeHistoryImpl obj, Object value) {
                obj.setUserName((String)value);
            }
        }
        ,
        Person {
            public Object get(MemberBarcodeHistoryImpl obj) {
                return obj.getPerson();
            }

            public void put(MemberBarcodeHistoryImpl obj, Object value) {
                obj.setPerson((PersonImpl)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(MemberBarcodeHistoryImpl object);

        public abstract void put(MemberBarcodeHistoryImpl object,
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


    public static final int PERSARTID = AttributesEnum.PersArtId.index();
    public static final int ARTID = AttributesEnum.ArtId.index();
    public static final int DAYDATE = AttributesEnum.DayDate.index();
    public static final int BARCODE = AttributesEnum.Barcode.index();
    public static final int USERNAME = AttributesEnum.UserName.index();
    public static final int PERSON = AttributesEnum.Person.index();

    /**
     * This is the default constructor (do not remove).
     */
    public MemberBarcodeHistoryImpl() {
    }


    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("org.parsisys.tehranuniversity.library.model.eo.MemberBarcodeHistory");
        }
        return mDefinitionObject;
    }

    /**
     * Gets the attribute value for PersArtId, using the alias name PersArtId.
     * @return the PersArtId
     */
    public Number getPersArtId() {
        return (Number)getAttributeInternal(PERSARTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for PersArtId.
     * @param value value to set the PersArtId
     */
    public void setPersArtId(Number value) {
        setAttributeInternal(PERSARTID, value);
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
     * Gets the attribute value for DayDate, using the alias name DayDate.
     * @return the DayDate
     */
    public Number getDayDate() {
        return (Number)getAttributeInternal(DAYDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for DayDate.
     * @param value value to set the DayDate
     */
    public void setDayDate(Number value) {
        setAttributeInternal(DAYDATE, value);
    }

    /**
     * Gets the attribute value for Barcode, using the alias name Barcode.
     * @return the Barcode
     */
    public String getBarcode() {
        return (String)getAttributeInternal(BARCODE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Barcode.
     * @param value value to set the Barcode
     */
    public void setBarcode(String value) {
        setAttributeInternal(BARCODE, value);
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
     * @return the associated entity PersonImpl.
     */
    public PersonImpl getPerson() {
        return (PersonImpl)getAttributeInternal(PERSON);
    }

    /**
     * Sets <code>value</code> as the associated entity PersonImpl.
     */
    public void setPerson(PersonImpl value) {
        setAttributeInternal(PERSON, value);
    }

    /**
     * @param artId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Number artId) {
        return new Key(new Object[]{artId});
    }


}