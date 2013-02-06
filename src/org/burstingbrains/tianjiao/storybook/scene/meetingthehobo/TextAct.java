package org.burstingbrains.tianjiao.storybook.scene.meetingthehobo;

import java.util.List;

import org.andengine.entity.scene.menu.item.TextMenuItem;
import org.burstingbrains.tianjiao.storybook.TextBoxManagerSingleton;
import org.burstingbrains.tianjiao.storybook.scene.IAct;

import android.util.Log;

public class TextAct implements IAct{
	
	private TextBoxManagerSingleton textBoxManager = TextBoxManagerSingleton.getSingleton();

	private boolean isComplete = false;
	
	private String testString;
	private List<String> storyText;
	
	public TextAct(String testString){
		this.testString = testString;	
	}
	
	public TextAct(List<String> storyText){
		this.storyText = storyText;
	}

	@Override
	public void update(float pSecondsElapsed) {
		isComplete = textBoxManager.isComplete();
	}

	@Override
	public void doQuickComplete() {
		textBoxManager.doQuickComplete();
		isComplete = true;
	}

	@Override
	public boolean isCompleted() {
		return isComplete;
	}

	@Override
	public void reset() {
		textBoxManager.setSpeechTextAndReset(testString);
		isComplete = false;
	}

}
