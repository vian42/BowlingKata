package fr.lacombe.kata;

import static fr.lacombe.kata.Score.valueOf;

class Roll {

    private final int value;

    Roll(int value) {
        this.value = value;
    }

    int plus(Roll secondRoll) {
        return value + secondRoll.value;
    }

    Score computeScore() {
        return valueOf(value);
    }

    boolean hasPins(int pins) {
        return pins == value;
    }
}
