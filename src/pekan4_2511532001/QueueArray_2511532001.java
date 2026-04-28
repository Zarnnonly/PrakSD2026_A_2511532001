package pekan4_2511532001;

public class QueueArray_2511532001 {
	int front_2001, rear_2001, size_2001;
	int capacity_2001;
	int array_2001[];
	
	public QueueArray_2511532001 (int capacity_2001) {
		this.capacity_2001 = capacity_2001;
		front_2001 = this.size_2001 = 0;
		rear_2001 = capacity_2001 - 1;
		array_2001 = new int [this.capacity_2001];
	}
	
	boolean isFull_2001(QueueArray_2511532001 queue_2001) {
		return (queue_2001.size_2001 == queue_2001.capacity_2001);
	}
	boolean isEmpty_2001(QueueArray_2511532001 queue_2001) {
		return (queue_2001.size_2001 == 0);
	}
	
	void enqueue_2001(int item_2001) {
		if (isFull_2001(this))
			return;
		this.rear_2001 = (this.rear_2001 + 1) % this.capacity_2001;
		this.array_2001 [this.rear_2001] = item_2001;
		this.size_2001 = this.size_2001 + 1;
		System.out.println(item_2001 + " enqueued to queue");
	}
	
	int dequeue_2001() {
		if(isEmpty_2001(this))
			return Integer.MAX_VALUE;
		int item_2001 = this.array_2001[this.front_2001];
		this.front_2001 = (this.front_2001 + 1) % this.capacity_2001;
		this.size_2001 = this.size_2001 -1;
		return item_2001;
	}
	int front_2001() {
		if (isEmpty_2001(this))
			return Integer.MIN_VALUE;
		return this.array_2001[this.front_2001];

	}
	
	int rear_2001() {
		if (isEmpty_2001(this))
			return Integer.MIN_VALUE;
		return this.array_2001[this.rear_2001];
	}
	
	// mencetak
	void display() {
		int i;
		if (front_2001 == rear_2001) {
			System.out.printf("\nAntrian Kosong\n");
			return;
	}
	// kunjungi dari belakang dan cetak
	for (i = front_2001; i < rear_2001; i++) {
		System.out.printf(" %d <--", array_2001[i]);
	}
	return;
		
	}
}