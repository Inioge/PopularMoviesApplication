package com.inioge.popularmoviesapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.inioge.popularmoviesapplication.models.MovieData;
import com.squareup.picasso.Picasso;

public class MovieDetailsActivity extends AppCompatActivity {

    private Context context;
    TextView title;
    ImageView image;
    TextView releaseDate;
    TextView ratings;
    TextView overView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        title = (TextView) findViewById(R.id.title);
        image = (ImageView) findViewById(R.id.poster_image_details);
        releaseDate = (TextView) findViewById(R.id.release_date);
        ratings = (TextView) findViewById(R.id.rating);
        overView = (TextView) findViewById(R.id.overview);

        MovieData data = getIntent().getParcelableExtra("data");

        String backDrop_url = "http://image.tmdb.org/t/p/w500" + data.getPosterPath();
        // load image into imageview using picasso
        Picasso.with(context).load(backDrop_url).placeholder(R.drawable.placeholder).into(image);
        title.setText(data.getTitle());
        releaseDate.setText(data.getDate());
        ratings.setText(data.getRating().toString());
        overView.setText(data.getOverview());

    }

    @Override
    protected void onStart() {
        super.onStart();


    }


}
