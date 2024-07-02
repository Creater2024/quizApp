package com.quizApp.quiz.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JSONObject {
        private String status;
        private int code;
        private String message;
        private Object data;
        private boolean value = true;

        public JSONObject(int statusCode) {
            this.code = statusCode;
        }

        public JSONObject(int statusCode, String message) {
            this.code = statusCode;
            this.message = message;
        }

        public JSONObject(String status, int statusCode, String message) {
            this.code = statusCode;
            this.message = message;
            this.status = status;
        }

        public JSONObject(String status, int statusCode, String message, Object data, boolean value) {
            this.code = statusCode;
            this.message = message;
            this.status = status;
            this.data = data;
            this.value = value;

        }

        public JSONObject(String status, int statusCode, String message, Object data) {
            this.code = statusCode;
            this.message = message;
            this.status = status;
            this.data = data;

        }


    }
