package YangGe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * YangGe
 *
 * @author jh
 * @date 2018/8/23 10:12
 * description:
 * 1.多线程编写套路----上
 * 1.1 线程   操作(实例方法)    资源类(票)     例子：空调制冷/制热
 * 1.2 高内聚  低耦合
 */
public class SaleTicket {
	public static void main(String[] args) {
		final Ticket ticket = new Ticket ();

		new Thread(() -> { for (int i = 1; i <=40; i++) 	ticket.sale(); }, "AA").start();
		new Thread(() -> { for (int i = 1; i <=40; i++) 	ticket.sale(); }, "BB").start();
		new Thread(() -> { for (int i = 1; i <=40; i++) 	ticket.sale(); }, "CC").start();


				/*new Thread(new Runnable() {
			@Override
			public void run()
			{
				for (int i = 1; i <=40; i++)
				{
					ticket.sale();
				}
			}
		}, "AA").start();
		new Thread(new Runnable() {
			@Override
			public void run()
			{
				for (int i = 1; i <=40; i++)
				{
					ticket.sale();
				}
			}
		}, "BB").start();
		new Thread(new Runnable() {
			@Override
			public void run()
			{
				for (int i = 1; i <=40; i++)
				{
					ticket.sale();
				}
			}
		}, "CC").start();		*/
	}
}

class Ticket {//资源类  类=实例变量+实例方法

	private int number = 30;
	private Lock lock = new ReentrantLock ();

	public void sale() {
		lock.lock ();
		try {
			if (number > 0) {
				System.out.println(Thread.currentThread().getName()+"\t 卖出第:"+(number--)+"\t 还剩下: "+number);
			}
		} finally {
			lock.unlock ();
		}
	}
}
