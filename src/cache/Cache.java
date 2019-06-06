package cache;

/**
 * @author shashank.mittal
 * @created Jun 6, 2019
 * 
 */
public interface Cache<T> {
	boolean contains(T item);

	T get(T item);

	void display();

}
