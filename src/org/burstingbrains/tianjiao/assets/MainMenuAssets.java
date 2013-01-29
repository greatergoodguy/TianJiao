package org.burstingbrains.tianjiao.assets;

import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder.TextureAtlasBuilderException;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.util.debug.Debug;
import org.burstingbrains.sharedlibs.andengineext.BBSGameActivity;
import org.burstingbrains.sharedlibs.universe.IAssets;

public class MainMenuAssets implements IAssets{

	private static final MainMenuAssets assetsMainMenuSingleton = new MainMenuAssets();
	

	private BuildableBitmapTextureAtlas tianJiaoTexture;
	public ITextureRegion tjRun1TR;
	public ITextureRegion tjRun2TR;
	public ITextureRegion tjStandingTR;
	
	public boolean isInitialized;
	
	private MainMenuAssets(){
		isInitialized = false;
	}
	

	public static MainMenuAssets getSingleton(){
		return assetsMainMenuSingleton;
	}
	
	
	@Override
	public void init(BBSGameActivity bbsGameActivity) {
		
		
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("art/TianJiao/");
		tianJiaoTexture = new BuildableBitmapTextureAtlas(bbsGameActivity.getTextureManager(), 2048, 1024, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		tjRun1TR = BitmapTextureAtlasTextureRegionFactory.createFromAsset(tianJiaoTexture, bbsGameActivity, "tj_run1.png");
		tjRun2TR = BitmapTextureAtlasTextureRegionFactory.createFromAsset(tianJiaoTexture, bbsGameActivity, "tj_run2.png");
		tjStandingTR = BitmapTextureAtlasTextureRegionFactory.createFromAsset(tianJiaoTexture, bbsGameActivity, "tj_standing.png");
		try{
			tianJiaoTexture.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(1, 1, 1));
		} catch (final TextureAtlasBuilderException e) {
			Debug.e(e);
		}
		
		
		isInitialized = true;
	}

	@Override
	public void load() {
		if(isInitialized){
			tianJiaoTexture.load();
		}
	}

	@Override
	public void unload() {
		if(isInitialized){
			tianJiaoTexture.unload();
		}
	}

}
