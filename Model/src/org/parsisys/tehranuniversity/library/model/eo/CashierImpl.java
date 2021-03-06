package org.parsisys.tehranuniversity.library.model.eo;

import oracle.jbo.AttributeList;
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
// ---    Tue Sep 25 12:20:27 GMT+03:30 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CashierImpl extends EntityImpl {
    private static EntityDefImpl mDefinitionObject;

    @Override
    protected void create(AttributeList attributeList) {
        setLabcol((Number)getDBTransaction().getSession().getUserData().get("labcolno"));
        super.create(attributeList);
    }

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        ArtId {
            public Object get(CashierImpl obj) {
                return obj.getArtId();
            }

            public void put(CashierImpl obj, Object value) {
                obj.setArtId((DBSequence)value);
            }
        }
        ,
        MemArtId {
            public Object get(CashierImpl obj) {
                return obj.getMemArtId();
            }

            public void put(CashierImpl obj, Object value) {
                obj.setMemArtId((Number)value);
            }
        }
        ,
        ReceiptDate {
            public Object get(CashierImpl obj) {
                return obj.getReceiptDate();
            }

            public void put(CashierImpl obj, Object value) {
                obj.setReceiptDate((Number)value);
            }
        }
        ,
        ReceiptTime {
            public Object get(CashierImpl obj) {
                return obj.getReceiptTime();
            }

            public void put(CashierImpl obj, Object value) {
                obj.setReceiptTime((Number)value);
            }
        }
        ,
        ReceiptUser {
            public Object get(CashierImpl obj) {
                return obj.getReceiptUser();
            }

            public void put(CashierImpl obj, Object value) {
                obj.setReceiptUser((String)value);
            }
        }
        ,
        ReturnDate {
            public Object get(CashierImpl obj) {
                return obj.getReturnDate();
            }

            public void put(CashierImpl obj, Object value) {
                obj.setReturnDate((Number)value);
            }
        }
        ,
        ReturnTime {
            public Object get(CashierImpl obj) {
                return obj.getReturnTime();
            }

            public void put(CashierImpl obj, Object value) {
                obj.setReturnTime((Number)value);
            }
        }
        ,
        ReturnUser {
            public Object get(CashierImpl obj) {
                return obj.getReturnUser();
            }

            public void put(CashierImpl obj, Object value) {
                obj.setReturnUser((String)value);
            }
        }
        ,
        CasheType {
            public Object get(CashierImpl obj) {
                return obj.getCasheType();
            }

            public void put(CashierImpl obj, Object value) {
                obj.setCasheType((Number)value);
            }
        }
        ,
        KeyNumber {
            public Object get(CashierImpl obj) {
                return obj.getKeyNumber();
            }

            public void put(CashierImpl obj, Object value) {
                obj.setKeyNumber((Number)value);
            }
        }
        ,
        Labcol {
            public Object get(CashierImpl obj) {
                return obj.getLabcol();
            }

            public void put(CashierImpl obj, Object value) {
                obj.setLabcol((Number)value);
            }
        }
        ,
        Member {
            public Object get(CashierImpl obj) {
                return obj.getMember();
            }

            public void put(CashierImpl obj, Object value) {
                obj.setMember((MemberImpl)value);
            }
        }
        ,
        InitMember {
            public Object get(CashierImpl obj) {
                return obj.getInitMember();
            }

            public void put(CashierImpl obj, Object value) {
                obj.setInitMember((InitMemberImpl)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(CashierImpl object);

        public abstract void put(CashierImpl object, Object value);

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
    public static final int MEMARTID = AttributesEnum.MemArtId.index();
    public static final int RECEIPTDATE = AttributesEnum.ReceiptDate.index();
    public static final int RECEIPTTIME = AttributesEnum.ReceiptTime.index();
    public static final int RECEIPTUSER = AttributesEnum.ReceiptUser.index();
    public static final int RETURNDATE = AttributesEnum.ReturnDate.index();
    public static final int RETURNTIME = AttributesEnum.ReturnTime.index();
    public static final int RETURNUSER = AttributesEnum.ReturnUser.index();
    public static final int CASHETYPE = AttributesEnum.CasheType.index();
    public static final int KEYNUMBER = AttributesEnum.KeyNumber.index();
    public static final int LABCOL = AttributesEnum.Labcol.index();
    public static final int MEMBER = AttributesEnum.Member.index();
    public static final int INITMEMBER = AttributesEnum.InitMember.index();

    /**
     * This is the default constructor (do not remove).
     */
    public CashierImpl() {
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
     * Gets the attribute value for MemArtId, using the alias name MemArtId.
     * @return the MemArtId
     */
    public Number getMemArtId() {
        return (Number)getAttributeInternal(MEMARTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for MemArtId.
     * @param value value to set the MemArtId
     */
    public void setMemArtId(Number value) {
        setAttributeInternal(MEMARTID, value);
    }

    /**
     * Gets the attribute value for ReceiptDate, using the alias name ReceiptDate.
     * @return the ReceiptDate
     */
    public Number getReceiptDate() {
        return (Number)getAttributeInternal(RECEIPTDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for ReceiptDate.
     * @param value value to set the ReceiptDate
     */
    public void setReceiptDate(Number value) {
        setAttributeInternal(RECEIPTDATE, value);
    }

    /**
     * Gets the attribute value for ReceiptTime, using the alias name ReceiptTime.
     * @return the ReceiptTime
     */
    public Number getReceiptTime() {
        return (Number)getAttributeInternal(RECEIPTTIME);
    }

    /**
     * Sets <code>value</code> as the attribute value for ReceiptTime.
     * @param value value to set the ReceiptTime
     */
    public void setReceiptTime(Number value) {
        setAttributeInternal(RECEIPTTIME, value);
    }

    /**
     * Gets the attribute value for ReceiptUser, using the alias name ReceiptUser.
     * @return the ReceiptUser
     */
    public String getReceiptUser() {
        return (String)getAttributeInternal(RECEIPTUSER);
    }

    /**
     * Sets <code>value</code> as the attribute value for ReceiptUser.
     * @param value value to set the ReceiptUser
     */
    public void setReceiptUser(String value) {
        setAttributeInternal(RECEIPTUSER, value);
    }

    /**
     * Gets the attribute value for ReturnDate, using the alias name ReturnDate.
     * @return the ReturnDate
     */
    public Number getReturnDate() {
        return (Number)getAttributeInternal(RETURNDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for ReturnDate.
     * @param value value to set the ReturnDate
     */
    public void setReturnDate(Number value) {
        setAttributeInternal(RETURNDATE, value);
    }

    /**
     * Gets the attribute value for ReturnTime, using the alias name ReturnTime.
     * @return the ReturnTime
     */
    public Number getReturnTime() {
        return (Number)getAttributeInternal(RETURNTIME);
    }

    /**
     * Sets <code>value</code> as the attribute value for ReturnTime.
     * @param value value to set the ReturnTime
     */
    public void setReturnTime(Number value) {
        setAttributeInternal(RETURNTIME, value);
    }

    /**
     * Gets the attribute value for ReturnUser, using the alias name ReturnUser.
     * @return the ReturnUser
     */
    public String getReturnUser() {
        return (String)getAttributeInternal(RETURNUSER);
    }

    /**
     * Sets <code>value</code> as the attribute value for ReturnUser.
     * @param value value to set the ReturnUser
     */
    public void setReturnUser(String value) {
        setAttributeInternal(RETURNUSER, value);
    }

    /**
     * Gets the attribute value for CasheType, using the alias name CasheType.
     * @return the CasheType
     */
    public Number getCasheType() {
        return (Number)getAttributeInternal(CASHETYPE);
    }

    /**
     * Sets <code>value</code> as the attribute value for CasheType.
     * @param value value to set the CasheType
     */
    public void setCasheType(Number value) {
        setAttributeInternal(CASHETYPE, value);
    }

    /**
     * Gets the attribute value for KeyNumber, using the alias name KeyNumber.
     * @return the KeyNumber
     */
    public Number getKeyNumber() {
        return (Number)getAttributeInternal(KEYNUMBER);
    }

    /**
     * Sets <code>value</code> as the attribute value for KeyNumber.
     * @param value value to set the KeyNumber
     */
    public void setKeyNumber(Number value) {
        setAttributeInternal(KEYNUMBER, value);
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
     * @return the associated entity MemberImpl.
     */
    public MemberImpl getMember() {
        return (MemberImpl)getAttributeInternal(MEMBER);
    }

    /**
     * Sets <code>value</code> as the associated entity MemberImpl.
     */
    public void setMember(MemberImpl value) {
        setAttributeInternal(MEMBER, value);
    }

    /**
     * @return the associated entity InitMemberImpl.
     */
    public InitMemberImpl getInitMember() {
        return (InitMemberImpl)getAttributeInternal(INITMEMBER);
    }

    /**
     * Sets <code>value</code> as the associated entity InitMemberImpl.
     */
    public void setInitMember(InitMemberImpl value) {
        setAttributeInternal(INITMEMBER, value);
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
            mDefinitionObject = EntityDefImpl.findDefObject("org.parsisys.tehranuniversity.library.model.eo.Cashier");
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
          SequenceImpl si=new SequenceImpl("book.SEQ_CASHIER_ART_ID",getDBTransaction());
          setArtId(new DBSequence( si.getSequenceNumber()));
        }
        super.doDML(operation, e);
    }
}
