//测试AVL性能
//AVL增加删除需要额外操作去维护平衡,但是查找和更改性能更优
//查找和更改次数越多,性能优势越明显

import java.util.ArrayList;
import java.util.Collections;

public class RBTreeMapTest {
    public static void main(String[] args) {
        ArrayList<String> words  =new ArrayList<>();
        FileOperation.readFile("./pride-and-prejudice.txt",words );
        System.out.println("Total words : "+ words .size());

        //测试极端情况,BSTMap退化成链表,RBTreeMap依然稳定
        Collections.sort(words);

        RBTree<String,Integer> RBTreeMap = new RBTree<>();
        BSTMap<String,Integer> bstMap= new BSTMap<>();


        //测试RBtreeMap性能
        long startTime=System.nanoTime();

        for (String word :words){
            if (RBTreeMap.contains(word))
                RBTreeMap.set(word, RBTreeMap.get(word)+1);
            else
                RBTreeMap.add(word,1);
        }


        long endTime=System.nanoTime();
        double time=(endTime-startTime)/1000000000.0;
        System.out.println("RBTree Map time : "+ time+" s.");


        //测试BST 性能
        startTime=System.nanoTime();

        for (String word :words){
            if (bstMap.contains(word))
                bstMap.set(word, bstMap.get(word)+1);
            else
                bstMap.add(word,1);
        }

        endTime=System.nanoTime();
        time=(endTime-startTime)/1000000000.0;
        System.out.println("BST Map time : "+ time+" s.");

    }
}
