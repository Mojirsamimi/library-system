package org.parsisys.tehranuniversity.library.model.eo.CommonEOs;

import fadak.base.TemplateEntityObject;

import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.RowSet;
import oracle.jbo.domain.DBSequence;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;

import org.parsisys.tehranuniversity.library.model.vo.RO.DummyVOImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sun Jan 13 16:43:38 CST 2013
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class LibRoleImpl extends TemplateEntityObject {
    private static EntityDefImpl mDefinitionObject;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        ArtId {
            public Object get(LibRoleImpl obj) {
                return obj.getArtId();
            }

            public void put(LibRoleImpl obj, Object value) {
                obj.setArtId((Number)value);
            }
        }
        ,
        RoleName {
            public Object get(LibRoleImpl obj) {
                return obj.getRoleName();
            }

            public void put(LibRoleImpl obj, Object value) {
                obj.setRoleName((String)value);
            }
        }
        ,
        Description {
            public Object get(LibRoleImpl obj) {
                return obj.getDescription();
            }

            public void put(LibRoleImpl obj, Object value) {
                obj.setDescription((String)value);
            }
        }
        ,
        SecurityCode {
            public Object get(LibRoleImpl obj) {
                return obj.getSecurityCode();
            }

            public void put(LibRoleImpl obj, Object value) {
                obj.setSecurityCode((String)value);
            }
        }
        ,
        LibUser1 {
            public Object get(LibRoleImpl obj) {
                return obj.getLibUser1();
            }

            public void put(LibRoleImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        LibUser {
            public Object get(LibRoleImpl obj) {
                return obj.getLibUser();
            }

            public void put(LibRoleImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        LibUserRole {
            public Object get(LibRoleImpl obj) {
                return obj.getLibUserRole();
            }

            public void put(LibRoleImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        DummyVO1 {
            public Object get(LibRoleImpl obj) {
                return obj.getDummyVO1();
            }

            public void put(LibRoleImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(LibRoleImpl object);

        public abstract void put(LibRoleImpl object, Object value);

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
    public static final int ROLENAME = AttributesEnum.RoleName.index();
    public static final int DESCRIPTION = AttributesEnum.Description.index();
    public static final int SECURITYCODE = AttributesEnum.SecurityCode.index();
    public static final int LIBUSER1 = AttributesEnum.LibUser1.index();
    public static final int LIBUSER = AttributesEnum.LibUser.index();
    public static final int LIBUSERROLE = AttributesEnum.LibUserRole.index();
    public static final int DUMMYVO1 = AttributesEnum.DummyVO1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public LibRoleImpl() {
    }


    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("org.parsisys.tehranuniversity.library.model.eo.CommonEOs.LibRole");
        }
        return mDefinitionObject;
    }

    /**
     * Gets the attribute value for ArtId, using the alias name ArtId.
     * @return the ArtId
     */
    public Number getArtId() {
        return (Number)getAttributeInternal(ARTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for ArtId.
     * @param value value to set the ArtId
     */
    public void setArtId(Number value) {
        setAttributeInternal(ARTID, value);
    }

    /**
     * Gets the attribute value for RoleName, using the alias name RoleName.
     * @return the RoleName
     */
    public String getRoleName() {
        return (String)getAttributeInternal(ROLENAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for RoleName.
     * @param value value to set the RoleName
     */
    public void setRoleName(String value) {
        setAttributeInternal(ROLENAME, value);
    }

    /**
     * Gets the attribute value for Description, using the alias name Description.
     * @return the Description
     */
    public String getDescription() {
        return (String)getAttributeInternal(DESCRIPTION);
    }

    /**
     * Sets <code>value</code> as the attribute value for Description.
     * @param value value to set the Description
     */
    public void setDescription(String value) {
        setAttributeInternal(DESCRIPTION, value);
    }

    /**
     * Gets the attribute value for SecurityCode, using the alias name SecurityCode.
     * @return the SecurityCode
     */
    public String getSecurityCode() {
        return (String)getAttributeInternal(SECURITYCODE);
    }

    /**
     * Sets <code>value</code> as the attribute value for SecurityCode.
     * @param value value to set the SecurityCode
     */
    public void setSecurityCode(String value) {
        setAttributeInternal(SECURITYCODE, value);
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
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getLibUser1() {
        return (RowIterator)getAttributeInternal(LIBUSER1);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getLibUser() {
        return (RowIterator)getAttributeInternal(LIBUSER);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getLibUserRole() {
        return (RowIterator)getAttributeInternal(LIBUSERROLE);
    }

    /**
     * Gets the view accessor <code>RowSet</code> DummyVO1.
     */
    public RowSet getDummyVO1() {
        return (RowSet)getAttributeInternal(DUMMYVO1);
    }


    /**
     * @param artId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Number artId) {
        return new Key(new Object[]{artId});
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
      if(operation==DML_INSERT)
      {
      DummyVOImpl dummyVO=(DummyVOImpl)getDummyVO1().getViewObject();
      
      dummyVO.setQuery("select max(art_id) from lib_role");
      dummyVO.executeQuery();
      dummyVO.first();
      String s= dummyVO.getCurrentRow().getAttribute("Dummy").toString();
      long artId;
      if(s==null || "".equalsIgnoreCase(s))
         artId=0;
      else
         artId=Long.valueOf(s);
      
      ++artId;
      setArtId(new Number(artId));
      }
      
        super.doDML(operation, e);
    }
}
