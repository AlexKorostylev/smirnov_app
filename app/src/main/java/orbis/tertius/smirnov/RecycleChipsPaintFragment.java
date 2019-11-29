package orbis.tertius.smirnov;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import static orbis.tertius.smirnov.MainActivity.periodCurrentStatePaint;


public class RecycleChipsPaintFragment extends Fragment implements View.OnClickListener {




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
        chipBtnAll.setText(R.string.chip_btn_all_paint);
        chipBtnAll.setOnClickListener(this);
        Button chipBtn_1 = v.findViewById(R.id.chipBtn_1);
        chipBtn_1.setOnClickListener(this);
        Button chipBtn_2 = v.findViewById(R.id.chipBtn_2);
        chipBtn_2.setOnClickListener(this);
        Button chipBtn_3 = v.findViewById(R.id.chipBtn_3);
        chipBtn_3.setOnClickListener(this);
        Button chipBtn_4 = v.findViewById(R.id.chipBtn_4);
        chipBtn_4.setText(R.string.chip_btn4_paint);
        chipBtn_4.setOnClickListener(this);


        return v;
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.chipBtnAll:
                periodCurrentStatePaint =0;
                chipListener.chipClick();
                break;
            case R.id.chipBtn_1:
                periodCurrentStatePaint =1;
                chipListener.chipClick();
                break;
            case R.id.chipBtn_2:
                periodCurrentStatePaint =2;
                chipListener.chipClick();
                break;
            case R.id.chipBtn_3:
                periodCurrentStatePaint =3;
                chipListener.chipClick();
                break;
            case R.id.chipBtn_4:
                periodCurrentStatePaint =4;
                chipListener.chipClick();
                break;
        }
    }
}
