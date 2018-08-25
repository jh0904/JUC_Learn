package YangGe;

import org.junit.runner.RunWith;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * YangGe
 *
 * @author jh
 * @date 2018/8/24 23:23
 * description:实现多线程的第三种方法。
 * 1.Callable: 异常/返回值/泛型
 * 2.面向接口编程，多态的思想，找关联。找一个类，传多个接口，就产生了关联。
 * 3.callable接口中的get方法放前与放后。不产生阻塞。
 * 4.不管几个线程，主要有一个FutureTask，就
 * 实现最好的是       异步调用，（会做的做，不会做的空着）
 */


/**
 在主线程中需要执行比较耗时的操作时，但又不想阻塞主线程时，可以把这些作业交给Future对象在后台完成，
 当主线程将来需要时，就可以通过Future对象获得后台作业的计算结果或者执行状态。

 一般FutureTask多用于耗时的计算，主线程可以在完成自己的任务后，再去获取结果。

 仅在计算完成时才能检索结果；如果计算尚未完成，则阻塞 get 方法。一旦计算完成，
 就不能再重新开始或取消计算。get方法而获取结果只有在计算完成时获取，否则会一直阻塞直到任务转入完成状态，
 然后会返回结果或者抛出异常。

 只计算一次
 get方法放到最后
 */

//
//class MyThread implements Runnable{
//	@Override
//	public void run() {
//
//	}
//}
class MyThread implements Callable<Integer> {
	@Override
	public Integer call() throws Exception {
		System.out.println ("call---->");
		//Thread.sleep (4000);
		return 200;
	}
}

public class CallableDemo {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		//利用Callable实现一个线程，
		//一个实现类实现两个接口，让两个接口关联在一起。
		FutureTask<Integer> ft = new FutureTask<> (new MyThread ());
		new Thread (ft, "AA").start ();


		System.out.println (Thread.currentThread ().getName () + "------------这是主线程");
		/*
		* get()方法最好放最后
		* */
		Integer result01 = ft.get ();
		Integer result02 = ft.get ();

		System.out.println ("result01------------->" + result01);
		System.out.println ("result02------------->" + result02);
	}
}
