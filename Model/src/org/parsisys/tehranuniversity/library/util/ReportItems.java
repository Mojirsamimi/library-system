package org.parsisys.tehranuniversity.library.util;

import oracle.jbo.domain.Number;

public class ReportItems {
    private String barcode;
    private Number artId;
    public ReportItems() {
        super();
    }
  public ReportItems(Number artId,String barcode) {
    super();

  this.artId=artId;
  this.barcode=barcode;

  }
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setArtId(Number artId) {
        this.artId = artId;
    }

    public Number getArtId() {
        return artId;
    }
}
