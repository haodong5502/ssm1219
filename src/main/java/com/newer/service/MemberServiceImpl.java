package com.newer.service;

import com.newer.dao.MemberMapper;
import com.newer.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("memberService")
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberMapper memberMapper;

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    @Override
    public int addMember(Member member) {
        return memberMapper.addMember(member);
    }
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    @Override
    public int updateMember(Member member) {

        return memberMapper.updateMember(member);
    }
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    @Override
    public int deleteMember(int mid) {
        return memberMapper.deleteMember(mid);
    }

    @Override
    public Member findById(int mid) {
        return memberMapper.findById(mid);
    }

    @Override
    public List<Member> find(Map<String, Object> map) {
        return memberMapper.find(map);
    }
}
