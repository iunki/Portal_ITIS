
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
    "left",
    "right"
})
public class Padding {

    @JsonProperty("left")
    private Integer left;
    @JsonProperty("right")
    private Integer right;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("left")
    public Integer getLeft() {
        return left;
    }

    @JsonProperty("left")
    public void setLeft(Integer left) {
        this.left = left;
    }

    @JsonProperty("right")
    public Integer getRight() {
        return right;
    }

    @JsonProperty("right")
    public void setRight(Integer right) {
        this.right = right;
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
