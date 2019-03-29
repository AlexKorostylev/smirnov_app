package spain.barcelona.mydraw;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class TopFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        TopImgFragment imgFragment = new TopImgFragment();
        TopBtnFragment topBtnFragment = new TopBtnFragment();
        ft.replace(R.id.img_container, imgFragment);
        ft.replace(R.id.btn_container, topBtnFragment);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();

        return inflater.inflate(R.layout.fragment_top, container, false);
    }

}
