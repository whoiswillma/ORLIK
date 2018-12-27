package com.orlik.ast;

import com.orlik.ast.booleanexpr.BooleanExpr;
import com.orlik.ast.visitor.Visitor;

import java.util.List;

public final class WhileStatement implements Statement {

    private final BooleanExpr conditional;
    private final Body body;

    public WhileStatement(BooleanExpr conditional, Body body) {
        this.conditional = conditional;
        this.body = body;
    }

    public BooleanExpr getConditional() {
        return conditional;
    }

    public Body getBody() {
        return body;
    }

    @Override
    public List<Node> getChildren() {
        return List.of(conditional, body);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
