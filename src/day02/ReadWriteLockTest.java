package day02;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * day02
 *
 * @author jh
 * @date 2018/8/5 14:06
 * description:
 * 1.读写锁ReadWriteLock
 * 什么情况下使用读写锁？
 *       写写/读写 需要互斥
 *       读读 不需要互斥
 *
 */
public class ReadWriteLockTest {
	public static void main(String[] args) {
		ReadWriteLockDemo rw=new ReadWriteLockDemo();

		new Thread (new Runnable () {
			@Override
			public void run() {
				rw.set ((int)(Math.random ()*100));
			}
		},"Write").start ();

		for (int i = 0; i < 100; i++) {
			new Thread (new Runnable () {
				@Override
				public void run() {
					rw.get ();
				}
			}).start ();
		}
	}
}
class ReadWriteLockDemo{
	private int number=0;
	private ReadWriteLock lock=new ReentrantReadWriteLock ();
	//读
	public void get(){
		lock.readLock().lock(); //上锁

		try{
			System.out.println(Thread.currentThread().getName() + " : " + number);
		}finally{
			lock.readLock().unlock(); //释放锁
		}
	}

	//写
	public void set(int number){
		lock.writeLock().lock();

		try{
			System.out.println(Thread.currentThread().getName());
			this.number = number;
		}finally{
			lock.writeLock().unlock();
		}
	}
}