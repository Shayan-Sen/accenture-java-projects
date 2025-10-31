package com.udacity.timezones.service;

import com.udacity.timezones.client.WorldTimeClient;

public class TimeZoneService {
	private final WorldTimeClient worldTimeApiRestClient;

	public TimeZoneService(WorldTimeClient worldTimeApiRestClient) {
		this.worldTimeApiRestClient = worldTimeApiRestClient;
	}

	public String getAvailableTimezoneText(String area) {
		return String.format(
			"Available timezones in %s are %s.",
			area,
			String.join(", ", worldTimeApiRestClient.getValidTimeZones(area))
		);
	}
}
