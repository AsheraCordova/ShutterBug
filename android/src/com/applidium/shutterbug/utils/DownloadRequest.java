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

import com.applidium.shutterbug.ShutterbugManager.ShutterbugManagerListener;

import android.graphics.BitmapFactory;

public class DownloadRequest {
    private String                    mUrl;
    private ShutterbugManagerListener mListener;

    private int                       mDesiredHeight = -1;
    private int                       mDesiredWidth  = -1;

    public DownloadRequest(String url, ShutterbugManagerListener listener) {
        mUrl = url;
        mListener = listener;
    }

    public DownloadRequest(String url, ShutterbugManagerListener listener, int desiredHeight, int desiredWidth) {
        mUrl = url;
        mListener = listener;

        mDesiredHeight = desiredHeight;
        mDesiredWidth = desiredWidth;
    }

    public int getSampleSize(BitmapFactory.Options options) {
        if (mDesiredHeight <= 0 || mDesiredWidth <= 0) {
            return 1;
        }

        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > mDesiredHeight || width > mDesiredWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > mDesiredHeight && (halfWidth / inSampleSize) > mDesiredWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    public String getUrl() {
        return mUrl;
    }

    public ShutterbugManagerListener getListener() {
        return mListener;
    }
}
