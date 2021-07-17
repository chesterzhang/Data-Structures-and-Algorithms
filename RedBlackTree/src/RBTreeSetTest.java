import java.util.ArrayList;
import java.util.Collections;

public class RBTreeSetTest {
    public static void main(String[] args) {
        ArrayList<String> words  =new ArrayList<>();
        FileOperation.readFile("./pride-and-prejudice.txt",words );
        System.out.println("Total words : "+ words .size());

        //测试极端情况,BSTSet退化成链表,RBTreeSet依然稳定
        Collections.sort(words);

        RBTreeSet<String> rbTreeSet= new RBTreeSet<>();
        BSTSet<String> bstSet= new BSTSet<>();


        //测试RBTree性能
        long startTime=System.nanoTime();

        for (String word :words){
            if (!rbTreeSet.contains(word))
                rbTreeSet.add(word );
        }


        long endTime=System.nanoTime();
        double time=(endTime-startTime)/1000000000.0;
        System.out.println("RBTree Set time : "+ time+" s.");


        //测试BST 性能
        startTime=System.nanoTime();

        for (String word :words){
            if (!bstSet.contains(word))
                bstSet.add(word );
        }

        endTime=System.nanoTime();
        time=(endTime-startTime)/1000000000.0;
        System.out.println("BST Set time : "+ time+" s.");

    }
}
