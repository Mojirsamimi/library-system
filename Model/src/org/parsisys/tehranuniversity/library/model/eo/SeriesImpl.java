package org.parsisys.tehranuniversity.library.model.eo;

import fadak.base.TemplateEntityObject;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Jan 26 17:36:47 CST 2013
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SeriesImpl extends TemplateEntityObject {
    private static EntityDefImpl mDefinitionObject;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        Labcol {
            public Object get(SeriesImpl obj) {
                return obj.getLabcol();
            }

            public void put(SeriesImpl obj, Object value) {
                obj.setLabcol((Number)value);
            }
        }
        ,
        VbookArtId {
            public Object get(SeriesImpl obj) {
                return obj.getVbookArtId();
            }

            public void put(SeriesImpl obj, Object value) {
                obj.setVbookArtId((Number)value);
            }
        }
        ,
        Series {
            public Object get(SeriesImpl obj) {
                return obj.getSeries();
            }

            public void put(SeriesImpl obj, Object value) {
                obj.setSeries((String)value);
            }
        }
        ,
        OrderNo {
            public Object get(SeriesImpl obj) {
                return obj.getOrderNo();
            }

            public void put(SeriesImpl obj, Object value) {
                obj.setOrderNo((Number)value);
            }
        }
        ,
        Printable {
            public Object get(SeriesImpl obj) {
                return obj.getPrintable();
            }

            public void put(SeriesImpl obj, Object value) {
                obj.setPrintable((Number)value);
            }
        }
        ,
        VirtualBook {
            public Object get(SeriesImpl obj) {
                return obj.getVirtualBook();
            }

            public void put(SeriesImpl obj, Object value) {
                obj.setVirtualBook((VirtualBookImpl)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(SeriesImpl object);

        public abstract void put(SeriesImpl object, Object value);

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
    public static final int VBOOKARTID = AttributesEnum.VbookArtId.index();
    public static final int SERIES = AttributesEnum.Series.index();
    public static final int ORDERNO = AttributesEnum.OrderNo.index();
    public static final int PRINTABLE = AttributesEnum.Printable.index();
    public static final int VIRTUALBOOK = AttributesEnum.VirtualBook.index();

    /**
     * This is the default constructor (do not remove).
     */
    public SeriesImpl() {
    }


    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("org.parsisys.tehranuniversity.library.model.eo.Series");
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
     * Gets the attribute value for Series, using the alias name Series.
     * @return the Series
     */
    public String getSeries() {
        return (String)getAttributeInternal(SERIES);
    }

    /**
     * Sets <code>value</code> as the attribute value for Series.
     * @param value value to set the Series
     */
    public void setSeries(String value) {
        setAttributeInternal(SERIES, value);
    }

    /**
     * Gets the attribute value for OrderNo, using the alias name OrderNo.
     * @return the OrderNo
     */
    public Number getOrderNo() {
        return (Number)getAttributeInternal(ORDERNO);
    }

    /**
     * Sets <code>value</code> as the attribute value for OrderNo.
     * @param value value to set the OrderNo
     */
    public void setOrderNo(Number value) {
        setAttributeInternal(ORDERNO, value);
    }

    /**
     * Gets the attribute value for Printable, using the alias name Printable.
     * @return the Printable
     */
    public Number getPrintable() {
        return (Number)getAttributeInternal(PRINTABLE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Printable.
     * @param value value to set the Printable
     */
    public void setPrintable(Number value) {
        setAttributeInternal(PRINTABLE, value);
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
     * @param labcol key constituent
     * @param vbookArtId key constituent
     * @param series key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Number labcol, Number vbookArtId,
                                       String series) {
        return new Key(new Object[]{labcol, vbookArtId, series});
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
