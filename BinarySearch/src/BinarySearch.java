public class BinarySearch {

    private BinarySearch(){}

    //二分查找的非递归写法
    public static <T extends Comparable<T>>int search(T[] data, T target){
        int l=0,r=data.length-1;

        while (l<=r){
            int mid=l+(r-l)/2;

            if (target.compareTo(data[mid])==0) {
                return mid;
            }

            if (target.compareTo(data[mid])<0){
                r=mid-1;
            }else {
                   l=mid+1;
            }

        }
        return  -1;
    }




    //二分查找的递归写法
    public static <T extends Comparable<T>>int searchR(T[] data, T target){
        return  searchR(data,0,data.length-1,target);
    }

    //二分查找的递归写法
    public static <T extends Comparable<T>>int searchR(T[] data,int l,int r, T target){
        if (l>r){
            return  -1;
        }

        int mid=l+(r-l)/2;

        if (data[mid].compareTo(target)==0){
            return mid;
        }

        int idx1,idx2;
        if (target.compareTo(data[mid])<0){
            idx1=searchR(data,l,mid-1,target);
            if (idx1!=-1){
                return idx1;
            }
        }else {
            idx2=searchR(data,mid+1,r,target);
            if (idx2!=-1){
                return idx2;
            }
        }
        return -1;

    }

}

