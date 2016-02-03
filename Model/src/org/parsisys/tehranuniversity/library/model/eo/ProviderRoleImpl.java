package org.parsisys.tehranuniversity.library.model.eo;

import fadak.base.TemplateEntityObject;

import oracle.jbo.AttributeList;
import oracle.jbo.JboException;
import oracle.jbo.Key;
import oracle.jbo.RowSet;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.SequenceImpl;
import oracle.jbo.server.TransactionEvent;

import org.parsisys.tehranuniversity.library.model.vo.RO.DummyVOImpl;
import org.parsisys.tehranuniversity.library.util.ParsiUtil;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sun Jan 22 15:54:05 IRST 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ProviderRoleImpl extends TemplateEntityObject {
    private static EntityDefImpl mDefinitionObject;

  

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        ArtId {
            public Object get(ProviderRoleImpl obj) {
                return obj.getArtId();
            }

            public void put(ProviderRoleImpl obj, Object value) {
                obj.setArtId((Number)value);
            }
        }
        ,
        Role {
            public Object get(ProviderRoleImpl obj) {
                return obj.getRole();
            }

            public void put(ProviderRoleImpl obj, Object value) {
                obj.setRole((String)value);
            }
        }
        ,
        ReadingOrder {
            public Object get(ProviderRoleImpl obj) {
                return obj.getReadingOrder();
            }

            public void put(ProviderRoleImpl obj, Object value) {
                obj.setReadingOrder((Number)value);
            }
        }
        ,
        Active {
            public Object get(ProviderRoleImpl obj) {
                return obj.getActive();
            }

            public void put(ProviderRoleImpl obj, Object value) {
                obj.setActive((Number)value);
            }
        }
        ,
        Description {
            public Object get(ProviderRoleImpl obj) {
                return obj.getDescription();
            }

            public void put(ProviderRoleImpl obj, Object value) {
                obj.setDescription((String)value);
            }
        }
        ,
        VbookProvider {
            public Object get(ProviderRoleImpl obj) {
                return obj.getVbookProvider();
            }

            public void put(ProviderRoleImpl obj, Object value) {
                obj.setVbookProvider((VbookProviderImpl)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(ProviderRoleImpl object);

        public abstract void put(ProviderRoleImpl object, Object value);

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
    public static final int ROLE = AttributesEnum.Role.index();
    public static final int READINGORDER = AttributesEnum.ReadingOrder.index();
    public static final int ACTIVE = AttributesEnum.Active.index();
    public static final int DESCRIPTION = AttributesEnum.Description.index();
    public static final int VBOOKPROVIDER = AttributesEnum.VbookProvider.index();

    /**
     * This is the default constructor (do not remove).
     */
    public ProviderRoleImpl() {
    }


    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("org.parsisys.tehranuniversity.library.model.eo.ProviderRole");
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
     * Gets the attribute value for Role, using the alias name Role.
     * @return the Role
     */
    public String getRole() {
        return (String)getAttributeInternal(ROLE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Role.
     * @param value value to set the Role
     */
    public void setRole(String value) {
        setAttributeInternal(ROLE, value);
    }

    /**
     * Gets the attribute value for ReadingOrder, using the alias name ReadingOrder.
     * @return the ReadingOrder
     */
    public Number getReadingOrder() {
        return (Number)getAttributeInternal(READINGORDER);
    }

    /**
     * Sets <code>value</code> as the attribute value for ReadingOrder.
     * @param value value to set the ReadingOrder
     */
    public void setReadingOrder(Number value) {
        setAttributeInternal(READINGORDER, value);
    }

    /**
     * Gets the attribute value for Active, using the alias name Active.
     * @return the Active
     */
    public Number getActive() {
        return (Number)getAttributeInternal(ACTIVE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Active.
     * @param value value to set the Active
     */
    public void setActive(Number value) {
        setAttributeInternal(ACTIVE, value);
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
     * @return the associated entity VbookProviderImpl.
     */
    public VbookProviderImpl getVbookProvider() {
        return (VbookProviderImpl)getAttributeInternal(VBOOKPROVIDER);
    }

    /**
     * Sets <code>value</code> as the associated entity VbookProviderImpl.
     */
    public void setVbookProvider(VbookProviderImpl value) {
        setAttributeInternal(VBOOKPROVIDER, value);
    }


    /**
     * @param artId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Number artId) {
        return new Key(new Object[]{artId});
    }

    /**
     * Add attribute defaulting logic in this method.
     * @param attributeList list of attribute names/values to initialize the row
     */
    protected void create(AttributeList attributeList) {
        super.create(attributeList);
        setArtId(new Number(-1));
       
    }
    
  @Override
  protected void doDML(int i, TransactionEvent transactionEvent) {
      try{
      if(i==DML_INSERT) {
        SequenceImpl si = new SequenceImpl("SEQ_PROVIDER_ROLE_ART_ID",getDBTransaction());
        setArtId(si.getSequenceNumber());
        setRole(ParsiUtil.clearString(getRole()));
       
      }
      super.doDML(i, transactionEvent);
      }catch (Exception e) {
         
        throw new JboException("خطا در ذخیره کردن رکورد نقش");
      }
  }
}