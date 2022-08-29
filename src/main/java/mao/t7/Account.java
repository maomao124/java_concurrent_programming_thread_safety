package mao.t7;

/**
 * Project name(项目名称)：java并发编程_线程安全
 * Package(包名): mao.t7
 * Class(类名): Account
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/29
 * Time(创建时间)： 20:36
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Account
{
    private int money;

    public Account(int money)
    {
        this.money = money;
    }

    public int getMoney()
    {
        return money;
    }

    public void setMoney(int money)
    {
        this.money = money;
    }

    /**
     * 转账
     *
     * @param target 对方的账户
     * @param amount 要转账的金额
     */
    public void transfer(Account target, int amount)
    {
        synchronized (Account.class)
        {
            if (this.money > amount)
            {
                this.setMoney(this.getMoney() - amount);
                target.setMoney(target.getMoney() + amount);
            }
        }
    }

}
