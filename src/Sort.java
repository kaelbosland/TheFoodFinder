public class Sort{
	private int input[];
    private int length;
	//QuickSort 

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
       
    }

	
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
	  
	  private static void show(Comparable[] a) {
	        for (int i = 0; i < a.length; i++) {
	            StdOut.println(a[i]);
	        }
	    }
	  
	  public static Comparable select(Comparable[] a, int k) {
	        if (k < 0 || k >= a.length) {
	            throw new IndexOutOfBoundsException("Selected element out of bounds");
	        }
	        StdRandom.shuffle(a);
	        int lo = 0, hi = a.length - 1;
	        while (hi > lo) {
	            int i = partition(a, lo, hi);
	            if      (i > k) hi = i - 1;
	            else if (i < k) lo = i + 1;
	            else return a[i];
	        }
	        return a[lo];
	    }

	
	    //test case 
	  public static void main(String[] args) {
	        Integer[] a = {4,8,6,5,2,8};
	        Sort.sort(a);
	        StdOut.println();
	        for (int i = 0; i < a.length; i++) {
	            Integer ith = (Integer) Sort.select(a, i);
	            StdOut.println(ith);
	    }
	  }
	  
}

