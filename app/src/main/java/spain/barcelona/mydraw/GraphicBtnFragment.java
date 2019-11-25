package spain.barcelona.mydraw;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import static spain.barcelona.mydraw.MainActivity.periodCurrentStateGraphic;
import static spain.barcelona.mydraw.MainActivity.indexCurrentStateGraphic;
import static spain.barcelona.mydraw.MainActivity.indexAllPeriodGraphic;
import static spain.barcelona.mydraw.MainActivity.indexFirstPeriodGraphic;
import static spain.barcelona.mydraw.MainActivity.indexSecondPeriodGraphic;
import static spain.barcelona.mydraw.MainActivity.indexThirdPeriodGraphic;
import static spain.barcelona.mydraw.MainActivity.indexFoursPeriodGraphic;

import static spain.barcelona.mydraw.BizLogic.*;
import static spain.barcelona.mydraw.GraphicImgFragment.indexToPicDetail;
import static spain.barcelona.mydraw.Pic.pics;


public class GraphicBtnFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_graphic_btn, container, false);

        Button btnNext = v.findViewById(R.id.btn_next);
        btnNext.setOnClickListener(this);
        Button btnPrevious = v.findViewById(R.id.btn_previous);
        btnPrevious.setOnClickListener(this);

        String[] years = new String[]{
                "1972-2012",
                "1972-1979",
                "1980-1989",
                "1990-1999",
                "2000-2012",
        };

        Spinner spinner = v.findViewById(R.id.spinner_pics);

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<>(
                getActivity(), R.layout.spinner_item, years
        );
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        spinner.setAdapter(spinnerArrayAdapter);

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
                if(periodCurrentStateGraphic != allPeriod ){
                    --indexAllPeriodGraphic;
                }
                indexAllPeriodGraphic = BizLogic.incrementCheck(allPeriod, indexAllPeriodGraphic, pics);
                image.setImageResource(pics[BizLogic.positionAtArray(allPeriod, indexAllPeriodGraphic, pics)].getImageResourceId());
                if (pics[BizLogic.positionAtArray(allPeriod, indexAllPeriodGraphic, pics)].getName().equals("")) {
                    nameText.setVisibility(View.INVISIBLE);
                } else {
                    nameText.setVisibility(View.VISIBLE);
                    nameText.setText(pics[BizLogic.positionAtArray(allPeriod, indexAllPeriodGraphic, pics)].getName());
                }
                picCounter.setText(BizLogic.dataForCounter(allPeriod, indexAllPeriodGraphic, pics));
                periodCurrentStateGraphic = allPeriod;
                indexCurrentStateGraphic = indexAllPeriodGraphic;
                indexToPicDetail = BizLogic.positionAtArray(allPeriod, indexAllPeriodGraphic, pics);
                break;
            case "1972-1979":
                if((periodCurrentStateGraphic != firstPeriod) & (indexFirstPeriodGraphic >= 0)){
                    --indexFirstPeriodGraphic;
                }
                indexFirstPeriodGraphic = BizLogic.incrementCheck(firstPeriod, indexFirstPeriodGraphic, pics);
                image.setImageResource(pics[BizLogic.positionAtArray(firstPeriod, indexFirstPeriodGraphic, pics)].getImageResourceId());
                if (pics[BizLogic.positionAtArray(firstPeriod, indexFirstPeriodGraphic, pics)].getName().equals("")) {
                    nameText.setVisibility(View.INVISIBLE);
                } else {
                    nameText.setVisibility(View.VISIBLE);
                    nameText.setText(pics[BizLogic.positionAtArray(firstPeriod, indexFirstPeriodGraphic, pics)].getName());
                }
                picCounter.setText(BizLogic.dataForCounter(firstPeriod, indexFirstPeriodGraphic, pics));
                periodCurrentStateGraphic = firstPeriod;
                indexCurrentStateGraphic = indexFirstPeriodGraphic;
                indexToPicDetail = BizLogic.positionAtArray(allPeriod, indexAllPeriodGraphic, pics);
                break;
            case "1980-1989":
                if((periodCurrentStateGraphic != secondPeriod) & (indexSecondPeriodGraphic >= 0)){
                    --indexSecondPeriodGraphic;
                }
                indexSecondPeriodGraphic = BizLogic.incrementCheck(secondPeriod, indexSecondPeriodGraphic, pics);
                image.setImageResource(pics[BizLogic.positionAtArray(secondPeriod, indexSecondPeriodGraphic, pics)].getImageResourceId());
                if (pics[BizLogic.positionAtArray(secondPeriod, indexSecondPeriodGraphic, pics)].getName().equals("")) {
                    nameText.setVisibility(View.INVISIBLE);
                } else {
                    nameText.setVisibility(View.VISIBLE);
                    nameText.setText(pics[BizLogic.positionAtArray(secondPeriod, indexSecondPeriodGraphic, pics)].getName());
                }
                picCounter.setText(BizLogic.dataForCounter(secondPeriod, indexSecondPeriodGraphic, pics));
                periodCurrentStateGraphic = secondPeriod;
                indexCurrentStateGraphic = indexSecondPeriodGraphic;
                indexToPicDetail = BizLogic.positionAtArray(secondPeriod, indexSecondPeriodGraphic, pics);
                break;
            case "1990-1999":
                if((periodCurrentStateGraphic != thirdPeriod) & (indexThirdPeriodGraphic >= 0)){
                    --indexThirdPeriodGraphic;
                }
                indexThirdPeriodGraphic = BizLogic.incrementCheck(thirdPeriod, indexThirdPeriodGraphic, pics);
                image.setImageResource(pics[BizLogic.positionAtArray(thirdPeriod, indexThirdPeriodGraphic, pics)].getImageResourceId());
                if (pics[BizLogic.positionAtArray(thirdPeriod, indexThirdPeriodGraphic, pics)].getName().equals("")) {
                    nameText.setVisibility(View.INVISIBLE);
                } else {
                    nameText.setVisibility(View.VISIBLE);
                    nameText.setText(pics[BizLogic.positionAtArray(thirdPeriod, indexThirdPeriodGraphic, pics)].getName());
                }
                picCounter.setText(BizLogic.dataForCounter(thirdPeriod, indexThirdPeriodGraphic, pics));
                periodCurrentStateGraphic = thirdPeriod;
                indexCurrentStateGraphic = indexThirdPeriodGraphic;
                indexToPicDetail = BizLogic.positionAtArray(thirdPeriod, indexThirdPeriodGraphic, pics);
                break;
            case "2000-2012":
                if((periodCurrentStateGraphic != foursPeriod) & (indexFoursPeriodGraphic >= 0)){
                    --indexFoursPeriodGraphic;
                }
                indexFoursPeriodGraphic = BizLogic.incrementCheck(foursPeriod, indexFoursPeriodGraphic, pics);
                image.setImageResource(pics[BizLogic.positionAtArray(foursPeriod, indexFoursPeriodGraphic, pics)].getImageResourceId());
                if (pics[BizLogic.positionAtArray(foursPeriod, indexFoursPeriodGraphic, pics)].getName().equals("")) {
                    nameText.setVisibility(View.INVISIBLE);
                } else {
                    nameText.setVisibility(View.VISIBLE);
                    nameText.setText(pics[BizLogic.positionAtArray(foursPeriod, indexFoursPeriodGraphic, pics)].getName());
                }
                picCounter.setText(BizLogic.dataForCounter(foursPeriod, indexFoursPeriodGraphic, pics));
                periodCurrentStateGraphic = foursPeriod;
                indexCurrentStateGraphic = indexFoursPeriodGraphic;
                indexToPicDetail = BizLogic.positionAtArray(foursPeriod, indexFoursPeriodGraphic, pics);
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
                if(periodCurrentStateGraphic != allPeriod ){
                    ++indexAllPeriodGraphic;
                }
                indexAllPeriodGraphic = BizLogic.decrementCheck(allPeriod, indexAllPeriodGraphic, pics);
                image.setImageResource(pics[BizLogic.positionAtArray(allPeriod, indexAllPeriodGraphic, pics)].getImageResourceId());
                if (pics[BizLogic.positionAtArray(allPeriod, indexAllPeriodGraphic, pics)].getName().equals("")) {
                    nameText.setVisibility(View.INVISIBLE);
                } else {
                    nameText.setVisibility(View.VISIBLE);
                    nameText.setText(pics[BizLogic.positionAtArray(allPeriod, indexAllPeriodGraphic, pics)].getName());
                }
                picCounter.setText(BizLogic.dataForCounter(allPeriod, indexAllPeriodGraphic, pics));
                periodCurrentStateGraphic = allPeriod;
                indexCurrentStateGraphic = indexAllPeriodGraphic;
                indexToPicDetail = BizLogic.positionAtArray(allPeriod, indexAllPeriodGraphic, pics);
                break;
            case "1972-1979":
                if((periodCurrentStateGraphic != firstPeriod) & (indexFirstPeriodGraphic >=0)){
                    ++indexFirstPeriodGraphic;
                }
                indexFirstPeriodGraphic = BizLogic.decrementCheck(firstPeriod, indexFirstPeriodGraphic, pics);
                image.setImageResource(pics[BizLogic.positionAtArray(firstPeriod, indexFirstPeriodGraphic, pics)].getImageResourceId());
                if (pics[BizLogic.positionAtArray(firstPeriod, indexFirstPeriodGraphic, pics)].getName().equals("")) {
                    nameText.setVisibility(View.INVISIBLE);
                } else {
                    nameText.setVisibility(View.VISIBLE);
                    nameText.setText(pics[BizLogic.positionAtArray(firstPeriod, indexFirstPeriodGraphic, pics)].getName());
                }
                picCounter.setText(BizLogic.dataForCounter(firstPeriod, indexFirstPeriodGraphic, pics));
                periodCurrentStateGraphic = firstPeriod;
                indexCurrentStateGraphic = indexFirstPeriodGraphic;
                indexToPicDetail = BizLogic.positionAtArray(firstPeriod, indexFirstPeriodGraphic, pics);
                break;
            case "1980-1989":
                if((periodCurrentStateGraphic != secondPeriod) & (indexSecondPeriodGraphic >= 0)){
                    ++indexSecondPeriodGraphic;
                }
                indexSecondPeriodGraphic = BizLogic.decrementCheck(secondPeriod, indexSecondPeriodGraphic, pics);
                image.setImageResource(pics[BizLogic.positionAtArray(secondPeriod, indexSecondPeriodGraphic, pics)].getImageResourceId());
                if (pics[BizLogic.positionAtArray(secondPeriod, indexSecondPeriodGraphic, pics)].getName().equals("")) {
                    nameText.setVisibility(View.INVISIBLE);
                } else {
                    nameText.setVisibility(View.VISIBLE);
                    nameText.setText(pics[BizLogic.positionAtArray(secondPeriod, indexSecondPeriodGraphic, pics)].getName());
                }
                picCounter.setText(BizLogic.dataForCounter(secondPeriod, indexSecondPeriodGraphic, pics));
                periodCurrentStateGraphic = secondPeriod;
                indexCurrentStateGraphic = indexSecondPeriodGraphic;
                indexToPicDetail = BizLogic.positionAtArray(secondPeriod, indexSecondPeriodGraphic, pics);
                break;
            case "1990-1999":
                if((periodCurrentStateGraphic != thirdPeriod) & (indexThirdPeriodGraphic >= 0)){
                    ++indexThirdPeriodGraphic;
                }
                indexThirdPeriodGraphic = BizLogic.decrementCheck(thirdPeriod, indexThirdPeriodGraphic, pics);
                image.setImageResource(pics[BizLogic.positionAtArray(thirdPeriod, indexThirdPeriodGraphic, pics)].getImageResourceId());
                if (pics[BizLogic.positionAtArray(thirdPeriod, indexThirdPeriodGraphic, pics)].getName().equals("")) {
                    nameText.setVisibility(View.INVISIBLE);
                } else {
                    nameText.setVisibility(View.VISIBLE);
                    nameText.setText(pics[BizLogic.positionAtArray(thirdPeriod, indexThirdPeriodGraphic, pics)].getName());
                }
                picCounter.setText(BizLogic.dataForCounter(thirdPeriod, indexThirdPeriodGraphic, pics));
                periodCurrentStateGraphic = thirdPeriod;
                indexCurrentStateGraphic = indexThirdPeriodGraphic;
                indexToPicDetail = BizLogic.positionAtArray(thirdPeriod, indexThirdPeriodGraphic, pics);
                break;
            case "2000-2012":
                if((periodCurrentStateGraphic != foursPeriod) & (indexFoursPeriodGraphic >= 0)){
                    ++indexFoursPeriodGraphic;
                }
                indexFoursPeriodGraphic = BizLogic.decrementCheck(foursPeriod, indexFoursPeriodGraphic, pics);
                image.setImageResource(pics[BizLogic.positionAtArray(foursPeriod, indexFoursPeriodGraphic, pics)].getImageResourceId());
                if (pics[BizLogic.positionAtArray(foursPeriod, indexFoursPeriodGraphic, pics)].getName().equals("")) {
                    nameText.setVisibility(View.INVISIBLE);
                } else {
                    nameText.setVisibility(View.VISIBLE);
                    nameText.setText(pics[BizLogic.positionAtArray(foursPeriod, indexFoursPeriodGraphic, pics)].getName());
                }
                picCounter.setText(BizLogic.dataForCounter(foursPeriod, indexFoursPeriodGraphic, pics));
                periodCurrentStateGraphic = foursPeriod;
                indexCurrentStateGraphic = indexFoursPeriodGraphic;
                indexToPicDetail = BizLogic.positionAtArray(foursPeriod, indexFoursPeriodGraphic, pics);
                break;
        }
    }
}
