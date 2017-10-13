package reflect;

import java.lang.reflect.Field;

class Persion{  
	private String name;
	private int age;
      
    @Override  
    public String toString()  
    {  
        return name + " --- " + age;  
    }  
}  
  
public class ReflectTest2  
{  
    public static void setProperty(Object obj,String propertyName,Object value)   
           throws Exception  
    {  
          
        //获得类的class文件对像  
        Class clazz = obj.getClass();  
          
        //获得propertyName字段  
        Field field = clazz.getDeclaredField(propertyName);  
        //设置访问权限  
        field.setAccessible(true);  
        //给obj对像赋值  
        field.set(obj, value);  
    }  
      
    public static void main(String[] args) throws Exception   
    {  
        Persion p = new Persion();  
        System.out.println(p);  
      
        setProperty(p,"name","刘德华");  
        setProperty(p,"age",50);  
          
        System.out.println(p);    
    }  
}  
