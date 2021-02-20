package ru.yashkova.jsontomaven;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.ValueCodecProvider;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.jsr310.Jsr310CodecProvider;
import org.bson.codecs.pojo.PojoCodecProvider;
import ru.yashkova.jsontomaven.entity.Bundle;
import ru.yashkova.jsontomaven.entity.JsonFileClass;
import ru.yashkova.jsontomaven.entity.JsonParameters;
import ru.yashkova.jsontomaven.entity.Path;

import java.util.function.Consumer;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class Start {
    public static void main(String[] args) throws Exception {

        MongoClient mongoClient = new MongoClient("localhost", 2717);
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder()
                                .register(JsonFileClass.class, JsonParameters.class, Bundle.class, Path.class)
                                .build(),
                        new Jsr310CodecProvider(),
                        new ValueCodecProvider());


        MongoDatabase database = mongoClient.getDatabase("myMongoDb").withCodecRegistry(pojoCodecRegistry);

        ConverterService converter = new ConverterService();
        JsonFileClass jsonFileClass = converter.convert();

        MongoCollection<JsonFileClass> collection = database.getCollection("jsonFileClasses",JsonFileClass.class);

        collection.insertOne(jsonFileClass);

        collection.find().forEach((Consumer<JsonFileClass>) todo -> System.out.println(todo.toString()));

    }
}
