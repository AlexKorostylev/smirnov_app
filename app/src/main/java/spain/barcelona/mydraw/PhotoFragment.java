package spain.barcelona.mydraw;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class PhotoFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        PhotoImgFragment imgFragment = new PhotoImgFragment();
        PhotoBtnFragment btnFragment = new PhotoBtnFragment();
        ft.replace(R.id.photo_img_container, imgFragment);
        ft.replace(R.id.photo_btn_container, btnFragment);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Фотоархив");

        ((MainActivity)getActivity()).getSupportActionBar().show();

        return inflater.inflate(R.layout.fragment_photo, container, false);
    }

}
