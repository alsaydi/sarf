package sarf;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SeparatedPronounsContainerTest {

    @Test
    void getPronouns() {
       var actual = SeparatedPronounsContainer.getPronouns();
       assertThat(actual).isNotNull();
       assertThat(actual.size()).isEqualTo(13);

       assertThat(actual.get(0)).isEqualTo("أنا");
       assertThat(actual.get(1)).isEqualTo("نحن");
       assertThat(actual.get(2)).isEqualTo("أنتَ");
       assertThat(actual.get(3)).isEqualTo("أنتِ");
       assertThat(actual.get(4)).isEqualTo("أنتما");
       assertThat(actual.get(5)).isEqualTo("أنتم");
       assertThat(actual.get(6)).isEqualTo("أنتنَّ");
       assertThat(actual.get(7)).isEqualTo("هو");
       assertThat(actual.get(8)).isEqualTo("هي");
       assertThat(actual.get(9)).isEqualTo("هما(مذ)");
       assertThat(actual.get(10)).isEqualTo("هما(مؤ)");
       assertThat(actual.get(11)).isEqualTo("هم");
       assertThat(actual.get(12)).isEqualTo("هنَّ");
    }
}