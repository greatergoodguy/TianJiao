package org.burstingbrains.tianjiao.storybook.scene.meetingthehobo;

import org.burstingbrains.tianjiao.storybook.TianJiao;
import org.burstingbrains.tianjiao.storybook.scene.IAct;

public class Act1 implements IAct{
	private final static float WALK_SPEED = 200;
	
	private TianJiao tj;
	
	private boolean isComplete;
	
	public Act1(TianJiao tj){
		this.tj = tj;
		
		reset();	
	}
	
	@Override
	public void update(float pSecondsElapsed){
		if(!isCompleted()){
		
			float moveDistance = pSecondsElapsed * WALK_SPEED;
		
			tj.setPosition(
					tj.getX() + moveDistance, 
					tj.getY());
			
			if(tj.getX() > 400){
				doQuickComplete();
			}
			
		}
	}
	
	@Override
	public void doQuickComplete() {
		tj.setPosition(400, tj.getY());
		isComplete = true;
	}

	@Override
	public boolean isCompleted() {
		return isComplete;
	}

	@Override
	public void reset() {
		isComplete = false;
		tj.setPosition(-200, 600);
	}
}
