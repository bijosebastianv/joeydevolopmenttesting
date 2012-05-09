package com.joey.aitesting.game.steering.behaviors;

import com.joey.aitesting.game.Deceleration;
import com.joey.aitesting.game.entities.Vehicle;
import com.joey.aitesting.game.maths.Transformations;
import com.joey.aitesting.game.shapes.Vector2D;

public class OffsetPursuit {

	public static void OffsetPursuit(Vehicle vehicle, Vehicle leader,
			Vector2D offset, Vector2D rst) {
		// calculate the offset�s position in world space
		Vector2D WorldOffsetPos = new Vector2D();
		Transformations.PointToWorldSpace(offset, leader.velHead,
				leader.velSide, leader.pos, WorldOffsetPos);

		Vector2D temp = new Vector2D(WorldOffsetPos);
		temp.subtract(vehicle.pos);
		// the look-ahead time is proportional to the distance between the
		// leader
		// and the pursuer; and is inversely proportional to the sum of both
		// agents� velocities
		float LookAheadTime = temp.length()
				/ (vehicle.maxSpeed + leader.vel.length());
		// now arrive at the predicted future position of the offset

		temp.x = WorldOffsetPos.x + leader.vel.x * LookAheadTime;
		temp.y = WorldOffsetPos.y + leader.vel.y * LookAheadTime;
		Arrive.arrive(vehicle, temp, Deceleration.FAST, rst);
	}
}
