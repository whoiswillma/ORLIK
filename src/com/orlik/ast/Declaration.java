package com.orlik.ast;

/**
 * A node where the type information is determined mostly at runtime
 */
public interface Declaration extends Node {

    String getIdentifier();

}
