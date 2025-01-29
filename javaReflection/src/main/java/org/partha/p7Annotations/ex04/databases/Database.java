package org.partha.p7Annotations.ex04.databases;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Database {
    public Set<String> readAllGames() {
        return Set.of("call-of-duty","hitman","far-cry","cyber-punk");
    }


    public Map<String, Float> readGameToPrice(Set<String> allGames) {
        Map<String,Float> map = new HashMap<>();
        map.put("call-of-duty",100f);
        map.put("hitman",130f);
        map.put("far-cry",90f);
        map.put("cyber-punk",200f);
        return map;
    }

    public Map<String, Float> readGameToRatings(Set<String> allGames) {
        Map<String,Float> map = new HashMap<>();
        map.put("call-of-duty",7f);
        map.put("hitman",5f);
        map.put("far-cry",8f);
        map.put("cyber-punk",9f);
        return map;
    }
}
