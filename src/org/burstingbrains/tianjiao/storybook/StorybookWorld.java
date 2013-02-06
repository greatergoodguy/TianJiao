package org.burstingbrains.tianjiao.storybook;

import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.sprite.Sprite;
import org.burstingbrains.sharedlibs.universe.Universe;
import org.burstingbrains.tianjiao.assets.StorybookAssets;
import org.burstingbrains.tianjiao.constants.GameConstants;
import org.burstingbrains.tianjiao.storybook.scene.IScene;
import org.burstingbrains.tianjiao.storybook.scene.MeetingTheHoboScene;

public class StorybookWorld implements IUpdateHandler, GameConstants{
	private StorybookAssets assets = StorybookAssets.getSingleton();
	
	private TextBoxManagerSingleton textBoxManager = TextBoxManagerSingleton.getSingleton();
	
	private StorybookBackground background;
	
	private TianJiao tianJiao;
	private SelectionMenu selectionMenu;
	
	private IScene activeScene;

	public StorybookWorld(Universe universe){
		
		textBoxManager.init(universe);
		
		background = new StorybookBackground(universe);
		tianJiao = new TianJiao(universe);
		selectionMenu = new SelectionMenu();
		
		Sprite rewind = new Sprite(0, 0, assets.uiRewindTR, universe.getVertexBufferObjectManager());
		Sprite fastforward = new Sprite(0, 0, assets.uiFastforwardTR, universe.getVertexBufferObjectManager());
		rewind.setPosition(1130, 210);
		fastforward.setPosition(1130, 650);
		
		
		
		
		universe.attachChild(background.getEntity());
		universe.attachChild(textBoxManager.getEntity());
		universe.attachChild(tianJiao.getEntity());
		
		universe.attachChild(rewind);
		universe.attachChild(fastforward);
		
		universe.registerUpdateHandler(this);
		
		activeScene = new MeetingTheHoboScene(background, tianJiao);
		
		assert background != null;
		assert tianJiao != null;
		assert selectionMenu != null;
		
		assert activeScene != null;
	}

	@Override
	public void onUpdate(float pSecondsElapsed) {
		activeScene.update(pSecondsElapsed);
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	public void doNext() {
		activeScene.doNext();
	}
	
}
