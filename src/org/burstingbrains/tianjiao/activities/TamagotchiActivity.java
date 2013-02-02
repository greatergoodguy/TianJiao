package org.burstingbrains.tianjiao.activities;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.util.FPSLogger;
import org.burstingbrains.sharedlibs.andengineext.BBSGameActivity;
import org.burstingbrains.sharedlibs.universe.Universe;
import org.burstingbrains.tianjiao.assets.TamagotchiAssets;
import org.burstingbrains.tianjiao.constants.GameConstants;
import org.burstingbrains.tianjiao.tamagotchi.TJWalkScript;



public class TamagotchiActivity extends BBSGameActivity implements GameConstants{
	private TamagotchiAssets assets = TamagotchiAssets.getSingleton();
	
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
		
		mainScene.setBackground(new Background(0.09804f, 0.6274f, 0.8784f));
		
		final Sprite background = new Sprite(0, 0, assets.backgroundTR, this.getVertexBufferObjectManager());
		background.setPosition(CAMERA_WIDTH_OVER_TWO - background.getWidth()/2, CAMERA_HEIGHT_OVER_TWO - background.getHeight()/2);
		background.setScale(1.6f, 1.34f);
		mainScene.attachChild(background);
		
		
		AnimatedSprite tjRunning = new AnimatedSprite(0, 0, assets.tjRunningTTR, this.getVertexBufferObjectManager());
		tjRunning.animate(400);
		
		universe.attachChild(tjRunning);
		
		universe.registerUpdateHandler(new TJWalkScript(tjRunning));
		
		return mainScene;
	}

}