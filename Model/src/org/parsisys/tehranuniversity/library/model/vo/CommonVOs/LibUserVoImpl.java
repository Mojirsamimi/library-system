package org.parsisys.tehranuniversity.library.model.vo.CommonVOs;

import fadak.base.TemplateViewObject;

import oracle.jbo.domain.Number;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue May 22 13:05:30 GMT+04:00 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class LibUserVoImpl extends TemplateViewObject {
    /**
     * This is the default constructor (do not remove).
     */
    public LibUserVoImpl() {
    }


    /**
     * Returns the variable value for Labcol_no.
     * @return variable value for Labcol_no
     */
    public Number getLabcol_no() {
        return (Number)ensureVariableManager().getVariableValue("Labcol_no");
    }

    /**
     * Sets <code>value</code> for variable Labcol_no.
     * @param value value to bind as Labcol_no
     */
    public void setLabcol_no(Number value) {
        ensureVariableManager().setVariableValue("Labcol_no", value);
    }

    /**
     * Returns the variable value for userNameParam.
     * @return variable value for userNameParam
     */
    public String getuserNameParam() {
        return (String)ensureVariableManager().getVariableValue("userNameParam");
    }

    /**
     * Sets <code>value</code> for variable userNameParam.
     * @param value value to bind as userNameParam
     */
    public void setuserNameParam(String value) {
        ensureVariableManager().setVariableValue("userNameParam", value);
    }

    /**
     * Returns the variable value for labcolParam.
     * @return variable value for labcolParam
     */
    public Number getlabcolParam() {
        return (Number)ensureVariableManager().getVariableValue("labcolParam");
    }

    /**
     * Sets <code>value</code> for variable labcolParam.
     * @param value value to bind as labcolParam
     */
    public void setlabcolParam(Number value) {
        ensureVariableManager().setVariableValue("labcolParam", value);
    }
}
