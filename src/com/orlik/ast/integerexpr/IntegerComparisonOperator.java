package com.orlik.ast.integerexpr;

import com.orlik.ast.Node;
import com.orlik.ast.booleanexpr.BooleanExpr;
import com.orlik.ast.visitor.Visitor;

import java.util.List;

/**
 * A boolean comparision between two integer expressions
 */
public final class IntegerComparisonOperator implements BooleanExpr {

    public enum Kind {

        LT, LT_OR_EQUALS, EQUALS, GT_OR_EQUALS, GT

    }

    private final IntegerExpr left, right;
    private final Kind kind;

    public IntegerComparisonOperator(IntegerExpr left, Kind kind, IntegerExpr right) {
        this.left = left;
        this.kind = kind;
        this.right = right;
    }

    public IntegerExpr getLeft() {
        return left;
    }

    public IntegerExpr getRight() {
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
