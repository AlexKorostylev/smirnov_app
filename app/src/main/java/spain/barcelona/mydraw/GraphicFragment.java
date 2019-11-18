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

public class GraphicFragment extends Fragment {

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

        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        GraphicImgFragment imgFragment = new GraphicImgFragment();
        GraphicBtnFragment btnFragment = new GraphicBtnFragment();
        ft.replace(R.id.graphic_img_container, imgFragment);
        ft.replace(R.id.graphic_btn_container, btnFragment);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Графика");

        ((MainActivity)getActivity()).getSupportActionBar().show();

        return inflater.inflate(R.layout.fragment_graphic, container, false);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Do something that differs the Activity's menu here
        menu.findItem(R.id.recycle_list).setTitle("Frame");
        menu.findItem(R.id.recycle_list).setIcon(R.drawable.frame_grid);
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
                    MainActivity.startPositionGraphic = 1;
                    appBranch = "graphicBranch";
                }
        }
        return false;
    }
}

