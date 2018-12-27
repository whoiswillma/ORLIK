package com.orlik.ast;

public final class Type {

    private final String identifier;

    public Type(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Type type = (Type) o;

        return identifier.equals(type.identifier);
    }

    @Override
    public int hashCode() {
        return identifier.hashCode();
    }

}
