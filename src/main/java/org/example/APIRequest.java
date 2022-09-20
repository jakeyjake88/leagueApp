package org.example;

import java.awt.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.SwingConstants;

public class APIRequest extends JFrame{
    private String key;
    private String region;
    private HashMap<String, String> regions;
    private ArrayList<Object> soloDuo, flex;
    private JPanel contentPane, contentPane2;
    private JTextField searchPlayer;
    private JFrame rtFrame;

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    APIRequest frame = new APIRequest();
                    frame.setVisible(true);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public APIRequest(){
    key = "#HiddenForProtection";
    region = "";
    regions = new HashMap<String,String>(){{put("North America","na1");put("Oceania","oc1");put("Korea","kr");
        put("Europe Nordic & East","eun1");put("Europe West","euw1");put("Latin America North","la1");put("Turkey","tr1");
        put("Latin America South","la2");put("Japan","jp1");put("Russia","ru");put("Brazil","br1");}};
    soloDuo = new ArrayList<Object>();
    flex = new ArrayList<Object>();
    JFrameTest();
    }

    public void JFrameTest(){
        JFrame frame = new JFrame("JFrame Example");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JLabel label = new JLabel("JFrame By Example");
        JButton button = new JButton();
        button.setText("Button");
        panel.add(label);
        panel.add(button);
        frame.add(panel);
        frame.setSize(200, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void preparePage(){
        contentPane = new JPanel();
        contentPane.setForeground(Color.WHITE);
        contentPane.setBackground(Color.BLUE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel programTitle = new JLabel("Stats");
        programTitle.setForeground(Color.BLACK);
        programTitle.setFont(new Font("Ugly", Font.PLAIN, 14));
        programTitle.setBounds(68, 25, 397, 27);
        contentPane.add(programTitle);

        JLabel searchPlayerLabel = new JLabel("Search: ");
        searchPlayerLabel.setForeground(Color.BLACK);
        searchPlayerLabel.setFont(new Font("Airstrike", Font.PLAIN, 18));
        searchPlayerLabel.setBounds(10, 237, 167, 20);
        contentPane.add(searchPlayerLabel);

        searchPlayer = new JTextField();
        searchPlayer.setFont(new Font("Tahoma", Font.PLAIN, 14));
        searchPlayer.setForeground(Color.BLACK);
        searchPlayer.setBounds(174, 233, 185, 27);
        contentPane.add(searchPlayer);
        searchPlayer.setColumns(10);

        JLabel lblReg = new JLabel("Select Region:");
        lblReg.setForeground(Color.BLACK);
        lblReg.setFont(new Font("Airstrike", Font.PLAIN, 21));
        lblReg.setBounds(172, 80, 175, 14);
        contentPane.add(lblReg);
        prepareList();
    }

    public void prepareList()
    {
        JList<String> list = new JList<String>();
        list.setForeground(Color.BLACK);
        list.setBackground(new Color(102, 153, 204));
        list.setFont(new Font("Airstrike", Font.PLAIN, 15));
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setModel(new AbstractListModel<String>() {
            private static final long serialVersionUID = 1L;
            String[] values = new String[] {"North America", "Oceania", "Korea", "Europe Nordic & East", "Europe West",
                    "Latin America North", "Turkey", "Latin America South", "Japan", "Russia", "Brazil"};
            public int getSize()
            {
                return values.length;
            }
            public String getElementAt(int index)
            {
                return values[index];
            }
        });
        list.addListSelectionListener(new ListSelectionListener()
        {
            public void valueChanged(ListSelectionEvent e)
            {
                region = regions.get(list.getSelectedValue());
            }
        });
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setBounds(100, 110, 366, 94);
        contentPane.add(list);
    }

}
