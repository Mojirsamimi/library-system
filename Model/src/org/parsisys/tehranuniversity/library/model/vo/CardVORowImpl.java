package org.parsisys.tehranuniversity.library.model.vo;

import oracle.jbo.RowIterator;
import oracle.jbo.domain.DBSequence;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;

import org.parsisys.tehranuniversity.library.model.eo.CardImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Jan 01 17:36:41 GMT+03:30 2013
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CardVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        ArtId {
            public Object get(CardVORowImpl obj) {
                return obj.getArtId();
            }

            public void put(CardVORowImpl obj, Object value) {
                obj.setArtId((DBSequence)value);
            }
        }
        ,
        CardDate {
            public Object get(CardVORowImpl obj) {
                return obj.getCardDate();
            }

            public void put(CardVORowImpl obj, Object value) {
                obj.setCardDate((Number)value);
            }
        }
        ,
        CrdtypeArtId {
            public Object get(CardVORowImpl obj) {
                return obj.getCrdtypeArtId();
            }

            public void put(CardVORowImpl obj, Object value) {
                obj.setCrdtypeArtId((Number)value);
            }
        }
        ,
        Labcol {
            public Object get(CardVORowImpl obj) {
                return obj.getLabcol();
            }

            public void put(CardVORowImpl obj, Object value) {
                obj.setLabcol((Number)value);
            }
        }
        ,
        Lastartid {
            public Object get(CardVORowImpl obj) {
                return obj.getLastartid();
            }

            public void put(CardVORowImpl obj, Object value) {
                obj.setLastartid((Number)value);
            }
        }
        ,
        Status {
            public Object get(CardVORowImpl obj) {
                return obj.getStatus();
            }

            public void put(CardVORowImpl obj, Object value) {
                obj.setStatus((Number)value);
            }
        }
        ,
        UserName {
            public Object get(CardVORowImpl obj) {
                return obj.getUserName();
            }

            public void put(CardVORowImpl obj, Object value) {
                obj.setUserName((String)value);
            }
        }
        ,
        VbookArtId {
            public Object get(CardVORowImpl obj) {
                return obj.getVbookArtId();
            }

            public void put(CardVORowImpl obj, Object value) {
                obj.setVbookArtId((Number)value);
            }
        }
        ,
        CardRowVO {
            public Object get(CardVORowImpl obj) {
                return obj.getCardRowVO();
            }

            public void put(CardVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(CardVORowImpl object);

        public abstract void put(CardVORowImpl object, Object value);

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
    public static final int CARDDATE = AttributesEnum.CardDate.index();
    public static final int CRDTYPEARTID = AttributesEnum.CrdtypeArtId.index();
    public static final int LABCOL = AttributesEnum.Labcol.index();
    public static final int LASTARTID = AttributesEnum.Lastartid.index();
    public static final int STATUS = AttributesEnum.Status.index();
    public static final int USERNAME = AttributesEnum.UserName.index();
    public static final int VBOOKARTID = AttributesEnum.VbookArtId.index();
    public static final int CARDROWVO = AttributesEnum.CardRowVO.index();

    /**
     * This is the default constructor (do not remove).
     */
    public CardVORowImpl() {
    }

    /**
     * Gets Card entity object.
     * @return the Card
     */
    public CardImpl getCard() {
        return (CardImpl)getEntity(0);
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
     * Gets the attribute value for CARD_DATE using the alias name CardDate.
     * @return the CARD_DATE
     */
    public Number getCardDate() {
        return (Number) getAttributeInternal(CARDDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for CARD_DATE using the alias name CardDate.
     * @param value value to set the CARD_DATE
     */
    public void setCardDate(Number value) {
        setAttributeInternal(CARDDATE, value);
    }

    /**
     * Gets the attribute value for CRDTYPE_ART_ID using the alias name CrdtypeArtId.
     * @return the CRDTYPE_ART_ID
     */
    public Number getCrdtypeArtId() {
        return (Number) getAttributeInternal(CRDTYPEARTID);
    }

    /**
     * Sets <code>value</code> as attribute value for CRDTYPE_ART_ID using the alias name CrdtypeArtId.
     * @param value value to set the CRDTYPE_ART_ID
     */
    public void setCrdtypeArtId(Number value) {
        setAttributeInternal(CRDTYPEARTID, value);
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
     * Gets the attribute value for LASTARTID using the alias name Lastartid.
     * @return the LASTARTID
     */
    public Number getLastartid() {
        return (Number) getAttributeInternal(LASTARTID);
    }

    /**
     * Sets <code>value</code> as attribute value for LASTARTID using the alias name Lastartid.
     * @param value value to set the LASTARTID
     */
    public void setLastartid(Number value) {
        setAttributeInternal(LASTARTID, value);
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
     * Gets the attribute value for VBOOK_ART_ID using the alias name VbookArtId.
     * @return the VBOOK_ART_ID
     */
    public Number getVbookArtId() {
        return (Number) getAttributeInternal(VBOOKARTID);
    }

    /**
     * Sets <code>value</code> as attribute value for VBOOK_ART_ID using the alias name VbookArtId.
     * @param value value to set the VBOOK_ART_ID
     */
    public void setVbookArtId(Number value) {
        setAttributeInternal(VBOOKARTID, value);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link CardRowVO.
     */
    public RowIterator getCardRowVO() {
        return (RowIterator)getAttributeInternal(CARDROWVO);
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
