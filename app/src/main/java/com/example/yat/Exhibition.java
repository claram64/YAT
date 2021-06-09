package com.example.yat;

public class Exhibition {

    private String exhibitionId;
    private String exhibitioName;
    private String exhibitionArtist;
    private String exhibitionPeriod;

    public Exhibition(){}

    public Exhibition(String exhibitionId, String exhibitioName, String exhibitionArtist, String exhibitionPeriod) {
        this.exhibitionId = exhibitionId;
        this.exhibitioName = exhibitioName;
        this.exhibitionArtist = exhibitionArtist;
        this.exhibitionPeriod = exhibitionPeriod;
    }

    public String getExhibitionId() {
        return exhibitionId;
    }

    public void setExhibitionId(String exhibitionId) {
        this.exhibitionId = exhibitionId;
    }

    public String getExhibitioName() {
        return exhibitioName;
    }

    public void setExhibitioName(String exhibitioName) {
        this.exhibitioName = exhibitioName;
    }

    public String getExhibitionArtist() {
        return exhibitionArtist;
    }

    public void setExhibitionArtist(String exhibitionArtist) {
        this.exhibitionArtist = exhibitionArtist;
    }

    public String getExhibitionPeriod() {
        return exhibitionPeriod;
    }

    public void setExhibitionPeriod(String exhibitionPeriod) {
        this.exhibitionPeriod = exhibitionPeriod;
    }
}
