import java.io.Serializable;

import static java.lang.Class.forName;

public class ReflectionExample {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
            Test t= new Test();
            Class clazz = t.getClass();
            Class clazz2 = Test.class;
            Class clazz3 = Class.forName("Reflection.Test");

            Test test = (Test) clazz.newInstance();

    }

}

class Test implements Serializable, Cloneable{
    private int num;

    public Test(){

    }
    public Test (Object obj){

    }

    @Deprecated
    protected static void counter(String[] array){

    }
    public void foo(){
        System.out.println("FOO");
    }

    @Override
    public String toString() {
        return "Test{" +
                "num=" + num +
                '}';
    }
}
