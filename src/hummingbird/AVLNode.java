package hummingbird;

public class AVLNode {

	private int key;
	private int bf;
	private AVLNode right;
	private AVLNode left;
	private AVLNode	parent;
	
	public AVLNode(int id) {
		this.key = id;
		this.bf = -1;
		this.right = null;
		this.left = null;
		
	}

	/**
	 * @return the id
	 */
	public int getKey() {
		return key;
	}

	/**
	 * @param id the id to set
	 */
	public void setKey(int k) {
		this.key = k;
	}

	/**
	 * @return the bf
	 */
	public int getBf() {
		return bf;
	}

	/**
	 * @param bf the bf to set
	 */
	public void setBf(int bf) {
		this.bf = bf;
	}

	/**
	 * @return the right
	 */
	public AVLNode getRight() {
		return right;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(AVLNode right) {
		this.right = right;
	}

	/**
	 * @return the left
	 */
	public AVLNode getLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(AVLNode left) {
		this.left = left;
	}

	/**
	 * @return the parent
	 */
	public AVLNode getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(AVLNode parent) {
		this.parent = parent;
	}
	

}
