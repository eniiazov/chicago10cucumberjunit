package test;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class Dog extends Pet {

    public Dog(){
        super();
    }

    @Ignore
    @Test
    public void test1(){
        int expected = 7;
        int actual = add(3,7);
        Assert.assertEquals(expected, actual);
    }

    public int add(int i, int j){
        return i+j;
    }

}

