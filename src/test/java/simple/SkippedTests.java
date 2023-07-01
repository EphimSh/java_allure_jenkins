package simple;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
@Tag("simple")
@Feature("tests practice")
@Story("skipped tests")
public class SkippedTests {
    @Test
    @Disabled
    void someTest(){
        assertTrue(true);
    }

    @Test
    @Disabled
    void someTest1(){
        assertTrue(true);
    }

    @Test
    @Disabled
    void someTest2(){
        assertTrue(true);
    }

    @Test
    @Disabled
    void someTest3(){
        assertTrue(true);
    }


}
