
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
    "bold",
    "fontFamily",
    "fontSize",
    "foregroundColor",
    "italic",
    "strikethrough",
    "underline"
})
public class TextFormat {

    @JsonProperty("bold")
    private Boolean bold;
    @JsonProperty("fontFamily")
    private String fontFamily;
    @JsonProperty("fontSize")
    private Integer fontSize;
    @JsonProperty("foregroundColor")
    private ForegroundColor foregroundColor;
    @JsonProperty("italic")
    private Boolean italic;
    @JsonProperty("strikethrough")
    private Boolean strikethrough;
    @JsonProperty("underline")
    private Boolean underline;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("bold")
    public Boolean getBold() {
        return bold;
    }

    @JsonProperty("bold")
    public void setBold(Boolean bold) {
        this.bold = bold;
    }

    @JsonProperty("fontFamily")
    public String getFontFamily() {
        return fontFamily;
    }

    @JsonProperty("fontFamily")
    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    @JsonProperty("fontSize")
    public Integer getFontSize() {
        return fontSize;
    }

    @JsonProperty("fontSize")
    public void setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
    }

    @JsonProperty("foregroundColor")
    public ForegroundColor getForegroundColor() {
        return foregroundColor;
    }

    @JsonProperty("foregroundColor")
    public void setForegroundColor(ForegroundColor foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    @JsonProperty("italic")
    public Boolean getItalic() {
        return italic;
    }

    @JsonProperty("italic")
    public void setItalic(Boolean italic) {
        this.italic = italic;
    }

    @JsonProperty("strikethrough")
    public Boolean getStrikethrough() {
        return strikethrough;
    }

    @JsonProperty("strikethrough")
    public void setStrikethrough(Boolean strikethrough) {
        this.strikethrough = strikethrough;
    }

    @JsonProperty("underline")
    public Boolean getUnderline() {
        return underline;
    }

    @JsonProperty("underline")
    public void setUnderline(Boolean underline) {
        this.underline = underline;
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
