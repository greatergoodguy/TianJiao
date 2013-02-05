package org.burstingbrains.tianjiao.storybook.scene;

public interface IScene {

	void update(float pSecondsElapsed);
	void reset();
	void doNext();
	
}
