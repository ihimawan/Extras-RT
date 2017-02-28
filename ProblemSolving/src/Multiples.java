
public class Multiples {

	public static void main(String[] args){
		
		int x[] = {1,3,2,5,7,3,2,4,6,9,1,2,3,2,10,23,25};
		
		int sum3 = 0;
		int sum5 = 0;
		
		for (int element: x){
			if (element%3 == 0){
				sum3+=element;
			}
			
			if (element%5 == 0){
				sum5+=element;
			}
		}
		
		System.out.println(sum3 + " " + sum5);
	}
	
}
