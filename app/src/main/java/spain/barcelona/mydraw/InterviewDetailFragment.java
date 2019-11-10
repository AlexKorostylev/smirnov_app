package spain.barcelona.mydraw;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class InterviewDetailFragment extends Fragment {

    private long interviewId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_interview_detail, container, false);

        if (savedInstanceState != null) {
            interviewId = savedInstanceState.getLong("interviewId");
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
            Text interview = Text.interview[(int) interviewId];
            title.setText(interview.getTitle());
            TextView description = view.findViewById(R.id.description_text);
            description.setText(interview.getDescription());

            TextView sign = view.findViewById(R.id.outputData_text);
            String outputData = interview.getAuthor() + ". \n" + interview.getOutputData();
            sign.setText(outputData);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putLong("interviewId", interviewId);
    }

    public void setInterviewId(long id) {
        this.interviewId = id;
    }

}
