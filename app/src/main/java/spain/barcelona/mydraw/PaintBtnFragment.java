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

import static spain.barcelona.mydraw.MainActivity.periodCurrentStatePaint;
import static spain.barcelona.mydraw.MainActivity.indexCurrentStatePaint;
import static spain.barcelona.mydraw.MainActivity.indexAllPeriodPaint;
import static spain.barcelona.mydraw.MainActivity.indexFirstPeriodPaint;
import static spain.barcelona.mydraw.MainActivity.indexSecondPeriodPaint;
import static spain.barcelona.mydraw.MainActivity.indexThirdPeriodPaint;
import static spain.barcelona.mydraw.MainActivity.indexFoursPeriodPaint;

import static spain.barcelona.mydraw.BizLogic.*;
import static spain.barcelona.mydraw.PaintImgFragment.indexToPicDetail;
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

        String[] years = new String[]{
                "1974-2011",
                "1974-1979",
                "1980-1989",
                "1990-1999",
                "2000-2011",
        };

        Spinner spinner = v.findViewById(R.id.spinner_paint);

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<>(
                getActivity(), R.layout.spinner_item, years
        );
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        spinner.setAdapter(spinnerArrayAdapter);

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
                if (periodCurrentStatePaint != allPeriod) {
                    --indexAllPeriodPaint;
                }
                indexAllPeriodPaint = BizLogic.incrementCheck(allPeriod, indexAllPeriodPaint, paint);
                image.setImageResource(paint[BizLogic.positionAtArray(allPeriod, indexAllPeriodPaint, paint)].getImageResourceId());
                if (paint[BizLogic.positionAtArray(allPeriod, indexAllPeriodPaint, paint)].getName().equals("")) {
                    nameText.setVisibility(View.INVISIBLE);
                } else {
                    nameText.setVisibility(View.VISIBLE);
                    nameText.setText(paint[BizLogic.positionAtArray(allPeriod, indexAllPeriodPaint, paint)].getName());
                }
                picCounter.setText(BizLogic.dataForCounter(allPeriod, indexAllPeriodPaint, paint));
                periodCurrentStatePaint = allPeriod;
                indexCurrentStatePaint = indexAllPeriodPaint;
                indexToPicDetail = BizLogic.positionAtArray(allPeriod, indexAllPeriodPaint, paint);
                break;
            case "1974-1979":
                if ((periodCurrentStatePaint != firstPeriod) & (indexFirstPeriodPaint >= 0)) {
                    --indexFirstPeriodPaint;
                }
                indexFirstPeriodPaint = BizLogic.incrementCheck(firstPeriod, indexFirstPeriodPaint, paint);
                image.setImageResource(paint[BizLogic.positionAtArray(firstPeriod, indexFirstPeriodPaint, paint)].getImageResourceId());
                if (paint[BizLogic.positionAtArray(firstPeriod, indexFirstPeriodPaint, paint)].getName().equals("")) {
                    nameText.setVisibility(View.INVISIBLE);
                } else {
                    nameText.setVisibility(View.VISIBLE);
                    nameText.setText(paint[BizLogic.positionAtArray(firstPeriod, indexFirstPeriodPaint, paint)].getName());
                }
                picCounter.setText(BizLogic.dataForCounter(firstPeriod, indexFirstPeriodPaint, paint));
                periodCurrentStatePaint = firstPeriod;
                indexCurrentStatePaint = indexFirstPeriodPaint;
                indexToPicDetail = BizLogic.positionAtArray(firstPeriod, indexFirstPeriodPaint, paint);
                break;
            case "1980-1989":
                if ((periodCurrentStatePaint != secondPeriod) & (indexSecondPeriodPaint >= 0)) {
                    --indexSecondPeriodPaint;
                }
                indexSecondPeriodPaint = BizLogic.incrementCheck(secondPeriod, indexSecondPeriodPaint, paint);
                image.setImageResource(paint[BizLogic.positionAtArray(secondPeriod, indexSecondPeriodPaint, paint)].getImageResourceId());
                if (paint[BizLogic.positionAtArray(secondPeriod, indexSecondPeriodPaint, paint)].getName().equals("")) {
                    nameText.setVisibility(View.INVISIBLE);
                } else {
                    nameText.setVisibility(View.VISIBLE);
                    nameText.setText(paint[BizLogic.positionAtArray(secondPeriod, indexSecondPeriodPaint, paint)].getName());
                }
                picCounter.setText(BizLogic.dataForCounter(secondPeriod, indexSecondPeriodPaint, paint));
                periodCurrentStatePaint = secondPeriod;
                indexCurrentStatePaint = indexSecondPeriodPaint;
                indexToPicDetail = BizLogic.positionAtArray(secondPeriod, indexSecondPeriodPaint, paint);
                break;
            case "1990-1999":
                if ((periodCurrentStatePaint != thirdPeriod) & (indexThirdPeriodPaint >= 0)) {
                    --indexThirdPeriodPaint;
                }
                indexThirdPeriodPaint = BizLogic.incrementCheck(thirdPeriod, indexThirdPeriodPaint, paint);
                image.setImageResource(paint[BizLogic.positionAtArray(thirdPeriod, indexThirdPeriodPaint, paint)].getImageResourceId());
                if (paint[BizLogic.positionAtArray(thirdPeriod, indexThirdPeriodPaint, paint)].getName().equals("")) {
                    nameText.setVisibility(View.INVISIBLE);
                } else {
                    nameText.setVisibility(View.VISIBLE);
                    nameText.setText(paint[BizLogic.positionAtArray(thirdPeriod, indexThirdPeriodPaint, paint)].getName());
                }
                picCounter.setText(BizLogic.dataForCounter(thirdPeriod, indexThirdPeriodPaint, paint));
                periodCurrentStatePaint = thirdPeriod;
                indexCurrentStatePaint = indexThirdPeriodPaint;
                indexToPicDetail = BizLogic.positionAtArray(thirdPeriod, indexThirdPeriodPaint, paint);
                break;
            case "2000-2011":
                if ((periodCurrentStatePaint != foursPeriod) & (indexFoursPeriodPaint >= 0)) {
                    --indexFoursPeriodPaint;
                }
                indexFoursPeriodPaint = BizLogic.incrementCheck(foursPeriod, indexFoursPeriodPaint, paint);
                image.setImageResource(paint[BizLogic.positionAtArray(foursPeriod, indexFoursPeriodPaint, paint)].getImageResourceId());
                if (paint[BizLogic.positionAtArray(foursPeriod, indexFoursPeriodPaint, paint)].getName().equals("")) {
                    nameText.setVisibility(View.INVISIBLE);
                } else {
                    nameText.setVisibility(View.VISIBLE);
                    nameText.setText(paint[BizLogic.positionAtArray(foursPeriod, indexFoursPeriodPaint, paint)].getName());
                }
                picCounter.setText(BizLogic.dataForCounter(foursPeriod, indexFoursPeriodPaint, paint));
                periodCurrentStatePaint = foursPeriod;
                indexCurrentStatePaint = indexFoursPeriodPaint;
                indexToPicDetail = BizLogic.positionAtArray(foursPeriod, indexFoursPeriodPaint, paint);
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
                if (periodCurrentStatePaint != allPeriod) {
                    ++indexAllPeriodPaint;
                }
                indexAllPeriodPaint = BizLogic.decrementCheck(allPeriod, indexAllPeriodPaint, paint);
                image.setImageResource(paint[BizLogic.positionAtArray(allPeriod, indexAllPeriodPaint, paint)].getImageResourceId());
                if (paint[BizLogic.positionAtArray(allPeriod, indexAllPeriodPaint, paint)].getName().equals("")) {
                    nameText.setVisibility(View.INVISIBLE);
                } else {
                    nameText.setVisibility(View.VISIBLE);
                    nameText.setText(paint[BizLogic.positionAtArray(allPeriod, indexAllPeriodPaint, paint)].getName());
                }
                picCounter.setText(BizLogic.dataForCounter(allPeriod, indexAllPeriodPaint, paint));
                periodCurrentStatePaint = allPeriod;
                indexCurrentStatePaint = indexAllPeriodPaint;
                indexToPicDetail = BizLogic.positionAtArray(allPeriod, indexAllPeriodPaint, paint);
                break;
            case "1974-1979":
                if ((periodCurrentStatePaint != firstPeriod) & (indexFirstPeriodPaint >= 0)) {
                    ++indexFirstPeriodPaint;
                }
                indexFirstPeriodPaint = BizLogic.decrementCheck(firstPeriod, indexFirstPeriodPaint, paint);
                image.setImageResource(paint[BizLogic.positionAtArray(firstPeriod, indexFirstPeriodPaint, paint)].getImageResourceId());
                if (paint[BizLogic.positionAtArray(firstPeriod, indexFirstPeriodPaint, paint)].getName().equals("")) {
                    nameText.setVisibility(View.INVISIBLE);
                } else {
                    nameText.setVisibility(View.VISIBLE);
                    nameText.setText(paint[BizLogic.positionAtArray(firstPeriod, indexFirstPeriodPaint, paint)].getName());
                }
                picCounter.setText(BizLogic.dataForCounter(firstPeriod, indexFirstPeriodPaint, paint));
                periodCurrentStatePaint = firstPeriod;
                indexCurrentStatePaint = indexFirstPeriodPaint;
                indexToPicDetail = BizLogic.positionAtArray(firstPeriod, indexFirstPeriodPaint, paint);
                break;
            case "1980-1989":
                if ((periodCurrentStatePaint != secondPeriod) & (indexSecondPeriodPaint >= 0)) {
                    ++indexSecondPeriodPaint;
                }
                indexSecondPeriodPaint = BizLogic.decrementCheck(secondPeriod, indexSecondPeriodPaint, paint);
                image.setImageResource(paint[BizLogic.positionAtArray(secondPeriod, indexSecondPeriodPaint, paint)].getImageResourceId());
                if (paint[BizLogic.positionAtArray(secondPeriod, indexSecondPeriodPaint, paint)].getName().equals("")) {
                    nameText.setVisibility(View.INVISIBLE);
                } else {
                    nameText.setVisibility(View.VISIBLE);
                    nameText.setText(paint[BizLogic.positionAtArray(secondPeriod, indexSecondPeriodPaint, paint)].getName());
                }
                picCounter.setText(BizLogic.dataForCounter(secondPeriod, indexSecondPeriodPaint, paint));
                periodCurrentStatePaint = secondPeriod;
                indexCurrentStatePaint = indexSecondPeriodPaint;
                indexToPicDetail = BizLogic.positionAtArray(secondPeriod, indexSecondPeriodPaint, paint);
                break;
            case "1990-1999":
                if ((periodCurrentStatePaint != thirdPeriod) & (indexThirdPeriodPaint >= 0)) {
                    ++indexThirdPeriodPaint;
                }
                indexThirdPeriodPaint = BizLogic.decrementCheck(thirdPeriod, indexThirdPeriodPaint, paint);
                image.setImageResource(paint[BizLogic.positionAtArray(thirdPeriod, indexThirdPeriodPaint, paint)].getImageResourceId());
                if (paint[BizLogic.positionAtArray(thirdPeriod, indexThirdPeriodPaint, paint)].getName().equals("")) {
                    nameText.setVisibility(View.INVISIBLE);
                } else {
                    nameText.setVisibility(View.VISIBLE);
                    nameText.setText(paint[BizLogic.positionAtArray(thirdPeriod, indexThirdPeriodPaint, paint)].getName());
                }
                picCounter.setText(BizLogic.dataForCounter(thirdPeriod, indexThirdPeriodPaint, paint));
                periodCurrentStatePaint = thirdPeriod;
                indexCurrentStatePaint = indexThirdPeriodPaint;
                indexToPicDetail = BizLogic.positionAtArray(thirdPeriod, indexThirdPeriodPaint, paint);
                break;
            case "2000-2011":
                if ((periodCurrentStatePaint != foursPeriod) & (indexFoursPeriodPaint >= 0)) {
                    ++indexFoursPeriodPaint;
                }
                indexFoursPeriodPaint = BizLogic.decrementCheck(foursPeriod, indexFoursPeriodPaint, paint);
                image.setImageResource(paint[BizLogic.positionAtArray(foursPeriod, indexFoursPeriodPaint, paint)].getImageResourceId());
                if (paint[BizLogic.positionAtArray(foursPeriod, indexFoursPeriodPaint, paint)].getName().equals("")) {
                    nameText.setVisibility(View.INVISIBLE);
                } else {
                    nameText.setVisibility(View.VISIBLE);
                    nameText.setText(paint[BizLogic.positionAtArray(foursPeriod, indexFoursPeriodPaint, paint)].getName());
                }
                picCounter.setText(BizLogic.dataForCounter(foursPeriod, indexFoursPeriodPaint, paint));
                periodCurrentStatePaint = foursPeriod;
                indexCurrentStatePaint = indexFoursPeriodPaint;
                indexToPicDetail = BizLogic.positionAtArray(foursPeriod, indexFoursPeriodPaint, paint);
                break;
        }
    }
}
