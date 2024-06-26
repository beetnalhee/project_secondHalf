package com.ezen.springmvc.web.meet.form;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MeetReplyForm {
    private int meetArticleId;
    private String writer;
    private String content;
}
