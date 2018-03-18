package eighth;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author codeAC
 * @date 2018/3/17 15:01
 */
//
public class PairArray extends Pair {

    public static <T> void addAll(Collection<T> collection, T... ts){
        for (T t : ts){
            collection.add(t);
        }
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
//        Pair<String>[] table = new Pair<String>[10]; //不能创建参数化类型的数组
//        Pair<String>[] table=(Pair<String>[]) new Pair<?>[10];
        Collection<Pair<String>> table2 = new ArrayList<>();
        Pair<String> pair1 = new Pair<>("sa","dsd");
        Pair<String> pair2 = new Pair<>("rz","dc");
        Pair<String> p = Pair.makePair(String.class);
        addAll(table2,pair1,pair2);
        System.out.println(table2.size());
    }

}
