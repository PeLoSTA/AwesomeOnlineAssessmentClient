package de.peterloos.onlineassessmentprototype.fragments;

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

    private TextView textviewQuestionHeader;
    private TextView textviewQuestion;
    private ListView listviewAnswers;

    public FragmentQuestion() {
        // no-args c'tor required
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

        SingleQuestionDescriptor question;

        if (bundle != null) {
            question = bundle.getParcelable("SingleQuestionDescriptor");

            Log.v(Globals.TAG, "FragmentQuestion ==> Frage " + question.getQuestion());
        }
        else {
            question = new SingleQuestionDescriptor();
            question.setQuestionNumber(0);
            question.setQuestion("INTERNAL ERROR");
            question.setNumberAnswers(1);
            question.setAnswers(new String[] {"NO ANSWER"});
            question.setCorrectAnswer(0);
            question.setUsersAnswer(-1);
        }

        // =============================================================================

        // setup UI
        int number = question.getQuestionNumber();
        String header = String.format(Locale.getDefault(),"Frage %d:", number);
        this.textviewQuestionHeader.setText(header);
        this.textviewQuestion.setText(question.getQuestion());

        SingleAnswerDTO[] dtoAnswers = new SingleAnswerDTO[question.getNumberAnswers()];
        String[] answers = question.getAnswers();
        for (int i = 0; i < question.getNumberAnswers(); i++) {
            SingleAnswerDTO dto = new SingleAnswerDTO(answers[i], 0);
            dtoAnswers[i] = dto;
        }
        SingleQuestionAdapter adapter = new SingleQuestionAdapter(this.getActivity(), dtoAnswers);
        adapter.setOnAnswerChanged (this);
        this.listviewAnswers.setAdapter(adapter);
    }

    @Override
    public void answerSelected(int position, boolean checked) {

        Toast.makeText(
                this.getContext(),
                "Clicked on Checkbox: Position " + position + " is " + checked,
                Toast.LENGTH_LONG).show();
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
