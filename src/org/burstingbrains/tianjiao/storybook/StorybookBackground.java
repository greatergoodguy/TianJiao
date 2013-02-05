package org.burstingbrains.tianjiao.storybook;

import org.andengine.entity.IEntity;
import org.andengine.entity.sprite.Sprite;
import org.burstingbrains.sharedlibs.universe.Universe;
import org.burstingbrains.tianjiao.assets.StorybookAssets;
import org.burstingbrains.tianjiao.constants.GameConstants;

public class StorybookBackground implements GameConstants{
	private StorybookAssets assets = StorybookAssets.getSingleton();
	
	private final Sprite background;
	
	public StorybookBackground(Universe universe){
	
		background = new Sprite(0, 0, assets.housesBG, universe.getVertexBufferObjectManager());
		background.setPosition(CAMERA_WIDTH_OVER_TWO - background.getWidth()/2, CAMERA_HEIGHT_OVER_TWO - background.getHeight()/2);
		float scaleX = CAMERA_WIDTH / background.getWidth();
		float scaleY = CAMERA_HEIGHT / background.getHeight();
		background.setScale(scaleX, scaleY);
	}
	
	
	public IEntity getEntity(){
		return background;
	}

	
}
