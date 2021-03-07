package com.validtest.shared.domain;

import java.util.Date;

public class DomainUtils {
    
    private DomainUtils() {
    }

    public static String getValue(StringValueObject instance) {
        if (instance == null) {
            return null;
        }

        return instance.value();
    }

    public static Date getValue(DateValueObject instance) {
        if (instance == null) {
            return null;
        }

        return instance.value();
    }

}
