package com.udacity.timezones;

import com.udacity.timezones.client.FakeWorldTimeClient;
import com.udacity.timezones.service.TimeZoneService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class MainTest {


    @ParameterizedTest(name = "[{index}] {2}")
    @MethodSource("dummyArgumentProvider")
    public void getAvailableTimezonesText_idkHowToNameThis(Map<String, List<String>> timeMap,String area,String returnStatement){
        TimeZoneService service = new TimeZoneService(new FakeWorldTimeClient(timeMap));
        Assertions.assertEquals(service.getAvailableTimezoneText(area),returnStatement);
    }

    public static Stream<Arguments> dummyArgumentProvider(){
        return Stream.of(
                Arguments.of(
                        Map.ofEntries(
                                Map.entry("Europe",List.of("A","B","C")),
                                Map.entry("Australia",List.of("D","E","F"))
                        ),"Europe","Available timezones in Europe are A, B, C."
                ),
                Arguments.of(
                        Map.ofEntries(
                                Map.entry("Europe",List.of("A","B","C")),
                                Map.entry("Australia",List.of("D","E","F"))
                        ),"Australia","Available timezones in Australia are D, E, F."
                )
        );
    }


}
