

/**
 * Simulates python's range function
 * @param <T>
 */
public class Range  {
	
	Integer current;
	Integer minimum;
	Integer maximum; 
	Integer increment;


	public Range(int start, int stop, int incr) {
		minimum = (Integer) start;
		maximum = (Integer) stop;
		/*Do something when a negative number is entered*/
		increment = (Integer) incr;
		
		current = minimum; //pointer; starts at min
		
		java.util.Iterator<Integer> itr1 = iterator(); 
		
		
		while(itr1.hasNext()){
			System.out.print(itr1.next() + " ");	
		}
	}
	public Range(int start, int stop) {
		int incr = 1;
		
		minimum= (Integer) start;
		maximum= (Integer) stop;
		increment = (Integer) incr;
		
		current = minimum; //pointer; starts at min
		
		java.util.Iterator<Integer> itr2 = iterator(); 

		while(itr2.hasNext()) {
			System.out.print(itr2.next() + " ");
		}
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

}
