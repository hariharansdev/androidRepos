package com.xts.customvideoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;

import com.xts.customvideoplayer.databinding.ActivityMainBinding;
import com.xts.customvideoplayer.interfaces.AssessmentVideoListener;
import com.xts.customvideoplayer.models.AssessmentDuration;
import com.xts.customvideoplayer.models.MoodleVideoData;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements AssessmentVideoListener {


    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.videoView.setData(new MoodleVideoData<Integer>("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                new ArrayList<AssessmentDuration<Integer>>(Arrays.asList(
                        new AssessmentDuration<Integer>(10000, 1),
                        new AssessmentDuration<Integer>(30000, 2),
                        new AssessmentDuration<Integer>(50000, 3)))));
        binding.videoView.startListener(this);
        binding.videoView.setOnPreparedListener(mp->{
            MediaController mediaController= new MediaController(this);
            binding.videoView.setMediaController(mediaController);
            mediaController.setAnchorView(binding.videoView);
//            handler.postDelayed(runnable, 100);
        });
    }

    @Override
    public void onAssessmentPause(AssessmentDuration<?> duration) {

        Toast.makeText(this, "toast", Toast.LENGTH_SHORT).show();
    }
}