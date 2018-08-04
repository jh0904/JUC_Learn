package day01;

import java.sql.SQLOutput;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * day01
 *
 * @author jh
 * @date 2018/8/4 16:22
 * description:创建线程的方式：四种
 * 继承Thread类
 * 实现Runnable接口，重写run方法
 * 实现Callable接口，重写call方法，有异常 相较于实现Runnable接口，方法有返回值，有异常抛出。
 *
 * 执行Callable方式，需要FutureTask实现类来支持，来接收运算结果。 FutureTask接口的实现类。
 */
public class CallableTest {
	public static void main(String[] args) {
		ThreadDemo1 td = new ThreadDemo1 ();

		//执行Callable方式，需要FutureTask实现类来支持，来接收运算结果。
		FutureTask<Integer> result = new FutureTask<Integer> (td);
		new Thread (result).start ();

		//接收线程运算后的结果
		//线程不执行完，FutureTask也可以用于闭锁的操作。

		try {
			Integer sum = result.get ();
			System.out.println (sum);
		} catch (InterruptedException e) {
			e.printStackTrace ();
		} catch (ExecutionException e) {
			e.printStackTrace ();
		}

	}
}

class ThreadDemo1 implements Callable<Integer> {
	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for (int i = 1; i <= 100000; i++) {
			System.out.println (i);
			sum += i;
		}
		return sum;
	}
}