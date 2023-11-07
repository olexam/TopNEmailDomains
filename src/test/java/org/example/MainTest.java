package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    ByteArrayOutputStream out;
    @BeforeEach
    void setUp() {
        InputStream in = getClass().getClassLoader().getResourceAsStream("examples.txt");
        System.setIn(in);
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Test
    void main() throws IOException {
        Main.main(new String[0]);
        final String string = out.toString();
        final String[] expected = {
                "ten.com 10",
                "nine.com 9",
                "eight.com 8",
                "seven.com 7",
                "six.com 6",
                "six2.com 6",
                "five.com 5",
                "four.com 4",
                "three.com 3",
                "two.com 2",
        };
        Assertions.assertArrayEquals(expected, string.split("\n"));
    }
}
