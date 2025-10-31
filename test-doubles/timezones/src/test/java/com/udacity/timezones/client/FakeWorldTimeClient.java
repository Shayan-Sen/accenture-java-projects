package com.udacity.timezones.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FakeWorldTimeClient implements WorldTimeClient {
    private int numberOfCalls = 0;

    private Map<String,List<String>> area = new HashMap<>();

    FakeWorldTimeClient(){}
    FakeWorldTimeClient(Map<String,List<String>> area){this.area =area;}

    @Override
    public List<String> getValidTimeZones(String area) {
        numberOfCalls++;
        return List.of(area);
    }
    public int getNumberOfCalls(){return numberOfCalls;}
}
