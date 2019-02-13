package fr.lacombe.kata;


public class Game {
    private Frame frame;

    public Game() {

    }

    public Score score() {
        return frame.computeScore();
    }

    public void addFrame(Frame frame) {
        this.frame = frame;
    }
}
