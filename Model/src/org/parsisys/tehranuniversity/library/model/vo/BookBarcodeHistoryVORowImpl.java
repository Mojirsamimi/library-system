package org.parsisys.tehranuniversity.library.model.vo;

import oracle.jbo.Row;
import oracle.jbo.domain.DBSequence;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;

import org.parsisys.tehranuniversity.library.model.eo.BookBarcodeHistoryImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Apr 11 10:22:37 GMT+03:30 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class BookBarcodeHistoryVORowImpl
  extends ViewRowImpl {
  /**
   * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
   */
  public enum AttributesEnum
  {
        ArtId {
            public Object get(BookBarcodeHistoryVORowImpl obj) {
                return obj.getArtId();
            }

            public void put(BookBarcodeHistoryVORowImpl obj, Object value) {
                obj.setArtId((DBSequence)value);
            }
        }
        ,
        Barcode {
            public Object get(BookBarcodeHistoryVORowImpl obj) {
                return obj.getBarcode();
            }

            public void put(BookBarcodeHistoryVORowImpl obj, Object value) {
                obj.setBarcode((String)value);
            }
        }
        ,
        DayDate {
            public Object get(BookBarcodeHistoryVORowImpl obj) {
                return obj.getDayDate();
            }

            public void put(BookBarcodeHistoryVORowImpl obj, Object value) {
                obj.setDayDate((Number)value);
            }
        }
        ,
        Labcol {
            public Object get(BookBarcodeHistoryVORowImpl obj) {
                return obj.getLabcol();
            }

            public void put(BookBarcodeHistoryVORowImpl obj, Object value) {
                obj.setLabcol((Number)value);
            }
        }
        ,
        PhbookArtId {
            public Object get(BookBarcodeHistoryVORowImpl obj) {
                return obj.getPhbookArtId();
            }

            public void put(BookBarcodeHistoryVORowImpl obj, Object value) {
                obj.setPhbookArtId((Number)value);
            }
        }
        ,
        UserName {
            public Object get(BookBarcodeHistoryVORowImpl obj) {
                return obj.getUserName();
            }

            public void put(BookBarcodeHistoryVORowImpl obj, Object value) {
                obj.setUserName((String)value);
            }
        }
        ,
        PhysicalBookVO {
            public Object get(BookBarcodeHistoryVORowImpl obj) {
                return obj.getPhysicalBookVO();
            }

            public void put(BookBarcodeHistoryVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

    public abstract Object get(BookBarcodeHistoryVORowImpl object);

    public abstract void put(BookBarcodeHistoryVORowImpl object,
                             Object value);

    public int index()
    {
      return AttributesEnum.firstIndex() + ordinal();
    }

    public static int firstIndex()
    {
      return firstIndex;
    }

    public static int count()
    {
      return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
    }

    public static AttributesEnum[] staticValues()
    {
      if (vals == null)
      {
        vals = AttributesEnum.values();
      }
      return vals;
    }
  }


    public static final int ARTID = AttributesEnum.ArtId.index();
    public static final int BARCODE = AttributesEnum.Barcode.index();
    public static final int DAYDATE = AttributesEnum.DayDate.index();
    public static final int LABCOL = AttributesEnum.Labcol.index();
    public static final int PHBOOKARTID = AttributesEnum.PhbookArtId.index();
    public static final int USERNAME = AttributesEnum.UserName.index();
    public static final int PHYSICALBOOKVO = AttributesEnum.PhysicalBookVO.index();

    /**
     * This is the default constructor (do not remove).
     */
  public BookBarcodeHistoryVORowImpl()
  {
  }

  /**
   * Gets BookBarcodeHistory entity object.
   * @return the BookBarcodeHistory
   */
  public BookBarcodeHistoryImpl getBookBarcodeHistory()
  {
    return (BookBarcodeHistoryImpl) getEntity(0);
  }

  /**
   * Gets the attribute value for ART_ID using the alias name ArtId.
   * @return the ART_ID
   */
  public DBSequence getArtId()
  {
    return (DBSequence) getAttributeInternal(ARTID);
  }

  /**
   * Sets <code>value</code> as attribute value for ART_ID using the alias name ArtId.
   * @param value value to set the ART_ID
   */
  public void setArtId(DBSequence value)
  {
    setAttributeInternal(ARTID, value);
  }

  /**
   * Gets the attribute value for BARCODE using the alias name Barcode.
   * @return the BARCODE
   */
  public String getBarcode()
  {
    return (String) getAttributeInternal(BARCODE);
  }

  /**
   * Sets <code>value</code> as attribute value for BARCODE using the alias name Barcode.
   * @param value value to set the BARCODE
   */
  public void setBarcode(String value)
  {
    setAttributeInternal(BARCODE, value);
  }

  /**
   * Gets the attribute value for DAY_DATE using the alias name DayDate.
   * @return the DAY_DATE
   */
  public Number getDayDate()
  {
    return (Number) getAttributeInternal(DAYDATE);
  }

  /**
   * Sets <code>value</code> as attribute value for DAY_DATE using the alias name DayDate.
   * @param value value to set the DAY_DATE
   */
  public void setDayDate(Number value)
  {
    setAttributeInternal(DAYDATE, value);
  }

  /**
   * Gets the attribute value for LABCOL using the alias name Labcol.
   * @return the LABCOL
   */
  public Number getLabcol()
  {
    return (Number) getAttributeInternal(LABCOL);
  }

  /**
   * Sets <code>value</code> as attribute value for LABCOL using the alias name Labcol.
   * @param value value to set the LABCOL
   */
  public void setLabcol(Number value)
  {
    setAttributeInternal(LABCOL, value);
  }

  /**
   * Gets the attribute value for PHBOOK_ART_ID using the alias name PhbookArtId.
   * @return the PHBOOK_ART_ID
   */
  public Number getPhbookArtId()
  {
    return (Number) getAttributeInternal(PHBOOKARTID);
  }

  /**
   * Sets <code>value</code> as attribute value for PHBOOK_ART_ID using the alias name PhbookArtId.
   * @param value value to set the PHBOOK_ART_ID
   */
  public void setPhbookArtId(Number value)
  {
    setAttributeInternal(PHBOOKARTID, value);
  }

  /**
   * Gets the attribute value for USER_NAME using the alias name UserName.
   * @return the USER_NAME
   */
  public String getUserName()
  {
    return (String) getAttributeInternal(USERNAME);
  }

  /**
   * Sets <code>value</code> as attribute value for USER_NAME using the alias name UserName.
   * @param value value to set the USER_NAME
   */
  public void setUserName(String value)
  {
    setAttributeInternal(USERNAME, value);
  }

  /**
   * Gets the associated <code>Row</code> using master-detail link PhysicalBookVO.
   */
  public Row getPhysicalBookVO()
  {
    return (Row) getAttributeInternal(PHYSICALBOOKVO);
  }

  /**
   * Sets the master-detail link PhysicalBookVO between this object and <code>value</code>.
   */
  public void setPhysicalBookVO(Row value)
  {
    setAttributeInternal(PHYSICALBOOKVO, value);
  }

  /**
   * getAttrInvokeAccessor: generated method. Do not modify.
   * @param index the index identifying the attribute
   * @param attrDef the attribute

   * @return the attribute value
   * @throws Exception
   */
  protected Object getAttrInvokeAccessor(int index,
                                         AttributeDefImpl attrDef)
    throws Exception
  {
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
                                       AttributeDefImpl attrDef)
    throws Exception
  {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].put(this, value);
            return;
        }
        super.setAttrInvokeAccessor(index, value, attrDef);
    }
}
