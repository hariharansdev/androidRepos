package com.xts.customvideoplayer.models;

import java.util.ArrayList;
import java.util.List;

public class MoodleVideoData<T> {

    private String uri;

    private ArrayList<AssessmentDuration<T>> assessmentDurations;


    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public ArrayList<AssessmentDuration<T>> getAssessmentDurations() {
        return assessmentDurations;
    }

    public void setAssessmentDurations(ArrayList<AssessmentDuration<T>> assessmentDurations) {
        this.assessmentDurations = assessmentDurations;
    }

    public MoodleVideoData(String uri, ArrayList<AssessmentDuration<T>> assessmentDurations) {
        this.uri = uri;
        this.assessmentDurations = assessmentDurations;
    }
}
