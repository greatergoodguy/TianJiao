package org.burstingbrains.tianjiao.storybook;

import org.andengine.entity.Entity;
import org.andengine.entity.IEntity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.util.HorizontalAlign;
import org.andengine.util.color.Color;
import org.burstingbrains.sharedlibs.andengineext.BBSTickerText;
import org.burstingbrains.sharedlibs.andengineext.TickerText.TickerTextOptions;
import org.burstingbrains.sharedlibs.universe.Universe;
import org.burstingbrains.tianjiao.assets.StorybookAssets;
import org.burstingbrains.tianjiao.constants.GameConstants;

public class TextBoxManagerSingleton implements GameConstants{
	private static final TextBoxManagerSingleton textBoxManagerSingleton = new TextBoxManagerSingleton();

	private StorybookAssets assets = StorybookAssets.getSingleton();

	private static final float TEXT_BOX_WIDTH = CAMERA_WIDTH;
	private static final float TEXT_BOX_HEIGHT = 200;

	private static final float TICKER_TEXT_DEFAULT_SPEED = 30; // Units are characters per second

	private Universe universe;

	private IEntity rootEntity;

	private Rectangle background;

	private Text nameTagText;
	private BBSTickerText speechText;

	public TextBoxManagerSingleton(){
	}

	public void init(Universe universe){
		this.universe = universe;

		rootEntity = new Entity();

		background = new Rectangle(0, 0, TEXT_BOX_WIDTH, TEXT_BOX_HEIGHT, universe.getVertexBufferObjectManager());
		background.setColor(Color.WHITE);
		background.setAlpha(0.5f);

		nameTagText = new Text(30, 20, assets.storybookFont, "TianJiao :", 
				new TextOptions(HorizontalAlign.LEFT), universe.getVertexBufferObjectManager());
		nameTagText.setColor(Color.RED);

		speechText = new BBSTickerText(200, 20, assets.storybookFont, "Hello, my name is Tian Jiao. HIYA. What would you like to do today? Oh Crap a hobo", 
				new TickerTextOptions(HorizontalAlign.LEFT, TICKER_TEXT_DEFAULT_SPEED), universe.getVertexBufferObjectManager());

		rootEntity.attachChild(background);
		rootEntity.attachChild(nameTagText);
		rootEntity.attachChild(speechText);
	}

	public IEntity getEntity(){
		assertIsValid();
		return rootEntity;
	}

	public void increaseTextTickerSpeed(int charsPerSecond){
		assertIsValid();
		speechText.setCharactersPerSecond(charsPerSecond);
	}

	public void reverseTextTicker(){
		assertIsValid();
		speechText.setReverse(true);
	}

	public void setSpeechTextAndReset(String string) {
		assertIsValid();
		speechText.setText(string);
		speechText.reset();
	}

	public void doQuickComplete() {
		assertIsValid();
		speechText.doQuickComplete();
	}	
	
	public int getCharactersVisible() {
		assertIsValid();
		return speechText.getCharactersVisible();
	}
	
	public boolean isComplete() {
		return speechText.isComplete();		
	}

	//====================
	// Singleton
	//====================
	public static TextBoxManagerSingleton getSingleton(){
		return textBoxManagerSingleton;
	}

	//====================
	// Validation Method
	//====================
	private void assertIsValid(){
		assert universe != null;

		assert rootEntity != null;
		assert background != null;
		assert nameTagText != null;
		assert speechText != null;
	}
}