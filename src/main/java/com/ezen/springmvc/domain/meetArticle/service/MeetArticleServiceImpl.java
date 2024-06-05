package com.ezen.springmvc.domain.meetArticle.service;

import com.ezen.springmvc.domain.common.dto.SearchDto;
import com.ezen.springmvc.domain.dailyarticle.dto.ReplyDto;
import com.ezen.springmvc.domain.meetArticle.dto.*;
import com.ezen.springmvc.domain.meetArticle.mapper.*;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MeetArticleServiceImpl implements MeetArticleService {
    private static final Logger log = LoggerFactory.getLogger(MeetArticleServiceImpl.class);
    private final MeetArticleMapper meetArticleMapper;
    private final MeetReplyMapper meetReplyMapper;
    private final TagMapper tagMapper;
    private final TagArticleMapper tagArticleMapper;

    // 모임 등록 서비스
    @Override
    @Transactional
    public void addMeet(MeetArticleDto meetArticleDto) {
        // 모임게시글 테이블에 신규 게시글 등록 
        meetArticleMapper.createMeetArticle(meetArticleDto);
        // 태그게시글 테이블에 신규 태그게시글 등록
        TagArticleDto tagArticleDto = TagArticleDto.builder()
                .meetArticleId(meetArticleDto.getMeetArticleId())
                .build();
        tagArticleMapper.createTagArticle(tagArticleDto);
        // 테그 테이블에 신규 태그 등록
        String[] tags = meetArticleDto.getTags();
        if (tags != null) {
            for (String tagName : tags) {
                tagName = tagName.trim();
                TagDto tagDto = TagDto.builder()
                        .tagName(tagName)
                        .tArticleId(tagArticleDto.getTArticleId())
                        .build();
                // 태그 등록 및 해당 태그의 tag_id 가져오기
                tagMapper.createTag(tagDto);
            }
        }
    }

    @Override
    public List<TagDto> findByAllTagName(String tagName) {
        return tagMapper.findByAllTagName(tagName);
    }

    @Override
    public List<MeetArticleDto> findByAllMeetArticle(int categoryId) {
        return meetArticleMapper.findByAllMeetArticle(categoryId);
    }

    @Override
    public List<MeetArticleDto> findByTitle(int categoryId, SearchDto searchDto) {
        return meetArticleMapper.findByTitle(categoryId, searchDto);
    }

    @Override
    public MeetArticleDto readMeetArticle(int categoryId, int meetArticleId) {
        return meetArticleMapper.readMeetArticle(categoryId, meetArticleId);
    }

    @Override
    public int findByMeetArticleCount(int categoryId, SearchDto searchDto) {
        return meetArticleMapper.findByMeetArticleCount(categoryId, searchDto);
    }

    @Override
    public MeetArticleDto hitcount(MeetArticleDto meetArticleDto) {
        meetArticleMapper.hitcount(meetArticleDto);
        return meetArticleDto;
    }

    @Override
    @Transactional
    public void createReply(MeetReplyDto meetReplyDto) {
        meetReplyMapper.createReply(meetReplyDto);
    }

    @Override
    public List<MeetReplyDto> replyList(int meetArticleId) {
        return meetReplyMapper.findByReplyAll(meetArticleId);
    }

    @Override
    public int replyCount(int meetArticleId) {
        return meetReplyMapper.replyCount(meetArticleId);
    }

    @Override
    public void participate(int categoryId, int meetArticleId, String memberId) {
        meetArticleMapper.participate(categoryId, meetArticleId, memberId);
    }

    @Override
    public void cancelParticipation(int categoryId, int meetArticleId, String memberId) {
        meetArticleMapper.cancelParticipation(categoryId, meetArticleId, memberId);
    }
}
