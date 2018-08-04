package day01;

import java.util.concurrent.CountDownLatch;

/**
 * day01
 *
 * @author jh
 * @date 2018/8/4 16:02
 * description:在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程等待。
 * 当你要完成运算，只有其他线程的运算全部完成，当前运算才继续执行。
 */
public class CountDownLatchTest {
	public static void main(String[] args) {
		final CountDownLatch latch = new CountDownLatch (5);
		LatchDemo ld = new LatchDemo (latch);

		long l = System.currentTimeMillis ();
		 //Type:

		for (int i = 0; i < 5; i++) {
			new Thread (ld).start ();
		}

		try {
			latch.await ();
		} catch (InterruptedException e) {
			e.printStackTrace ();
		}

		long l1 = System.currentTimeMillis ();

		System.out.println ("执行时间： " + (l1 - l));
	}

}

class LatchDemo implements Runnable {
	private CountDownLatch latch;

	public LatchDemo(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {

		synchronized (this){
			try {
				for (int i = 0; i < 50000; i++) {
					if (i % 2 == 0) {
						System.out.println (i);
					}
				}
			} finally {
				latch.countDown ();
			}
		}


	}
}