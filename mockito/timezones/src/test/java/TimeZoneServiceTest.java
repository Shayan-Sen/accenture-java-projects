import com.udacity.timezones.client.WorldTimeApiHttpClient;
import com.udacity.timezones.service.TimeZoneService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
public class TimeZoneServiceTest {
    @Mock
    WorldTimeApiHttpClient worldTimeApiClient;

    TimeZoneService timeZoneService;

    @BeforeEach
    void init(){
        this.timeZoneService = new TimeZoneService(worldTimeApiClient);
    }

    @ParameterizedTest
    @MethodSource("dummyProvider")
    public void getAvailableTimeZonesText_takesStringAndList_ReturnString(String area, List<String> timeZones,String output){
        Mockito.when(worldTimeApiClient.getValidTimeZones(area)).thenReturn(timeZones);
        Assertions.assertEquals(timeZoneService.getAvailableTimezoneText(area),output);
    }

    public static Stream<Arguments> dummyProvider(){
        return Stream.of(
                Arguments.of("Europe",List.of("A","B","C"),"Available timezones in Europe are A, B, C."),
                Arguments.of("Australia",List.of("A","B","C"),"Available timezones in Australia are A, B, C.")
        );
    }
}
