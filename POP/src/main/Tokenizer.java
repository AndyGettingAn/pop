package main;

import operator.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Tokenizer {
    public enum ScanToken { EOF, OPERATOR, JSON, STRING, NUMBER, VARIABLE, OPEN_BLOCK, CLOSE_BLOCK,
        BOOL_ASSIGNMENT, ASSIGNMENT,
        EOS, MAPDECL, DOUBLEDECL, TEXTDECL, BOOLDECL, PRINT, LISTENERDECL, FUNCTIONDECL, PROCDECL,
        RETURN, OPEN_BRACKET, CLOSE_BRACKET,
        COMMA, PROGRAM, CALL, SMALLER, GREATER, IF, ELSE, AND, OR, NOT,
        EVENT, WHILE, TRUE, FALSE, GET, THREAD, WAIT, AWAIT };
    private InputStreamReader input;

    private Operator currentOperator;
    private String currentValue;
    private double currentNumber;

    private int lastToken, backupToken;

    public Tokenizer(InputStream textsource) {
        input = new InputStreamReader(textsource);
        lastToken = Integer.MIN_VALUE;
    }

    private ScanToken readVariable(char tok) {
        int next;

        currentValue = "" + tok;

        try {
            next = input.read();
            lastToken = next;

            while (Character.isLowerCase(((char)next))) {
                currentValue += (char)next;
                next = input.read();
                lastToken = next;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ScanToken.VARIABLE;
    }

    private ScanToken readKeyword(char tok) {
       int next;

        currentValue = "" + tok;

        try {
            next = input.read();
            lastToken = next;

            while (Character.isUpperCase(((char)next))) {
                currentValue += (char)next;
                next = input.read();
                lastToken = next;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (currentValue.equals("DOUBLE")) return ScanToken.DOUBLEDECL;
        else if (currentValue.equals("TEXT")) return ScanToken.TEXTDECL;
        else if (currentValue.equals("MAP")) return ScanToken.MAPDECL;
        else if (currentValue.equals("BOOLEAN")) return ScanToken.BOOLDECL;
        else if (currentValue.equals("FUN")) return ScanToken.FUNCTIONDECL;
        else if (currentValue.equals("LISTENER")) return ScanToken.LISTENERDECL;
        else if (currentValue.equals("PROC")) return ScanToken.PROCDECL;
        else if (currentValue.equals("PRINT")) return ScanToken.PRINT;
        else if (currentValue.equals("RETURN")) return ScanToken.RETURN;
        else if (currentValue.equals("TRUE")) return ScanToken.TRUE;
        else if (currentValue.equals("FALSE")) return ScanToken.FALSE;
        else if (currentValue.equals("PROGRAM")) return ScanToken.PROGRAM;
        else if (currentValue.equals("CALL")) return ScanToken.CALL;
        else if (currentValue.equals("EVENT")) return ScanToken.EVENT;
        else if (currentValue.equals("THREAD")) return ScanToken.THREAD;
        else if (currentValue.equals("AWAIT")) return ScanToken.AWAIT;
        else if (currentValue.equals("WAIT")) return ScanToken.WAIT;
        else if (currentValue.equals("GET")) return ScanToken.GET;
        else if (currentValue.equals("IF")) return ScanToken.IF;
        else if (currentValue.equals("IS")) return ScanToken.BOOL_ASSIGNMENT;
        else if (currentValue.equals("ELSE")) return ScanToken.ELSE;
        else if (currentValue.equals("WHILE")) return ScanToken.WHILE;
        else {
            System.out.println("ERROR: unknown keyword " + currentValue);
            return ScanToken.EOF;
        }
    }

    private ScanToken readDoubleNumber(char tok) {
        int next;

        currentValue = (Character.isDigit(tok) ? "" + tok : "");

        try {
            next = input.read();
            lastToken = next;

            while (Character.isDigit(((char)next))) {
                currentValue += (char)next;
                next = input.read();
                lastToken = next;
            }

            if (((char)next) == '.') {
                currentValue += '.';

                next = input.read();
                lastToken = next;

                while (Character.isDigit(((char)next))) {
                    currentValue += (char)next;
                    next = input.read();
                    lastToken = next;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (currentValue.length() > 0) {
            currentNumber = Double.parseDouble((tok == '-' ? "-" : "") + currentValue);
            return ScanToken.NUMBER;
        }
        else if (tok == '-') {
            currentOperator = new Subtract();
            return ScanToken.OPERATOR;
        }
        else {
            System.out.println("ERROR: illegal token while reading double: " + tok);
            return null;
        }
    }

    private ScanToken readString(char tok) {
        int next;

        currentValue = "";

        try {
            next = input.read();
            lastToken = next;

            while ((char)next != '\"') {
                currentValue += (char)next;
                next = input.read();
                lastToken = next;
            }

            next = input.read();
            lastToken = next;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return ScanToken.STRING;
    }

    private ScanToken readJSONConst(char tok) {
        int next;

        currentValue = "";

        try {
            next = input.read();
            lastToken = next;

            while ((char)next != '\'') {
                currentValue += (char)next;
                next = input.read();
                lastToken = next;
            }

            next = input.read();
            lastToken = next;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return ScanToken.JSON;
    }

    public ScanToken readOperator(Operator op) {
            currentOperator = op;
            resetLastToken();
            return ScanToken.OPERATOR;
    }

    public boolean test(ScanToken t) {
        int next;
        try {
            if (lastToken == Integer.MIN_VALUE) {
                next = input.read();
                lastToken = next;
            }
            else next = lastToken;

            if (t == ScanToken.CLOSE_BRACKET && ((char)next == ')')) return true;
            else return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ScanToken scan() {
        int next;
        char [] token = new char[1];

        try {
            if (lastToken == Integer.MIN_VALUE) {
                next = input.read();
                lastToken = next;
            }
            else next = lastToken;

            while ((Character.isSpaceChar((char)next) && ((char)next != '\"')) ||
                    ((char)next == '\n') || ((char)next == '\t') || ((char)next == '\r')) {
                next = input.read();
                lastToken = next;
            }

            token[0] = ((char)next);

            if (next == -1) {
                resetLastToken();
                return ScanToken.EOF;
            }
            else if (token[0] == '\"') return readString(token[0]);
            else if (token[0] == '\'') return readJSONConst(token[0]);
            else if (Character.isDigit(token[0]) || (token[0] == '-')) return readDoubleNumber(token[0]);
            else if (token[0] == '*') return readOperator(new Mult());
            else if (token[0] == '/') return readOperator(new Divide());
            else if (token[0] == '+') return readOperator(new Add());
            else if (token[0] == '-') return readOperator(new Subtract());
            else if (token[0] == '{') {
                resetLastToken();
                return ScanToken.OPEN_BLOCK;
            }
            else if (token[0] == '}') {
                resetLastToken();
                return ScanToken.CLOSE_BLOCK;
            }
            else if (token[0] == '=') {
                resetLastToken();
                return ScanToken.ASSIGNMENT;
            }
            else if (token[0] == ';') {
                resetLastToken();
                return ScanToken.EOS;
            }
            else if (token[0] == ',') {
                resetLastToken();
                return ScanToken.COMMA;
            }
            else if (token[0] == '(') {
                resetLastToken();
                return ScanToken.OPEN_BRACKET;
            }
            else if (token[0] == ')') {
                resetLastToken();
                return ScanToken.CLOSE_BRACKET;
            }
            else if (token[0] == '<') {
                resetLastToken();
                return ScanToken.SMALLER;
            }
            else if (token[0] == '>') {
                resetLastToken();
                return ScanToken.GREATER;
            }
            else if (token[0] == '&') {
                resetLastToken();
                return ScanToken.AND;
            }
            else if (token[0] == '|') {
                resetLastToken();
                return ScanToken.OR;
            }
            else if (token[0] == '!') {
                resetLastToken();
                return ScanToken.NOT;
            }
            else if (Character.isLowerCase(token[0])) return readVariable(token[0]);
            else if (Character.isUpperCase(token[0])) return readKeyword(token[0]);
            else System.out.println("error: illegal token: " + next);
        } catch (IOException e) {
            e.printStackTrace();
        }

        resetLastToken();
        return ScanToken.EOF;
    }

    public String getCurrentValue() {
        return currentValue;
    }

    public double getCurrentNumber() {
        return currentNumber;
    }

    public Operator getCurrentOperator() { return currentOperator; }

    public void resetLastToken() {
        backupToken = lastToken;
        lastToken = Integer.MIN_VALUE;
    }

    public static void main(String [] args) {
        System.out.print("source text: ");
        Tokenizer s = new Tokenizer(System.in);
        ScanToken currentToken = s.scan();

        while (currentToken != ScanToken.EOF) {
            switch (currentToken) {
                case NUMBER:
                    System.out.println(currentToken + " has value: " + s.getCurrentNumber());
                    break;

                case OPERATOR:
                    System.out.println(currentToken + " is: " + s.getCurrentOperator());
                    break;

                case VARIABLE:
                    System.out.println(currentToken + " is variable: " + s.getCurrentValue());
                    break;

                default:
                    System.out.println("unknown token type: " + currentToken);
                    break;
            }
            currentToken = s.scan();
        }
    }
}
