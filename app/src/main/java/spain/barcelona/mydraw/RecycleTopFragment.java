package spain.barcelona.mydraw;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import static spain.barcelona.mydraw.MainActivity.appBranch;

public class RecycleTopFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        setHasOptionsMenu(true);

        if(appBranch.equals("graphicBranch")){
            RecycleListGraphicFragment recycleListGraphic = new RecycleListGraphicFragment();
            RecycleChipsGraphicFragment recycleChipsFragment = new RecycleChipsGraphicFragment();
            FragmentTransaction ft = getChildFragmentManager().beginTransaction();

            ft.replace(R.id.recycle_chips_container, recycleChipsFragment);
            ft.replace(R.id.recycle_list_container, recycleListGraphic);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();

            Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
            toolbar.setTitle("Графика");

        } else if(appBranch.equals("paintingBranch")){
            RecycleListPaintFragment recycleListFragment = new RecycleListPaintFragment();
            RecycleChipsPaintFragment recycleChipsFragment = new RecycleChipsPaintFragment();
            FragmentTransaction ft = getChildFragmentManager().beginTransaction();

            ft.replace(R.id.recycle_chips_container, recycleChipsFragment);
            ft.replace(R.id.recycle_list_container, recycleListFragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();

            Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
            toolbar.setTitle("Живопись");
        }
        else if(appBranch.equals("welcomeBranch")){
            RecycleListWelcomeFragment recycleListFragment = new RecycleListWelcomeFragment();
            RecycleChipsPaintFragment recycleChipsFragment = new RecycleChipsPaintFragment();
            FragmentTransaction ft = getChildFragmentManager().beginTransaction();

            ft.replace(R.id.recycle_chips_container, recycleChipsFragment);
            ft.replace(R.id.recycle_list_container, recycleListFragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();

            Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
            toolbar.setTitle("Вадим Смирнов");
        }





        ((MainActivity) getActivity()).getSupportActionBar().show();

        return inflater.inflate(R.layout.fragment_recycle_top, container, false);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Do something that differs the Activity's menu here
        menu.findItem(R.id.recycle_list).setTitle("Recycle");
        menu.findItem(R.id.recycle_list).setIcon(R.drawable.frame_24);
        super.onCreateOptionsMenu(menu, inflater);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.recycle_list:
                item.setTitle("Frame");
                item.setIcon(R.drawable.frame_grid);
                if(appBranch.equals("graphicBranch")){
                    GraphicFragment graphicFragment = new GraphicFragment();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.top_container, graphicFragment);
                    ft.addToBackStack(null);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    ft.commit();
                    MainActivity.startPositionPaint = 0;
                } else if(appBranch.equals("paintingBranch")) {
                    PaintFragment paintingFragment = new PaintFragment();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.top_container, paintingFragment);
                    ft.addToBackStack(null);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    ft.commit();
                    MainActivity.startPositionPaint = 0;
                }
                else if(appBranch.equals("welcomeBranch")) {
                    TopFragment topFragment = new TopFragment();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.top_container, topFragment);
                    ft.addToBackStack(null);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    ft.commit();
                    MainActivity.startPositionWelcome = 0;
                }

                break;
            case R.id.background_mode:
                FrameLayout layout = getActivity().findViewById(R.id.recycle_chips_container);
                layout.setVisibility(View.GONE);
        }
        return false;
    }

}
