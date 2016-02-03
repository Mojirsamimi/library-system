package org.parsisys.tehranuniversity.library.view.beans;

import java.util.Date;

import util.FDate;

public class CommonBean {
    private String shamsiToday;
    public CommonBean() {
        super();
    
     
    }

    public void setShamsiToday(String farsiToday) {
        this.shamsiToday = farsiToday;
    }

    public String getShamsiToday() {
        return FDate.Farsi_from_Georgian(new Date());
    }
}
