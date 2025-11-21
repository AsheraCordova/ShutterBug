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
package com.applidium.shutterbug.downloader;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.applidium.shutterbug.utils.DownloadRequest;

import android.os.AsyncTask;

public class ShutterbugDownloader {
    public interface ShutterbugDownloaderListener {
        void onImageDownloadSuccess(ShutterbugDownloader downloader, InputStream inputStream, DownloadRequest downloadRequest);

        void onImageDownloadFailure(ShutterbugDownloader downloader, DownloadRequest downloadRequest);
    }

    private String                             mUrl;
    private ShutterbugDownloaderListener       mListener;
    private byte[]                             mImageData;
    private DownloadRequest                    mDownloadRequest;
    private final static int                   TIMEOUT = 30000;
    private AsyncTask<Void, Void, InputStream> mCurrentTask;

    public ShutterbugDownloader(String url, ShutterbugDownloaderListener listener, DownloadRequest downloadRequest) {
        mUrl = url;
        mListener = listener;
        mDownloadRequest = downloadRequest;
    }

    public String getUrl() {
        return mUrl;
    }

    public ShutterbugDownloaderListener getListener() {
        return mListener;
    }

    public byte[] getImageData() {
        return mImageData;
    }

    public DownloadRequest getDownloadRequest() {
        return mDownloadRequest;
    }

    public void start() {
        mCurrentTask = new AsyncTask<Void, Void, InputStream>() {

            @Override
            protected InputStream doInBackground(Void... params) {
                try {
                	long t0 = System.currentTimeMillis();

                	System.out.println("starting download " + mUrl);
                    URL imageUrl = new URL(mUrl);
                    HttpURLConnection connection = (HttpURLConnection) imageUrl.openConnection();
                    connection.setConnectTimeout(TIMEOUT);
                    connection.setReadTimeout(TIMEOUT);
                    connection.setInstanceFollowRedirects(true);
                    InputStream inputStream = connection.getInputStream();
                    
    	            System.out.println("end download " + mUrl + " " + (System.currentTimeMillis() - t0));

                    return inputStream;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(InputStream inputStream) {
                if (isCancelled()) {
                    inputStream = null;
                }

                if (inputStream != null) {
                    mListener.onImageDownloadSuccess(ShutterbugDownloader.this, inputStream, mDownloadRequest);
                } else {
                    mListener.onImageDownloadFailure(ShutterbugDownloader.this, mDownloadRequest);
                }
            }

        }.execute();

    }

    public void cancel() {
        if (mCurrentTask != null) {
            mCurrentTask.cancel(true);
        }
    }
}
