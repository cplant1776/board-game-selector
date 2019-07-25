package com.bgs.BoardGameSelector.model;

import com.fasterxml.jackson.annotation.JsonTypeId;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "game")
public class Game {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name = "rank")
    private Integer rank;

    @Column(name = "bgg_url")
    private String bgg_url;

    @Id
    @Column(name = "game_id")
    private Integer game_id;

    @Column(name = "name")
    private String name;

    @Column(name = "min_player")
    private Integer min_player;

    @Column(name = "max_player")
    private Integer max_player;

    @Column(name = "avg_play_time")
    private Integer avg_play_time;

    @Column(name = "min_play_time")
    private  Integer min_play_time;

    @Column(name = "max_play_time")
    private Integer max_play_time;

    @Column(name = "year")
    private Integer year;

    @Column(name = "avg_rating")
    private Double avg_rating;

    @Column(name = "num_votes")
    private Integer num_votes;

    @Column(name = "img_url")
    private String img_url;

    @Column(name = "thumb_url")
    private String thumb_url;

    @Column(name = "age")
    private Integer age;

    @Column(name = "mechanic")
    private String mechanic;

    @Column(name = "category")
    private String category;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "fans")
    private Integer fans;

    @Column(name = "desc")
    private String desc;

    @Column(name = "is_user_made")
    private Boolean is_user_made;

    public Long getId() {
        return Id;
    }

    public Integer getRank() {
        return rank;
    }

    public String getBgg_url() {
        return bgg_url;
    }

    public Integer getGame_id() {
        return game_id;
    }

    public String getName() {
        return name;
    }

    public Integer getMin_player() {
        return min_player;
    }

    public Integer getMax_player() {
        return max_player;
    }

    public Integer getAvg_play_time() {
        return avg_play_time;
    }

    public Integer getMin_play_time() {
        return min_play_time;
    }

    public Integer getMax_play_time() {
        return max_play_time;
    }

    public Integer getYear() {
        return year;
    }

    public Double getAvg_rating() {
        return avg_rating;
    }

    public Integer getNum_votes() {
        return num_votes;
    }

    public String getImg_url() {
        return img_url;
    }

    public String getThumb_url() {
        return thumb_url;
    }

    public Integer getAge() {
        return age;
    }

    public String getMechanic() {
        return mechanic;
    }

    public String getCategory() {
        return category;
    }

    public String getPublisher() {
        return publisher;
    }

    public Integer getFans() {
        return fans;
    }

    public String getDesc() {
        return desc;
    }

    public Boolean getIs_user_made() {
        return is_user_made;
    }


    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public void setBgg_url(String bgg_url) {
        this.bgg_url = bgg_url;
    }

    public void setGame_id(Integer game_id) {
        this.game_id = game_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMin_player(Integer min_player) {
        this.min_player = min_player;
    }

    public void setMax_player(Integer max_player) {
        this.max_player = max_player;
    }

    public void setAvg_play_time(Integer avg_play_time) {
        this.avg_play_time = avg_play_time;
    }

    public void setMin_play_time(Integer min_play_time) {
        this.min_play_time = min_play_time;
    }

    public void setMax_play_time(Integer max_play_time) {
        this.max_play_time = max_play_time;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setAvg_rating(Double avg_rating) {
        this.avg_rating = avg_rating;
    }

    public void setNum_votes(Integer num_votes) {
        this.num_votes = num_votes;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public void setThumb_url(String thumb_url) {
        this.thumb_url = thumb_url;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setMechanic(String mechanic) {
        this.mechanic = mechanic;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setFans(Integer fans) {
        this.fans = fans;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setIs_user_made(Boolean is_user_made) {
        this.is_user_made = is_user_made;
    }


    public Game(Integer rank, String bggURL, Integer gameId, String name, Integer minPlayers, Integer maxPlayers,
                Integer avgPlayTime, Integer minPlayTime, Integer maxPlayTime, Integer year, Double avgRating,
                Integer numOfVotes, String imageURL, String thumbnailURL, Integer age, String mechanics,
                String categories, String publisher, Integer numOfFans, String desc, Boolean isUserAdded)
    {
        this.rank = rank;
        this.bgg_url = bggURL;
        this.game_id = gameId;
        this.name = name;
        this.min_player = minPlayers;
        this.max_player = maxPlayers;
        this.avg_play_time = avgPlayTime;
        this.min_play_time = minPlayTime;
        this.max_play_time = maxPlayTime;
        this.year = year;
        this.avg_rating = avgRating;
        this.num_votes = numOfVotes;
        this.img_url = imageURL;
        this.thumb_url = thumbnailURL;
        this.age = age;
        this.mechanic = mechanics;
        this.category = categories;
        this.publisher = publisher;
        this.fans = numOfFans;
        this.desc = desc;
        this.is_user_made = isUserAdded;
    }

    public Game() {
        this.rank = 123;
        this.bgg_url = "123";
        this.game_id = 123;
        this.name = "123";
        this.min_player = 123;
        this.max_player = 123;
        this.avg_play_time = 123;
        this.min_play_time = 123;
        this.max_play_time = 123;
        this.year = 123;
        this.avg_rating = 123.1;
        this.num_votes = 123;
        this.img_url = "123";
        this.thumb_url = "123";
        this.age = 123;
        this.publisher = "123";
        this.fans = 123;
        this.desc = "123123123123123123123";
        this.is_user_made = false;
    }

}