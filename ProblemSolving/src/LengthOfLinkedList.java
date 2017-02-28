public class LengthOfLinkedList {
	public static void main(String[] args){
		
	}
	
	public static int lengthOfLinkedList(LinkedList list){
		int counter = 0;
		if (list.hasNext()){
			counter ++;
		}
		
		return counter;
	}
}

class LinkedList{
	
	Node head;
	
	LinkedList(){
		head=null;
	}
	
	public boolean hasNext(){
		return false;
	}
}

class Node{
	public int data;
	public Node nextNode;
}