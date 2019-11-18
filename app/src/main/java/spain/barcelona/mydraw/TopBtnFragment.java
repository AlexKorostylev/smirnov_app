
package spain.barcelona.mydraw;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import static spain.barcelona.mydraw.MainActivity.indexCurrentStateWelcome;
import static spain.barcelona.mydraw.MainActivity.periodCurrentStateWelcome;
import static spain.barcelona.mydraw.MainActivity.indexAllPeriodWelcome;

import static spain.barcelona.mydraw.BizLogic.*;
import static spain.barcelona.mydraw.TopImgFragment.indexToPicDetail;
import static spain.barcelona.mydraw.Pic.*;

public class TopBtnFragment extends Fragment implements View.OnClickListener {

    // start index counter number for paints per period





    interface FragmentArtListener {
        void itemClickedArtListener(String fragment_name);
    }

    public FragmentArtListener listener;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_top_btn, container, false);
        // Inflate the layout for this fragment

        Button btnNext = v.findViewById(R.id.btn_next);
        btnNext.setOnClickListener(this);
        Button btnPrevious = v.findViewById(R.id.btn_previous);
        btnPrevious.setOnClickListener(this);

        Spinner spinner = v.findViewById(R.id.spinner_top);
        spinner.setSelection(PaintImgFragment.dataForCounterPeriodState);

        TextView pictureCounter = v.findViewById(R.id.counter_top);
        pictureCounter.setText(BizLogic.dataForCounter(TopImgFragment.dataForCounterPeriodState, TopImgFragment.dataForCounterIndexState, topScreen));

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
        ImageView image = getActivity().findViewById(R.id.info_image_top);
        TextView nameText = getActivity().findViewById(R.id.name_text_top);

        TextView picCounter = getActivity().findViewById(R.id.counter_top);
        Spinner spinner = getActivity().findViewById(R.id.spinner_top);

        String selectedPeriodFromSpinner = String.valueOf(spinner.getSelectedItem());
        switch (selectedPeriodFromSpinner) {
            case "знакомство":
                if(periodCurrentStateWelcome != allPeriod ){
                    --indexAllPeriodWelcome;
                }
                indexAllPeriodWelcome = BizLogic.incrementCheck(allPeriod, indexAllPeriodWelcome, topScreen);
                image.setImageResource(topScreen[BizLogic.positionAtArray(allPeriod, indexAllPeriodWelcome, topScreen)].getImageResourceId());
                nameText.setText(topScreen[BizLogic.positionAtArray(allPeriod, indexAllPeriodWelcome, topScreen)].getName());
                picCounter.setText(BizLogic.dataForCounter(allPeriod, indexAllPeriodWelcome, topScreen));
                periodCurrentStateWelcome = allPeriod;
                indexCurrentStateWelcome = indexAllPeriodWelcome;
                indexToPicDetail = BizLogic.positionAtArray(allPeriod, indexAllPeriodWelcome, topScreen);
                break;
            case "живопись":
                onListItemClick("живопись");
                break;
            case "графика":
                onListItemClick("графика");
                break;

        }
    }

    public void onClickPrevious() {
        ImageView image = getActivity().findViewById(R.id.info_image_top);
        TextView nameText = getActivity().findViewById(R.id.name_text_top);

        TextView picCounter = getActivity().findViewById(R.id.counter_top);
        Spinner spinner = getActivity().findViewById(R.id.spinner_top);

        String selectedPeriod = String.valueOf(spinner.getSelectedItem());
        switch (selectedPeriod) {
            case "знакомство":
                if(periodCurrentStateWelcome != allPeriod ){
                    ++indexAllPeriodWelcome;
                }
                indexAllPeriodWelcome = BizLogic.decrementCheck(allPeriod, indexAllPeriodWelcome, topScreen);
                image.setImageResource(topScreen[BizLogic.positionAtArray(allPeriod, indexAllPeriodWelcome, topScreen)].getImageResourceId());
                nameText.setText(topScreen[BizLogic.positionAtArray(allPeriod, indexAllPeriodWelcome, topScreen)].getName());
                picCounter.setText(BizLogic.dataForCounter(allPeriod, indexAllPeriodWelcome, topScreen));
                periodCurrentStateWelcome = allPeriod;
                indexCurrentStateWelcome = indexAllPeriodWelcome;
                indexToPicDetail = BizLogic.positionAtArray(allPeriod, indexAllPeriodWelcome, topScreen);
                break;
            case "живопись":
                onListItemClick("живопись");
                break;
            case "графика":
                onListItemClick("графика");
                break;
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.listener = (FragmentArtListener) activity;
    }

    public void onListItemClick(String fragment_name) {
        listener.itemClickedArtListener(fragment_name);

    }

}
