package stack;

import org.junit.Before;
import org.junit.Test;
import stack.exception.StackException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.Assert.assertEquals;

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
    public void handlePopException() {
        assertThatThrownBy(() ->  stack.pop())
                .hasMessage("Pila vacia, no puedes hacer pop por ahora!")
                .isInstanceOf(StackException.class);
    }

}