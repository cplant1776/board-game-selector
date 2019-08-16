# Board Game Selection Web App

A web app to assist users in finding a board game to play based on a series of optional criteria. The data (5000 base games + user made games) used is drawn from [Board Game Geek](https://boardgamegeek.com/) using a combination of [this tool](https://github.com/mcdemarco/bgg_pull/tree/fans) and some minor scraping on my own part. It is built on the Spring Boot Framework and uses Thymeleaf for front-end rendering.

## Link to App
[Just show me the app!](https://bg-selector.herokuapp.com/) Note: the app is unloaded from the server's memory when not used for a while, so it may take a bit to start. Because this project uses a free datbase host, the game data present in the link is just a subset of the full set (top 500 ranked games + user-made games). Finally, the interface is rather minimal at the moment, as I slapped it together as a placeholder. Making it pretty is coming up on the to-do list.

## Motivation

Going into this project, I knew practically nothing about actually developing a web app. Therefore, this project has three (selfish) objectives:

1. Increase familiarity with Spring Framework and MVC architecture
2. Gain some experience using Java beyond completing exercises
3. Refresh myself on the basics of Bootstrap and the front-end in general

## Basic Feature Overview

* Filter and search/sort within the game database
* Add/Edit/Delete user accounts (with authentication)
* Add/Edit/Delete user-added games
* Add/Edit/Delete comments to games
* Users can upload their own avatar images
* Can filter games by category/mechanic

## Current Roadmap (To-Do)

1. Make it pretty
1. Add Unit Tests
1. Voting function

## Current Reflections

I believe my biggest regret at this point is not developing unit tests as I went along. However, I wanted the momentum of just getting it off the ground before diving into the boring side. Now I will have to go back and add them after the fact before development continues.

Another painful point I came across was deploying from local development to Heroku (a web server). Particularly, I had trouble getting image assets to load correctly. This was due to database connection issues, pathing woes, and wrangling Spring resource handlers. After much fiddling, I got it working. However, I was unsatisfied with how fragile it seemed and decided to migrate to external database and image hosts.

Other than that, this has been a realtively-smooth project. Of course there has been a few instances of hair-pulling-inducing bugs, but I have learned a substantial amount regarding full-stack web development, java, databases, and api's. Therefore, I would consider it a success in its objectives.
