package it.bellotti.android.materialdesignsample.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import it.bellotti.android.materialdesignsample.R;

/**
 * Created with Android Studio.
 * User: SimoneBellotti
 * Date: 10/11/2015
 * Time: 19.29
 * App:  MaterialDesignSample
 */
public class DetailActivity extends AppCompatActivity {

    public static Intent newIntent(Context context) {
        return new Intent(context, DetailActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // Set Collapsing Toolbar layout to the screen
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        // Set title of Detail page
        collapsingToolbar.setTitle(getString(R.string.item_title));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Hello!", Snackbar.LENGTH_LONG)
                        .setAction("Action", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                /* no-op */
                            }
                        }).show();
            }
        });

//        animateInFab(fab);
    }

    private void animateInFab(final View fab) {
        fab.setAlpha(0.0f);
        ViewCompat.animate(fab).scaleX(1.0F).scaleY(1.0F).alpha(1.0f)
                .setInterpolator(new FastOutSlowInInterpolator())
                .setDuration(150)
                .setStartDelay(250)
                .withLayer()
                .setListener(new ViewPropertyAnimatorListener() {
                    @Override
                    public void onAnimationStart(View view) {
                        view.setVisibility(View.GONE);
                    }
                    @Override
                    public void onAnimationCancel(View view) {

                    }
                    @Override
                    public void onAnimationEnd(View view) {
                        view.setVisibility(View.VISIBLE);
                    }
                })
                .start();
    }
}
