package edu.junior;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Author: eukovko
 * Date: 11/16/2020
 */
class MainTest {

    PrintStream originalOut;
    PrintStream printStream;
    ByteArrayOutputStream byteArrayOutputStream;

    @BeforeEach
    void setUp() {
        originalOut = System.out;
        byteArrayOutputStream = new ByteArrayOutputStream();
        printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);
    }

    @Test
    void testMain(){

        Main.main(null);
        String expected = "Hello World";
        String actual = byteArrayOutputStream.toString();
        assertThat(actual.trim()).isEqualTo(expected);

    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        printStream.close();
    }
}