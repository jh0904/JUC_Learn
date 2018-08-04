package day01;

/**
 * day01
 *
 * @author jh
 * @date 2018/8/4 15:05
 * description:模拟CAS算法
 */
public class CompareAndSwapTest {
	public static void main(String[] args) {
		compareAndSwap cas = new compareAndSwap ();

		for (int i = 0; i < 10; i++) {
			new Thread (new Runnable () {
				@Override
				public void run() {
					int value = cas.get ();
					boolean b = cas.compareAndSet (value, (int) (Math.random () * 10));
					System.out.println (b);
				}
			}).start ();
		}
	}
}

class compareAndSwap {
	private int value;

	//获取内存值
	public synchronized int get() {
		return value;
	}
	//比较

	public synchronized int compareAndSwap(int expectValue, int newValue) {
		int oldValue = value;

		if (oldValue == expectValue) {
			this.value = newValue;
		}

		return oldValue;
	}

	//设置

	public synchronized boolean compareAndSet(int expectValue, int newValue) {
		return expectValue == compareAndSwap (expectValue, newValue);
	}
}