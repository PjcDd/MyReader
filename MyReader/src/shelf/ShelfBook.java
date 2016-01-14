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
