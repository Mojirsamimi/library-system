package org.parsisys.tehranuniversity.library.model.vo.RO;

import oracle.jbo.Row;
import oracle.jbo.RowIterator;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Apr 21 15:25:46 GMT+04:00 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PhysicalBookVolPartVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        VolNo {
            public Object get(PhysicalBookVolPartVORowImpl obj) {
                return obj.getVolNo();
            }

            public void put(PhysicalBookVolPartVORowImpl obj, Object value) {
                obj.setVolNo((String)value);
            }
        }
        ,
        PartNo {
            public Object get(PhysicalBookVolPartVORowImpl obj) {
                return obj.getPartNo();
            }

            public void put(PhysicalBookVolPartVORowImpl obj, Object value) {
                obj.setPartNo((String)value);
            }
        }
        ,
        Flag {
            public Object get(PhysicalBookVolPartVORowImpl obj) {
                return obj.getFlag();
            }

            public void put(PhysicalBookVolPartVORowImpl obj, Object value) {
                obj.setFlag((Number)value);
            }
        }
        ,
        VbookArtId {
            public Object get(PhysicalBookVolPartVORowImpl obj) {
                return obj.getVbookArtId();
            }

            public void put(PhysicalBookVolPartVORowImpl obj, Object value) {
                obj.setVbookArtId((Number)value);
            }
        }
        ,
        Labcol {
            public Object get(PhysicalBookVolPartVORowImpl obj) {
                return obj.getLabcol();
            }

            public void put(PhysicalBookVolPartVORowImpl obj, Object value) {
                obj.setLabcol((Number)value);
            }
        }
        ,
        VirtualBookVO {
            public Object get(PhysicalBookVolPartVORowImpl obj) {
                return obj.getVirtualBookVO();
            }

            public void put(PhysicalBookVolPartVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        ReserveVO {
            public Object get(PhysicalBookVolPartVORowImpl obj) {
                return obj.getReserveVO();
            }

            public void put(PhysicalBookVolPartVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(PhysicalBookVolPartVORowImpl object);

        public abstract void put(PhysicalBookVolPartVORowImpl object,
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


    public static final int VOLNO = AttributesEnum.VolNo.index();
    public static final int PARTNO = AttributesEnum.PartNo.index();
    public static final int FLAG = AttributesEnum.Flag.index();
    public static final int VBOOKARTID = AttributesEnum.VbookArtId.index();
    public static final int LABCOL = AttributesEnum.Labcol.index();
    public static final int VIRTUALBOOKVO = AttributesEnum.VirtualBookVO.index();
    public static final int RESERVEVO = AttributesEnum.ReserveVO.index();

    /**
     * This is the default constructor (do not remove).
     */
    public PhysicalBookVolPartVORowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute VolNo.
     * @return the VolNo
     */
    public String getVolNo() {
        return (String) getAttributeInternal(VOLNO);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute VolNo.
     * @param value value to set the  VolNo
     */
    public void setVolNo(String value) {
        setAttributeInternal(VOLNO, value);
    }

    /**
     * Gets the attribute value for the calculated attribute PartNo.
     * @return the PartNo
     */
    public String getPartNo() {
        return (String) getAttributeInternal(PARTNO);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute PartNo.
     * @param value value to set the  PartNo
     */
    public void setPartNo(String value) {
        setAttributeInternal(PARTNO, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Flag.
     * @return the Flag
     */
    public Number getFlag() {
        return (Number) getAttributeInternal(FLAG);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Flag.
     * @param value value to set the  Flag
     */
    public void setFlag(Number value) {
        setAttributeInternal(FLAG, value);
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
     * Gets the associated <code>Row</code> using master-detail link VirtualBookVO.
     */
    public Row getVirtualBookVO() {
        return (Row)getAttributeInternal(VIRTUALBOOKVO);
    }

    /**
     * Sets the master-detail link VirtualBookVO between this object and <code>value</code>.
     */
    public void setVirtualBookVO(Row value) {
        setAttributeInternal(VIRTUALBOOKVO, value);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link ReserveVO.
     */
    public RowIterator getReserveVO() {
        return (RowIterator)getAttributeInternal(RESERVEVO);
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
