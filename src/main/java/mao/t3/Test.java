package mao.t3;

import java.util.ArrayList;
import java.util.List;

/**
 * Project name(项目名称)：java并发编程_线程安全
 * Package(包名): mao.t3
 * Class(类名): Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/28
 * Time(创建时间)： 13:46
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Test
{
    public void method1(int loopNumber)
    {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < loopNumber; i++)
        {
            add(list);
            sub(list);
        }
    }

    public void add(List<Integer> list)
    {
        list.add(1);
    }

    public void sub(List<Integer> list)
    {
        list.remove(0);
    }

    public static void main(String[] args)
    {
        Test t = new Test();
        Thread t1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                t.method1(500);
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                t.method1(500);
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}

class Test2 extends Test
{
    @Override
    public void sub(List<Integer> list)
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                list.remove(0);
            }
        }).start();
    }

    public static void main(String[] args)
    {
        Test2 t = new Test2();
        Thread t1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                t.method1(500);
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                t.method1(500);
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
