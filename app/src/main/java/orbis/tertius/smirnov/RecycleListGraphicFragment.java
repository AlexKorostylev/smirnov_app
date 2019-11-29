package orbis.tertius.smirnov;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static orbis.tertius.smirnov.BizLogic.*;
import static orbis.tertius.smirnov.Pic.pics;
import static orbis.tertius.smirnov.DetailPicFragment.artWayIndex;

import static orbis.tertius.smirnov.MainActivity.positionRecycle;


public class RecycleListGraphicFragment extends Fragment {

    static int positionGraphic;

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


        RecyclerView graphicRecycler = (RecyclerView) inflater.inflate(
                R.layout.fragment_recycle_list, container, false);


        // Количество картин во временном периоде
        int amountOfPicAtPeriod;

        period = MainActivity.periodCurrentStateGraphic;

        switch (period) {
            case 1:
                amountOfPicAtPeriod = picCountingPerPeriod(1, pics);
                positionRecycle = MainActivity.indexFirstPeriodGraphic -2;
                break;
            case 2:
                amountOfPicAtPeriod = picCountingPerPeriod(2, pics);
                positionRecycle = MainActivity.indexSecondPeriodGraphic -2;
                break;
            case 3:
                amountOfPicAtPeriod = picCountingPerPeriod(3, pics);
                positionRecycle = MainActivity.indexThirdPeriodGraphic -2;
                break;
            case 4:
                amountOfPicAtPeriod = picCountingPerPeriod(4, pics);
                positionRecycle = MainActivity.indexFoursPeriodGraphic -2;
                break;
            default:
                amountOfPicAtPeriod = picCountingPerPeriod(0, pics);
                positionRecycle = MainActivity.indexAllPeriodGraphic - 2;
        }


        // Соответствие индекса картины в периоде с индексом в главном массиве
        final int[] periodArray = new int[amountOfPicAtPeriod];
        for (int i = 0; i < amountOfPicAtPeriod; i++) {
            periodArray[i] = positionAtArray(period, i, pics);
        }

        String[] picNames = new String[amountOfPicAtPeriod];
        for (int i = 0; i < amountOfPicAtPeriod; i++) {
            picNames[i] = pics[positionAtArray(period, i, pics)].getName();
        }

        int[] picImages = new int[amountOfPicAtPeriod];
        for (int i = 0; i < amountOfPicAtPeriod; i++) {
            picImages[i] = pics[positionAtArray(period, i, pics)].getSmallimageResourceId();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(picNames, picImages);
        graphicRecycler.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        graphicRecycler.setLayoutManager(layoutManager);

        // Установление возиции элемента recycle view


        // Если данные пришли из recycle view выбранным пользователем
        // Если данные пришли из Paint Fragment
        layoutManager.scrollToPositionWithOffset(positionRecycle, 2);


        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            public void onClick(int position) {
                // Получил номер карточки в выбранном моссиве
                if (period == 1) {
                    MainActivity.indexFirstPeriodGraphic = position;
                } else if(period == 2){
                    MainActivity.indexSecondPeriodGraphic = position;
                } else if(period == 3){
                    MainActivity.indexThirdPeriodGraphic = position;
                } else if(period == 4){
                    MainActivity.indexFoursPeriodGraphic = position;
                } else {
                    MainActivity.indexAllPeriodGraphic = position;
                }

                // Позиция в глобальном массиве
                MainActivity.indexCurrentStateGraphic = position;

                artWayIndex = "recycle_graphic";
                positionGraphic = periodArray[position];
                imgListener.imgClick();
                onDetach();
            }
        });


        return graphicRecycler;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
