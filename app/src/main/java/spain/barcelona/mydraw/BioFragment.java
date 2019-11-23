package spain.barcelona.mydraw;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import static spain.barcelona.mydraw.DetailPicFragment.artWayIndex;


public class BioFragment extends Fragment  {

    // TODO: Сделать отображение "биографии" через фрагменты. На планшете
    // TODO: фото слева - текст справа; На телефоно как сейчас.


    public static int fontSizeChange = 4;
    public static int paintIndex;

    ImgClickListener imgListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            imgListener = (ImgClickListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement onClickImgListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_biogrphy, container, false);

        setHasOptionsMenu(true);

        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.drawer_bio);




        TextView title = view.findViewById(R.id.title_text);
        final TextView description = view.findViewById(R.id.description_text);
        Text bio = Text.bio[0];
        title.setText(bio.getTitle());
        description.setText(bio.getDescription());

        ImageView additionalPic = view.findViewById(R.id.additional_pic);
        additionalPic.setImageResource(bio.getImageResourceId());
        paintIndex = bio.getImageResourceId();

        additionalPic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                imgListener.imgClick();
                artWayIndex = "bio";
            }
        });

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


        if(MainActivity.dayNightMode == 0){
            increaseBtn.setImageResource(R.drawable.font_increase_64_black);
            decreaseBtn.setImageResource(R.drawable.font_decrease_64_black);
        }else {
            increaseBtn.setImageResource(R.drawable.font_increase_64_white);
            decreaseBtn.setImageResource(R.drawable.font_decrease_64_white);
        }

        ((MainActivity) getActivity()).getSupportActionBar().show();

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Do something that differs the Activity's menu here
        menu.findItem(R.id.recycle_list).setTitle("Frame");
        menu.findItem(R.id.recycle_list).setVisible(false);
        if(MainActivity.dayNightMode ==0){
            menu.findItem(R.id.background_mode).setIcon(R.drawable.day_night_24_black);
        } else {
            menu.findItem(R.id.background_mode).setIcon(R.drawable.day_night_24_white);
        }
        super.onCreateOptionsMenu(menu, inflater);

    }
}
