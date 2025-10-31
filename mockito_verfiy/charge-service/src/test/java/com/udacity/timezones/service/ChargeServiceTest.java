package com.udacity.timezones.service;

import com.udacity.timezones.client.ChargeUserApiHttpClient;
import com.udacity.timezones.model.TicketItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;
import static  org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ChargeServiceTest {
    @Mock
    ChargeUserApiHttpClient chargeUserApiClient;

    ChargeService chargeService;

    @BeforeEach
    void each(){chargeService = new ChargeService(chargeUserApiClient);}

    @ParameterizedTest
    @MethodSource("arguments")
    public void chargeUser_check(String id, List<TicketItem> items, BigDecimal tip, BigDecimal discount,BigDecimal amount){
        chargeService.chargeUser(id,items,tip,discount);
        verify(chargeUserApiClient).charge(id,amount);
    }

    public static Stream<Arguments> arguments(){
        return Stream.of(
                Arguments.of("",List.of(
                        new TicketItem("Soda", new BigDecimal("10.0"), new BigDecimal("1.0")),
                        new TicketItem("Soda", new BigDecimal("12.0"), new BigDecimal("1.2"))),
                        new BigDecimal("1.50"),new BigDecimal("0.25"),new BigDecimal("25.45")
        ),
                Arguments.of("a",List.of(
                        new TicketItem("",BigDecimal.ZERO,BigDecimal.ZERO),
                        new TicketItem("",BigDecimal.ZERO,BigDecimal.ZERO)),
                        BigDecimal.ZERO,BigDecimal.ZERO,BigDecimal.ZERO)
                );
    }

}