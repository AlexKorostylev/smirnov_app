package orbis.tertius.smirnov;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import static orbis.tertius.smirnov.DetailPicFragment.artWayIndex;
import static orbis.tertius.smirnov.Pic.*;

public class PhotoImgFragment extends Fragment {

    static int dataForCounterPeriodState;
    static int dataForCounterIndexState;
    static int indexToPicDetail;

    ImgClickListener imgListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            imgListener = (ImgClickListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement onClickImgListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_photo_img, container, false);

        ImageView image = v.findViewById(R.id.info_image_photo);
        TextView detailText = v.findViewById(R.id.detail_text_photo);

        int periodState = MainActivity.periodCurrentStatePhoto; //
        int indexState = MainActivity.indexCurrentStatePhoto;

        if (periodState == 0 & indexState == -1) {
            indexState = BizLogic.incrementCheck(periodState, indexState, photo);
            MainActivity.indexAllPeriodPhoto++;
        }

        image.setImageResource(photo[BizLogic.positionAtArray(periodState, indexState, photo)].getImageResourceId());
        String year = photo[BizLogic.positionAtArray(periodState, indexState, photo)].getYear();
        String place = photo[BizLogic.positionAtArray(periodState, indexState, photo)].getMaterial();
        String photoDetail = place + "  " + year;
        if(photoDetail.equals("  ")){
            detailText.setVisibility(View.INVISIBLE);
        } else {
            detailText.setVisibility(View.VISIBLE);
            detailText.setText(PhotoBtnFragment.photoDetail(year, place));
        }

        indexToPicDetail = BizLogic.positionAtArray(periodState, indexState, photo);
        artWayIndex = "photo";

        dataForCounterPeriodState = periodState;
        dataForCounterIndexState = indexState;

        // Переход на карточку картины
        image.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                imgListener.imgClick();
            }
        });

        return v;
    }

}
