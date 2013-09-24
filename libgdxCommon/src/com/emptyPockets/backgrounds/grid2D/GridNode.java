package com.emptyPockets.backgrounds.grid2D;

import com.badlogic.gdx.math.Vector2;

public class GridNode {
	public float inverseMass;
	public Vector2 restPos;
	public Vector2 pos;
	public Vector2 vel;
	Vector2 acl;

	public GridNode() {
		pos = new Vector2();
		restPos = new Vector2();
		vel = new Vector2();
		acl = new Vector2();
		inverseMass = 0;
	}

	public void applyImpulse(Vector2 impulse) {
		vel.x+=impulse.x*inverseMass;
		vel.y+=impulse.y*inverseMass;
	}

	public void applyForce(Vector2 force) {
		acl.x+=force.x*inverseMass;
		acl.y+=force.y*inverseMass;
	}

	public void update(float delta) {
		vel.x += acl.x * delta;
		vel.y += acl.y * delta;

		if (vel.len2() < 1e-9f) {
			vel.x = 0;
			vel.y = 0;
		} else {
			pos.x += vel.x * delta;
			pos.y += vel.y * delta;
		}
		acl.x = 0;
		acl.y = 0;
	}

}