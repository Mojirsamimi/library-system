package org.parsisys.tehranuniversity.library.model.eo;

import fadak.base.TemplateEntityObject;

import oracle.jbo.Key;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Jan 21 16:11:15 IRST 2013
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class BookRequestImpl extends TemplateEntityObject {
    private static EntityDefImpl mDefinitionObject;

    /**
     * This is the default constructor (do not remove).
     */
    public BookRequestImpl() {
    }

    /**
     * @param labcol key constituent
     * @param barcode key constituent
     * @param reqNo key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Number labcol, String barcode,
                                       String reqNo) {
        return new Key(new Object[]{labcol, barcode, reqNo});
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("org.parsisys.tehranuniversity.library.model.eo.BookRequest");
        }
        return mDefinitionObject;
    }


}
