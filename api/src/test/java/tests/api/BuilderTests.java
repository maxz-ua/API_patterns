package tests.api;

import org.example.api.helper.model.UserModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BuilderTests {

    @Test
    public void builderTest() {
        // Create first UserModel instance with full attributes using the builder pattern
        UserModel user1 = UserModel.builder()
                .age(20)
                .salary(300.000)
                .isMarried(false)
                .password("testPassword")
                .username("testName")
                .build();  // Build the user1 object with the above properties

        // Create second UserModel instance with partial attributes using the builder pattern
        UserModel user2 = UserModel.builder()
                .password("secondPassword")
                .username("secondName")
                .build();  // Build the user2 object with the above properties (default values for age, salary, and isMarried)

        // Output both user objects to the console ( change 2 logger if u want :)
        System.out.println(user1);
        System.out.println(user2);

        // Assert that the two UserModel objects are not equal
        // If they are equal, the test will fail with the message "Values should not be equal"
        assertNotEquals(user1, user2, "Values should not be equal");
    }
}
