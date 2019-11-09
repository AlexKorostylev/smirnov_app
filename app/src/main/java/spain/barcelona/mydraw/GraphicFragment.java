package spain.barcelona.mydraw;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class GraphicFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

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
}

