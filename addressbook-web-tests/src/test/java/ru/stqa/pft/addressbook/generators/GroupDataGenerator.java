package ru.stqa.pft.addressbook.generators;

import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GroupDataGenerator {
    public static void main(String[] args) {
        int count = Integer.parseInt(args[0]);// amount of groups
        File file = new File(args[1]); //path to file


        List<GroupData> groups = generateGroups(count); // data generation
        save(groups,file); // save data generation to file
    }

    private static void save(List<GroupData> groups, File file) {
    }

    private static List<GroupData> generateGroups(int count) {
        List<GroupData> groups = new ArrayList<GroupData>();// create new list
        for ( int i = 0 ; i< count; i ++){
            groups.add(new GroupData().withName(String.format("test &s",i))
                    .withHeader(String.format("header &s", i )).withFooter(String.format("footer &s", i)));

        }
        return groups;
    }

}
