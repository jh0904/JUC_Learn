package YangGe;

/**
 * YangGe
 *
 * @author jh
 * @date 2018/8/23 9:52
 * description:
 * 1. 拷贝中括号+写死右箭头+落地大括号
 * 2. 一个接口有且仅有一个方法(默认就是函数式接口)
 * 3. @FunctionalInterface
 * 4.
 */
@FunctionalInterface
interface Foo{
	//public void sayHello();
	//public void show();
	public int add(int x,int y);

	default int div(int x,int y){
		return x/y;
	}
	public static int sub(int x,int y){
		return x-y;
	}

}


public class LambdaDemo {
	public static void main(String[] args) {
		/*Foo foo = new Foo () {
			@Override
			public void sayHello() {
				System.out.println ("-----hello---->");
			}

		};*/

		Foo foo1=(x,y)-> x+y;
		int add = foo1.add (0, 4);
		System.out.println (add);

		int div = foo1.div (6, 3);
		System.out.println (div);
		System.out.println (foo1.add (1, 4));
	}
}
