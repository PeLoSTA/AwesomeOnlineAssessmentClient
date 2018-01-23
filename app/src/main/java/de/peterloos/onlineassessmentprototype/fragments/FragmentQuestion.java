package de.peterloos.onlineassessmentprototype.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import de.peterloos.onlineassessmentprototype.Globals;
import de.peterloos.onlineassessmentprototype.R;
import de.peterloos.onlineassessmentprototype.adapters.OnAnswerSelectedListener;
import de.peterloos.onlineassessmentprototype.adapters.SingleQuestionAdapter;
import de.peterloos.onlineassessmentprototype.models.SingleQuestionDescriptor;
import de.peterloos.onlineassessmentprototype.models.SingleAnswerDTO;

public class FragmentQuestion extends Fragment implements OnAnswerSelectedListener {

    public interface OnQuestionAnsweredListener {

        void answerSelected(int questionNumber, int answerPosition, boolean checked);
    }

    private TextView textviewQuestionHeader;
    private TextView textviewQuestion;
    private ListView listviewAnswers;
//
    // data of this question
    // TODO: Hmm, das kann man vielleicht mit 2, 3 Variablen besser lesbarer darstellen
    private SingleQuestionDescriptor question;

    public FragmentQuestion() {
        // no-args c'tor required
        this.listener = null;
    }

    public static FragmentQuestion newInstance() {

        return new FragmentQuestion();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_question, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.textviewQuestionHeader = view.findViewById(R.id.textviewQuestionHeader);
        this.textviewQuestion = view.findViewById(R.id.textviewQuestion);
        this.listviewAnswers = view.findViewById(R.id.listviewAnswers);

        // =============================================================================

        // extract this fragment's question from bundle
        Bundle bundle = this.getArguments();

        if (bundle != null) {
            this.question = bundle.getParcelable("SingleQuestionDescriptor");

            Log.v(Globals.TAG, "FragmentQuestion ==> Frage " + question.getQuestion());
        }
        else {
            this.question = new SingleQuestionDescriptor();
            this.question.setQuestionNumber(0);
            this.question.setQuestion("INTERNAL ERROR");
            this.question.setNumberAnswers(1);
            this.question.setAnswers(new String[] {"NO ANSWER"});
            this.question.setCorrectAnswer(0);

            // TODO: Die nächste Zeile möglicherweise freischalten
            // this.question.setUsersAnswers(new boolean[] {false});
        }

        // =============================================================================

        // setup UI
        int number = question.getQuestionNumber();
        String header = String.format(Locale.getDefault(),"Frage %d:", number);
        this.textviewQuestionHeader.setText(header);
        this.textviewQuestion.setText(question.getQuestion());

        // setup adapter for listview with answers and the latest user input according to this answer
        SingleAnswerDTO[] dtoAnswers = new SingleAnswerDTO[question.getNumberAnswers()];
        String[] answers = question.getAnswers();

        for (int i = 0; i < question.getNumberAnswers(); i++) {

            // HIER WEITER: value of antwort setzen !!!!!!!!!!!!!1

            SingleAnswerDTO dto =
                    new SingleAnswerDTO(
                            answers[i],
                            (question.getUsersAnswer(i)) ? 1 : 0);

            dtoAnswers[i] = dto;
        }

        SingleQuestionAdapter adapter = new SingleQuestionAdapter(this.getActivity(), dtoAnswers);
        adapter.setOnAnswerChanged (this);
        this.listviewAnswers.setAdapter(adapter);
    }

    @Override
    public void answerSelected(int position, boolean checked) {

        if (this.listener != null) {

            Log.v(Globals.TAG, "FragmentQuestion:: answerSelected ===> Frage = " + question.getQuestionNumber() + ", Antwort zu " + position + ", checked = " + checked);

            this.listener.answerSelected( question.getQuestionNumber(), position, checked);
        }
    }

    private OnQuestionAnsweredListener listener;

    @Override
    public void onAttach(Context context) {

        super.onAttach(context);
        try {
            this.listener = (OnQuestionAnsweredListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()  + " must implement OnQuestionAnsweredListener");
        }
    }

    @Override
    public void onDetach() {

        this.listener = null;
        super.onDetach();
    }

//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        // =============================================================================
//
//        // want LinearLayout as parent layout
//        LinearLayout ll = new LinearLayout(this.getContext());
//        ll.setOrientation(LinearLayout.VERTICAL);
//        LinearLayout.LayoutParams llLP = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.MATCH_PARENT);
//        ll.setLayoutParams(llLP);
//
//        // adding textview into layout
//        TextView tv = new TextView(this.getContext());
//        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT);
//
//        tv.setLayoutParams(lp);
//        tv.setPadding(8, 8, 8, 8);
//        ll.addView(tv);
//
//        ViewGroup viewGroup = (ViewGroup) view;
//        viewGroup.addView(ll);
//
//        // =============================================================================
//
//        // extract this fragment's question from bundle
//        Bundle bundle = this.getArguments();
//
//        SingleQuestionDescriptor question;
//
//        if (bundle != null) {
//            question = bundle.getParcelable("SingleQuestionDescriptor");
//        }
//        else {
//            question = new SingleQuestionDescriptor();
//            question.setQuestion("Internal Error");
//            question.setNumberAnswers(3);
//            question.setAnswers(new String[] {"","", ""});
//            question.setCorrectAnswer(1);
//            question.setUsersAnswer(-1);
//        }
//
//        // =============================================================================
//
//        // patch dynamically created UI with details of this questions
//        tv.setText(question.getQuestion());
//    }
}
