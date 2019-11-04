package spain.barcelona.mydraw;


import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import static spain.barcelona.mydraw.Pic.*;

public class PaintImgFragment extends Fragment{

    static int dataForCounterPeriodState;
    static int dataForCounterIndexState;

    public interface onSomeEventListener {
        public void someEvent(String s);
    }

    onSomeEventListener someEventListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            someEventListener = (onSomeEventListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement onSomeEventListener");
        }
    }

    final String LOG_TAG = "myLogs";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_paint_img, container, false);
        ImageView image = v.findViewById(R.id.info_image_paint);
        TextView nameText = v.findViewById(R.id.name_text_paint);

        int periodState = PaintBtnFragment.periodCurrentState; //
        int indexState = PaintBtnFragment.indexCurrentState;

        if (periodState == 0 & indexState == -1) {
            indexState = BizLogic.incrementCheck(periodState, indexState, paint);
            PaintBtnFragment.indexAllPeriod++;
        }

        image.setImageResource(paint[BizLogic.positionAtArray(periodState, indexState, paint)].getImageResourceId());
        nameText.setText(paint[BizLogic.positionAtArray(periodState, indexState, paint)].getName());

        dataForCounterPeriodState = periodState;
        dataForCounterIndexState = indexState;

        image.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                someEventListener.someEvent("Test signal from fragment to Activity");
            }
        });

        return v;
    }

}
