package com.orlik.ast;

import com.orlik.ast.visitor.Visitor;

import java.util.Collections;
import java.util.List;

public final class Variable implements Declaration {

    private final String identifier;

    public Variable(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
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
