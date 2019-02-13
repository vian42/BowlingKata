package fr.lacombe.kata;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static fr.lacombe.kata.Frame.FrameBuilder.aFrame;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
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
    @Parameters({"1", "2", "3", "4", "5", "6", "7", "8", "9"})
    public void given_a_game_with_one_frame_with_first_roll_knocking_down_a_number_of_pins_should_return_the_number(int pins) {
        Roll rollOne = new Roll(pins);
        Roll rollZero = new Roll(0);
        Frame frame = aFrame(rollOne).withSecondRoll(rollZero).build();
        Game game = new Game();
        game.addFrame(frame);
        assertThat(game.score()).isEqualTo(Score.valueOf(pins));
    }

    @Test
    @Parameters({"1", "2", "3", "4", "5", "6", "7", "8", "9"})
    public void given_a_game_with_one_frame_with_second_roll_knocking_down_a_number_of_pins_should_return_the_number(int pins) {
        Roll rollOne = new Roll(0);
        Roll rollZero = new Roll(pins);
        Frame frame = aFrame(rollOne).withSecondRoll(rollZero).build();
        Game game = new Game();
        game.addFrame(frame);
        assertThat(game.score()).isEqualTo(Score.valueOf(pins));
    }

    @Test
    public void given_a_game_with_two_frames_with_first_roll_with_one_pin_should_return_two() {
        Roll rollOne = new Roll(0);
        Roll rollZero = new Roll(1);
        Frame frame = aFrame(rollOne).withSecondRoll(rollZero).build();
        Game game = new Game();
        game.addFrame(frame);
        game.addFrame(frame);
        assertThat(game.score()).isEqualTo(Score.valueOf(2));
    }
}