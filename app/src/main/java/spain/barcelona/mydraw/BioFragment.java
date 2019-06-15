package spain.barcelona.mydraw;

import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class BioFragment extends Fragment {

    // TODO: Сделать отображение "биографии" через фрагменты. На планшете
    // TODO: фото слева - текст справа; На телефоно как сейчас.

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_biogrphy, container, false);

        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.drawer_bio);

        TextView title = view.findViewById(R.id.title_text);
        TextView description = view.findViewById(R.id.description_text);
        Text bio = Text.bio[0];
        title.setText(bio.getTitle());
        description.setText(bio.getDescription());

        return view;
    }
}
