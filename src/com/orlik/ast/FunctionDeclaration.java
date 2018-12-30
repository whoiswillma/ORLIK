package com.orlik.ast;

import com.orlik.ast.visitor.Visitor;

import java.util.List;

public final class FunctionDeclaration implements Declaration {

    private final String identifier;
    private final List<Parameter> parameters;
    private final Body body;
    private final Type returnType;

    public FunctionDeclaration(String identifier, List<Parameter> parameters, Body body, Type returnType) {
        this.identifier = identifier;
        this.parameters = List.copyOf(parameters);
        this.body = body;
        this.returnType = returnType;
    }

    public String getIdentifier() {
        return identifier;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public Body getBody() {
        return body;
    }

    public Type getReturnType() {
        return returnType;
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
