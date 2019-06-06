package cache;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author shashank.mittal
 * @created Jun 6, 2019
 * 
 */
public class LruCacheImpl implements Cache<Integer> {

	private Deque<Integer> queue;
	private HashSet<Integer> map;
	private int capacity;

	public LruCacheImpl(int capacity) {
		super();
		queue = new LinkedList<Integer>();
		map = new HashSet<Integer>();
		this.capacity = capacity;
	}

	public LruCacheImpl() {
		super();
		queue = new LinkedList<Integer>();
		map = new HashSet<Integer>();
	}

	@Override
	public boolean contains(Integer item) {
		return containsKey(item);
	}

	@Override
	public Integer get(Integer item) {
		if (containsKey(item)) {
			queue.removeLastOccurrence(item);
		} else if (queue.size() == capacity) {
			queue.removeLast();
		}
		map.add(item);
		queue.addFirst(item);
		return item;
	}

	@Override
	public void display() {
		System.out.println(queue);
	}

	private boolean containsKey(Integer item) {
		return map.contains(item);
	}

	public static void main(String[] args) {
		Cache<Integer> ca = new LruCacheImpl(4);
		ca.get(1);
		ca.display();
		ca.get(2);
		ca.display();
		ca.get(3);
		ca.display();
		ca.get(1);
		ca.display();
		ca.get(4);
		ca.display();
		ca.get(5);
		ca.display();
	}

}
