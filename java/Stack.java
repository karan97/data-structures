class Stack<E> {
	
	int MAX = 500;
	E a[];
	int counter = -1;

	public void push(E element) {
		if (counter == MAX) {
			System.out.println("Stack Overflow");
			return;
		}
			counter = counter++;
			a[counter] = element;
	}

	public E pop() {
		if (counter == -1) {
			System.out.println("Stack Underflow");
		}
		E b = a[counter];
		counter--;
		return b;
	}
	
	public E top() {
		return a[counter];
	}

	public static void main(String args[]) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(5);
		s.push(6);
		s.push(7);
		s.push(2);
		s.push(-5);
		System.out.println(s.top());

	}
	
}