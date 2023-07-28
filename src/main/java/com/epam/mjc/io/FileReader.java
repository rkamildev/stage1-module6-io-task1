package com.epam.mjc.io;

import java.io.*;

public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String line = reader.readLine();
            while (line != null) {
                String[] attr = line.split(":\\s+");
                if (attr[0].equals("Name"))
                    profile.setName(attr[1]);
                if (attr[0].equals("Age"))
                    profile.setAge(Integer.valueOf(attr[1]));
                if (attr[0].equals("Email"))
                    profile.setEmail(attr[1]);
                if (attr[0].equals("Phone"))
                    profile.setPhone(Long.valueOf(attr[1]));
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return profile;
    }
}
