package spain.barcelona.mydraw;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class PoetryDetailFragment extends Fragment {

    private long poetryId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (savedInstanceState != null) {
            poetryId = savedInstanceState.getLong("poetryId");
        }

        return inflater.inflate(R.layout.fragment_poetry_detail, container, false);
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
