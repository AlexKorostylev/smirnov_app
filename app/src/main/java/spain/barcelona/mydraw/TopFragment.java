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
import static spain.barcelona.mydraw.MainActivity.startPositionG;

public class TopFragment extends Fragment {

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
        View v = inflater.inflate(R.layout.fragment_top, container, false);

        setHasOptionsMenu(true);

        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        TopImgFragment imgFragment = new TopImgFragment();
        TopBtnFragment topBtnFragment = new TopBtnFragment();
        ft.replace(R.id.img_container, imgFragment);
        ft.replace(R.id.btn_container, topBtnFragment);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();

        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Вадим Смирнов");

        ((MainActivity) getActivity()).getSupportActionBar().show();

        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Do something that differs the Activity's menu here
        menu.findItem(R.id.recycle_list).setTitle("Frame");
        if(startPositionG==0){
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
                    appBranch = "welcomeBranch";
                }
        }
        return false;
    }

}
