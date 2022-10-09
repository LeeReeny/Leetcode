import java.util.HashMap;

public class LRU {
    private DoubleList cache;
    private HashMap<Integer, Node> map; // 利用map快速定位是否存在该key
    private int cap;

    public LRU(int capacity) {
        cache = new DoubleList();
        map = new HashMap<>();
        this.cap = capacity;
    }

    public int get(int key) {
        // 不存在直接返回 -1；
        if (!map.containsKey(key)) {
            return -1;
        }
        // 存在的话，根据key在map中找到val，利用put(key, val)方法加入缓存
        int val = map.get(key).val;
        put(key, val);
        return val;
    }

    public void put(int key, int value) {
        // 如果存在key，把原来cache中的(key,val)删除，然后在cache的最前面加入(key,val)
        // 同时更新map
        Node newNode = new Node(key, value);
        if (map.containsKey(key)) {
            cache.remove(map.get(key));
            cache.addFirst(newNode);
            map.put(key, newNode);
        } else {
            // 不存在时要加入新的key和val
            // 首先要判断是否已经达到cap，如果满了的话就把最后的删了，同时也要在map中删除
            if (cache.size() == cap) {
                Node last = cache.pollLast();
                map.remove(last.key);
            }
            // 然后加到cache的最前面，并更新map
            cache.addFirst(newNode);
            map.put(key, newNode);
        }
    }
}

class Node {
    public int key, val;
    public Node next, pre;
    public Node (int k, int v) {
        this.key = k;
        this.val = v;
    }
}

class DoubleList {
    private Node head, tail;
    private int size;
    // 在链表前面添加节点
    public void addFirst(Node node) {
        if (head == null) {
            head = tail = node;
        } else {
            Node n = head;
            n.pre = node;
            node.next = n;
            head = node;
        }
        size++;
    }
    // 删除最后一个节点，并返回它
    public Node pollLast() {
        Node last = tail;
        remove(tail);
        return last;
    }
    // 删除某个节点
    public void remove(Node node) {
        if (head == node && tail == node) { // 只有一个节点
            head = tail = null;
        } else if (head == node) { // 要删的是第一个节点
            node.next.pre = null; // node的next就新的head，新head的pre要置为null
            head = node.next;
        } else if (tail == node) { // 要删的是最后一个节点
            node.pre.next = null;
            tail = node.pre;
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            node.next = null;
            node.pre = null;
        }
        size--;
    }
    //返回链表大小
    public int size() {
        return size;
    }
}

