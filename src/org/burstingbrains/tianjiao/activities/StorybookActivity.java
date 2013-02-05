package org.burstingbrains.tianjiao.activities;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.andengine.entity.scene.IOnSceneTouchListener;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.util.FPSLogger;
import org.andengine.input.touch.TouchEvent;
import org.burstingbrains.sharedlibs.andengineext.BBSGameActivity;
import org.burstingbrains.sharedlibs.universe.Universe;
import org.burstingbrains.tianjiao.assets.StorybookAssets;
import org.burstingbrains.tianjiao.constants.GameConstants;
import org.burstingbrains.tianjiao.storybook.StorybookWorld;

import android.util.Log;



public class StorybookActivity extends BBSGameActivity implements IOnSceneTouchListener, GameConstants{
	private StorybookAssets assets = StorybookAssets.getSingleton();
	
	private StorybookWorld world;
	
	@Override
	public EngineOptions onCreateEngineOptions() {
		Camera camera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);

		final EngineOptions engineOptions = new EngineOptions(true, ScreenOrientation.LANDSCAPE_FIXED, new FillResolutionPolicy(), camera);
		
		engineOptions.getTouchOptions().setNeedsMultiTouch(true);
		engineOptions.getAudioOptions().setNeedsSound(true);
		engineOptions.getAudioOptions().setNeedsMusic(true);
		
		return engineOptions;
	}

	@Override
	protected void onCreateResources() {
		assets.init(this);
		assets.load();
		
	}

	@Override
	protected Scene onCreateScene() {
		mEngine.registerUpdateHandler(new FPSLogger());
		
		Scene mainScene = new Scene();
		Universe universe = new Universe(this, mainScene);
		
		world = new StorybookWorld(universe);
		
//		gameScene.setOnAreaTouchTraversalFrontToBack();
//		gameScene.setTouchAreaBindingOnActionDownEnabled(true);
		mainScene.setOnSceneTouchListener(this);
		
		
		return mainScene;
	}

	@Override
	public boolean onSceneTouchEvent(Scene pScene, TouchEvent pSceneTouchEvent) {
		if(pSceneTouchEvent.isActionDown())
			world.doNext();
		
		return false;
	}

}