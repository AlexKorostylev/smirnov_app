package spain.barcelona.mydraw;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import static spain.barcelona.mydraw.Pic.pics;


public class GraphicImgFragment extends Fragment {

    static int dataForCounterPeriodState;
    static int dataForCounterIndexState;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_graphic_img, container, false);
        ImageView image = v.findViewById(R.id.info_image_graphic);
        TextView nameText = v.findViewById(R.id.name_text_graphic);

        int periodState = GraphicBtnFragment.periodCurrentState;
        int indexState = GraphicBtnFragment.indexCurrentState;

        // Сохранение состояния периода по направлению
        if (periodState == 0 & indexState == -1) {
            indexState = BizLogic.incrementCheck(periodState, indexState, pics);
            GraphicBtnFragment.indexAllPeriod++;
        }

        image.setImageResource(pics[BizLogic.positionAtArray(periodState, indexState, pics)].getImageResourceId());
        nameText.setText(pics[BizLogic.positionAtArray(periodState, indexState, pics)].getName());

        dataForCounterPeriodState = periodState;
        dataForCounterIndexState = indexState;

        return v;
    }

}
