package com.jdkgroup.loginanimation;
import android.app.*;
import android.support.multidex.MultiDex;

import com.jdkgroup.customview.FontsOverride;

public class Apps extends Application
{
	@Override
	public void onCreate() {
		MultiDex.install(this);
		FontsOverride.setDefaultFont(this, "SERIF","fonts/apercu_regular.otf");
		super.onCreate();
	}
}
