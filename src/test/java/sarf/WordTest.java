package sarf;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WordTest {

    @Test
    void testToString() {
        assertThat(new Word("").toString()).isEqualTo("");
        assertThat(new Word("ب").toString()).isEqualTo("ب");
    }

    @Test
    void isEmpty() {
        assertThat(new Word("").isEmpty()).isTrue();
        assertThat(new Word("و").isEmpty()).isFalse();
    }

    @Test
    void contains() {
        assertThat(new Word("").contains("f")).isFalse();
        assertThat(new Word("سمر").contains("f")).isFalse();
        assertThat(new Word("سمر").contains("مر")).isTrue();
        assertThat(new Word("سمر").contains("سمر")).isTrue();
        assertThat(new Word("سمر").contains("")).isTrue();
    }

    @Test
    void replaceAll() {
    }

    @Test
    void endsWith() {
    }

    @Test
    void lastIndexOf() {
    }

    @Test
    void substring() {
    }

    @Test
    void append() {
    }
}