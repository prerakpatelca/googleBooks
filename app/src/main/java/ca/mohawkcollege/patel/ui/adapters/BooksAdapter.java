package ca.mohawkcollege.patel.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.net.MalformedURLException;

import androidx.recyclerview.widget.RecyclerView;
import ca.mohawkcollege.patel.R;
import ca.mohawkcollege.patel.ui.Data.GoogleBook;
import ca.mohawkcollege.patel.ui.activities.BookDetailActivity;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.GoogleBooksData> {
    GoogleBook[] googleBooks;
    Context context;

    public BooksAdapter(GoogleBook[] datajson, Context context)
    {
        googleBooks = datajson;
        this.context = context;
    }

    @Override
    public GoogleBooksData onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.books_list,parent,false);
        GoogleBooksData googleBooksData = new GoogleBooksData(view);
        return googleBooksData;
    }

    @Override
    public void onBindViewHolder(GoogleBooksData holder, int position) {
        holder.bind(googleBooks[position]);
    }

    @Override
    public int getItemCount() {
        return googleBooks.length;
    }

    public class GoogleBooksData extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView bookTitleLabel;
        private TextView authorLabel;
        private TextView publisherLabel;
        private TextView publishedDateLabel;
        private ImageView thumnail;


        public GoogleBooksData(View view) {
            super(view);
            bookTitleLabel = view.findViewById(R.id.bookTitleLabel);
            authorLabel = view.findViewById(R.id.authorLabel);
            publisherLabel = view.findViewById(R.id.publisherLabel);
            publishedDateLabel = view.findViewById(R.id.publishedDateLabel);
            thumnail = view.findViewById(R.id.thumnail);
            view.setOnClickListener(this);
        }

        public void bind(GoogleBook eachGoogleBook){

            Glide.with(context).load(eachGoogleBook.getThumbnail()).error(R.drawable.ic_google_books_logo).override(400,400).into(thumnail);
            bookTitleLabel.setText(eachGoogleBook.getTitle());
            authorLabel.setText(eachGoogleBook.getAuthors());
            publisherLabel.setText(eachGoogleBook.getPublisher());
            publishedDateLabel.setText(String.valueOf(eachGoogleBook.getPublishedDate()));
        }

        @Override
        public void onClick(View view)
        {
            Intent intent = new Intent(context, BookDetailActivity.class);
            intent.putExtra("BookTitle", googleBooks[getAdapterPosition()].getTitle());
            intent.putExtra("BookAuthor", googleBooks[getAdapterPosition()].getAuthors());
            intent.putExtra("Publisher", googleBooks[getAdapterPosition()].getPublisher());
            intent.putExtra("PublishedDate", googleBooks[getAdapterPosition()].getPublishedDate());
            intent.putExtra("Description", googleBooks[getAdapterPosition()].getDescription());
            intent.putExtra("Thumbnail", googleBooks[getAdapterPosition()].getThumbnail());
            context.startActivity(intent);
        }
    }
}

