
public class MinHeapDemo {
	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap(15);
		minHeap.insert(15);	minHeap.insert(14);	minHeap.insert(1);	minHeap.insert(13);	
		minHeap.insert(11);	minHeap.insert(10);	minHeap.insert(7);	minHeap.insert(8);	
		minHeap.insert(12);	minHeap.insert(4);	minHeap.insert(2);	minHeap.insert(6);
		minHeap.insert(3);	minHeap.insert(9);	minHeap.insert(5);
		 minHeap.minHeap();
		 minHeap.print();
		System.out.println("The min val is " + minHeap.remove());
	}
}

class MinHeap {
	private int[] heap;
	private int size;
	private int maxSize;
	private static final int FRONT = 1;

	public MinHeap(int maxSize) {
		this.maxSize = maxSize;
		heap = new int[maxSize + 1];
		this.size = 0;
		heap[0] = Integer.MIN_VALUE;
	}

	private int getParent(int pos) {
		return pos / 2;
	}

	private int getLeftChild(int pos) {
		return 2 * pos + 1;
	}

	private int getRightChild(int pos) {
		return 2 * pos + 2;
	}

	private boolean isLeaf(int pos) {
		if (pos >= size / 2 || pos <= size)
			return true;
		return false;
	}

	private void swap(int fpos, int spos) {
		int temp = heap[spos];
		heap[spos] = heap[fpos];
		heap[fpos] = temp;
	}

	private void minHeapify(int pos) {
		if (!isLeaf(pos)) {
			if (heap[pos] > getLeftChild(pos) || heap[pos] > getRightChild(pos)) {
				if (getLeftChild(pos) < getRightChild(pos)) {
					swap(pos, getLeftChild(pos));
					minHeapify(getLeftChild(pos));
				} else {
					swap(pos, getRightChild(pos));
					minHeapify(getRightChild(pos));
				}
			}
		}
	}

	void insert(int element) {
		if (size >= maxSize)
			return;
		heap[++size] = element;
		int current = size;
		while (heap[current] < heap[getParent(current)]) {
			swap(current, getParent(current));
			current = getParent(current);
		}
	}

	void print() {
		for (int i = 0; i < size / 2; i++) {
			System.out.println("PARENT:" + heap[i]);
			System.out.println("LEFT CHILD:" + heap[2 * i + 1] + "<==========> RIGHT CHILD:" + heap[2 * i + 2]);
			System.out.println();
		}
	}

	void minHeap() {
		for (int pos = size / 2; pos >= 1; pos--) {
			minHeapify(pos);
		}
	}

	public int remove() {
		int popped = heap[FRONT];
		heap[FRONT] = heap[size--];
		minHeapify(FRONT);
		return popped;
	}
}
