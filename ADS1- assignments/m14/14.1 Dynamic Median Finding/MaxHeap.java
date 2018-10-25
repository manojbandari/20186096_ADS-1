import java.util.Comparator;
/**
 * Class for maximum heap.
 *
 * @param      <Key>  The key
 */
class MaxHeap<Key> {
	/**
	 * array hp.
	 */
	public Key[] hp;
	/**
	 * size.
	 */
	public int size;
	/**
	 * comparator.
	 */
	public Comparator<Key> comparator;
	/**
	 * Constructs the object.
	 *
	 * @param      sz    The size
	 */
	public MaxHeap(int sz) {
		hp = (Key[]) new Object[sz + 1];
		size = 0;
	}
	/**
	 * Constructs the object.
	 */
	public MaxHeap() {
		this(1);
	}
	/**
	 * size of the array.
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int getsize() {
		return size;
	}
	/**
	 * insert into the array.
	 *
	 * @param      k     { parameter_description }
	 */
	public void insertMax(Key k) {
		if (size == hp.length - 1) {
			resize(2 * hp.length);
		}
		hp[++size] = k;
		swimMax(size);
	}
	/**
	 * { function_description }
	 *
	 * @param      ind   The ind
	 */
	public void swimMax(int ind) {
		while (ind > 1 && minHP(ind / 2, ind)) { //ind is child and ind/2 is parent.
			swap(ind, ind / 2); //exchange parent with child when parent is less than child.
			ind = ind / 2;
		}
	}
	/**
	 * { function_description }
	 *
	 * @param      i     { parameter_description }
	 * @param      j     { parameter_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public boolean minHP(int i, int j) {
		if (comparator == null) {
			return  ((Comparable<Key>) hp[i]).compareTo(hp[j]) < 0;
		} else {
			return comparator.compare(hp[i], hp[j]) < 0;
		}
	}
	/**
	 * Gets the maximum.
	 *
	 * @return     The maximum.
	 */
	public Key getMax() {
		return hp[1];
	}
	/**
	 * { function_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public Key delMax() {
		Key max = hp[1];
		swap(1, size--);
		sinkMax(1);
		hp[size + 1] = null;
		if ((size > 0) && (size == (hp.length - 1) / 4)) {
			resize(hp.length / 2);
		}
		return max;
	}
	/**
	 * { function_description }
	 *
	 * @param      a     { parameter_description }
	 */
	public void sinkMax(int a) {
		while (2 * a <= size) {
			int j = 2 * a;
			if (j < size && minHP(j, j + 1)) {
				j++;
			}
			swap(a, j);
			a = j;
		}
	}
	public void resize(int newsize) {
		Key[] temp = (Key[]) new Object[newsize];
		for (int i = 1; i <= size; i++) {
			temp[i] = hp[i];
		}
		hp = temp;
	}
	public void swap(int i, int j) {
		Key temp = hp[i];
		hp[i] = hp[j];
		hp[j] = temp;
	}
	public void show() {
		for (int i = 1; i < size + 1; i++) {
			System.out.print(hp[i] + " ");
		}
		System.out.println();
	}
}