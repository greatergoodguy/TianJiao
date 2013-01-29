package org.burstingbrains.sharedlibs.universe;

import org.burstingbrains.sharedlibs.andengineext.BBSGameActivity;


public interface IAssets {
	public void init(BBSGameActivity bbsGameActivity);
	public void load();
	public void unload();
}
