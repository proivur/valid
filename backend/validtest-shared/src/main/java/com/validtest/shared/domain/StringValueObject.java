package com.validtest.shared.domain;

import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class StringValueObject {

    private String value;

    public StringValueObject(String value) {
        this.value = value;
    }

    public StringValueObject() {
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return this.value();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StringValueObject)) {
            return false;
        }
        StringValueObject that = (StringValueObject) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    protected static void validateTextLength(String value, String message, int minLength, int maxLength) {
        try {
            ensureTextLength(value, minLength, maxLength);
        } catch (RuntimeException ex) {
            throw new IllegalArgumentException(String.format(message, value), ex);
        }
    }

    private static void ensureTextLength(String value, int minLength, int maxLength) throws IllegalArgumentException {
        if ((value != null) && !(value.length() >= minLength && value.length() <= maxLength)) {
            new IllegalArgumentException("Wrong expected text length: " + maxLength + ", provided text length: " + value.length());
        }
    }

    protected static void ensureNotEmpty(Class refClass, String value) throws IllegalArgumentException {
        if (value != null && !value.isEmpty()) {
            return;
        }

        String message = "The parameter " + refClass.getSimpleName() + " with value <%s> is invalid";
        throw new IllegalArgumentException(String.format(message, value));
    }

    protected static void validateTextValue(String value, String message, Set<String> refSet) {
        try {
            ensureTextAgainstSet(value, refSet);
        } catch (RuntimeException ex) {
            throw new IllegalArgumentException(String.format(message, value), ex);
        }
    }

    private static void ensureTextAgainstSet(String value, Set<String> refSet) throws IllegalArgumentException {
        if ((value != null) && !(refSet != null) && (refSet.contains(value))) {
            new IllegalArgumentException("Wrong value: " + value + ", expected values are: " + refSet.toArray());
        }
    }

    protected static void validateEmailAddress(String value, String message) {
        Pattern pattern = Pattern.compile(RegexUtils.VALID_EMAIL_REGEX);
        Matcher matcher = pattern.matcher(value);

        if (matcher.matches()) {
            return;
        }

        throw new IllegalArgumentException(String.format(message, value));
    }

}
