package spain.barcelona.mydraw;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class PaintFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

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

        return inflater.inflate(R.layout.fragment_paint, container, false);
    }

}
