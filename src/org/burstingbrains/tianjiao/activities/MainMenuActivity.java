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
import org.burstingbrains.sharedlibs.andengineext.buttons.IBBOnClickListener;
import org.burstingbrains.sharedlibs.andengineext.buttons.OneStateSpriteButton;
import org.burstingbrains.sharedlibs.andengineext.buttons.OneStateTextButton;
import org.burstingbrains.sharedlibs.universe.Universe;
import org.burstingbrains.tianjiao.assets.MainMenuAssets;
import org.burstingbrains.tianjiao.constants.GameConstants;

import android.content.Intent;
import android.os.Handler;

public class MainMenuActivity extends BBSGameActivity implements GameConstants{
	private MainMenuAssets assets = MainMenuAssets.getSingleton();
	
	private Handler handler;
	
	@Override
	public EngineOptions onCreateEngineOptions() {
		handler = new Handler();
		
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
		OneStateTextButton animationViewerButton = new OneStateTextButton(universe, assets.addElectricCityFont, "Animation");
		animationViewerButton.registerOnClickListener(new IBBOnClickListener() {
			@Override
			public void onClick() {
				long delayMillis = 200;
				handler.postDelayed(launchAnimationViewerActivity, delayMillis);	
			}
		});
		animationViewerButton.setPosition(800, 100);
		
		OneStateTextButton storyBookButton = new OneStateTextButton(universe, assets.addElectricCityFont, "Story Book");
		storyBookButton.registerOnClickListener(new IBBOnClickListener() {
			@Override
			public void onClick() {
				long delayMillis = 200;
				handler.postDelayed(launchStorybookActivity, delayMillis);	
			}
		});
		storyBookButton.setPosition(800, 300);
		
		OneStateTextButton tamagotchiButton = new OneStateTextButton(universe, assets.addElectricCityFont, "Tamagotchi");
		tamagotchiButton.registerOnClickListener(new IBBOnClickListener() {
			@Override
			public void onClick() {
				long delayMillis = 200;
				handler.postDelayed(launchTamagotchiActivity, delayMillis);	
			}
		});
		tamagotchiButton.setPosition(800, 500);
		
		universe.attachChild(tjRun1Sprite);
		universe.attachChild(tjRun2Sprite);
		universe.attachChild(tjStandingSprite);
		universe.attachChild(animationViewerButton);
		universe.attachChild(storyBookButton);
		universe.attachChild(tamagotchiButton);
		universe.registerTouchArea(animationViewerButton.getTouchArea());
		universe.registerTouchArea(storyBookButton.getTouchArea());
		universe.registerTouchArea(tamagotchiButton.getTouchArea());
		
		
		return mainScene;
	}
	
	private Runnable launchAnimationViewerActivity = new Runnable(){
		public void run(){
			Intent myIntent = new Intent(MainMenuActivity.this, AnimationViewerActivity.class);
			startActivity(myIntent);
		}
	};

	private Runnable launchTamagotchiActivity = new Runnable(){
		public void run(){
			Intent myIntent = new Intent(MainMenuActivity.this, TamagotchiActivity.class);
			startActivity(myIntent);
		}
	};

	private Runnable launchStorybookActivity = new Runnable(){
		public void run(){
			Intent myIntent = new Intent(MainMenuActivity.this, StorybookActivity.class);
			startActivity(myIntent);
		}
	};

}
