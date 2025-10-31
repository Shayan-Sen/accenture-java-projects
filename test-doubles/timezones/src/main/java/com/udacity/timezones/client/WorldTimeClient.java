package com.udacity.timezones.client;

import java.util.List;

public interface WorldTimeClient {
    public List<String> getValidTimeZones(String area);
}
