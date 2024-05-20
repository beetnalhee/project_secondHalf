package com.ezen.springmvc.domain.dailyarticle.service;

import com.ezen.springmvc.domain.dailyarticle.dto.DailyArticleDto;
import com.ezen.springmvc.domain.dailyarticle.mapper.DailyArticleMapper;
import com.ezen.springmvc.domain.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DailyArticleServiceImpl implements DailyArticleService {

    private final DailyArticleMapper dailyArticleMapper;

    /**
     * 신규 일상 게시글 등록 구현
     * @param dailyArticleDto 일상 게시글
     * @return 일상 게시글
     */
    @Override
    @Transactional
    public DailyArticleDto writeDailyArticle(DailyArticleDto dailyArticleDto) {
        dailyArticleMapper.createDailyArticle(dailyArticleDto);
        return dailyArticleMapper.findByDailyArticleId(dailyArticleDto.getDailyArticleId());
    }

    /**
     * 일상 게시글 목록 반환 구현
     * @param categoryId 카테고리 번호
     * @return 일상 게시글 목록
     */
    @Override
    public List<DailyArticleDto> getDailyArticles(int categoryId) {
        return dailyArticleMapper.findByAllDailyArticle(categoryId);
    }
}
