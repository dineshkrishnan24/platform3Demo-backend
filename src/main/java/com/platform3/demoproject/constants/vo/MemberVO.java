package com.platform3.demoproject.constants.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MemberVO {

    private String id;

    private String memId;

    private String subId;

    private String memFirstName;

    private String memSecondName;

    private String memRel;

    private String memSex;

    private String memDob;

    private String memDobCompatible;

    private String familyLinkId;

    private String addrId;

    private String isSub;

    private String primaryAddrType;

    private String secondaryAddrType;

}
