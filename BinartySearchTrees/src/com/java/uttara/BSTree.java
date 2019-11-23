package com.java.uttara;

public class BSTree {

	BSTNode root;

	int getRoot(){
		return this.root.getData();
	}
	 
	//wrapper classes*********************************************************************************************
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

	boolean checkBST(int data){
		return checkBST(this.root,data);
	}
	
	BSTNode delete(int data){
		return delete(this.root,data);
	}
	
	boolean isBST(){
		int mini_value=minRec();
		return isBST(this.root,mini_value);
	}
	
	//Check for a leaf node------------------------------------------------------------------------------------------------------------
	boolean isLeaf(BSTNode root){
		if(root.getLeft()==null && root.getRight()==null)
			return true;
		else
			return false;
	}
	
	//Iterative approach to insert---------------------------------------------------------------------------------------------
	void insert(BSTNode root, int data) {
		BSTNode node = new BSTNode(data);

		if (root == null) {
			this.root = node;
			return;
		} else {
			BSTNode temp = root;
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

	//Recursive approach to insert data-----------------------------------------------------------------------------------
	BSTNode insertRecur(BSTNode root,int data){
		if(null == root){
			BSTNode node = new BSTNode(data);
			return node;
		}
		else{
			if(data < root.getData()){
				BSTNode left = insertRecur(root.getLeft(),data);
				//System.out.println("Data is inserted" + left.getData());
		        root.setLeft(left);	
			}
			else{
				BSTNode right = insertRecur(root.getRight(), data);
				//System.out.println("Data is inserted" + right.getData());
				root.setRight(right);
			}
			return root;
		}
	}
	
	// InOrder Traversal is used to print in sorted order-----------------------------------------------------------------
	void inOrderTrav(BSTNode root) {
		if (null == root) {
			// System.out.println("No elements are present");
			return;
		} else {
			inOrderTrav(root.getLeft());
			System.out.print(root.getData() + ",");
			inOrderTrav(root.getRight());
		}
	}

	// Find minimum value of BSTree-----------------------------------------------------------------------------------------
	int min(BSTNode root) {
		if (root == null) {
			System.out.println("No elements are present in the root");
			return -1;
		} else {
			BSTNode temp = root;
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
	int max(BSTNode root) {
		if (root == null) {
			System.out.println("No elements are present in the root");
			return -1;
		} else {
			BSTNode temp = root;
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
	
	//Recursive approach to find Min and Max----------------------------------------------------------------------
	int maxRec(BSTNode root){
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
	
	int minRec(BSTNode root){
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
	
	//Search for a given data in BST---------------------------------------------------------------------------------------
	boolean checkBST(BSTNode root,int data){
		if(null == root)
			return false;
		if(data == root.getData())
			return true;
		else if(data < root.getData())
			return checkBST(root.getLeft(),data);
		else 
			return checkBST(root.getRight(),data);
	}
	
	//Delete the given data in BST-----------------------------------------------------------------------------------
	BSTNode delete(BSTNode root,int data){
		if(null == root)
			return null;
		else if(data < root.getData()){
			 root.setLeft(delete(root.getLeft(),data));
		return root;
		}
		else if(data > root.getData()){
			root.setRight(delete(root.getRight(),data));
			return root;
		}
		else{
			if(isLeaf(root))
				return null;
			else if(root.getLeft()!=null && root.getRight()==null)
				return root.getLeft();
			else if(root.getLeft()==null && root.getRight()!=null)
				return root.getRight();
			else{
				BSTNode temp =new BSTNode( max(root.getLeft()));
				root.setData(temp.getData());
				root.setLeft(delete(root.getLeft(),root.getData()));
				return root;
			}
		}
	}
	
	//Check given BinaryTree is BST or Not---------------------------------------------------------------------------------
	boolean isBST(BSTNode root,int prev){
		if(null == root){
			return true;
		}else{
			boolean left = isBST(root.getLeft(),prev);
			if(!left)
				return left;
			
			if(prev > root.getData())
				return false;
			
			prev = root.getData();
			
			boolean right = isBST(root.getRight(),prev);
			return right;
		}
	}
	
}
