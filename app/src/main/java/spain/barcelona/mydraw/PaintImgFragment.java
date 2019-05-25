package spain.barcelona.mydraw;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import static spain.barcelona.mydraw.BizLogic.*;
import static spain.barcelona.mydraw.Pic.*;
import static spain.barcelona.mydraw.PaintBtnFragment.indexAllPeriod;


public class PaintImgFragment extends Fragment {

    static int dataForCounterPeriodState; // 0 главный период
    static int dataForCounterIndexState; //-1 - first start*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_paint_img, container, false);
        ImageView image = v.findViewById(R.id.info_image_paint);
        TextView nameText = v.findViewById(R.id.name_text_paint);

        int periodState = PaintBtnFragment.periodCurrentState; //
        int indexState = PaintBtnFragment.indexCurrentState;

        // Сохранение состояния периода по направлению
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
