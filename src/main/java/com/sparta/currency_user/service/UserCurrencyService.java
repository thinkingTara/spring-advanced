package com.sparta.currency_user.service;

import com.sparta.currency_user.dto.CurrencyResponseDto;
import com.sparta.currency_user.dto.UserCurrencyResponseDto;
import com.sparta.currency_user.dto.UserResponseDto;
import com.sparta.currency_user.entity.Currency;
import com.sparta.currency_user.entity.User;
import com.sparta.currency_user.entity.UserCurrency;
import com.sparta.currency_user.repository.UserCurrencyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserCurrencyService {

    private final UserCurrencyRepository userCurrencyRepository;
    private final UserService userService;
    private final CurrencyService currencyService;

    public UserCurrencyResponseDto createCalcCurrency(Long userId, Long currencyId, Long amountKrw) {

        User userById = userService.findUserById(userId);
        Currency currencyById = currencyService.findCurrencyById(currencyId);

        BigDecimal amountedKrw = new BigDecimal(amountKrw);
        BigDecimal amountAfter = amountedKrw.divide(currencyById.getExchangeRate(), 3, RoundingMode.HALF_UP);

        LocalDateTime createAt = LocalDateTime.now();
        UserCurrency savedUserCurrency =
                userCurrencyRepository.save(new UserCurrency(userById, currencyById, amountKrw, amountAfter, createAt));

        return new UserCurrencyResponseDto(
                savedUserCurrency.getUser(),
                savedUserCurrency.getCurrency(),
                savedUserCurrency.getAmountInKrw(),
                savedUserCurrency.getAmountAfterExchange(),
                savedUserCurrency.getCreateAt(),
                savedUserCurrency.getStatus()
        );
    }

    public List<UserCurrencyResponseDto> byUserIdRecord(Long id) {
        User userById = userService.findUserById(id);
        List<UserCurrency> userCurrencies = userById.getUserCurrencies();
        List<UserCurrencyResponseDto> responseDtos = new ArrayList<>();
        for (UserCurrency item : userCurrencies) {
            responseDtos.add(new UserCurrencyResponseDto(
                    item.getUser(),
                    item.getCurrency(),
                    item.getAmountInKrw(),
                    item.getAmountAfterExchange(),
                    item.getCreateAt(),
                    item.getStatus()
            ));
        }
        return responseDtos;
    }

    @Transactional
    public String changeStatus(Long id) {
        userCurrencyRepository.findById(id).get().update("cancel");

        return userCurrencyRepository.findById(id).get().getStatus();
    }
}
