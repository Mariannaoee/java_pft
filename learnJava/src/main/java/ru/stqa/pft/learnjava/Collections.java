package ru.stqa.pft.learnjava;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {
    public  static void main (String[]args){
        String [] langs= {"Java", "Python", "Ruby","PHP"};

        List<String> languages = Arrays.asList("Java", "Python", "Ruby","PHP");

        for (String l : languages){
            System.out.println("I want to learn " + l);

        }
    }
}
