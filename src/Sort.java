public class Sort{

	private static void sort(Comparable[] list, int lo, int hi){
		if (hi <= lo) 
			return;
		int j = partition(list, lo, hi);  // Separate into 2 parts 
		sort(list, lo, j-1);              // Sort left part list[lo .. j-1].
		sort(list, j+1, hi);              // Sort right part list[j+1 .. hi].
	}
	
	  private static int partition(Comparable[] a, int lo, int hi) {  // Separate into a[lo..i-1], a[i], a[i+1..hi].
	  
	     int i = lo, j = hi+1;            // left and right scan indices
	     Comparable v = a[lo];            // separating item
	     while (true){ 
	        while (less(a[++i], v)) if (i == hi) break;
	        while (less(v, a[--j])) if (j == lo) break;
	        if (i >= j) break;
	        exch(a, i, j);
	     }
	     exch(a, lo, j);
	     return j;
	     
	  }
	  private static boolean less(Comparable v, Comparable w) {
	        return v.compareTo(w) < 0;
	    }
	  
	  private static void exch(Object[] a, int i, int j) {
	        Object swap = a[i];
	        a[i] = a[j];
	        a[j] = swap;
	    }
}
