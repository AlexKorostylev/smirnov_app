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

    // start index counter number for paints per period
    static int indexAllPeriod = -1;
    static int indexFirstPeriod = -1;
    static int indexSecondPeriod = -1;
    static int indexThirdPeriod = -1;
    static int indexFoursPeriod = -1;

    static int periodCurrentState = allPeriod;
    static int indexCurrentState = indexAllPeriod;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_paint_btn, container, false);

        Button btnNext = v.findViewById(R.id.btn_next);
        btnNext.setOnClickListener(this);
        Button btnPrevious = v.findViewById(R.id.btn_previous);
        btnPrevious.setOnClickListener(this);

        Spinner spinner = v.findViewById(R.id.spinner_paint);
        spinner.setSelection(PaintImgFragment.dataForCounterPeriodState);

        TextView pictureCounter = v.findViewById(R.id.counter_paint);
        pictureCounter.setText(BizLogic.dataForCounter(PaintImgFragment.dataForCounterPeriodState, PaintImgFragment.dataForCounterIndexState, paint));
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

        TextView picCounter = getActivity().findViewById(R.id.counter_paint);
        Spinner spinner = getActivity().findViewById(R.id.spinner_paint);

        String selectedPeriodFromSpinner = String.valueOf(spinner.getSelectedItem());
        switch (selectedPeriodFromSpinner) {
            case "1974-2011":
                indexAllPeriod = BizLogic.incrementCheck(allPeriod, indexAllPeriod, paint);
                image.setImageResource(paint[BizLogic.positionAtArray(allPeriod, indexAllPeriod, paint)].getImageResourceId());
                nameText.setText(paint[BizLogic.positionAtArray(allPeriod, indexAllPeriod, paint)].getName());
                picCounter.setText(BizLogic.dataForCounter(allPeriod, indexAllPeriod, paint));
                periodCurrentState = allPeriod;
                indexCurrentState = indexAllPeriod;
                break;
            case "1974-1979":
                indexFirstPeriod = BizLogic.incrementCheck(firstPeriod, indexFirstPeriod, paint);
                image.setImageResource(paint[BizLogic.positionAtArray(firstPeriod, indexFirstPeriod, paint)].getImageResourceId());
                nameText.setText(paint[BizLogic.positionAtArray(firstPeriod, indexFirstPeriod, paint)].getName());
                picCounter.setText(BizLogic.dataForCounter(firstPeriod, indexFirstPeriod, paint));
                periodCurrentState = firstPeriod;
                indexCurrentState = indexFirstPeriod;
                break;
            case "1980-1989":
                indexSecondPeriod = BizLogic.incrementCheck(secondPeriod, indexSecondPeriod, paint);
                image.setImageResource(paint[BizLogic.positionAtArray(secondPeriod, indexSecondPeriod, paint)].getImageResourceId());
                nameText.setText(paint[BizLogic.positionAtArray(secondPeriod, indexSecondPeriod, paint)].getName());
                picCounter.setText(BizLogic.dataForCounter(secondPeriod, indexSecondPeriod, paint));
                periodCurrentState = secondPeriod;
                indexCurrentState = indexSecondPeriod;
                break;
            case "1990-1999":
                indexThirdPeriod = BizLogic.incrementCheck(thirdPeriod, indexThirdPeriod, paint);
                image.setImageResource(paint[BizLogic.positionAtArray(thirdPeriod, indexThirdPeriod, paint)].getImageResourceId());
                nameText.setText(paint[BizLogic.positionAtArray(thirdPeriod, indexThirdPeriod, paint)].getName());
                picCounter.setText(BizLogic.dataForCounter(thirdPeriod, indexThirdPeriod, paint));
                periodCurrentState = thirdPeriod;
                indexCurrentState = indexThirdPeriod;
                break;
            case "2000-2011":
                indexFoursPeriod = BizLogic.incrementCheck(foursPeriod, indexFoursPeriod, paint);
                image.setImageResource(paint[BizLogic.positionAtArray(foursPeriod, indexFoursPeriod, paint)].getImageResourceId());
                nameText.setText(paint[BizLogic.positionAtArray(foursPeriod, indexFoursPeriod, paint)].getName());
                picCounter.setText(BizLogic.dataForCounter(foursPeriod, indexFoursPeriod, paint));
                periodCurrentState = foursPeriod;
                indexCurrentState = indexFoursPeriod;
                break;
        }
    }

    public void onClickPrevious() {
        ImageView image = getActivity().findViewById(R.id.info_image_paint);
        TextView nameText = getActivity().findViewById(R.id.name_text_paint);

        TextView picCounter = getActivity().findViewById(R.id.counter_paint);
        Spinner spinner = getActivity().findViewById(R.id.spinner_paint);

        String selectedPeriod = String.valueOf(spinner.getSelectedItem());
        switch (selectedPeriod) {
            case "1974-2011":
                indexAllPeriod = BizLogic.decrementCheck(allPeriod, indexAllPeriod, paint);
                image.setImageResource(paint[BizLogic.positionAtArray(allPeriod, indexAllPeriod, paint)].getImageResourceId());
                nameText.setText(paint[BizLogic.positionAtArray(allPeriod, indexAllPeriod, paint)].getName());
                picCounter.setText(BizLogic.dataForCounter(allPeriod, indexAllPeriod, paint));
                periodCurrentState = allPeriod;
                indexCurrentState = indexAllPeriod;
                break;
            case "1974-1979":
                indexFirstPeriod = BizLogic.decrementCheck(firstPeriod, indexFirstPeriod, paint);
                image.setImageResource(paint[BizLogic.positionAtArray(firstPeriod, indexFirstPeriod, paint)].getImageResourceId());
                nameText.setText(paint[BizLogic.positionAtArray(firstPeriod, indexFirstPeriod, paint)].getName());
                picCounter.setText(BizLogic.dataForCounter(firstPeriod, indexFirstPeriod, paint));
                periodCurrentState = firstPeriod;
                indexCurrentState = indexFirstPeriod;
                break;
            case "1980-1989":
                indexSecondPeriod = BizLogic.decrementCheck(secondPeriod, indexSecondPeriod, paint);
                image.setImageResource(paint[BizLogic.positionAtArray(secondPeriod, indexSecondPeriod, paint)].getImageResourceId());
                nameText.setText(paint[BizLogic.positionAtArray(secondPeriod, indexSecondPeriod, paint)].getName());
                picCounter.setText(BizLogic.dataForCounter(secondPeriod, indexSecondPeriod, paint));
                periodCurrentState = secondPeriod;
                indexCurrentState = indexSecondPeriod;
                break;
            case "1990-1999":
                indexThirdPeriod = BizLogic.decrementCheck(thirdPeriod, indexThirdPeriod, paint);
                image.setImageResource(paint[BizLogic.positionAtArray(thirdPeriod, indexThirdPeriod, paint)].getImageResourceId());
                nameText.setText(paint[BizLogic.positionAtArray(thirdPeriod, indexThirdPeriod, paint)].getName());
                picCounter.setText(BizLogic.dataForCounter(thirdPeriod, indexThirdPeriod, paint));
                periodCurrentState = thirdPeriod;
                indexCurrentState = indexThirdPeriod;
                break;
            case "2000-2011":
                indexFoursPeriod = BizLogic.decrementCheck(foursPeriod, indexFoursPeriod, paint);
                image.setImageResource(paint[BizLogic.positionAtArray(foursPeriod, indexFoursPeriod, paint)].getImageResourceId());
                nameText.setText(paint[BizLogic.positionAtArray(foursPeriod, indexFoursPeriod, paint)].getName());
                picCounter.setText(BizLogic.dataForCounter(foursPeriod, indexFoursPeriod, paint));
                periodCurrentState = foursPeriod;
                indexCurrentState = indexFoursPeriod;
                break;
        }
    }
}
