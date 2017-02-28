import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Anagrams {

	public static void main(String[] args) {

		String[] array = new String[] { "lead", "deal", "dale", "cheating",
				"teaching", "eat", "tea", "ate" };

		// first sort the array
		Arrays.sort(array);

		// create another array that keeps track of the original index in the
		// array.
		String[][] testArray = new String[array.length][2];

		// fill in testArray with the words and its index, while sorting the
		// characters in the words.
		for (int i = 0; i < array.length; i++) {
			char[] charArray = array[i].toCharArray();
			Arrays.sort(charArray);
			testArray[i][0] = new String(charArray);
			testArray[i][1] = Integer.toString(i);
		}

		// Sort the words so that anagrams are grouped together.
		Arrays.sort(testArray, new Comparator<String[]>() {

			@Override
			public int compare(String[] entry1, String[] entry2) {
				final String s1 = entry1[0];
				final String s2 = entry2[0];

				return s1.compareTo(s2);
			}

		});

		// from here, the anagrams are grouped together and on each anagram
		// group,
		// the words are sorted. However, the anagram groups are not
		// sorted to other anagram groups. In other words, when printed,
		// the words are sorted horizontally, but not vertically.

		// since the first words of each anagram group cannot be equal,
		// then you just need to sort based on the first words.

		// Place the words in an Array List of Array List of Strings.
		// Where columns is the anagram group. And rows are words that
		// belong to that anagram group.
		// The first row will be the words that appear first for the anagram
		// groups.

		// Then sort that array list based on its first String.
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

		for (int i = 0; i < testArray.length; i++) {

			int index = Integer.parseInt(testArray[i][1]);

			if (i != 0) {
				// recognize that it belongs to another anagram group
				if (!(testArray[i][0]).equals(testArray[i - 1][0])) {
					// then create new empty anagram group
					result.add(new ArrayList<String>());
				}

				result.get(result.size() - 1).add(array[index]);

			} else { // if index is 0
				result.add(new ArrayList<String>());
				result.get(0).add(array[index]);
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
