import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.RescaleOp;
import java.io.*;
import java.util.Collection;
import static java.lang.Float.parseFloat;

public class ImageViewerGUI extends JFrame implements ActionListener{
    JButton selectFileButton = new JButton();
    JButton showImageButton = new JButton();
    JButton resizeButton = new JButton();
    JButton grayscaleButton = new JButton();
    JButton brightnessButton = new JButton();
    JButton closeButton = new JButton();
    JButton showResizeButton = new JButton();
    JButton showBrightnessButton = new JButton();
    JButton backButton = new JButton();
    JTextField widthTextField = new JTextField();
    JTextField heightTextField = new JTextField();
    JTextField brightnessTextField = new JTextField();
    JLabel pictureLabel = new JLabel();
    String filePath = "\\Users\\kiana\\OneDrive\\Desktop\\Photos";
    File file;
    JFileChooser fileChooser = new JFileChooser(filePath);
    ImageViewerGUI(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Image Viewer");
        this.setSize(700, 700);
        this.setVisible(true);
        this.setResizable(true);
        basics();
        mainPanel();
    }
    public void basics() {
        selectFileButton.setText("Choose Image");
        selectFileButton.setFont(new Font("French Script MT", Font.BOLD, 30));
        selectFileButton.setForeground(Color.white);
        selectFileButton.setBackground(Color.black);
        selectFileButton.addActionListener(this);

        showImageButton.setText("Show Image");
        showImageButton.setFont(new Font("French Script MT", Font.BOLD, 30));
        showImageButton.setForeground(Color.white);
        showImageButton.setBackground(Color.black);
        showImageButton.addActionListener(this);

        brightnessButton.setText("Brightness");
        brightnessButton.setFont(new Font("French Script MT", Font.BOLD, 30));
        brightnessButton.setForeground(Color.white);
        brightnessButton.setBackground(Color.black);
        brightnessButton.addActionListener(this);

        grayscaleButton.setText("Gray Scale");
        grayscaleButton.setFont(new Font("French Script MT", Font.BOLD, 30));
        grayscaleButton.setForeground(Color.white);
        grayscaleButton.setBackground(Color.black);
        grayscaleButton.addActionListener(this);

        resizeButton.setText("Resize");
        resizeButton.setFont(new Font("French Script MT", Font.BOLD, 30));
        resizeButton.setForeground(Color.white);
        resizeButton.setBackground(Color.black);
        resizeButton.addActionListener(this);

        closeButton.setText("Exit");
        closeButton.setFont(new Font("French Script MT", Font.BOLD, 30));
        closeButton.setForeground(Color.white);
        closeButton.setBackground(Color.black);
        closeButton.addActionListener(this);

        backButton.addActionListener(this);
        backButton.setText("Back");
        backButton.setFont(new Font("French Script MT", Font.BOLD, 22));
        backButton.setBounds(60, 550, 90, 50);
        backButton.setForeground(Color.white);
        backButton.setBackground(Color.black);

        showResizeButton.addActionListener(this);
        showResizeButton.setText("Result");
        showResizeButton.setFont(new Font("French Script MT", Font.BOLD, 22));
        showResizeButton.setBounds(550, 550, 90, 50);
        showResizeButton.setForeground(Color.white);
        showResizeButton.setBackground(Color.black);

        heightTextField.setText(null);
        heightTextField.addActionListener(this);
        heightTextField.setBounds(350, 350, 100, 50);

        widthTextField.setText(null);
        widthTextField.addActionListener(this);
        widthTextField.setBounds(350, 250, 100, 50);

        brightnessTextField.addActionListener(this);
        brightnessTextField.setBounds(300, 300, 150, 70);

        showBrightnessButton.addActionListener(this);
        showBrightnessButton.setText("Result");
        showBrightnessButton.setFont(new Font("French Script MT", Font.BOLD, 22));
        showBrightnessButton.setBounds(550, 550, 90, 50);
        showBrightnessButton.setForeground(Color.white);
        showBrightnessButton.setBackground(Color.black);

    }
    public void mainPanel(){
        // Create main panel for adding to Frame
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);

        // Create Grid panel for adding buttons to it, then add it all to main panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(3, 2, 10, 10));

        buttonsPanel.setBounds(120, 300, 460, 200);

        // Adding all buttons to Grid panel
        buttonsPanel.add(this.selectFileButton);
        buttonsPanel.add(this.showImageButton);
        buttonsPanel.add(this.brightnessButton);
        buttonsPanel.add(this.grayscaleButton);
        buttonsPanel.add(this.resizeButton);
        buttonsPanel.add(this.closeButton);

        // add Grid panel that contains 6 buttons to main panel
        mainPanel.add(buttonsPanel);
        JLabel label = new JLabel("Image Viewer");
        label.setFont(new Font("French Script MT", Font.BOLD, 50));
        label.setBounds(230, 100, 500, 100);
        mainPanel.add(label);
        // add main panel to our frame
        this.add(mainPanel);
    }
    public void resizePanel(){
        JPanel resizePanel = new JPanel();
        resizePanel.setLayout(null);

        JLabel label = new JLabel("Resize Section");
        label.setFont(new Font("French Script MT", Font.BOLD, 30));
        label.setBounds(260, 100, 200, 70);

        JLabel widthLabel = new JLabel("Width:");
        widthLabel.setFont(new Font("French Script MT", Font.BOLD, 25));
        widthLabel.setBounds(230, 250, 200, 70);
        widthTextField.setText(null);

        JLabel heightLabel = new JLabel("Height:");
        heightLabel.setFont(new Font("French Script MT", Font.BOLD, 25));
        heightLabel.setBounds(230, 350, 200, 70);
        heightTextField.setText(null);

        resizePanel.add(widthTextField);
        resizePanel.add(heightTextField);
        resizePanel.add(backButton);
        resizePanel.add(showResizeButton);
        resizePanel.add(label);
        resizePanel.add(widthLabel);
        resizePanel.add(heightLabel);
        this.add(resizePanel);
    }
    public void brightnessPanel(){
        JPanel brightnessPanel = new JPanel();
        brightnessPanel.setLayout(null);

        JLabel label = new JLabel("Enter F (Between 0 and 2)");
        label.setFont(new Font("French Script MT", Font.BOLD, 22));
        label.setBounds(100, 300, 200, 70);

        brightnessTextField.setText(null);

        brightnessPanel.add(label);
        brightnessPanel.add(showBrightnessButton);
        brightnessPanel.add(backButton);
        brightnessPanel.add(brightnessTextField);
        this.add(brightnessPanel);
    }
    public void chooseFileImage(){
        fileChooser.setAcceptAllFileFilterUsed(false);
        int option = fileChooser.showOpenDialog(ImageViewerGUI.this);
        if (option == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
        }
    }
    public void showOriginalImage(){
        JFrame tempFrame = new JFrame();
        JPanel tempPanel = new JPanel();
        System.out.println("HEY I'm In");
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(String.valueOf(file)).getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT));
        pictureLabel.setIcon(imageIcon);
        pictureLabel.setLayout(new BorderLayout());
        tempPanel.add(pictureLabel, BorderLayout.CENTER);

        tempPanel.setSize(1800, 1000);
        tempFrame.setTitle("Image Viewer");
        tempFrame.setSize(1800, 1000);
        tempFrame.setVisible(true);
        tempFrame.setResizable(true);
        tempFrame.add(tempPanel);
        tempFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    public void grayScaleImage(){
        JFrame tempFrame = new JFrame();
        JPanel tempPanel = new JPanel();

        ImageIcon imageIcon = new ImageIcon(new ImageIcon(String.valueOf(file)).getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT));
        BufferedImage bufferedImage = new BufferedImage(imageIcon.getImage().getWidth(null), imageIcon.getImage().getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics g = bufferedImage.createGraphics();
        g.drawImage(imageIcon.getImage(), 0, 0, null);
        ColorConvertOp op = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
        op.filter(bufferedImage, bufferedImage);
        ImageIcon grayImageIcon = new ImageIcon(bufferedImage);

        pictureLabel.setIcon(grayImageIcon);
        pictureLabel.setLayout(new BorderLayout());
        tempPanel.add(pictureLabel, BorderLayout.CENTER);

        tempPanel.setSize(1800, 1000);
        tempFrame.setTitle("Image Viewer");
        tempFrame.setSize(1800, 1000);
        tempFrame.setVisible(true);
        tempFrame.setResizable(true);
        tempFrame.add(tempPanel);
        tempFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    public void showResizeImage(int w, int h){
        JFrame tempFrame = new JFrame();
        JPanel tempPanel = new JPanel();

        ImageIcon imageIcon = new ImageIcon(new ImageIcon(String.valueOf(file)).getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT));
        pictureLabel.setIcon(imageIcon);
        pictureLabel.setLayout(new BorderLayout());
        tempPanel.add(pictureLabel, BorderLayout.CENTER);

        tempPanel.setSize(1800, 1000);
        tempFrame.setTitle("Image Viewer");
        tempFrame.setSize(1800, 1000);
        tempFrame.setVisible(true);
        tempFrame.setResizable(true);
        tempFrame.add(tempPanel);
        tempFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    public void showBrightnessImage(float f){
        JFrame tempFrame = new JFrame();
        JPanel tempPanel = new JPanel();

        ImageIcon imageIcon = new ImageIcon(new ImageIcon(String.valueOf(file)).getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT));
        BufferedImage image = new BufferedImage(imageIcon.getIconWidth(), imageIcon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        image.getGraphics().drawImage(imageIcon.getImage(), 0, 0, imageIcon.getImageObserver());
        RescaleOp op = new RescaleOp(f, 0, null);
        image = op.filter(image, image);
        imageIcon.setImage(image);
        pictureLabel.setIcon(imageIcon);
        pictureLabel.setLayout(new BorderLayout());
        tempPanel.add(pictureLabel, BorderLayout.CENTER);

        tempPanel.setSize(1800, 1000);
        tempFrame.setTitle("Image Viewer");
        tempFrame.setSize(1800, 1000);
        tempFrame.setVisible(true);
        tempFrame.setResizable(true);
        tempFrame.add(tempPanel);
        tempFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == resizeButton){
            if (file == null)
                JOptionPane.showMessageDialog(null, "Inputs Image");
            else {
                this.getContentPane().removeAll();
                resizePanel();
                this.revalidate();
                this.repaint();
            }
        }
        if(e.getSource() == showImageButton){
            if (file == null)
                JOptionPane.showMessageDialog(null, "Inputs Image");
            else
                showOriginalImage();
        }
        if(e.getSource() == grayscaleButton){
            if (file == null)
                JOptionPane.showMessageDialog(null, "Inputs Image");
            else
                grayScaleImage();
        }
        if(e.getSource() == showResizeButton){
            try {
                showResizeImage(Integer.parseInt(heightTextField.getText()), Integer.parseInt(widthTextField.getText()));
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid Inputs");
            }
        }
         if(e.getSource() == brightnessButton){
             if (file == null)
                 JOptionPane.showMessageDialog(null, "Inputs Image");
             else {
                 this.getContentPane().removeAll();
                 brightnessPanel();
                 this.revalidate();
                 this.repaint();
             }
        }
        if(e.getSource() == showBrightnessButton){
            try {
                if (parseFloat(brightnessTextField.getText()) < 0 || parseFloat(brightnessTextField.getText()) > 2)
                    JOptionPane.showMessageDialog(null, "Invalid Inputs");
                else {
                    showBrightnessImage(parseFloat(brightnessTextField.getText()));
                }
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid Inputs");
            }
        }
        if(e.getSource()== selectFileButton){
            chooseFileImage();
        }
        if(e.getSource() == closeButton){
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
        if(e.getSource() == backButton){
            this.getContentPane().removeAll();
            mainPanel();
            this.revalidate();
            this.repaint();
        }
    }
}