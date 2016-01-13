package main;

import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import shelf.ShelfBook;


public class ReaderFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6630165611817814347L;
	
	/**
	 * 顶部/底部界面
	 */
	private JPanel topPane = null;
	private JPanel bottomPane = null;
	
	/**
	 * 书架界面
	 */
	private JPanel shelfPane = null;
	
	/**
	 * 阅读界面
	 */
	private JScrollPane readingPane = null;
	private JTextArea readingArea = null;
	
	/**
	 * 控件
	 */
	private JButton openBtn = null;
	private JLabel timeLabel = null;
	private JButton backToShelfBtn = null;
	private JButton settingBtn = null;
	private JLabel percentageLabel = null;
	
	
	/**
	 * 阅读进度
	 */
	private StringBuffer readingBuffer = new StringBuffer();
	private BufferedReader reader;
	
	private ArrayList<ShelfBook> bookList = new ArrayList<ShelfBook>();
	public ReaderFrame() {
		if (readConfiguration()){
			initComponent();
			addComponent();
			addListener();
			showFrame();
		}else{
			System.out.println("读取软件配置失败！");
		}
	}

	/**
	 * 读取配置文件，配置文件不存在时，创建配置文件
	 * @return 读取成功或创建成功返回TRUE
	 */
	private boolean readConfiguration(){
		return true;
	}
	/**
	 * 初始化组件
	 */
	private void initComponent(){		
		// 上下界面
		this.topPane = new JPanel();
		this.bottomPane = new JPanel();
		
		// 中心界面
		this.shelfPane = new JPanel();
		this.readingArea = new JTextArea();
		this.readingArea.setLineWrap(true);
		this.readingPane = new JScrollPane(readingArea, 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		// 控件
		this.openBtn = new JButton("open");
		this.backToShelfBtn = new JButton("back");
		this.settingBtn = new JButton("setting");
		this.timeLabel = new JLabel("00:00:00");
		this.percentageLabel = new JLabel("0%");
		
	}
	/**
	 * 添加组件
	 */
	private void addComponent(){
		setShelfLayout();
	}
	/**
	 * 设置书架布局
	 */
	private void setShelfLayout(){
		this.setVisible(false);
		
		this.add(topPane, BorderLayout.NORTH);
		this.add(bottomPane, BorderLayout.SOUTH);
		this.add(shelfPane, BorderLayout.CENTER);
		
		this.topPane.add(openBtn);
		
		this.bottomPane.add(timeLabel);
				
		// to be added -- add shelf books
		//this.shelfPane.removeAll();
		if (!bookList.isEmpty()){
			Iterator<ShelfBook> it = bookList.iterator();
			while(it.hasNext()){
				shelfPane.add(new JButton(it.next().getFilePath()));
			}
		}

		this.setVisible(true);
	}
	/**
	 * 移除书架界面
	 */
	private void removeShelfLayout(){
		this.remove(topPane);
		this.remove(bottomPane);
		this.remove(shelfPane);
		this.topPane.removeAll();
		this.bottomPane.removeAll();
		this.shelfPane.removeAll();
	}
	/**
	 * 设置阅读布局
	 */
	private void setReadingLayout(){
		this.setVisible(false);
		
		this.add(topPane, BorderLayout.NORTH);
		this.add(bottomPane, BorderLayout.SOUTH);
		this.add(readingPane, BorderLayout.CENTER);
		
		this.topPane.add(backToShelfBtn);
		this.topPane.add(settingBtn);
		
		this.bottomPane.add(percentageLabel);
		this.bottomPane.add(timeLabel);

		this.setVisible(true);
	}
	private void removeReadingLayout(){
		this.remove(topPane);
		this.remove(bottomPane);
		this.remove(readingPane);
		this.topPane.removeAll();
		this.bottomPane.removeAll();
	}
	/**
	 * 添加监听器
	 */
	private void addListener(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.openBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChoose = new JFileChooser();
				fileChoose.setFileFilter(new FileNameExtensionFilter("txt文件", "txt"));
				fileChoose.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				fileChoose.showDialog(topPane.getParent(),"选择");
				File f = fileChoose.getSelectedFile();

				// to be added -- judge the file type
				
				removeShelfLayout();
				setReadingLayout();

				ShelfBook book = new ShelfBook(f.getPath());
				addBookToShelf(book);
				startReading(book);
			}
		});
		
		this.backToShelfBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				removeReadingLayout();
				setShelfLayout();
			}
		});
		
		this.readingArea.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}			
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1){
					if(e.getX() > readingArea.getVisibleRect().getWidth()/2){
						try{
							readingBuffer.append(reader.readLine() + "\n");
							readingArea.setText(readingBuffer.toString());
						}catch (Exception ee){ee.printStackTrace();}
						System.out.println("nextPage");
					}else{
						System.out.println("prevPage");
					}
				}
			}			
			@Override
			public void mouseExited(MouseEvent e) {
			}			
			@Override
			public void mouseEntered(MouseEvent e) {
			}			
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		this.addKeyListener(new KeyListener() {
					
					@Override
					public void keyTyped(KeyEvent e) {
					}
					
					@Override
					public void keyReleased(KeyEvent e) {
					}
					
					@Override
					public void keyPressed(KeyEvent e) {
						if (e.getKeyCode() == KeyEvent.VK_RIGHT){

							try{
								readingBuffer.append(reader.readLine() + "\n");
								readingArea.setText(readingBuffer.toString());
							}catch (Exception ee){ee.printStackTrace();}
							System.out.println("nextPage");
						}
					}
				});
		
		
		

	}
	/**
	 * 将选择的书添加到书架
	 * @param f
	 */
	private void addBookToShelf(ShelfBook book){
		if (!bookList.isEmpty()){
			Iterator<ShelfBook> it = bookList.iterator();
			boolean found = false;
			while(it.hasNext()){
				if (it.next().isSameBook(book)){
					found = true;
					System.out.println("本书已经在书架上！");
				}
			}
			if (!found){
				bookList.add(book);
				System.out.println("已经添加--"+book.getFilePath());
			}
		}else{
			bookList.add(book);
			System.out.println("已经添加--"+book.getFilePath());
		}
	}
	/**
	 * 开始读书
	 * @param book
	 */
	private void startReading(ShelfBook book){
		try{
			readingBuffer.setLength(0);
			reader = new BufferedReader(new FileReader(book.getFilePath()));
			readingBuffer.append(reader.readLine() + "\n");
			readingArea.setText(readingBuffer.toString());
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 显示界面
	 */
	private void showFrame(){
		try{
			String lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel"; 
			UIManager.setLookAndFeel(lookAndFeel); 
		}catch (Exception e){
			e.printStackTrace();
		}

		int height = (int)(this.getToolkit().getScreenSize().getHeight());
		int width = (int)(this.getToolkit().getScreenSize().getWidth());
		int sizeW = 400,sizeH = 300;
		this.setSize(sizeW, sizeH);
		this.setLocation((width - sizeW)/2, (height - sizeH)/2);
		this.setFocusable(true);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new ReaderFrame();
	}

}
