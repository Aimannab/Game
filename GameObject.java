package com.tutorial.main;

import java.awt.Graphics;
import java.awt.Rectangle;

//All our players from the game
public abstract class GameObject {

	protected float x, y;
	protected ID id;
	protected float velx, vely;
	
	GameObject(float x, float y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id; 
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();		//For our colliding method. Intersects method-> returns true when 2 rect intersect each other
	
	public void setx(int x) {
		this.x = x;
	}
	
	public void sety(int y) {
		this.y = y;
	}
	
	public float getx() {
		return x;
	}
	
	public float gety() {
		return y;
	}
	
	public void setid(ID id) {
		this.id = id;
	}
	
	public ID getid() {
		return id;
	}
	
	public void setVelX(int velx) {
		this.velx = velx;
	}
	
	public void setVelY(int vely) {
		this.vely = vely;
	}
	public float getVelX() {
		return velx;
	}
	
	public float getVelY() {
		return vely;
	}
}
