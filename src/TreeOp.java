//import java.util.*;

public class TreeOp {
	public static void main(String[] args){
		MyTreeNode head = new MyTreeNode("+");
		head.left = new MyTreeNode("-");
		head.right = new MyTreeNode("*");
//		head.right = new MyTreeNode("3");
		head.right.right = new MyTreeNode("4");
		head.right.left = new MyTreeNode("5");
		head.left.left = new MyTreeNode("7");
		head.left.right = new MyTreeNode("8");
		int counter = 0;
		while(head.hasChildren()){
			counter ++;
			MyTreeNode temp = head;
//		System.out.println(temp.hasChildren());
//		System.out.println(temp.right.value);
			while(temp.hasRight()){
		//			System.out.println("I am 0");
				if(temp.right.hasChildren()){
		//				System.out.println("I am 1");
					temp = temp.right;
				}
				else if(temp.left.hasChildren()){
		//				System.out.println("I am 2");
					temp = temp.left;
				}
				else{
		//				System.out.println("I am 3");
					temp.replace();
//					System.out.println(temp.value);
				}
			}	
		}
//		System.out.println(temp.value);
		System.out.println(head.value);
		System.out.println(counter);
	}
}
