package com.diostock.diostock.impl;

import android.net.NetworkInfo;

/**
 * Created by IMT 02 on 03/01/2017.
 */
    public interface DownloadCallback<T> {
        interface Progress {
            Integer ERROR = -1;
            Integer CONNECT_SUCCESS = 0;
            Integer GET_INPUT_STREAM_SUCCESS = 1;
            Integer PROCESS_INPUT_STREAM_IN_PROGRESS = 2;
            Integer PROCESS_INPUT_STREAM_SUCCESS = 3;
        }

        /**
         * Indicates that the callback handler needs to update its appearance or information based on
         * the result of the task. Expected to be called from the main thread.
         */
        void updateFromDownload(T result);

        /**
         * Get the device's active network status in the form of a NetworkInfo object.
         */
        NetworkInfo getActiveNetworkInfo();

        /**
         * Indicate to callback handler any progress update.
         * @param progressCode must be one of the constants defined in DownloadCallback.Progress.
         * @param percentComplete must be 0-100.
         */
        void onProgressUpdate(int progressCode, int percentComplete);

        /**
         * Indicates that the download operation has finished. This method is called even if the
         * download hasn't completed successfully.
         */
        void finishDownloading();
    }

