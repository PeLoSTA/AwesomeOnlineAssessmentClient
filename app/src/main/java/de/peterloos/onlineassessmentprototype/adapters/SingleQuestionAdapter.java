package de.peterloos.onlineassessmentprototype.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import de.peterloos.onlineassessmentprototype.R;
import de.peterloos.onlineassessmentprototype.models.SingleAnswerDTO;

/**
 * Created by Peter on 21.01.2018.
 */

public class SingleQuestionAdapter extends ArrayAdapter<SingleAnswerDTO> {

    private SingleAnswerDTO[] items;
    private Context context;

    public SingleQuestionAdapter(@NonNull Context context, @NonNull SingleAnswerDTO[] items) {
        super(context, R.layout.question_row, items);   // ZWEIMAL WIRD DA DIE ROW ÜBERGEBVEN ?!?!?!

        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = ((Activity)this.context).getLayoutInflater();

        convertView = inflater.inflate(R.layout.question_row, parent, false);

        TextView textviewAnswer = convertView.findViewById(R.id.textViewAnswer);
        CheckBox cb = convertView.findViewById(R.id.checkBoxAnswer);

        textviewAnswer.setText(this.items[position].getAnswer());
        cb.setChecked(false);

        return convertView;
    }
}
