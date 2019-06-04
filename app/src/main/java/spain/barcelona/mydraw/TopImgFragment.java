package spain.barcelona.mydraw;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import static spain.barcelona.mydraw.Pic.*;

public class TopImgFragment extends Fragment {

    static int dataForCounterPeriodState;
    static int dataForCounterIndexState;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_top_img, container, false);

        ImageView image = v.findViewById(R.id.info_image_top);
        TextView nameText = v.findViewById(R.id.name_text_top);

        int periodState = PaintBtnFragment.periodCurrentState; //
        int indexState = PaintBtnFragment.indexCurrentState;

        if (periodState == 0 & indexState == -1) {
            indexState = BizLogic.incrementCheck(periodState, indexState, paint);
            PaintBtnFragment.indexAllPeriod++;
        }

        image.setImageResource(paint[BizLogic.positionAtArray(periodState, indexState, paint)].getImageResourceId());
        nameText.setText(paint[BizLogic.positionAtArray(periodState, indexState, paint)].getName());

        dataForCounterPeriodState = periodState;
        dataForCounterIndexState = indexState;

        return v;
    }

}
