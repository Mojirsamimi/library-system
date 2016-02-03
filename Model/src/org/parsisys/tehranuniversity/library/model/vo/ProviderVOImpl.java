package org.parsisys.tehranuniversity.library.model.vo;

import fadak.base.TemplateViewObject;

import oracle.jbo.domain.Number;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Dec 17 13:28:21 GMT+03:30 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ProviderVOImpl extends TemplateViewObject {
    /**
     * This is the default constructor (do not remove).
     */
    public ProviderVOImpl() {
    }

    /**
     * Returns the bind variable value for labcol.
     * @return bind variable value for labcol
     */
    public Number getlabcol() {
        return (Number)getNamedWhereClauseParam("labcol");
    }

    /**
     * Sets <code>value</code> for bind variable labcol.
     * @param value value to bind as labcol
     */
    public void setlabcol(Number value) {
        setNamedWhereClauseParam("labcol", value);
    }

    /**
     * Returns the variable value for param_readingOrder.
     * @return variable value for param_readingOrder
     */
    public Number getparam_readingOrder() {
        return (Number)ensureVariableManager().getVariableValue("param_readingOrder");
    }

    /**
     * Sets <code>value</code> for variable param_readingOrder.
     * @param value value to bind as param_readingOrder
     */
    public void setparam_readingOrder(Number value) {
        ensureVariableManager().setVariableValue("param_readingOrder", value);
    }
}
