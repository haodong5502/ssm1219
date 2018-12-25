package com.newer.controller;

import com.newer.domain.Member;
import com.newer.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/members")
public class Controller {

    @Autowired
    private MemberService memberService;

    @GetMapping
    public List<Member> find(@RequestParam(value = "mname",required = false) String mname,
                             @RequestParam(value = "mcardNo",required = false) String mcardNo){
        Map<String,Object> map=new HashMap<>();
        if(mname!=null){
            map.put("mname","%"+mname+"%");
        }
        if(mcardNo!=null){
            map.put("mcardNo","%"+mcardNo+"%");
        }
        return memberService.find(map);
    }

    @PostMapping
    public Map<String,Object> addMember(Member member){

        int flw=memberService.addMember(member);
        Map<String,Object> results=new HashMap<>();
        results.put("flw",flw);
        return results;
    }

    @RequestMapping(value = "/upd{mid}",method = RequestMethod.POST)
    public Map<String,Object> updateMember(@PathVariable("mid") int mid, Member member){
        int count=memberService.updateMember(member);
        Map<String,Object> results=new HashMap<>();
        results.put("count",count);
        return results;
    }

    @RequestMapping(value = "/mids1{mid}",method = RequestMethod.GET)
    public Member findById(@PathVariable("mid")int mid){

        return memberService.findById(mid);
    }


    @DeleteMapping(value = "/{mid}")
    public Map<String,Object> deleteMember(@PathVariable("mid")int mid){
        int flw=memberService.deleteMember(mid);
        Map<String,Object> results=new HashMap<>();
        results.put("flw",flw);
        return results;
    }


}
