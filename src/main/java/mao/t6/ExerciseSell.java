package mao.t6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

/**
 * Project name(项目名称)：java并发编程_线程安全
 * Package(包名): mao.t6
 * Class(类名): ExerciseSell
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/29
 * Time(创建时间)： 20:19
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class ExerciseSell
{
    public static void main(String[] args)
    {
        TicketWindow ticketWindow = new TicketWindow(20000);
        List<Thread> list = new ArrayList<>();
        List<Integer> sellCount = new Vector<>();
        for (int i = 0; i < 10000; i++)
        {
            Thread t = new Thread(() ->
            {
                int count = ticketWindow.sell(randomAmount());
                sellCount.add(count);
            });
            list.add(t);
        }

        for (Thread thread : list)
        {
            thread.start();
        }

        list.forEach((t) ->
        {
            try
            {
                t.join();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        });
        System.out.println("卖出去的票总数：" + sellCount.stream().mapToInt(c -> c).sum());
        System.out.println("剩余票数：" + ticketWindow.getCount());
    }

    // Random 为线程安全
    static Random random = new Random();

    // 随机 1~5
    public static int randomAmount()
    {
        return random.nextInt(5) + 1;
    }

}
