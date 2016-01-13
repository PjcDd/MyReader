package shelf;

public class ShelfBook {
	private String filePath = null;
	public ShelfBook(String filePath) {
		this.filePath = filePath;
	}
	
	public String getFilePath(){
		return this.filePath;
	}
	
	public boolean isSameBook(ShelfBook checkBook){
		if (checkBook!=null && filePath!=null && this.filePath.equals(checkBook.filePath)){
			return true;
		}
		return false;
	}
}
