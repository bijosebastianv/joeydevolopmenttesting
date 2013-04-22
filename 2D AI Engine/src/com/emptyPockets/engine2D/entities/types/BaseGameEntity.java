package com.emptyPockets.engine2D.entities.types;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.emptyPockets.engine2D.shapes.Rectangle2D;
import com.emptyPockets.engine2D.shapes.Vector2D;

import java.awt.geom.Point2D;

public abstract class BaseGameEntity {
	static int ENTITY_COUNT = 0;

	public int id;
	public int entityType;

	public Vector2D pos;
	public Vector2D scale;
	public boolean tagged;
	public float radius =1;
	
	public BaseGameEntity(){
	    id = getNextValidId();
	    pos = new Vector2D();
	    scale = new Vector2D(1,1);
	    entityType = EntityTypes.DEFAULT_TYPE;
	    tagged = false;
	}
	
	public BaseGameEntity(int entityType){
	    this();
	    this.entityType = entityType;
	}
	public BaseGameEntity(int entityType, Vector2D pos){
	    this();
	    this.pos = pos;
	    this.entityType = entityType;
	}
	public BaseGameEntity(int entityType, Vector2D pos, float radius){
	    this();
	    this.pos = pos;
	    this.entityType = entityType;
	    this.radius = radius;
	}

	public BaseGameEntity(int entityType, int forcedId){
	    this();
	    this.id = forcedId;
	    this.entityType = entityType;
	}
	
	public abstract void update(float time);

	public static int getNextValidId(){
	    return ENTITY_COUNT++;
	}
	public int getId() {
	    return id;
	}

	public void setId(int id) {
	    this.id = id;
	}

	public int getEntityType() {
	    return entityType;
	}

	public void setEntityType(int entityType) {
	    this.entityType = entityType;
	}

	public Vector2D getPos() {
	    return pos;
	}

	public void setPos(Vector2D pos) {
	    this.pos = pos;
	}

	public boolean isTagged() {
	    return tagged;
	}

	public void setTagged(boolean tagged) {
	    this.tagged = tagged;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof BaseGameEntity)){
			return false;
		}
		return this.id == ((BaseGameEntity)obj).id;
	}

}
