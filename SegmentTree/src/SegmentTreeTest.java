public class SegmentTreeTest {

    public static void main(String[] args) {
        Integer[] nums={-2,0,3,-5,2,-1};
        SegmentTree<Integer> segTree=new SegmentTree<>(nums, new IMerger<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a+b;
            }
        });
        System.out.println(segTree);

        segTree.set(2,6);
        System.out.println(segTree);
    }
}
