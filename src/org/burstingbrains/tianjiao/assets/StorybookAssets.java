package org.burstingbrains.tianjiao.assets;

import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder.TextureAtlasBuilderException;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.util.debug.Debug;
import org.burstingbrains.sharedlibs.andengineext.BBSGameActivity;
import org.burstingbrains.sharedlibs.universe.IAssets;

public class StorybookAssets implements IAssets{

	private static final StorybookAssets assetsStorybookSingleton = new StorybookAssets();
	
	public BitmapTextureAtlas housesBGTexture;
	public ITextureRegion housesBG;

	private BuildableBitmapTextureAtlas tianJiaoTexture;
	public ITextureRegion tjRun1TR;
	public ITextureRegion tjRun2TR;
	public ITextureRegion tjStandingTR;
	
	private BuildableBitmapTextureAtlas tjRunningTexture;
	public TiledTextureRegion tjRunningTTR;
	
	private BuildableBitmapTextureAtlas uiButtonsTexture;
	public ITextureRegion uiRewindTR;
	public ITextureRegion uiFastforwardTR;
	
	public boolean isInitialized;
	
	private StorybookAssets(){
		isInitialized = false;
	}
	

	public static StorybookAssets getSingleton(){
		return assetsStorybookSingleton;
	}
	
	
	@Override
	public void init(BBSGameActivity bbsGameActivity) {
		
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("art/bg/");
		housesBGTexture = new BitmapTextureAtlas(bbsGameActivity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		housesBG = BitmapTextureAtlasTextureRegionFactory.createFromAsset(housesBGTexture, bbsGameActivity, "houses_bg.jpg", 0, 0);

		
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
		
		
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("anim/TianJiao/");
		tjRunningTexture = new BuildableBitmapTextureAtlas(bbsGameActivity.getTextureManager(), 1024, 512, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		tjRunningTTR = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(tjRunningTexture, bbsGameActivity, "tj_run.png", 3, 1);
		try{
			tjRunningTexture.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(1, 1, 1));
		} catch (final TextureAtlasBuilderException e) {
			Debug.e(e);
		}
		
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("art/storybook/");
		uiButtonsTexture = new BuildableBitmapTextureAtlas(bbsGameActivity.getTextureManager(), 1024, 512, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		uiRewindTR = BitmapTextureAtlasTextureRegionFactory.createFromAsset(uiButtonsTexture, bbsGameActivity, "rewind.png");
		uiFastforwardTR = BitmapTextureAtlasTextureRegionFactory.createFromAsset(uiButtonsTexture, bbsGameActivity, "fastforward.png");
		try{
			uiButtonsTexture.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(1, 1, 1));
		} catch (final TextureAtlasBuilderException e) {
			Debug.e(e);
		}
		
		isInitialized = true;
	}

	@Override
	public void load() {
		if(isInitialized){
			housesBGTexture.load();
			tianJiaoTexture.load();
			tjRunningTexture.load();
			
			uiButtonsTexture.load();
		}
	}

	@Override
	public void unload() {
		if(isInitialized){
			housesBGTexture.unload();
			tianJiaoTexture.unload();
			tjRunningTexture.unload();
			
			uiButtonsTexture.unload();
		}
	}

}
