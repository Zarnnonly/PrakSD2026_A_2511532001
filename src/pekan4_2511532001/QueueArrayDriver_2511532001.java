package pekan4_2511532001;

public class QueueArrayDriver_2511532001 {

    public static void main(String[] args) {
        QueueArray_2511532001 queue_2001 = new QueueArray_2511532001(1000);
        queue_2001.enqueue_2001(10);
        queue_2001.enqueue_2001(20);
        queue_2001.enqueue_2001(30);
        queue_2001.enqueue_2001(40);
        System.out.println("Item di depan " + queue_2001.front_2001());
        System.out.println("Item paling belakang " + queue_2001.rear_2001());
        System.out.println("tampilan queue");
        queue_2001.display();
        System.out.println();
        System.out.println(queue_2001.dequeue_2001() + " dihapus dari queue");
        System.out.println("Item di depan " + queue_2001.front_2001());
        System.out.println("Item dibelakang " + queue_2001.rear_2001());
        System.out.println("tampilan queue setelah satu data dihapus");
        queue_2001.display();
    }
}