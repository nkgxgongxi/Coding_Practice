//import java.util.*;

public class TreeOp {
	public static void main(String[] args){
		TreeNode head = new TreeNode("+");
		head.left = new TreeNode("-");
		head.right = new TreeNode("*");
//		head.right = new TreeNode("3");
		head.right.right = new TreeNode("4");
		head.right.left = new TreeNode("5");
		head.left.left = new TreeNode("7");
		head.left.right = new TreeNode("8");
		int counter = 0;
		while(head.hasChildren()){
			counter ++;
			TreeNode temp = head;
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
