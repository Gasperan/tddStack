package stack;

import stack.exception.StackException;

public class Stack {
    private static final String EXCEPTION_MESSAGE = "Pila vacia, no puedes hacer pop por ahora!";
    private int[] stack = new int[10];
    private int index = 0;

    public void push(int number) {
        stack[index] = number;
        index++;
    }

    public int size() {
        return index;
    }


    public int pop() throws StackException {
        try {
            return stack[--index];
        } catch (ArrayIndexOutOfBoundsException exception) {
            throw new StackException(EXCEPTION_MESSAGE);
        }
    }

    public int top() {
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
}
