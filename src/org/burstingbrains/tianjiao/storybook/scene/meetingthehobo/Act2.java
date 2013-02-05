package org.burstingbrains.tianjiao.storybook.scene.meetingthehobo;

import org.burstingbrains.tianjiao.storybook.TianJiao;
import org.burstingbrains.tianjiao.storybook.scene.IAct;

public class Act2 implements IAct{
	private final static float WALK_SPEED = 200;
	
	private TianJiao tj;
	
	private boolean isComplete;
	
	public Act2(TianJiao tj){
		this.tj = tj;
		
		reset();	
	}
	
	@Override
	public void update(float pSecondsElapsed){
		if(!isCompleted()){
		
			float moveDistance = pSecondsElapsed * WALK_SPEED;
		
			tj.setPosition(
					tj.getX(), 
					tj.getY() - moveDistance);
			
			if(tj.getY() < 300){
				doQuickComplete();
			}
			
		}
	}
	
	@Override
	public void doQuickComplete() {
		tj.setPosition(tj.getX(), 300);
		isComplete = true;
	}

	@Override
	public boolean isCompleted() {
		return isComplete;
	}

	@Override
	public void reset() {
		isComplete = false;
		tj.setPosition(400, 600);
	}
}