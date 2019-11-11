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
    public static int fontSizeChange = 4;

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
            final TextView description = view.findViewById(R.id.description_text);
            description.setText(interview.getDescription());

            final TextView sign = view.findViewById(R.id.outputData_text);
            String outputData = interview.getAuthor() + ". \n" + interview.getOutputData();
            sign.setText(outputData);

            if (fontSizeChange == 1) {
                description.setTextSize(getResources().getDimension(R.dimen.text_body_11));
                sign.setTextSize(getResources().getDimension(R.dimen.text_body_11));
            } else if (fontSizeChange == 2) {
                description.setTextSize(getResources().getDimension(R.dimen.text_body_12));
                sign.setTextSize(getResources().getDimension(R.dimen.text_body_12));
            } else if (fontSizeChange == 3) {
                description.setTextSize(getResources().getDimension(R.dimen.text_body_13));
                sign.setTextSize(getResources().getDimension(R.dimen.text_body_13));
            } else if (fontSizeChange == 4) {
                description.setTextSize(getResources().getDimension(R.dimen.text_body_14));
                sign.setTextSize(getResources().getDimension(R.dimen.text_body_14));
            } else if (fontSizeChange == 5) {
                description.setTextSize(getResources().getDimension(R.dimen.text_body_15));
                sign.setTextSize(getResources().getDimension(R.dimen.text_body_15));
            } else if (fontSizeChange == 6) {
                description.setTextSize(getResources().getDimension(R.dimen.text_body_16));
                sign.setTextSize(getResources().getDimension(R.dimen.text_body_16));
            } else if (fontSizeChange == 7) {
                description.setTextSize(getResources().getDimension(R.dimen.text_body_17));
                sign.setTextSize(getResources().getDimension(R.dimen.text_body_17));
            } else if (fontSizeChange == 8) {
                description.setTextSize(getResources().getDimension(R.dimen.text_body_18));
                sign.setTextSize(getResources().getDimension(R.dimen.text_body_18));
            } else if (fontSizeChange == 9) {
                description.setTextSize(getResources().getDimension(R.dimen.text_body_19));
                sign.setTextSize(getResources().getDimension(R.dimen.text_body_19));
            }

            // Increase button
            ImageView increaseBtn = view.findViewById(R.id.font_increase_btn);
            increaseBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ++fontSizeChange;
                    if (fontSizeChange == 1) {
                        description.setTextSize(getResources().getDimension(R.dimen.text_body_11));
                        sign.setTextSize(getResources().getDimension(R.dimen.text_body_11));
                    } else if (fontSizeChange == 2) {
                        description.setTextSize(getResources().getDimension(R.dimen.text_body_12));
                        sign.setTextSize(getResources().getDimension(R.dimen.text_body_12));
                    } else if (fontSizeChange == 3) {
                        description.setTextSize(getResources().getDimension(R.dimen.text_body_13));
                        sign.setTextSize(getResources().getDimension(R.dimen.text_body_13));
                    } else if (fontSizeChange == 4) {
                        description.setTextSize(getResources().getDimension(R.dimen.text_body_14));
                        sign.setTextSize(getResources().getDimension(R.dimen.text_body_14));
                    } else if (fontSizeChange == 5) {
                        description.setTextSize(getResources().getDimension(R.dimen.text_body_15));
                        sign.setTextSize(getResources().getDimension(R.dimen.text_body_15));
                    } else if (fontSizeChange == 6) {
                        description.setTextSize(getResources().getDimension(R.dimen.text_body_16));
                        sign.setTextSize(getResources().getDimension(R.dimen.text_body_16));
                    } else if (fontSizeChange == 7) {
                        description.setTextSize(getResources().getDimension(R.dimen.text_body_17));
                        sign.setTextSize(getResources().getDimension(R.dimen.text_body_17));
                    } else if (fontSizeChange == 8) {
                        description.setTextSize(getResources().getDimension(R.dimen.text_body_18));
                        sign.setTextSize(getResources().getDimension(R.dimen.text_body_18));
                    } else if (fontSizeChange >= 9) {
                        description.setTextSize(getResources().getDimension(R.dimen.text_body_19));
                        sign.setTextSize(getResources().getDimension(R.dimen.text_body_19));
                        fontSizeChange = 9;
                    }
                }
            });

            // Decrease button
            ImageView decreaseBtn = view.findViewById(R.id.font_decrease_btn);
            decreaseBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    --fontSizeChange;
                    if (fontSizeChange <= 1) {
                        description.setTextSize(getResources().getDimension(R.dimen.text_body_11));
                        sign.setTextSize(getResources().getDimension(R.dimen.text_body_11));
                        fontSizeChange = 1;
                    } else if (fontSizeChange == 2) {
                        description.setTextSize(getResources().getDimension(R.dimen.text_body_12));
                        sign.setTextSize(getResources().getDimension(R.dimen.text_body_12));
                    } else if (fontSizeChange == 3) {
                        description.setTextSize(getResources().getDimension(R.dimen.text_body_13));
                        sign.setTextSize(getResources().getDimension(R.dimen.text_body_13));
                    } else if (fontSizeChange == 4) {
                        description.setTextSize(getResources().getDimension(R.dimen.text_body_14));
                        sign.setTextSize(getResources().getDimension(R.dimen.text_body_14));
                    } else if (fontSizeChange == 5) {
                        description.setTextSize(getResources().getDimension(R.dimen.text_body_15));
                        sign.setTextSize(getResources().getDimension(R.dimen.text_body_15));
                    } else if (fontSizeChange == 6) {
                        description.setTextSize(getResources().getDimension(R.dimen.text_body_16));
                        sign.setTextSize(getResources().getDimension(R.dimen.text_body_16));
                    } else if (fontSizeChange == 7) {
                        description.setTextSize(getResources().getDimension(R.dimen.text_body_17));
                        sign.setTextSize(getResources().getDimension(R.dimen.text_body_17));
                    } else if (fontSizeChange == 8) {
                        description.setTextSize(getResources().getDimension(R.dimen.text_body_18));
                        sign.setTextSize(getResources().getDimension(R.dimen.text_body_18));
                    } else if (fontSizeChange == 9) {
                        description.setTextSize(getResources().getDimension(R.dimen.text_body_19));
                        sign.setTextSize(getResources().getDimension(R.dimen.text_body_19));
                    }
                }
            });
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
