package com.mentormate.devcamp.tasks;

import java.util.HashMap;
import java.util.Map;

/**
 * The enum Operation
 * <p>
 * This enum contains the code for the arithmetic operation 'addition' and 'subtraction'.
 */
public enum Operation {
    ADDITION(1),
    SUBTRACTION(2),
    DIVISION(3);
    private final int code;
    private static final Map<Integer, Operation> BY_OPERATION = new HashMap<>();

    static {
        for (Operation e : values()) {
            BY_OPERATION.put(e.code, e);
        }
    }

    Operation(int code) {
        this.code = code;
    }

    /**
     * Operation from code operation.
     *
     * @param code the code of the arithmetic operation
     * @return the operation
     */
    public static Operation operationFromCode(Integer code) {
        if (BY_OPERATION.get(code)==null) {
            throw new UnsupportedOperationException(String.format("Operation with code %d does not exist!", code));
        }
        return BY_OPERATION.get(code);
    }
}
