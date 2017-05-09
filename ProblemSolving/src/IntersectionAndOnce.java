import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionAndOnce {
	
	//something here
	public static List<Integer> intersect(int[] array1, int[] array2){
		
		Map<Integer, Boolean> hm = new HashMap<Integer, Boolean>(); 
		List<Integer> result = new ArrayList<Integer>();
		
		for (int element: array1){
			if (!hm.containsKey(element)) hm.put(element, true);
		}
		
		for (int element: array2){
		
			if (hm.containsKey(element) && hm.get(element) == true){
				result.add(element);
				hm.put(element, false);
			}
		}
		
		return result;
		
	}

	public static void main(String[] args) {
		
		int[] x = {1,5,6,8,10,5,4,3};
		int[] y = {7,5,4,3,8,9,4,10};
		
		System.out.println(intersect(x,y));
	}

}
