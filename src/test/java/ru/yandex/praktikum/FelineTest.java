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
    @Mock
    Feline newFeline;
    @Mock
    Animal animal;

    @Test
    public void eatMeatTest() throws Exception {
        List<String> foods = List.of("Животные", "Птицы", "Рыба");
        Assert.assertArrayEquals(foods.toArray(), feline.eatMeat().toArray());
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void getFamilyTest() {
        Assert.assertEquals("Кошачьи", feline.getFamily());
        Mockito.verify(feline, Mockito.times(1)).getFamily();
    }

    @Test
    public void getKittensTest() {
        Mockito.when(feline.getKittens(1)).thenReturn(1);
        Assert.assertEquals(1, feline.getKittens());
        Mockito.verify(feline, Mockito.times(1)).getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void getKittensOneKittenReturn() {
        Assert.assertEquals(1, feline.getKittens(1));
        Mockito.verify(feline, Mockito.times(1)).getKittens(anyInt());
    }
}