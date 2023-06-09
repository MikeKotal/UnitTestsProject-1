package ru.yandex.praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;

@RunWith(Parameterized.class)
public class AnimalParameterizedTest {

    private final String animalKind;
    private final List<String> foods;
    @Spy
    Feline feline;

    public AnimalParameterizedTest(String animalKind, List<String> foods) {
        this.animalKind = animalKind;
        this.foods = foods;
    }

    @Parameterized.Parameters
    public static Object[][] getLionInfo() {
        return new Object[][] {
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
                {"Млекопитающее", List.of("Молоко")}
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getFoodCheckConditionsTest() {
        String exception = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        try {
            Assert.assertArrayEquals(foods.toArray(), feline.getFood(animalKind).toArray());
            Mockito.verify(feline, Mockito.times(1)).getFood(anyString());
        } catch (Exception e) {
            Assert.assertEquals(exception, e.getMessage());
        }
    }
}