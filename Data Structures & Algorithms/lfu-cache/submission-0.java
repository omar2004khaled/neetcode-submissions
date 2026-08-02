
class LFUCache {

    class Node {
        int key;
        int value;
        int freq;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DoublyList {
        Node head;
        Node tail;
        int size;

        DoublyList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void add(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast() {
            if (size == 0) return null;
            Node node = tail.prev;
            remove(node);
            return node;
        }
    }

    int capacity;
    int size;
    int minFreq;

    HashMap<Integer, Node> map;
    HashMap<Integer, DoublyList> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.minFreq = 0;
        map = new HashMap<>();
        freqMap = new HashMap<>();
    }

    private void update(Node node) {
        int freq = node.freq;
        DoublyList list = freqMap.get(freq);
        list.remove(node);

        if (freq == minFreq && list.size == 0) {
            minFreq++;
        }

        node.freq++;

        DoublyList newList = freqMap.get(node.freq);
        if (newList == null) {
            newList = new DoublyList();
            freqMap.put(node.freq, newList);
        }
        newList.add(node);
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        update(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            update(node);
            return;
        }

        if (size == capacity) {
            DoublyList list = freqMap.get(minFreq);
            Node remove = list.removeLast();
            map.remove(remove.key);
            size--;
        }

        Node node = new Node(key, value);

        DoublyList list = freqMap.get(1);
        if (list == null) {
            list = new DoublyList();
            freqMap.put(1, list);
        }

        list.add(node);
        map.put(key, node);
        minFreq = 1;
        size++;
    }
}