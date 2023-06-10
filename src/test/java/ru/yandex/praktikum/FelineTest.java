package ru.yandex.praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    Feline feline;
    Feline newFeline;

    @Test
    public void eatMeatTest() throws Exception {
        List<String> foods = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(foods, feline.eatMeat());
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void getFamilyTest() {
        newFeline = new Feline();
        Assert.assertEquals("Кошачьи", newFeline.getFamily());
    }

    @Test
    public void getKittensTest() {
        Mockito.when(feline.getKittens(1)).thenReturn(1);
        Assert.assertEquals(1, feline.getKittens());
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void getKittensOneKittenReturn() {
        newFeline = new Feline();
        Assert.assertEquals(1, newFeline.getKittens(1));
    }
}