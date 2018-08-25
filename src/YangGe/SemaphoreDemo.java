package YangGe;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * YangGe
 *
 * @author jh
 * @date 2018/8/25 19:28
 * description:Semaphore，
 *  一个车位就是锁，多个车位就是信号量
 *  Semaphore（信号量）是用来控制同时访问特定资源的线程数量，它通过协调各个线程，以
 * 保证合理的使用公共资源。
 */
public class SemaphoreDemo {
	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore (3);//模拟三个停车位

		for (int i = 1; i <= 6; i++) {//模拟6个车
			new Thread (()->{
				try {
					semaphore.acquire ();
					System.out.println (Thread.currentThread ().getName () + "\t--->抢占了车位");
					TimeUnit.SECONDS.sleep (new Random ().nextInt (8));
					System.out.println (Thread.currentThread ().getName () + "\t离开了车位");

				} catch (InterruptedException e) {
					e.printStackTrace ();
				}finally {
					semaphore.release ();
				}
			},String.valueOf (i)).start ();
		}

	}
}
