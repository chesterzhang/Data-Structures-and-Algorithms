public class SortingHelper {
    private  SortingHelper(){}

    public static <T extends Comparable<T>> boolean isSorted(T[] arr){
        for (int i = 1; i < arr.length; i++) {
            if(arr[i-1].compareTo(arr[i])>0){
                return  false;
            }
        }
        return true;
    }

    public static <T extends Comparable<T>> void sortTest(String sortName, T[] arr, int n){

        long startTime=System.nanoTime();
        if (sortName.equals("MergeSort")){
            MergeSort.sort(arr);
        } else if (sortName.equals("QuickSortOneWay")){
            QuickSort.sortOneWay(arr);
        } else if (sortName.equals("QuickSortTwoWays")){
            QuickSort.sortTwoWays(arr);
        }else if (sortName.equals("QuickSortThreeWays")){
            QuickSort.sortThreeWays(arr);
        }

        long endTime=System.nanoTime();
        double time=endTime-startTime;
        if (SortingHelper.isSorted(arr)){
            System.out.println("n="+n+" ,"+sortName+"花费时间"+time/1000000000.0+"秒");
        }else{
            throw new RuntimeException(sortName+" failed !");
        }
    }

}
