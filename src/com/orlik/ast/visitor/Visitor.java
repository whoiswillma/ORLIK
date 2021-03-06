package com.orlik.ast.visitor;

import com.orlik.ast.*;
import com.orlik.ast.booleanexpr.BooleanLiteralExpr;
import com.orlik.ast.booleanexpr.BooleanOperator;
import com.orlik.ast.integerexpr.ArithmeticOperator;
import com.orlik.ast.booleanexpr.IntegerComparisonOperator;
import com.orlik.ast.integerexpr.IntegerFactor;
import com.orlik.ast.integerexpr.IntegerLiteralExpr;

public interface Visitor {

    void visit(ArithmeticOperator node);

    void visit(BooleanLiteralExpr node);

    void visit(BooleanOperator node);

    void visit(IfStatement node);

    void visit(IntegerComparisonOperator node);

    void visit(IntegerFactor node);

    void visit(IntegerLiteralExpr node);

    void visit(Body node);

    void visit(FunctionDeclaration node);

    void visit(WhileStatement node);

    void visit(VariableDeclaration node);

    void visit(Program node);

    void visit(FunctionCall node);

    void visit(VariableExpr node);

}
