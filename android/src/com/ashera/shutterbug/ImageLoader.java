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

import android.graphics.drawable.Drawable;

public class ImageLoader implements com.applidium.shutterbug.ShutterbugImageCallBack {
	private ITarget target;
	private Object error;

	public ImageLoader(ITarget target, Object error) {
		this.target = target;
		this.error = error;
	}

	@Override
	public void setImageDrawable(Drawable drawable) {
		target.onPrepareLoad(drawable);
	}

	@Override
	public void setImageBitmap(android.graphics.Bitmap bitmap) {
		target.onBitmapLoaded(bitmap);
	}

	@Override
	public void showError(String url) {
		target.onBitmapFailed(error);
	}
}