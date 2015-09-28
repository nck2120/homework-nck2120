

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

	public Range(int start, int stop, int incr) {
		minimum = (Integer) start;
		maximum = (Integer) stop;
		/*Do something when a negative number is entered*/
		increment = (Integer) incr;
		
		current = minimum; //pointer; starts at min
		
		java.util.Iterator<Integer> itr1 = iterator(); 
		
		createString(itr1);
	}
	public Range(int start, int stop) {
		int incr = 1;
		
		minimum= (Integer) start;
		maximum= (Integer) stop;
		increment = (Integer) incr;
		
		current = minimum; //pointer; starts at min
		
		java.util.Iterator<Integer> itr2 = iterator(); 

		createString(itr2);
	}
	
	public String createString(java.util.Iterator<Integer> iterator){
		while(iterator.hasNext()){
			sb.append(iterator.next());
		}
		return String(sb);
	}

	private String String(StringBuilder sb2) {
		// TODO Auto-generated method stub
		return null;
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
