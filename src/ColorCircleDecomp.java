import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import acm.graphics.*;
import acm.program.*;

public class ColorCircleDecomp extends GraphicsProgram implements ActionListener {
	public static final int PROGRAM_WIDTH = 800;
	public static final int PROGRAM_HEIGHT = 600;
	public static final int BALL_SIZE = 50;
	public static final int DELAY_MS = 25;
	
	private GOval ball;
	private int degree;
	private int red;
	private int green;
	private int blue;
	
	
	public void run() {
		degree = 0;
		red = 0;
		green = 85;
		blue = 170;
		ball = new GOval(400, 500, BALL_SIZE, BALL_SIZE);
		ball.setColor(new Color(red, 0, 0));
		ball.setFilled(true);
		add(ball);
		
		Timer t = new Timer(DELAY_MS, this);
		t.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// System.out.println(Math.min(degree % 510, 510 - (degree % 510)));
		degree++;
		red = Math.min(degree % 510, 510 - (degree % 510));
		green = Math.min((degree + 85) % 510, 510 - ((degree + 85) % 510));
		blue = Math.min((degree + 170) % 510, 510 - ((degree + 170) % 510));
		System.out.println("red: " + red + ", green " + green + ", blue: " + blue);

		
		ball.setColor(new Color(red, green, blue));
		
		ball.movePolar(4, degree % 360);
	}

	public void init() {
		setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
	}
	
	public static void main(String args[]) {
		new ColorCircleDecomp().start();
	}
	
}
