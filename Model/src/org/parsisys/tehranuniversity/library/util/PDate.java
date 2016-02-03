package org.parsisys.tehranuniversity.library.util;

import oracle.jbo.domain.Number;

public class PDate {
    private Number month;
    private Number day;
    public PDate() {
        super();
    }

    public PDate(Number month, Number day) {
        super();
        this.month = month;
        this.day = day;
    }


    public void setMonth(Number month) {
        this.month = month;
    }

    public Number getMonth() {
        return month;
    }

    public void setDay(Number day) {
        this.day = day;
    }

    public Number getDay() {
        return day;
    }
}
