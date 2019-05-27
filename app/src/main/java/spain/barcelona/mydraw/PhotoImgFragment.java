package spain.barcelona.mydraw;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import static spain.barcelona.mydraw.Pic.*;

public class PhotoImgFragment extends Fragment {

    static int dataForCounterPeriodState;
    static int dataForCounterIndexState;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_photo_img, container, false);

        ImageView image = v.findViewById(R.id.info_image_photo);
        TextView nameText = v.findViewById(R.id.name_text_photo);
        // в некоторых фото вообще нет деталей, значит и этого блока быть не должно
        TextView detailText = v.findViewById(R.id.detail_text_photo);

        int periodState = PhotoBtnFragment.periodCurrentState; //
        int indexState = PhotoBtnFragment.indexCurrentState;

        if (periodState == 0 & indexState == -1) {
            indexState = BizLogic.incrementCheck(periodState, indexState, photo);
            PhotoBtnFragment.indexAllPeriod++;
        }

        image.setImageResource(photo[BizLogic.positionAtArray(periodState, indexState, photo)].getImageResourceId());
        nameText.setText(photo[BizLogic.positionAtArray(periodState, indexState, photo)].getName());

        String year = photo[BizLogic.positionAtArray(periodState, indexState, photo)].getYear();
        String place = photo[BizLogic.positionAtArray(periodState, indexState, photo)].getMaterial();
        // String comment = photo[BizLogic.positionAtArray(periodState, indexState, photo)].getSize();
        detailText.setText(PhotoBtnFragment.photoDetail(year, place));

        dataForCounterPeriodState = periodState;
        dataForCounterIndexState = indexState;

        return v;
    }

}
