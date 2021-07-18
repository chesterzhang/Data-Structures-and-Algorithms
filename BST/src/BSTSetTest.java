import java.util.ArrayList;
import java.util.Collections;

public class BSTSetTest {
    public static void main(String[] args) {
        ArrayList<String> words  =new ArrayList<>();
        FileOperation.readFile("./pride-and-prejudice.txt",words );
        System.out.println("Total words : "+ words .size());

        //测试极端情况,BSTSet退化成链表
        //Collections.sort(words);

        BSTSet<String> bstSet=new BSTSet<>();

        //测试BST 性能
        long startTime=System.nanoTime();

        for (String word :words){
            if (!bstSet.contains(word))
                bstSet.add(word );
        }

        long endTime=System.nanoTime();
        double time=(endTime-startTime)/1000000000.0;
        System.out.println("BST Set time : "+ time+" s.");

    }
}
