package com.platform3.demoproject.service;

import com.platform3.demoproject.constants.vo.ClaimVO;
import org.springframework.util.MultiValueMap;

import java.util.List;

public interface ClaimService {

    public List<ClaimVO> getAllClaims(MultiValueMap<String, String> queryParam);

    public ClaimVO updateByClaimId(String id, ClaimVO claimVO);

    public String deleteByClaimId(String id);

    ClaimVO getClaimById(String id, MultiValueMap<String, String> queryMap);
}
