package ru.hackathon2807.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder
public class UserReplyDto {

    private final String fullName;
    private final String email;
    private  final String telephone;
    private final String passport;
}
