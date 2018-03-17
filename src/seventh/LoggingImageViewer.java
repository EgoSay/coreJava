package seventh;

import java.util.logging.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.EventQueue;
import java.io.*;


/**
 * @author 96166
 */
public class LoggingImageViewer {
    public static void main(String[] args) {
		if(System.getProperty("java.util.logging.config.class")==null
				&&System.getProperty("java.util.logging.config.file")==null)
		{
			try
			{
				Logger.getLogger("com.horstmann.corejava").setLevel(Level.ALL);
				final int logRotationCount =10;
				Handler handler =new FileHandler("%h/LoggingImageViewer.log",0,logRotationCount );
				Logger.getLogger("com.horstmann.corejava").addHandler(handler);
			}
			catch (IOException e) {
				// TODO: handle exception
				Logger.getLogger("com.horstmann.corejava").log(Level.SEVERE,
						"Can't create log file handler",e);
			}
		}
		EventQueue.invokeLater(()->
		    {
			    Handler windowHandler=new WindowsHanlder();
			    windowHandler.setLevel(Level.ALL);
			    Logger.getLogger("com.horstmann.corejava").addHandler(windowHandler);
			    
			    JFrame frame=new ImageViewerFrame();
			    frame.setTitle("LoggingImageViewer");
			    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    
			    Logger.getLogger("com.horstmann.corejava").fine("Showing Frame");
			    frame.setVisible(true);
		    });
	}
}
class WindowsHanlder extends StreamHandler
{
	private JFrame frame;
	public WindowsHanlder() 
	{
		frame=new JFrame();
		final JTextArea output=new JTextArea();
		output.setEditable(false);
		frame.setSize(200, 200);
		frame.add(new JScrollPane(output));
		frame.setFocusableWindowState(false);
		frame.setVisible(true);
		setOutputStream(new OutputStream()
		{	
			@Override
			public void write(int b) throws IOException {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void write(byte[] b,int off,int len)
			{
				output.append(new String(b,off,len));
			}
		});
	}
	@Override
	public void publish(LogRecord record)
	{
		if(!frame.isVisible()){
			return;
		}
		super.publish(record);
		flush();
	}
}
