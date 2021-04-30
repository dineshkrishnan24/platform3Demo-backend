package com.platform3.demoproject.service.impl;

import com.platform3.demoproject.constants.vo.MemberVO;
import com.platform3.demoproject.models.Member;
import com.platform3.demoproject.repository.MemberRepository;
import com.platform3.demoproject.service.MemberService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<MemberVO> getAllMembers(MultiValueMap<String, String> queryParam) {
        List<Member> members = memberRepository.findAll();
        List<MemberVO> memberVOS = new ArrayList<>();
        members.forEach(eachMember-> {
            MemberVO memberVO = modelMapper.map(eachMember,MemberVO.class);
            memberVOS.add(memberVO);
        });
        return memberVOS;
    }

    @Override
    public MemberVO getMemberById(String id, MultiValueMap<String, String> queryMap) {
        Member member = memberRepository.findById(id).orElse(null);
        if(Objects.isNull(member)) {
            return null;
        }
        MemberVO memberVO = modelMapper.map(member,MemberVO.class);
        return memberVO;
    }

    @Override
    public MemberVO updateByMemberId(String id, MemberVO memberVO) {
        Member member = memberRepository.findById(id).orElse(null);
        if(Objects.isNull(member)) {
            return null;
        }
        Member updatedMember = modelMapper.map(memberVO, Member.class);
        updatedMember.setId(member.getId());
        updatedMember = memberRepository.save(updatedMember);
        memberVO = modelMapper.map(updatedMember,MemberVO.class);
        return memberVO;
    }

    @Override
    public String deleteByMemberId(String id) {
        Member member = memberRepository.findById(id).orElse(null);
        if(Objects.isNull(member)) {
            return null;
        }
        memberRepository.deleteById(id);
        return "success";
    }


}
