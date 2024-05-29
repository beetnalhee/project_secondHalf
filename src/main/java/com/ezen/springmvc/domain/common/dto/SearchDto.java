package com.ezen.springmvc.domain.common.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class SearchDto {
    private String tagName;
    private int limit;
    private int page;
}