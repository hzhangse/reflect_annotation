package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ReflectRetentionTest {   
	  
    public static void main(String[] args) throws Exception{   
        MyTest mt = new MyTest();   
        Class<MyTest> c = MyTest.class;   
        Method method = c.getMethod("output",new Class[]{});   
        if(method.isAnnotationPresent(RetentionTest.class))   
        {   
            method.invoke(mt, new Object[]{});//output   
               
            RetentionTest  retentionTest = method.getAnnotation(RetentionTest.class);   
               
            System.out.println(retentionTest.hello());//beijing   
            System.out.println(retentionTest.world());//shanghai   
        }   
           
        Annotation[] annotations = method.getAnnotations();   
        for(Annotation annotation: annotations)   
        {   
            System.out.println(annotation.annotationType().getName());   
        }   
        //for循环里输出的结果是com.test.RetentionTest以及java.lang.Deprecated，而没有出来java.lang.SuppressWarnings   
        //因为java.lang.SuppressWarnings的Retention是被设置成RetentionPolicy.SOURCE类型的，所以在运行时是不会被虚拟机读取的。   
    }   
}   