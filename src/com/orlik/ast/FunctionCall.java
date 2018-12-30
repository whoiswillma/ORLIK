package com.orlik.ast;

import com.orlik.ast.visitor.Visitor;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class FunctionCall implements Expr {

    private final String identifier;
    private final List<Expr> parameterValues;

    public FunctionCall(String identifier, Collection<? extends Expr> parameterValues) {
        this.identifier = identifier;
        this.parameterValues = List.copyOf(parameterValues);
    }

    public String getIdentifier() {
        return identifier;
    }

    public List<Expr> getParameterValues() {
        return parameterValues;
    }

    @Override
    public List<Node> getChildren() {
        return Collections.unmodifiableList(parameterValues);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
