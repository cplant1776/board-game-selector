package com.bgs.BoardGameSelector.model;

import java.util.List;

public class Game {
    private final Integer rank;
    private final String bggURL;
    private final Integer gameId;
    private final String name;
    private final Integer minPlayers;
    private final Integer maxPlayers;
    private final Integer avgPlayTime;
    private final Integer minPlayTime;
    private final Integer maxPlayTime;
    private final Integer year;
    private final Float avgRating;
    private final Integer numOfVotes;
    private final String imageURL;
    private final String thumbnailURL;
    private final Integer age;
    private final List<String> mechanics;
    private final List<String> categories;
    private final String publisher;
    private final Integer numOfFans;
    private final String description;
    private final Boolean isUserAdded;


    public Game(Integer rank, String bggURL, Integer gameId, String name, Integer minPlayers, Integer maxPlayers,
                Integer avgPlayTime, Integer minPlayTime, Integer maxPlayTime, Integer year, Float avgRating,
                Integer numOfVotes, String imageURL, String thumbnailURL, Integer age, List<String> mechanics,
                List<String> categories, String publisher, Integer numOfFans, String description, Boolean isUserAdded)
    {
        this.rank = rank;
        this.bggURL = bggURL;
        this.gameId = gameId;
        this.name = name;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.avgPlayTime = avgPlayTime;
        this.minPlayTime = minPlayTime;
        this.maxPlayTime = maxPlayTime;
        this.year = year;
        this.avgRating = avgRating;
        this.numOfVotes = numOfVotes;
        this.imageURL = imageURL;
        this.thumbnailURL = thumbnailURL;
        this.age = age;
        this.mechanics = mechanics;
        this.categories = categories;
        this.publisher = publisher;
        this.numOfFans = numOfFans;
        this.description = description;
        this.isUserAdded = isUserAdded;
    }
}
