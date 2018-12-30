package com.orlik.ast;

import com.orlik.ast.visitor.Visitor;

import java.util.List;

public interface Node {

    /**
     * @return An unmodifiable list of nodes representing the children of this node
     */
    List<Node> getChildren();

    /**
     * @param visitor the visitor to accept
     */
    void accept(Visitor visitor);

}
