package com.bearapp.material;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.app.NavUtils;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "position";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            VectorDrawableCompat indicator = VectorDrawableCompat.create(getResources(), R.drawable.ic_arrow_back_black_24dp, getTheme());
            indicator.setTint(ResourcesCompat.getColor(getResources(), R.color.white, getTheme()));
            supportActionBar.setHomeAsUpIndicator(indicator);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        TextView tvPlaceDetail = (TextView) findViewById(R.id.place_detail);
        TextView tvPlaceLocation = (TextView) findViewById(R.id.place_location);
        ImageView ivPlacePicture = (ImageView) findViewById(R.id.image);

        int position = getIntent().getIntExtra(EXTRA_POSITION, 0);

        Resources resources = getResources();
        String[] places = resources.getStringArray(R.array.places);
        String[] placeDetails = resources.getStringArray(R.array.place_details);
        String[] placeLocations = resources.getStringArray(R.array.place_locations);

        collapsingToolbarLayout.setTitle(places[position % places.length]);
        tvPlaceDetail.setText(placeDetails[position % places.length]);
        tvPlaceLocation.setText(placeLocations[position % placeLocations.length]);

        TypedArray a = resources.obtainTypedArray(R.array.places_picture);
        ivPlacePicture.setImageDrawable(a.getDrawable(position % a.length()));
        a.recycle();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
