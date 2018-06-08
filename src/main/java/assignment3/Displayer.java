package assignment3;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Displayer extends JFrame {

    private DrawPanel drawPanel;
    private JLabel status;

    /**
     * This constructor will build the GUI consisting of
     * a main frame (Jframe)
     * A toolbar on the top of the screen with a file menu
     * An option to load an image
     * A toolbar that displays whether an image is loaded, and
     * whether it is a left eye or a right eye
     */
    public Displayer(){
        setTitle("Left-Right Eye Viewer");

        // Create file menubar
        JMenuBar menuBar = new JMenuBar();
        JMenuItem fileMenu = new JMenuItem("File");
        JMenuItem loadImage = new JMenuItem("Load Image");
        loadImage.addActionListener(new ButtonHandler());
        fileMenu.add(loadImage);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        // Create widget panel
        drawPanel = new DrawPanel();
        JPanel widgetPanel = new JPanel();
        widgetPanel.setLayout(new GridLayout(1, 1));
        status = new JLabel("Status: Ready");
        widgetPanel.add(status);

        add(widgetPanel, BorderLayout.NORTH);
        add(drawPanel, BorderLayout.CENTER);

        // Set size
        setSize(new Dimension(1000, 1000));

        // Exits software upon closing of window
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // display
        setVisible(true);
    }

    private class DrawPanel extends JPanel{

        private PremadeImage grayScaleImage = null;

        DrawPanel(){}

        @Override
        public void paintComponent(Graphics g){
            if(grayScaleImage != null){
                BufferedImage bimg = grayScaleImage.renderableImage();
                Image toRender = bimg.getScaledInstance(1000,1000, Image.SCALE_FAST);
                g.drawImage(toRender, 0,0,null);
            }
        }

        private void loadImage(){

            JFileChooser jfc = new JFileChooser(System.getProperty("user.home"));
            jfc.setDialogTitle("Select an annotation");
            jfc.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "png", "gif", "jpg");
            jfc.addChoosableFileFilter(filter);
            String image_path = "";

            int returnValue = jfc.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                image_path = jfc.getSelectedFile().getPath();
            }else{
                return;
            }

            grayScaleImage = new GrayScaleImage(image_path);

            try{
                ((GrayScaleImage)grayScaleImage).convertToGrayScale();
            }catch (GrayScaleImage.RGBException e){
                status.setText("image could not be converted");
            }

            status.setText("Determined eye: " + analyzeImage());
            repaint(); // call to paint image to screen
        }

        private String analyzeImage(){
            // TODO: use your code from assignment 2 here
            // How will you use call your optic disk function?

            // TODO: create your new analyzer here
            // return a string that says "Left" for left eye and "Right" for right eye
            return "";
        }
    }

    private class ButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(event.getActionCommand().equals("Load Image")){
                drawPanel.loadImage();
            }
        }
    }
}
