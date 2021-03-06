package org.parsisys.tehranuniversity.library.model.eo;

import fadak.base.TemplateEntityObject;

import oracle.jbo.AttributeList;
import oracle.jbo.JboException;
import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.RowSet;
import oracle.jbo.domain.DBSequence;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.SequenceImpl;
import oracle.jbo.server.TransactionEvent;

import org.parsisys.tehranuniversity.library.model.eo.BookBarcodeHistoryImpl;
import org.parsisys.tehranuniversity.library.util.ParsiUtil;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Jan 24 15:13:17 GMT+04:00 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PhysicalBookImpl extends TemplateEntityObject {
    private static EntityDefImpl mDefinitionObject;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        Labcol {
            public Object get(PhysicalBookImpl obj) {
                return obj.getLabcol();
            }

            public void put(PhysicalBookImpl obj, Object value) {
                obj.setLabcol((Number)value);
            }
        }
        ,
        ArtId {
            public Object get(PhysicalBookImpl obj) {
                return obj.getArtId();
            }

            public void put(PhysicalBookImpl obj, Object value) {
                obj.setArtId((Number)value);
            }
        }
        ,
        RegId {
            public Object get(PhysicalBookImpl obj) {
                return obj.getRegId();
            }

            public void put(PhysicalBookImpl obj, Object value) {
                obj.setRegId((String)value);
            }
        }
        ,
        ReplicateNo {
            public Object get(PhysicalBookImpl obj) {
                return obj.getReplicateNo();
            }

            public void put(PhysicalBookImpl obj, Object value) {
                obj.setReplicateNo((Number)value);
            }
        }
        ,
        VolNo {
            public Object get(PhysicalBookImpl obj) {
                return obj.getVolNo();
            }

            public void put(PhysicalBookImpl obj, Object value) {
                obj.setVolNo((String)value);
            }
        }
        ,
        PartNo {
            public Object get(PhysicalBookImpl obj) {
                return obj.getPartNo();
            }

            public void put(PhysicalBookImpl obj, Object value) {
                obj.setPartNo((String)value);
            }
        }
        ,
        LoanStatus {
            public Object get(PhysicalBookImpl obj) {
                return obj.getLoanStatus();
            }

            public void put(PhysicalBookImpl obj, Object value) {
                obj.setLoanStatus((Number)value);
            }
        }
        ,
        Place {
            public Object get(PhysicalBookImpl obj) {
                return obj.getPlace();
            }

            public void put(PhysicalBookImpl obj, Object value) {
                obj.setPlace((Number)value);
            }
        }
        ,
        VbookArtId {
            public Object get(PhysicalBookImpl obj) {
                return obj.getVbookArtId();
            }

            public void put(PhysicalBookImpl obj, Object value) {
                obj.setVbookArtId((Number)value);
            }
        }
        ,
        Hold {
            public Object get(PhysicalBookImpl obj) {
                return obj.getHold();
            }

            public void put(PhysicalBookImpl obj, Object value) {
                obj.setHold((Number)value);
            }
        }
        ,
        SafetyStatus {
            public Object get(PhysicalBookImpl obj) {
                return obj.getSafetyStatus();
            }

            public void put(PhysicalBookImpl obj, Object value) {
                obj.setSafetyStatus((Number)value);
            }
        }
        ,
        ExistenceStatus {
            public Object get(PhysicalBookImpl obj) {
                return obj.getExistenceStatus();
            }

            public void put(PhysicalBookImpl obj, Object value) {
                obj.setExistenceStatus((Number)value);
            }
        }
        ,
        Barcode {
            public Object get(PhysicalBookImpl obj) {
                return obj.getBarcode();
            }

            public void put(PhysicalBookImpl obj, Object value) {
                obj.setBarcode((String)value);
            }
        }
        ,
        InsertDate {
            public Object get(PhysicalBookImpl obj) {
                return obj.getInsertDate();
            }

            public void put(PhysicalBookImpl obj, Object value) {
                obj.setInsertDate((Number)value);
            }
        }
        ,
        UserName {
            public Object get(PhysicalBookImpl obj) {
                return obj.getUserName();
            }

            public void put(PhysicalBookImpl obj, Object value) {
                obj.setUserName((String)value);
            }
        }
        ,
        StatusChangeDate {
            public Object get(PhysicalBookImpl obj) {
                return obj.getStatusChangeDate();
            }

            public void put(PhysicalBookImpl obj, Object value) {
                obj.setStatusChangeDate((Number)value);
            }
        }
        ,
        BarcodeChangeDate {
            public Object get(PhysicalBookImpl obj) {
                return obj.getBarcodeChangeDate();
            }

            public void put(PhysicalBookImpl obj, Object value) {
                obj.setBarcodeChangeDate((Number)value);
            }
        }
        ,
        BarcodeChangeUser {
            public Object get(PhysicalBookImpl obj) {
                return obj.getBarcodeChangeUser();
            }

            public void put(PhysicalBookImpl obj, Object value) {
                obj.setBarcodeChangeUser((String)value);
            }
        }
        ,
        StatusChangeUser {
            public Object get(PhysicalBookImpl obj) {
                return obj.getStatusChangeUser();
            }

            public void put(PhysicalBookImpl obj, Object value) {
                obj.setStatusChangeUser((String)value);
            }
        }
        ,
        Description {
            public Object get(PhysicalBookImpl obj) {
                return obj.getDescription();
            }

            public void put(PhysicalBookImpl obj, Object value) {
                obj.setDescription((String)value);
            }
        }
        ,
        PubDate {
            public Object get(PhysicalBookImpl obj) {
                return obj.getPubDate();
            }

            public void put(PhysicalBookImpl obj, Object value) {
                obj.setPubDate((String)value);
            }
        }
        ,
        LoanDuration {
            public Object get(PhysicalBookImpl obj) {
                return obj.getLoanDuration();
            }

            public void put(PhysicalBookImpl obj, Object value) {
                obj.setLoanDuration((Number)value);
            }
        }
        ,
        DurationUnit {
            public Object get(PhysicalBookImpl obj) {
                return obj.getDurationUnit();
            }

            public void put(PhysicalBookImpl obj, Object value) {
                obj.setDurationUnit((Number)value);
            }
        }
        ,
        FileAddress {
            public Object get(PhysicalBookImpl obj) {
                return obj.getFileAddress();
            }

            public void put(PhysicalBookImpl obj, Object value) {
                obj.setFileAddress((String)value);
            }
        }
        ,
        FileName {
            public Object get(PhysicalBookImpl obj) {
                return obj.getFileName();
            }

            public void put(PhysicalBookImpl obj, Object value) {
                obj.setFileName((String)value);
            }
        }
        ,
        VirtualBook {
            public Object get(PhysicalBookImpl obj) {
                return obj.getVirtualBook();
            }

            public void put(PhysicalBookImpl obj, Object value) {
                obj.setVirtualBook((VirtualBookImpl)value);
            }
        }
        ,
        Loan {
            public Object get(PhysicalBookImpl obj) {
                return obj.getLoan();
            }

            public void put(PhysicalBookImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        Loan1 {
            public Object get(PhysicalBookImpl obj) {
                return obj.getLoan1();
            }

            public void put(PhysicalBookImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        BookStatusHistory {
            public Object get(PhysicalBookImpl obj) {
                return obj.getBookStatusHistory();
            }

            public void put(PhysicalBookImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        BookBarcodeHistory1 {
            public Object get(PhysicalBookImpl obj) {
                return obj.getBookBarcodeHistory1();
            }

            public void put(PhysicalBookImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        Loan2 {
            public Object get(PhysicalBookImpl obj) {
                return obj.getLoan2();
            }

            public void put(PhysicalBookImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        VirtualBook1 {
            public Object get(PhysicalBookImpl obj) {
                return obj.getVirtualBook1();
            }

            public void put(PhysicalBookImpl obj, Object value) {
                obj.setVirtualBook1((VirtualBookImpl)value);
            }
        }
        ,
        Loan_Spc {
            public Object get(PhysicalBookImpl obj) {
                return obj.getLoan_Spc();
            }

            public void put(PhysicalBookImpl obj, Object value) {
                obj.setLoan_Spc((LoanImpl)value);
            }
        }
        ,
        PenaltyType {
            public Object get(PhysicalBookImpl obj) {
                return obj.getPenaltyType();
            }

            public void put(PhysicalBookImpl obj, Object value) {
                obj.setPenaltyType((EntityImpl)value);
            }
        }
        ,
        MessageVO1 {
            public Object get(PhysicalBookImpl obj) {
                return obj.getMessageVO1();
            }

            public void put(PhysicalBookImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(PhysicalBookImpl object);

        public abstract void put(PhysicalBookImpl object, Object value);

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() +
                AttributesEnum.staticValues().length;
        }

        public static AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int LABCOL = AttributesEnum.Labcol.index();
    public static final int ARTID = AttributesEnum.ArtId.index();
    public static final int REGID = AttributesEnum.RegId.index();
    public static final int REPLICATENO = AttributesEnum.ReplicateNo.index();
    public static final int VOLNO = AttributesEnum.VolNo.index();
    public static final int PARTNO = AttributesEnum.PartNo.index();
    public static final int LOANSTATUS = AttributesEnum.LoanStatus.index();
    public static final int PLACE = AttributesEnum.Place.index();
    public static final int VBOOKARTID = AttributesEnum.VbookArtId.index();
    public static final int HOLD = AttributesEnum.Hold.index();
    public static final int SAFETYSTATUS = AttributesEnum.SafetyStatus.index();
    public static final int EXISTENCESTATUS = AttributesEnum.ExistenceStatus.index();
    public static final int BARCODE = AttributesEnum.Barcode.index();
    public static final int INSERTDATE = AttributesEnum.InsertDate.index();
    public static final int USERNAME = AttributesEnum.UserName.index();
    public static final int STATUSCHANGEDATE = AttributesEnum.StatusChangeDate.index();
    public static final int BARCODECHANGEDATE = AttributesEnum.BarcodeChangeDate.index();
    public static final int BARCODECHANGEUSER = AttributesEnum.BarcodeChangeUser.index();
    public static final int STATUSCHANGEUSER = AttributesEnum.StatusChangeUser.index();
    public static final int DESCRIPTION = AttributesEnum.Description.index();
    public static final int PUBDATE = AttributesEnum.PubDate.index();
    public static final int LOANDURATION = AttributesEnum.LoanDuration.index();
    public static final int DURATIONUNIT = AttributesEnum.DurationUnit.index();
    public static final int FILEADDRESS = AttributesEnum.FileAddress.index();
    public static final int FILENAME = AttributesEnum.FileName.index();
    public static final int VIRTUALBOOK = AttributesEnum.VirtualBook.index();
    public static final int LOAN = AttributesEnum.Loan.index();
    public static final int LOAN1 = AttributesEnum.Loan1.index();
    public static final int BOOKSTATUSHISTORY = AttributesEnum.BookStatusHistory.index();
    public static final int BOOKBARCODEHISTORY1 = AttributesEnum.BookBarcodeHistory1.index();
    public static final int LOAN2 = AttributesEnum.Loan2.index();
    public static final int VIRTUALBOOK1 = AttributesEnum.VirtualBook1.index();
    public static final int LOAN_SPC = AttributesEnum.Loan_Spc.index();
    public static final int PENALTYTYPE = AttributesEnum.PenaltyType.index();
    public static final int MESSAGEVO1 = AttributesEnum.MessageVO1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public PhysicalBookImpl() {
    }


    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("org.parsisys.tehranuniversity.library.model.eo.PhysicalBook");
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
     * Gets the attribute value for RegId, using the alias name RegId.
     * @return the RegId
     */
    public String getRegId() {
        return (String)getAttributeInternal(REGID);
    }

    /**
     * Sets <code>value</code> as the attribute value for RegId.
     * @param value value to set the RegId
     */
    public void setRegId(String value) {
        setAttributeInternal(REGID, value);
    }

    /**
     * Gets the attribute value for ReplicateNo, using the alias name ReplicateNo.
     * @return the ReplicateNo
     */
    public Number getReplicateNo() {
        return (Number)getAttributeInternal(REPLICATENO);
    }

    /**
     * Sets <code>value</code> as the attribute value for ReplicateNo.
     * @param value value to set the ReplicateNo
     */
    public void setReplicateNo(Number value) {
        setAttributeInternal(REPLICATENO, value);
    }

    /**
     * Gets the attribute value for VolNo, using the alias name VolNo.
     * @return the VolNo
     */
    public String getVolNo() {
        return (String)getAttributeInternal(VOLNO);
    }

    /**
     * Sets <code>value</code> as the attribute value for VolNo.
     * @param value value to set the VolNo
     */
    public void setVolNo(String value) {
        setAttributeInternal(VOLNO, value);
    }

    /**
     * Gets the attribute value for PartNo, using the alias name PartNo.
     * @return the PartNo
     */
    public String getPartNo() {
        return (String)getAttributeInternal(PARTNO);
    }

    /**
     * Sets <code>value</code> as the attribute value for PartNo.
     * @param value value to set the PartNo
     */
    public void setPartNo(String value) {
        setAttributeInternal(PARTNO, value);
    }

    /**
     * Gets the attribute value for LoanStatusText, using the alias name LoanStatusText.
     * @return the LoanStatusText
     */
    public Number getLoanStatus() {
        return (Number)getAttributeInternal(LOANSTATUS);
    }

    /**
     * Sets <code>value</code> as the attribute value for LoanStatusText.
     * @param value value to set the LoanStatusText
     */
    public void setLoanStatus(Number value) {
        setAttributeInternal(LOANSTATUS, value);
    }

    /**
     * Gets the attribute value for Place, using the alias name Place.
     * @return the Place
     */
    public Number getPlace() {
        return (Number)getAttributeInternal(PLACE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Place.
     * @param value value to set the Place
     */
    public void setPlace(Number value) {
        setAttributeInternal(PLACE, value);
    }

    /**
     * Gets the attribute value for VbookArtId, using the alias name VbookArtId.
     * @return the VbookArtId
     */
    public Number getVbookArtId() {
        return (Number)getAttributeInternal(VBOOKARTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for VbookArtId.
     * @param value value to set the VbookArtId
     */
    public void setVbookArtId(Number value) {
        setAttributeInternal(VBOOKARTID, value);
    }

    /**
     * Gets the attribute value for Hold, using the alias name Hold.
     * @return the Hold
     */
    public Number getHold() {
        return (Number)getAttributeInternal(HOLD);
    }

    /**
     * Sets <code>value</code> as the attribute value for Hold.
     * @param value value to set the Hold
     */
    public void setHold(Number value) {
        setAttributeInternal(HOLD, value);
    }

    /**
     * Gets the attribute value for SafetyStatus, using the alias name SafetyStatus.
     * @return the SafetyStatus
     */
    public Number getSafetyStatus() {
        return (Number)getAttributeInternal(SAFETYSTATUS);
    }

    /**
     * Sets <code>value</code> as the attribute value for SafetyStatus.
     * @param value value to set the SafetyStatus
     */
    public void setSafetyStatus(Number value) {
        setAttributeInternal(SAFETYSTATUS, value);
    }

    /**
     * Gets the attribute value for ExistenceStatus, using the alias name ExistenceStatus.
     * @return the ExistenceStatus
     */
    public Number getExistenceStatus() {
        return (Number)getAttributeInternal(EXISTENCESTATUS);
    }

    /**
     * Sets <code>value</code> as the attribute value for ExistenceStatus.
     * @param value value to set the ExistenceStatus
     */
    public void setExistenceStatus(Number value) {
        setAttributeInternal(EXISTENCESTATUS, value);
    }

    /**
     * Gets the attribute value for Barcode, using the alias name Barcode.
     * @return the Barcode
     */
    public String getBarcode() {
        return (String)getAttributeInternal(BARCODE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Barcode.
     * @param value value to set the Barcode
     */
    public void setBarcode(String value) {
        setAttributeInternal(BARCODE, value);
    }

    /**
     * Gets the attribute value for InsertDate, using the alias name InsertDate.
     * @return the InsertDate
     */
    public Number getInsertDate() {
        return (Number)getAttributeInternal(INSERTDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for InsertDate.
     * @param value value to set the InsertDate
     */
    public void setInsertDate(Number value) {
        setAttributeInternal(INSERTDATE, value);
    }

    /**
     * Gets the attribute value for UserName, using the alias name UserName.
     * @return the UserName
     */
    public String getUserName() {
        return (String)getAttributeInternal(USERNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for UserName.
     * @param value value to set the UserName
     */
    public void setUserName(String value) {
        setAttributeInternal(USERNAME, value);
    }

    /**
     * Gets the attribute value for StatusChangeDate, using the alias name StatusChangeDate.
     * @return the StatusChangeDate
     */
    public Number getStatusChangeDate() {
        return (Number)getAttributeInternal(STATUSCHANGEDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for StatusChangeDate.
     * @param value value to set the StatusChangeDate
     */
    public void setStatusChangeDate(Number value) {
        setAttributeInternal(STATUSCHANGEDATE, value);
    }

    /**
     * Gets the attribute value for BarcodeChangeDate, using the alias name BarcodeChangeDate.
     * @return the BarcodeChangeDate
     */
    public Number getBarcodeChangeDate() {
        return (Number)getAttributeInternal(BARCODECHANGEDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for BarcodeChangeDate.
     * @param value value to set the BarcodeChangeDate
     */
    public void setBarcodeChangeDate(Number value) {
        setAttributeInternal(BARCODECHANGEDATE, value);
    }

    /**
     * Gets the attribute value for BarcodeChangeUser, using the alias name BarcodeChangeUser.
     * @return the BarcodeChangeUser
     */
    public String getBarcodeChangeUser() {
        return (String)getAttributeInternal(BARCODECHANGEUSER);
    }

    /**
     * Sets <code>value</code> as the attribute value for BarcodeChangeUser.
     * @param value value to set the BarcodeChangeUser
     */
    public void setBarcodeChangeUser(String value) {
        setAttributeInternal(BARCODECHANGEUSER, value);
    }

    /**
     * Gets the attribute value for StatusChangeUser, using the alias name StatusChangeUser.
     * @return the StatusChangeUser
     */
    public String getStatusChangeUser() {
        return (String)getAttributeInternal(STATUSCHANGEUSER);
    }

    /**
     * Sets <code>value</code> as the attribute value for StatusChangeUser.
     * @param value value to set the StatusChangeUser
     */
    public void setStatusChangeUser(String value) {
        setAttributeInternal(STATUSCHANGEUSER, value);
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
     * Gets the attribute value for PubDate, using the alias name PubDate.
     * @return the PubDate
     */
    public String getPubDate() {
        return (String)getAttributeInternal(PUBDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for PubDate.
     * @param value value to set the PubDate
     */
    public void setPubDate(String value) {
        setAttributeInternal(PUBDATE, value);
    }

    /**
     * Gets the attribute value for LoanDuration, using the alias name LoanDuration.
     * @return the LoanDuration
     */
    public Number getLoanDuration() {
        return (Number)getAttributeInternal(LOANDURATION);
    }

    /**
     * Sets <code>value</code> as the attribute value for LoanDuration.
     * @param value value to set the LoanDuration
     */
    public void setLoanDuration(Number value) {
        setAttributeInternal(LOANDURATION, value);
    }

    /**
     * Gets the attribute value for DurationUnit, using the alias name DurationUnit.
     * @return the DurationUnit
     */
    public Number getDurationUnit() {
        return (Number)getAttributeInternal(DURATIONUNIT);
    }

    /**
     * Sets <code>value</code> as the attribute value for DurationUnit.
     * @param value value to set the DurationUnit
     */
    public void setDurationUnit(Number value) {
        setAttributeInternal(DURATIONUNIT, value);
    }


    /**
     * Gets the attribute value for FileAddress, using the alias name FileAddress.
     * @return the FileAddress
     */
    public String getFileAddress() {
        return (String)getAttributeInternal(FILEADDRESS);
    }

    /**
     * Sets <code>value</code> as the attribute value for FileAddress.
     * @param value value to set the FileAddress
     */
    public void setFileAddress(String value) {
        setAttributeInternal(FILEADDRESS, value);
    }

    /**
     * Gets the attribute value for FileName, using the alias name FileName.
     * @return the FileName
     */
    public String getFileName() {
        return (String)getAttributeInternal(FILENAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for FileName.
     * @param value value to set the FileName
     */
    public void setFileName(String value) {
        setAttributeInternal(FILENAME, value);
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
    public RowIterator getLoan2() {
        return (RowIterator)getAttributeInternal(LOAN2);
    }


    /**
     * @return the associated entity VirtualBookImpl.
     */
    public VirtualBookImpl getVirtualBook1() {
        return (VirtualBookImpl)getAttributeInternal(VIRTUALBOOK1);
    }

    /**
     * Sets <code>value</code> as the associated entity VirtualBookImpl.
     */
    public void setVirtualBook1(VirtualBookImpl value) {
        setAttributeInternal(VIRTUALBOOK1, value);
    }

    /**
     * @return the associated entity LoanImpl.
     */
    public LoanImpl getLoan_Spc() {
        return (LoanImpl)getAttributeInternal(LOAN_SPC);
    }

    /**
     * Sets <code>value</code> as the associated entity LoanImpl.
     */
    public void setLoan_Spc(LoanImpl value) {
        setAttributeInternal(LOAN_SPC, value);
    }


    /**
     * @return the associated entity oracle.jbo.server.EntityImpl.
     */
    public EntityImpl getPenaltyType() {
        return (EntityImpl)getAttributeInternal(PENALTYTYPE);
    }

    /**
     * Sets <code>value</code> as the associated entity oracle.jbo.server.EntityImpl.
     */
    public void setPenaltyType(EntityImpl value) {
        setAttributeInternal(PENALTYTYPE, value);
    }


    /**
     * @return the associated entity VirtualBookImpl.
     */
    public VirtualBookImpl getVirtualBook() {
        return (VirtualBookImpl)getAttributeInternal(VIRTUALBOOK);
    }

    /**
     * Sets <code>value</code> as the associated entity VirtualBookImpl.
     */
    public void setVirtualBook(VirtualBookImpl value) {
        setAttributeInternal(VIRTUALBOOK, value);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getLoan() {
        return (RowIterator)getAttributeInternal(LOAN);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getLoan1() {
        return (RowIterator)getAttributeInternal(LOAN1);
    }


    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getBookStatusHistory() {
        return (RowIterator)getAttributeInternal(BOOKSTATUSHISTORY);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getBookBarcodeHistory1() {
        return (RowIterator)getAttributeInternal(BOOKBARCODEHISTORY1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> MessageVO1.
     */
    public RowSet getMessageVO1() {
        return (RowSet)getAttributeInternal(MESSAGEVO1);
    }


    /**
     * @param labcol key constituent
     * @param artId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Number labcol, Number artId) {
        return new Key(new Object[]{labcol, artId});
    }

    /**
     * Add attribute defaulting logic in this method.
     * @param attributeList list of attribute names/values to initialize the row
     */
    protected void create(AttributeList attributeList) {
        super.create(attributeList);
        SequenceImpl si =
            new SequenceImpl("BOOK.SEQ_PHYSICAL_BOOK_ART_id", getDBTransaction());
        setArtId(si.getSequenceNumber());
        
    }

    /**
     * Add entity remove logic in this method.
     */
    public void remove() {
      RowIterator barcodeHistory1 = getBookBarcodeHistory1();
      System.out.println(barcodeHistory1.getRowCount());
      while(barcodeHistory1.hasNext()) {
        barcodeHistory1.next().remove();
      }
      RowIterator bookStatusHistory = getBookStatusHistory();
      while(bookStatusHistory.hasNext()) {
        bookStatusHistory.next().remove();
      }
        super.remove();
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
        if(operation==DML_DELETE) {
         
            if(new Number(2).equals(getExistenceStatus()) || new Number(8).equals(getExistenceStatus())){
            
           
           throw new JboException(   (String)getMessageVO1().findByKey(new Key( new Object[]{"book_in_loan".toUpperCase()}),-1)[0].getAttribute("Message"));
         
            }
            else {
              if(getLoan_Spc()!=null) {
               
                throw new JboException( "اين كتاب داراي سابقة امانت است لذا حذف ان ممكن نيست،در صورت مفقود شدن وضعيت آنرا به مفقود تغيير دهيد.");
                  }
            }
           

        }

        if (operation == DML_UPDATE && "persian_cataloging".equals(getDBTransaction().getSession().getUserData().get("validation_policy"))) {
          
          String savedBarcode=(String)getPostedAttribute(BARCODE);
            if (getBarcode() != null &&
                !(getBarcode().equalsIgnoreCase(savedBarcode))) {
                
                if(getBookBarcodeHistory1().hasNext() || savedBarcode!=null ) {
                
                 EntityDefImpl bkBrcdHistDef=EntityDefImpl.findDefObject("org.parsisys.tehranuniversity.library.model.eo.BookBarcodeHistory");
                  BookBarcodeHistoryImpl newBkBrcdHist=(BookBarcodeHistoryImpl)bkBrcdHistDef.createInstance2(getDBTransaction(), null);
                
                  newBkBrcdHist.setDayDate(getBarcodeChangeDate());
                
                  if(savedBarcode==null)
                    newBkBrcdHist.setBarcode("خالي");
                  else 
                  newBkBrcdHist.setBarcode(savedBarcode);
                  newBkBrcdHist.setPhbookArtId(getArtId());
                  newBkBrcdHist.setUserName(getBarcodeChangeUser());
                  
                }
              setBarcodeChangeDate(ParsiUtil.DateToNumber());
              setBarcodeChangeUser((String)e.getDBTransaction().getSession().getUserData().get("username"));
                /*SELECT COUNT(*) INTO CNT FROM book_barcode_history
		  		WHERE PHBOOK_ART_ID=:PHYSICAL_BOOK.ART_ID;	
		  IF :SAVED_BARCODE IS NOT NULL OR CNT>0 THEN	
					SELECT SEQ_BK_BARCODE_HISTORY_ID.NEXTVAL INTO temp_art_id FROM dual;
					INSERT INTO book_barcode_history(ART_ID,DAY_DATE,BARCODE
																					,PHBOOK_ART_ID,USER_NAME)
							VALUES(temp_art_id,:barcode_change_date,
					   				 NVL(:PHYSICAL_BOOK.SAVED_BARCODE,'ÎÇáí'),
					    			:PHYSICAL_BOOK.ART_ID,:barcode_change_user);
	   	END IF;*/
            }
            
            /*	SELECT COUNT(*) INTO cnt FROM loan 
			WHERE phbook_art_id=:PHYSICAL_BOOK.ART_ID AND real_ret_date IS NULL;*/
            Number existStatus = ParsiUtil.NVL(getExistenceStatus());
            Number savedexistStatus = ParsiUtil.NVL((Number)getPostedAttribute(EXISTENCESTATUS));
            if(getLoan_Spc()!=null && existStatus!=null && !(existStatus.equals(savedexistStatus))) {
              //	pkg_msg.show_msg('un_upd_loan_st');
                throw new JboException("امكان تغيير وضعيت يا تغيير باركد كتاب در امانت موجود نيست.");
            }
            if(existStatus!=null && existStatus.intValue()==2 && savedexistStatus.intValue()!=2) {
              //	pkg_msg.show_msg('un_upd_phbook_status');;
              throw new JboException("امكان تغيير وضعيت كتاب  به امانت وجود ندارد.");
            }
         
       
            if (been_changed(SAFETYSTATUS)  || been_changed(PLACE) || been_changed(LOANSTATUS) || been_changed(EXISTENCESTATUS)){
              SequenceImpl seqimpl =  new SequenceImpl("BOOK.SEQ_BK_ST_HIS_ART_ID", getDBTransaction());
               Number statusHistArtId= seqimpl.getSequenceNumber();
               EntityDefImpl bkBrcdHistDef=EntityDefImpl.findDefObject("org.parsisys.tehranuniversity.library.model.eo.BookStatusHistory");
              //(hist_art_id,:STATUS_CHANGE_DATE,:SAVED_LOAN_ST,
              // 			          :SAVED_SAF_ST,:SAVED_EX_ST,
              // 			          :SAVED_PLACE,:PHYSICAL_BOOK.art_id,
              // 			          :STATUS_CHANGE_USER
              
              
                BookStatusHistoryImpl newBkStdHist=(BookStatusHistoryImpl)bkBrcdHistDef.createInstance2(getDBTransaction(), null);
                newBkStdHist.setArtId(new DBSequence( statusHistArtId));
                newBkStdHist.setDayDate(getStatusChangeDate());
              newBkStdHist.setLoanStatus((Number)getPostedAttribute(LOANSTATUS));
              newBkStdHist.setSafetyStatus((Number)getPostedAttribute(SAFETYSTATUS));
              newBkStdHist.setExistenceStatus((Number)getPostedAttribute(EXISTENCESTATUS));
              newBkStdHist.setPlace((Number)getPostedAttribute(PLACE));
                newBkStdHist.setPhbookArtId(getArtId());
                newBkStdHist.setUserName(getStatusChangeUser());
                
              setStatusChangeDate(ParsiUtil.DateToNumber());
              setStatusChangeUser((String)e.getDBTransaction().getSession().getUserData().get("username"));
                
            }
        }
        if(operation==DML_INSERT){
          if(new Number(2).equals(getExistenceStatus()))
              throw new JboException("امكان ورود نسخه با وضعيت امانت وجود ندارد. اگر نسخه كتاب در دسترس نيست وضعيت را نامشخص وارد كنيد.");
          setInsertDate(ParsiUtil.DateToNumber());
          setStatusChangeDate(getInsertDate());
          setStatusChangeUser(getUserName());
          setBarcodeChangeDate(getInsertDate());
          setBarcodeChangeUser(getUserName());
          
        }
       
        super.doDML(operation, e);
    }
    
    public boolean been_changed(int index){
      Number old = ParsiUtil.NVL((Number)getPostedAttribute(index));
      Number newval = ParsiUtil.NVL((Number)getAttribute(index));
      if(old.equals(newval))
          return false;
      return true;
      
    }
    
    public Object getPostedAttribute2(int i) {
      return getPostedAttribute(i);
    }
  
}
