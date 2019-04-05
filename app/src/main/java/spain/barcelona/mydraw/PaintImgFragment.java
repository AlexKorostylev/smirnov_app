package spain.barcelona.mydraw;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


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
        View v = inflater.inflate(R.layout.fragment_paint_img, container, false);
        ImageView image = v.findViewById(R.id.info_image_paint);
        image.setImageResource(Pic.paint[0].getImageResourceId());
        TextView nameText = v.findViewById(R.id.name_text_paint);
        nameText.setText(Pic.paint[0].getName());
        TextView detailText = v.findViewById(R.id.detail_text_paint);
        detailText.setText(Pic.paint[0].getDetail());

        return v;
    }

}
