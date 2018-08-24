package YangGe;

import org.junit.runner.RunWith;

import java.util.concurrent.Callable;

/**
 * YangGe
 *
 * @author jh
 * @date 2018/8/24 23:23
 * description:实现多线程的第三种方法。
 */
//
//class MyThread implements Runnable{
//	@Override
//	public void run() {
//
//	}
//}
class MyThread implements Callable<Integer>{
	@Override
	public Integer call() throws Exception {
		return 200;
	}
}


public class CallableDemo {
	public static void main(String[] args) {
		//利用Callable实现一个线程，
		//一个实现类实现两个接口，让两个接口关联在一起。

	}
}
