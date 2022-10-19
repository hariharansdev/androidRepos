package com.xts.customvideoplayer.interfaces;

import com.xts.customvideoplayer.models.AssessmentDuration;

public interface AssessmentVideoListener {

    void onAssessmentPause(AssessmentDuration<?> duration);
}
