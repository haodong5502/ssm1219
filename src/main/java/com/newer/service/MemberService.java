package com.newer.service;

import com.newer.domain.Member;
import org.apache.ibatis.annotations.Param;


import java.util.List;
import java.util.Map;

public interface MemberService {

    int addMember(Member member);

    int updateMember(Member member);

    int deleteMember(int mid);

    Member findById(int mid);

    List<Member> find(Map<String,Object> map);

}
