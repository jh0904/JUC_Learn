package day01;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * day01
 *
 * @author jh
 * @date 2018/8/4 14:40
 * description:原子性问题
 * 一、i++的原子性问题   实际上是分为三个步骤的“读、改、写”
 * int i=10;
 * i=i++;  //10
 * 解析：int temp=i;
 * i=i+1;
 * i=temp;
 * 二、原子变量：jdk5之后，java.util.concurrent.atomic包下提供了常用的原子变量
 *      1.volatile 保证内存可见性
 *      2.CAS算法(Compare-And-Swap) 保证数据的原子性
 *          CAS算法是硬件对于并发操作共享数据的支持。
 *          CAS包含了三个操作数：
 *          内存值 V
 *          预估值 A
 *          更新值 B
 *          当且仅当V==A时，V==B，否则，将不进行任何操作。
 */
public class AtomicTest {
	public static void main(String[] args) {
		AtomicDemo ad = new AtomicDemo ();
		for (int i = 0; i < 10; i++) {
			new Thread (ad).start ();
		}
	}
}

class AtomicDemo implements Runnable {
	//private int serialNumber = 0;

	private AtomicInteger serialNumber = new AtomicInteger ();
	@Override
	public void run() {
		try {
			Thread.sleep (200);
			System.out.println (getSerialNumber ());
		} catch (InterruptedException e) {
			e.printStackTrace ();
		}
	}

	public int getSerialNumber() {
		return serialNumber.getAndIncrement ();
	}
}