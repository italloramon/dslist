package com.italloramon.dslist.dto;

import com.italloramon.dslist.entities.Game;
import jakarta.persistence.Column;

public class GameMinDTO {
    private Long id;
    private String title;
    private Integer year;

    private String imageUrl;
    private String shortDescription;

    public GameMinDTO(){ }

    public GameMinDTO(Game entity) {
        id = entity.getId();
        title = entity.getTitle();
        year = entity.getYear();
        imageUrl = entity.getImageUrl();
        shortDescription = entity.getShortDescription();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}
