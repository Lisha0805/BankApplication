package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class ResourceConverter {
    private static final String defaultResourcePath = "src/main/resources/";

    public static <T> Object yamlToObject(String filename, Class<T>  className) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();
        return mapper.readValue(new File(defaultResourcePath + filename), className);
    }

    public static <T> Object jsonToObject(String filename, Class<T>  className) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(defaultResourcePath + filename), className);
    }

    public static void objectToJson(String filename, Object object) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(defaultResourcePath + filename), object);
        System.out.println("Data updated!");
    }

    public static void objectToYaml(String filename, Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.writeValue(new File(defaultResourcePath + filename), object);
    }
}