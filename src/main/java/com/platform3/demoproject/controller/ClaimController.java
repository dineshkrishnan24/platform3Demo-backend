package com.platform3.demoproject.controller;

import com.platform3.demoproject.constants.vo.ClaimVO;
import com.platform3.demoproject.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("/v1/purchase/claims")
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    @GetMapping
    private ResponseEntity<List<ClaimVO>> getAllClaims(@RequestParam MultiValueMap<String, String> queryMap) {
        List<ClaimVO> allClaims = claimService.getAllClaims(queryMap);
        return ResponseEntity.ok(allClaims);
    }

    @GetMapping("/{id}")
    private ResponseEntity<ClaimVO> getClaimById(@PathVariable("id") String id, @RequestParam MultiValueMap<String, String> queryMap) {
        ClaimVO claimVO = claimService.getClaimById(id, queryMap);
        if(Objects.isNull(claimVO)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(claimVO);
    }

    @PutMapping("/{id}")
    private ResponseEntity<ClaimVO> updateClaim(@PathVariable("id") String id, @RequestBody ClaimVO claimVO){
        ClaimVO claimVO1 = claimService.updateByClaimId(id, claimVO);
        if(Objects.isNull(claimVO1)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(claimVO1);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity deleteClaim(@PathVariable("id") String id) {
        String resp = claimService.deleteByClaimId(id);
        if(Objects.isNull(resp)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
