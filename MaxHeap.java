import java.util.Arrays;

public class MaxHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        heap = new int[capacity];
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    public void insert(int element) {
        if (size >= capacity) {
            throw new IndexOutOfBoundsException("Heap is full");
        }
        heap[size] = element;
        size++;
        heapifyUp(size - 1);
        System.out.println("Inserted: " + element);
    }

    private void heapifyUp(int index) {
        while (index > 0 && heap[parent(index)] < heap[index]) {
            swap(parent(index), index);
            index = parent(index);
        }
    }

    public int remove() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        System.out.println("Removed Max: " + max);
        return max;
    }

    private void heapifyDown(int index) {
        int largest = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }
        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }
        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    public void printHeap() {
        System.out.println(Arrays.toString(Arrays.copyOf(heap, size)));
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(3);
        maxHeap.insert(1);
        maxHeap.insert(6);
        maxHeap.insert(5);
        maxHeap.insert(2);
        maxHeap.insert(4);
        
        maxHeap.printHeap();
        maxHeap.remove();
        maxHeap.printHeap();
    }
}
