package spain.barcelona.mydraw;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

import static spain.barcelona.mydraw.Pic.*;


public class DetailPicFragment extends Fragment implements View.OnTouchListener {

    static String artWayIndex;

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


    ChipListener chipListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            chipListener = (ChipListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement onClickImgListener");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_detail_pic, container, false);

        ImageView picImg = v.findViewById(R.id.detail_pic_img);
        TextView picName = v.findViewById(R.id.detail_pic_name);
        TextView picMaterial = v.findViewById(R.id.detail_pic_detail);
        ImageView imgBtn = v.findViewById(R.id.back_button);


        if (artWayIndex.equals("welcome")) {
            int picIndex = TopImgFragment.indexToPicDetail;
            picImg.setImageResource(topScreen[picIndex].getImageResourceId());
            picName.setText(topScreen[picIndex].getName());

            String picDetail = topScreen[picIndex].getMaterial() + "   " + (topScreen[picIndex].getSize()) + "   " +
                    (topScreen[picIndex].getYear());
            picMaterial.setText(picDetail);

        } else if (artWayIndex.equals("pics")) {
            int picIndex = GraphicImgFragment.indexToPicDetail;
            picImg.setImageResource(pics[picIndex].getImageResourceId());
            picName.setText(pics[picIndex].getName());

            String picDetail = pics[picIndex].getMaterial() + "   " + (pics[picIndex].getSize()) + "   " +
                    (pics[picIndex].getYear());
            picMaterial.setText(picDetail);

        } else if (artWayIndex.equals("painting")) {
            int picIndex = PaintImgFragment.indexToPicDetail;
            picImg.setImageResource(paint[picIndex].getImageResourceId());
            picName.setText(paint[picIndex].getName());

            String picDetail = paint[picIndex].getMaterial() + "   " + (paint[picIndex].getSize()) + "   " +
                    (paint[picIndex].getYear());
            picMaterial.setText(picDetail);

            // Back button
            imgBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getActivity().onBackPressed();
                }
            });
        }
        else if (artWayIndex.equals("photo")) {
            int picIndex = PhotoImgFragment.indexToPicDetail;
            picImg.setImageResource(photo[picIndex].getImageResourceId());
            picName.setText(photo[picIndex].getName());

            String picDetail = photo[picIndex].getMaterial() + "   " +
                    (photo[picIndex].getYear());
            picMaterial.setText(picDetail);

        } else if (artWayIndex.equals("about")) {
            int picIndex = 1;
            for (int i = 0; i < paint.length; i++) {
                if (paint[i].getImageResourceId() == AboutDetailFragment.paintIndex) {
                    picIndex = i;
                }
            }
            picImg.setImageResource(paint[picIndex].getImageResourceId());
            picName.setText(paint[picIndex].getName());

            String picDetail = paint[picIndex].getMaterial() + "   " +
                    (paint[picIndex].getYear());
            picMaterial.setText(picDetail);

            // Back button
            imgBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getActivity().onBackPressed();
                }
            });
        }
        else if (artWayIndex.equals("interview")) {
            int picIndex = 1;
            for (int i = 0; i < paint.length; i++) {
                if (paint[i].getImageResourceId() == InterviewDetailFragment.paintIndex) {
                    picIndex = i;
                }
            }
            picImg.setImageResource(paint[picIndex].getImageResourceId());
            picName.setText(paint[picIndex].getName());

            String picDetail = paint[picIndex].getMaterial() + "   " +
                    (paint[picIndex].getYear());
            picMaterial.setText(picDetail);

            // Back button
            imgBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getActivity().onBackPressed();
                }
            });
        }
        else if (artWayIndex.equals("bio")) {
            int picIndex = 1;
            for (int i = 0; i < paint.length; i++) {
                if (paint[i].getImageResourceId() == BioFragment.paintIndex) {
                    picIndex = i;
                }
            }
            picImg.setImageResource(paint[picIndex].getImageResourceId());
            picName.setText(paint[picIndex].getName());

            String picDetail = paint[picIndex].getMaterial() + "   " +
                    (paint[picIndex].getYear());
            picMaterial.setText(picDetail);

            // Back button
            imgBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getActivity().onBackPressed();
                }
            });

        } else if (artWayIndex.equals("recycle_paint")) {
            int picIndex = RecycleListFragment.positionPaint;
            picImg.setImageResource(paint[picIndex].getImageResourceId());
            picName.setText(paint[picIndex].getName());

            String picDetail = paint[picIndex].getMaterial() + "   " +
                    (paint[picIndex].getYear());
            picMaterial.setText(picDetail);

            // Back button
            imgBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    chipListener.chipClick();
                }
            });
        }


        picImg.setScaleType(ImageView.ScaleType.FIT_CENTER); // make the image fit to the center.
        picImg.setOnTouchListener(this);

        // Hiding toolbar
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).getSupportActionBar().hide();
        }



        return v;
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
                if (mode == DRAG) { //movement of first finger
                    matrix.set(savedMatrix);
                    if (view.getLeft() >= 0) {
                        matrix.postTranslate(event.getX() - start.x, event.getY() - start.y);
                    }
                } else if (mode == ZOOM) { //pinch zooming
                    float newDist = spacing(event);
                    if (newDist > 5f) {
                        matrix.set(savedMatrix);
                        scale = newDist / oldDist; // XXX may need to play with this value to limit it
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
        return (float) Math.sqrt(x * x + y * y);
    }

    private void midPoint(PointF point, MotionEvent event) {
        float x = event.getX(0) + event.getX(1);
        float y = event.getY(0) + event.getY(1);
        point.set(x / 2, y / 2);
    }



}
