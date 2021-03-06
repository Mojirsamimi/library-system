package org.parsisys.tehranuniversity.library.model.vo.RO;

import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Apr 11 12:57:46 GMT+03:30 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class AllPersonVORowImpl
  extends ViewRowImpl
{
  /**
   * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
   */
  public enum AttributesEnum
  {
    ArtId
    {
      public Object get(AllPersonVORowImpl obj)
      {
        return obj.getArtId();
      }

      public void put(AllPersonVORowImpl obj, Object value)
      {
        obj.setArtId((Number)value);
      }
    }
    ,
    Barcode
    {
      public Object get(AllPersonVORowImpl obj)
      {
        return obj.getBarcode();
      }

      public void put(AllPersonVORowImpl obj, Object value)
      {
        obj.setBarcode((String)value);
      }
    }
    ,
    Fname
    {
      public Object get(AllPersonVORowImpl obj)
      {
        return obj.getFname();
      }

      public void put(AllPersonVORowImpl obj, Object value)
      {
        obj.setFname((String)value);
      }
    }
    ,
    Lname
    {
      public Object get(AllPersonVORowImpl obj)
      {
        return obj.getLname();
      }

      public void put(AllPersonVORowImpl obj, Object value)
      {
        obj.setLname((String)value);
      }
    }
    ,
    CertificateNo
    {
      public Object get(AllPersonVORowImpl obj)
      {
        return obj.getCertificateNo();
      }

      public void put(AllPersonVORowImpl obj, Object value)
      {
        obj.setCertificateNo((String)value);
      }
    }
    ,
    Origine
    {
      public Object get(AllPersonVORowImpl obj)
      {
        return obj.getOrigine();
      }

      public void put(AllPersonVORowImpl obj, Object value)
      {
        obj.setOrigine((Number)value);
      }
    }
    ,
    Id
    {
      public Object get(AllPersonVORowImpl obj)
      {
        return obj.getId();
      }

      public void put(AllPersonVORowImpl obj, Object value)
      {
        obj.setId((String)value);
      }
    }
    ,
    Affiliation
    {
      public Object get(AllPersonVORowImpl obj)
      {
        return obj.getAffiliation();
      }

      public void put(AllPersonVORowImpl obj, Object value)
      {
        obj.setAffiliation((String)value);
      }
    }
    ,
    PersType
    {
      public Object get(AllPersonVORowImpl obj)
      {
        return obj.getPersType();
      }

      public void put(AllPersonVORowImpl obj, Object value)
      {
        obj.setPersType((Number)value);
      }
    }
    ,
    Degree
    {
      public Object get(AllPersonVORowImpl obj)
      {
        return obj.getDegree();
      }

      public void put(AllPersonVORowImpl obj, Object value)
      {
        obj.setDegree((Number)value);
      }
    }
    ,
    UserId
    {
      public Object get(AllPersonVORowImpl obj)
      {
        return obj.getUserId();
      }

      public void put(AllPersonVORowImpl obj, Object value)
      {
        obj.setUserId((String)value);
      }
    }
    ,
    Password
    {
      public Object get(AllPersonVORowImpl obj)
      {
        return obj.getPassword();
      }

      public void put(AllPersonVORowImpl obj, Object value)
      {
        obj.setPassword((String)value);
      }
    }
    ,
    PersStatus
    {
      public Object get(AllPersonVORowImpl obj)
      {
        return obj.getPersStatus();
      }

      public void put(AllPersonVORowImpl obj, Object value)
      {
        obj.setPersStatus((Number)value);
      }
    }
    ,
    SecArtId
    {
      public Object get(AllPersonVORowImpl obj)
      {
        return obj.getSecArtId();
      }

      public void put(AllPersonVORowImpl obj, Object value)
      {
        obj.setSecArtId((Number)value);
      }
    }
    ,
    PersCategory
    {
      public Object get(AllPersonVORowImpl obj)
      {
        return obj.getPersCategory();
      }

      public void put(AllPersonVORowImpl obj, Object value)
      {
        obj.setPersCategory((Number)value);
      }
    }
    ,
    MjrArtId
    {
      public Object get(AllPersonVORowImpl obj)
      {
        return obj.getMjrArtId();
      }

      public void put(AllPersonVORowImpl obj, Object value)
      {
        obj.setMjrArtId((Number)value);
      }
    }
    ,
    CmemsetupArtId
    {
      public Object get(AllPersonVORowImpl obj)
      {
        return obj.getCmemsetupArtId();
      }

      public void put(AllPersonVORowImpl obj, Object value)
      {
        obj.setCmemsetupArtId((Number)value);
      }
    }
    ,
    DeptArtId
    {
      public Object get(AllPersonVORowImpl obj)
      {
        return obj.getDeptArtId();
      }

      public void put(AllPersonVORowImpl obj, Object value)
      {
        obj.setDeptArtId((Number)value);
      }
    }
    ,
    PersOffstatArtId
    {
      public Object get(AllPersonVORowImpl obj)
      {
        return obj.getPersOffstatArtId();
      }

      public void put(AllPersonVORowImpl obj, Object value)
      {
        obj.setPersOffstatArtId((Number)value);
      }
    }
    ;
    private static AttributesEnum[] vals = null;
    private static int firstIndex = 0;

    public abstract Object get(AllPersonVORowImpl object);

    public abstract void put(AllPersonVORowImpl object, Object value);

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
  public static final int FNAME = AttributesEnum.Fname.index();
  public static final int LNAME = AttributesEnum.Lname.index();
  public static final int CERTIFICATENO = AttributesEnum.CertificateNo.index();
  public static final int ORIGINE = AttributesEnum.Origine.index();
  public static final int ID = AttributesEnum.Id.index();
  public static final int AFFILIATION = AttributesEnum.Affiliation.index();
  public static final int PERSTYPE = AttributesEnum.PersType.index();
  public static final int DEGREE = AttributesEnum.Degree.index();
  public static final int USERID = AttributesEnum.UserId.index();
  public static final int PASSWORD = AttributesEnum.Password.index();
  public static final int PERSSTATUS = AttributesEnum.PersStatus.index();
  public static final int SECARTID = AttributesEnum.SecArtId.index();
  public static final int PERSCATEGORY = AttributesEnum.PersCategory.index();
  public static final int MJRARTID = AttributesEnum.MjrArtId.index();
  public static final int CMEMSETUPARTID = AttributesEnum.CmemsetupArtId.index();
  public static final int DEPTARTID = AttributesEnum.DeptArtId.index();
  public static final int PERSOFFSTATARTID = AttributesEnum.PersOffstatArtId.index();

  /**
   * This is the default constructor (do not remove).
   */
  public AllPersonVORowImpl()
  {
  }

  /**
   * Gets the attribute value for the calculated attribute ArtId.
   * @return the ArtId
   */
  public Number getArtId()
  {
    return (Number) getAttributeInternal(ARTID);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute ArtId.
   * @param value value to set the  ArtId
   */
  public void setArtId(Number value)
  {
    setAttributeInternal(ARTID, value);
  }

  /**
   * Gets the attribute value for the calculated attribute Barcode.
   * @return the Barcode
   */
  public String getBarcode()
  {
    return (String) getAttributeInternal(BARCODE);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute Barcode.
   * @param value value to set the  Barcode
   */
  public void setBarcode(String value)
  {
    setAttributeInternal(BARCODE, value);
  }

  /**
   * Gets the attribute value for the calculated attribute Fname.
   * @return the Fname
   */
  public String getFname()
  {
    return (String) getAttributeInternal(FNAME);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute Fname.
   * @param value value to set the  Fname
   */
  public void setFname(String value)
  {
    setAttributeInternal(FNAME, value);
  }

  /**
   * Gets the attribute value for the calculated attribute Lname.
   * @return the Lname
   */
  public String getLname()
  {
    return (String) getAttributeInternal(LNAME);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute Lname.
   * @param value value to set the  Lname
   */
  public void setLname(String value)
  {
    setAttributeInternal(LNAME, value);
  }

  /**
   * Gets the attribute value for the calculated attribute CertificateNo.
   * @return the CertificateNo
   */
  public String getCertificateNo()
  {
    return (String) getAttributeInternal(CERTIFICATENO);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute CertificateNo.
   * @param value value to set the  CertificateNo
   */
  public void setCertificateNo(String value)
  {
    setAttributeInternal(CERTIFICATENO, value);
  }

  /**
   * Gets the attribute value for the calculated attribute Origine.
   * @return the Origine
   */
  public Number getOrigine()
  {
    return (Number) getAttributeInternal(ORIGINE);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute Origine.
   * @param value value to set the  Origine
   */
  public void setOrigine(Number value)
  {
    setAttributeInternal(ORIGINE, value);
  }

  /**
   * Gets the attribute value for the calculated attribute Id.
   * @return the Id
   */
  public String getId()
  {
    return (String) getAttributeInternal(ID);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute Id.
   * @param value value to set the  Id
   */
  public void setId(String value)
  {
    setAttributeInternal(ID, value);
  }

  /**
   * Gets the attribute value for the calculated attribute Affiliation.
   * @return the Affiliation
   */
  public String getAffiliation()
  {
    return (String) getAttributeInternal(AFFILIATION);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute Affiliation.
   * @param value value to set the  Affiliation
   */
  public void setAffiliation(String value)
  {
    setAttributeInternal(AFFILIATION, value);
  }

  /**
   * Gets the attribute value for the calculated attribute PersType.
   * @return the PersType
   */
  public Number getPersType()
  {
    return (Number) getAttributeInternal(PERSTYPE);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute PersType.
   * @param value value to set the  PersType
   */
  public void setPersType(Number value)
  {
    setAttributeInternal(PERSTYPE, value);
  }

  /**
   * Gets the attribute value for the calculated attribute Degree.
   * @return the Degree
   */
  public Number getDegree()
  {
    return (Number) getAttributeInternal(DEGREE);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute Degree.
   * @param value value to set the  Degree
   */
  public void setDegree(Number value)
  {
    setAttributeInternal(DEGREE, value);
  }

  /**
   * Gets the attribute value for the calculated attribute UserId.
   * @return the UserId
   */
  public String getUserId()
  {
    return (String) getAttributeInternal(USERID);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute UserId.
   * @param value value to set the  UserId
   */
  public void setUserId(String value)
  {
    setAttributeInternal(USERID, value);
  }

  /**
   * Gets the attribute value for the calculated attribute Password.
   * @return the Password
   */
  public String getPassword()
  {
    return (String) getAttributeInternal(PASSWORD);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute Password.
   * @param value value to set the  Password
   */
  public void setPassword(String value)
  {
    setAttributeInternal(PASSWORD, value);
  }

  /**
   * Gets the attribute value for the calculated attribute PersStatus.
   * @return the PersStatus
   */
  public Number getPersStatus()
  {
    return (Number) getAttributeInternal(PERSSTATUS);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute PersStatus.
   * @param value value to set the  PersStatus
   */
  public void setPersStatus(Number value)
  {
    setAttributeInternal(PERSSTATUS, value);
  }

  /**
   * Gets the attribute value for the calculated attribute SecArtId.
   * @return the SecArtId
   */
  public Number getSecArtId()
  {
    return (Number) getAttributeInternal(SECARTID);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute SecArtId.
   * @param value value to set the  SecArtId
   */
  public void setSecArtId(Number value)
  {
    setAttributeInternal(SECARTID, value);
  }

  /**
   * Gets the attribute value for the calculated attribute PersCategory.
   * @return the PersCategory
   */
  public Number getPersCategory()
  {
    return (Number) getAttributeInternal(PERSCATEGORY);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute PersCategory.
   * @param value value to set the  PersCategory
   */
  public void setPersCategory(Number value)
  {
    setAttributeInternal(PERSCATEGORY, value);
  }

  /**
   * Gets the attribute value for the calculated attribute MjrArtId.
   * @return the MjrArtId
   */
  public Number getMjrArtId()
  {
    return (Number) getAttributeInternal(MJRARTID);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute MjrArtId.
   * @param value value to set the  MjrArtId
   */
  public void setMjrArtId(Number value)
  {
    setAttributeInternal(MJRARTID, value);
  }

  /**
   * Gets the attribute value for the calculated attribute CmemsetupArtId.
   * @return the CmemsetupArtId
   */
  public Number getCmemsetupArtId()
  {
    return (Number) getAttributeInternal(CMEMSETUPARTID);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute CmemsetupArtId.
   * @param value value to set the  CmemsetupArtId
   */
  public void setCmemsetupArtId(Number value)
  {
    setAttributeInternal(CMEMSETUPARTID, value);
  }

  /**
   * Gets the attribute value for the calculated attribute DeptArtId.
   * @return the DeptArtId
   */
  public Number getDeptArtId()
  {
    return (Number) getAttributeInternal(DEPTARTID);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute DeptArtId.
   * @param value value to set the  DeptArtId
   */
  public void setDeptArtId(Number value)
  {
    setAttributeInternal(DEPTARTID, value);
  }

  /**
   * Gets the attribute value for the calculated attribute PersOffstatArtId.
   * @return the PersOffstatArtId
   */
  public Number getPersOffstatArtId()
  {
    return (Number) getAttributeInternal(PERSOFFSTATARTID);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute PersOffstatArtId.
   * @param value value to set the  PersOffstatArtId
   */
  public void setPersOffstatArtId(Number value)
  {
    setAttributeInternal(PERSOFFSTATARTID, value);
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
    if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count()))
    {
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
    if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count()))
    {
      AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].put(this, value);
      return;
    }
    super.setAttrInvokeAccessor(index, value, attrDef);
  }
}
