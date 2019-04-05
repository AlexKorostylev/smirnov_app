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
public class GraphicImgFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_graphic_img, container, false);
        ImageView image = v.findViewById(R.id.info_image_graphic);
        TextView nameText = v.findViewById(R.id.name_text_graphic);
        TextView detailText = v.findViewById(R.id.detail_text_graphic);
        image.setImageResource(Pic.pics[0].getImageResourceId());
        nameText.setText(Pic.pics[0].getName());
        detailText.setText(Pic.pics[0].getDetail());

        return v;
    }

}
