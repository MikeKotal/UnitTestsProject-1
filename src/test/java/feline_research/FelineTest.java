package feline_research;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    Feline feline;
    Feline newFeline;

    @Test
    public void eatMeatTest() throws Exception {
        List<String> foods = List.of("Животные", "Птицы", "Рыба");
        assertEquals(foods, feline.eatMeat());
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void getFamilyTest() {
        newFeline = new Feline();
        assertEquals("Кошачьи", newFeline.getFamily());
    }

    @Test
    public void getKittensTest() {
        Mockito.when(feline.getKittens(1)).thenReturn(1);
        assertEquals(1, feline.getKittens());
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void getKittensOneKittenReturn() {
        newFeline = new Feline();
        assertEquals(1, newFeline.getKittens(1));
    }
}