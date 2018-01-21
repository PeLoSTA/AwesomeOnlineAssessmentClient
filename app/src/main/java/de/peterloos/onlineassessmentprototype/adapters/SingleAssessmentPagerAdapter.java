package de.peterloos.onlineassessmentprototype.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import de.peterloos.onlineassessmentprototype.Globals;
import de.peterloos.onlineassessmentprototype.fragments.FragmentQuestion;
import de.peterloos.onlineassessmentprototype.models.SingleQuestionDescriptor;

/**
 * Created by Peter on 20.01.2018.
 */

public class SingleAssessmentPagerAdapter extends FragmentPagerAdapter {

    private final int MaxQuestions = 10;

    private SingleQuestionDescriptor[] exam;

    public SingleAssessmentPagerAdapter(FragmentManager fm) {
        super(fm);

        this.setupExam();
    }

//    @Override
//    public Fragment getItem(int position) {
//
//        // setup data for corresponding fragment
//        SingleQuestionDescriptor question = new SingleQuestionDescriptor();
//        String s = String.format(Locale.getDefault(), "Awesome %d. question", position);
//        question.setQuestion(s);
//        question.setNumberAnswers(3);
//        question.setAnswers(new String[] {"Erste Antwort","Zweite Antwort", "Dritte Antwort"});
//        question.setCorrectAnswer(1);
//        question.setUsersAnswer(-1);
//
//        // FragmentQuestion fragment = new FragmentQuestion();
//
//        Fragment fragment = FragmentQuestion.newInstance();
//        Bundle bundle = new Bundle();
//        bundle.putParcelable("SingleQuestionDescriptor", question);
//        fragment.setArguments(bundle);
//        return fragment;
//    }

    @Override
    public Fragment getItem(int position) {

        Log.v(Globals.TAG, "getItem at " + position + " called !!!" );

        // setup data for corresponding fragment
        SingleQuestionDescriptor question = this.exam[position];

        Fragment fragment = FragmentQuestion.newInstance();
        Bundle bundle = new Bundle();
        bundle.putParcelable("SingleQuestionDescriptor", question);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return MaxQuestions;
    }

    // private helper methods
    private  void setupExam () {

        this.exam = new SingleQuestionDescriptor[MaxQuestions];

        SingleQuestionDescriptor dsc1 = new SingleQuestionDescriptor();
        dsc1.setQuestionNumber(1);
        dsc1.setQuestion("Wieviel ist 1 + 1?");
        dsc1.setNumberAnswers(4);
        dsc1.setAnswers(new String[] { "3", "1", "0", "2"});
        dsc1.setCorrectAnswer(3);

        SingleQuestionDescriptor dsc2 = new SingleQuestionDescriptor();
        dsc2.setQuestionNumber(2);
        dsc2.setQuestion("Wieviel ist 2 - 1?");
        dsc2.setNumberAnswers(4);
        dsc2.setAnswers(new String[] { "1", "0", "2", "Keine dieser Antworten ist korrekt"});
        dsc2.setCorrectAnswer(0);

        SingleQuestionDescriptor dsc3 = new SingleQuestionDescriptor();
        dsc3.setQuestionNumber(3);
        dsc3.setQuestion("Wie viele Mitgliedstaaten hat die Europäische Union?");
        dsc3.setNumberAnswers(5);
        dsc3.setAnswers(new String[] { "14", "17", "24", "27", "29"});
        dsc3.setCorrectAnswer(3);

        SingleQuestionDescriptor dsc4 = new SingleQuestionDescriptor();
        dsc4.setQuestionNumber(4);
        dsc4.setQuestion("Wie heißt die Hauptstadt von Frankreich?");
        dsc4.setNumberAnswers(3);
        dsc4.setAnswers(new String[] { "Marseille", "Paris", "Brüssel"  });
        dsc4.setCorrectAnswer(1);

        SingleQuestionDescriptor dsc5 = new SingleQuestionDescriptor();
        dsc5.setQuestionNumber(5);
        dsc5.setQuestion("Wann wurde die Europäische Union gegründet?");
        dsc5.setNumberAnswers(7);
        dsc5.setAnswers(new String[] { "01. Januar 1990", "01. Dezember 1991", "01. April 1992", "01. November 1993", "01. Juli 1994", "01. Februar 1995", "01. Dezember 1996" });
        dsc5.setCorrectAnswer(3);

        SingleQuestionDescriptor dsc6 = new SingleQuestionDescriptor();
        dsc6.setQuestionNumber(6);
        dsc6.setQuestion("Wie heißt das berühmte Bauwerk in Rom, wo die Gladiatoren kämpften?");
        dsc6.setNumberAnswers(4);
        dsc6.setAnswers(new String[] { "Forum Romanum", "Fontana di Trevi", "Colosseo", "Piazza Popolo"  });
        dsc6.setCorrectAnswer(2);

        SingleQuestionDescriptor dsc7 = new SingleQuestionDescriptor();
        dsc7.setQuestionNumber(7);
        dsc7.setQuestion("Wie viele Sterne hat die EU-Flagge?");
        dsc7.setNumberAnswers(11);
        dsc7.setAnswers(new String[] { "5 Sterne", "6 Sterne", "7 Sterne", "8 Sterne", "9 Sterne", "10 Sterne", "11 Sterne", "12 Sterne",  "13 Sterne", "14 Sterne", "15 Sterne" });
        dsc7.setCorrectAnswer(7);

        SingleQuestionDescriptor dsc8 = new SingleQuestionDescriptor();
        dsc8.setQuestionNumber(8);
        dsc8.setQuestion("Welches französische Denkmal steht in Paris und ist 327 Meter hoch?");
        dsc8.setNumberAnswers(5);
        dsc8.setAnswers(new String[] { "Chinesische Turm", "Empire State Building", "Eiffellturm", "Türme von Hanoi", "Sinwellturm" });
        dsc8.setCorrectAnswer(2);

        SingleQuestionDescriptor dsc9 = new SingleQuestionDescriptor();
        dsc9.setQuestionNumber(9);
        dsc9.setQuestion(" Gehört Finnland der Europäischen Union an?");
        dsc9.setNumberAnswers(2);
        dsc9.setAnswers(new String[] { "Ja", "Nein" });
        dsc9.setCorrectAnswer(0);

        SingleQuestionDescriptor dsc10 = new SingleQuestionDescriptor();
        dsc10.setQuestionNumber(10);
        dsc10.setQuestion("Wie heißt die Hauptstadt von Portugal?");
        dsc10.setNumberAnswers(4);
        dsc10.setAnswers(new String[] { "Barcelona", "Lissabon", "Porto", "La Valetta" });
        dsc10.setCorrectAnswer(3);

        this.exam[0] = dsc1;
        this.exam[1] = dsc2;
        this.exam[2] = dsc3;
        this.exam[3] = dsc4;
        this.exam[4] = dsc5;
        this.exam[5] = dsc6;
        this.exam[6] = dsc7;
        this.exam[7] = dsc8;
        this.exam[8] = dsc9;
        this.exam[9] = dsc10;
    }
}
