//start - license
/*
 * Copyright (c) 2025 Ashera Cordova
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
//end - license
package com.ashera.shutterbug;

import com.ashera.image.ITarget;

import android.content.Context;
import android.graphics.drawable.Drawable;

public class ShutterBugPlugin  {
    private static final class Target implements com.ashera.image.IImageDownloader {
		@Override
		public void download(Object context, String url, Object placeholder, Object error, ITarget target) {
			com.applidium.shutterbug.ShutterbugManager.getSharedImageManager((Context) context).download(url, (Drawable) placeholder, new ImageLoader(target, error));				

		}
	}

	public static void initPlugin() {
    	//start - body
    	//end - body
		com.ashera.image.ImageDownloaderFactory.register(new Target());
    }
}
