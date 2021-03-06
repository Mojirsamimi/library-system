package org.parsisys.tehranuniversity.library.model.eo;

import fadak.base.TemplateEntityObject;

import oracle.jbo.Key;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Jan 26 17:39:16 CST 2013
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class VbookLanguageImpl extends TemplateEntityObject {
    private static EntityDefImpl mDefinitionObject;

    /**
     * This is the default constructor (do not remove).
     */
    public VbookLanguageImpl() {
    }

    /**
     * @param labcol key constituent
     * @param vbookArtId key constituent
     * @param langArtId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Number labcol, Number vbookArtId,
                                       Number langArtId) {
        return new Key(new Object[]{labcol, vbookArtId, langArtId});
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("org.parsisys.tehranuniversity.library.model.eo.VbookLanguage");
        }
        return mDefinitionObject;
    }


}
