package ca.mohawkcollege.patel.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import ca.mohawkcollege.patel.R;
import ca.mohawkcollege.patel.ui.fragments.DetailFragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class BookDetailActivity extends AppCompatActivity {

    String bookTitle;
    String bookAuthor;
    String publisher;
    String publishedDate;
    String description;
    String thubmnail;
    String CHANNEL_ID =  "default";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        Intent intent = getIntent();
        bookTitle = intent.getStringExtra("BookTitle");
        bookAuthor = intent.getStringExtra("BookAuthor");
        publisher = intent.getStringExtra("Publisher");
        publishedDate = intent.getStringExtra("PublishedDate");
        description = intent.getStringExtra("Description");
        thubmnail = intent.getStringExtra("Thumbnail");

        Log.v("Detail", "Title: " + bookTitle + " Author: " + bookAuthor + " Publisher: " + publisher + " PublisherDate " + publishedDate + " Description: " + description + " Thumbnail: " + thubmnail);

        Bundle bundle = new Bundle();
        bundle.putString("bookTitleLabel",bookTitle);
        bundle.putString("authorLabel",bookAuthor);
        bundle.putString("publisherLabel",publisher);
        bundle.putString("publishedDateLabel",publishedDate);
        bundle.putString("description",description);
        bundle.putString("thubmnail",thubmnail);

        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.bookDetailFragment, detailFragment);
        fragmentTransaction.commit();
    }
}
