import org.example.DynamicArray;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicArrayTest {

    DynamicArray numbers;
    DynamicArray strings;

    Integer[] arNumbers={10,7,11,-2,13,10};
    String[] arStrings={"abc", "lmn", "fg", "abc"};

    @BeforeEach
    void setUp() {
        numbers = new DynamicArray(1);
        for (int i=0; i<arNumbers.length;i++)
            numbers.add(arNumbers[i]);

        strings = new DynamicArray();
        for (String str: arStrings)
            strings.add(str);
    }

    @Disabled
    @AfterEach
    void tearDown() {
    }

    @Test
    void add() {
        numbers.add(18);
        assertArrayEquals(new Integer[]{10,7,11,-2,13,10,18}, numbers.toArray());

        numbers.add(19);
        assertArrayEquals(new Integer[]{10,7,11,-2,13,10,18,19}, numbers.toArray());

        numbers.add(25);
        assertArrayEquals(new Integer[]{10,7,11,-2,13,10,18,19,25}, numbers.toArray());

        numbers.add(5);
        assertArrayEquals(new Integer[]{10,7,11,-2,13,10,18,19,25,5}, numbers.toArray());

        numbers.add(3);
        assertArrayEquals(new Integer[]{10,7,11,-2,13,10,18,19,25,5,3}, numbers.toArray());

        numbers.add(12);
        assertArrayEquals(new Integer[]{10,7,11,-2,13,10,18,19,25,5,3,12}, numbers.toArray());

        numbers.add(8);
        assertArrayEquals(new Integer[]{10,7,11,-2,13,10,18,19,25,5,3,12,8}, numbers.toArray());

        numbers.add(0);
        assertArrayEquals(new Integer[]{10,7,11,-2,13,10,18,19,25,5,3,12,8,0}, numbers.toArray());

        numbers.add(-4);
        assertArrayEquals(new Integer[]{10,7,11,-2,13,10,18,19,25,5,3,12,8,0,-4}, numbers.toArray());

        numbers.add(7);
        assertArrayEquals(new Integer[]{10,7,11,-2,13,10,18,19,25,5,3,12,8,0,-4,7}, numbers.toArray());

        numbers.add(2);
        assertArrayEquals(new Integer[]{10,7,11,-2,13,10,18,19,25,5,3,12,8,0,-4,7,2}, numbers.toArray());

        numbers.add(6);
        assertArrayEquals(new Integer[]{10,7,11,-2,13,10,18,19,25,5,3,12,8,0,-4,7,2,6}, numbers.toArray());

        numbers.add(14);
        assertArrayEquals(new Integer[]{10,7,11,-2,13,10,18,19,25,5,3,12,8,0,-4,7,2,6,14}, numbers.toArray());

        numbers.add(1);
        assertArrayEquals(new Integer[]{10,7,11,-2,13,10,18,19,25,5,3,12,8,0,-4,7,2,6,14,1}, numbers.toArray());
    }

    @org.junit.jupiter.api.Test
    void get() {
        assertEquals(10, numbers.get(0));
        assertEquals(-2, numbers.get(3));
        assertEquals(10, numbers.get(5));
        assertNull(numbers.get(-1));
        assertNull(numbers.get(6));
    }

    @org.junit.jupiter.api.Test
    void size() {
        assertEquals(6, numbers.size());
        for (int i=7; i<20; i++)
        {
            numbers.add(9);
            assertEquals(i, numbers.size());
        }
    }

    @org.junit.jupiter.api.Test
    void indexOf() {
        assertEquals(0, numbers.indexOf(10));
        assertEquals(3, numbers.indexOf(-2));
        assertEquals(-1, numbers.indexOf(null));
        assertEquals(-1, numbers.indexOf(999));
    }

    @org.junit.jupiter.api.Test
    void lastIndexOf() {
        assertEquals(5, numbers.lastIndexOf(10));
        assertEquals(3, numbers.lastIndexOf(-2));
        assertEquals(-1, numbers.lastIndexOf(null));
        assertEquals(-1, numbers.lastIndexOf(999));
    }

    @org.junit.jupiter.api.Test
    void removeByIndex() {
        //{10,7,11,-2,13,10}
        var res = numbers.removeByIndex(0);
        assertArrayEquals(new Integer[]{7,11,-2,13,10}, numbers.toArray());
        assertEquals(10, res);
        res = numbers.removeByIndex(4);
        assertEquals(10, res);
        assertArrayEquals(new Integer[]{7,11,-2,13}, numbers.toArray());
        res = numbers.removeByIndex(2);
        assertArrayEquals(new Integer[]{7,11,13}, numbers.toArray());
        assertEquals(-2, res);

    }

    @org.junit.jupiter.api.Test
    void removeItem() {
        //{10,7,11,-2,13,10}
        var res = numbers.removeItem(11);
        assertArrayEquals(new Integer[]{10, 7,-2,13,10}, numbers.toArray());
        assertTrue(res);
        res = numbers.removeItem(4);
        assertArrayEquals(new Integer[]{10, 7,-2,13,10}, numbers.toArray());
        assertFalse(res);
        res = numbers.removeItem(-2);
        assertArrayEquals(new Integer[]{10, 7,13,10}, numbers.toArray());
        assertTrue(res);
    }


    @org.junit.jupiter.api.Test
    void testRemove() {
    }

    @org.junit.jupiter.api.Test
    void contains() {
    }

    @org.junit.jupiter.api.Test
    void toArray() {
    }
}