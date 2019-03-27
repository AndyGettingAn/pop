package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Editor extends JFrame implements ActionListener {
    private JPanel myContents;
    private JScrollPane textView;
    private JPanel controlView;
    private SmartAgentLanguage mysal;
    private JTextArea sourceCode;
    private JFileChooser fc;

    public Editor(SmartAgentLanguage sal) {
        super("POP Editor");

        fc = new JFileChooser();
        fc.setCurrentDirectory(new File("/Users/bdludwig/Dropbox/workspace/VL_POP"));

        mysal = sal;
        myContents = new JPanel(new GridLayout(1, 0));

        //Create the scroll pane and add the tree to it.
        textView = new JScrollPane(sourceCode = new JTextArea());
        sourceCode.setTabSize(2);

        //Create the behavior tree display.
        controlView = new JPanel();
        controlView.setLayout(new BoxLayout(controlView, BoxLayout.X_AXIS));

        JButton b;
        b = new JButton("Load");
        b.addActionListener(this);
        controlView.add(b);

        b = new JButton("Save");
        b.addActionListener(this);
        controlView.add(b);

        b = new JButton("Start");
        b.addActionListener(this);
        controlView.add(b);

        //Add the scroll panes to a split pane.
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPane.setTopComponent(textView);
        splitPane.setBottomComponent(controlView);

        textView.setPreferredSize(new Dimension(500, 250));

        //Add the split pane to this panel.
        myContents.add(splitPane);

        this.setContentPane(myContents);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton uielement = (JButton)e.getSource();

            if(uielement.getText().equals("Load")) {
                fc.showOpenDialog(this);
                if (fc.getSelectedFile() != null) {
                    try {
                        sourceCode.setText(new String(Files.readAllBytes(Paths.get(fc.getSelectedFile().getPath()))));
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
            else if(uielement.getText().equals("Save")) {
                fc.showSaveDialog(this);
                if (fc.getSelectedFile() != null) {
                    try {
                        PrintWriter w;
                        w = new PrintWriter(fc.getSelectedFile());
                        w.print(sourceCode.getText());
                        w.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
            else if(uielement.getText().equals("Start")) {
                mysal.executeCode(new ByteArrayInputStream(sourceCode.getText().getBytes()));
            }
            else {
                System.out.println("Unknown UI Element: " + uielement.getText());
            }
        }
    }
}