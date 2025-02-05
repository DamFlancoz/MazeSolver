public class StackRefBased<T> implements Stack<T> {
    StackNode<T> top;
    int size;

    public StackRefBased() {
        top = null;
    }

    /*
     * Purpose:
     *   return the number of items currently pushed onto the stack.
     *
     * Returns:
     *   the number of items in the stack
     *
     * Examples:
     *
     * If s is {x, y, z}:
     *    s.size() returns 3.
     * If s is {}:
     *    s.size() returns 0.
     */
    public int size() {
        return size;
    }

    /*
     * Purpose:
     *   returns the boolean state of the stack (empty or not empty)
     *
     * Returns:
     *   false if stack is empty, true otherwise
     *
     * Examples:
     *
     * If s is {x, y, z}:
     *    s.isEmpty() returns false.
     * If s is {}:
     *    s.isEmpty() returns true.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /*
     * Purpose:
     *   places the values passed as a parameter onto the top of
     *   the stack.
     *
     * Returns:
     *   nothing.
     *
     * Examples:
     *
     * If s is {x, y, z}:
     *   then after s.push(m), s is {a, x, y, z} (i.e., top of stack
     *   is the left-most value in the sequence, bottom of stack is
     *   the right-most value in the sequence}.
     * If s is {}:
     *   then after s.push(m), s is {m}.
     */
    public void push(T data) {
        StackNode<T> newTop = new StackNode<>(data);
        newTop.setNext(top);
        top = newTop;
        size++;
    }

    /*
     * Purpose:
     *   removes the value at the top of the stack (if it exists),
     *   and returns it to the caller. If the stack was empty before
     *   the call, then an exception is thrown by the method.
     *
     * Returns:
     *   The value of type T at the top of the stack (if stack is
     *   non-empty)
     *
     * Examples:
     *
     * If s is {x, y, z}:
     *    then after s.pop(), s is {y, z} and x is returned to the
     *    caller.
     * If s is {}:
     *    then a StackEmptyException() is thrown.
     */
    public T pop() throws StackEmptyException {
        if (isEmpty()) throw new StackEmptyException();

        T val = top.getValue();
        top = top.getNext();
        size--;
        return val;
    }

    /*
     * Purpose:
     *   returns the value at the top of the stack (if it exists)
     *   but does not modify the contents of the stack. If the stack
     *   was empty before the call, then an exception is thrown
     *   by the method.
     *
     * Returns:
     *   The value of type T at the top of the stack (if stack is
     *   non-empty)
     *
     * Examples:
     *
     * If s is {x, y, z}:
     *    then after s.peek(), s is {x, y, z} and x is returned to the
     *    caller.
     * If s is {}:
     *    then a StackEmptyException() is thrown.
     */
    public T peek() throws StackEmptyException {
        if(isEmpty()) throw new StackEmptyException();
        return top.getValue();
    }

    /*
     * Purpose:
     *   clear the stack of all its content.
     *
     * Returns:
     *   nothing.
     *
     * Examples:
     *
     * If s is {x, y, z}:
     *   then after s.makeEmpty(), s is {}.
     * If s is {}:
     *   then after s.makeEmpty(), s is {}.
     */
    public void makeEmpty() {
        top = null;
        size = 0;
    }

    /*
     * Purpose:
     *	return a string representation of the stack
     *
     * Returns:
     *  A string representation of the stack.
     *
     * Examples:
     *
     * If is is {x,y,z}, s.toString() returns "x y z"
     *
     * If s is {}, s.toString() returns ""
     */
    public String toString() {

        StringBuilder s = new StringBuilder();

        for(StackNode<T> temp = top; temp != null; temp = temp.getNext()){
            s.insert(0," " + temp.toString());
        }

        if (s.toString().equals("")) return s.toString();

        s.deleteCharAt(0);
        return s.toString();
    }
}

