package com.orlik.ast;

public final class Parameter {

    private final Type type;
    private final String identifier;

    public Parameter(Type type, String identifier) {
        this.type = type;
        this.identifier = identifier;
    }

    public Type getType() {
        return type;
    }

    public String getIdentifier() {
        return identifier;
    }

}