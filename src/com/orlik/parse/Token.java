package com.orlik.parse;

class Token {

    enum Group {

        // something with an identifier, not necessarily directly after
        DEFINITION,

        // if statement, while loop
        STATEMENT,

        // tokens about the code itself, such as end of file, etc.
        META,

        // grouping characters, end of line characters, etc.
        PUNCTUATION,

        // an identifier
        IDENTIFIER

    }

    enum Kind {

        FUNCTION_DEFINITION(Group.DEFINITION),
        VARIABLE_DEFINITION(Group.DEFINITION),

        IF_STATEMENT(Group.STATEMENT),
        WHILE_STATEMENT(Group.STATEMENT),

        END_OF_FILE(Group.META),
        INVALID(Group.META),

        LEFT_PAREN(Group.PUNCTUATION),
        RIGHT_PAREN(Group.PUNCTUATION),
        LEFT_BRACE(Group.PUNCTUATION),
        RIGHT_BRACE(Group.PUNCTUATION),
        SEMICOLON(Group.PUNCTUATION),
        COLON(Group.PUNCTUATION),

        // always has associated type of string
        IDENTIFIER(Group.IDENTIFIER);

        private final Group group;

        Kind(Group group) {
            this.group = group;
        }

        public Group getGroup() {
            return group;
        }

    }

    private final Kind kind;

    Token(Kind kind) {
        this.kind = kind;
    }

     Kind getKind() {
        return kind;
    }

    static class Identifier extends Token {

        String value;

        Identifier(String value) {
            super(Kind.IDENTIFIER);

            this.value = value;
        }

        String getValue() {
            return value;
        }

    }

}
