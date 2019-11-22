package spain.barcelona.mydraw;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import static spain.barcelona.mydraw.MainActivity.appBranch;

public class PaintFragment extends Fragment {

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

        setHasOptionsMenu(true);

        View v = inflater.inflate(R.layout.fragment_paint, container, false);

        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        PaintImgFragment imgFragment = new PaintImgFragment();
        PaintBtnFragment yearFragment = new PaintBtnFragment();

        ft.replace(R.id.paint_img_container, imgFragment);
        ft.replace(R.id.paint_btn_container, yearFragment);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();

        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Живопись");

        ((MainActivity) getActivity()).getSupportActionBar().show();

        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.findItem(R.id.recycle_list).setTitle("Frame");
        if(MainActivity.dayNightMode ==0){
            menu.findItem(R.id.recycle_list).setIcon(R.drawable.frame_grid_black_24);
            menu.findItem(R.id.background_mode).setIcon(R.drawable.day_night_24_black);
        } else {
            menu.findItem(R.id.recycle_list).setIcon(R.drawable.frame_grid_white_24);
            menu.findItem(R.id.background_mode).setIcon(R.drawable.day_night_24_white);
        }
        super.onCreateOptionsMenu(menu, inflater);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.recycle_list:
                if (item.getTitle().equals("Frame")) {
                    RecycleTopFragment recycleTopFragment = new RecycleTopFragment();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.top_container, recycleTopFragment);
                    ft.addToBackStack(null);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    ft.commit();
                    MainActivity.startPositionPaint = 1;
                    appBranch = "paintingBranch";
                }
                break;
            case R.id.background_mode:
        break;

        }
        return false;
    }
}
