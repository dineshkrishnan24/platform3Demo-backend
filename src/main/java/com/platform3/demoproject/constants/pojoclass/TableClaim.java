package com.platform3.demoproject.constants.pojoclass;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TableClaim {

    @JacksonXmlProperty(localName="CLAIM_ROW")
    List<Claim> ClaimRow;

}
