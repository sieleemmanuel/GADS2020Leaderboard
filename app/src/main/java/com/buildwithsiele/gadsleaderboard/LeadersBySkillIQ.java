package com.buildwithsiele.gadsleaderboard;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class LeadersBySkillIQ {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("score")
        @Expose
        private Integer score;
        @SerializedName("country")
        @Expose
        private String country;
        @SerializedName("badgeUrl")
        @Expose
        private String badgeUrl;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getScore() {
            return score;
        }

        public void setScore(Integer score) {
            this.score = score;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getBadgeUrl() {
            return badgeUrl;
        }

        public void setBadgeUrl(String badgeUrl) {
            this.badgeUrl = badgeUrl;
        }

}
