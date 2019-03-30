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
                onClickNext(v);
                break;
            case R.id.btn_previous:
                onClickPrevious(v);
                break;

        }
    }
    public void onClickNext(View v) {
        //Spinner artType = (Spinner) view.findViewById(R.id.art_type);
        //String spinnerMsg = (String)artType.getSelectedItem();
        ImageView image = getActivity().findViewById(R.id.info_image);
        image.setImageResource(R.drawable.p19);
        TextView nameText = getActivity().findViewById(R.id.name_text);
        nameText.setText(R.string.p19_name);
        TextView detailText = getActivity().findViewById(R.id.detail_text);
        detailText.setText(R.string.p19_detail);
        //TextView lotNum = (TextView)getActivity().findViewById(R.id.lot_num);
        //lotNum.setText();
    }

    public void onClickPrevious(View v) {
        ImageView image = getActivity().findViewById(R.id.info_image);
        image.setImageResource(R.drawable.s11_p);
        TextView nameText = getActivity().findViewById(R.id.name_text);
        nameText.setText(R.string.s11_p_name);
        TextView detailText = getActivity().findViewById(R.id.detail_text);
        detailText.setText(R.string.s11_p_detail);
    }

}
