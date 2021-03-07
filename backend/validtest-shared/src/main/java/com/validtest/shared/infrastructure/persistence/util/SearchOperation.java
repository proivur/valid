package com.validtest.shared.infrastructure.persistence.util;

public enum SearchOperation {
    EQUALITY, NEGATION, GREATER_THAN, LESS_THAN, LIKE, STARTS_WITH, ENDS_WITH, CONTAINS, NOT_IN, IN;

    public static final String[] SIMPLE_OPERATION_SET = { ":", "!", ">", "<", "~", "-" };

    public static final String[] BASIC_OPERATION_SET = { ":", "!", ">", "<", "~" };
    
    public static final String VALID_EMAIL_REGEX = "[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+";

    public static final String VALID_UUID = "[a-f0-9]{8}-[a-f0-9]{4}-4[a-f0-9]{3}-[89aAbB][a-f0-9]{3}-[a-f0-9]{12}";

    public static final String OR_PREDICATE_FLAG = "'";

    public static final String ZERO_OR_MORE_REGEX = "*";

    public static final String OR_OPERATOR = "OR";

    public static final String AND_OPERATOR = "AND";

    public static final String LEFT_PARANTHESIS = "(";

    public static final String RIGHT_PARANTHESIS = ")";

    public static SearchOperation getSimpleOperation(final char input) {
        switch (input) {
        case ':':
            return EQUALITY;
        case '!':
            return NEGATION;
        case '>':
            return GREATER_THAN;
        case '<':
            return LESS_THAN;
        case '~':
            return LIKE;
        case '-':
            return NOT_IN;
        case '#':
            return IN;
        default:
            return null;
        }
    }
}
