package com.platform3.demoproject.utils;

import com.platform3.demoproject.constants.pojoclass.Claim;
import com.platform3.demoproject.constants.pojoclass.Member;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanUtils {

    @Bean
    @Scope("prototype")
    ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        modelMapper.createTypeMap(Claim.class, com.platform3.demoproject.models.Claim.class);
        modelMapper.createTypeMap(Member.class, com.platform3.demoproject.models.Member.class);
        return modelMapper;
    }

}
