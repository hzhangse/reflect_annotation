package reflect;

import java.lang.reflect.Method;

class Persion1 {
	private String name;
	private int age;

	public void setName(String name) {
		this.name = name;
	}
}

public class ReflectTest3 {
	public static void main(String[] args) throws Exception {
		Persion1 p = new Persion1();

		// 用普通的方法进行赋值操作
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000000L; i++) {
			p.setName("张三");
		}
		long end = System.currentTimeMillis();
		System.out.println("普通方法赋值1亿次,执行时间: " + (end - start) + "ms");

		// 利用反射动态赋值
		Class clazz = p.getClass();
		Method m = clazz.getDeclaredMethod("setName", String.class);
		long start1 = System.currentTimeMillis();
		for (int i = 0; i < 100000000L; i++) {
			m.invoke(p, "张三");
		}
		long end1 = System.currentTimeMillis();
		System.out.println("反射动态赋值1亿次,执行时间: " + (end1 - start1) + "ms");

		// 利用反射禁止访问检查,动态赋值测试
		m.setAccessible(true);
		long start2 = System.currentTimeMillis();
		for (int i = 0; i < 100000000L; i++) {
			m.invoke(p, "张三");
		}
		long end2 = System.currentTimeMillis();
		System.out.println("反射取消访问检查,动态赋值1亿次,执行时间: " + (end2 - start2) + "ms");
	}

}