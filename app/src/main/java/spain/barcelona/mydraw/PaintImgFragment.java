package spain.barcelona.mydraw;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class PaintImgFragment extends Fragment {


    public PaintImgFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
/*        ImageView image = getActivity().findViewById(R.id.info_image_paint);
        image.setImageResource(R.drawable.s11_p);
        TextView nameText = getActivity().findViewById(R.id.name_text_paint);
        nameText.setText(R.string.s11_p_name);
        TextView detailText = getActivity().findViewById(R.id.detail_text_paint);
        detailText.setText(R.string.s11_p_detail);*/

        return inflater.inflate(R.layout.fragment_paint_img, container, false);
    }

}
