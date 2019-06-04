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
import static spain.barcelona.mydraw.Pic.pics;


public class GraphicBtnFragment extends Fragment implements View.OnClickListener {

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
        View v = inflater.inflate(R.layout.fragment_graphic_btn, container, false);

        Button btnNext = v.findViewById(R.id.btn_next);
        btnNext.setOnClickListener(this);
        Button btnPrevious = v.findViewById(R.id.btn_previous);
        btnPrevious.setOnClickListener(this);

        Spinner spinner = v.findViewById(R.id.spinner_pics);
        spinner.setSelection(GraphicImgFragment.dataForCounterPeriodState);

        TextView pictureCounter = v.findViewById(R.id.counter_graphic);
        pictureCounter.setText(BizLogic.dataForCounter(GraphicImgFragment.dataForCounterPeriodState, GraphicImgFragment.dataForCounterIndexState, pics));
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
        ImageView image = getActivity().findViewById(R.id.info_image_graphic);
        TextView nameText = getActivity().findViewById(R.id.name_text_graphic);

        TextView picCounter = getActivity().findViewById(R.id.counter_graphic);
        Spinner spinner = getActivity().findViewById(R.id.spinner_pics);

        String selectedPeriodFromSpinner = String.valueOf(spinner.getSelectedItem());
        switch (selectedPeriodFromSpinner) {
            case "1972-2012":
                if(periodCurrentState != allPeriod ){
                    --indexAllPeriod;
                }
                indexAllPeriod = BizLogic.incrementCheck(allPeriod, indexAllPeriod, pics);
                image.setImageResource(pics[BizLogic.positionAtArray(allPeriod, indexAllPeriod, pics)].getImageResourceId());
                nameText.setText(pics[BizLogic.positionAtArray(allPeriod, indexAllPeriod, pics)].getName());
                picCounter.setText(BizLogic.dataForCounter(allPeriod, indexAllPeriod, pics));
                periodCurrentState = allPeriod;
                indexCurrentState = indexAllPeriod;
                break;
            case "1972-1979":
                if((periodCurrentState != firstPeriod) & (indexFirstPeriod >= 0)){
                    --indexFirstPeriod;
                }
                indexFirstPeriod = BizLogic.incrementCheck(firstPeriod, indexFirstPeriod, pics);
                image.setImageResource(pics[BizLogic.positionAtArray(firstPeriod, indexFirstPeriod, pics)].getImageResourceId());
                nameText.setText(pics[BizLogic.positionAtArray(firstPeriod, indexFirstPeriod, pics)].getName());
                picCounter.setText(BizLogic.dataForCounter(firstPeriod, indexFirstPeriod, pics));
                periodCurrentState = firstPeriod;
                indexCurrentState = indexFirstPeriod;
                break;
            case "1980-1989":
                if((periodCurrentState != secondPeriod) & (indexSecondPeriod >= 0)){
                    --indexSecondPeriod;
                }
                indexSecondPeriod = BizLogic.incrementCheck(secondPeriod, indexSecondPeriod, pics);
                image.setImageResource(pics[BizLogic.positionAtArray(secondPeriod, indexSecondPeriod, pics)].getImageResourceId());
                nameText.setText(pics[BizLogic.positionAtArray(secondPeriod, indexSecondPeriod, pics)].getName());
                picCounter.setText(BizLogic.dataForCounter(secondPeriod, indexSecondPeriod, pics));
                periodCurrentState = secondPeriod;
                indexCurrentState = indexSecondPeriod;
                break;
            case "1990-1999":
                if((periodCurrentState != thirdPeriod) & (indexThirdPeriod >= 0)){
                    --indexThirdPeriod;
                }
                indexThirdPeriod = BizLogic.incrementCheck(thirdPeriod, indexThirdPeriod, pics);
                image.setImageResource(pics[BizLogic.positionAtArray(thirdPeriod, indexThirdPeriod, pics)].getImageResourceId());
                nameText.setText(pics[BizLogic.positionAtArray(thirdPeriod, indexThirdPeriod, pics)].getName());
                picCounter.setText(BizLogic.dataForCounter(thirdPeriod, indexThirdPeriod, pics));
                periodCurrentState = thirdPeriod;
                indexCurrentState = indexThirdPeriod;
                break;
            case "2000-2012":
                if((periodCurrentState != foursPeriod) & (indexFoursPeriod >= 0)){
                    --indexFoursPeriod;
                }
                indexFoursPeriod = BizLogic.incrementCheck(foursPeriod, indexFoursPeriod, pics);
                image.setImageResource(pics[BizLogic.positionAtArray(foursPeriod, indexFoursPeriod, pics)].getImageResourceId());
                nameText.setText(pics[BizLogic.positionAtArray(foursPeriod, indexFoursPeriod, pics)].getName());
                picCounter.setText(BizLogic.dataForCounter(foursPeriod, indexFoursPeriod, pics));
                periodCurrentState = foursPeriod;
                indexCurrentState = indexFoursPeriod;
                break;
        }
    }

    public void onClickPrevious() {
        ImageView image = getActivity().findViewById(R.id.info_image_graphic);
        TextView nameText = getActivity().findViewById(R.id.name_text_graphic);

        TextView picCounter = getActivity().findViewById(R.id.counter_graphic);
        Spinner spinner = getActivity().findViewById(R.id.spinner_pics);

        String selectedPeriod = String.valueOf(spinner.getSelectedItem());
        switch (selectedPeriod) {
            case "1972-2012":
                if(periodCurrentState != allPeriod ){
                    ++indexAllPeriod;
                }
                indexAllPeriod = BizLogic.decrementCheck(allPeriod, indexAllPeriod, pics);
                image.setImageResource(pics[BizLogic.positionAtArray(allPeriod, indexAllPeriod, pics)].getImageResourceId());
                nameText.setText(pics[BizLogic.positionAtArray(allPeriod, indexAllPeriod, pics)].getName());
                picCounter.setText(BizLogic.dataForCounter(allPeriod, indexAllPeriod, pics));
                periodCurrentState = allPeriod;
                indexCurrentState = indexAllPeriod;
                break;
            case "1972-1979":
                if((periodCurrentState != firstPeriod) & (indexFirstPeriod>=0)){
                    ++indexFirstPeriod;
                }
                indexFirstPeriod = BizLogic.decrementCheck(firstPeriod, indexFirstPeriod, pics);
                image.setImageResource(pics[BizLogic.positionAtArray(firstPeriod, indexFirstPeriod, pics)].getImageResourceId());
                nameText.setText(pics[BizLogic.positionAtArray(firstPeriod, indexFirstPeriod, pics)].getName());
                picCounter.setText(BizLogic.dataForCounter(firstPeriod, indexFirstPeriod, pics));
                periodCurrentState = firstPeriod;
                indexCurrentState = indexFirstPeriod;
                break;
            case "1980-1989":
                if((periodCurrentState != secondPeriod) & (indexSecondPeriod >= 0)){
                    ++indexSecondPeriod;
                }
                indexSecondPeriod = BizLogic.decrementCheck(secondPeriod, indexSecondPeriod, pics);
                image.setImageResource(pics[BizLogic.positionAtArray(secondPeriod, indexSecondPeriod, pics)].getImageResourceId());
                nameText.setText(pics[BizLogic.positionAtArray(secondPeriod, indexSecondPeriod, pics)].getName());
                picCounter.setText(BizLogic.dataForCounter(secondPeriod, indexSecondPeriod, pics));
                periodCurrentState = secondPeriod;
                indexCurrentState = indexSecondPeriod;
                break;
            case "1990-1999":
                if((periodCurrentState != thirdPeriod) & (indexThirdPeriod >= 0)){
                    ++indexThirdPeriod;
                }
                indexThirdPeriod = BizLogic.decrementCheck(thirdPeriod, indexThirdPeriod, pics);
                image.setImageResource(pics[BizLogic.positionAtArray(thirdPeriod, indexThirdPeriod, pics)].getImageResourceId());
                nameText.setText(pics[BizLogic.positionAtArray(thirdPeriod, indexThirdPeriod, pics)].getName());
                picCounter.setText(BizLogic.dataForCounter(thirdPeriod, indexThirdPeriod, pics));
                periodCurrentState = thirdPeriod;
                indexCurrentState = indexThirdPeriod;
                break;
            case "2000-2012":
                if((periodCurrentState != foursPeriod) & (indexFoursPeriod >= 0)){
                    ++indexFoursPeriod;
                }
                indexFoursPeriod = BizLogic.decrementCheck(foursPeriod, indexFoursPeriod, pics);
                image.setImageResource(pics[BizLogic.positionAtArray(foursPeriod, indexFoursPeriod, pics)].getImageResourceId());
                nameText.setText(pics[BizLogic.positionAtArray(foursPeriod, indexFoursPeriod, pics)].getName());
                picCounter.setText(BizLogic.dataForCounter(foursPeriod, indexFoursPeriod, pics));
                periodCurrentState = foursPeriod;
                indexCurrentState = indexFoursPeriod;
                break;
        }
    }
}
