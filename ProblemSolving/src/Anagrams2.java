import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;

public class Anagrams2 {
	
	//change here
	public static void main(String[] args) {
		
		int x = 0;

		String[] somethingDifferent = new String[] { "lead", "deal", "dale", "cheating",
				"teaching", "eat", "tea", "ate" };

		// first sort the array
		Arrays.sort(array);

		TreeMap<String, ArrayList<String>> anagrams = new TreeMap<String, ArrayList<String>>();
		
		for (int i = 0; i < array.length; i++){
			
			char[] charArray = array[i].toCharArray();
			Arrays.sort(charArray);
			String sortedString = new String(charArray);
			
			ArrayList<String> value = anagrams.get(sortedString);

			if (value == null){
				anagrams.put(sortedString, new ArrayList<String>());
				value = anagrams.get(sortedString);
			}
			
			value.add(array[i]);
		}
		
		// Then sort that array list based on its first String.
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		
		for (String s: anagrams.keySet()){
			result.add(new ArrayList<String>());
			for (String words: anagrams.get(s)){
				result.get(result.size()-1).add(words);
			}

		}

		Collections.sort(result, new Comparator<ArrayList<String>>() {
			@Override
			public int compare(ArrayList<String> o1, ArrayList<String> o2) {
				return o1.get(0).compareTo(o2.get(0));
			}

		});

		// 'result' now contains the answer.
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < result.get(i).size(); j++) {
				System.out.print(result.get(i).get(j) + " ");
			}

			System.out.println();
		}

	}
}
