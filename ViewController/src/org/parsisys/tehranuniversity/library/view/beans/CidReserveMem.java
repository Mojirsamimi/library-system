package org.parsisys.tehranuniversity.library.view.beans;

import javax.faces.event.ActionEvent;

import util.JSFUtils;

public class CidReserveMem {
    private String popUpTxt;
    public CidReserveMem() {
        super();
    }

    public void reserveBtnActionListener(ActionEvent actionEvent) {
      setPopUpTxt("hellooooooo!");
      System.out.println("this is test");
      JSFUtils.showPopup("p2");
    }

    public void setPopUpTxt(String popUpTxt) {
        this.popUpTxt = popUpTxt;
    }

    public String getPopUpTxt() {
        return popUpTxt;
    }
}
