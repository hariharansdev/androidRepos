package com.xts.customvideoplayer.models;

public class AssessmentDuration<T> {

    private Integer durationMillies;
    T object;

    public AssessmentDuration(Integer durationMillies, T object) {
        this.durationMillies = durationMillies;
        this.object = object;
    }

    public Integer getDurationMillies() {
        return durationMillies;
    }

    public void setDurationMillies(Integer durationMillies) {
        this.durationMillies = durationMillies;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
