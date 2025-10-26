package org.example;

import java.io.File;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Stream;

public class FileManager {

    public void listFilesInDirectory(String directory) {
        Stream.of(Objects.requireNonNull(new File(directory).listFiles()))
                .filter(File::isFile)
                .map(File::getName)
                .forEach(System.out::println);
    }
    public void sortFilesInDirectly(String directory){
            Stream.of(Objects.requireNonNull(new File(directory).listFiles()))
                    .filter(File::isFile)
                    .sorted(new Comparator<File>() {
                        @Override
                        public int compare(File o1, File o2) {
                            return Long.compare(o2.length(), o1.length());
                        }
                    })
                    .forEach(file -> {
                        System.out.println(file.getName());
                        System.out.println(file.length());
                    });
        }


}
