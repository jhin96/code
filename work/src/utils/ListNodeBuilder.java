package utils;

import java.util.ArrayList;
import java.util.List;

public class ListNodeBuilder {

    public static ListNode build(int... array){
        if(array == null || array.length < 1){
            return null;
        }
        ListNode node = new ListNode(array[0]);
        ListNode res = node;
        for(int i = 1; i < array.length; i++){
            node.next = new ListNode(array[i]);
            node = node.next;
        }
        return res;
    }

    public static List node2List(ListNode node){
        if(node == null){
            return new ArrayList();
        }
        List<Integer> res = new ArrayList<>();
        while(node != null){
            res.add(node.val);
            node = node.next;
        }
        return res;
    }

}
