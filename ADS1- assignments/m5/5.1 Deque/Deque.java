class Deque {
    LinkedList deque;
    Deque() {
        deque = new LinkedList();
    }
    public void addAtStart(int item) {
        deque.pushAtStart(item);
    }
    public void addAtEnd(int item) {
        deque.pushAtEnd(item);
    }
    public void removeAtStart() {
        deque.popAtStart();
    }
    public boolean isempty() {
        return deque.isEmpty();
    }
    public void removeAtEnd() {
        deque.popAtEnd();
    }
    public int size() {
        return deque.size();
    }
    public String display() {
        return deque.displayAll();
    }
}