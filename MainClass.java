
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Manvendra
 */
public class MainClass extends Frame {

    public static void main(String args[]) {
        MainClass f = new MainClass();
        f.setUndecorated(true);
        f.setVisible(true);
       
        f.putDrives();
    }
    public JButton jb1;
    public JLabel l,p,r;
    File[] drives;
    FileSystemView fsv;
    public File f = null;

    public MainClass() {

        p=new JLabel("_________*_________");
        l=new JLabel("External Drive Detector!!");
        r=new JLabel("___________________");

        BoxLayout layout = new BoxLayout(this, ICONIFIED);
        setLayout(layout);
        add(p);
        add(l);add(r);
        jb1 = new JButton("Close");

        jb1.setBounds(50, 50, 100, 30);
        add(jb1);
        setSize(140, 250);
        
        setLocationRelativeTo(null);
        drives = File.listRoots();
        fsv = FileSystemView.getFileSystemView();
        setBackground(Color.lightGray);
    }

    public void putDrives() {
        if (drives != null && drives.length > 0) {
            for (File aDrive : drives) {
                String driveType = fsv.getSystemTypeDescription(aDrive);
                String s1 = FileSystemView.getFileSystemView().getSystemDisplayName(aDrive);
                if (driveType.equals("Removable Disk")) {
                    System.out.println(aDrive);
                    System.out.println(s1);
                    l = new JLabel(s1);
                    add(l);
                    revalidate();
                }

            }
        }

        Alpha a = new Alpha();
        jb1.addActionListener(a);
        revalidate();
    }

    public class Alpha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

}
