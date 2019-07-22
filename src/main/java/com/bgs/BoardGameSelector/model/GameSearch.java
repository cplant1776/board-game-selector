package com.bgs.BoardGameSelector.model;
import java.util.List;

public class GameSearch {
    public int minRank;
    public int maxRank;
    public int minNumOfPlayers;
    public int maxNumOfPlayers;
    public int minYearPublished;
    public int maxYearPublished;
    public int minAvgPlayTime;
    public int maxAvgPlayTime;
    public int minMinPlayTime;
    public int maxMinPlayTime;
    public int minMaxPlayTime;
    public int maxMaxPlayTime;
    public int minVotes;
    public int maxVotes;
    public int minAge;
    public int maxAge;
    public int minFans;
    public int maxFans;
    public List<String> mechanic;
    public List<String> category;

    public GameSearch()
    {
        minRank = 1;
        maxRank = 25;
        minNumOfPlayers = -1;
        maxNumOfPlayers = -1;
        minYearPublished = -1;
        maxYearPublished = -1;
        minAvgPlayTime = -1;
        maxAvgPlayTime = -1;
        minMinPlayTime = -1;
        maxMinPlayTime = -1;
        minMaxPlayTime = -1;
        maxMaxPlayTime = -1;
        minVotes = -1;
        maxVotes = -1;
        minAge = -1;
        maxAge = -1;
        minFans = -1;
        maxFans = -1;
    }
}
