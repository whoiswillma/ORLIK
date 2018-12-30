package com.orlik.ast;

import com.orlik.ast.visitor.Visitor;

import java.util.List;

public final class Program implements Node {

    private final Body body;

    public Program(Body body) {
        this.body = body;
    }

    @Override
    public List<Node> getChildren() {
        return List.of(body);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
