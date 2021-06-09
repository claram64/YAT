package com.example.yat;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class GalleryListView extends AppCompatActivity {

    private FirebaseFirestore db=FirebaseFirestore.getInstance();
    private CollectionReference gallreyRef=db.collection("Galleries");
    private GalleryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_list);

        setUpRecyclerView();
    }
    private void setUpRecyclerView()
    {
        Query query=gallreyRef.orderBy("priority",Query.Direction.DESCENDING);

        FirestoreRecyclerOptions<Gallery> options=new FirestoreRecyclerOptions.Builder<Gallery>()
                .setQuery(query,Gallery.class)
                .build();

        adapter=new GalleryAdapter(options);

        RecyclerView recyclerView=findViewById(R.id.rec_gallery_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}