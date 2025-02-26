package org.example.context;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CustomContext {
    private Map<String, Data> beans;
    public CustomContext(String configPath) {
        init(configPath);

    }

    private void init(String configPath) {
        beans = new HashMap<>();

        Path path  = Path.of(configPath);

        try {
            List<String> lines = Files.readAllLines(path);
            lines.forEach(elements -> {
                String[] split = elements.split("=");
                if (split.length > 1) {
                    Data data = buildData(split[1]);
                    beans.put(split[0], data);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private Data buildData(String classPath) {
        try {
            Class<?> classType = Class.forName(classPath);
            Object instance = classType.getDeclaredConstructor().newInstance();
            return new Data(instance, classType);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static class Data {
        Object instance;
        Class<?> classType;

        public Data(Object instance, Class<?> classType) {
            this.instance = instance;
            this.classType = classType;
        }
    }
}
