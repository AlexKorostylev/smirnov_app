package spain.barcelona.mydraw;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;


public class RecycleTopFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        setHasOptionsMenu(true);

        RecycleListFragment recycleListFragment = new RecycleListFragment();
        RecycleChipsFragment recycleChipsFragment = new RecycleChipsFragment();
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();

        ft.replace(R.id.recycle_chips_container, recycleChipsFragment);
        ft.replace(R.id.recycle_list_container, recycleListFragment);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();

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
                PaintFragment paintingFragment = new PaintFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.top_container, paintingFragment);
                ft.addToBackStack(null);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
                break;
            case R.id.background_mode:
                FrameLayout layout = getActivity().findViewById(R.id.recycle_chips_container);
                layout.setVisibility(View.GONE);
        }
        return false;
    }

}
