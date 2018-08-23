package YangGe;

/**
 * YangGe
 *
 * @author jh
 * @date 2018/8/23 21:23
 * description:  从父到子，模板先有。静态方法，加载一次。方法块后构造方法
 */
class Father{
	public Father() {
		System.out.println ("111111");
	}
	{
		System.out.println ("222222");
	}
	static {
		System.out.println ("333333");
	}
}
class Son extends Father{
	public Son() {
		super();
		System.out.println ("44444");
	}
	{
		System.out.println ("55555");
	}
	static {
		System.out.println ("66666");
	}
}
public class TestStaticSeq {

	public static void main(String[] args) {
		new Son();   //Sun.class--->Father.class---->Father Instance --->Son Instance
		System.out.println ("==================");
		new Son ();
		System.out.println ("==================");
		new Father ();
	}
}
