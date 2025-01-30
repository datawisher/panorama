package com.datawisher.face.recognition.login;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class FaceDetectionController {

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> handleFaceData(@RequestBody FaceData faceData) {

        // 处理人脸数据进行识别 (这里你可以调用人脸识别的模型或者其他的业务逻辑)
        boolean isFaceRecognized = recognizeFace(faceData);

        // 返回登录成功或失败的信息
        if (isFaceRecognized) {
            Map<String, String> map = new HashMap<>();
            map.put("message", "Login successful");
            return ResponseEntity.ok(map);
        } else {
            Map<String, String> map = new HashMap<>();
            map.put("message", "Face not recognized");
            return ResponseEntity.ok(map);
        }
    }

    private boolean recognizeFace(FaceData faceData) {
        // 在这里，你可以使用如 OpenCV、深度学习模型、机器学习方法进行实际的人脸识别
        // 示例中是一个简化的检查步骤，你可以替换为自己的识别逻辑

        // 简单的模拟：如果面部特征点的数量大于 5 个，认为人脸已识别
        return faceData.getFaceData().size() > 5;
    }
}
