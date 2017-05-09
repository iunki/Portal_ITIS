
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
    "merges",
    "properties"
})
public class Sheet {

    @JsonProperty("merges")
    private List<Merge> merges = null;
    @JsonProperty("properties")
    private Properties_ properties;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("merges")
    public List<Merge> getMerges() {
        return merges;
    }

    @JsonProperty("merges")
    public void setMerges(List<Merge> merges) {
        this.merges = merges;
    }

    @JsonProperty("properties")
    public Properties_ getProperties() {
        return properties;
    }

    @JsonProperty("properties")
    public void setProperties(Properties_ properties) {
        this.properties = properties;
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
