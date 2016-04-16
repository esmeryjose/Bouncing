import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 * 
 * @author Esmery Corniel
 *
 */
public class MainClass extends JPanel implements ActionListener, AlarmListener {
	//the frame
	private JFrame frame;
	//the width and height 
	private int height,width;
	//the coordinates, index of the color, and the size of the ball
	private int ballX, ballY, colorIndex, ballSize = 50;
	// a temporary variable that hold the value of speed
	private int period = 50;
	//String that holds the reference to the title of the frame
	private String title;
	//creates the toggle button
	private JToggleButton toggle;
	//a sting that hold the names that will be use for the toggle buttons
	private String[] TOGGLE_STR = {"Pause", "Play"};
	//this variable will help us switch between 
	private int toggleMode;
	//the array of buttons
	private JButton [] button;
	//hold a reference of all the names for the buttons
	private String [] BUTTONS= {"RESET","THROW","REMOVE","FASTER", "SLOWER"};
	//Instance of the collection class
	private Collection collect = new Collection();
	//Instance of the alarm class;
	private Alarm alarm;
	//This boolean is use to stop and play the animation
	private boolean running = false;
	
	/**
	 * calls the constructor
	 */
	public static void main(String[] args){

		MainClass main = new MainClass (900,800,"Bouncing Ball");
	}

	/**
	 * Constructor
	 * @param w--> the width 
	 * @param h--> the height
	 * @param t--> the title
	 */
	public MainClass(int w, int h, String t){
		
		//we are creating the alarm and passing it this class
		alarm = new Alarm(this);
		alarm.setPeriod(50);
		//Here I start the alarm
		alarm.start();
		running = true;
		
		//storing the parameters
		width = w;
		height = h;
		title = t;

		//creating the frame
		frame = new JFrame(title);
		//setting its dimensions
		frame.setSize(width, height);	
		//it cannot be re-sized
		frame.setResizable(false);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.setBackground(Color.pink);
		frame.add(this,BorderLayout.CENTER);

		// In this panel i will place all the buttons
		JPanel controlPanel = new JPanel();
		//setting its ground color to pink
		controlPanel.setBackground(Color.PINK);

		toggle = new JToggleButton(TOGGLE_STR[0]);
		toggleMode = 0;
		toggle.setSelected(true);
		//we allowed action listener to work on the button
		toggle.addActionListener(this);
		//we added the button to the control panel
		controlPanel.add(toggle);

		//sets all the buttons 
		button = new JButton[BUTTONS.length];
		for (int i=0; i<BUTTONS.length; i++) 
		{
			button[i] = new JButton(BUTTONS[i]);
			button[i].addActionListener(this);
			controlPanel.add(button[i]);

		}
		//sets them on the east side of the frame
		frame.add(controlPanel, BorderLayout.NORTH);
		frame.setVisible(true);

	}
	/**
	 * This method is in charge of painting out layout
	 */
	public void paint(Graphics g){
		
		g.setColor(Color.pink);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.black);
		g.drawLine(25, 0, 25,height-100 );
		g.drawLine(25, height-100, width-25,height-100 );
		g.drawLine(width-25,height-100, width-25,0 );
		
		if(collect!= null){
			collect.paint(g);
		}
		
	}

	/**
	 * This method takes care of the actions being done
	 * with the buttons
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Object obj = e.getSource();
		
		//this toggle button is use to stop and play the animations
		//hopefully i can get some extra credit for adding it to the 
		//program
		if( obj == toggle){
			
			if(obj == toggle)
			{
				//updates togglemode every time the button is hit
				toggleMode = 1 - toggleMode;
				toggle.setText(TOGGLE_STR[toggleMode]);
				
				//this if and else statement is what switches the toggle button
				if(toggleMode == 1){
					
					running = false;
					
				}
				else{
					
					running = true;

				}		
			}
		}
		
		//we reset
		if(obj==button[0]){
			
			collect = new Collection();
			period = 50;
			alarm.setPeriod(period);
			this.repaint();
		}
		//we add
		if(obj==button[1]){
			
			period = 50;
			alarm.setPeriod(period);
			collect.add();
			
		}
		//we remove
		if(obj==button[2]){
			
			collect.remove();
		}
		//we speed up
		if(obj==button[3]){
			
			//collect.speedChange(true);
			
			if(period!=0)
			period=period-2;
			alarm.setPeriod(period);
		}
		//we slow down
		if(obj==button[4]){
			
			//collect.speedChange(false);
			if(period!=100)
			period = period+2;
			alarm.setPeriod(period);
			
		}
		
	}

	/**
	 * this method makes the objects in the collection move
	 * when running is true
	 */
	public void takeNotice() {
		if(running){
			collect.move();
			repaint();
		}
		
	}
}
