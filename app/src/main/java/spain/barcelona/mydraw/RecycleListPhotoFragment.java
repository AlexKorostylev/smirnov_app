package spain.barcelona.mydraw;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static spain.barcelona.mydraw.BizLogic.*;
import static spain.barcelona.mydraw.Pic.photo;
import static spain.barcelona.mydraw.DetailPicFragment.artWayIndex;

import static spain.barcelona.mydraw.MainActivity.positionRecycle;

public class RecycleListPhotoFragment extends Fragment {

    static int positionPhoto;

    public static int period;

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

        // View v = inflater.inflate(R.layout.fragment_recycle_list, container, false);


        RecyclerView photoRecycler = (RecyclerView) inflater.inflate(
                R.layout.fragment_recycle_list, container, false);


        // Количество картин во временном периоде
        int amountOfPicAtPeriod;

        period = MainActivity.periodCurrentStatePhoto;


        amountOfPicAtPeriod = picCountingPerPeriod(0, photo);
        positionRecycle = MainActivity.indexAllPeriodPhoto - 2;



        // Соответствие индекса картины в периоде с индексом в главном массиве
        final int[] periodArray = new int[amountOfPicAtPeriod];
        for (int i = 0; i < amountOfPicAtPeriod; i++) {
            periodArray[i] = positionAtArray(period, i, photo);
        }

        String[] picYear = new String[amountOfPicAtPeriod];
        for (int i = 0; i < amountOfPicAtPeriod; i++) {
            picYear[i] = photo[positionAtArray(period, i, photo)].getYear();
        }

        int[] picImages = new int[amountOfPicAtPeriod];
        for (int i = 0; i < amountOfPicAtPeriod; i++) {
            picImages[i] = photo[positionAtArray(period, i, photo)].getSmallimageResourceId();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(picYear, picImages);
        photoRecycler.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        photoRecycler.setLayoutManager(layoutManager);

        // Установление возиции элемента recycle view


        // Если данные пришли из recycle view выбранным пользователем
        // Если данные пришли из Paint Fragment
        layoutManager.scrollToPositionWithOffset(positionRecycle, 20);


        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            public void onClick(int position) {
                // Получил номер карточки в выбранном моссиве

                MainActivity.indexAllPeriodPhoto = position;

                // Позиция в глобальном массиве
                MainActivity.indexCurrentStatePhoto = position;

                artWayIndex = "recycle_photo";
                positionPhoto = periodArray[position];
                imgListener.imgClick();
                onDetach();
            }
        });

        return photoRecycler;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }



}
