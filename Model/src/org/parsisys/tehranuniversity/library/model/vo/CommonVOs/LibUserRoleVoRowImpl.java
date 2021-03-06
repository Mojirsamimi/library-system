package org.parsisys.tehranuniversity.library.model.vo.CommonVOs;

import oracle.jbo.RowIterator;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue May 22 16:06:41 GMT+03:30 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class LibUserRoleVoRowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        Labcol {
            public Object get(LibUserRoleVoRowImpl obj) {
                return obj.getLabcol();
            }

            public void put(LibUserRoleVoRowImpl obj, Object value) {
                obj.setLabcol((Number)value);
            }
        }
        ,
        LibroleArtId {
            public Object get(LibUserRoleVoRowImpl obj) {
                return obj.getLibroleArtId();
            }

            public void put(LibUserRoleVoRowImpl obj, Object value) {
                obj.setLibroleArtId((Number)value);
            }
        }
        ,
        LibuserUserName {
            public Object get(LibUserRoleVoRowImpl obj) {
                return obj.getLibuserUserName();
            }

            public void put(LibUserRoleVoRowImpl obj, Object value) {
                obj.setLibuserUserName((String)value);
            }
        }
        ,
        LibUserVo {
            public Object get(LibUserRoleVoRowImpl obj) {
                return obj.getLibUserVo();
            }

            public void put(LibUserRoleVoRowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(LibUserRoleVoRowImpl object);

        public abstract void put(LibUserRoleVoRowImpl object, Object value);

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
    public static final int LIBROLEARTID = AttributesEnum.LibroleArtId.index();
    public static final int LIBUSERUSERNAME = AttributesEnum.LibuserUserName.index();
    public static final int LIBUSERVO = AttributesEnum.LibUserVo.index();

    /**
     * This is the default constructor (do not remove).
     */
    public LibUserRoleVoRowImpl() {
    }

    /**
     * Gets LibUserRole entity object.
     * @return the LibUserRole
     */
    public EntityImpl getLibUserRole() {
        return (EntityImpl)getEntity(0);
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
     * Gets the attribute value for LIBROLE_ART_ID using the alias name LibroleArtId.
     * @return the LIBROLE_ART_ID
     */
    public Number getLibroleArtId() {
        return (Number) getAttributeInternal(LIBROLEARTID);
    }

    /**
     * Sets <code>value</code> as attribute value for LIBROLE_ART_ID using the alias name LibroleArtId.
     * @param value value to set the LIBROLE_ART_ID
     */
    public void setLibroleArtId(Number value) {
        setAttributeInternal(LIBROLEARTID, value);
    }

    /**
     * Gets the attribute value for LIBUSER_USER_NAME using the alias name LibuserUserName.
     * @return the LIBUSER_USER_NAME
     */
    public String getLibuserUserName() {
        return (String) getAttributeInternal(LIBUSERUSERNAME);
    }

    /**
     * Sets <code>value</code> as attribute value for LIBUSER_USER_NAME using the alias name LibuserUserName.
     * @param value value to set the LIBUSER_USER_NAME
     */
    public void setLibuserUserName(String value) {
        setAttributeInternal(LIBUSERUSERNAME, value);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link LibUserVo.
     */
    public RowIterator getLibUserVo() {
        return (RowIterator)getAttributeInternal(LIBUSERVO);
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
