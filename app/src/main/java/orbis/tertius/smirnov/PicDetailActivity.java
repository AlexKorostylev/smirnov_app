package orbis.tertius.smirnov;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static orbis.tertius.smirnov.Pic.paint;

public class PicDetailActivity extends AppCompatActivity implements View.OnTouchListener {


    // These matrices will be used to move and zoom image
    Matrix matrix = new Matrix();
    Matrix savedMatrix = new Matrix();

    // We can be in one of these 3 states
    static final int NONE = 0;
    static final int DRAG = 1;
    static final int ZOOM = 2;
    int mode = NONE;

    // Remember some things for zooming
    PointF start = new PointF();
    PointF mid = new PointF();
    float oldDist = 1f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_detail);

        ImageView picImg = findViewById(R.id.detail_pic_img);
        TextView picName = findViewById(R.id.detail_pic_name);
        TextView picMaterial = findViewById(R.id.detail_pic_detail);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int picIndex = bundle.getInt("PIC_INDEX");
            picImg.setImageResource(paint[picIndex].getImageResourceId());
            picName.setText(paint[picIndex].getName());

            String picDetail = paint[picIndex].getMaterial() + "   " + (paint[picIndex].getSize()) + "   " +
                    (paint[picIndex].getYear())+"г.";
            picMaterial.setText(picDetail);
        }

        picImg.setScaleType(ImageView.ScaleType.FIT_CENTER); // make the image fit to the center.
        picImg.setOnTouchListener(this);
    }

    public boolean onTouch(View v, MotionEvent event) {
        ImageView view = (ImageView) v;
        // make the image scalable as a matrix
        view.setScaleType(ImageView.ScaleType.MATRIX);
        float scale;

        // Handle touch events here...
        switch (event.getAction() & MotionEvent.ACTION_MASK) {

            case MotionEvent.ACTION_DOWN: //first finger down only
                savedMatrix.set(matrix);
                start.set(event.getX(), event.getY());

                mode = DRAG;
                break;
            case MotionEvent.ACTION_UP: //first finger lifted
                break;
            case MotionEvent.ACTION_POINTER_UP: //second finger lifted
                mode = NONE;
                break;
            case MotionEvent.ACTION_POINTER_DOWN: //second finger down
                oldDist = spacing(event); // calculates the distance between two points where user touched.
                // minimal distance between both the fingers
                if (oldDist > 5f) {
                    savedMatrix.set(matrix);
                    midPoint(mid, event); // sets the mid-point of the straight line between two points where user touched.
                    mode = ZOOM;
                }
                break;

            case MotionEvent.ACTION_MOVE:
                if (mode == DRAG)
                { //movement of first finger
                    matrix.set(savedMatrix);
                    if (view.getLeft() >= 0)
                    {
                        matrix.postTranslate(event.getX() - start.x, event.getY() - start.y);
                    }
                }
                else if (mode == ZOOM) { //pinch zooming
                    float newDist = spacing(event);
                    if (newDist > 5f) {
                        matrix.set(savedMatrix);
                        scale = newDist/oldDist; // XXX may need to play with this value to limit it
                        matrix.postScale(scale, scale, mid.x, mid.y);
                    }
                }
                break;
        }

        // Perform the transformation
        view.setImageMatrix(matrix);

        return true; // indicate event was handled
    }

    private float spacing(MotionEvent event) {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return (float)Math.sqrt(x * x + y * y);
    }

    private void midPoint(PointF point, MotionEvent event) {
        float x = event.getX(0) + event.getX(1);
        float y = event.getY(0) + event.getY(1);
        point.set(x / 2, y / 2);
    }
}
