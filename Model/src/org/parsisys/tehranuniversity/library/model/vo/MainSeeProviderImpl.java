package org.parsisys.tehranuniversity.library.model.vo;

import fadak.base.TemplateViewObject;

import oracle.jbo.domain.Number;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sun Jul 22 11:50:03 GMT+03:30 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class MainSeeProviderImpl extends TemplateViewObject {
    /**
     * This is the default constructor (do not remove).
     */
    public MainSeeProviderImpl() {
    }

    /**
     * Returns the bind variable value for labcolParam.
     * @return bind variable value for labcolParam
     */
    public Number getlabcolParam() {
        return (Number)getNamedWhereClauseParam("labcolParam");
    }

    /**
     * Sets <code>value</code> for bind variable labcolParam.
     * @param value value to bind as labcolParam
     */
    public void setlabcolParam(Number value) {
        setNamedWhereClauseParam("labcolParam", value);
    }

    /**
     * Returns the variable value for forignNameParam.
     * @return variable value for forignNameParam
     */
    public String getforignNameParam() {
        return (String)ensureVariableManager().getVariableValue("forignNameParam");
    }

    /**
     * Sets <code>value</code> for variable forignNameParam.
     * @param value value to bind as forignNameParam
     */
    public void setforignNameParam(String value) {
        ensureVariableManager().setVariableValue("forignNameParam", value);
    }

    /**
     * Returns the variable value for BDdateParam.
     * @return variable value for BDdateParam
     */
    public String getBDdateParam() {
        return (String)ensureVariableManager().getVariableValue("BDdateParam");
    }

    /**
     * Sets <code>value</code> for variable BDdateParam.
     * @param value value to bind as BDdateParam
     */
    public void setBDdateParam(String value) {
        ensureVariableManager().setVariableValue("BDdateParam", value);
    }

    /**
     * Returns the variable value for providerParam.
     * @return variable value for providerParam
     */
    public String getproviderParam() {
        return (String)ensureVariableManager().getVariableValue("providerParam");
    }

    /**
     * Sets <code>value</code> for variable providerParam.
     * @param value value to bind as providerParam
     */
    public void setproviderParam(String value) {
        ensureVariableManager().setVariableValue("providerParam", value);
    }

    /**
     * Returns the variable value for providerKindParam.
     * @return variable value for providerKindParam
     */
    public String getproviderKindParam() {
        return (String)ensureVariableManager().getVariableValue("providerKindParam");
    }

    /**
     * Sets <code>value</code> for variable providerKindParam.
     * @param value value to bind as providerKindParam
     */
    public void setproviderKindParam(String value) {
        ensureVariableManager().setVariableValue("providerKindParam", value);
    }
}
