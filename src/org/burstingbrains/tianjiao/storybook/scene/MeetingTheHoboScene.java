package org.burstingbrains.tianjiao.storybook.scene;

import java.util.ArrayList;
import java.util.List;

import org.burstingbrains.tianjiao.storybook.StorybookBackground;
import org.burstingbrains.tianjiao.storybook.TianJiao;
import org.burstingbrains.tianjiao.storybook.scene.meetingthehobo.Act1;
import org.burstingbrains.tianjiao.storybook.scene.meetingthehobo.Act2;
import org.burstingbrains.tianjiao.storybook.scene.meetingthehobo.TextAct;

import android.util.Log;

public class MeetingTheHoboScene implements IScene{
	private final static float WALK_SPEED = 200;

	private StorybookBackground background;
	private TianJiao tianJiao;
	
	private List<IAct> acts;
	
	private IAct activeAct;
	private int activeActIndex;
	
	
	
	public MeetingTheHoboScene(StorybookBackground background, TianJiao tianJiao){
		this.background = background;
		this.tianJiao = tianJiao;
		
		acts = new ArrayList<IAct>();
		
		acts.add(new Act1(tianJiao));
		acts.add(new Act2(tianJiao));
		acts.add(new TextAct("Hello mister hobo. How do you do? The weather is nice today."));
		
		reset();
	}
	
	@Override
	public void update(float pSecondsElapsed) {
		activeAct.update(pSecondsElapsed);
	}

	@Override
	public void reset() {
		activeActIndex = 0;
		activeAct = acts.get(activeActIndex);
		activeAct.reset();
	}

	@Override
	public void doNext() {
		if(!activeAct.isCompleted()){
			activeAct.doQuickComplete();
		}
		else{
			if(activeActIndex >= acts.size() - 1)
				activeActIndex = 0;
			else
				activeActIndex++;
			
			activeAct = acts.get(activeActIndex);
			activeAct.reset();
		}
		
	}

}
