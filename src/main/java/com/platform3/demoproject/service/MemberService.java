package com.platform3.demoproject.service;

import com.platform3.demoproject.constants.vo.MemberVO;
import org.springframework.util.MultiValueMap;

import java.util.List;

public interface MemberService {

    public List<MemberVO> getAllMembers(MultiValueMap<String, String> queryParam);

    public MemberVO updateByMemberId(String id, MemberVO memberVO);

    public String deleteByMemberId(String id);

    MemberVO getMemberById(String id, MultiValueMap<String, String> queryMap);
}
