package day02;

import java.util.Random;
import java.util.concurrent.*;

/**
 * day02
 *
 * @author jh
 * @date 2018/8/5 15:47
 * description:
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
public class ScheduledThreadPoolTest {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ScheduledExecutorService pool = Executors.newScheduledThreadPool (5);
		for (int i = 0; i < 10; i++) {
			Future<Integer> result = pool.schedule (new Callable<Integer> () {
				@Override
				public Integer call() throws Exception {
					int sum = new Random ().nextInt (100);
					System.out.println (Thread.currentThread ().getName () + " : " + sum);
					return sum;

				}
			}, 1, TimeUnit.SECONDS);

			System.out.println (result.get ());
		}
			pool.shutdown ();
	}

}
