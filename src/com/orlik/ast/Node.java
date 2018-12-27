package com.orlik.ast;

import com.orlik.ast.visitor.Visitor;

import java.util.List;

public interface Node {

    /**
     * @return An unmodifiable list of nodes representing the children of this node
     */
    public abstract List<Node> getChildren();

    /**
     * @param visitor the visitor to accept
     */
    public abstract void accept(Visitor visitor);

}
