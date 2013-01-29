package org.burstingbrains.sharedlibs.andengineext.buttons;

import org.andengine.entity.Entity;
import org.andengine.entity.scene.ITouchArea;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.burstingbrains.sharedlibs.universe.Universe;

public class OneStateButton extends Entity{

	private IBBOnClickListener bbOnClickListener;
	
	private Sprite sprite1;
	
	public OneStateButton(Universe universe, ITextureRegion textureRegion1){
		super(0, 0);
		
		bbOnClickListener = ButtonUtil.dummyBBOnClickListener;
		
		sprite1 = new Sprite(0, 0, textureRegion1, universe.getVertexBufferObjectManager()){
			boolean mGrabbed = false;
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				switch(pSceneTouchEvent.getAction()) {
					case TouchEvent.ACTION_DOWN:
						this.mGrabbed = true;
						this.setScale(1.25f);
						break;
					case TouchEvent.ACTION_MOVE:
						if(this.mGrabbed) {
						}
						break;
					case TouchEvent.ACTION_UP:
						if(this.mGrabbed) {
							this.mGrabbed = false;
							this.setScale(1.0f);
							bbOnClickListener.onClick();
						}
						break;
				}
				return true;
			}
		};

		this.attachChild(sprite1);
	}

	public float getWidth() {
		return sprite1.getWidth();
	}

	public float getHeight() {
		return sprite1.getHeight();
	}	
	
	public void registerOnClickListener(IBBOnClickListener bbOnClickListener) {
		this.bbOnClickListener = bbOnClickListener;
	}
	
	public ITouchArea getTouchArea() {
		return sprite1;
	}
}
