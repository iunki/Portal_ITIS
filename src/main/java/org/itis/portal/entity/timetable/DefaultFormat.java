
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
    "backgroundColor",
    "padding",
    "textFormat",
    "verticalAlignment",
    "wrapStrategy"
})
public class DefaultFormat {

    @JsonProperty("backgroundColor")
    private BackgroundColor backgroundColor;
    @JsonProperty("padding")
    private Padding padding;
    @JsonProperty("textFormat")
    private TextFormat textFormat;
    @JsonProperty("verticalAlignment")
    private String verticalAlignment;
    @JsonProperty("wrapStrategy")
    private String wrapStrategy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("backgroundColor")
    public BackgroundColor getBackgroundColor() {
        return backgroundColor;
    }

    @JsonProperty("backgroundColor")
    public void setBackgroundColor(BackgroundColor backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @JsonProperty("padding")
    public Padding getPadding() {
        return padding;
    }

    @JsonProperty("padding")
    public void setPadding(Padding padding) {
        this.padding = padding;
    }

    @JsonProperty("textFormat")
    public TextFormat getTextFormat() {
        return textFormat;
    }

    @JsonProperty("textFormat")
    public void setTextFormat(TextFormat textFormat) {
        this.textFormat = textFormat;
    }

    @JsonProperty("verticalAlignment")
    public String getVerticalAlignment() {
        return verticalAlignment;
    }

    @JsonProperty("verticalAlignment")
    public void setVerticalAlignment(String verticalAlignment) {
        this.verticalAlignment = verticalAlignment;
    }

    @JsonProperty("wrapStrategy")
    public String getWrapStrategy() {
        return wrapStrategy;
    }

    @JsonProperty("wrapStrategy")
    public void setWrapStrategy(String wrapStrategy) {
        this.wrapStrategy = wrapStrategy;
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
