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
import static spain.barcelona.mydraw.Pic.photo;

public class PhotoBtnFragment extends Fragment implements View.OnClickListener {

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

        View v = inflater.inflate(R.layout.fragment_photo_btn, container, false);

        Button btnNext = v.findViewById(R.id.btn_next);
        btnNext.setOnClickListener(this);
        Button btnPrevious = v.findViewById(R.id.btn_previous);
        btnPrevious.setOnClickListener(this);

        Spinner spinner = v.findViewById(R.id.spinner_photo);
        spinner.setSelection(PhotoImgFragment.dataForCounterPeriodState);

        TextView pictureCounter = v.findViewById(R.id.counter_photo);
        pictureCounter.setText(BizLogic.dataForCounter(PhotoImgFragment.dataForCounterPeriodState, PhotoImgFragment.dataForCounterIndexState, photo));

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
        ImageView image = getActivity().findViewById(R.id.info_image_photo);
        TextView nameText = getActivity().findViewById(R.id.name_text_photo);

        TextView picCounter = getActivity().findViewById(R.id.counter_photo);
        Spinner spinner = getActivity().findViewById(R.id.spinner_photo);

        String selectedPeriodFromSpinner = String.valueOf(spinner.getSelectedItem());
        switch (selectedPeriodFromSpinner) {
            case "1970-2011":
                indexAllPeriod = BizLogic.incrementCheck(allPeriod, indexAllPeriod, photo);
                image.setImageResource(photo[BizLogic.positionAtArray(allPeriod, indexAllPeriod, photo)].getImageResourceId());
                nameText.setText(photo[BizLogic.positionAtArray(allPeriod, indexAllPeriod, photo)].getName());
                picCounter.setText(BizLogic.dataForCounter(allPeriod, indexAllPeriod, photo));
                periodCurrentState = allPeriod;
                indexCurrentState = indexAllPeriod;
                break;
        }
    }

    public void onClickPrevious() {
        ImageView image = getActivity().findViewById(R.id.info_image_photo);
        TextView nameText = getActivity().findViewById(R.id.name_text_photo);

        TextView picCounter = getActivity().findViewById(R.id.counter_photo);
        Spinner spinner = getActivity().findViewById(R.id.spinner_photo);

        String selectedPeriod = String.valueOf(spinner.getSelectedItem());
        switch (selectedPeriod) {
            case "1970-2011":
                indexAllPeriod = BizLogic.decrementCheck(allPeriod, indexAllPeriod, photo);
                image.setImageResource(photo[BizLogic.positionAtArray(allPeriod, indexAllPeriod, photo)].getImageResourceId());
                nameText.setText(photo[BizLogic.positionAtArray(allPeriod, indexAllPeriod, photo)].getName());
                picCounter.setText(BizLogic.dataForCounter(allPeriod, indexAllPeriod, photo));
                periodCurrentState = allPeriod;
                indexCurrentState = indexAllPeriod;
                break;
        }
    }
}
