package org.parsisys.tehranuniversity.library.model.eo;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Apr 23 16:44:56 GMT+03:30 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class BookThesisImpl extends EntityImpl {
    private static EntityDefImpl mDefinitionObject;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        Labcol {
            public Object get(BookThesisImpl obj) {
                return obj.getLabcol();
            }

            public void put(BookThesisImpl obj, Object value) {
                obj.setLabcol((Number)value);
            }
        }
        ,
        ThesisLetterNo {
            public Object get(BookThesisImpl obj) {
                return obj.getThesisLetterNo();
            }

            public void put(BookThesisImpl obj, Object value) {
                obj.setThesisLetterNo((String)value);
            }
        }
        ,
        MemArtId {
            public Object get(BookThesisImpl obj) {
                return obj.getMemArtId();
            }

            public void put(BookThesisImpl obj, Object value) {
                obj.setMemArtId((Number)value);
            }
        }
        ,
        Member {
            public Object get(BookThesisImpl obj) {
                return obj.getMember();
            }

            public void put(BookThesisImpl obj, Object value) {
                obj.setMember((MemberImpl)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(BookThesisImpl object);

        public abstract void put(BookThesisImpl object, Object value);

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
    public static final int THESISLETTERNO = AttributesEnum.ThesisLetterNo.index();
    public static final int MEMARTID = AttributesEnum.MemArtId.index();
    public static final int MEMBER = AttributesEnum.Member.index();

    /**
     * This is the default constructor (do not remove).
     */
    public BookThesisImpl() {
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
     * Gets the attribute value for ThesisLetterNo, using the alias name ThesisLetterNo.
     * @return the ThesisLetterNo
     */
    public String getThesisLetterNo() {
        return (String)getAttributeInternal(THESISLETTERNO);
    }

    /**
     * Sets <code>value</code> as the attribute value for ThesisLetterNo.
     * @param value value to set the ThesisLetterNo
     */
    public void setThesisLetterNo(String value) {
        setAttributeInternal(THESISLETTERNO, value);
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
     * @param labcol key constituent
     * @param memArtId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Number labcol, Number memArtId) {
        return new Key(new Object[]{labcol, memArtId});
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("org.parsisys.tehranuniversity.library.model.eo.BookThesis");
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