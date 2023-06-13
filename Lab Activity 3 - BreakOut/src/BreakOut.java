import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class BreakOut extends GraphicsProgram {
    // defines the width and height of the window. library magic makes this work ig.
    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 620;

    // defines the number of bricks per row and number of rows.
    public static final int NUMBER_OF_BRICKS_PER_ROW = 10;
    public static final int ROWS = 10;

    // defines the height and width of the bricks.
    public static final int BRICK_HEIGHT = 10;
    public static final int BRICK_WIDTH = APPLICATION_WIDTH / NUMBER_OF_BRICKS_PER_ROW;

    // defines the height and width of the paddle.
    public static final int PADDLE_HEIGHT = 10;
    public static final int PADDLE_WIDTH = 60;

    // defines the radius of the ball.
    public static final int BALL_RADIUS = 10;

    public static final String FOREGROUND_COLOR = "#575279";

    // define the paddle.
    public GRect paddle = new GRect(PADDLE_WIDTH, PADDLE_HEIGHT);

    // define the ball.
    public GOval ball = new GOval(BALL_RADIUS, BALL_RADIUS);

    public GRect brick;

    // defines the x- and y- velocity of the ball.
    public static int ballXVelocity = 3;
    public static int ballYVelocity = 3;

    public void init() {

        // creates background.
        GRect background = new GRect(0, 0, APPLICATION_WIDTH, APPLICATION_HEIGHT);
        background.setFilled(true);
        background.setFillColor(Color.decode("#faf4ed"));
        background.setLineWidth(0);
        add(background);

        // array of colors
        String[] brickColors = {"#b4637a", "#b4637a", "#d7827e", "#d7827e", "#ea9d34", "#ea9d34", "#286983", "#286983", "#907aa9", "#907aa9"};

        // creates bricks.
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < NUMBER_OF_BRICKS_PER_ROW; j++) {
                brick = new GRect(BRICK_WIDTH, BRICK_HEIGHT);
                brick.setFilled(true);

                // sets brick colors per row.
                brick.setFillColor(Color.decode(brickColors[i]));

                brick.setColor(Color.decode("#faf4ed"));
                add(brick, j * BRICK_WIDTH, i * BRICK_HEIGHT + 60);
            }
        }

        // creates ball
        ball.setFilled(true);
        ball.setFillColor(Color.decode(FOREGROUND_COLOR));
        ball.setLineWidth(0);
        add(ball, APPLICATION_WIDTH / 2  - (BALL_RADIUS * 2), APPLICATION_HEIGHT / 2 - BALL_RADIUS);

        // creates paddle
        paddle.setFilled(true);
        paddle.setFillColor(Color.decode(FOREGROUND_COLOR));
        paddle.setLineWidth(0);
        add(paddle, APPLICATION_WIDTH / 2 - (PADDLE_WIDTH / 2), APPLICATION_HEIGHT - 40);

        // listens to mouse input
        addMouseListeners();
    }

    public void run() {
        while (true) {
            // set the ball to move at whatever the x- and y- velocities are currently set to.
            // the pause statement prevents it from going too fast.
            ball.move(ballXVelocity, ballYVelocity);
            pause(10);

            // reverses the ball's x velocity if it touches a wall.
            if (ball.getX() >= APPLICATION_WIDTH || ball.getX() <= 0) {
                ballXVelocity = -ballXVelocity;
            }

            // reverses the ball's y velocity if it touches the paddle. may change this completely.
            if (ball.intersects(paddle)) {
                ballYVelocity = -ballYVelocity;
            }
        }
    }

    public void mouseMoved(MouseEvent me) {
        // move the paddle as long as the mouse is within the window.
        if (me.getX() >= 0 && me.getX() <= APPLICATION_WIDTH) {
            paddle.setLocation(me.getX() - (PADDLE_WIDTH / 2), paddle.getY());
        }
    }

    public static void main(String[] args) {
        (new BreakOut()).start(args);
    }
}