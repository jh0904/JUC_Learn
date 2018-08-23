package YangGe;

/**
 * YangGe
 *
 * @author jh
 * @date 2018/8/23 14:50
 * description:
 * 现在两个线程，
 * 可以操作初始值为零的一个变量，
 * 实现一个线程对该变量加1，一个线程对该变量减1，
 * 交替，来10轮，变量初始值为零
 * <p>
 * 1 多线程编写套路------上
 * 1.1	 线程		操作(实例方法)		资源类
 * 1.2  高内聚  低耦合
 * <p>
 * 2 多线程编写套路------下
 * 2.1  判断
 * 2.2  干活
 * 2.3  通知
 */
class ShareData {
	private int number = 0;

	public synchronized void increment() throws InterruptedException {
		//判断
		if (number != 0) {
			this.wait ();
		}
		//干活
		number++;
		System.out.println (Thread.currentThread ().getName () + "\t" + number);
		//通知
		this.notifyAll ();
	}

	public synchronized void decrement() throws InterruptedException {
		//判断
		if (number == 0) {
			this.wait ();
		}
		//干活
		number--;
		System.out.println (Thread.currentThread ().getName () + "\t" + number);
		//通知
		this.notifyAll ();
	}

}

public class NotifyWaitDemo {
	public static void main(String[] args) {
		ShareData sd = new ShareData();
		new Thread (() -> {
			for (int i = 1; i <= 10; i++) {
				try {
					sd.increment ();
				} catch (InterruptedException e) {
					e.printStackTrace ();
				}
			}
		}, "AA").start ();


		new Thread (() -> {
			for (int i = 1; i <= 10; i++) {
				try {
					sd.decrement ();
				} catch (InterruptedException e) {
					e.printStackTrace ();
				}
			}
		}, "BB").start ();
	}
}
