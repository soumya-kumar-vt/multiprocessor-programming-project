package concurrent_tree;

import java.util.concurrent.locks.ReentrantLock;

/**
 * LockableNode Class
 * 
 * Extends the basic Node class used for fine-grained locking.
 *
 */
public class LockableNode<T> {
	
	public T data;
	public ReentrantLock lock;
	public LockableNode<T> left;
	public LockableNode<T> right;
	public int height;
	public long Throughput;
	
	/**
	 * Instantiates a LockableNode object.
	 */

	public LockableNode(T data) {
		this.data = data;
		left = null;
		right = null;
		lock = new ReentrantLock();
        this.height=height;
	}
	
	/**
	 * Locking the LockableNode's lock.
	 */
	public void lock() {
		lock.lock();
		Throughput=Throughput+1;
	}
	
	/**
	 * Convenience method to unlock the LockableNode's lock.
	 */
	public void unlock() {
		lock.unlock();
	}
}
