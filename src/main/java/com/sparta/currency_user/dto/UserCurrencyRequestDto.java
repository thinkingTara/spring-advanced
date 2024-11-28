package com.sparta.currency_user.dto;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class UserCurrencyRequestDto {

    Long userId;
    Long currencyId;
    Long amountKrw;

}
