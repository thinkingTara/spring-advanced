package com.sparta.currency_user.service;

import com.sparta.currency_user.dto.CurrencyResponseDto;
import com.sparta.currency_user.dto.UserCurrencyResponseDto;
import com.sparta.currency_user.dto.UserResponseDto;
import com.sparta.currency_user.entity.Currency;
import com.sparta.currency_user.entity.User;
import com.sparta.currency_user.entity.UserCurrency;
import com.sparta.currency_user.repository.UserCurrencyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserCurrencyService {

    private final UserCurrencyRepository userCurrencyRepository;
    private final UserService userService;
    private final CurrencyService currencyService;



//    public UserCurrencyResponseDto calcCurrency(UserResponseDto userById, CurrencyResponseDto currencyById, Long amountKrw) {
//
//        BigDecimal amountedKrw = new BigDecimal(amountKrw);
//        BigDecimal amountAfter = amountedKrw.divide(currencyById.getExchangeRate(), 3, RoundingMode.HALF_UP);
//
//        UserCurrency savedUserCurrency = userCurrencyRepository.save(new UserCurrency(
//                userById.getId(),
//                currencyById.getId(),
//                amountKrw,
//                amountAfter)
//        );
//        log.info(" savedUserCurrency.getId() : {}", savedUserCurrency.getId());
////        log.info("savedUserCurrency.getUser() : {}",savedUserCurrency.getUser().getName());
////        return new UserCurrencyResponseDto(
////                savedUserCurrency.getId(),
////                savedUserCurrency.getUser().getName(),
////                savedUserCurrency.getCurrency().getCurrencyName(),
////                savedUserCurrency.getAmountInKrw(),
////                savedUserCurrency.getAmountAfterExchange()
////        );
//        return new UserCurrencyResponseDto(savedUserCurrency.getId(), userById,currencyById,amountKrw,amountAfter);
//    }

    public UserCurrencyResponseDto createCalcCurrency(Long userId, Long currencyId, Long amountKrw) {

        User userById = userService.findUserById(userId);
        Currency currencyById = currencyService.findCurrencyById(currencyId);

        BigDecimal amountedKrw = new BigDecimal(amountKrw);
        BigDecimal amountAfter = amountedKrw.divide(currencyById.getExchangeRate(), 3, RoundingMode.HALF_UP);

        UserCurrency savedUserCurrency = userCurrencyRepository.save(new UserCurrency(userById, currencyById, amountKrw, amountAfter));


        return new UserCurrencyResponseDto(
                savedUserCurrency.getId(),
                savedUserCurrency.getUser(),
                savedUserCurrency.getCurrency(),
                savedUserCurrency.getAmountInKrw(),
                savedUserCurrency.getAmountAfterExchange());
    }
}
