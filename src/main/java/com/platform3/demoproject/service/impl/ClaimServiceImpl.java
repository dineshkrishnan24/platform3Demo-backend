package com.platform3.demoproject.service.impl;

import com.platform3.demoproject.constants.vo.ClaimVO;
import com.platform3.demoproject.models.Claim;
import com.platform3.demoproject.repository.ClaimRepository;
import com.platform3.demoproject.service.ClaimService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ClaimServiceImpl implements ClaimService {

    @Autowired
    private ClaimRepository claimRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ClaimVO> getAllClaims(MultiValueMap<String, String> queryParam) {
        List<Claim> claims = claimRepository.findAll();
        List<ClaimVO> claimVOS = new ArrayList<>();
        claims.forEach(eachClaim-> {
            ClaimVO claimVO = modelMapper.map(eachClaim,ClaimVO.class);
            claimVOS.add(claimVO);
        });
        return claimVOS;
    }

    @Override
    public ClaimVO getClaimById(String id, MultiValueMap<String, String> queryMap) {
        Claim claim = claimRepository.findById(id).orElse(null);
        if(Objects.isNull(claim)) {
            return null;
        }
        ClaimVO claimVO = modelMapper.map(claim,ClaimVO.class);
        return claimVO;
    }

    @Override
    public ClaimVO updateByClaimId(String id, ClaimVO claimVO) {
        Claim claim = claimRepository.findById(id).orElse(null);
        if(Objects.isNull(claim)) {
            return null;
        }
        Claim updatedClaim = modelMapper.map(claimVO, Claim.class);
        updatedClaim.setId(claim.getId());
        updatedClaim = claimRepository.save(updatedClaim);
        claimVO = modelMapper.map(updatedClaim,ClaimVO.class);
        return claimVO;
    }

    @Override
    public String deleteByClaimId(String id) {
        Claim claim = claimRepository.findById(id).orElse(null);
        if(Objects.isNull(claim)) {
            return null;
        }
        claimRepository.deleteById(id);
        return "success";
    }


}
