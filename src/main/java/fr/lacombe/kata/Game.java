package fr.lacombe.kata;


import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Frame> frames = new ArrayList<>();

    public Score score() {
        Score score = Score.valueOf(0);
        for (Frame frame : frames) {
            score = score.plus(frame.computeScore());
        }
        return score;
    }

    public void addFrame(Frame frame) {
        this.frames.add(frame);
    }
}
