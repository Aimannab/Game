package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject{

	Random r = new Random();
	Handler handler;
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32, 32);
	}

	@Override
	public void tick() {
		
		x+= velx;
		y+= vely;
		
		x = Game.clamp(x, 0, Game.WIDTH -35);
		y = Game.clamp(y, 0, Game.HEIGHT -61);
		
		handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.white, 32, 32, 0.1f, handler));
		
		collision();
	}
	
	private void collision() {
		for(int i = 0; i < handler.object.size(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getid() == ID.BasicEnemy || tempObject.getid() == ID.FastEnemy || tempObject.getid() == ID.SmartEnemy) {					//temp object is now basic enemy
				if(getBounds().intersects(tempObject.getBounds())) {	//if player bounds intersect basic enemy bounds
					//collision code
					
					HUD.HEALTH -=2;
				}
			}
		}
	}

	@Override
	public void render(Graphics g) {
		
		g.setColor(Color.white);
		g.fillRect((int)x, (int)y, 32, 32);
		
	}

}
