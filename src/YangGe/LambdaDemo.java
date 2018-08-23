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
 */
@FunctionalInterface
interface Foo{
	public void sayHello();
	//public void show();
}


public class LambdaDemo {
	public static void main(String[] args) {
		Foo foo = new Foo () {
			@Override
			public void sayHello() {
				System.out.println ("-----hello---->");
			}

		};

		Foo foo1=()->{
			System.out.println ("hello---->");
		};

	}
}
