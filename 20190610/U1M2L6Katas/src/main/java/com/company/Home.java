package com.company;

public class Home {

        private Basement basement;
        private Bathroom bathroom;
        private Kitchen kitchen;
        private Patio patio;
        private Bedroom bedroom;

        //default constructor

        public Home() {
        }


        //Getter And Setters

        public Basement getBasement() {
            return basement;
        }

        public void setBasement(Basement basement) {
            this.basement = basement;
        }

        public Bathroom getBathroom() {
            return bathroom;
        }

        public void setBathroom(Bathroom bathroom) {
            this.bathroom = bathroom;
        }

        public Kitchen getKitchen() {
            return kitchen;
        }

        public void setKitchen(Kitchen kitchen) {
            this.kitchen = kitchen;
        }

        public Patio getPatio() {
            return patio;
        }

        public void setPatio(Patio patio) {
            this.patio = patio;
        }

        public Bedroom getBedroom() {
            return bedroom;
        }

        public void setBedroom(Bedroom bedroom) {
            this.bedroom = bedroom;
        }
}
