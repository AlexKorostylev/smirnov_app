package spain.barcelona.mydraw;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class BioFragment extends Fragment {

    // TODO: Сделать отображение "биографии" через фрагменты. На планшете
    // TODO: фото слева - текст справа; На телефоно как сейчас.

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bio, container, false);
    }
}
