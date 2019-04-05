package spain.barcelona.mydraw;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class GraphicBtnFragment extends Fragment implements View.OnClickListener {

    int counter = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_graphic_btn, container, false);
        // Inflate the layout for this fragment
        Button btnNext = v.findViewById(R.id.btn_next);
        btnNext.setOnClickListener(this);
        Button btnPrevious = v.findViewById(R.id.btn_previous);
        btnPrevious.setOnClickListener(this);

        return v;
    }


    public void onClick(View v) {

        switch (v.getId()) {
            // Отчет начинается с 0
            case R.id.btn_next:
                if(counter ==0){
                    ++counter;
                } else if (counter >=Pic.pics.length) {
                    counter = 0;
                }
                onClickNext(v);
                counter++;
                break;
            case R.id.btn_previous:
                if(counter==0){
                    counter = Pic.pics.length-1;
                } else {
                    --counter;
                }
                onClickPrevious(v);
                break;

        }
    }

    public void onClickNext(View v) {
        //Spinner artType = (Spinner) view.findViewById(R.id.art_type);
        //String spinnerMsg = (String)artType.getSelectedItem();
        ImageView image = getActivity().findViewById(R.id.info_image_graphic);
        TextView nameText = getActivity().findViewById(R.id.name_text_graphic);
        TextView detailText = getActivity().findViewById(R.id.detail_text_graphic);


        int picArrayPos = counter;
        image.setImageResource(Pic.pics[picArrayPos].getImageResourceId());
        nameText.setText(Pic.pics[picArrayPos].getName());
        detailText.setText(Pic.pics[picArrayPos].getDetail());
        //TextView lotNum = (TextView)getActivity().findViewById(R.id.lot_num);
        //lotNum.setText();
    }

    public void onClickPrevious(View v) {
        int picArrayPos = counter;
        ImageView image = getActivity().findViewById(R.id.info_image_graphic);
        image.setImageResource(Pic.pics[picArrayPos].getImageResourceId());
        TextView nameText = getActivity().findViewById(R.id.name_text_graphic);
        nameText.setText(Pic.pics[picArrayPos].getName());
        TextView detailText = getActivity().findViewById(R.id.detail_text_graphic);
        detailText.setText(Pic.pics[picArrayPos].getDetail());
    }

}
