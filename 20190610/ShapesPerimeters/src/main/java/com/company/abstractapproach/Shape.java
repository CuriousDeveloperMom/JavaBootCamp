package com.company.abstractapproach;

public abstract class Shape {
        private String name;
        private String color;
        private int xCoOrdinate;

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getColor() {
                return color;
        }

        public void setColor(String color) {
                this.color = color;
        }

        public int getxCoOrdinate() {
                return xCoOrdinate;
        }

        public void setxCoOrdinate(int xCoOrdinate) {
                this.xCoOrdinate = xCoOrdinate;
        }

        public int getyCoOrdinate() {
                return yCoOrdinate;
        }

        public void setyCoOrdinate(int yCoOrdinate) {
                this.yCoOrdinate = yCoOrdinate;
        }

        private int yCoOrdinate;

        public abstract void perimeter();

        public abstract void area();



}
