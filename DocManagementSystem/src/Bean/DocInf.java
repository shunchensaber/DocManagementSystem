package Bean;
/**
 * 
 * @author ³ÂË³
 * docinfµÄÐÅÏ¢
 *
 */
public class DocInf {
	private String  userid;
	private String  title;
	private String main;
	private String path;
	public DocInf(String userid,String title,String main,String path)
	{
		this.userid = userid;
		this.title = title;
		this.main = main;
		this.path = path;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	

}
