package com.newer.dao;

import com.newer.domain.Member;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface MemberMapper {
    @Insert("insert into t_member values(null,#{mname},#{mphone},#{mlevel},now(),#{mcardNo})")
    int addMember(Member member);

    @Update("update t_member set m_name=#{mname},m_level=#{mlevel},m_phone=#{mphone},m_card_no=#{mcardNo} where m_id=#{mid}")
    int updateMember(Member member);

    @Delete("delete from t_member where m_id=#{mid}")
    int deleteMember(@Param("mid") int mid);


    Member findById(@Param("mid") int mid);

    List<Member> find(Map<String,Object> map);

}
