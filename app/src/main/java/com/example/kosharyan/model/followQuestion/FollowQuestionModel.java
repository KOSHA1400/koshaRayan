package com.example.kosharyan.model.followQuestion;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FollowQuestionModel implements Serializable {



        @SerializedName("state")
        @Expose
        private String state;
        @SerializedName("number of answers")
        @Expose
        private Integer numberOfAnswers;

        public String getState() {
        return state;
    }

        public void setState(String state) {
        this.state = state;
    }

        public Integer getNumberOfAnswers() {
        return numberOfAnswers;
    }

        public void setNumberOfAnswers(Integer numberOfAnswers) {
        this.numberOfAnswers = numberOfAnswers;
    }


}
