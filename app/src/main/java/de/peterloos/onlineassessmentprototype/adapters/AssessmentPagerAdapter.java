package de.peterloos.onlineassessmentprototype.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.Locale;

import de.peterloos.onlineassessmentprototype.fragments.FragmentQuestion;
import de.peterloos.onlineassessmentprototype.models.SingleQuestionDescriptor;

/**
 * Created by Peter on 20.01.2018.
 */

public class AssessmentPagerAdapter extends FragmentPagerAdapter {

    public AssessmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        // setup data for corresponding fragment
        SingleQuestionDescriptor question = new SingleQuestionDescriptor();
        String s = String.format(Locale.getDefault(), "Awesome %d. question", position);
        question.setQuestion(s);
        question.setNumberAnswers(3);
        question.setAnswers(new String[] {"Erste Antwort","Zweite Antwort", "Dritte Antwort"});
        question.setCorrectAnswer(1);
        question.setUsersAnswer(-1);

        // FragmentQuestion fragment = new FragmentQuestion();

        Fragment fragment = FragmentQuestion.newInstance();
        Bundle bundle = new Bundle();
        bundle.putParcelable("SingleQuestionDescriptor", question);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
