package seventh;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.*;
import javax.swing.*;

class ImageViewerFrame extends JFrame {
    private static final int DEFAULT_WIDTH=300;
    private static final int DEFAULT_HEIGHT=400;
    private JLabel label;
    private static Logger logger=Logger.getLogger("com.horstmann.corejava");
    public ImageViewerFrame() {
		// TODO Auto-generated constructor stub
    	logger.entering("ImageViewerFrame", "<init>");
    	setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    	JMenuBar menuBar=new JMenuBar();
    	setJMenuBar(menuBar);
    	JMenu menu=new JMenu("File");
    	menuBar.add(menu);
    	JMenuItem openItem=new JMenuItem("Open");
    	menu.add(openItem);
    	openItem.addActionListener(new FileOpenListener());
    	
    	JMenuItem exitItem=new JMenuItem("exit");
    	menu.add(exitItem);
    	exitItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				logger.fine("Exiting");
				System.exit(0);
			}
		});
    	//use a label to display the images
    	label=new JLabel();
    	add(label);
    	logger.exiting("ImageViewerFrame", "<init>");
	}
    private class FileOpenListener implements ActionListener
    {
    	@Override
    	public void actionPerformed(ActionEvent event)
    	{
    		logger.entering("ImageViewerFrame.FileOpenListener", "actionPerformed",event);
    		//set up file chooser
    		JFileChooser chooser=new JFileChooser();
    		chooser.setCurrentDirectory(new File("."));
    		//accept all files ending with .gif
    		chooser.setFileFilter(new javax.swing.filechooser.FileFilter()
    			{
    			@Override
    			    public boolean accept(File f)
    			    {
    			    	return f.getName().toLowerCase().endsWith(".gif")||f.isDirectory();
    			    }
    			@Override
    			    public String getDescription()
    			    {
    			    	return "GIF Images";
    			    }
    			});
    		//show file chooser dialog
    		int r=chooser.showOpenDialog(ImageViewerFrame.this);
    		//if image file accepted, set it as icon of the label
    		if(r==JFileChooser.APPROVE_OPTION)
    		{
    			String name=chooser.getSelectedFile().getPath();
    			logger.log(Level.FINE,"Reading file {0}",name);
    			label.setIcon(new ImageIcon(name));
    		}
    		else {
                logger.fine("File open dialog canceled.");
            }
    		logger.exiting("ImageViewerFrame.FileOpenListener", "actionPerformed");
    	}
    }
}
