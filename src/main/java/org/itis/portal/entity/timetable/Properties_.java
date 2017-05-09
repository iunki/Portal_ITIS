
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
    "gridProperties",
    "index",
    "sheetId",
    "sheetType",
    "title",
    "hidden"
})
public class Properties_ {

    @JsonProperty("gridProperties")
    private GridProperties gridProperties;
    @JsonProperty("index")
    private Integer index;
    @JsonProperty("sheetId")
    private Integer sheetId;
    @JsonProperty("sheetType")
    private String sheetType;
    @JsonProperty("title")
    private String title;
    @JsonProperty("hidden")
    private Boolean hidden;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("gridProperties")
    public GridProperties getGridProperties() {
        return gridProperties;
    }

    @JsonProperty("gridProperties")
    public void setGridProperties(GridProperties gridProperties) {
        this.gridProperties = gridProperties;
    }

    @JsonProperty("index")
    public Integer getIndex() {
        return index;
    }

    @JsonProperty("index")
    public void setIndex(Integer index) {
        this.index = index;
    }

    @JsonProperty("sheetId")
    public Integer getSheetId() {
        return sheetId;
    }

    @JsonProperty("sheetId")
    public void setSheetId(Integer sheetId) {
        this.sheetId = sheetId;
    }

    @JsonProperty("sheetType")
    public String getSheetType() {
        return sheetType;
    }

    @JsonProperty("sheetType")
    public void setSheetType(String sheetType) {
        this.sheetType = sheetType;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("hidden")
    public Boolean getHidden() {
        return hidden;
    }

    @JsonProperty("hidden")
    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
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
