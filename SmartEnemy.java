package com.tutorial.main;

	
	import java.awt.Color;
	import java.awt.Graphics;
	import java.awt.Rectangle;

public class SmartEnemy extends GameObject{
		
		private Handler handler;
		private GameObject player;

		SmartEnemy(int x, int y, ID id, Handler handler) {
			super(x, y, id);
			
			this.handler = handler;
			
			for(int i=0; i< handler.object.size(); i++) {
				if(handler.object.get(i).getid() == ID.Player) {
					player = handler.object.get(i);
				}
			}
			
		}

		public Rectangle getBounds() {
			return new Rectangle((int)x, (int)y, 16, 16);
		}

		
		@Override
		public void tick() {
			x +=velx;
			y +=vely;
			
			float diffX = x - player.getx() -8;
			float diffY = y - player.gety() -8;
			float distance = (float) Math.sqrt((x-player.getx())*(x-player.getx())+ (y-player.gety())*(y-player.gety()));
			
			velx = (int) ((-1.0/distance) *diffX); 
			vely = (int) ((-1.0/distance) *diffY); 
			
			if(y <=0 || y>= Game.HEIGHT -32) vely*= -1;
			if(x <=0 || x>= Game.WIDTH -16) velx*= -1;
			
			handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.green, 16, 16, 0.02f, handler));
		
		}

		@Override
		public void render(Graphics g) {
			g.setColor(Color.green);
			g.fillRect((int)x, (int)y, 16, 16);
			
		}

		
	}

