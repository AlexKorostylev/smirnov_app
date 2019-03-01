package spain.barcelona.mydraw;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ms.square.android.expandabletextview.ExpandableTextView;

public class PoetryFragment extends Fragment {


    // данная версия кода для телефонов
    // TODO для планшетов желательно сделать отображение с помощью 2 фрагментов названия стихотворения-слева (как бы меню) и вывод самого стихотворения справа с возможностью прокручивания правого фрагмента
    // TODO

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_poetry, container, false);

    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        // sample code snippet to set the text content on the ExpandableTextView

        ExpandableTextView expTv1 = null;
        if (view != null) {
            expTv1 = (ExpandableTextView) view.findViewById(R.id.expand_text_view);
        }

        // IMPORTANT - call setText on the ExpandableTextView to set the text content to display
        if (expTv1 != null) {
            expTv1.setText(getString(R.string.poem1));
        }

        ExpandableTextView expTv2 = null;
        if (view != null) {
            expTv2 = (ExpandableTextView) view.findViewById(R.id.expand_text2_view);
        }

        // IMPORTANT - call setText on the ExpandableTextView to set the text content to display
        if (expTv2 != null) {
            expTv2.setText(getString(R.string.poem2));
        }

        ExpandableTextView expTv3 = null;
        if (view != null) {
            expTv3 = (ExpandableTextView) view.findViewById(R.id.expand_text3_view);
        }
        if (expTv3 != null) {
            expTv3.setText(getString(R.string.poem3));
        }

        ExpandableTextView expTv4 = null;
        if (view != null) {
            expTv4 = (ExpandableTextView) view.findViewById(R.id.expand_text4_view);
        }
        if (expTv4 != null) {
            expTv4.setText(getString(R.string.poem4));
        }

        ExpandableTextView expTv5 = null;
        if (view != null) {
            expTv5 = (ExpandableTextView) view.findViewById(R.id.expand_text5_view);
        }
        if (expTv5 != null) {
            expTv5.setText(getString(R.string.poem5));
        }

        ExpandableTextView expTv6 = null;
        if (view != null) {
            expTv6 = (ExpandableTextView) view.findViewById(R.id.expand_text6_view);
        }
        if (expTv6 != null) {
            expTv6.setText(getString(R.string.poem6));
        }

        ExpandableTextView expTv7 = null;
        if (view != null) {
            expTv7 = (ExpandableTextView) view.findViewById(R.id.expand_text7_view);
        }
        if (expTv7 != null) {
            expTv7.setText(getString(R.string.poem7));
        }

        ExpandableTextView expTv8 = null;
        if (view != null) {
            expTv8 = (ExpandableTextView) view.findViewById(R.id.expand_text8_view);
        }
        if (expTv8 != null) {
            expTv8.setText(getString(R.string.poem8));
        }

    }



}
