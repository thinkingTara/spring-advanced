package com.sparta.currency_user.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class UserCurrencyRequestDto {

    Long userId;
    Long currencyId;
    @Positive
    Long amountKrw;

}
