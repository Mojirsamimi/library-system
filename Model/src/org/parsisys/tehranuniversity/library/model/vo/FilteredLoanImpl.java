package org.parsisys.tehranuniversity.library.model.vo;

import fadak.base.TemplateViewObject;

import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Jan 18 12:37:13 GMT+04:00 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class FilteredLoanImpl extends TemplateViewObject {
    /**
     * This is the default constructor (do not remove).
     */
    public FilteredLoanImpl() {
    }

    /**
     * Returns the variable value for currentPhBookArtId.
     * @return variable value for currentPhBookArtId
     */
    public Number getcurrentPhBookArtId() {
        return (Number)ensureVariableManager().getVariableValue("currentPhBookArtId");
    }

    /**
     * Sets <code>value</code> for variable currentPhBookArtId.
     * @param value value to bind as currentPhBookArtId
     */
    public void setcurrentPhBookArtId(Number value) {
        ensureVariableManager().setVariableValue("currentPhBookArtId", value);
    }

    /**
     * Returns the variable value for currentMemArtId.
     * @return variable value for currentMemArtId
     */
    public Number getcurrentMemArtId() {
        return (Number)ensureVariableManager().getVariableValue("currentMemArtId");
    }

    /**
     * Sets <code>value</code> for variable currentMemArtId.
     * @param value value to bind as currentMemArtId
     */
    public void setcurrentMemArtId(Number value) {
        ensureVariableManager().setVariableValue("currentMemArtId", value);
    }

    /**
     * Returns the variable value for currentLoanDate.
     * @return variable value for currentLoanDate
     */
    public Number getcurrentLoanDate() {
        return (Number)ensureVariableManager().getVariableValue("currentLoanDate");
    }

    /**
     * Sets <code>value</code> for variable currentLoanDate.
     * @param value value to bind as currentLoanDate
     */
    public void setcurrentLoanDate(Number value) {
        ensureVariableManager().setVariableValue("currentLoanDate", value);
    }
}
