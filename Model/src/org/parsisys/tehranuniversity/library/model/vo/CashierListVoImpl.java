package org.parsisys.tehranuniversity.library.model.vo;

import oracle.jbo.domain.Number;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Sep 22 14:45:38 GMT+03:30 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CashierListVoImpl extends ViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public CashierListVoImpl() {
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
}
