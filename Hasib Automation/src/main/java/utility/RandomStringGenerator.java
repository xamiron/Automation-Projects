package utility;

import com.github.javafaker.Faker;

public class RandomStringGenerator {
    private final Faker faker;

    public RandomStringGenerator() {
        this.faker = new Faker();
    }

    public String generateRandomString(int length) {
        return faker.lorem().characters(length);
    }
}
