package org.burstingbrains.sharedlibs.andengineext;

import org.andengine.opengl.font.IFont;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import android.util.Log;

public class BBSTickerText extends TickerText{

	public BBSTickerText(int pX, int pY, IFont pFont, String pText,
			TickerTextOptions pTickerTextOptions,
			VertexBufferObjectManager pVertexBufferObjectManager) {
		super(pX, pY, pFont, pText, pTickerTextOptions, pVertexBufferObjectManager);
	}

	public void doQuickComplete(){
		mCharactersVisible = mCharactersToDraw;
	}
	
	public boolean isComplete(){
		return mCharactersVisible == mCharactersToDraw;
	}
}
