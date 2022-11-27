## 环境
本程序应运行在windows操作系统

## 安装
jacob.jar是java连接COM的桥梁，可调用windows操作系统的api

jacob-1.20-xxx.dll文件复制到java运行环境的bin目录下，请按操作系统位数来选择32位或64位的dll

默认在C盘中创建VoiceStore目录，用于存放语音文件

## 运行
java -jar -Dvoice.spot=speaker1 -Dvoice.save=false bee-voice-2.0.0.jar

voice.spot是运行程序的站点编号，便于服务器能确认播放语音的客户端; voice.save默认不保存语音文件