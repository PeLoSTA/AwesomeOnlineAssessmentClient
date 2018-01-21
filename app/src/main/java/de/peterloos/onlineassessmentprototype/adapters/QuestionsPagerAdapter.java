package de.peterloos.onlineassessmentprototype.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.Locale;

import de.peterloos.onlineassessmentprototype.fragments.FragmentQuestion;
import de.peterloos.onlineassessmentprototype.models.QuestionSingleAnswer;

/**
 * Created by Peter on 20.01.2018.
 */

public class QuestionsPagerAdapter extends FragmentPagerAdapter {

    public QuestionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        // setup data for corresponding fragment
        QuestionSingleAnswer question = new QuestionSingleAnswer();
        String s = String.format(Locale.getDefault(), "Awesome %d. awesome Question", position);
        question.setQuestion(s);
        question.setNumberAnswers(3);
        question.setAnswers(new String[] {"Erste Antwort","Zweite Antwort", "Dritte Antwort"});
        question.setCorrectAnswer(1);
        question.setUsersAnswer(-1);

        // FragmentQuestion fragment = new FragmentQuestion();

        Fragment fragment = FragmentQuestion.newInstance(position + 1);
        Bundle bundle = new Bundle();
        bundle.putParcelable("QuestionSingleAnswer", question);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
