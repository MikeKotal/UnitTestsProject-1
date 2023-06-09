package ru.yandex.praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private final String sex;
    private final boolean expectedHasMane;
    @Mock
    Feline feline;

    public LionParameterizedTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getLionInfo() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
                {"Тест", false}
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void doesHaveManeCheckConstructorConditionsTest() {
        String exception = "Используйте допустимые значения пола животного - самец или самка";
        try {
            Lion lion = new Lion(sex, feline);
            Assert.assertEquals(expectedHasMane, lion.doesHaveMane());
        } catch (Exception e) {
            Assert.assertEquals(exception, e.getMessage());
        }
    }
}