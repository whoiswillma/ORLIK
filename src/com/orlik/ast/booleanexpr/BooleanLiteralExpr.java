package com.orlik.ast.booleanexpr;

import com.orlik.ast.Node;
import com.orlik.ast.visitor.Visitor;

import java.util.List;

public final class BooleanLiteralExpr implements BooleanExpr {

    private final boolean value;

    public BooleanLiteralExpr(boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }

    @Override
    public List<Node> getChildren() {
        return List.of();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
