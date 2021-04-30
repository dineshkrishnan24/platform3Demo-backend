package com.platform3.demoproject.constants.pojoclass;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JacksonXmlRootElement(localName="MEMBER_ROW")
public class Member {

    @JacksonXmlProperty(localName="MEM_ID")
    private String memId;

    @JacksonXmlProperty(localName="SUB_ID")
    private String subId;

    @JacksonXmlProperty(localName="MEM_FIRST_NAME")
    private String memFirstName;

    @JacksonXmlProperty(localName="MEM_LAST_NAME")
    private String memSecondName;

    @JacksonXmlProperty(localName="MEM_REL")
    private String memRel;

    @JacksonXmlProperty(localName="MEM_SEX")
    private String memSex;

    @JacksonXmlProperty(localName="MEM_DOB")
    private String memDob;

    @JacksonXmlProperty(localName="MEM_DOB_DT_COMPATIBLE")
    private String memDobCompatible;

    @JacksonXmlProperty(localName="FAMILY_LINK_ID")
    private String familyLinkId;

    @JacksonXmlProperty(localName="ADDR_ID")
    private String addrId;

    @JacksonXmlProperty(localName="IS_SUB")
    private String isSub;

    @JacksonXmlProperty(localName="PRIMARY_ADDR_TYPE")
    private String primaryAddrType;

    @JacksonXmlProperty(localName="SECONDARY_ADDR_TYPE")
    private String secondaryAddrType;

}
