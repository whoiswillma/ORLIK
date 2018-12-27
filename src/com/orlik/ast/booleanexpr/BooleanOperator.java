package com.orlik.ast.booleanexpr;

import com.orlik.ast.Node;
import com.orlik.ast.visitor.Visitor;

import java.util.List;

/**
 * An operation on two boolean expressions
 */
public final class BooleanOperator implements BooleanExpr {

    public enum Kind {

        AND, OR, NOT_EQUALS, EQUALS

    }

    private final BooleanExpr left, right;
    private final Kind kind;

    public BooleanOperator(BooleanExpr left, Kind kind, BooleanExpr right) {
        this.left = left;
        this.kind = kind;
        this.right = right;
    }

    public BooleanExpr getLeft() {
        return left;
    }

    public BooleanExpr getRight() {
        return right;
    }

    public Kind getKind() {
        return kind;
    }

    @Override
    public List<Node> getChildren() {
        return List.of(left, right);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
