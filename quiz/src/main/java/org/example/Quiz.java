package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Quiz {
    File quizJson;
    public Quiz(String fileName){
        String file = Objects.requireNonNull(this.getClass().getClassLoader().getResource(fileName).getFile());
        quizJson = new File(file);
    }

    public void displayQuestions() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Questions> questions = mapper.readValue(quizJson, new TypeReference<>(){});

        questions.stream().map(Questions::getPytanie).forEach(System.out::println);

    }
    public  void play() throws IOException {
        Scanner scanner = new Scanner(System.in);
        ObjectMapper mapper = new ObjectMapper();
        List<Questions> questions = mapper.readValue(quizJson, new TypeReference<>(){});
        for (Questions question : questions) {
            System.out.println(question.getPytanie());
            System.out.println("a: " + question.getA());
            System.out.println("b: " + question.getB());
            System.out.println("c: " + question.getC());
            System.out.println("d: " + question.getD());
            System.out.println("Podaj odpowiedź a, b, c, d ");

            String answer = scanner.next();

            if(question.getPrawidlowaOdpowiedz().equals(answer)){
                System.out.println("BARWO! To prawidowa odpowiedź");
            } else{
                System.out.println(question.getPrawidlowaOdpowiedz());
            }




        }
        scanner.close();
    }
}
