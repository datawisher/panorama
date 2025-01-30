package com.datawisher.face.recognition.login;

import java.util.List;
import java.util.Map;

class FaceDataRequest {
    private List<Map<String, Double>> faceData;

    public List<Map<String, Double>> getFaceData() {
        return faceData;
    }

    public void setFaceData(List<Map<String, Double>> faceData) {
        this.faceData = faceData;
    }
}