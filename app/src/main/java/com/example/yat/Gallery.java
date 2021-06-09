package com.example.yat;

import com.google.firebase.firestore.DocumentId;

import java.util.List;

public class Gallery {

    public static final String collection="Galleries";

    @DocumentId
    private String galleryId;

    private String name;
    private String imageUrl;
    private String description;
    private String location;
    private String openingH;
    private String website;
    private String starRating;


    /**
     * the list of userIds for the users that follow this gallery
     */
    private List<String> followedBy;

    //List of Exhibitions in the gallery
    private List<Exhibition> exhibitions;

    public Gallery(String galleryId, String name, String imageUrl, String description, String location, String openingH, String website, String starRating, List<String> followedBy, List<Exhibition> exhibitions) {
        this.galleryId = galleryId;
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
        this.location = location;
        this.openingH = openingH;
        this.website = website;
        this.starRating = starRating;
        this.followedBy = followedBy;
        this.exhibitions = exhibitions;
    }

    public static String getCollection() {
        return collection;
    }

    public String getGalleryId() {
        return galleryId;
    }

    public void setGalleryId(String galleryId) {
        this.galleryId = galleryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOpeningH() {
        return openingH;
    }

    public void setOpeningH(String openingH) {
        this.openingH = openingH;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getStarRating() {
        return starRating;
    }

    public void setStarRating(String starRating) {
        this.starRating = starRating;
    }

    public List<String> getFollowedBy() {
        return followedBy;
    }

    public void setFollowedBy(List<String> followedBy) {
        this.followedBy = followedBy;
    }

    public List<Exhibition> getExhibitions() {
        return exhibitions;
    }

    public void setExhibitions(List<Exhibition> exhibitions) {
        this.exhibitions = exhibitions;
    }
}
