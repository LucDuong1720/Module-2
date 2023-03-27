import java.util.LinkedList;
    public class GenericQueue<E> {
        private LinkedList<E> elements;

        public GenericQueue() {
            elements = new LinkedList<>();
        }

        public void enqueue(E e) {
            elements.addLast(e);
        }

        public E dequeue() {
            return elements.removeFirst();
        }

        public int getSize() {
            return elements.size();
        }

        public boolean isEmpty() {
            return elements.size() == 0;
        }

        public static void main(String[] args) {
            GenericQueue<String>
            queue = new GenericQueue<>();
            queue.enqueue("America");
            queue.enqueue("Canada");
            queue.enqueue("France");
            queue.dequeue();
            while (!queue.isEmpty()) {
                System.out.println(queue.dequeue());
            }
        }
    }
