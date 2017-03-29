// package FoodFinder;

import java.util.ArrayList;

public class Search {

	public static ArrayList[] Search(String key, ArrayList prodId, ArrayList overall, ArrayList reviewText) {
		ArrayList[] arraylists = new ArrayList[3];

		if (prodId.size() == overall.size() && overall.size() == reviewText.size()) {
			arraylists[0] = new ArrayList<String>();
			arraylists[1] = new ArrayList<Double>();
			arraylists[2] = new ArrayList<String>();

			for (int i = 0; i < prodId.size(); i++) {
				if (findKey(key, (String) reviewText.get(i))) {
					arraylists[0].add(prodId.get(i));
					arraylists[1].add(overall.get(i));
					arraylists[2].add(reviewText.get(i));
				}
			}
		}
		return arraylists;
	}

	public static boolean findKey(String keyword, String review) {
		String rev = review;
		String key = keyword;
		return rev.toLowerCase().contains(key.toLowerCase());
	}

	public static void main(String[] args) {
		//cant get json parser to work properly, so made a small test case instead
		ArrayList<String> prodID = new ArrayList<String>();
		ArrayList<Double> overall = new ArrayList<Double>();
		ArrayList<String> reviews = new ArrayList<String>();

		for (double i = 0; i < 5; i++) {
			overall.add(i);
		}

		for (int i = 0; i < 5; i++) {
			prodID.add(Integer.toString(i));
		}

		reviews.add("this food was very tasty");
		reviews.add("this food was bad");
		reviews.add("this food sucked");
		reviews.add("this food was very tasty");
		reviews.add("this was very tasty");

		ArrayList[] lists = Search("tasty", prodID, overall, reviews);

		for (int i = 0; i < lists[2].size(); i++) {
			System.out.println(lists[0].get(i));
			System.out.println(lists[1].get(i));
			System.out.println(lists[2].get(i));
			System.out.println();
		}
	}
}
