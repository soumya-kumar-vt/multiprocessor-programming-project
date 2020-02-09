package concurrent_tree;

/**
 * Node Class
 * 
 * Implements the basic node needed to wrap data objects for manipulation in
 * the sequential binary tree.
 *
 */
public class Node<T> {

	public T data;
	public Node<T> left;
	public Node<T> right;
	

	public Node(T data) {
		this.data = data;
		left = null;
		right = null;
	}
}
