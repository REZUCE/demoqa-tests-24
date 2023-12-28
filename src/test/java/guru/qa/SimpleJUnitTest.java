package guru.qa;

import org.junit.jupiter.api.*;

public class SimpleJUnitTest {

    // До всех тестов.
    @BeforeAll
    static void beforeAll() {
        System.out.println("##b all##");
    }

    // После всех тестов.
    @AfterAll
    static void afterAll() {
        System.out.println("##a all##");
    }


    // До каждого теста.
    @BeforeEach
    void beforeEach() {
        System.out.println("##b##");
    }

    // После каждого теста.
    @AfterEach
    void afterEach() {
        System.out.println("##a##");
    }

    @Test
    void firstTest() {
        Assertions.assertTrue(3 > 2);
    }

    @Test
    void secondTest() {
        Assertions.assertTrue(3 > 2);
    }
}
