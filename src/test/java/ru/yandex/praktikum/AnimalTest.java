package ru.yandex.praktikum;

import org.junit.Assert;
import org.junit.Test;

public class AnimalTest {

    Animal animal;

    @Test(expected = Exception.class)
    public void getFoodNegativeTest() throws Exception {
        animal = new Animal();
        animal.getFood("Млекопитающее");
    }

    @Test
    public void getFamilyTest() {
        animal = new Animal();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        Assert.assertEquals(expected, animal.getFamily());
    }
}