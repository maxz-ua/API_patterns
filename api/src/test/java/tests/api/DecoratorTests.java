package tests.api;


import org.example.api.helper.model.UserModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import patterns.observer.LoggingExtension;
import patterns.observer.RandomUser;
import patterns.observer.RandomUserResolver;


@ExtendWith({LoggingExtension.class, RandomUserResolver.class}) //can attach new behaviors
public class DecoratorTests {

    @Test
    public void coolLoggingTest(){
        System.out.println("Body");
        Assertions.assertTrue(20<50);
    }

    @Test
    public void deskTopTest(@RandomUser UserModel user){
        System.out.println(user.getUsername());
        System.out.println(user.getAge());
    }
}
