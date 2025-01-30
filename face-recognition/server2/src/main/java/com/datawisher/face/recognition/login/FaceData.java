package com.datawisher.face.recognition.login;

import java.util.List;

public class FaceData {
    private List<Point> faceData;

    public List<Point> getFaceData() {
        return faceData;
    }

    public void setFaceData(List<Point> faceData) {
        this.faceData = faceData;
    }

    public static class Point {
        private float x;
        private float y;

        public float getX() {
            return x;
        }

        public void setX(float x) {
            this.x = x;
        }

        public float getY() {
            return y;
        }

        public void setY(float y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}