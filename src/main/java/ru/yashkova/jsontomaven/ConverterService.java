package ru.yashkova.jsontomaven;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.yashkova.jsontomaven.entity.JsonFileClass;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class ConverterService {
    private static final String SOURCE_FILE = "homework.parameters.json";
    //private static final String RESULT_FILE = "result.homework.parameters.xml";

    public JsonFileClass convert() throws IOException, URISyntaxException {
        ObjectMapper jsonMapper = new ObjectMapper();
        JsonFileClass jsonFileClass = jsonMapper.readValue(new File(SOURCE_FILE), JsonFileClass.class);
        return jsonFileClass;

        //XmlMapper xmlMapper = new XmlMapper();
        //xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        //File resultFile = new File(RESULT_FILE);
        //xmlMapper.writeValue(resultFile, jsonFileClass);
    }

    /*private URI getUri(String filename) {
        try {
            return getClass().getClassLoader().getResource(filename).toURI();
        } catch (URISyntaxException e) {
            throw new RuntimeException("Unable to get file path.");
        }
    }*/
}
