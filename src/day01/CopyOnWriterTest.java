package day01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * day01
 *
 * @author jh
 * @date 2018/8/4 15:52
 * description:
 */

/*
* CopyOnWriteArrayList/CopyOnWriteArraySet  ：写入并复制（适用于迭代操作，不适合添加操作）
* 当你每次写入是，会复制一个新的列表，然后进行添加。
* */

public class CopyOnWriterTest {
	public static void main(String[] args) {
		HelloThread ht = new HelloThread ();
		for (int i = 0; i < 10; i++) {
			new Thread (ht).start ();
		}
	}
}
class HelloThread implements Runnable{
	//private static List<String> list= Collections.synchronizedList (new ArrayList<> ());

	private static CopyOnWriteArrayList<String> list=new CopyOnWriteArrayList<String>();

	static {
		list.add ("AA");
		list.add ("BB");
		list.add ("CC");
	}

	@Override
	public void run() {
		Iterator<String> it = list.iterator ();
		while (it.hasNext ()){
			System.out.println (it.next ());
			//并发修改异常
			list.add ("AAA");
		}
	}
}