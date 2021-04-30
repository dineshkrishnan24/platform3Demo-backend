package com.platform3.demoproject.controller;

import com.platform3.demoproject.constants.vo.ClaimVO;
import com.platform3.demoproject.constants.vo.MemberVO;
import com.platform3.demoproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("/v1/purchase/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping
    private ResponseEntity<List<MemberVO>> getAllMembers(@RequestParam MultiValueMap<String, String> queryMap) {
        List<MemberVO> memberVOList = memberService.getAllMembers(queryMap);
        return ResponseEntity.ok(memberVOList);
    }

    @GetMapping("/{id}")
    private ResponseEntity<MemberVO> getMemberById(@PathVariable("id") String id, @RequestParam MultiValueMap<String, String> queryMap) {
        MemberVO memberVO = memberService.getMemberById(id, queryMap);
        if(Objects.isNull(memberVO)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(memberVO);
    }

    @PutMapping("/{id}")
    private ResponseEntity<MemberVO> updateMember(@PathVariable("id") String id, @RequestBody MemberVO memberVO){
        MemberVO memberVO1 = memberService.updateByMemberId(id, memberVO);
        if(Objects.isNull(memberVO)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(memberVO1);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity deleteMember(@PathVariable("id") String id) {
        String resp = memberService.deleteByMemberId(id);
        if(Objects.isNull(resp)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


}
