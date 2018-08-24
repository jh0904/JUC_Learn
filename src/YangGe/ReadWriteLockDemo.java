package YangGe;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * YangGe
 *
 * @author jh
 * @date 2018/8/24 22:55
 * description:一个线程写入，100个线程去读取
 */
class MyQueue{
	private Object obj;

	private ReentrantReadWriteLock rwLock=new ReentrantReadWriteLock ();

	public void whiteObj(Object obj){
		rwLock.writeLock ().lock ();
		try {
			this.obj=obj;
			System.out.println (Thread.currentThread ().getName () + "\t" + obj);
		} catch (Exception e) {
			e.printStackTrace ();
		} finally {
			rwLock.writeLock ().unlock ();
		}

	}

	public void readObj(){
		rwLock.readLock ().lock ();
		try {
			System.out.println (Thread.currentThread ().getName () + "\t" + obj);
		} catch (Exception e) {
			e.printStackTrace ();
		} finally {
			rwLock.readLock ().unlock ();
		}

	}
}
public class ReadWriteLockDemo {
	public static void main(String[] args) throws InterruptedException {
		MyQueue myQueue = new MyQueue ();

		new Thread (()->{
			myQueue.whiteObj ("ClassName1018");
		},"Write").start ();

		Thread.sleep (100);

		for (int i = 1; i <=100; i++) {
			new Thread (()->{
				myQueue.readObj ();
			},String.valueOf (i)).start ();
		}

	}
}
