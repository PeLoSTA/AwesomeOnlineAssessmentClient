package de.peterloos.onlineassessmentprototype.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Peter on 20.01.2018.
 */

public class SingleQuestionDescriptor implements Parcelable {

    /**
     * static field used to regenerate object, individually or as array
     */
    public static final Parcelable.Creator<SingleQuestionDescriptor> CREATOR =
            new Parcelable.Creator<SingleQuestionDescriptor>() {
                public SingleQuestionDescriptor createFromParcel(Parcel pc) {
                    return new SingleQuestionDescriptor(pc);
                }

                public SingleQuestionDescriptor[] newArray(int size) {
                    return new SingleQuestionDescriptor[size];
                }
            };

    // member data
    private int questionNumber;
    private String question;
    private int numberAnswers;
    private String[] answers;
    private int correctAnswer;
    // private int usersAnswer;
    private boolean[] usersAnswers;

    // no-args c'tor
    public SingleQuestionDescriptor() {
    }

    /**
     * c'tor from Parcel, reads back fields IN THE ORDER they were written
     */
    public SingleQuestionDescriptor(Parcel pc) {
        this.questionNumber = pc.readInt();
        this.question = pc.readString();
        this.numberAnswers = pc.readInt();
        pc.readStringArray(this.answers);
        this.correctAnswer = pc.readInt();
        pc.readBooleanArray(this.usersAnswers);
    }

    // getter / setter methods
    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getNumberAnswers() {
        return numberAnswers;
    }

    public void setNumberAnswers(int numberAnswers) {
        this.numberAnswers = numberAnswers;

        // allocate array of boolean values according to user's answers
        this.usersAnswers = new boolean[this.numberAnswers];
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public boolean getUsersAnswer(int index) {
        return usersAnswers[index];
    }

    public void setUsersAnswer(int index, boolean value) {
        usersAnswers[index] = value;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(this.questionNumber);
        parcel.writeString(this.question);
        parcel.writeInt(this.numberAnswers);
        parcel.writeStringArray(this.answers);
        parcel.writeInt(this.correctAnswer);
        parcel.writeBooleanArray(this.usersAnswers);
    }
}
