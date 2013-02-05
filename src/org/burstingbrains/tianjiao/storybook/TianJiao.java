package org.burstingbrains.tianjiao.storybook;

import org.andengine.entity.IEntity;
import org.andengine.entity.sprite.AnimatedSprite;
import org.burstingbrains.sharedlibs.universe.Universe;
import org.burstingbrains.tianjiao.assets.StorybookAssets;

public class TianJiao {
	private StorybookAssets assets = StorybookAssets.getSingleton();
	
	private AnimatedSprite tjRunning;
	
	public TianJiao(Universe universe){
		tjRunning = new AnimatedSprite(0, 0, assets.tjRunningTTR, universe.getVertexBufferObjectManager());
		tjRunning.animate(400);
	}

	public void setPosition(float pX, float pY) {
		tjRunning.setPosition(pX, pY);
	}

	public float getX() {
		return tjRunning.getX();
	}
	
	public float getY() {
		return tjRunning.getY();
	}
	
	public IEntity getEntity(){
		return tjRunning;
	}


}
