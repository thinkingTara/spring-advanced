package com.sparta.currency_user.dto;

import com.sparta.currency_user.entity.Currency;
import com.sparta.currency_user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class UserCurrencyResponseDto {

    Long id;
    Long userId;
    String userName;
    Long currencyId;
    String currencyName;
    Long amountKrw;
    BigDecimal amountAfter;
    String symbol;

    public UserCurrencyResponseDto(){}
    public UserCurrencyResponseDto(Long id, User user, Currency currency, Long amountKrw, BigDecimal amountAfter){
        this.id = id;
        this.userId = user.getId();
        this.userName = user.getName();
        this.currencyId = currency.getId();
        this.currencyName = currency.getCurrencyName();
        this.amountKrw = amountKrw;
        this.amountAfter = amountAfter;
        this.symbol = currency.getSymbol();
    }
//    public UserCurrencyResponseDto(Long id, UserResponseDto user, CurrencyResponseDto currency, Long amountKrw, BigDecimal amountAfter){
//        this.id = id;
//        this.userId = user.getId();
//        this.userName = user.getName();
//        this.currencyId = currency.getId();
//        this.currencyName = currency.getCurrencyName();
//        this.amountKrw = amountKrw;
//        this.amountAfter = amountAfter;
//        this.symbol = currency.getSymbol();
//    }

    public UserCurrencyResponseDto(
            Long id,
            String userName,
            String currencyName,
            Long amountKrw,
            BigDecimal amountAfter
    ){
        this.id= id;
        this.userName = userName;
        this.currencyName = currencyName;
        this.amountKrw = amountKrw;
        this.amountAfter = amountAfter;

    }

}
