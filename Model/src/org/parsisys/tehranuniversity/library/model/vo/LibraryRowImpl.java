package org.parsisys.tehranuniversity.library.model.vo;

import oracle.jbo.RowIterator;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sun Jun 17 17:06:47 GMT+03:30 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class LibraryRowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        ArtId {
            public Object get(LibraryRowImpl obj) {
                return obj.getArtId();
            }

            public void put(LibraryRowImpl obj, Object value) {
                obj.setArtId((Number)value);
            }
        }
        ,
        LibName {
            public Object get(LibraryRowImpl obj) {
                return obj.getLibName();
            }

            public void put(LibraryRowImpl obj, Object value) {
                obj.setLibName((String)value);
            }
        }
        ,
        LibLabel {
            public Object get(LibraryRowImpl obj) {
                return obj.getLibLabel();
            }

            public void put(LibraryRowImpl obj, Object value) {
                obj.setLibLabel((Number)value);
            }
        }
        ,
        EnglishLibSearchTitle {
            public Object get(LibraryRowImpl obj) {
                return obj.getEnglishLibSearchTitle();
            }

            public void put(LibraryRowImpl obj, Object value) {
                obj.setEnglishLibSearchTitle((String)value);
            }
        }
        ,
        LibArtId {
            public Object get(LibraryRowImpl obj) {
                return obj.getLibArtId();
            }

            public void put(LibraryRowImpl obj, Object value) {
                obj.setLibArtId((Number)value);
            }
        }
        ,
        LibEnglishName {
            public Object get(LibraryRowImpl obj) {
                return obj.getLibEnglishName();
            }

            public void put(LibraryRowImpl obj, Object value) {
                obj.setLibEnglishName((String)value);
            }
        }
        ,
        LibSearchTitle {
            public Object get(LibraryRowImpl obj) {
                return obj.getLibSearchTitle();
            }

            public void put(LibraryRowImpl obj, Object value) {
                obj.setLibSearchTitle((String)value);
            }
        }
        ,
        LibType {
            public Object get(LibraryRowImpl obj) {
                return obj.getLibType();
            }

            public void put(LibraryRowImpl obj, Object value) {
                obj.setLibType((Number)value);
            }
        }
        ,
        MainLabcol {
            public Object get(LibraryRowImpl obj) {
                return obj.getMainLabcol();
            }

            public void put(LibraryRowImpl obj, Object value) {
                obj.setMainLabcol((Number)value);
            }
        }
        ,
        SearchDbLink {
            public Object get(LibraryRowImpl obj) {
                return obj.getSearchDbLink();
            }

            public void put(LibraryRowImpl obj, Object value) {
                obj.setSearchDbLink((String)value);
            }
        }
        ,
        SearchUser {
            public Object get(LibraryRowImpl obj) {
                return obj.getSearchUser();
            }

            public void put(LibraryRowImpl obj, Object value) {
                obj.setSearchUser((String)value);
            }
        }
        ,
        LibUserVo {
            public Object get(LibraryRowImpl obj) {
                return obj.getLibUserVo();
            }

            public void put(LibraryRowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        InitMemberVO {
            public Object get(LibraryRowImpl obj) {
                return obj.getInitMemberVO();
            }

            public void put(LibraryRowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(LibraryRowImpl object);

        public abstract void put(LibraryRowImpl object, Object value);

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
    public static final int LIBNAME = AttributesEnum.LibName.index();
    public static final int LIBLABEL = AttributesEnum.LibLabel.index();
    public static final int ENGLISHLIBSEARCHTITLE = AttributesEnum.EnglishLibSearchTitle.index();
    public static final int LIBARTID = AttributesEnum.LibArtId.index();
    public static final int LIBENGLISHNAME = AttributesEnum.LibEnglishName.index();
    public static final int LIBSEARCHTITLE = AttributesEnum.LibSearchTitle.index();
    public static final int LIBTYPE = AttributesEnum.LibType.index();
    public static final int MAINLABCOL = AttributesEnum.MainLabcol.index();
    public static final int SEARCHDBLINK = AttributesEnum.SearchDbLink.index();
    public static final int SEARCHUSER = AttributesEnum.SearchUser.index();
    public static final int LIBUSERVO = AttributesEnum.LibUserVo.index();
    public static final int INITMEMBERVO = AttributesEnum.InitMemberVO.index();

    /**
     * This is the default constructor (do not remove).
     */
    public LibraryRowImpl() {
    }

    /**
     * Gets Library entity object.
     * @return the Library
     */
    public EntityImpl getLibrary() {
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
     * Gets the attribute value for LIB_NAME using the alias name LibName.
     * @return the LIB_NAME
     */
    public String getLibName() {
        return (String) getAttributeInternal(LIBNAME);
    }

    /**
     * Sets <code>value</code> as attribute value for LIB_NAME using the alias name LibName.
     * @param value value to set the LIB_NAME
     */
    public void setLibName(String value) {
        setAttributeInternal(LIBNAME, value);
    }


    /**
     * Gets the attribute value for LIB_LABEL using the alias name LibLabel.
     * @return the LIB_LABEL
     */
    public Number getLibLabel() {
        return (Number) getAttributeInternal(LIBLABEL);
    }

    /**
     * Sets <code>value</code> as attribute value for LIB_LABEL using the alias name LibLabel.
     * @param value value to set the LIB_LABEL
     */
    public void setLibLabel(Number value) {
        setAttributeInternal(LIBLABEL, value);
    }

    /**
     * Gets the attribute value for ENGLISH_LIB_SEARCH_TITLE using the alias name EnglishLibSearchTitle.
     * @return the ENGLISH_LIB_SEARCH_TITLE
     */
    public String getEnglishLibSearchTitle() {
        return (String) getAttributeInternal(ENGLISHLIBSEARCHTITLE);
    }

    /**
     * Sets <code>value</code> as attribute value for ENGLISH_LIB_SEARCH_TITLE using the alias name EnglishLibSearchTitle.
     * @param value value to set the ENGLISH_LIB_SEARCH_TITLE
     */
    public void setEnglishLibSearchTitle(String value) {
        setAttributeInternal(ENGLISHLIBSEARCHTITLE, value);
    }

    /**
     * Gets the attribute value for LIB_ART_ID using the alias name LibArtId.
     * @return the LIB_ART_ID
     */
    public Number getLibArtId() {
        return (Number) getAttributeInternal(LIBARTID);
    }

    /**
     * Sets <code>value</code> as attribute value for LIB_ART_ID using the alias name LibArtId.
     * @param value value to set the LIB_ART_ID
     */
    public void setLibArtId(Number value) {
        setAttributeInternal(LIBARTID, value);
    }

    /**
     * Gets the attribute value for LIB_ENGLISH_NAME using the alias name LibEnglishName.
     * @return the LIB_ENGLISH_NAME
     */
    public String getLibEnglishName() {
        return (String) getAttributeInternal(LIBENGLISHNAME);
    }

    /**
     * Sets <code>value</code> as attribute value for LIB_ENGLISH_NAME using the alias name LibEnglishName.
     * @param value value to set the LIB_ENGLISH_NAME
     */
    public void setLibEnglishName(String value) {
        setAttributeInternal(LIBENGLISHNAME, value);
    }

    /**
     * Gets the attribute value for LIB_SEARCH_TITLE using the alias name LibSearchTitle.
     * @return the LIB_SEARCH_TITLE
     */
    public String getLibSearchTitle() {
        return (String) getAttributeInternal(LIBSEARCHTITLE);
    }

    /**
     * Sets <code>value</code> as attribute value for LIB_SEARCH_TITLE using the alias name LibSearchTitle.
     * @param value value to set the LIB_SEARCH_TITLE
     */
    public void setLibSearchTitle(String value) {
        setAttributeInternal(LIBSEARCHTITLE, value);
    }

    /**
     * Gets the attribute value for LIB_TYPE using the alias name LibType.
     * @return the LIB_TYPE
     */
    public Number getLibType() {
        return (Number) getAttributeInternal(LIBTYPE);
    }

    /**
     * Sets <code>value</code> as attribute value for LIB_TYPE using the alias name LibType.
     * @param value value to set the LIB_TYPE
     */
    public void setLibType(Number value) {
        setAttributeInternal(LIBTYPE, value);
    }

    /**
     * Gets the attribute value for MAIN_LABCOL using the alias name MainLabcol.
     * @return the MAIN_LABCOL
     */
    public Number getMainLabcol() {
        return (Number) getAttributeInternal(MAINLABCOL);
    }

    /**
     * Sets <code>value</code> as attribute value for MAIN_LABCOL using the alias name MainLabcol.
     * @param value value to set the MAIN_LABCOL
     */
    public void setMainLabcol(Number value) {
        setAttributeInternal(MAINLABCOL, value);
    }

    /**
     * Gets the attribute value for SEARCH_DB_LINK using the alias name SearchDbLink.
     * @return the SEARCH_DB_LINK
     */
    public String getSearchDbLink() {
        return (String) getAttributeInternal(SEARCHDBLINK);
    }

    /**
     * Sets <code>value</code> as attribute value for SEARCH_DB_LINK using the alias name SearchDbLink.
     * @param value value to set the SEARCH_DB_LINK
     */
    public void setSearchDbLink(String value) {
        setAttributeInternal(SEARCHDBLINK, value);
    }

    /**
     * Gets the attribute value for SEARCH_USER using the alias name SearchUser.
     * @return the SEARCH_USER
     */
    public String getSearchUser() {
        return (String) getAttributeInternal(SEARCHUSER);
    }

    /**
     * Sets <code>value</code> as attribute value for SEARCH_USER using the alias name SearchUser.
     * @param value value to set the SEARCH_USER
     */
    public void setSearchUser(String value) {
        setAttributeInternal(SEARCHUSER, value);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link LibUserVo.
     */
    public RowIterator getLibUserVo() {
        return (RowIterator)getAttributeInternal(LIBUSERVO);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link InitMemberVO.
     */
    public RowIterator getInitMemberVO() {
        return (RowIterator)getAttributeInternal(INITMEMBERVO);
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