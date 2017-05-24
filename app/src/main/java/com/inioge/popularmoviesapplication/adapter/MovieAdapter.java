package com.inioge.popularmoviesapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.inioge.popularmoviesapplication.MovieDetailsActivity;
import com.inioge.popularmoviesapplication.R;
import com.inioge.popularmoviesapplication.models.MovieData;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ADMIN on 24/05/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private List<MovieData> movies;
    private Context context;
    private int rowLayout;


    public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        LinearLayout moviesLayout;
        ImageView posterImage;

        public LinearLayout getMoviesLayout() {
            return moviesLayout;
        }

        public void setMoviesLayout(LinearLayout moviesLayout) {
            this.moviesLayout = moviesLayout;
        }

        //Constructor to get widget reference
        public MovieViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            moviesLayout = (LinearLayout) itemView.findViewById(R.id.movies_layout);
            posterImage = (ImageView) itemView.findViewById(R.id.poster_image);

        }

        @Override
        public void onClick(View v) {
            Context context = v.getContext();
            Intent intent = new Intent(context, MovieDetailsActivity.class);
            MovieData data = movies.get(getLayoutPosition());
            intent.putExtra("data", data);
            context.startActivity(intent);

        }
    }
    public MovieAdapter(List<MovieData> movies, int rowLayout, Context context){
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;

    }

    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }

    // Get current position of item in recyclerview to bind data and assign values from list
    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        MovieData image = movies.get(position);
        String posterPath_url = "http://image.tmdb.org/t/p/w500" + image.getPosterPath();
        // load image into imageview using picasso
        Picasso.with(context).load(posterPath_url).placeholder(R.drawable.placeholder).into(holder.posterImage);

    }


    // return total item from List
    @Override
    public int getItemCount() {
        if (movies == null)
            return 0;
        return movies.size();
    }

}