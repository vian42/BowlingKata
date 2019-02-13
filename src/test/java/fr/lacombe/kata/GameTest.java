package fr.lacombe.kata;

import org.junit.Test;

import static fr.lacombe.kata.Frame.FrameBuilder.aFrame;
import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test
    public void given_a_game_with_one_frame_with_two_zero_rolls_should_return_zero() {
        Roll rollZero = new Roll(0);
        Frame frame = aFrame(rollZero).withSecondRoll(rollZero).build();
        Game game = new Game();
        game.addFrame(frame);
        assertThat(game.score()).isEqualTo(Score.valueOf(0));
    }

    @Test
    public void given_a_game_with_one_frame_with_one_roll_with_one_pin_should_return_one() {
        Roll rollOne = new Roll(1);
        Roll rollZero = new Roll(0);
        Frame frame = aFrame(rollOne).withSecondRoll(rollZero).build();
        Game game = new Game();
        game.addFrame(frame);
        assertThat(game.score()).isEqualTo(Score.valueOf(1));
    }
}