package com.xts.customvideoplayer.customviews;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.VideoView;

import com.xts.customvideoplayer.interfaces.AssessmentVideoListener;
import com.xts.customvideoplayer.models.AssessmentDuration;
import com.xts.customvideoplayer.models.MoodleVideoData;

import java.util.ArrayList;

public class MoodleVideoView extends VideoView {

    private AssessmentVideoListener assessmentVideoListener;
    private int listenerDelayMillies = 100;

    private Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {

            if (assessments.size() > 0 && assessments.get(0).getDurationMillies() <= getCurrentPosition() && isPlaying()) {
                if (assessmentVideoListener != null) {
                    assessmentVideoListener.onAssessmentPause(assessments.get(0));
                }
                pause();
                seekTo(assessments.get(0).getDurationMillies());
                assessments.remove(0);
            }

            handler.postDelayed(this, listenerDelayMillies);

        }
    };
    private ArrayList<AssessmentDuration<?>> assessments = new ArrayList<>();
    private MoodleVideoData<?> videoData;

    public MoodleVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setData(MoodleVideoData<?> videoData) {
        this.videoData = videoData;
        assessments = (ArrayList) videoData.getAssessmentDurations().clone();
        setVideoURI(Uri.parse(videoData.getUri()));
    }

    public void startListener(AssessmentVideoListener assessmentVideoListener) {
        setAssessmentVideoListener(assessmentVideoListener);
        handler.postDelayed(runnable, listenerDelayMillies);
    }

    public void stopListener() {
        handler.removeCallbacks(runnable);
    }

    @Override
    public void resume() {
        Log.d(">>Resume>>", "resumeeeee");
        super.resume();
    }

    public int getListenerDelayMillies() {
        return listenerDelayMillies;
    }

    public void setListenerDelayMillies(int listenerDelayMillies) {
        this.listenerDelayMillies = listenerDelayMillies;
    }

    public AssessmentVideoListener getAssessmentVideoListener() {
        return assessmentVideoListener;
    }

    public void setAssessmentVideoListener(AssessmentVideoListener assessmentVideoListener) {
        this.assessmentVideoListener = assessmentVideoListener;
    }

    public void restart(){
        assessments = (ArrayList) videoData.getAssessmentDurations().clone();
        this.seekTo(0);
        this.start();
    }
}
