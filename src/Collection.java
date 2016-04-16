import java.awt.Graphics;


public class Collection implements CollectionInterface{

	//my collection of balls
	private Ball [] ball = new Ball [50];
	//this is the counter that allows us to place the balls
	//in different indexes
	private int count = 0;
	//features of the ball
	private double ballX, ballY;
	private double colorIndex, ballSize = 30;
		
	@Override
	public void add() {
		//we randomize the balls x,y, and color
		// and the we pass it to its constructor
		colorIndex = (int)(10 * Math.random());
		ballX=(int) (600 * Math.random());
		ballY=(int) (600 * Math.random());

		ball[count] = new Ball(ballX, ballY, ballSize, colorIndex);
		count++;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		//if the collection is not empty we remove
		if(!isEmpty()){
			ball[count] = null;
			count--;
		}
		
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		//checks if the array is empty
		return (ball[0]==null);
		
		
	}
	/**
	 * this method paints all the balls
	 * @param g
	 */
	public void paint(Graphics g){
		
		for(int i = 0; i < ball.length; i++){
			if(ball[i] != null){
				ball[i].paint(g);
			}
		}
	}

	public void move() {
		//for every ball in my collection, call ball.move();
		for(int i=0; i<ball.length; i++){
			
			if(ball[i]!=null)
			ball[i].move();
		}
		
	}
}
