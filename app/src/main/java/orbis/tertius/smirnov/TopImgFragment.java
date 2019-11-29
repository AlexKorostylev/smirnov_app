package orbis.tertius.smirnov;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import static orbis.tertius.smirnov.DetailPicFragment.artWayIndex;
import static orbis.tertius.smirnov.Pic.*;

public class TopImgFragment extends Fragment {

    static int dataForCounterPeriodState;
    static int dataForCounterIndexState;
    static int indexToPicDetail;

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
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_top_img, container, false);

        ImageView image = v.findViewById(R.id.info_image_top);
        TextView nameText = v.findViewById(R.id.name_text_top);

        int periodState = MainActivity.periodCurrentStateWelcome;
        int indexState = MainActivity.indexCurrentStateWelcome;

        if (periodState == 0 & indexState == -1) {
            indexState = BizLogic.incrementCheck(periodState, indexState, topScreen);
            MainActivity.indexAllPeriodWelcome++;
        }

        image.setImageResource(topScreen[BizLogic.positionAtArray(periodState, indexState, topScreen)].getImageResourceId());
        nameText.setText(topScreen[BizLogic.positionAtArray(periodState, indexState, topScreen)].getName());

        indexToPicDetail = BizLogic.positionAtArray(periodState, indexState, topScreen);
        artWayIndex = "welcome";

        dataForCounterPeriodState = periodState;
        dataForCounterIndexState = indexState;

        image.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                imgListener.imgClick();
            }
        });

        return v;
    }

}
