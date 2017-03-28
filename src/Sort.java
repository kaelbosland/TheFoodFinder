
public class Sort{
	
	//QuickSort 
	
	private static void sort(Comparable[] prodID, int lo, int hi){
		if (hi <= lo) 
			return;
		int j = partition(prodID, lo, hi);  // Separate into 2 parts 
		sort(prodID, lo, j-1);              // Sort left part prodID[lo .. j-1].
		sort(prodID, j+1, hi);              // Sort right part prodID[j+1 .. hi].
	}
	
	  private static int partition(Comparable[] prodID, int lo, int hi) {  // Separate into prodID[lo..i-1], prodID[i], prodID[i+1..hi].
	  
	     int i = lo, j = hi+1;            // left and right scan indices
	     Comparable v = prodID[lo];            // separating item
	     while (true){ 
	        while (less(prodID[++i], v)) if (i == hi) break;
	        while (less(v, prodID[--j])) if (j == lo) break;
	        if (i >= j) break;
	        exch(prodID, i, j);
	     }
	     exch(prodID, lo, j);
	     return j;
	     
	  }
	  private static boolean less(Comparable v, Comparable w) {
	        return v.compareTo(w) < 0;
	    }
	  
	  private static void exch(Object[] prodID, int i, int j) {
	        Object swap = prodID[i];
	        prodID[i] = prodID[j];
	        prodID[j] = swap;
	    }
}

