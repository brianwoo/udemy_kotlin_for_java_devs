package com.examples.javacode;

import java.util.ArrayList;
import java.util.List;

public class JavaGenerics {

    public static void main(String[] args) {
        List<String> strings = new ArrayList();
        strings.add("hello");

        //**** JVM doesn't understand generics, we cannot do instanceof check List<String>
        //**** Java Generics is a COMPILE TIME feature
        // Generic types are "erased" in runtime
        // boolean b = strings instanceof List<String>;
        boolean b = strings instanceof List;
    }
}
