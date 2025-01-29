package org.partha.p7Annotations.ex04;

import org.partha.p7Annotations.ex04.databases.Database;

import java.util.*;

public class BestGamesFinder {

    private Database database = new Database();

    public Set<String> getAllGames(){
        return database.readAllGames();
    }

    public Map<String, Float> getGameToPrice(Set<String> allGames){
        return database.readGameToPrice(allGames);
    }

    public Map<String, Float> getGameToRating(Set<String> allGames){
        return database.readGameToRatings(allGames);
    }

    public SortedMap<Double,String> scoreGames( Map<String, Float> gameToPrice,
                                                Map<String, Float> gameToRating) {
        SortedMap<Double,String> gameToScore = new TreeMap<>(Collections.reverseOrder());
        for(String gameName: gameToPrice.keySet()){
            double score = (double) gameToRating.get(gameName)/gameToPrice.get(gameName);
            gameToScore.put(score, gameName);
        }
        return gameToScore;
    }

    public List<String> getTopGames(SortedMap<Double,String> gameToScore){
        return new ArrayList<>(gameToScore.values());
    }

}
