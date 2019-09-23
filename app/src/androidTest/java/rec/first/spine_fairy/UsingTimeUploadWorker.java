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
        long screenOnTime = System.currentTimeMillis()*1000*60;
        if(screenOnTime >=10 && screenOnTime <= 20) {
            
        }
        else if(screenOnTime >=30 && screenOnTime <=40) {

        }
        else if(screenOnTime >=50 && screenOnTime <=60) {

        }
        return Result.success();
    }
}
