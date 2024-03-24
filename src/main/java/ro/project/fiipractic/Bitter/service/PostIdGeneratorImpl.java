package ro.project.fiipractic.Bitter.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PostIdGeneratorImpl implements PostIdGenerator {
    public String generateId(String userName, String message)
    {
        Random rand = new Random();
        String id = userName.concat(message.substring(0,3));
        int randomNumber  = rand.nextInt(10000);
        id = id.concat(Integer.toString(randomNumber));
        return id;
    }
}
