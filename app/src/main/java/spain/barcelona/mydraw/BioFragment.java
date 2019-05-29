package spain.barcelona.mydraw;

import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class BioFragment extends Fragment {

    // TODO: Сделать отображение "биографии" через фрагменты. На планшете
    // TODO: фото слева - текст справа; На телефоно как сейчас.

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.drawer_bio);

        return inflater.inflate(R.layout.fragment_biogrphy, container, false);
        //return inflater.inflate(R.layout.fragment_bio, container, false);
    }
}
