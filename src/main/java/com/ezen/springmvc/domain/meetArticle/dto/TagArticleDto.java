package com.ezen.springmvc.domain.meetArticle.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class TagArticleDto {
    private String tagName;
    private int tArticleId;
    private int meetArticleId;
}
