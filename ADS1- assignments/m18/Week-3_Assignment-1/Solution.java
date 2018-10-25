import java.util.Scanner;
import java.util.ArrayList;
class Stock implements Comparable<Stock> {
	private String name;
	private Double percentChange;
	Stock(String name1, Double percentChange1) {
		this.name = name1;
		this.percentChange = percentChange1;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name1) {
		this.name = name1;
	}
	public Double getpercentChange() {
		return this.percentChange;
	}
	public void setpercentChange(Double percentChange1) {
		this.percentChange = percentChange1;
	}
	public String print() {
		return this.name + " " + this.percentChange;
	}
	public int compareTo(final Stock other) {
		if (this.percentChange > other.percentChange) {
			return 1;
		} else if (this.percentChange < other.percentChange) {
			return -1;
		} else {
			return this.name.compareTo(other.name);
		}
	}
}

class Table {
	private String[] keys;
	private Integer[] data;
	private int size;
	public Table(final int n) {
		keys = new String[n];
		data = new Integer[n];
		size = 0;
	}
	public void put(final String key, final Integer value) {
		if (value == null) {
			delete(key);
			return;
		}
		int i = rank(key);
		if (i < size && keys[i].compareTo(key) == 0) {
			data[i] = value;
			return;
		}
		for (int j = size; j > i; j--) {
			keys[j] = keys[j - 1];
			data[j] = data[j - 1];
		}
		keys[i] = key;
		data[i] = value;
		size++;
	}
	public boolean contains(final String key) {
		return get(key) != null;
	}
	public String max() {
		return keys[size - 1];
	}
	public int rank(final String key) {
		int low = 0;
		int high = size - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int cmp = key.compareTo(keys[mid]);
			if (cmp < 0) {
				high = mid - 1;
			} else if (cmp > 0) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return low;
	}
	public Integer get(final String key) {
		if (size == 0) {
			return null;
		}
		int i = rank(key);
		if (i < size && keys[i].compareTo(key) == 0) {
			return data[i];
		}
		return null;
	}

	public void delete(final String key) {
		if (size == 0) {
			return;
		}
		int i = rank(key);
		if (i == size || keys[i].compareTo(key) != 0) {
			return;
		}
		int j;
		for (j = i; j < size - 1; j++) {
			keys[j] = keys[j + 1];
			data[j] = data[j + 1];
		}
		size--;
		keys[j] = null;
		data[j] = null;
	}
	public void deleteMin() {
		delete(keys[0]);
	}
	public String[] keys() {
		String[] a = new String[size];
		int k = 0;
		for (int i = 0; i < size; i++) {
			if (data[i] != null) {
				a[k++] = keys[i];
			}
		}
		return a;
	}
	public String floor(final String key) {
		int i = rank(key);
		if (i < size && key.compareTo(keys[i]) == 0) {
			return keys[i];
		}
		if (i == 0) {
			return null;
		}
		return keys[i - 1];
	}
	public void print() {
		for (int i = 0; i < size; i++) {
			System.out.println(keys[i] + "         " + data[i]);
		}
	}
}

class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int count = Integer.parseInt(s.nextLine());
		Table worstList = new Table(count);
		Table bestList = new Table(count);
		for (int i = 0; i < 6; i++) {
			MinPQ<Stock> min = new MinPQ<Stock>();
			MaxPQ<Stock> max = new MaxPQ<Stock>();
			for (int j = 0; j < count; j++) {
				String[] tokens = s.nextLine().split(",");
				max.insert(new Stock(tokens[0], Double.parseDouble(tokens[1])));
				min.insert(new Stock(tokens[0], Double.parseDouble(tokens[1])));
			}
			for(int j=5;j>0;j--) {
				Stock a = max.delMax();
				System.out.println(a.print());
				Integer val = bestList.get(a.getName());
				if (val == null) {
					bestList.put(a.getName(), 1);
				} else {
					bestList.put(a.getName(), 1 + val);
				}
			}
			System.out.println();
			for(int j=5;j>0;j--) {
				Stock a = min.delMin();
				System.out.println(a.print());
				Integer val = worstList.get(a.getName());
				if (val == null) {
					worstList.put(a.getName(), 1);
				} else {
					worstList.put(a.getName(), 1+val);
				}
			}
			System.out.println();
		}
		int query = Integer.parseInt(s.nextLine());
		for (int i = 0; i < query; i++) {
			String tokens[] = s.nextLine().split(",");
			if (tokens[0].equals("get")) {
				if (tokens[1].equals("maxST")) {
					Integer a = bestList.get(tokens[2]);
					if (a == null) {
						System.out.println("0");
					} else {
						System.out.println(a);
					}
				} else {
					Integer a = worstList.get(tokens[2]);
					if (a == null) {
						System.out.println("0");
					} else {
						System.out.println(a);
					}
				}
			} else {
				String[] keys = bestList.keys();
				for (String list : keys) {
					if (worstList.contains(list)) {
						System.out.println(list);
					}
				}
			}
		}
	}
}