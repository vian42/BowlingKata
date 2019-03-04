package fr.lacombe.kata;


import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Frame> frames = new ArrayList<>();

    public Score score() {
        Score score = Score.valueOf(0);
        for (int i = 0; i < frames.size(); i++) {
            Frame frame = frames.get(i);

            Score addedScore = frame.computeScore();
            score = score.plus(addedScore);

            if (frame.isSpare() && i + 1 < frames.size()) {
                score = score.plus(frames.get(i + 1).getFirstRollPin());
            }
        }
        return score;
    }

    public void addFrame(Frame frame) {
        this.frames.add(frame);
    }
}
