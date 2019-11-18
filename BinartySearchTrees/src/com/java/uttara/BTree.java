package com.java.uttara;

public class BTree {

	BTNode root;

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
	
	BTNode delete(int data){
		return delete(this.root,data);
	}
	
	//Check for a leaf node------------------------------------------------------------------------------------------------------------
	boolean isLeaf(BTNode root){
		if(root.getLeft()==null && root.getRight()==null)
			return true;
		else
			return false;
	}
	
	//Iterative approach to insert---------------------------------------------------------------------------------------------
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

	//Recursive approach to insert data-----------------------------------------------------------------------------------
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
	
	// InOrder Traversal is used to print in sorted order-----------------------------------------------------------------
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

	// Find minimum value of BSTree-----------------------------------------------------------------------------------------
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
	
	//Recursive approach to find Min and Max----------------------------------------------------------------------
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
	
	//Search for a given data in BST---------------------------------------------------------------------------------------
	boolean checkBST(BTNode root,int data){
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
	BTNode delete(BTNode root,int data){
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
				BTNode temp =new BTNode( max(root.getLeft()));
				root.setData(temp.getData());
				root.setLeft(delete(root.getLeft(),root.getData()));
				return root;
			}
		}
	}
	
	
	//Check given Tree is BST or Not
	boolean isBST1(){
		return true;
	}
	
}
