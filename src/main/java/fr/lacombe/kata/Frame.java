package fr.lacombe.kata;

import static fr.lacombe.kata.Score.valueOf;

public class Frame {
    public static final int MAX_PINS = 10;
    private final Roll firstRoll;
    private final Roll secondRoll;

    private Frame(Roll firstRoll, Roll secondRoll) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
    }

    private Frame(Roll firstRoll) {
        this(firstRoll, null);
    }

    public Score computeScore() {
        return isStrike() ? valueOf(firstRoll.getPins()): valueOf(firstRoll.plus(secondRoll));
    }

    boolean isStrike() {
        return MAX_PINS == firstRoll.getPins();
    }

    public Score getFirstRollPin() {
        return valueOf(firstRoll.getPins());
    }

    boolean isSpare() {
        return firstRoll.getPins()<MAX_PINS && valueOf(MAX_PINS).equals(computeScore());
    }

    public static class FrameBuilder {
        private final Roll firstRoll;
        private Roll secondRoll;

        public FrameBuilder(Roll firstRoll) {
            this.firstRoll = firstRoll;
        }

        public static FrameBuilder aFrame(Roll firstRoll) {
            return new FrameBuilder(firstRoll);
        }

        public Frame build() {
            if (secondRoll != null)
                return new Frame(firstRoll, secondRoll);
            return new Frame(firstRoll);
        }

        public FrameBuilder withSecondRoll(Roll roll) {
            this.secondRoll = roll;
            return this;
        }
    }
}
