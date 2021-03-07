package com.validtest.shared.domain;

public enum RecordStatusName {

    ACTIVE("A"),
    DISABLED("D"),
    RETIRED("R");

    private String label;

    RecordStatusName(String label) {
        this.label = label;
    }

    public static RecordStatusName getFrom(String value) {
        if (value == null) {
            return null;
        }

        for (RecordStatusName enu : RecordStatusName.values()) {
            if (value.equals(enu.label)) {
                return enu;
            }
        }

        return null;
    }

}
