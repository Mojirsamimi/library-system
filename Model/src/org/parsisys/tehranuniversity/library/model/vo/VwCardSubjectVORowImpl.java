package org.parsisys.tehranuniversity.library.model.vo;

import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Jan 05 11:20:54 GMT+03:30 2013
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class VwCardSubjectVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        Labcol {
            public Object get(VwCardSubjectVORowImpl obj) {
                return obj.getLabcol();
            }

            public void put(VwCardSubjectVORowImpl obj, Object value) {
                obj.setLabcol((Number)value);
            }
        }
        ,
        Subject {
            public Object get(VwCardSubjectVORowImpl obj) {
                return obj.getSubject();
            }

            public void put(VwCardSubjectVORowImpl obj, Object value) {
                obj.setSubject((String)value);
            }
        }
        ,
        ReadingOrder {
            public Object get(VwCardSubjectVORowImpl obj) {
                return obj.getReadingOrder();
            }

            public void put(VwCardSubjectVORowImpl obj, Object value) {
                obj.setReadingOrder((Number)value);
            }
        }
        ,
        Printable {
            public Object get(VwCardSubjectVORowImpl obj) {
                return obj.getPrintable();
            }

            public void put(VwCardSubjectVORowImpl obj, Object value) {
                obj.setPrintable((Number)value);
            }
        }
        ,
        VbookArtId {
            public Object get(VwCardSubjectVORowImpl obj) {
                return obj.getVbookArtId();
            }

            public void put(VwCardSubjectVORowImpl obj, Object value) {
                obj.setVbookArtId((Number)value);
            }
        }
        ,
        ArtId {
            public Object get(VwCardSubjectVORowImpl obj) {
                return obj.getArtId();
            }

            public void put(VwCardSubjectVORowImpl obj, Object value) {
                obj.setArtId((Number)value);
            }
        }
        ,
        OrderNo {
            public Object get(VwCardSubjectVORowImpl obj) {
                return obj.getOrderNo();
            }

            public void put(VwCardSubjectVORowImpl obj, Object value) {
                obj.setOrderNo((Number)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(VwCardSubjectVORowImpl object);

        public abstract void put(VwCardSubjectVORowImpl object, Object value);

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
    public static final int SUBJECT = AttributesEnum.Subject.index();
    public static final int READINGORDER = AttributesEnum.ReadingOrder.index();
    public static final int PRINTABLE = AttributesEnum.Printable.index();
    public static final int VBOOKARTID = AttributesEnum.VbookArtId.index();
    public static final int ARTID = AttributesEnum.ArtId.index();
    public static final int ORDERNO = AttributesEnum.OrderNo.index();

    /**
     * This is the default constructor (do not remove).
     */
    public VwCardSubjectVORowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute Labcol.
     * @return the Labcol
     */
    public Number getLabcol() {
        return (Number) getAttributeInternal(LABCOL);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Labcol.
     * @param value value to set the  Labcol
     */
    public void setLabcol(Number value) {
        setAttributeInternal(LABCOL, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Subject.
     * @return the Subject
     */
    public String getSubject() {
        return (String) getAttributeInternal(SUBJECT);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Subject.
     * @param value value to set the  Subject
     */
    public void setSubject(String value) {
        setAttributeInternal(SUBJECT, value);
    }

    /**
     * Gets the attribute value for the calculated attribute ReadingOrder.
     * @return the ReadingOrder
     */
    public Number getReadingOrder() {
        return (Number) getAttributeInternal(READINGORDER);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute ReadingOrder.
     * @param value value to set the  ReadingOrder
     */
    public void setReadingOrder(Number value) {
        setAttributeInternal(READINGORDER, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Printable.
     * @return the Printable
     */
    public Number getPrintable() {
        return (Number) getAttributeInternal(PRINTABLE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Printable.
     * @param value value to set the  Printable
     */
    public void setPrintable(Number value) {
        setAttributeInternal(PRINTABLE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute VbookArtId.
     * @return the VbookArtId
     */
    public Number getVbookArtId() {
        return (Number) getAttributeInternal(VBOOKARTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute VbookArtId.
     * @param value value to set the  VbookArtId
     */
    public void setVbookArtId(Number value) {
        setAttributeInternal(VBOOKARTID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute ArtId.
     * @return the ArtId
     */
    public Number getArtId() {
        return (Number) getAttributeInternal(ARTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute ArtId.
     * @param value value to set the  ArtId
     */
    public void setArtId(Number value) {
        setAttributeInternal(ARTID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute OrderNo.
     * @return the OrderNo
     */
    public Number getOrderNo() {
        return (Number) getAttributeInternal(ORDERNO);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute OrderNo.
     * @param value value to set the  OrderNo
     */
    public void setOrderNo(Number value) {
        setAttributeInternal(ORDERNO, value);
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
