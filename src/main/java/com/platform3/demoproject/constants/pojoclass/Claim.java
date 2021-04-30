package com.platform3.demoproject.constants.pojoclass;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JacksonXmlRootElement(localName="CLAIM_ROW")
public class Claim {

    @JacksonXmlProperty(localName="CLAIM_ID")
    private String claimId;

    @JacksonXmlProperty(localName="CLAIM_STATUS")
    private String claimStatus;

    @JacksonXmlProperty(localName="SUB_ID")
    private String subId;

    @JacksonXmlProperty(localName="MEM_ID")
    private String memId;

    @JacksonXmlProperty(localName="MEM_REL")
    private String memRel;

    @JacksonXmlProperty(localName="ADM_FROM_DATE")
    private String admFromDate;

    @JacksonXmlProperty(localName="ADM_FROM_DATE_DT_COMPATIBLE")
    private String admFromDateDtCompatible;

    @JacksonXmlProperty(localName="ADM_TO_DATE")
    private String admToDate;

    @JacksonXmlProperty(localName="ADM_TO_DATE_DT_COMPATIBLE")
    private String admToDateDtCompatible;

    @JacksonXmlProperty(localName="DAYS")
    private int days;

    @JacksonXmlProperty(localName="PROV_ID")
    private String provId;

    @JacksonXmlProperty(localName="IS_LATE_FILED")
    private String isLateFiled;

    @JacksonXmlProperty(localName="TABLE_MEMBER")
    private TableMember tableMember;

}
