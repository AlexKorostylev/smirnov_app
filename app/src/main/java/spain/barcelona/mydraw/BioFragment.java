package spain.barcelona.mydraw;

import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class BioFragment extends Fragment {

    // TODO: Сделать отображение "биографии" через фрагменты. На планшете
    // TODO: фото слева - текст справа; На телефоно как сейчас.


    public static int fontSizeChange = 4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_biogrphy, container, false);

        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.drawer_bio);

        TextView title = view.findViewById(R.id.title_text);
        final TextView description = view.findViewById(R.id.description_text);
        Text bio = Text.bio[0];
        title.setText(bio.getTitle());
        description.setText(bio.getDescription());

        if (fontSizeChange == 1) {
            description.setTextSize(getResources().getDimension(R.dimen.text_body_11));
        } else if (fontSizeChange == 2) {
            description.setTextSize(getResources().getDimension(R.dimen.text_body_12));
        } else if (fontSizeChange == 3) {
            description.setTextSize(getResources().getDimension(R.dimen.text_body_13));
        } else if (fontSizeChange == 4) {
            description.setTextSize(getResources().getDimension(R.dimen.text_body_14));
        } else if (fontSizeChange == 5) {
            description.setTextSize(getResources().getDimension(R.dimen.text_body_15));
        } else if (fontSizeChange == 6) {
            description.setTextSize(getResources().getDimension(R.dimen.text_body_16));
        } else if (fontSizeChange == 7) {
            description.setTextSize(getResources().getDimension(R.dimen.text_body_17));
        } else if (fontSizeChange == 8) {
            description.setTextSize(getResources().getDimension(R.dimen.text_body_18));
        } else if (fontSizeChange == 9) {
            description.setTextSize(getResources().getDimension(R.dimen.text_body_19));
        }

        // Increase button
        ImageView increaseBtn = view.findViewById(R.id.font_increase_btn);
        increaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++fontSizeChange;
                if (fontSizeChange == 1) {
                    description.setTextSize(getResources().getDimension(R.dimen.text_body_11));
                } else if (fontSizeChange == 2) {
                    description.setTextSize(getResources().getDimension(R.dimen.text_body_12));
                } else if (fontSizeChange == 3) {
                    description.setTextSize(getResources().getDimension(R.dimen.text_body_13));
                } else if (fontSizeChange == 4) {
                    description.setTextSize(getResources().getDimension(R.dimen.text_body_14));
                } else if (fontSizeChange == 5) {
                    description.setTextSize(getResources().getDimension(R.dimen.text_body_15));
                } else if (fontSizeChange == 6) {
                    description.setTextSize(getResources().getDimension(R.dimen.text_body_16));
                } else if (fontSizeChange == 7) {
                    description.setTextSize(getResources().getDimension(R.dimen.text_body_17));
                } else if (fontSizeChange == 8) {
                    description.setTextSize(getResources().getDimension(R.dimen.text_body_18));
                } else if (fontSizeChange >= 9) {
                    description.setTextSize(getResources().getDimension(R.dimen.text_body_19));
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
                    fontSizeChange = 1;
                } else if (fontSizeChange == 2) {
                    description.setTextSize(getResources().getDimension(R.dimen.text_body_12));
                } else if (fontSizeChange == 3) {
                    description.setTextSize(getResources().getDimension(R.dimen.text_body_13));
                } else if (fontSizeChange == 4) {
                    description.setTextSize(getResources().getDimension(R.dimen.text_body_14));
                } else if (fontSizeChange == 5) {
                    description.setTextSize(getResources().getDimension(R.dimen.text_body_15));
                } else if (fontSizeChange == 6) {
                    description.setTextSize(getResources().getDimension(R.dimen.text_body_16));
                } else if (fontSizeChange == 7) {
                    description.setTextSize(getResources().getDimension(R.dimen.text_body_17));
                } else if (fontSizeChange == 8) {
                    description.setTextSize(getResources().getDimension(R.dimen.text_body_18));
                } else if (fontSizeChange == 9) {
                    description.setTextSize(getResources().getDimension(R.dimen.text_body_19));
                }
            }
        });


        return view;
    }
}
