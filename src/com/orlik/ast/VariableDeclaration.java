package com.orlik.ast;

import com.orlik.ast.visitor.Visitor;

import java.util.Collections;
import java.util.List;

public final class VariableDeclaration implements Declaration {

    private final String identifier;
    private final Type type;

    public VariableDeclaration(String identifier, Type type) {
        this.identifier = identifier;
        this.type = type;
    }

    public String getIdentifier() {
        return identifier;
    }

    public Type getType() {
        return type;
    }

    @Override
    public List<Node> getChildren() {
        return Collections.emptyList();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
