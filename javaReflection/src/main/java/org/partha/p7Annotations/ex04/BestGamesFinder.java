package org.partha.p7Annotations.ex04;

import org.partha.p7Annotations.ex04.customAnnotations.Annotations;
import org.partha.p7Annotations.ex04.databases.Database;

import java.util.*;

public class BestGamesFinder {

    private Database database = new Database();

    @Annotations.Operation("all-games")
    public Set<String> getAllGames(){
        return database.readAllGames();
    }

    @Annotations.Operation("game-to-price")
    public Map<String, Float> getGameToPrice(@Annotations.DependsOn("all-games") Set<String> allGames){
        return database.readGameToPrice(allGames);
    }

    @Annotations.Operation("game-to-rating")
    public Map<String, Float> getGameToRating(@Annotations.DependsOn("all-games") Set<String> allGames){
        return database.readGameToRatings(allGames);
    }

    @Annotations.Operation("score-to-game")
    public SortedMap<Double,String> scoreGames(@Annotations.DependsOn("game-to-price") Map<String, Float> gameToPrice,
                                                @Annotations.DependsOn("game-to-rating") Map<String, Float> gameToRating) {
        SortedMap<Double,String> gameToScore = new TreeMap<>(Collections.reverseOrder());
        for(String gameName: gameToPrice.keySet()){
            double score = (double) gameToRating.get(gameName)/gameToPrice.get(gameName);
            gameToScore.put(score, gameName);
        }
        return gameToScore;
    }

    @Annotations.FinalResult
    public List<String> getTopGames(@Annotations.DependsOn("score-to-game") SortedMap<Double,String> gameToScore){
        return new ArrayList<>(gameToScore.values());
    }

}
