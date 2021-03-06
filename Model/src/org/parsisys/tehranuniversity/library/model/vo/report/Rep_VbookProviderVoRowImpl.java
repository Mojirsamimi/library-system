package org.parsisys.tehranuniversity.library.model.vo.report;

import oracle.jbo.domain.DBSequence;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;

import org.parsisys.tehranuniversity.library.model.eo.ProviderRoleImpl;
import org.parsisys.tehranuniversity.library.model.eo.VbookProviderImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sun Mar 03 15:36:42 CST 2013
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class Rep_VbookProviderVoRowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        ArtId {
            public Object get(Rep_VbookProviderVoRowImpl obj) {
                return obj.getArtId();
            }

            public void put(Rep_VbookProviderVoRowImpl obj, Object value) {
                obj.setArtId((Number)value);
            }
        }
        ,
        EntryKind {
            public Object get(Rep_VbookProviderVoRowImpl obj) {
                return obj.getEntryKind();
            }

            public void put(Rep_VbookProviderVoRowImpl obj, Object value) {
                obj.setEntryKind((Number)value);
            }
        }
        ,
        Labcol {
            public Object get(Rep_VbookProviderVoRowImpl obj) {
                return obj.getLabcol();
            }

            public void put(Rep_VbookProviderVoRowImpl obj, Object value) {
                obj.setLabcol((Number)value);
            }
        }
        ,
        OrderNo {
            public Object get(Rep_VbookProviderVoRowImpl obj) {
                return obj.getOrderNo();
            }

            public void put(Rep_VbookProviderVoRowImpl obj, Object value) {
                obj.setOrderNo((Number)value);
            }
        }
        ,
        Printable {
            public Object get(Rep_VbookProviderVoRowImpl obj) {
                return obj.getPrintable();
            }

            public void put(Rep_VbookProviderVoRowImpl obj, Object value) {
                obj.setPrintable((Number)value);
            }
        }
        ,
        PrvArtId {
            public Object get(Rep_VbookProviderVoRowImpl obj) {
                return obj.getPrvArtId();
            }

            public void put(Rep_VbookProviderVoRowImpl obj, Object value) {
                obj.setPrvArtId((Number)value);
            }
        }
        ,
        PrvroleArtId {
            public Object get(Rep_VbookProviderVoRowImpl obj) {
                return obj.getPrvroleArtId();
            }

            public void put(Rep_VbookProviderVoRowImpl obj, Object value) {
                obj.setPrvroleArtId((Number)value);
            }
        }
        ,
        TitleRefer {
            public Object get(Rep_VbookProviderVoRowImpl obj) {
                return obj.getTitleRefer();
            }

            public void put(Rep_VbookProviderVoRowImpl obj, Object value) {
                obj.setTitleRefer((String)value);
            }
        }
        ,
        VbookArtId {
            public Object get(Rep_VbookProviderVoRowImpl obj) {
                return obj.getVbookArtId();
            }

            public void put(Rep_VbookProviderVoRowImpl obj, Object value) {
                obj.setVbookArtId((Number)value);
            }
        }
        ,
        Provider1 {
            public Object get(Rep_VbookProviderVoRowImpl obj) {
                return obj.getProvider1();
            }

            public void put(Rep_VbookProviderVoRowImpl obj, Object value) {
                obj.setProvider1((String)value);
            }
        }
        ,
        Labcol1 {
            public Object get(Rep_VbookProviderVoRowImpl obj) {
                return obj.getLabcol1();
            }

            public void put(Rep_VbookProviderVoRowImpl obj, Object value) {
                obj.setLabcol1((Number)value);
            }
        }
        ,
        ArtId1 {
            public Object get(Rep_VbookProviderVoRowImpl obj) {
                return obj.getArtId1();
            }

            public void put(Rep_VbookProviderVoRowImpl obj, Object value) {
                obj.setArtId1((DBSequence)value);
            }
        }
        ,
        BDDate {
            public Object get(Rep_VbookProviderVoRowImpl obj) {
                return obj.getBDDate();
            }

            public void put(Rep_VbookProviderVoRowImpl obj, Object value) {
                obj.setBDDate((String)value);
            }
        }
        ,
        Role {
            public Object get(Rep_VbookProviderVoRowImpl obj) {
                return obj.getRole();
            }

            public void put(Rep_VbookProviderVoRowImpl obj, Object value) {
                obj.setRole((String)value);
            }
        }
        ,
        ArtId2 {
            public Object get(Rep_VbookProviderVoRowImpl obj) {
                return obj.getArtId2();
            }

            public void put(Rep_VbookProviderVoRowImpl obj, Object value) {
                obj.setArtId2((Number)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(Rep_VbookProviderVoRowImpl object);

        public abstract void put(Rep_VbookProviderVoRowImpl object,
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
    public static final int ENTRYKIND = AttributesEnum.EntryKind.index();
    public static final int LABCOL = AttributesEnum.Labcol.index();
    public static final int ORDERNO = AttributesEnum.OrderNo.index();
    public static final int PRINTABLE = AttributesEnum.Printable.index();
    public static final int PRVARTID = AttributesEnum.PrvArtId.index();
    public static final int PRVROLEARTID = AttributesEnum.PrvroleArtId.index();
    public static final int TITLEREFER = AttributesEnum.TitleRefer.index();
    public static final int VBOOKARTID = AttributesEnum.VbookArtId.index();
    public static final int PROVIDER1 = AttributesEnum.Provider1.index();
    public static final int LABCOL1 = AttributesEnum.Labcol1.index();
    public static final int ARTID1 = AttributesEnum.ArtId1.index();
    public static final int BDDATE = AttributesEnum.BDDate.index();
    public static final int ROLE = AttributesEnum.Role.index();
    public static final int ARTID2 = AttributesEnum.ArtId2.index();

    /**
     * This is the default constructor (do not remove).
     */
    public Rep_VbookProviderVoRowImpl() {
    }

    /**
     * Gets VbookProvider entity object.
     * @return the VbookProvider
     */
    public VbookProviderImpl getVbookProvider() {
        return (VbookProviderImpl)getEntity(0);
    }

    /**
     * Gets Provider entity object.
     * @return the Provider
     */
    public org.parsisys.tehranuniversity.library.model.eo.ProviderImpl getProvider() {
        return (org.parsisys.tehranuniversity.library.model.eo.ProviderImpl)getEntity(1);
    }

    /**
     * Gets ProviderRole entity object.
     * @return the ProviderRole
     */
    public ProviderRoleImpl getProviderRole() {
        return (ProviderRoleImpl)getEntity(2);
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
     * Gets the attribute value for ENTRY_KIND using the alias name EntryKind.
     * @return the ENTRY_KIND
     */
    public Number getEntryKind() {
        return (Number) getAttributeInternal(ENTRYKIND);
    }

    /**
     * Sets <code>value</code> as attribute value for ENTRY_KIND using the alias name EntryKind.
     * @param value value to set the ENTRY_KIND
     */
    public void setEntryKind(Number value) {
        setAttributeInternal(ENTRYKIND, value);
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
     * Gets the attribute value for PRV_ART_ID using the alias name PrvArtId.
     * @return the PRV_ART_ID
     */
    public Number getPrvArtId() {
        return (Number) getAttributeInternal(PRVARTID);
    }

    /**
     * Sets <code>value</code> as attribute value for PRV_ART_ID using the alias name PrvArtId.
     * @param value value to set the PRV_ART_ID
     */
    public void setPrvArtId(Number value) {
        setAttributeInternal(PRVARTID, value);
    }

    /**
     * Gets the attribute value for PRVROLE_ART_ID using the alias name PrvroleArtId.
     * @return the PRVROLE_ART_ID
     */
    public Number getPrvroleArtId() {
        return (Number) getAttributeInternal(PRVROLEARTID);
    }

    /**
     * Sets <code>value</code> as attribute value for PRVROLE_ART_ID using the alias name PrvroleArtId.
     * @param value value to set the PRVROLE_ART_ID
     */
    public void setPrvroleArtId(Number value) {
        setAttributeInternal(PRVROLEARTID, value);
    }

    /**
     * Gets the attribute value for TITLE_REFER using the alias name TitleRefer.
     * @return the TITLE_REFER
     */
    public String getTitleRefer() {
        return (String) getAttributeInternal(TITLEREFER);
    }

    /**
     * Sets <code>value</code> as attribute value for TITLE_REFER using the alias name TitleRefer.
     * @param value value to set the TITLE_REFER
     */
    public void setTitleRefer(String value) {
        setAttributeInternal(TITLEREFER, value);
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
     * Gets the attribute value for PROVIDER using the alias name Provider1.
     * @return the PROVIDER
     */
    public String getProvider1() {
        return (String) getAttributeInternal(PROVIDER1);
    }

    /**
     * Sets <code>value</code> as attribute value for PROVIDER using the alias name Provider1.
     * @param value value to set the PROVIDER
     */
    public void setProvider1(String value) {
        setAttributeInternal(PROVIDER1, value);
    }

    /**
     * Gets the attribute value for LABCOL using the alias name Labcol1.
     * @return the LABCOL
     */
    public Number getLabcol1() {
        return (Number) getAttributeInternal(LABCOL1);
    }

    /**
     * Sets <code>value</code> as attribute value for LABCOL using the alias name Labcol1.
     * @param value value to set the LABCOL
     */
    public void setLabcol1(Number value) {
        setAttributeInternal(LABCOL1, value);
    }

    /**
     * Gets the attribute value for ART_ID using the alias name ArtId1.
     * @return the ART_ID
     */
    public DBSequence getArtId1() {
        return (DBSequence)getAttributeInternal(ARTID1);
    }

    /**
     * Sets <code>value</code> as attribute value for ART_ID using the alias name ArtId1.
     * @param value value to set the ART_ID
     */
    public void setArtId1(DBSequence value) {
        setAttributeInternal(ARTID1, value);
    }

    /**
     * Gets the attribute value for B_D_DATE using the alias name BDDate.
     * @return the B_D_DATE
     */
    public String getBDDate() {
        return (String) getAttributeInternal(BDDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for B_D_DATE using the alias name BDDate.
     * @param value value to set the B_D_DATE
     */
    public void setBDDate(String value) {
        setAttributeInternal(BDDATE, value);
    }

    /**
     * Gets the attribute value for ROLE using the alias name Role.
     * @return the ROLE
     */
    public String getRole() {
        return (String) getAttributeInternal(ROLE);
    }

    /**
     * Sets <code>value</code> as attribute value for ROLE using the alias name Role.
     * @param value value to set the ROLE
     */
    public void setRole(String value) {
        setAttributeInternal(ROLE, value);
    }

    /**
     * Gets the attribute value for ART_ID using the alias name ArtId2.
     * @return the ART_ID
     */
    public Number getArtId2() {
        return (Number) getAttributeInternal(ARTID2);
    }

    /**
     * Sets <code>value</code> as attribute value for ART_ID using the alias name ArtId2.
     * @param value value to set the ART_ID
     */
    public void setArtId2(Number value) {
        setAttributeInternal(ARTID2, value);
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
