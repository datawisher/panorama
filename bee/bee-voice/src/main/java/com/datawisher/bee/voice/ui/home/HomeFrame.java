package com.datawisher.bee.voice.ui.home;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@Getter
@Setter
@Component
public class HomeFrame extends JFrame {

    private JTextField spotTxf;
    private JTextField volumeTxf;
    private JTextField rateTxf;
    private JComboBox<String> voiceCbx;
    private JTextArea testTextArea;
    private JTextField ratioTxf;
    private JTextField dirTxf;
    private JButton confirmBtn;
    private JButton testBtn;

    /**
     * Create the frame.
     */
    public HomeFrame() {
        initializeFrame();
    }

    private void initializeFrame() {
        // 初始化UI界面
        initUI();
        // 添加系统图标
        systemIcon();
        // 添加系统托盘
        systemTray();
        // 添加窗口监听
        windowListener();
    }

    private void initUI() {
        setResizable(false);
        setTitle("语音播放");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, 437, 504);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel tileLbl = new JLabel("功放语音播放");
        tileLbl.setFont(new Font("微软雅黑", Font.PLAIN, 26));
        tileLbl.setHorizontalAlignment(SwingConstants.CENTER);
        tileLbl.setBounds(105, 10, 240, 51);
        contentPane.add(tileLbl);

        JLabel spotLbl = new JLabel("站点");
        spotLbl.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        spotLbl.setBounds(24, 93, 38, 22);
        contentPane.add(spotLbl);

        spotTxf = new JTextField();
        spotTxf.setEditable(false);
        spotTxf.setBounds(62, 93, 119, 25);
        contentPane.add(spotTxf);
        spotTxf.setColumns(10);

        JLabel volumeLbl = new JLabel("音量");
        volumeLbl.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        volumeLbl.setBounds(248, 93, 38, 22);
        contentPane.add(volumeLbl);

        volumeTxf = new JTextField();
        volumeTxf.setColumns(10);
        volumeTxf.setBounds(283, 93, 119, 25);
        contentPane.add(volumeTxf);

        JLabel rateLbl = new JLabel("音速");
        rateLbl.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        rateLbl.setBounds(24, 151, 38, 22);
        contentPane.add(rateLbl);

        rateTxf = new JTextField();
        rateTxf.setColumns(10);
        rateTxf.setBounds(62, 151, 119, 25);
        contentPane.add(rateTxf);

        JLabel voiceLbl = new JLabel("音频");
        voiceLbl.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        voiceLbl.setBounds(248, 151, 38, 22);
        contentPane.add(voiceLbl);

        voiceCbx = new JComboBox();
        voiceCbx.setModel(new DefaultComboBoxModel(new String[]{"丢弃", "存储"}));
        voiceCbx.setFont(new Font("微软雅黑", Font.PLAIN, 10));
        voiceCbx.setBounds(283, 148, 119, 26);
        contentPane.add(voiceCbx);

        JLabel ratioLbl = new JLabel("倍率");
        ratioLbl.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        ratioLbl.setBounds(24, 207, 38, 22);
        contentPane.add(ratioLbl);

        ratioTxf = new JTextField();
        ratioTxf.setColumns(10);
        ratioTxf.setBounds(62, 207, 119, 25);
        contentPane.add(ratioTxf);

        JLabel pathLbl = new JLabel("路径");
        pathLbl.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        pathLbl.setBounds(245, 207, 38, 22);
        contentPane.add(pathLbl);

        dirTxf = new JTextField();
        dirTxf.setEditable(false);
        dirTxf.setColumns(10);
        dirTxf.setBounds(283, 207, 119, 25);
        contentPane.add(dirTxf);

        testTextArea = new JTextArea();
        testTextArea.setBounds(24, 277, 378, 104);
        contentPane.add(testTextArea);

        confirmBtn = new JButton("确定");
        confirmBtn.setFont(new Font("微软雅黑", Font.PLAIN, 10));
        confirmBtn.setBounds(76, 413, 71, 26);
        contentPane.add(confirmBtn);

        testBtn = new JButton("测试");
        testBtn.setFont(new Font("微软雅黑", Font.PLAIN, 10));
        testBtn.setBounds(252, 413, 71, 26);
        contentPane.add(testBtn);
    }

    private void systemIcon() {
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/chunhui-ico.png"));
        setIconImage(imageIcon.getImage());
    }

    private void systemTray() {
        if (SystemTray.isSupported()) {
            // 系统托盘菜单
            PopupMenu popupMenu = new PopupMenu();
            MenuItem openExit = new MenuItem("Open");
            openExit.addActionListener(e -> {
                if (!this.isShowing()) {
                    this.setVisible(true);
                }
            });
            popupMenu.add(openExit);
            MenuItem itemExit = new MenuItem("Exit");
            itemExit.addActionListener(e -> System.exit(0));
            popupMenu.add(itemExit);

            // 创建系统托盘
            ImageIcon icon = new ImageIcon(getClass().getResource("/chunhui-ico.png"));
            TrayIcon trayIcon = new TrayIcon(icon.getImage(), "语音播放", popupMenu);
            trayIcon.setImageAutoSize(true);
            trayIcon.addActionListener(e -> this.setVisible(true));

            try {
                SystemTray.getSystemTray().add(trayIcon);
            } catch (AWTException e1) {
                e1.printStackTrace();
            }
        }
    }

    private void windowListener() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                HomeFrame.this.setVisible(false);
            }
        });
    }


}
