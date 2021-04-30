package com.platform3.demoproject.constants.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ClaimVO {

    private String id;

    private String claimId;

    private String claimStatus;

    private String subId;

    private String memId;

    private String memRel;

    private String admFromDate;

    private String admFromDateDtCompatible;

    private String admToDate;

    private String admToDateDtCompatible;

    private int days;

    private String provId;

    private String isLateFiled;

}
