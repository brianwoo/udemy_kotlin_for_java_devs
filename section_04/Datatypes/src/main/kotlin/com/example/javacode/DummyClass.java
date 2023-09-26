package com.example.javacode;

public class DummyClass {

    public String isVacationTime(boolean onVacation) {
        return onVacation ? "I'm on vcation" : "I am working";
    }

    public void printNumbers(int[] numbers) {
        for (int number : numbers) {
            System.out.println("Java: " + number);
        }
    }
}
