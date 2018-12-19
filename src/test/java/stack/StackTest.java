package stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void pushOneElementToStack() {
        Stack stack = new Stack();
        stack.push(1);

        assertEquals(1,stack.size());
    }

    @Test
    public void pushTwoElementsToStack() {
        Stack stack = new Stack();
        stack.push(112312);
        stack.push(4123132);

        assertEquals(2,stack.size());
    }
}