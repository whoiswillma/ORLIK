package com.orlik.parse;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.Reader;

public class Tokenizer {

    private final PushbackReader reader;

    private Token previousToken, currentToken;

    public Tokenizer(Reader reader) {
        // support keywords up to 64 characters long
        this.reader = new PushbackReader(reader, 64);
    }

    private Token peek() throws IOException {
        if (currentToken == null) {
            currentToken = consumeNextToken();
        }

        return currentToken;
    }

    private Token pop() throws IOException {
        previousToken = currentToken;
        currentToken = consumeNextToken();
        return previousToken;
    }

    /**
     * Determines and appends the next token, consuming characters as needed from the reader
     */
    private Token consumeNextToken() throws IOException {
        if (!advanceWhitespace()) {
            return new Token(Token.Kind.END_OF_FILE);
        }

        if (previousToken != null && previousToken.getKind() == Token.Kind.COLON) {
            return consumeIdentifier();
        }

        char ch = (char) reader.read();
        switch (ch) {
            case '(':
                return new Token(Token.Kind.LEFT_PAREN);
            case ')':
                return new Token(Token.Kind.RIGHT_PAREN);
            case '{':
                return new Token(Token.Kind.LEFT_BRACE);
            case '}':
                return new Token(Token.Kind.RIGHT_BRACE);
            case ';':
                return new Token(Token.Kind.SEMICOLON);
            case ':':
                return new Token(Token.Kind.COLON);

            case 'g':
                reader.unread('g');
                return consumeKeywordToken("givemeanew", Token.Kind.VARIABLE_DEFINITION);
            case 'd':
                reader.unread('d');
                return consumeKeywordToken("do", Token.Kind.FUNCTION_DEFINITION);
            case 'a':
                reader.unread('a');
                return consumeKeywordToken("anybodywantsome", Token.Kind.IF_STATEMENT);
            case 'b':
                reader.unread('b');
                return consumeKeywordToken("bigo", Token.Kind.WHILE_STATEMENT);
        }

        return new Token(Token.Kind.INVALID);
    }

    /**
     * Advances past any whitespace, so the next call of {@code reader.read()} will return a non-whitespace character
     *
     * @return false iff the end of the file was reached
     * @throws IOException
     */
    private boolean advanceWhitespace() throws IOException {
        char ch;
        do {
            int value = reader.read();
            if (value == -1) {
                return false;
            }

            ch = (char) value;
        } while (Character.isWhitespace(ch));

        reader.unread(ch);
        return true;
    }

    /**
     * Consumes characters that would match an identifier.
     * <p>
     * This method returns a token of kind invalid if
     * <ul>
     * <li>any characters starting from the next character in the reader are not valid identifier characters</li>
     * </ul>
     * </p>
     *
     * @return an identifier token if an identifier could be read successfully, an invalid token otherwise.
     * @throws IOException
     */
    private Token consumeIdentifier() throws IOException {
        StringBuilder sb = new StringBuilder();
        char ch;
        do {
            int value = reader.read();
            if (value == -1) {
                String identifier = sb.toString();
                if (isValidIdentifier(identifier)) {
                    return new Token.Identifier(identifier);
                } else {
                    return new Token(Token.Kind.INVALID);
                }
            }

            ch = (char) value;
            sb.append(ch);
        } while (Character.isWhitespace(ch));

        String identifier = sb.toString();
        if (isValidIdentifier(identifier)) {
            return new Token.Identifier(identifier);
        } else {
            return new Token(Token.Kind.INVALID);
        }
    }

    /**
     * @param identifier The identifier to check the validity of
     * @return true iff the identifier is a valid identifier in the language
     */
    private boolean isValidIdentifier(String identifier) {
        if (identifier.isEmpty()) {
            return false;
        }

        for (char ch : identifier.toCharArray()) {
            if (!Character.isLetterOrDigit(ch) && ch != '_') {
                return false;
            }
        }

        if (identifier.equals("givemeanew")
                || identifier.equals("doitnow")
                || identifier.equals("anybodywantsome")
                || identifier.equals("bigo")) {
            return false;
        }

        return true;
    }

    /**
     * @param keyword The keyword
     * @param kind    The kind of the token
     * @return A token with the specified kind, or a token of {@code Token.Kind.INVALID} if the keyword did not match the next characters
     * @throws IOException
     */
    private Token consumeKeywordToken(String keyword, Token.Kind kind) throws IOException {
        if (consumeString(keyword)) {
            return new Token(kind);
        } else {
            return new Token(Token.Kind.INVALID);
        }
    }

    /**
     * @param str the string to match
     * @return true iff the entire string was matched
     * @throws IOException
     */
    private boolean consumeString(String str) throws IOException {
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            int value = reader.read();
            if (value == -1) {
                reader.unread(chars, 0, i);
                return false;
            }

            char ch = (char) value;
            if (chars[i] != ch) {
                reader.unread(chars, 0, i);
                return false;
            }
        }

        return true;
    }

}
