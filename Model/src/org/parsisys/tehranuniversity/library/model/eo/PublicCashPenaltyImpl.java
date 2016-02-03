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
// ---    Tue Mar 13 14:56:17 GMT+03:30 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PublicCashPenaltyImpl extends EntityImpl {
    private static EntityDefImpl mDefinitionObject;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        Labcol {
            public Object get(PublicCashPenaltyImpl obj) {
                return obj.getLabcol();
            }

            public void put(PublicCashPenaltyImpl obj, Object value) {
                obj.setLabcol((Number)value);
            }
        }
        ,
        ArtId {
            public Object get(PublicCashPenaltyImpl obj) {
                return obj.getArtId();
            }

            public void put(PublicCashPenaltyImpl obj, Object value) {
                obj.setArtId((DBSequence)value);
            }
        }
        ,
        Value {
            public Object get(PublicCashPenaltyImpl obj) {
                return obj.getValue();
            }

            public void put(PublicCashPenaltyImpl obj, Object value) {
                obj.setValue((Number)value);
            }
        }
        ,
        DayDate {
            public Object get(PublicCashPenaltyImpl obj) {
                return obj.getDayDate();
            }

            public void put(PublicCashPenaltyImpl obj, Object value) {
                obj.setDayDate((Number)value);
            }
        }
        ,
        Description {
            public Object get(PublicCashPenaltyImpl obj) {
                return obj.getDescription();
            }

            public void put(PublicCashPenaltyImpl obj, Object value) {
                obj.setDescription((String)value);
            }
        }
        ,
        MemArtId {
            public Object get(PublicCashPenaltyImpl obj) {
                return obj.getMemArtId();
            }

            public void put(PublicCashPenaltyImpl obj, Object value) {
                obj.setMemArtId((Number)value);
            }
        }
        ,
        UserName {
            public Object get(PublicCashPenaltyImpl obj) {
                return obj.getUserName();
            }

            public void put(PublicCashPenaltyImpl obj, Object value) {
                obj.setUserName((String)value);
            }
        }
        ,
        Member {
            public Object get(PublicCashPenaltyImpl obj) {
                return obj.getMember();
            }

            public void put(PublicCashPenaltyImpl obj, Object value) {
                obj.setMember((MemberImpl)value);
            }
        }
        ,
        InitMember {
            public Object get(PublicCashPenaltyImpl obj) {
                return obj.getInitMember();
            }

            public void put(PublicCashPenaltyImpl obj, Object value) {
                obj.setInitMember((InitMemberImpl)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(PublicCashPenaltyImpl object);

        public abstract void put(PublicCashPenaltyImpl object, Object value);

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
    public static final int VALUE = AttributesEnum.Value.index();
    public static final int DAYDATE = AttributesEnum.DayDate.index();
    public static final int DESCRIPTION = AttributesEnum.Description.index();
    public static final int MEMARTID = AttributesEnum.MemArtId.index();
    public static final int USERNAME = AttributesEnum.UserName.index();
    public static final int MEMBER = AttributesEnum.Member.index();
    public static final int INITMEMBER = AttributesEnum.InitMember.index();

    /**
     * This is the default constructor (do not remove).
     */
    public PublicCashPenaltyImpl() {
    }


    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("org.parsisys.tehranuniversity.library.model.eo.PublicCashPenalty");
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
     * Gets the attribute value for Value, using the alias name Value.
     * @return the Value
     */
    public Number getValue() {
        return (Number)getAttributeInternal(VALUE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Value.
     * @param value value to set the Value
     */
    public void setValue(Number value) {
        setAttributeInternal(VALUE, value);
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
     * Gets the attribute value for Description, using the alias name Description.
     * @return the Description
     */
    public String getDescription() {
        return (String)getAttributeInternal(DESCRIPTION);
    }

    /**
     * Sets <code>value</code> as the attribute value for Description.
     * @param value value to set the Description
     */
    public void setDescription(String value) {
        setAttributeInternal(DESCRIPTION, value);
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
     * @return the associated entity oracle.jbo.server.EntityImpl.
     */
    public MemberImpl getMember() {
        return (MemberImpl)getAttributeInternal(MEMBER);
    }

    /**
     * Sets <code>value</code> as the associated entity oracle.jbo.server.EntityImpl.
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
     * @param labcol key constituent
     * @param artId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Number labcol, DBSequence artId) {
        return new Key(new Object[]{labcol, artId});
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
        SequenceImpl si = new SequenceImpl("seq_pub_cash_penalty_art_id",getDBTransaction());
        setArtId(new DBSequence( si.getSequenceNumber()));
      }
        
        super.doDML(operation, e);
    }
}
