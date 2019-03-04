package fr.lacombe.kata;


import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import static fr.lacombe.kata.Score.*;

class Game {
    private List<Frame> frames = new ArrayList<>();
    private ListIterator<Frame> frameIterator;

    Score score() {
        Score score = NULL_SCORE;

        frameIterator = frames.listIterator();
        while (frameIterator.hasNext()) {
            Frame frame = frameIterator.next();
            Score frameScore = getScore(frame);
            score = score.plus(frameScore);
        }
        return score;
    }

    private Score getScore(Frame frame) {
        Score frameScore = frame.computeScore();

        Score bonusStrike = getStrikeBonus(frame);

        Score bonusSpare = getSpareBonus(frame);

        return frameScore.plus(bonusSpare).plus(bonusStrike);
    }

    private Score getStrikeBonus(Frame frame) {
        Score bonusStrike = NULL_SCORE;
        if (frame.isStrike() && frameIterator.hasNext()) {
            bonusStrike = frameIterator.next().computeScore();
            frameIterator.previous();
        }
        return bonusStrike;
    }

    private Score getSpareBonus(Frame frame) {
        Score bonusSpare = NULL_SCORE;
        if (frame.isSpare() && frameIterator.hasNext()) {
            bonusSpare = frameIterator.next().getFirstRollPin();
            frameIterator.previous();
        }
        return bonusSpare;
    }

    void addFrame(Frame frame) {
        this.frames.add(frame);
    }
}
