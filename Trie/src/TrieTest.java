
public class TrieTest {

    public static void main(String[] args) {

        Trie trieSet=new Trie();
        trieSet.add("cater");
        trieSet.add("dog");
        trieSet.add("deer");
        trieSet.add("pan");
        trieSet.add("panda");

        System.out.println(trieSet.contains("cat"));
        System.out.println(trieSet.isPrefix("cat"));
        System.out.println(trieSet.contains("pan"));
        System.out.println(trieSet.isPrefix("pan"));
        System.out.println(trieSet.match("de.r"));
        System.out.println(trieSet.match("d..d"));

    }
}
