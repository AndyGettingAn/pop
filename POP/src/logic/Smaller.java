package logic;

import declaration.Block;
import main.RuntimeScope;
import operator.Operator;

public class Smaller extends Condition {
        public Smaller() {
            super();
        }

        public Smaller(Operator l, Operator r) {
            super(l, r);
        }

        @Override
        public boolean evaluate(Block myBlock, RuntimeScope myScope) {
            Object op1, op2;

            op1 = left.evaluate(myBlock, myScope);
            op2 = right.evaluate(myBlock, myScope);

            if (op1 instanceof Double && op2 instanceof Double) {
                return ((Double)op1).doubleValue() < ((Double)op2).doubleValue();
            }
            else {
                System.out.println("RUNTIME ERROR:  operand of SMALLER does not have a defined value:" + op1 + " " + op2);
                return false;
            }
        }
    }
