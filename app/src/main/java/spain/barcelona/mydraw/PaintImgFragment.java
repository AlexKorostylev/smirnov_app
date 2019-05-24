package spain.barcelona.mydraw;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import static spain.barcelona.mydraw.BizLogic.*;
import static spain.barcelona.mydraw.Pic.*;


public class PaintImgFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_paint_img, container, false);
        ImageView image = v.findViewById(R.id.info_image_paint);
        TextView nameText = v.findViewById(R.id.name_text_paint);

        indexAllPeriod = BizLogic.incrementCheck(allPeriod, indexAllPeriod, paint);
        image.setImageResource(paint[BizLogic.positionAtArray(allPeriod, indexAllPeriod, paint)].getImageResourceId());
        nameText.setText(paint[BizLogic.positionAtArray(allPeriod, indexAllPeriod, paint)].getName());
        return v;
    }

}
