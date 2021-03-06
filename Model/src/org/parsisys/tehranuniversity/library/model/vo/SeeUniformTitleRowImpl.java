package org.parsisys.tehranuniversity.library.model.vo;

import fadak.base.TemplateViewRow;

import oracle.jbo.Row;
import oracle.jbo.RowSet;
import oracle.jbo.domain.DBSequence;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;

import org.parsisys.tehranuniversity.library.model.eo.SeeUniformTitleImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Jan 14 20:27:33 CST 2013
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SeeUniformTitleRowImpl extends TemplateViewRow {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        Labcol {
            public Object get(SeeUniformTitleRowImpl obj) {
                return obj.getLabcol();
            }

            public void put(SeeUniformTitleRowImpl obj, Object value) {
                obj.setLabcol((Number)value);
            }
        }
        ,
        UniTitleArtId {
            public Object get(SeeUniformTitleRowImpl obj) {
                return obj.getUniTitleArtId();
            }

            public void put(SeeUniformTitleRowImpl obj, Object value) {
                obj.setUniTitleArtId((Number)value);
            }
        }
        ,
        UniTitleArtIdRelatedTo {
            public Object get(SeeUniformTitleRowImpl obj) {
                return obj.getUniTitleArtIdRelatedTo();
            }

            public void put(SeeUniformTitleRowImpl obj, Object value) {
                obj.setUniTitleArtIdRelatedTo((Number)value);
            }
        }
        ,
        TitleText {
            public Object get(SeeUniformTitleRowImpl obj) {
                return obj.getTitleText();
            }

            public void put(SeeUniformTitleRowImpl obj, Object value) {
                obj.setTitleText((String)value);
            }
        }
        ,
        MainSeeUniformTitle {
            public Object get(SeeUniformTitleRowImpl obj) {
                return obj.getMainSeeUniformTitle();
            }

            public void put(SeeUniformTitleRowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        UniformTitleRefrence {
            public Object get(SeeUniformTitleRowImpl obj) {
                return obj.getUniformTitleRefrence();
            }

            public void put(SeeUniformTitleRowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        UniformTitleVO1 {
            public Object get(SeeUniformTitleRowImpl obj) {
                return obj.getUniformTitleVO1();
            }

            public void put(SeeUniformTitleRowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(SeeUniformTitleRowImpl object);

        public abstract void put(SeeUniformTitleRowImpl object, Object value);

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
    public static final int UNITITLEARTID = AttributesEnum.UniTitleArtId.index();
    public static final int UNITITLEARTIDRELATEDTO = AttributesEnum.UniTitleArtIdRelatedTo.index();
    public static final int TITLETEXT = AttributesEnum.TitleText.index();
    public static final int MAINSEEUNIFORMTITLE = AttributesEnum.MainSeeUniformTitle.index();
    public static final int UNIFORMTITLEREFRENCE = AttributesEnum.UniformTitleRefrence.index();
    public static final int UNIFORMTITLEVO1 = AttributesEnum.UniformTitleVO1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public SeeUniformTitleRowImpl() {
    }

    /**
     * Gets SeeUniformTitle entity object.
     * @return the SeeUniformTitle
     */
    public SeeUniformTitleImpl getSeeUniformTitle() {
        return (SeeUniformTitleImpl)getEntity(0);
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
     * Gets the attribute value for UNI_TITLE_ART_ID using the alias name UniTitleArtId.
     * @return the UNI_TITLE_ART_ID
     */
    public Number getUniTitleArtId() {
        return (Number) getAttributeInternal(UNITITLEARTID);
    }

    /**
     * Sets <code>value</code> as attribute value for UNI_TITLE_ART_ID using the alias name UniTitleArtId.
     * @param value value to set the UNI_TITLE_ART_ID
     */
    public void setUniTitleArtId(Number value) {
        setAttributeInternal(UNITITLEARTID, value);
    }

    /**
     * Gets the attribute value for UNI_TITLE_ART_ID_RELATED_TO using the alias name UniTitleArtIdRelatedTo.
     * @return the UNI_TITLE_ART_ID_RELATED_TO
     */
    public Number getUniTitleArtIdRelatedTo() {
        return (Number) getAttributeInternal(UNITITLEARTIDRELATEDTO);
    }

    /**
     * Sets <code>value</code> as attribute value for UNI_TITLE_ART_ID_RELATED_TO using the alias name UniTitleArtIdRelatedTo.
     * @param value value to set the UNI_TITLE_ART_ID_RELATED_TO
     */
    public void setUniTitleArtIdRelatedTo(Number value) {
        setAttributeInternal(UNITITLEARTIDRELATEDTO, value);
    }


    /**
     * Gets the attribute value for the calculated attribute TitleText.
     * @return the TitleText
     */
    public String getTitleText() {
       // return (String) getAttributeInternal(TITLETEXT);
        Row refrence = getUniformTitleRefrence();
        if(refrence==null)
            return null;
        
        return (String)refrence.getAttribute("Title");
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute TitleText.
     * @param value value to set the  TitleText
     */
    public void setTitleText(String value) {
        setAttributeInternal(TITLETEXT, value);
    }

    /**
     * Gets the associated <code>Row</code> using master-detail link MainSeeUniformTitle.
     */
    public Row getMainSeeUniformTitle() {
        return (Row)getAttributeInternal(MAINSEEUNIFORMTITLE);
    }

    /**
     * Sets the master-detail link MainSeeUniformTitle between this object and <code>value</code>.
     */
    public void setMainSeeUniformTitle(Row value) {
        setAttributeInternal(MAINSEEUNIFORMTITLE, value);
    }

    /**
     * Gets the associated <code>Row</code> using master-detail link UniformTitleRefrence.
     */
    public Row getUniformTitleRefrence() {
        return ((Row)getAttributeInternal(UNIFORMTITLEREFRENCE));
    }

    /**
     * Sets the master-detail link UniformTitleRefrence between this object and <code>value</code>.
     */
    public void setUniformTitleRefrence(Row value) {
        setAttributeInternal(UNIFORMTITLEREFRENCE, value);
    }

    /**
     * Gets the view accessor <code>RowSet</code> UniformTitleVO1.
     */
    public RowSet getUniformTitleVO1() {
        return (RowSet)getAttributeInternal(UNIFORMTITLEVO1);
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
