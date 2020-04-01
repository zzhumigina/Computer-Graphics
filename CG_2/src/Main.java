import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private JPanel rootPanel;
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenuItem jMenuItem;
    private JMenuBar jMenuBar;
    private  JTable table1;
    private JFileChooser fc;
    private JScrollPane jScrollPane;

    File[] data;

    private static String[] allowed_formats = {"pcx", "jpg", "gif", "tif", "bmp", "png"};

    String[] tags_ = {"Name", "Extension", "Compression Type", "Data Precision", "Height", "Width", "Res. Units", "X Res.", "Y Res."};
    String[] tags = {"Compression Type", "Data Precision", "Image Height", "Image Width", "Resolution Units", "X Resolution", "Y Resolution"};

    private void init(){

        table1.setModel(new javax.swing.table.DefaultTableModel(null, tags_) {
            Class[] types = new Class [] {java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class};
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
    }


    private static boolean isImage(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
            for (String frm: allowed_formats)
                if (frm.equals(ext))
                    return true;
        }
        return false;
    }

    public Main() {
        init();
        jMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                fc = new JFileChooser();
                //fc.showOpenDialog(rootPanel);
                fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                fc.setMultiSelectionEnabled(true);
                if (fc.showOpenDialog(rootPanel) == JFileChooser.APPROVE_OPTION) {
                    data = fc.getSelectedFiles();
                    ArrayList<File> inTable = new ArrayList<>();
                    for (File f : data) {
                        if (f.isDirectory()) {
                            for (File fd : f.listFiles()) {
                                if (isImage(fd)) {
                                    inTable.add(fd);
                                }
                            }
                        }
                        else{
                            if(isImage(f))
                                inTable.add(f);
                        }
                    }
                    Object[][] table = new String[inTable.size()][];
                    for(int i = 0; i < inTable.size(); ++i){
                        table[i] = getFileInfo(inTable.get(i));
                        String name = inTable.get(i).getName();
                        table[i][0] = name;
                        table[i][1] = "["+name.substring(name.lastIndexOf(".")+1) + "]";

                    }
                    table1.setModel(new DefaultTableModel(table, tags_));
                } else {
                    System.out.println("No Selection ");
                }
            }
        });
    }

    private String[] getFileInfo(File file){
        Metadata metadata = null;
        String[] ret = new String[tags.length+2];
        String fileName = file.getName();
        try {
            metadata = ImageMetadataReader.readMetadata(file);
            for (Directory directory : metadata.getDirectories()) {
                for (Tag tag : directory.getTags()) {
                    System.out.println(tag);
                    for(int i = 0; i < tags.length; ++i)
                        if(tag.getTagName().equals(tags[i]))
                            ret[i+2] = tag.getDescription();
                }
            }

        } catch (ImageProcessingException | IOException e) {
            e.printStackTrace();
        } finally {
            if(fileName.matches("\\d+�\\d+�\\d+[a-zA-Z0-9+]*\\.[a-zA-Z]+")){
                String[] data2 = fileName.split("\\.");
                String[] data = data2[0].split("�");
                ret[4] = data[0];
                ret[5] = data[1];
                ret[6] = "inch";
                String inch = "";

                int i = 0;
                for(; '0' <= data[2].charAt(i) && '9' >= data[2].charAt(i); ++i){
                    inch+= data[2].charAt(i);
                }
                ret[7] = inch;
                ret[8] = inch;
                ret[2] = data[2].substring(i);
            }
        }

        return ret;
    }


    public static void main(String[] args){
        JFrame frame = new JFrame("Main");
        frame.setContentPane(new Main().rootPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
