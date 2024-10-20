package com.patres.ownframework.step2a.application.dao;

public class TestImp1 implements TestInf{



    @Override
    public void test() {
        System.out.println("This is props of Interface" + TestInf.test);
        System.out.println("Welcome to my house , Test1");
    }
}
