package com.spring.took.api.Uber.DTO;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReturnReviewDto {
    private long id;
    private String content;
    private double rating;
    private long booking;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
