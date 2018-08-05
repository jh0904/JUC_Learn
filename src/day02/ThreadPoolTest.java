package day02;

import java.util.concurrent.*;

/**
 * day02
 *
 * @author jh
 * @date 2018/8/5 14:55
 * description:线程池
 * 一、提供了一个线程队列，队列中保存着所有等待状态的线程。避免了创建于销毁的额外开销，提高了响应速度。
 * 二、线程池的体系结构：
 *  java.util.concurrent.Excutere:负责线程的使用于调度的子接口。
 *          |--ExecutorService 子接口：线程池的主要接口
 *             |--ThreadPoolExecutor 线程池的实现类
 *             |--ScheduleExecutorService 子接口 ：负责线程调度
 *                |--ScheduledThreadPoolExecutor ：  负责线程调度也具备线程池功能。继承了ThreadPoolExecutor,实现了ScheduledThreadPoolExecutor
 *  三、工具类： Executors
 *  ExecutorService newFixedThreadPool() 创建固定大小的线程池
 *  ExecutorService newCachedThreadPool() 缓存线程池，线程池数量不固定，更具需求自动更改数量。
 *  ExecutorService newSingleThreadExecutor 创建单个线程池
 *
 *
 *  ScheduledExecutorService newScheduledThreadPool :创建固定大小的线程池，可以延迟或者定时的执行任务。
 */
public class ThreadPoolTest {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ThreadPoolDemo tpd = new ThreadPoolDemo();
		/*new Thread (tpd).start ();
		new Thread (tpd).start ();*/
		//1.创建一个线程池

		ExecutorService pool = Executors.newFixedThreadPool (5);
		Future<Integer> submit = pool.submit (new Callable<Integer> () {
			@Override
			public Integer call() throws Exception {
				int sum = 0;
				for (int i = 0; i < 100; i++) {
					sum += i;
				}
				return sum;
			}
		});

		System.out.println (submit.get ());

		pool.shutdown ();

		//2.为线程池中的线程分配任务
		/*for (int i = 0; i < 10; i++) {
			pool.submit (tpd);
		}
		//关闭线程池
		pool.shutdown ();*/
		//pool.shutdownNow (); 立即关闭，不管线程是否完成。
	}
}
class ThreadPoolDemo implements Runnable{
	private int i=0;
	@Override
	public void run() {
		while (i<=100){
			System.out.println (Thread.currentThread ().getName () + " : " + i++);
		}
	}
}
