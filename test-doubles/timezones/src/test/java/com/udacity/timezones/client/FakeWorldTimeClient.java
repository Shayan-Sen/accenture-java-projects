package com.udacity.timezones.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FakeWorldTimeClient implements WorldTimeClient {
    private int numberOfCalls = 0;

    private Map<String,List<String>> timeMap = new HashMap<>();

    public FakeWorldTimeClient(){}
    public FakeWorldTimeClient(Map<String,List<String>> timeMap){this.timeMap =timeMap;}

    @Override
    public List<String> getValidTimeZones(String area) {
        numberOfCalls++;
        return timeMap.get(area);
    }
    public int getNumberOfCalls(){return numberOfCalls;}
}
