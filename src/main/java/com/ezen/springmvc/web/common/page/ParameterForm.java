package com.ezen.springmvc.web.common.page;

import lombok.*;

/**
 * 페이지 계산에 필요한 요청 파라메터 정보
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ParameterForm {
    private int elementSize = 6;     /** 페이지에 보여지는 목록 갯수 */
    private int pageSize = 5;        /** 페이지에 보여지는 페이지 갯수 */
    private int requestPage = 1;     /** 사용자 요청 페이지 */
    private int rowCount;            /** 테이블 목록 갯수 */
    private String tagName;          /** 검색값 */
}