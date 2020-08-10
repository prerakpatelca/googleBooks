package ca.mohawkcollege.patel.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import ca.mohawkcollege.patel.R;

public class DetailFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.book_detail, container, false);
        String bookTitle = getArguments().getString("bookTitleLabel");
        String bookAuthor = getArguments().getString("authorLabel");
        String publisher = getArguments().getString("publisherLabel");
        String publishedDate = getArguments().getString("publishedDateLabel");
        String description = getArguments().getString("description");
        String thubmnail = getArguments().getString("thubmnail");

        Log.v("Detail", "Title: " + bookTitle + " Author: " + bookAuthor + " Publisher: " + publisher + " PublisherDate " + publishedDate);

        TextView title = rootView.findViewById(R.id.bookTitle);
        TextView author = rootView.findViewById(R.id.author);
        TextView bookPublisher = rootView.findViewById(R.id.publisher);
        TextView bookPublishedDate = rootView.findViewById(R.id.publicationDateTextView);
        TextView bookDescription = rootView.findViewById(R.id.descriptionTextView);
        ImageView bookThumbnail = rootView.findViewById(R.id.thumbnailImage);

        title.setText(bookTitle);
        author.setText(bookAuthor);
        bookPublisher.setText(publisher);
        bookPublishedDate.setText(publishedDate);
        bookDescription.setText(description);
        Glide.with(this).load(thubmnail).error(R.drawable.ic_google_books_logo).override(400,400).into(bookThumbnail);
        return rootView;
    }

}
