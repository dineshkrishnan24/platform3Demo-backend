package com.platform3.demoproject.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
public class Claim {

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
