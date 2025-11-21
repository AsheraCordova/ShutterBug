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
package com.applidium.shutterbug.utils;

import java.io.InputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapFactoryScale {
    public interface InputStreamGenerator {
        public InputStream getStream();
    }

    public static Bitmap decodeSampledBitmapFromStream(InputStreamGenerator generator, DownloadRequest request) {
        if (generator == null || request == null) {
            return null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(generator.getStream(), null, options);

            options.inSampleSize = request.getSampleSize(options);
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeStream(generator.getStream(), null, options);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            return null;
        }
    }
}
