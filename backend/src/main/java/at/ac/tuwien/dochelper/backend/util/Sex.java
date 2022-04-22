package at.ac.tuwien.dochelper.backend.util;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Sex {
    @JsonProperty("FEMALE")
    FEMALE("female"),
    @JsonProperty("MALE")
    MALE("male"),
    OTHER("other");

    private final String sex_value;

    private Sex(String sex_value) {
        this.sex_value = sex_value;
    }

    @JsonValue
    public String getSex_value() {
        return sex_value;
    }
}
