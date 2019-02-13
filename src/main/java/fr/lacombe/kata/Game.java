package fr.lacombe.kata;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;


public class Game {
    public Game(List<Frame> frames) {
        throw new NotImplementedException();
    }

    public Game() {

    }

    public Score score() {
        return Score.valueOf(0);
    }

    public void addFrame(Frame build) {
    }
}
