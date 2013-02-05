package org.burstingbrains.tianjiao.tamagotchi;

import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.sprite.AnimatedSprite;

public class TJWalkScript implements IUpdateHandler{
	private final static float WALK_SPEED = 40;
	
	private final static float START_POS_X = 800;
	private final static float START_POS_Y = 530;
	
	private final static float LEFT_BOUND = 650;
	private final static float RIGHT_BOUND = 950;
	
	AnimatedSprite tjRunning;
	
	boolean isRunningRight;
	
	
	public TJWalkScript(AnimatedSprite tjRunning){
		this.tjRunning = tjRunning;
		
		reset();
		
		assert tjRunning != null;
	}
	
	@Override
	public void onUpdate(float pSecondsElapsed) {
		float moveDistance = pSecondsElapsed * WALK_SPEED;
		
		if(isRunningRight){
			tjRunning.setPosition(
					tjRunning.getX() + moveDistance, 
					tjRunning.getY());
			
			if(tjRunning.getX() > RIGHT_BOUND){
				isRunningRight = !isRunningRight;
			}
		}
		else{
			tjRunning.setPosition(
					tjRunning.getX() - moveDistance, 
					tjRunning.getY());
			
			if(tjRunning.getX() < LEFT_BOUND)
				isRunningRight = !isRunningRight;
		}
		
	}

	@Override
	public void reset() {
		tjRunning.setPosition(START_POS_X, START_POS_Y);
		isRunningRight = true;
	}

}
