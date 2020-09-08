package com.buildwithsiele.gadsleaderboard;


 import com.google.gson.annotations.Expose;
 import com.google.gson.annotations.SerializedName;

    class LeadersByHours {
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("hours")
        @Expose
        private Integer hours;
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

        public Integer getHours() {
            return hours;
        }

        public void setHours(Integer hours) {
            this.hours = hours;
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
