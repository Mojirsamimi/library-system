package org.parsisys.tehranuniversity.library.model.eo;

import fadak.base.TemplateEntityObject;

import oracle.jbo.Key;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Aug 15 02:33:13 GMT+03:30 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SeeSubjectImpl extends TemplateEntityObject {
    private static EntityDefImpl mDefinitionObject;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        Labcol {
            public Object get(SeeSubjectImpl obj) {
                return obj.getLabcol();
            }

            public void put(SeeSubjectImpl obj, Object value) {
                obj.setLabcol((Number)value);
            }
        }
        ,
        SubjArtId {
            public Object get(SeeSubjectImpl obj) {
                return obj.getSubjArtId();
            }

            public void put(SeeSubjectImpl obj, Object value) {
                obj.setSubjArtId((Number)value);
            }
        }
        ,
        SubjArtIdRelatedTo {
            public Object get(SeeSubjectImpl obj) {
                return obj.getSubjArtIdRelatedTo();
            }

            public void put(SeeSubjectImpl obj, Object value) {
                obj.setSubjArtIdRelatedTo((Number)value);
            }
        }
        ,
        Subject1 {
            public Object get(SeeSubjectImpl obj) {
                return obj.getSubject1();
            }

            public void put(SeeSubjectImpl obj, Object value) {
                obj.setSubject1((SubjectImpl)value);
            }
        }
        ,
        Subject {
            public Object get(SeeSubjectImpl obj) {
                return obj.getSubject();
            }

            public void put(SeeSubjectImpl obj, Object value) {
                obj.setSubject((SubjectImpl)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(SeeSubjectImpl object);

        public abstract void put(SeeSubjectImpl object, Object value);

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
    public static final int SUBJARTID = AttributesEnum.SubjArtId.index();
    public static final int SUBJARTIDRELATEDTO = AttributesEnum.SubjArtIdRelatedTo.index();
    public static final int SUBJECT1 = AttributesEnum.Subject1.index();
    public static final int SUBJECT = AttributesEnum.Subject.index();

    /**
     * This is the default constructor (do not remove).
     */
    public SeeSubjectImpl() {
    }


    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("org.parsisys.tehranuniversity.library.model.eo.SeeSubject");
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
     * Gets the attribute value for SubjArtId, using the alias name SubjArtId.
     * @return the SubjArtId
     */
    public Number getSubjArtId() {
        return (Number)getAttributeInternal(SUBJARTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for SubjArtId.
     * @param value value to set the SubjArtId
     */
    public void setSubjArtId(Number value) {
        setAttributeInternal(SUBJARTID, value);
    }

    /**
     * Gets the attribute value for SubjArtIdRelatedTo, using the alias name SubjArtIdRelatedTo.
     * @return the SubjArtIdRelatedTo
     */
    public Number getSubjArtIdRelatedTo() {
        return (Number)getAttributeInternal(SUBJARTIDRELATEDTO);
    }

    /**
     * Sets <code>value</code> as the attribute value for SubjArtIdRelatedTo.
     * @param value value to set the SubjArtIdRelatedTo
     */
    public void setSubjArtIdRelatedTo(Number value) {
        setAttributeInternal(SUBJARTIDRELATEDTO, value);
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
     * @return the associated entity SubjectImpl.
     */
    public SubjectImpl getSubject1() {
        return (SubjectImpl)getAttributeInternal(SUBJECT1);
    }

    /**
     * Sets <code>value</code> as the associated entity SubjectImpl.
     */
    public void setSubject1(SubjectImpl value) {
        setAttributeInternal(SUBJECT1, value);
    }

    /**
     * @return the associated entity SubjectImpl.
     */
    public SubjectImpl getSubject() {
        return (SubjectImpl)getAttributeInternal(SUBJECT);
    }

    /**
     * Sets <code>value</code> as the associated entity SubjectImpl.
     */
    public void setSubject(SubjectImpl value) {
        setAttributeInternal(SUBJECT, value);
    }

    /**
     * @param labcol key constituent
     * @param subjArtId key constituent
     * @param subjArtIdRelatedTo key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Number labcol, Number subjArtId,
                                       Number subjArtIdRelatedTo) {
        return new Key(new Object[]{labcol, subjArtId, subjArtIdRelatedTo});
    }


}
