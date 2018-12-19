package stack;

public class Stack {

    private int[] stack = new int[10];
    private  int index = 0;

    public void push(int number) {
        stack[index] = number;
        index++;
    }

    public int size() {
        return index;
    }
}
