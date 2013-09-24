
public class MyTreeNode {
	String value;
	MyTreeNode left;
	MyTreeNode right;
	
	MyTreeNode(String s){
		value = s;
		left = null;
		right = null;
				
	}
	
	public MyTreeNode getRight(){
		return this.right;
	}
	public MyTreeNode getLeft(){
		return this.left;
	}
	public boolean hasLeft(){
		if(this.left == null)
			return false;
		else
			return true;
	}
	public boolean hasRight(){
		if(this.right == null)
			return false;
		else
			return true;
	}
	public boolean hasChildren(){
		if(this.left != null || this.right != null)
			return true;
		else
			return false;
	}
	public void replace(){
		this.value = this.operation();
		this.left = null;
		this.right = null;
	}
	public String operation(){
		if(this.value.equals("+"))
			return String.valueOf(Integer.parseInt(this.getRight().value) + Integer.parseInt(this.getLeft().value));
		else if(this.value.equals("-"))
			return String.valueOf(Integer.parseInt(this.getLeft().value) - Integer.parseInt(this.getRight().value));
		else if(this.value.equals("*"))
			return String.valueOf(Integer.parseInt(this.getLeft().value) * Integer.parseInt(this.getRight().value));
		else
			return String.valueOf(Integer.parseInt(this.getLeft().value) / Integer.parseInt(this.getRight().value));
	}
}
