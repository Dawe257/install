package com.dzhenetl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
	    // /Users/dzhenetl/Games
        StringBuilder log = new StringBuilder();
        File gamesDir = new File("/Users/dzhenetl/Games");

        File srcDir = new File(gamesDir, "src");
        File resDir = new File(gamesDir, "res");
        File savegames = new File(gamesDir, "savegames");
        File temp = new File(gamesDir, "temp");
        // 1
        createDirs(log, srcDir, resDir, savegames, temp);

        File main = new File(srcDir, "main");
        File test = new File(srcDir, "test");
        // 2
        createDirs(log, main, test);

        File mainJava = new File(main, "Main.java");
        File utilsJava = new File(main, "Utils.java");
        // 3
        createFiles(log, mainJava, utilsJava);

        File drawables = new File(resDir, "drawables");
        File vectors = new File(resDir, "vectors");
        File icons = new File(resDir, "icons");
        // 4
        createDirs(log, drawables, vectors, icons);

        File tempFile = new File(temp, "temp.txt");
        // 5
        createFiles(log, tempFile);

        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write(log.toString());
            writer.flush();
        } catch (IOException e) {

        }
    }

    public static void createDirs(StringBuilder log, File... dirs) {
        for (File dir : dirs) {
            if (dir.mkdir())
                log.append(dir.getName()).append(" - каталог создан\n");
            else
                log.append(dir.getName()).append(" - не удалось создать каталог\n");
        }
    }

    public static void createFiles(StringBuilder log, File... files) {
        for (File file : files) {
            try {
                if (file.createNewFile())
                    log.append(file.getName()).append(" - файл создан\n");
                else
                    log.append(file.getName()).append(" - не удалось создать файл\n");
            } catch (IOException e) {
                log.append(file.getName()).append(" - ошибка при создании файла\n");
            }
        }
    }
}
