package spain.barcelona.mydraw;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import static spain.barcelona.mydraw.Pic.paint;


public class PaintBtnFragment extends Fragment implements View.OnClickListener {

    // input creative period from spiner
    final int allPeriod = 0;
    int firstPeriod = 1;
    int secondPeriod = 2;
    int thirdPeriod = 3;
    int foursPeriod = 4;

    // start index counter number for paints per period
    int indexAllPeriod = -1;
    int indexFirstPeriod = -1;
    int indexSecondPeriod = -1;
    int indexThirdPeriod = -1;
    int indexFoursPeriod = -1;

    // Checking increase counter for overload
    public static int incrementCheck(int inputPeriod, int picIndex) {
        ++picIndex;
        if (picIndex > picCountingPerPeriod(inputPeriod) - 1) {
            picIndex = 0;
        }
        return picIndex;
    }

    // Checking decrease counter for download
    public static int decrementCheck(int inputPeriod, int picIndex) {
        --picIndex;
        if (picIndex <= -1) {
            picIndex = picCountingPerPeriod(inputPeriod) - 1;
        }
        return picIndex;
    }

    public static String dataForCounter(int inputPeriod, int picIndex) {
        // текущий номер картины по выбранному периоду.
        String indexCount = null;
        if (picIndex > 0) {
            indexCount = Integer.toString(picIndex + 1);
        }
        if (picIndex == 0) {
            indexCount = "1";
        }
        if (picIndex <= -1) {
            indexCount = Integer.toString(picCountingPerPeriod(inputPeriod) - 1);
        }

        // всего картин за по выбранному периоду.
        String totalCount = Integer.toString(picCountingPerPeriod(inputPeriod));
        // Строка счетчика
        return indexCount + " из " + totalCount;
    }

    public static int picCountingPerPeriod(int inputPeriod) {
        int totalPicPerPeriod = 0;
        // Подсчет картин за период
        if (inputPeriod == 0) {
            totalPicPerPeriod = paint.length;
        } else {
            for (int i = 0; i < Pic.paint.length; i++) {
                int period = paint[i].getPeriod();
                if (period == inputPeriod) {
                    totalPicPerPeriod++;
                }
            }
        }
        return totalPicPerPeriod;
    }

    public static int[] picIndexingAccordingMainArray(int inputPeriod) {
        int[] totalPicPerPeriod = new int[picCountingPerPeriod(inputPeriod)];
        // Переиндексация относительно главного массива из Pic.paint[]
        for (int i = 0, y = 0; i < Pic.paint.length; i++) {
            if (inputPeriod == 0) {
                totalPicPerPeriod[y] = i;
                y++;
            }
            if (paint[i].getPeriod() == inputPeriod) {
                totalPicPerPeriod[y] = i;
                y++;
            }
        }
        return totalPicPerPeriod;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_paint_btn, container, false);

        Button btnNext = v.findViewById(R.id.btn_next);
        btnNext.setOnClickListener(this);
        Button btnPrevious = v.findViewById(R.id.btn_previous);
        btnPrevious.setOnClickListener(this);

        // Picture counter for each period (заполнение счетчика по периуду
        TextView pictureCounter = v.findViewById(R.id.counter);
        indexAllPeriod = incrementCheck(allPeriod, indexAllPeriod);
        pictureCounter.setText(dataForCounter(allPeriod, indexAllPeriod));
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
        TextView picCounter = getActivity().findViewById(R.id.counter);
        Spinner artPeriod = getActivity().findViewById(R.id.art_type_paint);
        String selectedPeriod = String.valueOf(artPeriod.getSelectedItem());
        switch (selectedPeriod) {
            case "1972-2012":
                indexAllPeriod = incrementCheck(allPeriod, indexAllPeriod);
                dataТoScreenDisplay(allPeriod, indexAllPeriod);
                picCounter.setText(dataForCounter(allPeriod, indexAllPeriod));
                break;
            case "1972-1979":
                indexFirstPeriod = incrementCheck(firstPeriod, indexFirstPeriod);
                dataТoScreenDisplay(firstPeriod, indexFirstPeriod);
                picCounter.setText(dataForCounter(firstPeriod, indexFirstPeriod));
                break;
            case "1980-1989":
                indexSecondPeriod = incrementCheck(secondPeriod, indexSecondPeriod);
                dataТoScreenDisplay(secondPeriod, indexSecondPeriod);
                picCounter.setText(dataForCounter(secondPeriod, indexSecondPeriod));
                break;
            case "1990-1999":
                indexThirdPeriod = incrementCheck(thirdPeriod, indexThirdPeriod);
                dataТoScreenDisplay(thirdPeriod, indexThirdPeriod);
                picCounter.setText(dataForCounter(thirdPeriod, indexThirdPeriod));
                break;
            case "2000-2012":
                indexFoursPeriod = incrementCheck(foursPeriod, indexFoursPeriod);
                dataТoScreenDisplay(foursPeriod, indexFoursPeriod);
                picCounter.setText(dataForCounter(foursPeriod, indexFoursPeriod));
                break;
        }
    }

    public void onClickPrevious(View v) {
        TextView picCounter = getActivity().findViewById(R.id.counter);
        Spinner artPeriod = getActivity().findViewById(R.id.art_type_paint);
        String selectedPeriod = String.valueOf(artPeriod.getSelectedItem());
        switch (selectedPeriod) {
            case "1972-2012":
                indexAllPeriod = decrementCheck(allPeriod, indexAllPeriod);
                dataТoScreenDisplay(allPeriod, indexAllPeriod);
                picCounter.setText(dataForCounter(allPeriod, indexAllPeriod));
                break;
            case "1972-1979":
                indexFirstPeriod = decrementCheck(firstPeriod, indexFirstPeriod);
                dataТoScreenDisplay(firstPeriod, indexFirstPeriod);
                picCounter.setText(dataForCounter(firstPeriod, indexFirstPeriod));
                break;
            case "1980-1989":
                indexSecondPeriod = decrementCheck(secondPeriod, indexSecondPeriod);
                dataТoScreenDisplay(secondPeriod, indexSecondPeriod);
                picCounter.setText(dataForCounter(secondPeriod, indexSecondPeriod));
                break;
            case "1990-1999":
                indexThirdPeriod = decrementCheck(thirdPeriod, indexThirdPeriod);
                dataТoScreenDisplay(thirdPeriod, indexThirdPeriod);
                picCounter.setText(dataForCounter(thirdPeriod, indexThirdPeriod));
                break;
            case "2000-2012":
                indexFoursPeriod = decrementCheck(foursPeriod, indexFoursPeriod);
                dataТoScreenDisplay(foursPeriod, indexFoursPeriod);
                picCounter.setText(dataForCounter(foursPeriod, indexFoursPeriod));
                break;
        }
    }

    // метод, заполняющий данными макет
    public void dataТoScreenDisplay(int inputPeriod, int indexPerPeriod) {

        int[] picPeriodArray = picIndexingAccordingMainArray(inputPeriod);
        int picIndexAtMainArray = picPeriodArray[indexPerPeriod];

        ImageView image = getActivity().findViewById(R.id.info_image_paint);
        image.setImageResource(paint[picIndexAtMainArray].getImageResourceId());

        TextView nameText = getActivity().findViewById(R.id.name_text_paint);
        nameText.setText(paint[picIndexAtMainArray].getName());

// Логика для отображения деталей в названии картины. Например Холст, масло | 10х15 | 1978
        /*TextView detailText = getActivity().findViewById(R.id.detail_text_paint);
        String material = paint[periodPaintNo[serialNumPerPeriod]].getMaterial();
        String size = paint[periodPaintNo[serialNumPerPeriod]].getSize();
        String year = paint[periodPaintNo[serialNumPerPeriod]].getYear();
        String paintDescription;

        if (material.equals("")) {
            paintDescription = size + " | " + year;
            if (size.equals("")) {
                paintDescription = year;
            } else {
                paintDescription = size;
            }
        } else {
            if (size.equals("")) {
                paintDescription = material + " | " + year;
            } else{
                paintDescription = material + " | " + size;
                if (year.equals("")){
                } else {
                    paintDescription = material + " | " + size + " | " + year;
                }
            }
        }
        detailText.setText(paintDescription);
*/


    }
}




