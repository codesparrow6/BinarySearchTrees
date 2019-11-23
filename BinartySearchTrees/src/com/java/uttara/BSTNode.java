package com.java.uttara;

public class BSTNode {

	private BSTNode left,right;
	private int data,size;
	
	public BSTNode (int data){
		this.data=data;
	}
	
	public BSTNode getLeft() {
		return left;
	}
	public void setLeft(BSTNode left) {
		this.left = left;
	}
	public BSTNode getRight() {
		return right;
	}
	public void setRight(BSTNode right) {
		this.right = right;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public void setSize(int size){
		this.size = size;
	}
	public int getSize(){
		return size;
	}
}
