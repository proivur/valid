package com.validtest.shared.domain;

import java.util.Date;
import java.util.Objects;

public abstract class DateValueObject {

    protected Date value;

    public DateValueObject(Date value) {
        this.value = value;
    }

    protected DateValueObject() {
    }

    public Date value() {
        return value;
    }

    @Override
    public String toString() {
        return this.value != null ? DateUtils.defaultFormatDate(this.value) : null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof DateValueObject)) {
            return false;
        }

        DateValueObject that = (DateValueObject) o;

        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
