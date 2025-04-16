package memory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemoryFinderTest {

    @Test
    void get() throws Exception {
        //given
        MemoryFinder memoryFinder = new MemoryFinder();

        //when
        Memory memory = memoryFinder.get();

        //then
        assertNotNull(memory);
    }

}