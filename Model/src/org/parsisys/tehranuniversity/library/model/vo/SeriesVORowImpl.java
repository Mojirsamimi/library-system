package org.parsisys.tehranuniversity.library.model.vo;

import fadak.base.TemplateViewRow;

import oracle.jbo.RowSet;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;

import org.parsisys.tehranuniversity.library.model.eo.SeriesImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Oct 16 16:06:52 GST 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SeriesVORowImpl extends TemplateViewRow {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        Printable {
            public Object get(SeriesVORowImpl obj) {
                return obj.getPrintable();
            }

            public void put(SeriesVORowImpl obj, Object value) {
                obj.setPrintable((Number)value);
            }
        }
        ,
        Series1 {
            public Object get(SeriesVORowImpl obj) {
                return obj.getSeries1();
            }

            public void put(SeriesVORowImpl obj, Object value) {
                obj.setSeries1((String)value);
            }
        }
        ,
        Labcol {
            public Object get(SeriesVORowImpl obj) {
                return obj.getLabcol();
            }

            public void put(SeriesVORowImpl obj, Object value) {
                obj.setLabcol((Number)value);
            }
        }
        ,
        VbookArtId {
            public Object get(SeriesVORowImpl obj) {
                return obj.getVbookArtId();
            }

            public void put(SeriesVORowImpl obj, Object value) {
                obj.setVbookArtId((Number)value);
            }
        }
        ,
        OrderNo {
            public Object get(SeriesVORowImpl obj) {
                return obj.getOrderNo();
            }

            public void put(SeriesVORowImpl obj, Object value) {
                obj.setOrderNo((Number)value);
            }
        }
        ,
        printBoolean {
            public Object get(SeriesVORowImpl obj) {
                return obj.getprintBoolean();
            }

            public void put(SeriesVORowImpl obj, Object value) {
                obj.setprintBoolean((Boolean)value);
            }
        }
        ,
        SeriesVO_VirtualBookVOLookup {
            public Object get(SeriesVORowImpl obj) {
                return obj.getSeriesVO_VirtualBookVOLookup();
            }

            public void put(SeriesVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        CheckBox01View1 {
            public Object get(SeriesVORowImpl obj) {
                return obj.getCheckBox01View1();
            }

            public void put(SeriesVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(SeriesVORowImpl object);

        public abstract void put(SeriesVORowImpl object, Object value);

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


    public static final int PRINTABLE = AttributesEnum.Printable.index();
    public static final int SERIES1 = AttributesEnum.Series1.index();
    public static final int LABCOL = AttributesEnum.Labcol.index();
    public static final int VBOOKARTID = AttributesEnum.VbookArtId.index();
    public static final int ORDERNO = AttributesEnum.OrderNo.index();
    public static final int PRINTBOOLEAN = AttributesEnum.printBoolean.index();
    public static final int SERIESVO_VIRTUALBOOKVOLOOKUP = AttributesEnum.SeriesVO_VirtualBookVOLookup.index();
    public static final int CHECKBOX01VIEW1 = AttributesEnum.CheckBox01View1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public SeriesVORowImpl() {
    }

    /**
     * Gets Series entity object.
     * @return the Series
     */
    public SeriesImpl getSeries() {
        return (SeriesImpl)getEntity(0);
    }

    /**
     * Gets the attribute value for PRINTABLE using the alias name Printable.
     * @return the PRINTABLE
     */
    public Number getPrintable() {
        return (Number) getAttributeInternal(PRINTABLE);
    }

    /**
     * Sets <code>value</code> as attribute value for PRINTABLE using the alias name Printable.
     * @param value value to set the PRINTABLE
     */
    public void setPrintable(Number value) {
        setAttributeInternal(PRINTABLE, value);
    }

    /**
     * Gets the attribute value for SERIES using the alias name Series1.
     * @return the SERIES
     */
    public String getSeries1() {
        return (String) getAttributeInternal(SERIES1);
    }

    /**
     * Sets <code>value</code> as attribute value for SERIES using the alias name Series1.
     * @param value value to set the SERIES
     */
    public void setSeries1(String value) {
        setAttributeInternal(SERIES1, value);
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
     * Gets the attribute value for ORDER_NO using the alias name OrderNo.
     * @return the ORDER_NO
     */
    public Number getOrderNo() {
        return (Number) getAttributeInternal(ORDERNO);
    }

    /**
     * Sets <code>value</code> as attribute value for ORDER_NO using the alias name OrderNo.
     * @param value value to set the ORDER_NO
     */
    public void setOrderNo(Number value) {
        setAttributeInternal(ORDERNO, value);
    }

    /**
     * Gets the attribute value for the calculated attribute printBoolean.
     * @return the printBoolean
     */
    public Boolean getprintBoolean() {
        if(getPrintable()==null  || getPrintable().equals(new Number(0))){
          return Boolean.FALSE;
        }
        return Boolean.TRUE;
        //return (Boolean) getAttributeInternal(PRINTBOOLEAN);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute printBoolean.
     * @param value value to set the  printBoolean
     */
    public void setprintBoolean(Boolean value) {
        setAttributeInternal(PRINTBOOLEAN, value);
if(value==null || value.equals(Boolean.FALSE))
    setPrintable(new Number(0));
else
    setPrintable(new Number(1));
//System.out/.println("it is set... with value: "+value);
        }

    /**
     * Gets the view accessor <code>RowSet</code> SeriesVO_VirtualBookVOLookup.
     */
    public RowSet getSeriesVO_VirtualBookVOLookup() {
        return (RowSet)getAttributeInternal(SERIESVO_VIRTUALBOOKVOLOOKUP);
    }

    /**
     * Gets the view accessor <code>RowSet</code> CheckBox01View1.
     */
    public RowSet getCheckBox01View1() {
        return (RowSet)getAttributeInternal(CHECKBOX01VIEW1);
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
