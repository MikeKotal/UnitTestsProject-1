package ru.yandex.praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;
    Lion newLion;

    @Test
    public void getKittensTest() throws Exception {
        newLion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        Assert.assertEquals(1, newLion.getKittens());
    }

    @Test
    public void doesHaveManeTest() throws Exception {
        newLion = new Lion("Самка", feline);
        assertFalse(newLion.doesHaveMane());
    }

    @Test
    public void getFoodTest() throws Exception {
        newLion = new Lion("Самец", feline);
        List<String> foods = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood(anyString())).thenReturn(foods);
        Assert.assertEquals(foods, newLion.getFood());
    }

    @Test(expected = Exception.class)
    public void negativeTestConstructorConditions() throws Exception {
        newLion = new Lion("Нейтральный", feline);
    }
}