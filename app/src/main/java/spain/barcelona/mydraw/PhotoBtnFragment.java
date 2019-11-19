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


import static spain.barcelona.mydraw.MainActivity.indexAllPeriodPhoto;
import static spain.barcelona.mydraw.MainActivity.indexCurrentStatePhoto;
import static spain.barcelona.mydraw.MainActivity.periodCurrentStatePhoto;

import static spain.barcelona.mydraw.BizLogic.*;
import static spain.barcelona.mydraw.PhotoImgFragment.indexToPicDetail;
import static spain.barcelona.mydraw.Pic.photo;

public class PhotoBtnFragment extends Fragment implements View.OnClickListener {

    // start index counter number for paints per period





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
        //TextView nameText = getActivity().findViewById(R.id.name_text_photo);
        TextView detailText = getActivity().findViewById(R.id.detail_text_photo);

        TextView picCounter = getActivity().findViewById(R.id.counter_photo);
        Spinner spinner = getActivity().findViewById(R.id.spinner_photo);

        String selectedPeriodFromSpinner = String.valueOf(spinner.getSelectedItem());
        switch (selectedPeriodFromSpinner) {
            case "1970-2011":
                indexAllPeriodPhoto = incrementCheck(allPeriod, indexAllPeriodPhoto, photo);
                image.setImageResource(photo[positionAtArray(allPeriod, indexAllPeriodPhoto, photo)].getImageResourceId());
                String year = photo[positionAtArray(allPeriod, indexAllPeriodPhoto, photo)].getYear();
                String place = photo[positionAtArray(allPeriod, indexAllPeriodPhoto, photo)].getMaterial();
                String photoDetail = place + "  " + year;
                detailText.setText(photoDetail);
                picCounter.setText(dataForCounter(allPeriod, indexAllPeriodPhoto, photo));
                periodCurrentStatePhoto = allPeriod;
                indexAllPeriodPhoto = indexAllPeriodPhoto;
                indexToPicDetail = positionAtArray(allPeriod, indexAllPeriodPhoto, photo);
                break;
        }
    }

    public void onClickPrevious() {
        ImageView image = getActivity().findViewById(R.id.info_image_photo);
        TextView detailText = getActivity().findViewById(R.id.detail_text_photo);

        TextView picCounter = getActivity().findViewById(R.id.counter_photo);
        Spinner spinner = getActivity().findViewById(R.id.spinner_photo);

        String selectedPeriod = String.valueOf(spinner.getSelectedItem());
        switch (selectedPeriod) {
            case "1970-2011":
                indexAllPeriodPhoto = decrementCheck(allPeriod, indexAllPeriodPhoto, photo);
                image.setImageResource(photo[positionAtArray(allPeriod, indexAllPeriodPhoto, photo)].getImageResourceId());
                String year = photo[positionAtArray(allPeriod, indexAllPeriodPhoto, photo)].getYear();
                String place = photo[positionAtArray(allPeriod, indexAllPeriodPhoto, photo)].getMaterial();
                detailText.setText(photoDetail(year, place));
                picCounter.setText(dataForCounter(allPeriod, indexAllPeriodPhoto, photo));
                periodCurrentStatePhoto = allPeriod;
                indexCurrentStatePhoto = indexAllPeriodPhoto;
                indexToPicDetail = positionAtArray(allPeriod, indexAllPeriodPhoto, photo);
                break;
        }
    }

    public static String photoDetail(String year, String place) {
        String photoDetail;
        if (place.equals("")) {
            photoDetail = year;
        } else {
            photoDetail = place + "  " + year;
        }
        return photoDetail;
    }

}
