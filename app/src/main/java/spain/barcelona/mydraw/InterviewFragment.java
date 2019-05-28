package spain.barcelona.mydraw;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ms.square.android.expandabletextview.ExpandableTextView;

public class InterviewFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Интервью");


        return inflater.inflate(R.layout.fragment_interview, container, false);
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
            expTv1.setText(getString(R.string.interview1));
        }

        ExpandableTextView expTv2 = null;
        if (view != null) {
            expTv2 = (ExpandableTextView) view.findViewById(R.id.expand_text2_view);
        }

        // IMPORTANT - call setText on the ExpandableTextView to set the text content to display
        if (expTv2 != null) {
            expTv2.setText(getString(R.string.interview2));
        }

        ExpandableTextView expTv3 = null;
        if (view != null) {
            expTv3 = (ExpandableTextView) view.findViewById(R.id.expand_text3_view);
        }
        if (expTv3 != null) {
            expTv3.setText(getString(R.string.interview3));
        }

        ExpandableTextView expTv4 = null;
        if (view != null) {
            expTv4 = (ExpandableTextView) view.findViewById(R.id.expand_text4_view);
        }
        if (expTv4 != null) {
            expTv4.setText(getString(R.string.interview4));
        }

    }
}
