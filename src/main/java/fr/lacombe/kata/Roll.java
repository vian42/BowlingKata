package fr.lacombe.kata;

class Roll {

    private final int value;

    Roll(int value) {
        this.value = value;
    }

    int plus(Roll secondRoll) {
        return value + secondRoll.value;
    }

    int getPins() {
        return value;
    }
}
