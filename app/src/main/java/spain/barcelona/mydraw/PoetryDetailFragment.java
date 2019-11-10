package spain.barcelona.mydraw;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class PoetryDetailFragment extends Fragment {

    private long poetryId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_poetry_detail, container, false);

        if (savedInstanceState != null) {
            poetryId = savedInstanceState.getLong("poetryId");
        }

        // Hiding toolbar
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).getSupportActionBar().hide();
        }

        // Back button
        ImageView imgBtn = v.findViewById(R.id.back_button);
        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            TextView title = view.findViewById(R.id.title_text);
            Text poem = Text.poetry[(int) poetryId];
            title.setText(poem.getTitle());
            TextView description = view.findViewById(R.id.description_text);
            description.setText(poem.getDescription());
            TextView sign = view.findViewById(R.id.outputData_text);
            String outputData = poem.getAuthor() + ". \n" + poem.getOutputData();
            sign.setText(outputData);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putLong("poetryId", poetryId);
    }

    public void setPoetryId(long id) {
        this.poetryId = id;
    }

}
