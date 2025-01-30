package com.datawisher.face.recognition.trainer;


import java.io.File;
import java.util.Objects;

import org.bytedeco.opencv.opencv_core.MatVector;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.face.FisherFaceRecognizer;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.utils.Converters;

public class ModelTrainer {

    public static void main(String[] args) {
        // 加载 OpenCV 库
//        Loader.load(opencv_java.class);
        // 创建 LBPH 人脸识别器
        FisherFaceRecognizer faceRecognizer = FisherFaceRecognizer.create();

        // 存储训练图片和标签（用户ID）
        MatVector images = new MatVector();
        Mat lables = new Mat();

        // 加载训练数据：读取存放训练数据的文件夹
        File dir = new File(Objects.requireNonNull(ModelTrainer.class.getResource("/train_data/")).getPath());
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                // 读取图片
                Mat img = Imgcodecs.imread(file.getAbsolutePath());
                if (img.empty()) {
                    System.out.println("无法加载图像: " + file.getAbsolutePath());
                    continue;
                }
                images.push_back(img);

                // 转换为灰度图像
                Mat grayImage = new Mat();
                Imgproc.cvtColor(img, grayImage, Imgproc.COLOR_BGR2GRAY);

                // 加载 Haar 级联分类器
                CascadeClassifier faceDetector = new CascadeClassifier("D:\\haarcascade_frontalface_default.xml");
                //                faceDetector.load(Objects.requireNonNull(LBPHFaceTrainer.class.getResource("/haarcascade_frontalface_default.xml")).getPath());

                // 检测人脸
                MatOfRect faceDetections = new MatOfRect();
                faceDetector.detectMultiScale(grayImage, faceDetections);

                // 如果检测到人脸，返回第一个人脸区域
                if (faceDetections.toArray().length > 0) {
                    Rect rect = faceDetections.toArray()[0];
                    img = new Mat(grayImage, rect); // 返回裁剪后的人脸区域
                } else {
                    System.out.println("未检测到人脸: " + file.getAbsolutePath());
                    continue;
                }

                // 调整图片大小
                Imgproc.resize(img, img, new Size(200, 200));  // 统一图片大小

                // 获取标签：假设文件名为 userID.jpg 格式
                int label = Integer.parseInt(file.getName().split("\\.")[0]);

                // 添加图片和标签到列表
                images.add(img);
                labels.add(label);
            }
        }

        // 训练 LBPH 模型
        recognizer.train(images, Converters.vector_int_to_Mat(labels));

        // 保存模型到文件
        recognizer.save("lbph_face_model.xml");

        System.out.println("Model training complete!");
    }
}
