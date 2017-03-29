public class Product implements Comparable<Product>{
	private String prodID;
	private double overall;
	private String reviewText;
	
	
	public Product (String prodID, double overall, String reviewText){
		this.prodID = prodID;
		this.overall = overall;
		this.reviewText = reviewText;
	}
	
	
	public String prodID(){
		return this.prodID;
	}
	
	
	
	public double overall(){
		return this.overall;
	}
	
	
	
	public String reviewText(){
		return this.reviewText;
	}
	
	
	public String toString() {
		return prodID + "\t" + overall + reviewText;
	}
	
	
	@Override
	public int compareTo(Product that) {
		if (prodID.compareTo(that.prodID()) > 0) return +1;
		if (prodID.compareTo(that.prodID()) < 0) return -1;
		if (this.overall > that.overall) return +1;
		if (this.overall < that.overall) return -1;
		else return 0;
		}
}

