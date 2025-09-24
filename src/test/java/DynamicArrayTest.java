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
    }

    @org.junit.jupiter.api.Test
    void testAdd() {
    }

    @org.junit.jupiter.api.Test
    void get() {
    }

    @org.junit.jupiter.api.Test
    void size() {
    }

    @org.junit.jupiter.api.Test
    void indexOf() {
    }

    @org.junit.jupiter.api.Test
    void lastIndexOf() {
    }

    @org.junit.jupiter.api.Test
    void remove() {
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