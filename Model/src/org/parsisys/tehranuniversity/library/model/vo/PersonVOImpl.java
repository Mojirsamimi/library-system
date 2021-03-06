package org.parsisys.tehranuniversity.library.model.vo;

import java.sql.ResultSet;

import oracle.jbo.RowSetIterator;
import oracle.jbo.domain.Number;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.server.ViewRowImpl;
import oracle.jbo.server.ViewRowSetImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Oct 17 10:49:33 IRST 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PersonVOImpl extends ViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public PersonVOImpl() {
    }

    /**
     * Returns the variable value for barcode.
     * @return variable value for barcode
     */
    public String getbarcode() {
        return (String)ensureVariableManager().getVariableValue("barcode");
    }

    /**
     * Sets <code>value</code> for variable barcode.
     * @param value value to bind as barcode
     */
    public void setbarcode(String value) {
        ensureVariableManager().setVariableValue("barcode", value);
    }

    /**
     * Returns the variable value for id_Param.
     * @return variable value for id_Param
     */
    public String getid_Param() {
        return (String)ensureVariableManager().getVariableValue("id_Param");
    }

    /**
     * Sets <code>value</code> for variable id_Param.
     * @param value value to bind as id_Param
     */
    public void setid_Param(String value) {
        ensureVariableManager().setVariableValue("id_Param", value);
    }

    /**
     * Returns the variable value for lname_Param.
     * @return variable value for lname_Param
     */
    public String getlname_Param() {
        return (String)ensureVariableManager().getVariableValue("lname_Param");
    }

    /**
     * Sets <code>value</code> for variable lname_Param.
     * @param value value to bind as lname_Param
     */
    public void setlname_Param(String value) {
        ensureVariableManager().setVariableValue("lname_Param", value);
    }

    /**
     * Returns the variable value for fname_param.
     * @return variable value for fname_param
     */
    public String getfname_param() {
        return (String)ensureVariableManager().getVariableValue("fname_param");
    }

    /**
     * Sets <code>value</code> for variable fname_param.
     * @param value value to bind as fname_param
     */
    public void setfname_param(String value) {
        ensureVariableManager().setVariableValue("fname_param", value);
    }

    /**
     * Returns the variable value for param_barcode.
     * @return variable value for param_barcode
     */
    public String getparam_barcode() {
        return (String)ensureVariableManager().getVariableValue("param_barcode");
    }

    /**
     * Sets <code>value</code> for variable param_barcode.
     * @param value value to bind as param_barcode
     */
    public void setparam_barcode(String value) {
        ensureVariableManager().setVariableValue("param_barcode", value);
    }

    /**
     * Returns the variable value for id_param2.
     * @return variable value for id_param2
     */
    public String getid_param2() {
        return (String)ensureVariableManager().getVariableValue("id_param2");
    }

    /**
     * Sets <code>value</code> for variable id_param2.
     * @param value value to bind as id_param2
     */
    public void setid_param2(String value) {
        ensureVariableManager().setVariableValue("id_param2", value);
    }

    /**
     * Returns the variable value for barcode_param2.
     * @return variable value for barcode_param2
     */
    public String getbarcode_param2() {
        return (String)ensureVariableManager().getVariableValue("barcode_param2");
    }

    /**
     * Sets <code>value</code> for variable barcode_param2.
     * @param value value to bind as barcode_param2
     */
    public void setbarcode_param2(String value) {
        ensureVariableManager().setVariableValue("barcode_param2", value);
    }

    /**
     * Returns the variable value for CNoParam.
     * @return variable value for CNoParam
     */
    public String getCNoParam() {
        return (String)ensureVariableManager().getVariableValue("CNoParam");
    }

    /**
     * Sets <code>value</code> for variable CNoParam.
     * @param value value to bind as CNoParam
     */
    public void setCNoParam(String value) {
        ensureVariableManager().setVariableValue("CNoParam", value);
    }

    /**
     * Returns the variable value for BarcodeParam3.
     * @return variable value for BarcodeParam3
     */
    public String getBarcodeParam3() {
        return (String)ensureVariableManager().getVariableValue("BarcodeParam3");
    }

    /**
     * Sets <code>value</code> for variable BarcodeParam3.
     * @param value value to bind as BarcodeParam3
     */
    public void setBarcodeParam3(String value) {
        ensureVariableManager().setVariableValue("BarcodeParam3", value);
    }

    /**
     * Returns the variable value for CNoParam2.
     * @return variable value for CNoParam2
     */
    public String getCNoParam2() {
        return (String)ensureVariableManager().getVariableValue("CNoParam2");
    }

    /**
     * Sets <code>value</code> for variable CNoParam2.
     * @param value value to bind as CNoParam2
     */
    public void setCNoParam2(String value) {
        ensureVariableManager().setVariableValue("CNoParam2", value);
    }

    /**
     * Returns the variable value for idParam3.
     * @return variable value for idParam3
     */
    public String getidParam3() {
        return (String)ensureVariableManager().getVariableValue("idParam3");
    }

    /**
     * Sets <code>value</code> for variable idParam3.
     * @param value value to bind as idParam3
     */
    public void setidParam3(String value) {
        ensureVariableManager().setVariableValue("idParam3", value);
    }

    /**
     * Returns the variable value for param_barcode_equal.
     * @return variable value for param_barcode_equal
     */
    public String getparam_barcode_equal() {
        return (String)ensureVariableManager().getVariableValue("param_barcode_equal");
    }

    /**
     * Sets <code>value</code> for variable param_barcode_equal.
     * @param value value to bind as param_barcode_equal
     */
    public void setparam_barcode_equal(String value) {
        ensureVariableManager().setVariableValue("param_barcode_equal", value);
    }

    /**
     * Returns the variable value for param_ID.
     * @return variable value for param_ID
     */
    public String getparam_ID() {
        return (String)ensureVariableManager().getVariableValue("param_ID");
    }

    /**
     * Sets <code>value</code> for variable param_ID.
     * @param value value to bind as param_ID
     */
    public void setparam_ID(String value) {
        ensureVariableManager().setVariableValue("param_ID", value);
    }

    /**
     * Returns the variable value for param_pers_category1.
     * @return variable value for param_pers_category1
     */
    public Number getparam_pers_category1() {
        return (Number)ensureVariableManager().getVariableValue("param_pers_category1");
    }

    /**
     * Sets <code>value</code> for variable param_pers_category1.
     * @param value value to bind as param_pers_category1
     */
    public void setparam_pers_category1(Number value) {
        ensureVariableManager().setVariableValue("param_pers_category1", value);
    }

    /**
     * Returns the variable value for param_pers_category2.
     * @return variable value for param_pers_category2
     */
    public Number getparam_pers_category2() {
        return (Number)ensureVariableManager().getVariableValue("param_pers_category2");
    }

    /**
     * Sets <code>value</code> for variable param_pers_category2.
     * @param value value to bind as param_pers_category2
     */
    public void setparam_pers_category2(Number value) {
        ensureVariableManager().setVariableValue("param_pers_category2", value);
    }

    /**
     * executeQueryForCollection - overridden for custom java data source support.
     */
    protected void executeQueryForCollection(Object qc, Object[] params,
                                             int noUserParams) {
        super.executeQueryForCollection(qc, params, noUserParams);
    }

    /**
     * hasNextForCollection - overridden for custom java data source support.
     */
    protected boolean hasNextForCollection(Object qc) {
        boolean bRet = super.hasNextForCollection(qc);
        return bRet;
    }

    /**
     * createRowFromResultSet - overridden for custom java data source support.
     */
    protected ViewRowImpl createRowFromResultSet(Object qc,
                                                 ResultSet resultSet) {
        ViewRowImpl value = super.createRowFromResultSet(qc, resultSet);
        return value;
    }

    /**
     * getQueryHitCount - overridden for custom java data source support.
     */
    public long getQueryHitCount(ViewRowSetImpl viewRowSet) {
        long value = super.getQueryHitCount(viewRowSet);
        return value;
    }

    @Override
    public RowSetIterator findRowSetIterator(String string) {
//        if(string!=null && string.equals("test")){
//          System.out.println("it is in the test");
//           getRowSetIterator().setCurrentRowAtRangeIndex(-1);
//           return getRowSetIterator();
//        }else
        return super.findRowSetIterator(string);
    }
}
