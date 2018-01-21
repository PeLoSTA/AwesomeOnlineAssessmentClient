package de.peterloos.onlineassessmentprototype.models;

/**
 * Created by Peter on 21.01.2018.
 */

public class SingleAnswerDTO {

    private String answer;       /* answer */
    private int value;           /* 0 -> checkbox disable, 1 -> checkbox enable */

    public SingleAnswerDTO(String answer, int value){
        this.answer = answer;
        this.value = value;
    }

    public String getAnswer(){
        return this.answer;
    }

    public int getValue(){
        return this.value;
    }
}
