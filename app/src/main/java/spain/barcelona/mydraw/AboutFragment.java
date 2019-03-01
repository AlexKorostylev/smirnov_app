package spain.barcelona.mydraw;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ms.square.android.expandabletextview.ExpandableTextView;


public class AboutFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        // sample code snippet to set the text content on the ExpandableTextView

        ExpandableTextView expTv1 = null;
        if (view != null) {
            expTv1 = view.findViewById(R.id.expand_text_view);
        }

        // IMPORTANT - call setText on the ExpandableTextView to set the text content to display
        if (expTv1 != null) {
            expTv1.setText(getString(R.string.about1));
        }

        ExpandableTextView expTv2 = null;
        if (view != null) {
            expTv2 = view.findViewById(R.id.expand_text2_view);
        }

        // IMPORTANT - call setText on the ExpandableTextView to set the text content to display
        if (expTv2 != null) {
            expTv2.setText(getString(R.string.about2));
        }

        ExpandableTextView expTv3 = null;
        if (view != null) {
            expTv3 = view.findViewById(R.id.expand_text3_view);
        }
        if (expTv3 != null) {
            expTv3.setText(getString(R.string.about3));
        }

        ExpandableTextView expTv4 = null;
        if (view != null) {
            expTv4 = view.findViewById(R.id.expand_text4_view);
        }
        if (expTv4 != null) {
            expTv4.setText(getString(R.string.about4));
        }

        ExpandableTextView expTv5 = null;
        if (view != null) {
            expTv5 = view.findViewById(R.id.expand_text5_view);
        }
        if (expTv5 != null) {
            expTv5.setText(getString(R.string.about5));
        }

    }
}
