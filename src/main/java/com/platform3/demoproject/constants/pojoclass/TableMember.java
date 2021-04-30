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
@JacksonXmlRootElement(localName="TABLE_MEMBER")
public class TableMember {

    @JacksonXmlProperty(localName="MEMBER_ROW")
    private Member memberRow;

}
