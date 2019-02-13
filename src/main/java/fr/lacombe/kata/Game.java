package fr.lacombe.kata;


import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Frame> frames = new ArrayList<>();

    public Score score() {
        return frames.parallelStream()
                .reduce(Score.valueOf(0),
                        (score, frame) -> score.plus(frame.computeScore()),
                        Score::plus);
    }

    public void addFrame(Frame frame) {
        this.frames.add(frame);
    }
}
