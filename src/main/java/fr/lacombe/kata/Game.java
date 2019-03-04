package fr.lacombe.kata;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Stream;

public class Game {
    private List<Frame> frames = new ArrayList<>();

    public Score score() {
        Score score = Score.valueOf(0);

        ListIterator<Frame> frameIterator = frames.listIterator();
        while (frameIterator.hasNext()) {
            Frame frame = frameIterator.next();
            Score addedScore = frame.computeScore();
            score = score.plus(addedScore);

            if (frame.isSpare() && frameIterator.hasNext()) {
                score = score.plus(frameIterator.next().getFirstRollPin());
                frameIterator.previous();
            }
        }
        return score;
    }

    public void addFrame(Frame frame) {
        this.frames.add(frame);
    }
}
