package fr.lacombe.kata;

public class Roll {

    private final int value;

    public Roll(int value) {
        this.value = value;
    }

    public int plus(Roll secondRoll) {
        return value + secondRoll.value;
    }
}
