package pl.sdacademy.tdd;

import java.util.HashSet;
import java.util.Set;

public class Question {
    private int score;
    private boolean questionAlreadyVoter;
    private String author;
    private Set<String> voters;

    public Question(int score, String author) {
        questionAlreadyVoter = false;
        this.author = author;
        this.score = score;
        voters = new HashSet<>();
    }

    public void upvoteBy(String user) {
        if (userCanVote(user)) {
            voters.add(user);
            score++;
        }
    }

    private boolean userCanVote(String user) {
        return !voters.contains(user) && !author.equals(user);
    }

    public int score() {
        return score;
    }
}
