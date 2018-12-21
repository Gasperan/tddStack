package stack;

import stack.exception.StackException;

public class Stack {
    private static final String EXCEPTION_MESSAGE = "Pila vacia, no puedes hacer %s por ahora!";
    private static final int EXTEND_FACTOR_STACK = 2;
    private int[] stack = new int[3];
    private int index = 0;

    public void push(int number) {
        if(isFull()){
            extendCapacityStack();
        }

        stack[index] = number;
        index++;
    }

    public int size() {
        return index;
    }


    public int pop() {
        checkIsEmpty("pop");
        return stack[--index];
    }

    public int top() {
        checkIsEmpty("top");
        return stack[index - 1];
    }

    public String print() {
        StringBuilder print = new StringBuilder("bottom-->[");

        for (int i = 0; i < index; ++i) {
            print.append(stack[i]);

            if (i < index-1) {
                print.append(",");
            }
        }
        print.append("]<--top");


        return print.toString();
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public boolean isFull() {

        return index == stack.length;
    }

    private void checkIsEmpty(String from) {
        if (isEmpty()) {
            throw new StackException(String.format(EXCEPTION_MESSAGE, from));
        }
    }

    private void extendCapacityStack(){
        int[] newStack = new int[index+EXTEND_FACTOR_STACK];

        for(int i=0; i < index; i++){
            newStack[i] = stack[i];
        }

        stack = newStack;
    }




}
