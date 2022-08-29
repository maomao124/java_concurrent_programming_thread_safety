package mao.t6;

/**
 * Project name(项目名称)：java并发编程_线程安全
 * Package(包名): mao.t6
 * Class(类名): TicketWindow
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/29
 * Time(创建时间)： 20:18
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class TicketWindow
{
    private int count;

    public TicketWindow(int count)
    {
        this.count = count;
    }

    public int getCount()
    {
        return count;
    }

    public int sell(int amount)
    {
        if (this.count >= amount)
        {
            this.count -= amount;
            return amount;
        }
        else
        {
            return 0;
        }
    }

//    public synchronized int sell(int amount)
//    {
//        if (this.count >= amount)
//        {
//            this.count -= amount;
//            return amount;
//        }
//        else
//        {
//            return 0;
//        }
//    }
}
