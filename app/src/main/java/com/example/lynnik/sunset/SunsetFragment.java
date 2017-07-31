package com.example.lynnik.sunset;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SunsetFragment extends Fragment {

  private View mSceneView;
  private View mSunView;
  private View mSkyView;

  public static SunsetFragment newInstance() {
    return new SunsetFragment();
  }

  @Nullable
  @Override
  public View onCreateView(
      LayoutInflater inflater,
      @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_sunset, container, false);

    mSceneView = v;
    mSunView = v.findViewById(R.id.sun);
    mSkyView = v.findViewById(R.id.sky);

    mSceneView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        startAnimation();
      }
    });

    return v;
  }

  private void startAnimation() {
    float sunYStart = mSunView.getTop();
    float sunYEnd = mSunView.getHeight();

    ObjectAnimator heightAnimator = ObjectAnimator
        .ofFloat(mSunView, "y", sunYStart, sunYEnd);

    heightAnimator.start();
  }
}