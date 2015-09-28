

/**
 * Simulates python's range function
 * @param <T>
 */
public class Range  {
	
	Integer current;
	Integer minimum;
	Integer maximum; 
	Integer increment;

	StringBuilder sb = new StringBuilder();
	
	SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();

	public Range(int start, int stop, int incr) {
		minimum = (Integer) start;
		maximum = (Integer) stop;
		/*Do something when a negative number is entered*/
		increment = (Integer) incr;
		
		current = minimum; //pointer; starts at min
		
		java.util.Iterator<Integer> itr1 = iterator(); 
		
		System.out.println(create(itr1));
	}
	public Range(int start, int stop) {
		int incr = 1;
		
		minimum= (Integer) start;
		maximum= (Integer) stop;
		increment = (Integer) incr;
		
		current = minimum; //pointer; starts at min
		
		java.util.Iterator<Integer> itr2 = iterator(); 

		System.out.println(create(itr2));
	}
	
	public String create(java.util.Iterator<Integer> iterator){
		while(iterator.hasNext()){
			list.add(iterator.next());
		}
		return list.toString();
	}

	
	/**
	 * Obtains an Iterator object used to traverse the list
	 * 
	 * @return an iterator pointed at the beginMarker
	 */
	public java.util.Iterator<Integer> iterator() {
		return new RangeIterator();
	}
	
	private class RangeIterator implements java.util.Iterator<Integer> {
		Integer nextInt; 
		
		public boolean hasNext() {
			if (current.compareTo(maximum)<0)
				return true;
			return false;
		}
		public Integer next() {
			if (!hasNext())
				throw new java.util.NoSuchElementException();
			
			nextInt = current;
			current = new Integer(current.intValue() + increment.intValue());
			
			return nextInt;
		}
		
	}
	
	public static void main(String[] args) {
		int min = 0;
		int max = 10;
		int incr = -1;
		
		System.out.println(new Range(min, max, incr));

	}

}
