package mao.t1;

import java.util.ArrayList;
import java.util.List;

/**
 * Project name(项目名称)：java并发编程_线程安全
 * Package(包名): mao.t1
 * Class(类名): Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/28
 * Time(创建时间)： 13:18
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Test
{
    private final List<Integer> list = new ArrayList<>();

    public void method1(int loopNumber)
    {
        for (int i = 0; i < loopNumber; i++)
        {
            add();
            sub();
        }
    }

    private void add()
    {
        list.add(1);
    }

    private void sub()
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
