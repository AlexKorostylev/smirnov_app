package spain.barcelona.mydraw;

public class BizLogic {
    // input creative period from spiner
    final static int allPeriod = 0;
    final static int firstPeriod = 1;
    final static int secondPeriod = 2;
    final static int thirdPeriod = 3;
    final static int foursPeriod = 4;

    public static int picCountingPerPeriod(int inputPeriod, Pic[] dataArray) {
        int totalPicPerPeriod = 0;
        // Подсчет картин за период
        if (inputPeriod == 0) {
            totalPicPerPeriod = dataArray.length;
        } else {
            for (int i = 0; i < dataArray.length; i++) {
                int period = dataArray[i].getPeriod();
                if (period == inputPeriod) {
                    totalPicPerPeriod++;
                }
            }
        }
        return totalPicPerPeriod;
    }

    public static String dataForCounter(int inputPeriod, int picIndex, Pic[] dataArray) {
        // текущий номер картины по выбранному периоду.
        String indexCount = null;
        if (picIndex > 0) {
            indexCount = Integer.toString(picIndex + 1);
        }
        if (picIndex == 0) {
            indexCount = "1";
        }
        if (picIndex <= -1) {
            indexCount = Integer.toString(picCountingPerPeriod(inputPeriod, dataArray) - 1);
        }

        // всего картин за по выбранному периоду.
        String totalCount = Integer.toString(picCountingPerPeriod(inputPeriod, dataArray));
        // Строка счетчика
        return indexCount + " из " + totalCount;
    }

    public static int[] indexingAccordingMainArray(int inputPeriod, Pic[] dataArray) {
        int[] totalPicPerPeriod = new int[picCountingPerPeriod(inputPeriod, dataArray)];
        // Переиндексация относительно главного массива из Pic.paint[]
        for (int i = 0, y = 0; i < dataArray.length; i++) {
            if (inputPeriod == 0) {
                totalPicPerPeriod[y] = i;
                y++;
            }
            if (dataArray[i].getPeriod() == inputPeriod) {
                totalPicPerPeriod[y] = i;
                y++;
            }
        }
        return totalPicPerPeriod;
    }

    public static int positionAtArray(int inputPeriod, int indexPerPeriod, Pic[] dataArray) {
        int[] picPeriodArray = indexingAccordingMainArray(inputPeriod, dataArray);
        return picPeriodArray[indexPerPeriod];
    }

    // Checking increase counter for overload
    public static int incrementCheck(int inputPeriod, int picIndex, Pic[] dataArray) {
        ++picIndex;
        if (picIndex > picCountingPerPeriod(inputPeriod, dataArray) - 1) {
            picIndex = 0;
        }
        return picIndex;
    }

    // Checking decrease counter for download
    public static int decrementCheck(int inputPeriod, int picIndex, Pic[] dataArray) {
        --picIndex;
        if (picIndex <= -1) {
            picIndex = picCountingPerPeriod(inputPeriod, dataArray) - 1;
        }
        return picIndex;
    }
}

