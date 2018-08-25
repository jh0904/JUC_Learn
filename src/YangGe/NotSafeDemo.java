package YangGe;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * YangGe
 *
 * @author jh
 * @date 2018/8/25 22:18
 * description:集合的不安全类
 * 解决集合list线程不安全的方法：CopyOnWriteArrayList /
 */
public class NotSafeDemo {
	public static void main(String[] args) {
		//HashMap<String, String> map = new HashMap<> ();
		Map<String, String> map = new ConcurrentHashMap<String, String> ();
		for (int i = 1; i <= 30; i++) {
			new Thread (()->{
				map.put (Thread.currentThread ().getName (),UUID.randomUUID ().toString ().substring (0,4));
				System.out.println (map);
			},String.valueOf (i)).start ();
		}
	}

	public static void NotSafeSet() {
		/* Set<String> set = new HashSet<> (); */
		Set<String> set = new CopyOnWriteArraySet<> ();
		for (int i = 1; i <= 30; i++) {
			new Thread (()->{
				set.add (UUID.randomUUID ().toString ().substring (0,4));
				System.out.println (set);
				/*
					[8218, b778]
					[8218, b778, 5004]
					[8218, b778]
				* */

			},String.valueOf (i)).start ();
		}
	}

	/**
	 CopyOnWrite容器即写时复制的容器。往一个容器添加元素的时候，不直接往当前容器Object[]添加，而是先将当前容器Object[]进行Copy，
	 复制出一个新的容器Object[] newElements，然后新的容器Object[] newElements里添加元素，添加完元素之后，
	 再将原容器的引用指向新的容器 setArray(newElements);。这样做的好处是可以对CopyOnWrite容器进行并发的读，
	 而不需要加锁，因为当前容器不会添加任何元素。所以CopyOnWrite容器也是一种读写分离的思想，读和写不同的容器
	 */
	public static void ListNotSafe() {
		//List<String> list = new ArrayList<> ();
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<> ();
		/*
		* 写时复制技术
		* add方法434行加了锁
		* */
		//list = Arrays.asList ("a", "b", "c");
		//list.forEach (System.out::println);

		for (int i = 1; i <= 30; i++) {
			new Thread (()->{
				list.add (UUID.randomUUID ().toString ().substring (0,4));
				System.out.println (list);
				/*
					[8218, b778]
					[8218, b778, 5004]
					[8218, b778]
				* */

			},String.valueOf (i)).start ();

			//Collections.synchronizedList (list);
		}
	}
}
