package day01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * day01
 *
 * @author jh
 * @date 2018/8/4 16:36
 * description:
 * 一、解决线程安全问题的方法：
 * <p>
 * 1.同步代码块  隐式锁
 * 2.同步方法
 * 3.JDK1.5 ---->Lock锁  （显示锁）
 * 必须通过lock()方法上锁，通过unLock()方法释放锁 （放finally中，保证执行。确保安全隐患）
 */
public class LockTest {
	public static void main(String[] args) {
		Ticket ticket = new Ticket ();

		new Thread (ticket, "一号窗口").start ();
		new Thread (ticket, "二号窗口").start ();
		new Thread (ticket, "三号窗口").start ();

	}
}

class Ticket implements Runnable {
	private int tick = 100;

	private Lock lock=new ReentrantLock();
	@Override
	public void run() {
		while (true) {
			lock.lock ();

			try {
				if (tick > 0) {
					try {
						Thread.sleep (200);
					} catch (InterruptedException e) {
						e.printStackTrace ();
					}
					System.out.println (Thread.currentThread ().getName () + "完成售票，余票为" + --tick);
				}
			} finally {
				lock.unlock ();
			}

		}
	}
}
