package com.platform3.demoproject.service.impl;

import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.platform3.demoproject.constants.pojoclass.Claim;
import com.platform3.demoproject.models.Member;
import com.platform3.demoproject.repository.ClaimRepository;
import com.platform3.demoproject.repository.MemberRepository;
import com.platform3.demoproject.service.FileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ClaimRepository claimRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public String uploadFile(MultipartFile multipartFile) throws Exception {
        if(!multipartFile.getOriginalFilename().contains(".xml")) {
            return "badRequest";
        }
        JacksonXmlModule module = new JacksonXmlModule();
        module.setDefaultUseWrapper(false);
        XmlMapper xmlMapper = new XmlMapper(module);
        String xmlStr = inputStreamToString(multipartFile.getInputStream());
        CollectionType listType = xmlMapper.getTypeFactory().constructCollectionType(List.class,
                Claim.class);
        List<com.platform3.demoproject.constants.pojoclass.Claim> claims = xmlMapper.readValue(xmlStr, listType);
        claims.forEach(eachClaimRow->{
            claimRepository.save(mapper.map(eachClaimRow, com.platform3.demoproject.models.Claim.class));
            memberRepository.save(mapper.map(eachClaimRow.getTableMember().getMemberRow(), Member.class));
        });
        return "accepted";
    }

    public String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }

}
