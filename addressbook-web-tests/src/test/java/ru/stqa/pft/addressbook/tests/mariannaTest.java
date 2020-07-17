package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class mariannaTest {

    @Test
    public void mariannaTest(){

        List<String> mariannaList = new ArrayList<>();

        mariannaList.add("ilyaString");
        mariannaList.add("mariannaString");



        for (int i = 0; i <mariannaList.size() ; i++) {

            String myString = mariannaList.get(i);
            System.out.println(myString);
        }

    }
}
