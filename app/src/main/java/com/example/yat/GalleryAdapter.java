package com.example.yat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

public class GalleryAdapter extends FirestoreRecyclerAdapter<Gallery, GalleryAdapter.GalleryHolder> {

    public GalleryAdapter(@NonNull @NotNull FirestoreRecyclerOptions<Gallery> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull @NotNull GalleryHolder holder, int position, @NonNull @NotNull Gallery model) {
//tell the adapter what to put in each viewCard layout
        holder.textViewGalleryName.setText(model.getName());//put the title of the gallery into this textview
        holder.textViewGalleryAddress.setText(model.getLocation());
        holder.textViewGalleryOpeningHours.setText(model.getOpeningH());
        Picasso.get().load(model.getImageUrl()).into(holder.imgViewGallery);
    }

    @NonNull
    @NotNull
    @Override
    public GalleryHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {//tell the adapter which layout it has to inflate
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_item,parent,false);
        return new GalleryHolder(v);
    }
//gets data from firestore into recyclerview

    class GalleryHolder extends RecyclerView.ViewHolder{

        ImageView imgViewGallery;
        TextView textViewGalleryName;
        TextView  textViewGalleryOpeningHours;
        TextView  textViewGalleryAddress;

        public GalleryHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imgViewGallery=itemView.findViewById(R.id.gallery_image);
            textViewGalleryName=itemView.findViewById(R.id.gallery_name);
            textViewGalleryAddress=itemView.findViewById(R.id.gallery_Address);
            textViewGalleryOpeningHours=itemView.findViewById(R.id.gallery_openingH);
        }
    }
}
