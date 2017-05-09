
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
    "autoRecalc",
    "defaultFormat",
    "locale",
    "timeZone",
    "title"
})
public class Properties {

    @JsonProperty("autoRecalc")
    private String autoRecalc;
    @JsonProperty("defaultFormat")
    private DefaultFormat defaultFormat;
    @JsonProperty("locale")
    private String locale;
    @JsonProperty("timeZone")
    private String timeZone;
    @JsonProperty("title")
    private String title;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("autoRecalc")
    public String getAutoRecalc() {
        return autoRecalc;
    }

    @JsonProperty("autoRecalc")
    public void setAutoRecalc(String autoRecalc) {
        this.autoRecalc = autoRecalc;
    }

    @JsonProperty("defaultFormat")
    public DefaultFormat getDefaultFormat() {
        return defaultFormat;
    }

    @JsonProperty("defaultFormat")
    public void setDefaultFormat(DefaultFormat defaultFormat) {
        this.defaultFormat = defaultFormat;
    }

    @JsonProperty("locale")
    public String getLocale() {
        return locale;
    }

    @JsonProperty("locale")
    public void setLocale(String locale) {
        this.locale = locale;
    }

    @JsonProperty("timeZone")
    public String getTimeZone() {
        return timeZone;
    }

    @JsonProperty("timeZone")
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
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
