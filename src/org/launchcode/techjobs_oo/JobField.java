package org.launchcode.techjobs_oo;

import lombok.Getter;
import lombok.Setter;

public abstract class JobField {

    private @Getter int id;
    private static int nextId = 1;
    private @Getter @Setter String value;

    public JobField() {
        id = nextId;
        nextId++;
    }

    public JobField(String value) {
        this();
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
