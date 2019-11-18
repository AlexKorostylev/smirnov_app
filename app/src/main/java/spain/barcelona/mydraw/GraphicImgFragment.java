package spain.barcelona.mydraw;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import static spain.barcelona.mydraw.DetailPicFragment.artWayIndex;
import static spain.barcelona.mydraw.Pic.*;

public class GraphicImgFragment extends Fragment {

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
        View v = inflater.inflate(R.layout.fragment_graphic_img, container, false);
        final ImageView image = v.findViewById(R.id.info_image_graphic);
        TextView nameText = v.findViewById(R.id.name_text_graphic);

        // Отображение нужной картины
        int periodState = MainActivity.periodCurrentStateGraphic;
        int indexState = MainActivity.indexCurrentStateGraphic;

        // Сохранение состояния периода по направлению
        if (periodState == 0 & indexState == -1) {
            indexState = BizLogic.incrementCheck(periodState, indexState, pics);
            MainActivity.indexAllPeriodGraphic++;
        }

        image.setImageResource(pics[BizLogic.positionAtArray(periodState, indexState, pics)].getImageResourceId());
        nameText.setText(pics[BizLogic.positionAtArray(periodState, indexState, pics)].getName());


        indexToPicDetail = BizLogic.positionAtArray(periodState, indexState, pics);
        artWayIndex = "pics";

        dataForCounterPeriodState = periodState;
        dataForCounterIndexState = indexState;

        // Переход на карточку картины
        image.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                imgListener.imgClick();
            }
        });

        return v;
    }

}
