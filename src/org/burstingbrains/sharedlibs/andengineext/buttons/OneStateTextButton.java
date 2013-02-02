package org.burstingbrains.sharedlibs.andengineext.buttons;

import org.andengine.entity.Entity;
import org.andengine.entity.scene.ITouchArea;
import org.andengine.entity.text.Text;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.font.IFont;
import org.burstingbrains.sharedlibs.universe.Universe;

public class OneStateTextButton extends Entity{

	private IBBOnClickListener bbOnClickListener;
	
	private Text text;
	
	public OneStateTextButton(Universe universe, IFont font, String buttonText){
		super(0, 0);
		
		bbOnClickListener = ButtonUtil.dummyBBOnClickListener;
		
		text = new Text(0, 0, font, buttonText, universe.getVertexBufferObjectManager()){
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


		this.attachChild(text);
	}

	public float getWidth() {
		return text.getWidth();
	}

	public float getHeight() {
		return text.getHeight();
	}	
	
	public void registerOnClickListener(IBBOnClickListener bbOnClickListener) {
		this.bbOnClickListener = bbOnClickListener;
	}
	
	public ITouchArea getTouchArea() {
		return text;
	}
}
