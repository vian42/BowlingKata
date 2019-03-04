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
        while (hasNextFrame()) {
            Frame frame = getNextFrame();
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
        if (frame.isStrike() && hasNextFrame()) {
            Frame next = getNextFrame();
            bonusStrike = next.computeScore();
            if (next.isStrike()) {
                bonusStrike = bonusStrike.plus(getNextRollScore());
            }
            getPreviousFrame();
        }
        return bonusStrike;
    }

    private Score getSpareBonus(Frame frame) {
        Score bonusSpare = NULL_SCORE;
        if (frame.isSpare() && hasNextFrame()) {
            bonusSpare = getNextRollScore();
        }
        return bonusSpare;
    }

    private Score getNextRollScore() {
        Score firstRollPin = getNextFrame().getFirstRollPin();
        getPreviousFrame();
        return firstRollPin;
    }

    private Frame getPreviousFrame() {
        return frameIterator.previous();
    }

    private boolean hasNextFrame() {
        return frameIterator.hasNext();
    }

    private Frame getNextFrame() {
        return frameIterator.next();
    }

    void addFrame(Frame frame) {
        this.frames.add(frame);
    }
}
