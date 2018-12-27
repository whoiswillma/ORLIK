package com.orlik.ast.integerexpr;

import com.orlik.ast.Node;
import com.orlik.ast.visitor.Visitor;

import java.util.List;

/**
 * An expression representing an unary operator on an integer expression
 */
public final class IntegerFactor implements IntegerExpr {

    public enum Kind {

        NEGATION

    }

    private final Kind kind;
    private final IntegerExpr child;

    public IntegerFactor(Kind kind, IntegerExpr child) {
        this.kind = kind;
        this.child = child;
    }

    public Kind getKind() {
        return kind;
    }

    public IntegerExpr getChild() {
        return child;
    }

    @Override
    public List<Node> getChildren() {
        return List.of(child);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
