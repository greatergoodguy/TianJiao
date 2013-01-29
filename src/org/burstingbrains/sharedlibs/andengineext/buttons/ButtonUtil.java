package org.burstingbrains.sharedlibs.andengineext.buttons;

public class ButtonUtil {
	public static IBBOnClickListener dummyBBOnClickListener = new IBBOnClickListener(){
		@Override
		public void onClick() {
			// This is a dummy listener so this 
			// method should be empty
		}
	};
}
