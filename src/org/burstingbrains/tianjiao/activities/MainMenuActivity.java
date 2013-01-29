package org.burstingbrains.tianjiao.activities;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.util.FPSLogger;
import org.burstingbrains.sharedlibs.andengineext.BBSGameActivity;
import org.burstingbrains.sharedlibs.andengineext.buttons.OneStateButton;
import org.burstingbrains.sharedlibs.universe.Universe;
import org.burstingbrains.tianjiao.assets.MainMenuAssets;
import org.burstingbrains.tianjiao.constants.GameConstants;

public class MainMenuActivity extends BBSGameActivity implements GameConstants{
	private MainMenuAssets assets = MainMenuAssets.getSingleton();
	
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
		mainScene.setBackground(new Background(0.09804f, 0.6274f, 0.8784f));
		
		Universe universe = new Universe(this, mainScene);
		
		Sprite tjRun1Sprite = new Sprite(0, 0, assets.tjRun1TR, this.getVertexBufferObjectManager());		
		Sprite tjRun2Sprite = new Sprite(200, 200, assets.tjRun2TR, this.getVertexBufferObjectManager());
		Sprite tjStandingSprite = new Sprite(400, 400, assets.tjStandingTR, this.getVertexBufferObjectManager());
		OneStateButton tjRun1Button = new OneStateButton(universe, assets.tjRun1TR);
		tjRun1Button.setPosition(800, 200);
		
		
		universe.attachChild(tjRun1Sprite);
		universe.attachChild(tjRun2Sprite);
		universe.attachChild(tjStandingSprite);
		universe.attachChild(tjRun1Button);
		universe.registerTouchArea(tjRun1Button.getTouchArea());
		
		
		
		return mainScene;
	}

}
