package com.orlik.ast.integerexpr;

import com.orlik.ast.Node;
import com.orlik.ast.integerexpr.IntegerExpr;
import com.orlik.ast.visitor.Visitor;

import java.util.List;

/**
 * An expression representing a binary arithmetic operation: addition, multiplication, etc.
 */
public final class ArithmeticOperator implements IntegerExpr {

    public enum Kind {

        ADD, SUBTRACT, MULTIPLY, DIVIDE, MOD;

    }

    private final IntegerExpr left, right;
    private final Kind kind;

    public ArithmeticOperator(IntegerExpr left, Kind kind, IntegerExpr right) {
        this.left = left;
        this.kind = kind;
        this.right = right;
    }

    public IntegerExpr getLeft() {
        return left;
    }

    public Kind getKind() {
        return kind;
    }

    public IntegerExpr getRight() {
        return right;
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
