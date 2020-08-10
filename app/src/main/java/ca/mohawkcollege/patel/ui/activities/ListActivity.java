package ca.mohawkcollege.patel.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ca.mohawkcollege.patel.R;
import ca.mohawkcollege.patel.ui.Data.AllBooks;
import ca.mohawkcollege.patel.ui.Data.GoogleBook;
import ca.mohawkcollege.patel.ui.adapters.BooksAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import static ca.mohawkcollege.patel.ui.home.HomeFragment.TAG1;
import static ca.mohawkcollege.patel.ui.home.HomeFragment.TAG2;

public class ListActivity extends AppCompatActivity {

    public String title;
    public String author;
    public String booksURL;
    public AllBooks allBooks;
    public TextView totalbooksTextView;
    public int totalItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Intent intent = getIntent();
        title = intent.getStringExtra(TAG1);
        author = intent.getStringExtra(TAG2);

        totalbooksTextView = findViewById(R.id.totalbooksTextView);

        OkHttpClient okHttpClient = new OkHttpClient();
        booksURL = "https://www.googleapis.com/books/v1/volumes?q=intitle:" + title + "+" + "inauthor:" + author + "&maxResults=40";
        Log.v("URL",booksURL);
        Request requestBuilder = new Request.Builder().url(booksURL).build();
        okHttpClient.newCall(requestBuilder).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
            }

            @Override
            public void onResponse(Response response) throws IOException {
                String bookData = response.body().string();
                Log.v("data", bookData);

                try {

                    allBooks = getData(bookData);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            RecyclerView recyclerView;
                            recyclerView = findViewById(R.id.booksList);
                            BooksAdapter booksAdapter = new BooksAdapter(allBooks.getGoogleBooks(),ListActivity.this);
                            recyclerView.setAdapter(booksAdapter);
                            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ListActivity.this);
                            recyclerView.setLayoutManager(layoutManager);
                            recyclerView.setHasFixedSize(true);
                        }
                    });

                } catch (JSONException e) {
                    e.printStackTrace();
                }
//                if (response.isSuccessful()) {
//                    try{

//
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
            }
        });
    }
        private AllBooks getData(String bookData) throws JSONException {
            AllBooks allBooks = new AllBooks();
            allBooks.setGoogleBooks(getEachBookData(bookData));
            return allBooks;
        }

        public GoogleBook[] getEachBookData(String bookData) throws JSONException {
            JSONObject reader = new JSONObject(bookData);
            JSONArray items = reader.optJSONArray("items");
            if(items != null){
                totalItems = items.length();
            }
            else{
                totalItems = 0;
            }
            GoogleBook[] allBooks = new GoogleBook[totalItems];

            for (int counter = 0; counter < totalItems; counter++)
            {
                GoogleBook googleBook = new GoogleBook();
                JSONObject volumeInfoReader = items.optJSONObject(counter);
                JSONObject volumeInfo = volumeInfoReader.optJSONObject("volumeInfo");
                googleBook.setTitle(volumeInfo.optString("title"));
                googleBook.setPublishedDate(volumeInfo.optString("publishedDate"));
                googleBook.setPublisher(volumeInfo.optString("publisher"));
                googleBook.setDescription(volumeInfo.optString("description"));

                JSONArray authorsReader = volumeInfo.optJSONArray("authors");
                String authors = "";
                if(authorsReader != null){
                    for (int eachAuthor = 0; eachAuthor < authorsReader.length(); eachAuthor++)
                    {
                        if (eachAuthor < authorsReader.length()-1){
                            authors += authorsReader.get(eachAuthor)+", ";
                        }
                        else {
                            authors += authorsReader.get(eachAuthor);
                        }
                    }
                }
                googleBook.setAuthors(authors);

                JSONObject imageLinks = volumeInfo.optJSONObject("imageLinks");
                if(imageLinks !=null){
                    googleBook.setThumbnail(imageLinks.optString("thumbnail"));
                }
                else {
                    googleBook.setThumbnail("");
                }

                allBooks[counter] = googleBook;
            }
            if(allBooks.length > 0){
                totalbooksTextView.setText("We've found some listings!!");
            }
            else {
                totalbooksTextView.setText("Sorry no result found for this search!!");
            }
            return allBooks;
        }

    }
