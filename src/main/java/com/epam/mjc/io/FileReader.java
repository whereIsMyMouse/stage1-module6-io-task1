package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class FileReader {

    File profileTxt = new File("src/main/resources");

    public Profile getDataFromFile(File file) {
        StringBuilder content = new StringBuilder();
        try (FileInputStream inputStream = new FileInputStream(file)) {
            int byteInt;
            while ((byteInt = inputStream.read()) != -1) {
                content.append((char) byteInt);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String dataProfile = content.toString();
        String sep = System.lineSeparator();
        String[] dataProfileSeparate = dataProfile.split(sep);
        String name = dataProfileSeparate[0].replaceFirst("Name: ", "");
        int age = Integer.parseInt(dataProfileSeparate[1].replaceFirst("Age: ", ""));
        String email = dataProfileSeparate[2].replaceFirst("Email: ", "");
        long phone = Long.parseLong(dataProfileSeparate[3].replaceFirst("Phone: ", ""));
        return new Profile(name, age, email, phone);

    }
}
