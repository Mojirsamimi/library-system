package org.parsisys.tehranuniversity.library.model.vo;

import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Apr 21 13:07:03 GMT+03:30 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class MemberVoRowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        ArtId {
            public Object get(MemberVoRowImpl obj) {
                return obj.getArtId();
            }

            public void put(MemberVoRowImpl obj, Object value) {
                obj.setArtId((Number)value);
            }
        }
        ,
        Description {
            public Object get(MemberVoRowImpl obj) {
                return obj.getDescription();
            }

            public void put(MemberVoRowImpl obj, Object value) {
                obj.setDescription((String)value);
            }
        }
        ,
        Labcol {
            public Object get(MemberVoRowImpl obj) {
                return obj.getLabcol();
            }

            public void put(MemberVoRowImpl obj, Object value) {
                obj.setLabcol((Number)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(MemberVoRowImpl object);

        public abstract void put(MemberVoRowImpl object, Object value);

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
    public static final int DESCRIPTION = AttributesEnum.Description.index();
    public static final int LABCOL = AttributesEnum.Labcol.index();

    /**
     * This is the default constructor (do not remove).
     */
    public MemberVoRowImpl() {
    }

    /**
     * Gets Member entity object.
     * @return the Member
     */
    public EntityImpl getMember() {
        return (EntityImpl)getEntity(0);
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
     * Gets the attribute value for DESCRIPTION using the alias name Description.
     * @return the DESCRIPTION
     */
    public String getDescription() {
        return (String) getAttributeInternal(DESCRIPTION);
    }

    /**
     * Sets <code>value</code> as attribute value for DESCRIPTION using the alias name Description.
     * @param value value to set the DESCRIPTION
     */
    public void setDescription(String value) {
        setAttributeInternal(DESCRIPTION, value);
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
