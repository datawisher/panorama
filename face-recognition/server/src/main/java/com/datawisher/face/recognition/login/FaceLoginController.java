package com.datawisher.face.recognition.login;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.opencv.opencv_java;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.face.LBPHFaceRecognizer;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FaceLoginController {

    Logger logger = LoggerFactory.getLogger(FaceLoginController.class);

    @CrossOrigin
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody FaceDataRequest request) {
        // 获取客户端传来的特征数据
        List<Map<String, Double>> faceData = request.getFaceData();

        // 加载已有的模型进行匹配（假设模型已经训练好）
        boolean isMatched = matchFace(faceData);

        Map<String, String> map = new HashMap<>();
        if (isMatched) {
            // 登录成功
            map.put("message", "Login Successful");
            return map;
        } else {
            // 登录失败
            map.put("message", "Login Failed. Face not recognized.");
            return map;
        }
    }

    private boolean matchFace(List<Map<String, Double>> faceData) {
        //  加载 OpenCV 库
        Loader.load(opencv_java.class);

        // 初始化 LBPHFaceRecognizer
        LBPHFaceRecognizer faceRecognizer = LBPHFaceRecognizer.create();
        // 加载预训练的 LBPH 模型
        faceRecognizer.read("D:\\lbph_face_model.xml");

        // 将前端传递的人脸数据转换为 OpenCV 的 Mat 格式
        Mat faceMat = convertFaceDataToMat(faceData);

        // 人脸检测
        CascadeClassifier faceDetector  = new CascadeClassifier("D:\\haarcascade_frontalface_default.xml");
        MatOfRect faces = new MatOfRect();
        faceDetector.detectMultiScale(faceMat, faces);

        if (faces.toArray().length > 0) {
            // 检测到人脸
            Rect face = faces.toArray()[0]; // 选择第一个检测到的面部

            // 对面部区域进行识别
            Mat faceRegion = new Mat(faceMat, face); // 获取人脸区域
            int prediction = faceRecognizer.predict_label(faceRegion); // 预测标签

            // 根据预测的标签进行判断，0表示识别成功
            return prediction == 0; // 根据实际情况返回相应的值
        } else {
            return false; // 没有检测到人脸
        }
    }

    private Mat convertFaceDataToMat(List<Map<String, Double>> faceData) {
        // 假设每个点为二维坐标(x, y)，将其转换为OpenCV的Mat矩阵
        Mat mat = new Mat(faceData.size(), 1, CvType.CV_32FC2);

        // 将人脸数据绘制到 Mat 中
        for (int i = 0; i < faceData.size(); i++) {
            Map<String, Double> point = faceData.get(i);
            mat.put(i, 0, point.get("x"), point.get("y")); // 填充点数据
        }

        return mat;
    }
}

