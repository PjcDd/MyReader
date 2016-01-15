package shelf;

public class ShelfBook {
	/**
	 * 书目录及文件名
	 */
	private String filePath = null;
	/**
	 * 书架显示用的按钮
	 */
	private BookButton shelfBtn = null;
	/**
	 * 文档总行数，用于处理进度
	 */
	private int lineCount = 0;
	/**
	 * 当前读到的行数
	 */
	private int currentLine = 0;
	/**
	 * 当前进度
	 */
	private int currentPercentage = 0;
	
	/**
	 * 构造，创建书本，及书本按钮
	 * @param filePath
	 */
	public ShelfBook(String filePath) {
		this.filePath = filePath;
		this.shelfBtn = new BookButton(getFileName());
	}
	
	/**
	 * 获取书本完整路径
	 * @return
	 */
	public String getFilePath(){
		return this.filePath;
	}
	/**
	 * 获取书本按钮实例
	 * @return
	 */
	public BookButton getButton(){
		return this.shelfBtn;
	}
	
	/**
	 * 获取书本名称
	 * @return
	 */
	public String getFileName(){
		return this.filePath.substring(this.filePath.lastIndexOf("\\")+1, 
				this.filePath.lastIndexOf("."));
	}
	
	/**
	 * 设置文档总行数
	 * @param lineCount
	 */
	public void setLineCount(int lineCount){
		this.lineCount = lineCount;
	}
	/**
	 * 获取文档总行数
	 * @return
	 */
	public int getLineCount(){
		return this.lineCount;
	}
	/**
	 * 设置当前行数
	 * @param currentLine
	 */
	public void setCurrentLine(int currentLine){
		this.currentLine = currentLine;
	}
	/**
	 * 获取当前行数
	 * @return
	 */
	public int getCurrentLine(){
		return this.currentLine;
	}
	/**
	 * 获取当前百分比
	 * @return
	 */
	public float getCurrentPercentage(){
		return ((float)this.currentLine/(float)this.lineCount)*100;
	}
	
	/**
	 * 判断是否与本书是同一本，根据完整路径判断
	 * @param checkBook
	 * @return
	 */
	public boolean isSameBook(ShelfBook checkBook){
		if (checkBook!=null && filePath!=null && this.filePath.equals(checkBook.filePath)){
			return true;
		}
		return false;
	}
}
