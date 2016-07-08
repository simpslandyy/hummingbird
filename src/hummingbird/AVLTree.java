package hummingbird;


public class AVLTree {
	protected AVLNode master;
	
	public AVLTree() {
		this.master = null;
	}

	public void insert(AVLNode item, AVLNode root) {
		// If the AVL tree is empty, then there will be no children (root) to compare
		// So set the master of the tree to be the item to be inserted, and change the bf to 0.
		if (root == null && this.master == null) {
			this.master = item;
			this.master.setBf(0);
			return;
		}
		
		// If the item.key has a greater value than root.key
		if (item.getKey() > root.getKey()) {
			// if the root doesn't have a right child, insert the item as it's right child
			if (root.getRight() == null) {
				root.setRight(item);
				item.setParent(root);
				
				this.bubbleUp(item);
				
			} else {
				// if the root has a right child, call this function again
				insert(item, root.getRight());
			}
			
		// If the item.key has a lesser or equal value than the root.key
		} else if (item.getKey() <= root.getKey()) {
			// if the root doesn't have a left child, insert the item as it's left child
			if (root.getLeft() == null) {
				root.setLeft(item);
				item.setParent(root);
				
				this.bubbleUp(item);
				
				// if the root has a right child, call this function again
			} else {
				insert(item, root.getLeft());
			}
		}
	}
	
	private void bubbleUp(AVLNode root) {
		root = this.fixBF(root);
		
		if (root.getBf() == -2) {
			AVLNode left;
			left = root.getLeft();
			
			if (getHeight(left.getLeft()) >= getHeight(left.getRight())) {
				root = this.rotateRight(root);
			} else {
//				root = this.rotateLeftRight();
			}
		} else if (root.getBf() == 2) {
			AVLNode right;
			right = root.getRight();
			
			if (getHeight(right.getRight()) >= getHeight(right.getLeft())) {
				root = this.rotateLeft(root);
			} else {
//				root = this.rotateRightLeft();
			}
		}
		
		if (root.getParent() != null) {
			this.bubbleUp(root.getParent());
		} else {
			// Once everything has been rebalanced it's possible that the master of the tree has changed
			// To be safe, set whatever root is as the master of the tree once you're done rebalancing.
			this.master = root;
		}
		
	}

	private AVLNode fixBF(AVLNode item) {
		AVLNode left, right;
		left = item.getLeft();
		right = item.getRight();
		
		if (left != null && right != null) {
			int heightL = getHeight(left);
			int heightR = getHeight(right);
			
			item.setBf(heightR - heightL);
			
		} else if (left == null && right == null) {
			item.setBf(0);
		} else if (left == null) {
			item.setBf(1);
		}
		// Since the bf of a node is default -1, we don't have to set the bf if right child is null.
		
		return item;
	}
	
	private int getHeight(AVLNode item) {
		
		// If no children exists for the current node, then the height is 0
		if (item.getLeft() == null && item.getRight() == null) {
			return 0;
			
		// If no children exists for the left or the right side, then get the height of the opposite side + 1
		} else if (item.getLeft() == null) {
			return 1 + getHeight(item.getRight());
			
		} else if (item.getRight() == null) {
			return 1 + getHeight(item.getLeft());
			
		// If children exists for both sides, then get the subtree that has the most edges between its children
		} else {
			return 1 + Math.max(getHeight(item.getLeft()), getHeight(item.getRight()));
		}
		
	}
	
	private AVLNode rotateLeft(AVLNode head) {
		AVLNode old, lChild;
		// Head will be replaced by it's left child & it's left child will recognize it's grandparent as it's new parent
		old = head;
		head = old.getLeft();
		head.setParent(old.getParent());
		
		// If the new head has a left child, old will adopt it as it's right child
		if ((lChild = head.getLeft()) != null) {
			old.setRight(lChild);
			lChild.setParent(old);
		}
		
		// The new head will adopt old head as a left child
		head.setLeft(old);
		old.setParent(head);
		
		// Fix the balance factor!
		old = fixBF(old);
		head = fixBF(head);
		
		// Return the new head!
		return head;
		
	}
	
	private AVLNode rotateRight(AVLNode head) {
		AVLNode old, rChild;
		
		// Head will be replaced by it's right child & it's right child will recognize it's grandparent as it's new parent
		old = head;
		head = old.getRight();
		head.setParent(old.getParent());

		// If the new head has a right child, old will adopt it as it's left child
		if ((rChild = head.getRight()) != null) {
			old.setLeft(rChild);
			rChild.setParent(old);
		}
		
		// The new head will adopt old head as a right child
		head.setRight(old);
		old.setParent(head);
		
		// Fix the balance factor!
		old = fixBF(old);
		head = fixBF(head);
		
		// Return the new head!
		return head;
		
	}
	
	private AVLNode rotateLeftRight(AVLNode head) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private AVLNode rotateRightLeft(AVLNode head) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
