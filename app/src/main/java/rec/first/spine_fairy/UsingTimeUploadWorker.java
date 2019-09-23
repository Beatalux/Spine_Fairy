package com.example.myapplication;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class UsingTimeUploadWorker extends Worker {
    public UsingTimeUploadWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @Override
    public Worker.Result doWork() {
        
        return Result.success();
    }
}
