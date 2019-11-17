package com.java.uttara;

public class BTree {

	BTNode root;

	// wrapper classes
	void insert(int data) {
		insert(this.root, data);
	}

	void inOrderTrav() {
		inOrderTrav(this.root);
	}

	int min() {
		return min(this.root);
	}

	
	int max() {
		return max(this.root);
	}
	
	void insertRecur(int data){
		this.root= insertRecur(this.root,data);
		//System.out.println("Root="+this.root.getData());
	}
	
	int maxRec(){
		return maxRec(this.root);
	}
	
	int minRec(){
		return minRec(this.root);
	}

	//Iterative approach
	void insert(BTNode root, int data) {
		BTNode node = new BTNode(data);

		if (root == null) {
			this.root = node;
			return;
		} else {
			BTNode temp = root;
			while (temp != null) {
				if (data < temp.getData()) {
					if (temp.getLeft() != null)
						temp = temp.getLeft();
					else {
						System.out.println("Data is inserted" + temp.getData());
						temp.setLeft(node);
						return;
					}
				} else {
					if (temp.getRight() != null)
						temp = temp.getRight();
					else {
						System.out.println("Data is inserted" + temp.getData());
						temp.setRight(node);
						return;
					}
				}
			}
		}
	}

	//Recursive approach to insert data
	BTNode insertRecur(BTNode root,int data){
		if(null == root){
			BTNode node = new BTNode(data);
			return node;
		}
		else{
			if(data < root.getData()){
				BTNode left = insertRecur(root.getLeft(),data);
				//System.out.println("Data is inserted" + left.getData());
		        root.setLeft(left);	
			}
			else{
				BTNode right = insertRecur(root.getRight(), data);
				//System.out.println("Data is inserted" + right.getData());
				root.setRight(right);
			}
			return root;
		}
	}
	
	// InOrder Traversal is used to print in sorted order
	void inOrderTrav(BTNode root) {
		if (null == root) {
			// System.out.println("No elements are present");
			return;
		} else {
			inOrderTrav(root.getLeft());
			System.out.print(root.getData() + ",");
			inOrderTrav(root.getRight());
		}
	}

	// Find minimum value of BSTree
	int min(BTNode root) {
		if (root == null) {
			System.out.println("No elements are present in the root");
			return -1;
		} else {
			BTNode temp = root;
			int mini = 0;
			while (temp != null) {
				if (temp.getLeft() != null)
					temp = temp.getLeft();
				else {
					mini = temp.getData();
					temp = temp.getLeft();
				}
			}
			return mini;
		}
	}

	//Find  maximum value of BSTree
	int max(BTNode root) {
		if (root == null) {
			System.out.println("No elements are present in the root");
			return -1;
		} else {
			BTNode temp = root;
			int maxm = 0;
			while (temp != null) {
				if (temp.getRight() != null)
					temp = temp.getRight();
				else {
					maxm = temp.getData();
					temp = temp.getRight();
				}
			}
			return maxm;
		}
	}
	
	//Recursive approach to find Min and Max
	int maxRec(BTNode root){
		if(root == null){
			return -1;
		}
		else if(root.getRight()==null){
			return root.getData();
		}
		else
		{
			int maxVal = maxRec(root.getRight());
			return maxVal;
		}
	}
	
	int minRec(BTNode root){
		if(root == null){
			return -1;
		}
		else if(root.getLeft()==null){
			return root.getData();
		}
		else
		{
			int minVal = minRec(root.getLeft());
			return minVal;
		}
	}
}
