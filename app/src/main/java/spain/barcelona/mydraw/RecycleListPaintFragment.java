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
import static spain.barcelona.mydraw.Pic.paint;
import static spain.barcelona.mydraw.DetailPicFragment.artWayIndex;

import static spain.barcelona.mydraw.MainActivity.positionRecycle;

public class RecycleListPaintFragment extends Fragment {

    static int positionPaint;

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


        RecyclerView pizzaRecycler = (RecyclerView) inflater.inflate(
                R.layout.fragment_recycle_list, container, false);


        // Количество картин во временном периоде
        int amountOfPicAtPeriod;

        period = MainActivity.periodCurrentStatePaint;

        switch (period) {
            case 1:
                amountOfPicAtPeriod = picCountingPerPeriod(1, paint);
                positionRecycle = MainActivity.indexFirstPeriodPaint -2;
                break;
            case 2:
                amountOfPicAtPeriod = picCountingPerPeriod(2, paint);
                positionRecycle = MainActivity.indexSecondPeriodPaint -2;
                break;
            case 3:
                amountOfPicAtPeriod = picCountingPerPeriod(3, paint);
                positionRecycle = MainActivity.indexThirdPeriodPaint -2;
                break;
            case 4:
                amountOfPicAtPeriod = picCountingPerPeriod(4, paint);
                positionRecycle = MainActivity.indexFoursPeriodPaint -2;
                break;
            default:
                amountOfPicAtPeriod = picCountingPerPeriod(0, paint);
                positionRecycle = MainActivity.indexAllPeriodPaint - 2;
        }


        // Соответствие индекса картины в периоде с индексом в главном массиве
        final int[] periodArray = new int[amountOfPicAtPeriod];
        for (int i = 0; i < amountOfPicAtPeriod; i++) {
            periodArray[i] = positionAtArray(period, i, paint);
        }

        String[] picNames = new String[amountOfPicAtPeriod];
        for (int i = 0; i < amountOfPicAtPeriod; i++) {
            picNames[i] = paint[positionAtArray(period, i, paint)].getName();
        }

        int[] picImages = new int[amountOfPicAtPeriod];
        for (int i = 0; i < amountOfPicAtPeriod; i++) {
            picImages[i] = paint[positionAtArray(period, i, paint)].getImageResourceId();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(picNames, picImages);
        pizzaRecycler.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        pizzaRecycler.setLayoutManager(layoutManager);

        // Установление возиции элемента recycle view


        // Если данные пришли из recycle view выбранным пользователем
        // Если данные пришли из Paint Fragment
        layoutManager.scrollToPositionWithOffset(positionRecycle, 20);


        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            public void onClick(int position) {
                // Получил номер карточки в выбранном моссиве
                if (period == 1) {
                    MainActivity.indexFirstPeriodPaint = position;
                } else if(period == 2){
                    MainActivity.indexSecondPeriodPaint = position;
                } else if(period == 3){
                    MainActivity.indexThirdPeriodPaint = position;
                } else if(period == 4){
                    MainActivity.indexFoursPeriodPaint = position;
                } else {
                    MainActivity.indexAllPeriodPaint = position;
                }

                // Позиция в глобальном массиве
                MainActivity.indexCurrentStatePaint = position;

                artWayIndex = "recycle_paint";
                positionPaint = periodArray[position];
                imgListener.imgClick();
                onDetach();
            }
        });


        return pizzaRecycler;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
