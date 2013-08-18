package com.michelboudreau.sample;

import android.os.Bundle;
import android.widget.TextView;
import com.github.rtyley.android.sherlock.roboguice.activity.RoboSherlockActivity;
import org.holoeverywhere.app.Activity;
import roboguice.inject.ContentView;
import roboguice.inject.ContentViewListener;
import roboguice.inject.InjectView;

import javax.inject.Inject;

@Activity.Addons(Activity.ADDON_SLIDER)
@ContentView(R.layout.main)
public class MainActivity extends RoboSherlockActivity {

    // Various views that we inject into the activity.e
    // Equivalent to calling findViewById() in your onCreate(), except more succinct
    @InjectView(R.id.mainText)
    TextView mainText;

	@Inject
	ContentViewListener ignored;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // @Inject, @InjectResource, and @InjectExtra injection happens during super.onCreate()


    }
}




