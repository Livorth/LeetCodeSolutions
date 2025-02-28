package test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;
import java.math.RoundingMode;

interface Subject {
    void doSomething();
}

class RealSubject implements Subject {
    @Override
    public void doSomething() {
        System.out.println("RealSubject is doing something");
    }
}

class DynamicProxyHandler implements InvocationHandler {

    private Object target;

    public DynamicProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before method invocation");
        Object result = method.invoke(target, args);
        System.out.println("After method invocation");
        return result;    }


    public static void main(String[] args) {
//        Subject realSubject = new RealSubject();
//        Subject proxySubject = (Subject) Proxy.newProxyInstance(
//                realSubject.getClass().getClassLoader(),
//                realSubject.getClass().getInterfaces(),
//                new DynamicProxyHandler(realSubject));
//
//        proxySubject.doSomething();
        BigDecimal a = new BigDecimal(1.01D);
        BigDecimal b = new BigDecimal("1.01");
        System.out.println(1.010D == 1.01D);
        System.out.println(a.equals(b));//false
        System.out.println();
    }
}