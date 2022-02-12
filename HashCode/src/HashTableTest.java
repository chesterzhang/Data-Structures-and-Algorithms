import java.util.ArrayList;
import java.util.Collections;

public class HashTableTest {
    public static void main(String[] args) {
        ArrayList<String> words  =new ArrayList<>();
        FileOperation.readFile("./pride-and-prejudice.txt",words );
        System.out.println("Total words : "+ words .size());

        //测试极端情况,BSTMap退化成链表,AVLMap，RBTreeMap, HashTable依然稳定
        //Collections.sort(words);

        AVLMap<String,Integer> avlMap = new AVLMap<>();
        BSTMap<String,Integer> bstMap= new BSTMap<>();
        RBTree<String,Integer> RBTreeMap = new RBTree<>();
        HashTable<String,Integer> ht =new HashTable<>(words .size());

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


        //测试AVL性能
        startTime=System.nanoTime();

        for (String word :words){
            if (avlMap.contains(word))
                avlMap.set(word, avlMap.get(word)+1);
            else
                avlMap.add(word,1);
        }

        endTime=System.nanoTime();
        time=(endTime-startTime)/1000000000.0;
        System.out.println("AVL Map time : "+ time+" s.");


        //测试RBtreeMap性能
        startTime=System.nanoTime();

        for (String word :words){
            if (RBTreeMap.contains(word))
                RBTreeMap.set(word, RBTreeMap.get(word)+1);
            else
                RBTreeMap.add(word,1);
        }

        endTime=System.nanoTime();
        time=(endTime-startTime)/1000000000.0;
        System.out.println("RBTreeMap time : "+ time+" s.");

        //测试HashTable性能
        startTime=System.nanoTime();

        for (String word :words){
            if (ht.contains(word))
                ht.set(word, RBTreeMap.get(word)+1);
            else
                ht.add(word,1);
        }

        endTime=System.nanoTime();
        time=(endTime-startTime)/1000000000.0;
        System.out.println("HashTable time : "+ time+" s.");

    }
}
