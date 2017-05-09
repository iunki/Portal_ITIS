
package org.itis.portal.entity.timetable;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "endColumnIndex",
    "endRowIndex",
    "sheetId",
    "startColumnIndex",
    "startRowIndex"
})
public class Merge {

    @JsonProperty("endColumnIndex")
    private Integer endColumnIndex;
    @JsonProperty("endRowIndex")
    private Integer endRowIndex;
    @JsonProperty("sheetId")
    private Integer sheetId;
    @JsonProperty("startColumnIndex")
    private Integer startColumnIndex;
    @JsonProperty("startRowIndex")
    private Integer startRowIndex;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("endColumnIndex")
    public Integer getEndColumnIndex() {
        return endColumnIndex;
    }

    @JsonProperty("endColumnIndex")
    public void setEndColumnIndex(Integer endColumnIndex) {
        this.endColumnIndex = endColumnIndex;
    }

    @JsonProperty("endRowIndex")
    public Integer getEndRowIndex() {
        return endRowIndex;
    }

    @JsonProperty("endRowIndex")
    public void setEndRowIndex(Integer endRowIndex) {
        this.endRowIndex = endRowIndex;
    }

    @JsonProperty("sheetId")
    public Integer getSheetId() {
        return sheetId;
    }

    @JsonProperty("sheetId")
    public void setSheetId(Integer sheetId) {
        this.sheetId = sheetId;
    }

    @JsonProperty("startColumnIndex")
    public Integer getStartColumnIndex() {
        return startColumnIndex;
    }

    @JsonProperty("startColumnIndex")
    public void setStartColumnIndex(Integer startColumnIndex) {
        this.startColumnIndex = startColumnIndex;
    }

    @JsonProperty("startRowIndex")
    public Integer getStartRowIndex() {
        return startRowIndex;
    }

    @JsonProperty("startRowIndex")
    public void setStartRowIndex(Integer startRowIndex) {
        this.startRowIndex = startRowIndex;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
