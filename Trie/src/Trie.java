
import java.util.TreeMap;

public class Trie {

    private class  Node{

        public  boolean isWord;

        public TreeMap<Character, Node> next;

        public Node(boolean isWord ) {
            this.isWord = isWord;
            next = new TreeMap<Character, Node>();
        }

        public Node(  ) {
            this(false);
        }

    }

    private  Node root;
    private int size;

    public Trie(){
        root=new Node();
        size=0;
    }

    public int getSize(){
        return size;
    }

    public void add(String word){
        Node cur = root;

        for(int i =0; i< word.length(); i++){
            char c= word.charAt(i);
            if (cur.next.get(c)==null){
                cur.next.put(c, new Node());
            }
            cur=cur.next.get(c);
        }

        if (!cur.isWord){
            cur.isWord=true;
            size++;
        }
    }

    public boolean contains(String word){
        Node cur = root;
        for(int i =0; i< word.length(); i++){
            char c= word.charAt(i);
            if (cur.next.get(c)==null){
                return false;
            }
            cur=cur.next.get(c);
        }

        return  cur.isWord;

    }

    public boolean isPrefix(String prefix){
        Node cur = root;
        for(int i =0; i< prefix.length(); i++){
            char c= prefix.charAt(i);
            if (cur.next.get(c)==null){
                return false;
            }
            cur=cur.next.get(c);
        }

        return  true;
    }

    public boolean match(String word){
        return match(root,word,0);
    }

    private boolean match(Node node, String word, int depth){
        if (depth==word.length()){
            return node.isWord;
        }

        char c=word.charAt(depth);
        if (c!='.'){
            if (node.next.get(c)==null){
                return  false;
            }else{
                return match(node.next.get(c),word,depth+1);
            }
        }else {
            for (char nextChar : node.next.keySet()){
                return match(node.next.get(nextChar),word,depth+1);
            }
            return false;
        }
    }


}
