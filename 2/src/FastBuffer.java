import java.util.ArrayList;

// this class should contain your implementation of the Buffer interface

public class FastBuffer implements Buffer{

	int size = 0;
	char[] bufferArray;
	int cursorPos = 0;
	
	myStack stackA = new myStack();
	myStack stackB = new myStack();

	public int size() {
		return size;
	}

	public void load(char[] initial, int cursorPosition) {
		bufferArray = initial;
		cursorPos = cursorPosition; 
		
		for(int a=0; a<cursorPos; a++) {
			stackA.push(bufferArray[a]);
		}
		
		for(int b=initial.length-1; b>=cursorPos; b--) {
			stackB.push(bufferArray[b]);
		}
	}

	/** converts the current buffer contents to an array
	  returnArray.length == size()
	 */
	public char[] toArray() {
		char[] newArray = new char[stackA.size()+stackB.size()];
		
		for(int c = stackA.size()-1; c >= 0; c--){
			newArray[c]=stackA.peek();
		}
		
		/*ends before sum of the stacks' size*/
		for(int d = cursorPos; d < stackA.size()+stackB.size(); d++){
			newArray[d]=stackB.peek();
		}
		
		return newArray;
	}

	
	public int getCursor() {
		return cursorPos;
	}

	
	public void setCursor(int j) {
		int difference = cursorPos-j;	
		
		/*if desired cursor position is BEFORE initial cursor */
		if(difference<0){
			for(int k=0;k<=difference;k++) { moveRight(); }
	
		/*if desired cursor position is AFTER initial cursor*/		
		}else if(difference>0)	{
			for(int k=0;k<=difference;k++) { moveLeft(); }
			
		}else {
			System.out.println("The cursor is already at the desired position.");
		}
	}

	
	public void moveRight() {
		stackA.push(stackB.pop());
		cursorPos++;
	}

	
	public void moveLeft() {
		stackB.push(stackA.pop());
		cursorPos--;
		
	}

	public void insertLeft(char c) {
		bufferArray[cursorPos-1] = c;
	}

	public char deleteRight() {
		char deletedChar = bufferArray[cursorPos+1];
		bufferArray[cursorPos+1] = '\0';
		
		return deletedChar;
	}
	
	public char deleteLeft() {
		char deletedChar = bufferArray[cursorPos-1];
		bufferArray[cursorPos-1] = '\0';
		
		return deletedChar;
	}
	
	private class myStack {
		ArrayList<Character> theArray = new ArrayList<Character>(); 
		int topOfStack = -1;
		
		public void push(char c) {
			topOfStack++;
			theArray.add((Character) c);
		}
		
		public char pop() {
			char d = theArray.get(topOfStack);
			theArray.remove(topOfStack);
			topOfStack--;
			
			return d;	
		}
		
		public int size() {
			return theArray.size();
		}

		public char peek() {
			return theArray.get(topOfStack);
		}
		
	}

	
}
