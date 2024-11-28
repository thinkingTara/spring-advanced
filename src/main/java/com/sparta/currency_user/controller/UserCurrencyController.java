package com.sparta.currency_user.controller;

import com.sparta.currency_user.dto.CurrencyResponseDto;
import com.sparta.currency_user.dto.UserCurrencyRequestDto;
import com.sparta.currency_user.dto.UserCurrencyResponseDto;
import com.sparta.currency_user.dto.UserResponseDto;
import com.sparta.currency_user.entity.Currency;
import com.sparta.currency_user.entity.User;
import com.sparta.currency_user.service.CurrencyService;
import com.sparta.currency_user.service.UserCurrencyService;
import com.sparta.currency_user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user-currencies")
@RequiredArgsConstructor
public class UserCurrencyController {

    private final UserCurrencyService userCurrencyService;
    private final UserService userService;
    private final CurrencyService currencyService;

    @PostMapping
    public ResponseEntity<UserCurrencyResponseDto> calcCurrency(@RequestBody UserCurrencyRequestDto requestDto){
        UserResponseDto userById = userService.findById(requestDto.getUserId());
        CurrencyResponseDto currencyById = currencyService.findById(requestDto.getCurrencyId());
        //UserCurrencyResponseDto responseDto = userCurrencyService.calcCurrency(userById, currencyById, requestDto.getAmountKrw());
        UserCurrencyResponseDto responseDto = userCurrencyService.createCalcCurrency(requestDto.getUserId(), requestDto.getCurrencyId(), requestDto.getAmountKrw());
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }
}
