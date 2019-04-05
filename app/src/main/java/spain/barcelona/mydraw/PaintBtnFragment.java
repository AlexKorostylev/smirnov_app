package spain.barcelona.mydraw;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class PaintBtnFragment extends Fragment implements View.OnClickListener {

    int counter = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_paint_btn, container, false);
        // Inflate the layout for this fragment

    Button btnNext = v.findViewById(R.id.btn_next);
        btnNext.setOnClickListener(this);
    Button btnPrevious = v.findViewById(R.id.btn_previous);
        btnPrevious.setOnClickListener(this);

        return v;
}



    public void onClick(View v) {
        switch (v.getId()) {
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
        int picArrayPos = counter;
        ImageView image = getActivity().findViewById(R.id.info_image_paint);
        image.setImageResource(Pic.paint[picArrayPos].getImageResourceId());
        TextView nameText = getActivity().findViewById(R.id.name_text_paint);
        nameText.setText(Pic.paint[picArrayPos].getName());
        TextView detailText = getActivity().findViewById(R.id.detail_text_paint);
        detailText.setText(Pic.paint[picArrayPos].getDetail());
        //TextView lotNum = (TextView)getActivity().findViewById(R.id.lot_num);
        //lotNum.setText();
    }

    public void onClickPrevious(View v) {
        int picArrayPos = counter;
        ImageView image = getActivity().findViewById(R.id.info_image_paint);
        image.setImageResource(Pic.paint[picArrayPos].getImageResourceId());
        TextView nameText = getActivity().findViewById(R.id.name_text_paint);
        nameText.setText(Pic.paint[picArrayPos].getName());
        TextView detailText = getActivity().findViewById(R.id.detail_text_paint);
        detailText.setText(Pic.paint[picArrayPos].getDetail());
    }

}
