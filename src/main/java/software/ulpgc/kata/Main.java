package software.ulpgc.kata;

import software.ulpgc.kata.control.TitleReader;
import software.ulpgc.kata.control.TsvTitleReader;
import software.ulpgc.kata.model.Title;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        TitleReader reader = new TsvTitleReader(new File("src/main/resources/title.basics.tsv"));
        List<Title> titles = reader.read();
        Map<Title.TitleType, Integer> titlesByType = new HashMap<>();
        titles.forEach(t -> {
            titlesByType.putIfAbsent(t.titleType(), 0);
            titlesByType.computeIfPresent(t.titleType(), (tt, i) -> i + 1);
        });
        System.out.println(titlesByType);
    }
}
