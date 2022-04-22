package at.ac.tuwien.dochelper.backend.util;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Sex {
    FEMALE("female"),
    MALE("male"),
    OTHER("other");

    private final String sex_value;

    private Sex(String sex_value) {
        this.sex_value = sex_value;
    }
}
