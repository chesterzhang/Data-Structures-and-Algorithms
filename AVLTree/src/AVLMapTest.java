//测试AVL性能
//AVL增加删除需要额外操作去维护平衡,但是查找和更改性能更优
//查找和更改次数越多,性能优势越明显
import java.util.ArrayList;

import java.util.Collections;

public class AVLMapTest {
    public static void main(String[] args) {
        ArrayList<String> words  =new ArrayList<>();
        FileOperation.readFile("./pride-and-prejudice.txt",words );
        System.out.println("Total words : "+ words .size());

        //测试极端情况,BSTMap退化成链表,AVLMap依然稳定
        Collections.sort(words);

        AVLMap<String,Integer> avlMap = new AVLMap<>();
        BSTMap<String,Integer> bstMap= new BSTMap<>();


        //测试AVL性能
        long startTime=System.nanoTime();

        for (String word :words){
            if (avlMap.contains(word))
                avlMap.set(word, avlMap.get(word)+1);
            else
                avlMap.add(word,1);
        }

        for (String word :words){
           avlMap.remove(word);
        }



        long endTime=System.nanoTime();
        double time=(endTime-startTime)/1000000000.0;
        System.out.println("AVL Map time : "+ time+" s.");


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
