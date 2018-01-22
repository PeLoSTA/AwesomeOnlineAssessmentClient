package de.peterloos.onlineassessmentprototype.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;

import de.peterloos.onlineassessmentprototype.R;
import de.peterloos.onlineassessmentprototype.models.SingleAnswerDTO;

/**
 * Created by Peter on 21.01.2018.
 */

public class SingleQuestionAdapter extends ArrayAdapter<SingleAnswerDTO> {

    private SingleAnswerDTO[] items;
    private Context context;

    private OnAnswerSelectedListener listener;

    public SingleQuestionAdapter(@NonNull Context context, @NonNull SingleAnswerDTO[] items) {
        super(context, R.layout.question_row, items);

        this.context = context;
        this.items = items;
    }

    // public interface
    public void setOnAnswerChanged (OnAnswerSelectedListener listener) {

        this.listener = listener;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolderItem viewHolder;
        if (convertView == null) {

            // inflate the layout
            LayoutInflater inflater = ((Activity) this.context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.question_row, parent, false);

            // setup ViewHolder object
            viewHolder = new ViewHolderItem();
            viewHolder.checkbox = convertView.findViewById(R.id.checkBoxAnswer);

            // store the holder within the view
            convertView.setTag(viewHolder);
        } else {

            // ViewHolderItem object has been created before
            viewHolder = (ViewHolderItem) convertView.getTag();
        }

        viewHolder.checkbox.setText(this.items[position].getAnswer());
        viewHolder.checkbox.setChecked(false);
        viewHolder.checkbox.setTag(new Integer(position));

        viewHolder.checkbox.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                CheckBox cb = (CheckBox) view;
                int pos = ((Integer) cb.getTag()).intValue();
                if (listener != null) {

                    listener.answerSelected(pos, cb.isChecked());
                }
            }
        });

        return convertView;
    }

    private static class ViewHolderItem {
        public CheckBox checkbox;
    }
}
