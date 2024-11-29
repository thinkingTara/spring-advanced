package com.sparta.currency_user.dto;

import com.sparta.currency_user.entity.User;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class UserRequestDto {
    @NonNull
    private String name;

    @Pattern(regexp = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])+[.][a-zA-Z]{2,3}$", message="이메일 주소 양식을 확인해주세요")
    private String email;

    public User toEntity() {
        return new User(
                this.name,
                this.email
        );
    }
}
