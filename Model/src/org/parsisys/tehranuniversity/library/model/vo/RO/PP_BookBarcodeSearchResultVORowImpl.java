package org.parsisys.tehranuniversity.library.model.vo.RO;

import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Oct 29 17:26:45 GMT+03:30 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PP_BookBarcodeSearchResultVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        ArtId {
            public Object get(PP_BookBarcodeSearchResultVORowImpl obj) {
                return obj.getArtId();
            }

            public void put(PP_BookBarcodeSearchResultVORowImpl obj,
                            Object value) {
                obj.setArtId((Number)value);
            }
        }
        ,
        Labcol {
            public Object get(PP_BookBarcodeSearchResultVORowImpl obj) {
                return obj.getLabcol();
            }

            public void put(PP_BookBarcodeSearchResultVORowImpl obj,
                            Object value) {
                obj.setLabcol((Number)value);
            }
        }
        ,
        Title {
            public Object get(PP_BookBarcodeSearchResultVORowImpl obj) {
                return obj.getTitle();
            }

            public void put(PP_BookBarcodeSearchResultVORowImpl obj,
                            Object value) {
                obj.setTitle((String)value);
            }
        }
        ,
        CallNo {
            public Object get(PP_BookBarcodeSearchResultVORowImpl obj) {
                return obj.getCallNo();
            }

            public void put(PP_BookBarcodeSearchResultVORowImpl obj,
                            Object value) {
                obj.setCallNo((String)value);
            }
        }
        ,
        BarcodeType {
            public Object get(PP_BookBarcodeSearchResultVORowImpl obj) {
                return obj.getBarcodeType();
            }

            public void put(PP_BookBarcodeSearchResultVORowImpl obj,
                            Object value) {
                obj.setBarcodeType((String)value);
            }
        }
        ,
        Barcode {
            public Object get(PP_BookBarcodeSearchResultVORowImpl obj) {
                return obj.getBarcode();
            }

            public void put(PP_BookBarcodeSearchResultVORowImpl obj,
                            Object value) {
                obj.setBarcode((String)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(PP_BookBarcodeSearchResultVORowImpl object);

        public abstract void put(PP_BookBarcodeSearchResultVORowImpl object,
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
    public static final int TITLE = AttributesEnum.Title.index();
    public static final int CALLNO = AttributesEnum.CallNo.index();
    public static final int BARCODETYPE = AttributesEnum.BarcodeType.index();
    public static final int BARCODE = AttributesEnum.Barcode.index();

    /**
     * This is the default constructor (do not remove).
     */
    public PP_BookBarcodeSearchResultVORowImpl() {
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
     * Gets the attribute value for the calculated attribute Title.
     * @return the Title
     */
    public String getTitle() {
        return (String) getAttributeInternal(TITLE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Title.
     * @param value value to set the  Title
     */
    public void setTitle(String value) {
        setAttributeInternal(TITLE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute CallNo.
     * @return the CallNo
     */
    public String getCallNo() {
        return (String) getAttributeInternal(CALLNO);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute CallNo.
     * @param value value to set the  CallNo
     */
    public void setCallNo(String value) {
        setAttributeInternal(CALLNO, value);
    }

    /**
     * Gets the attribute value for the calculated attribute BarcodeType.
     * @return the BarcodeType
     */
    public String getBarcodeType() {
        return (String) getAttributeInternal(BARCODETYPE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute BarcodeType.
     * @param value value to set the  BarcodeType
     */
    public void setBarcodeType(String value) {
        setAttributeInternal(BARCODETYPE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Barcode.
     * @return the Barcode
     */
    public String getBarcode() {
        return (String) getAttributeInternal(BARCODE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Barcode.
     * @param value value to set the  Barcode
     */
    public void setBarcode(String value) {
        setAttributeInternal(BARCODE, value);
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
