package fr.lacombe.kata;

public class Frame {
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
        return Score.valueOf(firstRoll.plus(secondRoll));
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
