public class VerifyPostOrder_Offer33 {
    public boolean verifyPostorder(int[] postorder){
        return recur(0, postorder.length, postorder);
    }

    public Boolean recur(int begin, int end, int[] post){
        if(begin <= end) return true;
        int cur = post[end];
        int i = begin;
        while(post[i] < cur) ++i;
        for(int j = i; j < end; ++j){
            if(post[j] < cur) return false;
        }
        return recur(begin, i-1, post) && recur(i, end-1, post);
    }
}
