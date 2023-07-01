package simple;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("simple")
@Feature("tests practice")
@Story("positive tests")
public class PositiveTests {
    @Test
    void someTest(){
        assertTrue(true);
    }

    @Test
    void someTest1(){
        assertTrue(true);
    }

    @Test
    void someTest2(){
        assertTrue(true);
    }

    @Test
    void someTest3(){
        assertTrue(true);
    }

    @Test
    void someTest4(){
        assertTrue(true);
    }

    @Test
    void someTest5(){
        assertTrue(true);
    }

    @Test
    void someTest6(){
        assertTrue(true);
    }
}
