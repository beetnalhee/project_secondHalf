package com.ezen.springmvc.domain.member.mapper;

import com.ezen.springmvc.domain.member.dto.MemberDto;
import com.ezen.springmvc.domain.member.dto.MemberSearchCondition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MemberMapper {
    //회원 생성
    public void create(MemberDto member);

    //로그인
    public MemberDto findByIdAndPasswd(@Param("memberId") String id, @Param("memberPasswd") String passwd);

    //회원정보 수정
    public void updateInfo(MemberDto member);

    //닉네임 변경
    public void updateNickname(MemberDto member);

    //비밀번호 변경
    public void updatePasswd(MemberDto member);

    //대표사진 변경
    public void updatePicture(MemberDto member);

    //아이디로 회원찾기
    public MemberDto findById(String id);

    //닉네임으로 회원찾기
    public MemberDto findByNickname(String nickname);

    //회원목록 조회
    public List<MemberDto> findByAll();

    //회원 아이디 찾기
    public String findMemberId(String name, String nickname);

    //회원 비밀번호 찾기
    public MemberDto findMemberPasswd(String id, String name, String email);

    //회원 비밀번호 확인
    public String confirmPasswd(String id);

    //검색으로 회원 리스트 찾기
    public List<MemberDto> findByKeyword(String keyword);

    //회원 활동정지
    public void banMember(String id);

    //회원 정지 해제
    public void releaseMember(String id);

    //회원 삭제
    public void fireMember(String id);
}

