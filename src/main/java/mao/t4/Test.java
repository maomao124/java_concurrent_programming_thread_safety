package mao.t4;

import java.util.Hashtable;

/**
 * Project name(项目名称)：java并发编程_线程安全
 * Package(包名): mao.t4
 * Class(类名): Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/29
 * Time(创建时间)： 19:54
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Test
{
    private static final Hashtable<String, String> hashtable = new Hashtable<>();

    public static void m(String value)
    {
        if (hashtable.get("key") == null)
        {
            hashtable.put("key", value);
            System.out.println("put "+value);
        }
    }

    public static void main(String[] args)
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                m("v1");
            }
        }, "t1").start();

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                m("v2");
            }
        }, "t2").start();
    }
}
