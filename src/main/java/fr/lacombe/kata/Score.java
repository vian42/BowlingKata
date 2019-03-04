package fr.lacombe.kata;

import java.util.Objects;

public class Score {
    static final Score NULL_SCORE = valueOf(0);
    private final int value;

    private Score(int value) {
        this.value = value;
    }

    Score plus(Score addedScore) {
        return new Score(value + addedScore.value);
    }

    static Score valueOf(int i) {
        return new Score(i);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Score)) return false;
        Score score = (Score) o;
        return value == score.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Score{" +
                "value=" + value +
                '}';
    }
}
