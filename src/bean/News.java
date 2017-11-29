package bean;

public class News {
	private int idNews;
	private String nameNews;
	private String previewNews;
	private String detailNews;
	private String picture;
	public int getIdNews() {
		return idNews;
	}
	public void setIdNews(int idNews) {
		this.idNews = idNews;
	}
	public String getNameNews() {
		return nameNews;
	}
	public void setNameNews(String nameNews) {
		this.nameNews = nameNews;
	}
	public String getPreviewNews() {
		return previewNews;
	}
	public void setPreviewNews(String previewNews) {
		this.previewNews = previewNews;
	}
	public String getDetailNews() {
		return detailNews;
	}
	public void setDetailNews(String detailNews) {
		this.detailNews = detailNews;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public News(int idNews, String nameNews, String previewNews,
			String detailNews, String picture) {
		super();
		this.idNews = idNews;
		this.nameNews = nameNews;
		this.previewNews = previewNews;
		this.detailNews = detailNews;
		this.picture = picture;
	}
	public News() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
