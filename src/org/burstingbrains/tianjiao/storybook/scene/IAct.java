package org.burstingbrains.tianjiao.storybook.scene;

public interface IAct {

	void update(float pSecondsElapsed);
	void doQuickComplete();
	boolean isCompleted();
	void reset();
	

	
}
