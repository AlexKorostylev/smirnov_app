package spain.barcelona.mydraw;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class AboutDetailFragment extends Fragment {

    private long aboutId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (savedInstanceState != null) {
            aboutId = savedInstanceState.getLong("aboutId");
        }

        return inflater.inflate(R.layout.fragment_about_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            TextView title = view.findViewById(R.id.title_text);
            Text about = Text.about[(int) aboutId];
            title.setText(about.getTitle());
            TextView description = view.findViewById(R.id.description_text);
            description.setText(about.getDescription());
            TextView sign = view.findViewById(R.id.outputData_text);
            String outputData = about.getAuthor() + ". \n" + about.getOutputData();
            sign.setText(outputData);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putLong("aboutId", aboutId);
    }

    public void setAboutId(long id) {
        this.aboutId = id;
    }

}
