package de.peterloos.onlineassessmentprototype.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Locale;

import de.peterloos.onlineassessmentprototype.R;
import de.peterloos.onlineassessmentprototype.models.QuestionSingleAnswer;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentQuestion extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    public FragmentQuestion() {
        // Required empty public constructor
    }

    public static FragmentQuestion newInstance(int sectionNumber) {

        QuestionSingleAnswer question = new QuestionSingleAnswer();

        String s = String.format(Locale.getDefault(), "And this is the %d. awesome Question", sectionNumber);
        question.setQuestion(s);
        question.setNumberAnswers(3);
        question.setAnswers(new String[] {"Erste Antwort","Zweite Antwort", "Dritte Antwort"});
        question.setCorrectAnswer(1);
        question.setUsersAnswer(-1);

        FragmentQuestion fragment = new FragmentQuestion();
        Bundle bundle = new Bundle();
        bundle.putParcelable("QuestionSingleAnswer", question);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_activity_pass_exam, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.section_label);

        textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));

        Bundle bundle = this.getArguments();

        QuestionSingleAnswer question;

        if (bundle != null) {
            question = bundle.getParcelable("QuestionSingleAnswer");
        }
        else {
            question = new QuestionSingleAnswer();
            question.setQuestion("Internal Error");
            question.setNumberAnswers(3);
            question.setAnswers(new String[] {"","", ""});
            question.setCorrectAnswer(1);
            question.setUsersAnswer(-1);
        }

        // int number = args.getInt(ARG_SECTION_NUMBER);
        // String title = String.format(Locale.getDefault(), getString(R.string.section_format), number );
        textView.setText(question.getQuestion());
        return rootView;
    }

}
