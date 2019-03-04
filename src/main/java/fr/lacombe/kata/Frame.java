package fr.lacombe.kata;

import static fr.lacombe.kata.Score.valueOf;

class Frame {
    private static final int MAX_PINS = 10;
    private final Roll firstRoll;
    private final Roll secondRoll;

    private Frame(Roll firstRoll, Roll secondRoll) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
    }

    Score computeScore() {
        return isStrike() ? firstRoll.computeScore() : valueOf(firstRoll.plus(secondRoll));
    }

    boolean isStrike() {
        return firstRoll.hasPins(MAX_PINS);
    }

    Score getFirstRollPin() {
        return firstRoll.computeScore();
    }

    boolean isSpare() {
        return !firstRoll.hasPins(MAX_PINS) && valueOf(MAX_PINS).equals(computeScore());
    }

    static class FrameBuilder {
        private final Roll firstRoll;
        private Roll secondRoll;

        FrameBuilder(Roll firstRoll) {
            this.firstRoll = firstRoll;
        }

        static FrameBuilder aFrame(Roll firstRoll) {
            return new FrameBuilder(firstRoll);
        }

        Frame build() {
            if (secondRoll != null)
                return new Frame(firstRoll, secondRoll);
            return new Frame(firstRoll, new Roll(0));
        }

        FrameBuilder withSecondRoll(Roll roll) {
            this.secondRoll = roll;
            return this;
        }
    }
}
