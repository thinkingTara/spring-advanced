package com.sparta.currency_user.dto;

import com.sparta.currency_user.entity.Currency;
import com.sparta.currency_user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserCurrencyResponseDto {

//    Long id;
//    Long userId;
//    Long currencyId;
    String userName;
    String currencyName;
    Long amountKrw;
    BigDecimal amountAfter;
    String symbol;
    LocalDateTime createAt;

    public UserCurrencyResponseDto() {}

    public UserCurrencyResponseDto(
            User user,
            Currency currency,
            Long amountKrw,
            BigDecimal amountAfter,
            LocalDateTime createAt
    ) {
//        this.userId = user.getId();
//        this.currencyId = currency.getId();
        this.userName = user.getName();
        this.currencyName = currency.getCurrencyName();
        this.amountKrw = amountKrw;
        this.amountAfter = amountAfter;
        this.symbol = currency.getSymbol();
        this.createAt = createAt;
    }

}
