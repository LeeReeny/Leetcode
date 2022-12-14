public class MinStack_Offer30 {

    public class MinStack{
        private class Node{
            int val;
            int min_val;
            Node next;

            public Node(int val, int min_val, Node next){
                this.val = val;
                this.min_val = min_val;
                this.next = next;
            }
        }

        private Node head;

        public MinStack(){};

        public void push(int x){
            if(head == null) head = new Node(x, x, null);
            else head = new Node(x, Math.min(x, head.min_val), head);
        }

        public void pop(){ head = head.next;}

        public int top(){ return head.val;}

        public int min(){ return head.min_val;}
    }


}
