
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
    "columnCount",
    "frozenColumnCount",
    "frozenRowCount",
    "rowCount"
})
public class GridProperties {

    @JsonProperty("columnCount")
    private Integer columnCount;
    @JsonProperty("frozenColumnCount")
    private Integer frozenColumnCount;
    @JsonProperty("frozenRowCount")
    private Integer frozenRowCount;
    @JsonProperty("rowCount")
    private Integer rowCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("columnCount")
    public Integer getColumnCount() {
        return columnCount;
    }

    @JsonProperty("columnCount")
    public void setColumnCount(Integer columnCount) {
        this.columnCount = columnCount;
    }

    @JsonProperty("frozenColumnCount")
    public Integer getFrozenColumnCount() {
        return frozenColumnCount;
    }

    @JsonProperty("frozenColumnCount")
    public void setFrozenColumnCount(Integer frozenColumnCount) {
        this.frozenColumnCount = frozenColumnCount;
    }

    @JsonProperty("frozenRowCount")
    public Integer getFrozenRowCount() {
        return frozenRowCount;
    }

    @JsonProperty("frozenRowCount")
    public void setFrozenRowCount(Integer frozenRowCount) {
        this.frozenRowCount = frozenRowCount;
    }

    @JsonProperty("rowCount")
    public Integer getRowCount() {
        return rowCount;
    }

    @JsonProperty("rowCount")
    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
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
