package com.udacity.timezones;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class MainTest {


    @ParameterizedTest()
    @MethodSource("dummyArgumentProvider")
    public void getAvailableTimezonesText_idkHowToNameThis(Map<String, List<String>> area){
        Assertions.assertTrue(true);
    }

    public static Stream<Arguments> dummyArgumentProvider(){
        return Stream.of(
                Arguments.of(
                        Map.ofEntries(
                                Map.entry("Europe",List.of("A","B","C"))
                        )
                )
        );
    }


}
