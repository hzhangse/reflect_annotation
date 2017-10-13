package annotation;
@InheritedTest(hello = "yahaitt")   
public class InheritedParent {   
	@InheritedTest(hello = "yahaitt-method")   
    public void doSomething()   
    {   
        System.out.println("parent do something");   
    }   

}   