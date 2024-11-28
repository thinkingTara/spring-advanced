package com.sparta.currency_user.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
//@Table(name = "user_currency")
public class UserCurrency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="currency_id")
    private Currency currency;

    private Long amountInKrw;
    private BigDecimal amountAfterExchange;
//    private String status;
    private LocalDateTime createAt;

    public UserCurrency() {
    }

    public UserCurrency(
//            Long user_id,
//            Long currency_id,
            User user,
            Currency currency,
            Long amountInKrw,
            BigDecimal amountAfterExchange){
        this.user = user;
        this.currency = currency;
        this.amountInKrw = amountInKrw;
        this.amountAfterExchange = amountAfterExchange;
    }

}
