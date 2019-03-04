package fr.lacombe.kata;

import java.util.List;
import java.util.ListIterator;

class FrameCursor {
    private final ListIterator<Frame> frameIterator;
    private final int maxNormalFrame;

    FrameCursor(List<Frame> frames, int maxNormalFrame) {
        frameIterator=frames.listIterator();
        this.maxNormalFrame = maxNormalFrame;
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

    boolean hasFrameToCalculate() {
        return frameIterator.hasNext() && frameIterator.nextIndex() < maxNormalFrame;
    }
}