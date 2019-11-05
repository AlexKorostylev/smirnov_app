package spain.barcelona.mydraw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import static spain.barcelona.mydraw.Pic.paint;

public class PicDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_detail);

        ImageView picImg = findViewById(R.id.detail_pic_img);
        TextView picName = findViewById(R.id.detail_pic_name); // Название картины
        TextView picMaterial = findViewById(R.id.detail_pic_material); // Техника исполнения (Например: холст, масло)
        // TextView picSize = findViewById(R.id.detail_pic_size); // Размер (Высота х ширина)
        // TextView picYear = findViewById(R.id.detail_pic_year); // Год создания (город, страна)
        // TextView picCategory = findViewById(R.id.detail_pic_category); //  живопись графика
        // TextView picStyle = findViewById(R.id.detail_pic_style); // импррессионизм

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int picIndex = bundle.getInt("PIC_INDEX");
            //String paramFromIntent = Integer.toString(picIndex);
            picImg.setImageResource(paint[picIndex].getImageResourceId());
            picName.setText(paint[picIndex].getName());

            String date = paint[picIndex].getMaterial() + ",  " + (paint[picIndex].getSize()) + ",  " +
                    (paint[picIndex].getYear());
            picMaterial.setText(date);
            // picSize.setText(paint[picIndex].getSize());
            // picYear.setText(paint[picIndex].getYear());
        }



    }
}
