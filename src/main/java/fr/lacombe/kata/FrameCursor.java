package fr.lacombe.kata;

import java.util.List;
import java.util.ListIterator;

class FrameCursor {
    private final ListIterator<Frame> frameIterator;

    FrameCursor(List<Frame> frames) {
        frameIterator=frames.listIterator();
    }

    void getPreviousFrame() {
        frameIterator.previous();
    }

    boolean hasNextFrame() {
        return frameIterator.hasNext();
    }

    Frame getNextFrame() {
        return frameIterator.next();
    }
}