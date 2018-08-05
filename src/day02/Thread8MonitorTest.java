package day02;

/**
 * day02
 *
 * @author jh
 * @date 2018/8/5 14:31
 * description:
 * 1.两个synchronized同步方法，顺序执行，两个线程标准打印 one two
 * 2.新增Thread.sleep方法给one，打印： one two
 * 3.新增普通方法 getThree方法，打印 3 one two
 * 4.两个普通的同步方法，两个number对象，打印：two one
 * 5.修改getOne（）方法为静态方法，打印？ two one
 * 6.两个均为静态方法，一个number对象 打印：one ，two
 * 7.一个静态同步，一个非静态同步方法，两个number对象，打印 two one
 * 8.两个静态方法，两个number对象 打印 one two
 *
 *
 * 线程八锁的关键：
 * 1.非静态方法的锁为this，静态方法的锁 为对应的Class实例
 * 2.某一个时刻内，只有一个线程可以持有锁，不论几个方法。
 */
public class Thread8MonitorTest {

	public static void main(String[] args) {
		Number number = new Number ();
		Number number1 = new Number ();
		new Thread (new Runnable () {
			@Override
			public void run() {
				number.getOne ();
			}
		}).start ();

		new Thread (new Runnable () {
			@Override
			public void run() {
				number1.getTwo ();
			}
		}).start ();

	}
}

class Number {
	public static synchronized void getOne() {
		try {
			Thread.sleep (3000);
		} catch (InterruptedException e) {
			e.printStackTrace ();
		}
		System.out.println ("one");
	}

	public static synchronized void getTwo() {
		System.out.println ("two");
	}

	public void getThree(){
		System.out.println ("3");
	}
}
