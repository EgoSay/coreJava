package ninth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author codeAC
 * @date 2018/3/19 18:59
 */
public class ReverseIterator {
    public static void main(String [] args)
    {
        ReversibleArrayList<String> ral = new ReversibleArrayList<String>(Arrays.asList("To be or not to be".split(" ")));

        for(String s : ral) {
            System.out.print(s + " ");
        }
        System.out.println();
        //向前遍历
        for(String s : ral.reversed()) {
            System.out.print(s + " ");
        }
    }

}
class ReversibleArrayList<T> extends ArrayList<T>
{

    public ReversibleArrayList(Collection<T> c) { super(c);   }

    public Iterable<T> reversed()
    {
        //第一个匿名的内部类
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator()
            //Iterable里面的必须实现的方法
            {
                return new Iterator<T>()
                        //返回值是第二个匿名内部类
                {
                    int current = size() - 1;
                    //这个size是ArrayList里面的函数，继承过来的

                    @Override
                    public boolean hasNext()
                    {
                        return current > -1;
                    }

                    @Override
                    public T next()
                    {
                        return get(current--);
                        //这个是向前推进的
                    }

                    @Override
                    public void remove()
                    {
                        throw new UnsupportedOperationException();
                    }

                };

            }

        };
    }

}

