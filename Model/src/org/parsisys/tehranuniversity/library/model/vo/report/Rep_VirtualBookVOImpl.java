package org.parsisys.tehranuniversity.library.model.vo.report;

import oracle.jbo.domain.Number;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Feb 20 15:09:14 CST 2013
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class Rep_VirtualBookVOImpl extends ViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public Rep_VirtualBookVOImpl() {
    }

    /**
     * Returns the bind variable value for param_labcol.
     * @return bind variable value for param_labcol
     */
    public Number getparam_labcol() {
        return (Number)getNamedWhereClauseParam("param_labcol");
    }

    /**
     * Sets <code>value</code> for bind variable param_labcol.
     * @param value value to bind as param_labcol
     */
    public void setparam_labcol(Number value) {
        setNamedWhereClauseParam("param_labcol", value);
    }

    /**
     * Returns the variable value for param_art_id_from.
     * @return variable value for param_art_id_from
     */
    public Number getparam_art_id_from() {
        return (Number)ensureVariableManager().getVariableValue("param_art_id_from");
    }

    /**
     * Sets <code>value</code> for variable param_art_id_from.
     * @param value value to bind as param_art_id_from
     */
    public void setparam_art_id_from(Number value) {
        ensureVariableManager().setVariableValue("param_art_id_from", value);
    }

    /**
     * Returns the variable value for param_art_id_to.
     * @return variable value for param_art_id_to
     */
    public Number getparam_art_id_to() {
        return (Number)ensureVariableManager().getVariableValue("param_art_id_to");
    }

    /**
     * Sets <code>value</code> for variable param_art_id_to.
     * @param value value to bind as param_art_id_to
     */
    public void setparam_art_id_to(Number value) {
        ensureVariableManager().setVariableValue("param_art_id_to", value);
    }
}
