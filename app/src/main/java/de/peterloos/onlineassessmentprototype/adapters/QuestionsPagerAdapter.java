package de.peterloos.onlineassessmentprototype.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import de.peterloos.onlineassessmentprototype.fragments.FragmentQuestion;

/**
 * Created by Peter on 20.01.2018.
 */

public class QuestionsPagerAdapter extends FragmentPagerAdapter {

    public QuestionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.

        Fragment f = FragmentQuestion.newInstance(position + 1);

        return f;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
