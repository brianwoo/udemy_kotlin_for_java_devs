package com.examples.javacode;

import java.util.ArrayList;
import java.util.List;

public class JavaCode {

    // PECS
    // Producer Extends, Consumer Super

    private void producerExtends() {
        List<? extends Number> foo3a = new ArrayList<Number>();  // Number "extends" Number (in this context)
        List<? extends Number> foo3b = new ArrayList<Integer>(); // Integer extends Number
        List<? extends Number> foo3c = new ArrayList<Double>();  // Double extends Number

        Number myNum = foo3a.get(0);
        // Failed:
        // foo3a.add(Integer.valueOf(3))
    }

    private void consumerSuper() {
        List<? super Integer> foo3a = new ArrayList<Integer>();  // Integer is a "superclass" of Integer (in this context)
        List<? super Integer> foo3b = new ArrayList<Number>();   // Number is a superclass of Integer
        List<? super Integer> foo3c = new ArrayList<Object>();   // Object is a superclass of Integer

        foo3a.add(Integer.valueOf(11));
        Object object = foo3a.get(0);

        // Failed:
        // foo3a.add(Double.valueOf(111d))
        // Integer myInt = foo3a.get(0);
    }

    public static void main(String[] args) {

    }
}
