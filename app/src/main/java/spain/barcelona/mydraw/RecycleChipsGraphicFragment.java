package spain.barcelona.mydraw;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import static spain.barcelona.mydraw.MainActivity.periodCurrentStateGraphic;

public class RecycleChipsGraphicFragment extends Fragment implements View.OnClickListener {

    ChipListener chipListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            chipListener = (ChipListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement onClickChipListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_recycle_chips, container, false);



        Button chipBtnAll = v.findViewById(R.id.chipBtnAll);
        chipBtnAll.setText(R.string.chip_btn_all_graphic);
        chipBtnAll.setOnClickListener(this);
        Button chipBtn_1 = v.findViewById(R.id.chipBtn_1);
        chipBtn_1.setOnClickListener(this);
        Button chipBtn_2 = v.findViewById(R.id.chipBtn_2);
        chipBtn_2.setOnClickListener(this);
        Button chipBtn_3 = v.findViewById(R.id.chipBtn_3);
        chipBtn_3.setOnClickListener(this);
        Button chipBtn_4 = v.findViewById(R.id.chipBtn_4);
        chipBtn_4.setText(R.string.chip_btn4_graphic);
        chipBtn_4.setOnClickListener(this);


        return v;
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.chipBtnAll:
                periodCurrentStateGraphic =0;
                chipListener.chipClick();
                break;
            case R.id.chipBtn_1:
                periodCurrentStateGraphic =1;
                chipListener.chipClick();
                break;
            case R.id.chipBtn_2:
                periodCurrentStateGraphic =2;
                chipListener.chipClick();
                break;
            case R.id.chipBtn_3:
                periodCurrentStateGraphic =3;
                chipListener.chipClick();
                break;
            case R.id.chipBtn_4:
                periodCurrentStateGraphic =4;
                chipListener.chipClick();
                break;
        }
    }


}
