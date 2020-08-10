package ca.mohawkcollege.patel.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import ca.mohawkcollege.patel.ui.activities.ListActivity;
import ca.mohawkcollege.patel.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    TextView titleEditText;
    TextView authorEditText;
    public static final String TAG1 = "titleEditText";
    public static final String TAG2 = "authorEditText";


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        titleEditText = root.findViewById(R.id.titleEditText);
        authorEditText = root.findViewById(R.id.authorEditText);

        Button searchBooksButton = root.findViewById(R.id.searchBooksButton);
        searchBooksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ListActivity.class);
                intent.putExtra(TAG1,titleEditText.getText().toString());
                intent.putExtra(TAG2,authorEditText.getText().toString());
                startActivity(intent);
            }
        });

        return root;
    }
}