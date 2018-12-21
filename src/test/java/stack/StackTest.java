package stack;

import org.junit.Before;
import org.junit.Test;
import stack.exception.StackException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.Assert.*;

public class StackTest {

    Stack stack;


    @Before
    public void setUp() {
        stack = new Stack();
    }

    @Test
    public void pushOneElementToStack() {
        stack.push(1113);

        assertEquals(1, stack.size());
    }

    @Test
    public void pushTwoElementsToStack() {
        stack.push(112312);
        stack.push(4123132);

        assertEquals(2, stack.size());
    }

    @Test
    public void popRetrieveElementToStack() {
        stack.push(112312);

        int element = stack.pop();

        assertEquals(112312, element);
        assertEquals(0, stack.size());
    }

    @Test
    public void popRetrieveTwoElementToStack() {
        stack.push(112312);
        stack.push(34242);

        int elementOne = stack.pop();
        int elementTwo = stack.pop();

        assertEquals(34242, elementOne);
        assertEquals(112312, elementTwo);
    }

    @Test
    public void topElementFromStack() {
        stack.push(112312);

        int elementOne = stack.top();

        assertEquals(112312, elementOne);
        assertEquals(1, stack.size());
    }

    @Test
    public void printStack() {
        stack.push(7777);
        stack.push(2222);
        stack.push(5555);

        String printStack = stack.print();

        assertEquals("bottom-->[7777,2222,5555]<--top",printStack);

    }

    @Test
    public void printEmptyStack() {

        String printStack = stack.print();

        assertEquals("bottom-->[]<--top",printStack);

    }

    @Test
    public void handlePopException() {
        assertThatThrownBy(() ->  stack.pop())
                .hasMessage("Pila vacia, no puedes hacer pop por ahora!")
                .isInstanceOf(StackException.class);
    }

    @Test
    public void handleTopException() {
        assertThatThrownBy(() ->  stack.top())
                .hasMessage("Pila vacia, no puedes hacer top por ahora!")
                .isInstanceOf(StackException.class);
    }

    @Test
    public void shouldReturnTrueIfStackIsEmpty() {
        boolean result = stack.isEmpty();
        assertTrue(result);
    }

    @Test
    public void shouldReturnFalseIfStackIsNotEmpty() {

        stack.push(111);

        boolean result = stack.isEmpty();
        assertFalse(result);
    }

    @Test
    public void shouldReturnTrueIfStackIsFull() {
        stack.push(111);
        stack.push(222);
        stack.push(333);

        boolean result = stack.isFull();

        assertTrue(result);
    }

    @Test
    public void shouldReturnFalseIfStackIsNotFull() {

        boolean result = stack.isFull();

        assertFalse(result);
    }

    @Test
    public void shouldCheckIfStackIsDynamic() {
        stack.push(111);
        stack.push(222);
        stack.push(333);
        stack.push(444);

        assertEquals(4, stack.size());
    }
}