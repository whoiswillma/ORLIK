package com.orlik.ast.integerexpr;

import com.orlik.ast.Node;
import com.orlik.ast.visitor.Visitor;

import java.util.Collections;
import java.util.List;

public final class IntegerLiteralExpr implements IntegerExpr {

    private final int value;

    public IntegerLiteralExpr(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
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
