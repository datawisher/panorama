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
    private JButton confirmBtn;
    private JButton testBtn;

    /**
     * Create the frame.
     */
    public HomeFrame() {
        initializeFrame();
    }

    private void initializeFrame() {
        setResizable(false);
        setTitle("语音播放");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, 450, 456);
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
        spotTxf.setBounds(62, 93, 119, 25);
        contentPane.add(spotTxf);
        spotTxf.setColumns(10);
        spotTxf.setEditable(false);

        JLabel volumeLbl = new JLabel("音量");
        volumeLbl.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        volumeLbl.setBounds(248, 93, 38, 22);
        contentPane.add(volumeLbl);

        volumeTxf = new JTextField();
        volumeTxf.setColumns(10);
        volumeTxf.setBounds(283, 93, 119, 25);
        contentPane.add(volumeTxf);

        JLabel rateLbl = new JLabel("速率");
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

        testTextArea = new JTextArea();
        testTextArea.setBounds(24, 231, 378, 104);
        contentPane.add(testTextArea);

        confirmBtn = new JButton("确定");
        confirmBtn.setFont(new Font("微软雅黑", Font.PLAIN, 10));
        confirmBtn.setBounds(78, 365, 71, 21);
        contentPane.add(confirmBtn);

        testBtn = new JButton("测试");
        testBtn.setFont(new Font("微软雅黑", Font.PLAIN, 10));
        testBtn.setBounds(248, 365, 71, 21);
        contentPane.add(testBtn);

        // 添加系统图标
        systemIcon();
        // 添加系统托盘
        systemTray();
        // 添加窗口监听
        windowListener();
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
