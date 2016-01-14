package shelf;

public class ShelfBook {
	/**
	 * ��Ŀ¼���ļ���
	 */
	private String filePath = null;
	/**
	 * �����ʾ�õİ�ť
	 */
	private BookButton shelfBtn = null;
	
	/**
	 * ���죬�����鱾�����鱾��ť
	 * @param filePath
	 */
	public ShelfBook(String filePath) {
		this.filePath = filePath;
		this.shelfBtn = new BookButton(getFileName());
	}
	
	/**
	 * ��ȡ�鱾����·��
	 * @return
	 */
	public String getFilePath(){
		return this.filePath;
	}
	/**
	 * ��ȡ�鱾��ťʵ��
	 * @return
	 */
	public BookButton getButton(){
		return this.shelfBtn;
	}
	
	/**
	 * ��ȡ�鱾����
	 * @return
	 */
	public String getFileName(){
		return this.filePath.substring(this.filePath.lastIndexOf("\\")+1, 
				this.filePath.lastIndexOf("."));
	}
	
	/**
	 * �ж��Ƿ��뱾����ͬһ������������·���ж�
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
