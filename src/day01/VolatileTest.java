package day01;

/**
 * day01
 *
 * @author jh
 * @date 2018/8/4 13:36
 * description:Volatile关键字
 * 当多个线程进行操作共享数据时，可以保证内存中的数据可见。
 * 相较于 synchronized 是一种较为轻量级的同步策略。
 * 注意：1.volatile不具有“互斥性”，可以允许多个线程同时进入
 *      2.volatile不保证元素的“原子性”
 */
public class VolatileTest {

	public static void main(String[] args) {
		ThreadDemo td = new ThreadDemo ();
		new Thread (td).start ();

		while (true) {
			//效率很低
			synchronized (td) {
				if (td.isFlag ()) {
					System.out.println ("------------------");
					break;
				}
			}
		}

	}

}

class ThreadDemo implements Runnable {

	private boolean flag = false;

	@Override
	public void run() {

		try {
			Thread.sleep (200);
		} catch (InterruptedException e) {
		}

		flag = true;

		System.out.println ("flag=" + isFlag ());

	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}