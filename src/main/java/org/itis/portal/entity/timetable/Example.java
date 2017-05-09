
package org.itis.portal.entity.timetable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "properties",
    "sheets",
    "spreadsheetId",
    "spreadsheetUrl"
})
public class Example {

    @JsonProperty("properties")
    private Properties properties;
    @JsonProperty("sheets")
    private List<Sheet> sheets = null;
    @JsonProperty("spreadsheetId")
    private String spreadsheetId;
    @JsonProperty("spreadsheetUrl")
    private String spreadsheetUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("properties")
    public Properties getProperties() {
        return properties;
    }

    @JsonProperty("properties")
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @JsonProperty("sheets")
    public List<Sheet> getSheets() {
        return sheets;
    }

    @JsonProperty("sheets")
    public void setSheets(List<Sheet> sheets) {
        this.sheets = sheets;
    }

    @JsonProperty("spreadsheetId")
    public String getSpreadsheetId() {
        return spreadsheetId;
    }

    @JsonProperty("spreadsheetId")
    public void setSpreadsheetId(String spreadsheetId) {
        this.spreadsheetId = spreadsheetId;
    }

    @JsonProperty("spreadsheetUrl")
    public String getSpreadsheetUrl() {
        return spreadsheetUrl;
    }

    @JsonProperty("spreadsheetUrl")
    public void setSpreadsheetUrl(String spreadsheetUrl) {
        this.spreadsheetUrl = spreadsheetUrl;
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
