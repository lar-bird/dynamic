package com.example;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.io.IOException;

@RestController
public class TextFileController {

    private static final String FILE_PATH = "output.txt";

    @PostMapping("/appendText")
    public String appendText(@RequestBody String newText) {
        try (FileWriter fileWriter = new FileWriter(FILE_PATH, true)) {
            fileWriter.write(newText + "\n");
            return "Text appended successfully!";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error appending text.";
        }
    }
}
