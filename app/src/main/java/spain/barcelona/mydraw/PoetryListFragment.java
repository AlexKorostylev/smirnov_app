package spain.barcelona.mydraw;


import android.app.Activity;
import android.os.Bundle;
import android.app.ListFragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PoetryListFragment extends ListFragment {

    interface PoetryListListener {
        void itemClickedPoetry(long id);
    }

    public PoetryListListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Поэзия");

        String[] listTitles = new String[Text.poetry.length];
        for (int i = 0; i < listTitles.length; i++) {
            listTitles[i] = Text.poetry[i].getTitle();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                inflater.getContext(), android.R.layout.simple_list_item_1,
                listTitles);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.listener = (PoetryListListener) activity;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if (listener != null) {
            listener.itemClickedPoetry(id);
        }
    }
}
