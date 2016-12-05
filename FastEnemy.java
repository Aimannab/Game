package com.tutorial.main;

	import java.awt.Color;
	import java.awt.Graphics;
	import java.awt.Rectangle;

public class FastEnemy extends GameObject{
		
		private Handler handler;

		FastEnemy(int x, int y, ID id, Handler handler) {
			super(x, y, id);
			
			this.handler = handler;
			
			velx = 2;
			vely = 5;
		}

		public Rectangle getBounds() {
			return new Rectangle(x, y, 16, 16);
		}

		
		@Override
		public void tick() {
			x +=velx;
			y +=vely;
			
			if(y <=0 || y>= Game.HEIGHT -32) vely*= -1;
			if(x <=0 || x>= Game.WIDTH -16) velx*= -1;
			
			handler.addObject(new Trail(x, y, ID.Trail, Color.cyan, 16, 16, 0.021f, handler));
		
		}

		@Override
		public void render(Graphics g) {
			g.setColor(Color.cyan);
			g.fillRect(x, y, 16, 16);
			
		}

		
	}


