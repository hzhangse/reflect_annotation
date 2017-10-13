package annotation;

import java.lang.reflect.Method;

public class InheritedClassTest {
	public static void main(String[] args) throws Exception   
    {   
        Class<InheritedChild> c = InheritedChild.class;   
        if(c.isAnnotationPresent(InheritedTest.class))   
        {   
            InheritedTest it = c.getAnnotation(InheritedTest.class);   
            System.out.println(it.hello());//yahaitt   
        }   
        
        
        Method method = c.getMethod("doSomething", new Class[]{});   
        if(method.isAnnotationPresent(InheritedTest.class))   
        {   
            InheritedTest it = method.getAnnotation(InheritedTest.class);   
            System.out.println(it.hello());//yahaitt   
        }   
    }   
}
