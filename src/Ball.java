import java.awt.Color;
import java.awt.Graphics;


public class Ball {
	// these integers take care of the coordinates of the ball
		//its color and its speed
		private double x, y, size,colorI,
						speedX = 10, speedY = 15, 
						gravity = 5, bouncingFactor = .9;


		
		/**
		 * @param ballX--> x coordinate of the ball
		 * @param ballY--> y coordinate of the ball
		 * @param ballSize--> width and height of the ball
		 * @param i--> Random color for i
		 */
		public Ball(double ballX, double ballY, double ballSize, double colorIndex){
			//storing the variables
			x = ballX;
			y = ballY;
			size = ballSize;
			colorI = colorIndex;
		}
		
		public void paint(Graphics g){
			//an array with all the colors
			Color[] colors = {Color.black,Color.blue,Color.cyan,
								Color.gray, Color.green,Color.magenta,
								Color.orange,Color.red,Color.white,
								Color.yellow};
					
			//I use the random number to choose one of the color 
			// for the ball
			g.setColor(colors[(int)colorI]);
			// than i use the coordiates to set the ball
			g.fillOval((int)x, (int)y,(int)size, (int)size);
		}
		
		/**
		 * moves the ball and keeps it in its boundaries 
		 */
		public void move(){
			
			x = x+speedX;
			if(x<25){
				//this does not allow x to get smaller than 25
				x = 25;
				//we change the direction because it hit a boundary
				speedX  = -speedX;
			}
			if(x>=850){
				//x cant get bigger than 850
				x = 850-size;
				//then we change direction
				speedX = -speedX;
			}
			y = y+speedY;
			
			speedY = speedY + gravity;
			if(y>675){
				//y cant get bigger than 675
				y = 675;
				//than we change its direction
				speedY = -speedY*bouncingFactor;
				bouncingFactor = bouncingFactor - .05;
				
			}
			if(y<0){
				//when y is less than 0 we change the direction of the ball
				speedY = -speedY*bouncingFactor;
				bouncingFactor = bouncingFactor - .05;

				
			}

		}

}
