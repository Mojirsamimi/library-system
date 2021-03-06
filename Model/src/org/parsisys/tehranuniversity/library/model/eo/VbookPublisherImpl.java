package org.parsisys.tehranuniversity.library.model.eo;

import fadak.base.TemplateEntityObject;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Jan 26 17:35:01 CST 2013
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class VbookPublisherImpl extends TemplateEntityObject {
    private static EntityDefImpl mDefinitionObject;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        Labcol {
            public Object get(VbookPublisherImpl obj) {
                return obj.getLabcol();
            }

            public void put(VbookPublisherImpl obj, Object value) {
                obj.setLabcol((Number)value);
            }
        }
        ,
        VbookArtId {
            public Object get(VbookPublisherImpl obj) {
                return obj.getVbookArtId();
            }

            public void put(VbookPublisherImpl obj, Object value) {
                obj.setVbookArtId((Number)value);
            }
        }
        ,
        OrderNo {
            public Object get(VbookPublisherImpl obj) {
                return obj.getOrderNo();
            }

            public void put(VbookPublisherImpl obj, Object value) {
                obj.setOrderNo((Number)value);
            }
        }
        ,
        PubArtId {
            public Object get(VbookPublisherImpl obj) {
                return obj.getPubArtId();
            }

            public void put(VbookPublisherImpl obj, Object value) {
                obj.setPubArtId((Number)value);
            }
        }
        ,
        Printable {
            public Object get(VbookPublisherImpl obj) {
                return obj.getPrintable();
            }

            public void put(VbookPublisherImpl obj, Object value) {
                obj.setPrintable((Number)value);
            }
        }
        ,
        Publisher {
            public Object get(VbookPublisherImpl obj) {
                return obj.getPublisher();
            }

            public void put(VbookPublisherImpl obj, Object value) {
                obj.setPublisher((PublisherImpl)value);
            }
        }
        ,
        VirtualBook {
            public Object get(VbookPublisherImpl obj) {
                return obj.getVirtualBook();
            }

            public void put(VbookPublisherImpl obj, Object value) {
                obj.setVirtualBook((VirtualBookImpl)value);
            }
        }
        ,
        Publisher1 {
            public Object get(VbookPublisherImpl obj) {
                return obj.getPublisher1();
            }

            public void put(VbookPublisherImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(VbookPublisherImpl object);

        public abstract void put(VbookPublisherImpl object, Object value);

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
    public static final int ORDERNO = AttributesEnum.OrderNo.index();
    public static final int PUBARTID = AttributesEnum.PubArtId.index();
    public static final int PRINTABLE = AttributesEnum.Printable.index();
    public static final int PUBLISHER = AttributesEnum.Publisher.index();
    public static final int VIRTUALBOOK = AttributesEnum.VirtualBook.index();
    public static final int PUBLISHER1 = AttributesEnum.Publisher1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public VbookPublisherImpl() {
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
     * Gets the attribute value for PubArtId, using the alias name PubArtId.
     * @return the PubArtId
     */
    public Number getPubArtId() {
        return (Number)getAttributeInternal(PUBARTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for PubArtId.
     * @param value value to set the PubArtId
     */
    public void setPubArtId(Number value) {
        setAttributeInternal(PUBARTID, value);
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
     * @return the associated entity PublisherImpl.
     */
    public PublisherImpl getPublisher() {
        return (PublisherImpl)getAttributeInternal(PUBLISHER);
    }

    /**
     * Sets <code>value</code> as the associated entity PublisherImpl.
     */
    public void setPublisher(PublisherImpl value) {
        setAttributeInternal(PUBLISHER, value);
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
    public RowIterator getPublisher1() {
        return (RowIterator)getAttributeInternal(PUBLISHER1);
    }

    /**
     * @param labcol key constituent
     * @param vbookArtId key constituent
     * @param pubArtId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Number labcol, Number vbookArtId,
                                       Number pubArtId) {
        return new Key(new Object[]{labcol, vbookArtId, pubArtId});
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("org.parsisys.tehranuniversity.library.model.eo.VbookPublisher");
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
