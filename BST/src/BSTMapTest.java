//测试BSTMap性能

import java.util.ArrayList;
import java.util.Collections;

public class BSTMapTest {
    public static void main(String[] args) {
        ArrayList<String> words  =new ArrayList<>();
        FileOperation.readFile("./pride-and-prejudice.txt",words );
        System.out.println("Total words : "+ words .size());

        //测试极端情况,BSTMap退化成链表
        //Collections.sort(words);


        BSTMap<String,Integer> bstMap= new BSTMap<>();

        //测试BST 性能
        long startTime=System.nanoTime();

        for (String word :words){
            if (bstMap.contains(word))
                bstMap.set(word, bstMap.get(word)+1);
            else
                bstMap.add(word,1);
        }

        long endTime=System.nanoTime();
        double time=(endTime-startTime)/1000000000.0;
        System.out.println("BST Map time : "+ time+" s.");

    }
}
