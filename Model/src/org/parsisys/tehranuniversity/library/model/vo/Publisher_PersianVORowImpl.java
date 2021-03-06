package org.parsisys.tehranuniversity.library.model.vo;

import fadak.base.TemplateViewRow;

import oracle.jbo.RowSet;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;

import org.parsisys.tehranuniversity.library.model.eo.PublisherImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Jan 26 18:25:14 CST 2013
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class Publisher_PersianVORowImpl extends TemplateViewRow {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        ArtId {
            public Object get(Publisher_PersianVORowImpl obj) {
                return obj.getArtId();
            }

            public void put(Publisher_PersianVORowImpl obj, Object value) {
                obj.setArtId((Number)value);
            }
        }
        ,
        Labcol {
            public Object get(Publisher_PersianVORowImpl obj) {
                return obj.getLabcol();
            }

            public void put(Publisher_PersianVORowImpl obj, Object value) {
                obj.setLabcol((Number)value);
            }
        }
        ,
        Place {
            public Object get(Publisher_PersianVORowImpl obj) {
                return obj.getPlace();
            }

            public void put(Publisher_PersianVORowImpl obj, Object value) {
                obj.setPlace((String)value);
            }
        }
        ,
        Publisher1 {
            public Object get(Publisher_PersianVORowImpl obj) {
                return obj.getPublisher1();
            }

            public void put(Publisher_PersianVORowImpl obj, Object value) {
                obj.setPublisher1((String)value);
            }
        }
        ,
        ReadingOrder {
            public Object get(Publisher_PersianVORowImpl obj) {
                return obj.getReadingOrder();
            }

            public void put(Publisher_PersianVORowImpl obj, Object value) {
                obj.setReadingOrder((Number)value);
            }
        }
        ,
        ReadingOrderLovVO1 {
            public Object get(Publisher_PersianVORowImpl obj) {
                return obj.getReadingOrderLovVO1();
            }

            public void put(Publisher_PersianVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(Publisher_PersianVORowImpl object);

        public abstract void put(Publisher_PersianVORowImpl object,
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
    public static final int PLACE = AttributesEnum.Place.index();
    public static final int PUBLISHER1 = AttributesEnum.Publisher1.index();
    public static final int READINGORDER = AttributesEnum.ReadingOrder.index();
    public static final int READINGORDERLOVVO1 = AttributesEnum.ReadingOrderLovVO1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public Publisher_PersianVORowImpl() {
    }

    /**
     * Gets Publisher entity object.
     * @return the Publisher
     */
    public PublisherImpl getPublisher() {
        return (PublisherImpl)getEntity(0);
    }

    /**
     * Gets the attribute value for ART_ID using the alias name ArtId.
     * @return the ART_ID
     */
    public Number getArtId() {
        return (Number) getAttributeInternal(ARTID);
    }

    /**
     * Sets <code>value</code> as attribute value for ART_ID using the alias name ArtId.
     * @param value value to set the ART_ID
     */
    public void setArtId(Number value) {
        setAttributeInternal(ARTID, value);
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
     * Gets the attribute value for PLACE using the alias name Place.
     * @return the PLACE
     */
    public String getPlace() {
        return (String) getAttributeInternal(PLACE);
    }

    /**
     * Sets <code>value</code> as attribute value for PLACE using the alias name Place.
     * @param value value to set the PLACE
     */
    public void setPlace(String value) {
        setAttributeInternal(PLACE, value);
    }

    /**
     * Gets the attribute value for PUBLISHER using the alias name Publisher1.
     * @return the PUBLISHER
     */
    public String getPublisher1() {
        return (String) getAttributeInternal(PUBLISHER1);
    }

    /**
     * Sets <code>value</code> as attribute value for PUBLISHER using the alias name Publisher1.
     * @param value value to set the PUBLISHER
     */
    public void setPublisher1(String value) {
        setAttributeInternal(PUBLISHER1, value);
    }

    /**
     * Gets the attribute value for READING_ORDER using the alias name ReadingOrder.
     * @return the READING_ORDER
     */
    public Number getReadingOrder() {
        return (Number) getAttributeInternal(READINGORDER);
    }

    /**
     * Sets <code>value</code> as attribute value for READING_ORDER using the alias name ReadingOrder.
     * @param value value to set the READING_ORDER
     */
    public void setReadingOrder(Number value) {
        setAttributeInternal(READINGORDER, value);
    }

    /**
     * Gets the view accessor <code>RowSet</code> ReadingOrderLovVO1.
     */
    public RowSet getReadingOrderLovVO1() {
        return (RowSet)getAttributeInternal(READINGORDERLOVVO1);
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
