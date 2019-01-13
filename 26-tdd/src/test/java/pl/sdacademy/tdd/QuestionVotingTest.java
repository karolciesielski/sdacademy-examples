package pl.sdacademy.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class QuestionVotingTest {

    @DisplayName("given question with initial score 0 and author 'goobar', when upvoteBy the question by user 'foobar', then score is 1")
    @Test
    void test() throws Exception{
        // given
        Question question = new Question(0, "goobar");

        // when
        question.upvoteBy("foobar");

        // then
        assertThat(question.score()).isEqualTo(1);
    }

    @DisplayName("given question with initial score 0 and author 'goobar', when upvoteBy the question two times by user 'foobar', then score is 1")
    @Test
    void test1() throws Exception{
        // given
        Question question = new Question(0, "goobar");
        String user = "foobar";
        // whenS
        question.upvoteBy(user);
        question.upvoteBy(user);

        // then
        assertThat(question.score()).isEqualTo(1);
    }

    @DisplayName("given question with initial score 0 and author 'goobar', when upvoteBy the question by author, then score is 0")
    @Test
    void test2() throws Exception{
        // given
        String author = "goobar";
        Question question = new Question(0, author);

        // whenS
        question.upvoteBy(author);

        // then
        assertThat(question.score()).isEqualTo(0);
    }

    @DisplayName("given question with initial score 0 and author 'goobar', when upvoteBy the question by two different users, then score is 2")
    @Test
    void test3() throws Exception{
        // given
        Question question = new Question(0, "goobar");

        // whenS
        question.upvoteBy("foobar");
        question.upvoteBy("hoobar");

        // then
        assertThat(question.score()).isEqualTo(2);
    }

    @DisplayName("given question with initial score 100 and author 'goobar', when upvoteBy the question by user 'foobar, then score is 101")
    @Test
    void test4() throws Exception{
        // given
        Question question = new Question(100, "goobar");

        // whenS
        question.upvoteBy("foobar");

        // then
        assertThat(question.score()).isEqualTo(101);
    }

    @DisplayName("given question with initial score 50, when upvoteBy the question by 20 different users, then score is 70")
    @Test
    void test5() throws Exception{
        // given
        String author = "george";
        Question question = new Question(50, author);

        // whenS
        upvoteNTimesByUsersDifferentThan(20, author, question);

        // then
        assertThat(question.score()).isEqualTo(70);
    }

    private void upvoteNTimesByUsersDifferentThan(int score, String author, Question question) {
        for (int i = 0; i < score; i++) {
            question.upvoteBy("non" + author + i);
        }
    }
}
