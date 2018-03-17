package eighth;

import org.jetbrains.annotations.Contract;
/**
 * @author codeAC
 * @date 2018/3/15 11:52
 */
public class ArrayAlg {
    @Contract(pure = true)
    public static <T> T getMiddle(T... a){
        return a[a.length/2];
    }

    public static <T extends Comparable> T min(T[] a){
        if(a == null || a.length == 0) {
            return null;
        }
        T smallest = a[0];
        for(int i = 1;i < a.length;i++){
            if(smallest.compareTo(a[i])>0){
                smallest = a[i];
            }
        }
        return smallest;
    }

    public static void main(String[] args) {
        String middle=ArrayAlg.getMiddle("jone","a","Public","da");
        Double mid=ArrayAlg.getMiddle(3.14,5.9,0.8,9.6,7.8);
        System.out.println(middle);
        System.out.println(mid);
    }
}
