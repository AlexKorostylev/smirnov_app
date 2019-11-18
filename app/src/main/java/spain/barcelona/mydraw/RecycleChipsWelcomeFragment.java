package spain.barcelona.mydraw;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import static spain.barcelona.mydraw.MainActivity.*;

public class RecycleChipsWelcomeFragment extends Fragment implements View.OnClickListener{


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

        View v = inflater.inflate(R.layout.fragment_recycle_chips_welcome, container, false);

        Button chipBtn_1 = v.findViewById(R.id.chipBtn_1);
        chipBtn_1.setText(R.string.chip_btn_welcome);
        chipBtn_1.setOnClickListener(this);
        Button chipBtn_2 = v.findViewById(R.id.chipBtn_2);
        chipBtn_2.setText(R.string.chip_btn_art_paint);
        chipBtn_2.setOnClickListener(this);
        Button chipBtn_3 = v.findViewById(R.id.chipBtn_3);
        chipBtn_3.setText(R.string.chip_btn_art_graphic);
        chipBtn_3.setOnClickListener(this);

        return v;
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.chipBtn_1:
                chipListener.chipClick();
                break;
            case R.id.chipBtn_2:
                appBranch = "paintingBranch";
                chipListener.chipClick();
                break;
            case R.id.chipBtn_3:
                appBranch = "graphicBranch";
                chipListener.chipClick();
                break;

        }
    }

}
