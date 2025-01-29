package org.partha.p7Annotations.ex04;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

public class ApplicationParamAnnotation {

    public static void main(String[] args) {

        BestGamesFinder bestGamesFinder = new BestGamesFinder();

        Set<String> allGames = bestGamesFinder.getAllGames();

        Map<String, Float> gameToRating = bestGamesFinder.getGameToRating(allGames);
        Map<String, Float> gameToPrice = bestGamesFinder.getGameToPrice(allGames);

        SortedMap<Double, String> scoreToGame = bestGamesFinder.scoreGames(gameToPrice, gameToRating);

        List<String> bestGamesInDescendingOrder = bestGamesFinder.getTopGames(scoreToGame);

        System.out.println(bestGamesFinder);

    }
}
