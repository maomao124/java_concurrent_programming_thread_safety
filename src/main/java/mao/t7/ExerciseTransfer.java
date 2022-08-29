package mao.t7;

import java.util.Random;

/**
 * Project name(项目名称)：java并发编程_线程安全
 * Package(包名): mao.t7
 * Class(类名): ExerciseTransfer
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/29
 * Time(创建时间)： 20:37
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class ExerciseTransfer
{
    public static void main(String[] args) throws InterruptedException
    {
        Account a = new Account(1000);
        Account b = new Account(1000);

        Thread t1 = new Thread(() ->
        {
            for (int i = 0; i < 1000; i++)
            {
                a.transfer(b, randomAmount());
            }
        }, "t1");

        Thread t2 = new Thread(() ->
        {
            for (int i = 0; i < 1000; i++)
            {
                b.transfer(a, randomAmount());
            }
        }, "t2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        // 查看转账2000次后的总金额
        System.out.println("转账后双方的总金额:" + (a.getMoney() + b.getMoney()));
    }

    // Random 为线程安全
    static Random random = new Random();

    // 随机 1~100
    public static int randomAmount()
    {
        return random.nextInt(100) + 1;
    }
}
