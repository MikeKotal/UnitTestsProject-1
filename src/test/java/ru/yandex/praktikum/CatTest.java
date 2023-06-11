package ru.yandex.praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;
    Cat newCat;

    @Test
    public void getSoundTest() {
        newCat = new Cat(feline);
        Assert.assertEquals("Мяу", newCat.getSound());
    }

    @Test
    public void getFoodTest() throws Exception {
        newCat = new Cat(feline);
        List<String> foods = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(foods);
        Assert.assertEquals(foods, newCat.getFood());
    }
}