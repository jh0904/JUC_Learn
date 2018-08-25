package YangGe;

import java.util.Random;
import java.util.concurrent.*;

/**
 * YangGe
 *
 * @author jh
 * @date 2018/8/25 21:09
 * description:创建线程的第四种方式：线程池
 * S S S
 * Collections Arrays Executors
 */
public class ExecutorsDemo {
	public static void main(String[] args) {
		ScheduledExecutorService service = Executors.newScheduledThreadPool (5);
		ScheduledFuture result=null;
		try {
			for (int i = 1; i <= 15; i++) {
				result = service.schedule (() -> {
					Thread.sleep (100);
					System.out.print (Thread.currentThread ().getName () + "\t");
					return (new Random ().nextInt (10));
				},2,TimeUnit.SECONDS);
				System.out.println ("-------------->result" + result.get ());
			}
		} catch (Exception e) {
			e.printStackTrace ();
		} finally {
			service.shutdownNow ();
		}
	}

	public static void testThreadPool() {
		//ExecutorService service = Executors.newFixedThreadPool (5);//一池5线程
		//ExecutorService service = Executors.newSingleThreadExecutor ();//一池1线程
		ExecutorService service = Executors.newCachedThreadPool ();//一池N线程
		Future result = null;
		try {
			for (int i = 1; i <= 15; i++) {
				result = service.submit (() -> {
					Thread.sleep (100);
					System.out.print (Thread.currentThread ().getName () + "\t");
					return (new Random ().nextInt (10));
				});
				System.out.println ("-------------->result" + result.get ());
			}
		} catch (Exception e) {
			e.printStackTrace ();
		} finally {
			service.shutdownNow ();
		}
	}
}
