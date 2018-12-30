package com.orlik.ast;

import com.orlik.ast.visitor.Visitor;

import java.util.Collections;
import java.util.List;

public class VariableExpr implements Expr {

    private final String identifier;

    public VariableExpr(String identifier) {
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
