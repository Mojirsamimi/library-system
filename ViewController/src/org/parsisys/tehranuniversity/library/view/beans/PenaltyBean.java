package org.parsisys.tehranuniversity.library.view.beans;

public class PenaltyBean {
    private String description;
    private String penaltyValue;
    private String path;
    private String title;
    public PenaltyBean() {
        
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setPenaltyValue(String penaltyValue) {
        this.penaltyValue = penaltyValue;
    }

    public String getPenaltyValue() {
        return penaltyValue;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
