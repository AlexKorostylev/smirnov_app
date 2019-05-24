package spain.barcelona.mydraw;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import static spain.barcelona.mydraw.BizLogic.*;
import static spain.barcelona.mydraw.Pic.paint;

public class PaintBtnFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_paint_btn, container, false);

        Button btnNext = v.findViewById(R.id.btn_next);
        btnNext.setOnClickListener(this);
        Button btnPrevious = v.findViewById(R.id.btn_previous);
        btnPrevious.setOnClickListener(this);

        TextView pictureCounter = v.findViewById(R.id.counter);
        pictureCounter.setText(BizLogic.dataForCounter(allPeriod, indexAllPeriod, paint));
        return v;
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_next:
                onClickNext();
                break;
            case R.id.btn_previous:
                onClickPrevious();
                break;
        }
    }

    public void onClickNext() {
        ImageView image = getActivity().findViewById(R.id.info_image_paint);
        TextView nameText = getActivity().findViewById(R.id.name_text_paint);

        TextView picCounter = getActivity().findViewById(R.id.counter);
        Spinner spinner = getActivity().findViewById(R.id.art_type_paint);

        String selectedPeriodFromSpinner = String.valueOf(spinner.getSelectedItem());
        switch (selectedPeriodFromSpinner) {
            case "1972-2012":
                indexAllPeriod = BizLogic.incrementCheck(allPeriod, indexAllPeriod, paint);
                image.setImageResource(paint[BizLogic.positionAtArray(allPeriod, indexAllPeriod, paint)].getImageResourceId());
                nameText.setText(paint[BizLogic.positionAtArray(allPeriod, indexAllPeriod, paint)].getName());
                picCounter.setText(BizLogic.dataForCounter(allPeriod, indexAllPeriod, paint));
                break;
            case "1972-1979":
                indexFirstPeriod = BizLogic.incrementCheck(firstPeriod, indexFirstPeriod, paint);
                image.setImageResource(paint[BizLogic.positionAtArray(firstPeriod, indexFirstPeriod, paint)].getImageResourceId());
                nameText.setText(paint[BizLogic.positionAtArray(firstPeriod, indexFirstPeriod, paint)].getName());
                picCounter.setText(BizLogic.dataForCounter(firstPeriod, indexFirstPeriod, paint));
                break;
            case "1980-1989":
                indexSecondPeriod = BizLogic.incrementCheck(secondPeriod, indexSecondPeriod, paint);
                image.setImageResource(paint[BizLogic.positionAtArray(secondPeriod, indexSecondPeriod, paint)].getImageResourceId());
                nameText.setText(paint[BizLogic.positionAtArray(secondPeriod, indexSecondPeriod, paint)].getName());
                picCounter.setText(BizLogic.dataForCounter(secondPeriod, indexSecondPeriod, paint));
                break;
            case "1990-1999":
                indexThirdPeriod = BizLogic.incrementCheck(thirdPeriod, indexThirdPeriod, paint);
                image.setImageResource(paint[BizLogic.positionAtArray(thirdPeriod, indexThirdPeriod, paint)].getImageResourceId());
                nameText.setText(paint[BizLogic.positionAtArray(thirdPeriod, indexThirdPeriod, paint)].getName());
                picCounter.setText(BizLogic.dataForCounter(thirdPeriod, indexThirdPeriod, paint));
                break;
            case "2000-2012":
                indexFoursPeriod = BizLogic.incrementCheck(foursPeriod, indexFoursPeriod, paint);
                image.setImageResource(paint[BizLogic.positionAtArray(foursPeriod, indexFoursPeriod, paint)].getImageResourceId());
                nameText.setText(paint[BizLogic.positionAtArray(foursPeriod, indexFoursPeriod, paint)].getName());
                picCounter.setText(BizLogic.dataForCounter(foursPeriod, indexFoursPeriod, paint));
                break;
        }
    }

    public void onClickPrevious() {
        ImageView image = getActivity().findViewById(R.id.info_image_paint);
        TextView nameText = getActivity().findViewById(R.id.name_text_paint);

        TextView picCounter = getActivity().findViewById(R.id.counter);
        Spinner spinner = getActivity().findViewById(R.id.art_type_paint);

        String selectedPeriod = String.valueOf(spinner.getSelectedItem());
        switch (selectedPeriod) {
            case "1972-2012":
                indexAllPeriod = BizLogic.decrementCheck(allPeriod, indexAllPeriod, paint);
                image.setImageResource(paint[BizLogic.positionAtArray(allPeriod, indexAllPeriod, paint)].getImageResourceId());
                nameText.setText(paint[BizLogic.positionAtArray(allPeriod, indexAllPeriod, paint)].getName());
                picCounter.setText(BizLogic.dataForCounter(allPeriod, indexAllPeriod, paint));
                break;
            case "1972-1979":
                indexFirstPeriod = BizLogic.decrementCheck(firstPeriod, indexFirstPeriod, paint);
                image.setImageResource(paint[BizLogic.positionAtArray(firstPeriod, indexFirstPeriod, paint)].getImageResourceId());
                nameText.setText(paint[BizLogic.positionAtArray(firstPeriod, indexFirstPeriod, paint)].getName());
                picCounter.setText(BizLogic.dataForCounter(firstPeriod, indexFirstPeriod, paint));
                break;
            case "1980-1989":
                indexSecondPeriod = BizLogic.decrementCheck(secondPeriod, indexSecondPeriod, paint);
                image.setImageResource(paint[BizLogic.positionAtArray(secondPeriod, indexSecondPeriod, paint)].getImageResourceId());
                nameText.setText(paint[BizLogic.positionAtArray(secondPeriod, indexSecondPeriod, paint)].getName());
                picCounter.setText(BizLogic.dataForCounter(secondPeriod, indexSecondPeriod, paint));
                break;
            case "1990-1999":
                indexThirdPeriod = BizLogic.decrementCheck(thirdPeriod, indexThirdPeriod, paint);
                image.setImageResource(paint[BizLogic.positionAtArray(thirdPeriod, indexThirdPeriod, paint)].getImageResourceId());
                nameText.setText(paint[BizLogic.positionAtArray(thirdPeriod, indexThirdPeriod, paint)].getName());
                picCounter.setText(BizLogic.dataForCounter(thirdPeriod, indexThirdPeriod, paint));
                break;
            case "2000-2012":
                indexFoursPeriod = BizLogic.decrementCheck(foursPeriod, indexFoursPeriod, paint);
                image.setImageResource(paint[BizLogic.positionAtArray(foursPeriod, indexFoursPeriod, paint)].getImageResourceId());
                nameText.setText(paint[BizLogic.positionAtArray(foursPeriod, indexFoursPeriod, paint)].getName());
                picCounter.setText(BizLogic.dataForCounter(foursPeriod, indexFoursPeriod, paint));
                break;
        }
    }
}
