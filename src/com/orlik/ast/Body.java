package com.orlik.ast;

import com.orlik.ast.visitor.Visitor;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class Body implements Statement {

    private final List<Statement> statements;

    public Body(Collection<? extends Statement> statements) {
        this.statements = List.copyOf(statements);
    }

    public List<Statement> getStatements() {
        return statements;
    }

    @Override
    public List<Node> getChildren() {
        return Collections.unmodifiableList(statements);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
