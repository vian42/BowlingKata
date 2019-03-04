package fr.lacombe.kata;

import java.util.ArrayList;
import java.util.List;

import static fr.lacombe.kata.Score.NULL_SCORE;

class Game {
    private FrameCursor frameCursor;
    private final List<Frame> frames = new ArrayList<>();
    private final int maxNormalFrame;

    Game(int maxNormalFrame) {
        this.maxNormalFrame = maxNormalFrame;
    }

    Score score() {
        Score score = NULL_SCORE;
        frameCursor = new FrameCursor(frames, maxNormalFrame);
        while (frameCursor.hasFrameToCalculate()) {
            Frame frame = frameCursor.getNextFrame();
            score = score.plus(computeFrameScore(frame));
        }
        return score;
    }

    private Score computeFrameScore(Frame frame) {
        Score frameScore = frame.computeScore();

        return frameScore.plus(computeSpareBonus(frame)).plus(computeStrikeBonus(frame));
    }

    private Score computeStrikeBonus(Frame frame) {
        Score bonusStrike = NULL_SCORE;
        if (frame.isStrike() && frameCursor.hasNextFrame()) {
            Frame next = frameCursor.getNextFrame();
            bonusStrike = next.computeScore();
            if (next.isStrike() && frameCursor.hasNextFrame()) {
                bonusStrike = bonusStrike.plus(getNextRollScore());
            }
            frameCursor.getPreviousFrame();
        }
        return bonusStrike;
    }

    private Score computeSpareBonus(Frame frame) {
        Score bonusSpare = NULL_SCORE;
        if (frame.isSpare() && frameCursor.hasNextFrame()) {
            bonusSpare = getNextRollScore();
        }
        return bonusSpare;
    }

    private Score getNextRollScore() {
        Frame nextFrame = frameCursor.getNextFrame();
        Score firstRollPin = nextFrame.getFirstRollPin();
        frameCursor.getPreviousFrame();
        return firstRollPin;
    }

    void addFrame(Frame frame) {
        this.frames.add(frame);
    }
}
