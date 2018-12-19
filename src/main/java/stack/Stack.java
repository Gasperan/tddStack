package stack;

public class Stack {

    private int[] stack = new int[10];
    private  int index = -1;

    public void push(int number) {
        index++;
        stack[index] = number;
    }

    public int size() {
        return index+1;
    }
}
