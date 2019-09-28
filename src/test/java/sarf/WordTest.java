package sarf;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WordTest {

    @Test
    void testToString() {
        assertThat(new Word("").toString()).isEqualTo("");
        assertThat(new Word("ب").toString()).isEqualTo("ب");
    }

    @Test
    void isEmpty() {
        assertThat(new Word("").isEmpty()).isTrue();
        assertThat(new Word("و").isEmpty()).isFalse();
    }

    @Test
    void contains() {
        assertThat(new Word("").contains("f")).isFalse();
        assertThat(new Word("سمر").contains("f")).isFalse();
        assertThat(new Word("سمر").contains("مر")).isTrue();
        assertThat(new Word("سمر").contains("سمر")).isTrue();
        assertThat(new Word("سمر").contains("")).isTrue();
    }

    @Test
    void replaceAll() {
    }

    @Test
    void endsWith() {
    }

    @Test
    void lastIndexOf() {
    }

    @Test
    void substring() {
    }

    @Test
    void append() {
    }

    @Test
    void test(){
        process(new Derived1());
        process(new Derived2());

        List<Integer> ints = new ArrayList<Integer>();
        count(ints, 5);
        assert ints.toString().equals("[0, 1, 2, 3, 4]");

        List<Number> nums = new ArrayList<Number>();
        count(nums, 5); nums.add(5.0);
        assert nums.toString().equals("[0, 1, 2, 3, 4, 5.0]");

        List<Object> objs = new ArrayList<Object>();
        count(objs, 5); objs.add("five");
        assert objs.toString().equals("[0, 1, 2, 3, 4, five]");

        System.out.println(objs.toString());

        List<? super Integer> l = new ArrayList<Integer>();
        l.add(1);
        l.add(null);
        Object x = l.get(0);
        System.out.println(x);

        print(l);

    }
    static void count(Collection<? super Integer> ints, int n) {
        for (int i = 0; i < n; i++) ints.add(i);
    }

    static void print(Collection<? super Integer> objs){
        for(Object x : objs){
            System.out.printf("%s ", x);
        }
    }
    private void process(BaseClass baseClass){

    }
    private abstract class BaseClass{
    }

    private class Derived1 extends BaseClass{}
    private class Derived2 extends BaseClass{}

}