/*
 *Cameron Bourque
 *Period 2
 *1/11/17
 */

import java.applet.Applet;
import java.awt.*;
import java.util.Random;

public class Fractals extends Applet
{
	public static final int PAUSE = 1;
	private long seed;
	private boolean done;
	private Color color;
	/**
	 * draw the original rectangle in the middle of the graphics window
	 */
	public void paint(Graphics g)
	{
		// if you cannot see the entire applet window on your monitor, you can change the
		// size of it in Fractals.html
		drawRectangle(g,getWidth(),getHeight());
//		seed = (long)(Math.random() * 54439);
//		Random randy = new Random(seed);
	}
	
	/**
	 * draws the original rectangle, then calls the method/s that draw the
	 * four rectangles at the corners.
	 * NOT RECURSIVE
	 */
	public void drawRectangle(Graphics g, int x, int y)
	{
		seed = (long)(Math.random() * 24534536);
		Random rand = new Random(seed);
		if(!done)
		{
				bonus(g,rand,x);
			color = g.getColor();
			done = true;
		}
		else
		{
			g.setColor(color);
		}
		try
		{
			Thread.sleep(PAUSE);
			g.fillRect(x/3,y/3,x/3,y/3);
		}
		catch(InterruptedException e)
		{
		}
		drawRect1(g,x/3,y/3,x/3,y/3,rand);
		drawRect3(g,x/3,y/3,x/3,y/3,rand);
		drawRect4(g,x/3,y/3,x/3,y/3,rand);
		drawRect2(g,x/3,y/3,x/3,y/3,rand);
			drawRectangle(g,x,y);
	}
	public void drawRect1(Graphics g, int x, int y, int xSize, int ySize, Random rand) //topleft
	{
		if(xSize>=2 && ySize>=2)
		{
				bonus(g,rand,xSize);
			
			try
			{
				Thread.sleep(PAUSE);
				g.fillRect(x-xSize/2,y-ySize/2,xSize/2,ySize/2);
			}
			catch(InterruptedException e)
			{
			}
			drawRect2(g,x-xSize/2,y-ySize/2,xSize/2,ySize/2,rand);
			drawRect1(g,x-xSize/2,y-ySize/2,xSize/2,ySize/2,rand);
			drawRect3(g,x-xSize/2,y-ySize/2,xSize/2,ySize/2,rand);
		}
	}
	public void drawRect2(Graphics g, int x, int y, int xSize, int ySize, Random rand)//topright
	{
		if(xSize>=2 && ySize>=2)
		{
				bonus(g,rand,xSize);
			try
			{
				Thread.sleep(PAUSE);
				g.fillRect(x+xSize,y-ySize/2,xSize/2,ySize/2);
				
			}
			catch(InterruptedException e)
			{
			}

			drawRect4(g,x+xSize,y-ySize/2,xSize/2,ySize/2,rand);
			drawRect2(g,x+xSize,y-ySize/2,xSize/2,ySize/2,rand);
			drawRect1(g,x+xSize,y-ySize/2,xSize/2,ySize/2,rand);
		}
	}
	public void drawRect3(Graphics g, int x, int y, int xSize, int ySize, Random rand)//bottomleft
	{
		if(xSize>=2 && ySize>=2)
		{
				bonus(g,rand,xSize);
			try
			{
				Thread.sleep(PAUSE);
				g.fillRect(x-xSize/2,y+ySize,xSize/2,ySize/2);	
			}
			catch(InterruptedException e)
			{
			}
			drawRect1(g,x-xSize/2,y+ySize,xSize/2,ySize/2,rand);
			drawRect3(g,x-xSize/2,y+ySize,xSize/2,ySize/2,rand);
			drawRect4(g,x-xSize/2,y+ySize,xSize/2,ySize/2,rand);
		}
	}
	public void drawRect4(Graphics g, int x, int y, int xSize, int ySize, Random rand)//bottomright
	{
		if(xSize>=2 && ySize>=2)
		{
				bonus(g,rand,xSize);
			try
			{
				Thread.sleep(PAUSE);
				g.fillRect(x+xSize,y+ySize,xSize/2,ySize/2);
				
			}
			catch(InterruptedException e)
			{
			}
			drawRect3(g,x+xSize,y+ySize,xSize/2,ySize/2,rand);
			drawRect4(g,x+xSize,y+ySize,xSize/2,ySize/2,rand);
			drawRect2(g,x+xSize,y+ySize,xSize/2,ySize/2,rand);
		}
	}
	
	public void bonus(Graphics g, Random rand, int value)
	{
		rand.setSeed(value*seed);
		int r = (int)(rand.nextDouble()*255);
		int gr =(int)(rand.nextDouble()*255);
		int b = (int)(rand.nextDouble()*255);
		
		g.setColor(new Color(r,gr,b));
	}
	public Color randColor(Graphics g, Random rand, int value)
	{
		rand.setSeed(value*seed);
		int r = (int)(rand.nextDouble()*255);
		int gr =(int)(rand.nextDouble()*255);
		int b = (int)(rand.nextDouble()*255);
		
		return new Color(r,gr,b);
	}
}