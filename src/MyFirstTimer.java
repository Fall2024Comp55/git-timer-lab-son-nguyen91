import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

public class MyFirstTimer extends GraphicsProgram implements ActionListener {
	public static final int PROGRAM_HEIGHT = 600;
	public static final int PROGRAM_WIDTH = 800;
	public static final int MAX_STEPS = 20;
	private GLabel myLabel;
	
	private int count;
	private Timer t;

	public void init() {
		setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
		requestFocus();
	}
	
	public void run() {
		myLabel = new GLabel("# of times called?", 0, 100);
		add(myLabel);
		count = 0;
		
		t = new Timer(1000, this);
		t.start();
	
	}
	
	public void actionPerformed(ActionEvent e) {
		myLabel.move(5, 0);
		count++;

		myLabel.setLabel("times called? " + count);
		if (count == 10) {
			t.stop();
		}
	}
	
	public static void main(String[] args) {
		new MyFirstTimer().start();
	}
}