package com.example.martoraneca.challengegenerator.data;

import com.example.martoraneca.challengegenerator.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FakeDataSource implements DataSourceInterface {

    private Random random;

    private String[] challenges = {
            "Wash the dishes",
            "Buy your dad a beer",
            "Do 30 push-ups",
            "Stop being distracted by your phone",
            "Clean your room",
            "Do 1 minute plank",
            "Don't do anything, I'm just testing big length text"
    };

    private String[] times = {
            "5 minutes",
            "15 minutes",
            "30 minutes",
            "1 hour",
            "6 hours",
            "1 day"
    };

    private int[] drawables = {
            R.drawable.red_drawable,
            R.drawable.blue_drawable,
            R.drawable.green_drawable,
            R.drawable.yellow_drawable
    };

    public FakeDataSource() {
        random = new Random();
    }

    @Override
    public List<ListItem> getListOfData() {

        ArrayList<ListItem> listOfData = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            listOfData.add(createNewListItem());

        }
        return listOfData;
    }

    //Create a ListItem with random challenge, time to do and drawable
    @Override
    public ListItem createNewListItem() {

        int randOne = random.nextInt(7);
        int randTwo = random.nextInt(6);
        int randThree = random.nextInt(4);

        return new ListItem(
                challenges[randOne],
                times[randTwo],
                drawables[randThree]
        );
    }
}
