package Model;

import java.util.Date;

public class Build_System {
	private Integer Build_A_id;
	private String 	Build_A_name;
	private String	Build_A_man;
	private Integer Build_A_worker;
	private String 	Build_A_work;
	private Boolean Build_A_safe;
	private String 	Build_A_remind;
	private Integer Build_B_id;
	private String	Build_B_name;
	private String	Build_B_editor;
	private Date	Build_B_date;
	private	String	Build_B_service;
	private Double	Build_B_unitprice;//單價
	private Double	Build_B_quantity;//數量
	private Double	Build_B_discount;//折扣
	private Double	Build_B_sum;//總和
	private String	Build_B_cooperation;//合作專案
	private Boolean	Build_B_arrears;//欠款紀錄
	private String 	Build_B_remind;//備註
	private String	Build_personname;
	private String  Build_password;
	public Build_System() {
	super();
	}
	
	public Build_System(String build_A_name, String build_A_man, Integer build_A_worker, String build_A_work,
			Boolean build_A_safe, String build_A_remind) {
		super();
		Build_A_name = build_A_name;
		Build_A_man = build_A_man;
		Build_A_worker = build_A_worker;
		Build_A_work = build_A_work;
		Build_A_safe = build_A_safe;
		Build_A_remind = build_A_remind;
	}
	public Build_System(String build_B_name,String build_B_editor, Date build_B_date, String build_B_service, Double build_B_unitprice,
			Double build_B_quantity, Double build_B_discount,String build_B_cooperation,Boolean build_B_arrears, String build_B_remind) {
		super();
		Build_B_name=build_B_name;
		Build_B_editor = build_B_editor;
		Build_B_date = build_B_date;
		Build_B_service = build_B_service;
		Build_B_unitprice = build_B_unitprice;
		Build_B_quantity = build_B_quantity;
		Build_B_discount = build_B_discount;
		//Build_B_sum = build_B_sum;
		Build_B_cooperation = build_B_cooperation;
		Build_B_arrears = build_B_arrears;
		Build_B_remind = build_B_remind;
		
	}
	
	
	
	public Build_System(String build_personname, String build_password) {
		super();
		Build_personname = build_personname;
		Build_password = build_password;
	}
	
	

	public String getBuild_personname() {
		return Build_personname;
	}

	public void setBuild_personname(String build_personname) {
		Build_personname = build_personname;
	}

	public String getBuild_password() {
		return Build_password;
	}

	public void setBuild_password(String build_password) {
		Build_password = build_password;
	}

	public String getBuild_B_name() {
		return Build_B_name;
	}
	public void setBuild_B_name(String bild_B_name) {
		Build_B_name = bild_B_name;
	}
	public String getBuild_A_name() {
		return Build_A_name;
	}
	public void setBuild_A_name(String build_A_name) {
		Build_A_name = build_A_name;
	}
	public String getBuild_A_man() {
		return Build_A_man;
	}
	public void setBuild_A_man(String build_A_man) {
		Build_A_man = build_A_man;
	}
	public Integer getBuild_A_worker() {
		return Build_A_worker;
	}
	public void setBuild_A_worker(Integer build_A_worker) {
		Build_A_worker = build_A_worker;
	}
	public String getBuild_A_work() {
		return Build_A_work;
	}
	public void setBuild_A_work(String build_A_work) {
		Build_A_work = build_A_work;
	}
	public Boolean getBuild_A_safe() {
		return Build_A_safe;
	}
	public void setBuild_A_safe(Boolean build_A_safe) {
		Build_A_safe = build_A_safe;
	}
	public String getBuild_A_remind() {
		return Build_A_remind;
	}
	public void setBuild_A_remind(String build_A_remind) {
		Build_A_remind = build_A_remind;
	}
	public String getBuild_B_editor() {
		return Build_B_editor;
	}
	public void setBuild_B_editor(String build_B_editor) {
		Build_B_editor = build_B_editor;
	}
	public Date getBuild_B_date() {
		return Build_B_date;
	}
	public void setBuild_B_date(Date build_B_date) {
		Build_B_date = build_B_date;
	}
	public String getBuild_B_service() {
		return Build_B_service;
	}
	public void setBuild_B_service(String build_B_service) {
		Build_B_service = build_B_service;
	}
	public Double getBuild_B_unitprice() {
		return Build_B_unitprice;
	}
	public void setBuild_B_unitprice(Double build_B_unitprice) {
		Build_B_unitprice = build_B_unitprice;
	}
	public Double getBuild_B_quantity() {
		return Build_B_quantity;
	}
	public void setBuild_B_quantity(Double build_B_quantity) {
		Build_B_quantity = build_B_quantity;
	}
	public Double getBuild_B_discount() {
		return Build_B_discount;
	}
	public void setBuild_B_discount(Double build_B_discount) {
		Build_B_discount = build_B_discount;
	}
	public Double getBuild_B_sum() {
		Build_B_sum=(getBuild_B_unitprice()*getBuild_B_quantity())*getBuild_B_discount();
		return Build_B_sum;
	}
	public void setBuild_B_sum(Double build_B_sum) {
		Build_B_sum = build_B_sum;
	}
	public String getBuild_B_cooperation() {
		return Build_B_cooperation;
	}
	public void setBuild_B_cooperation(String build_B_cooperation) {
		Build_B_cooperation = build_B_cooperation;
	}
	public boolean getBuild_B_arrears() {
		return Build_B_arrears;
	}
	public void setBuild_B_arrears(Boolean build_B_arrears) {
		Build_B_arrears = build_B_arrears;
	}
	public String getBuild_B_remind() {
		return Build_B_remind;
	}
	public void setBuild_B_remind(String build_B_remind) {
		Build_B_remind = build_B_remind;
	}
	public void showA() 
	{ 
		System.out.println("專案編號:"+Build_A_id+"\t建案名稱:"+Build_A_name
							+"\t建案負責人:"+Build_A_man+"\t當日進場人員:"+Build_A_worker
							+"  人\t進場工項:"+Build_A_work+"\t勞工安檢:"+Build_A_safe
							+"\t備註:"+Build_A_remind);
	}
	public void showB() 
	{
		System.out.println("廠商名稱:"+Build_B_name+"\t統編:"+Build_B_editor
							+"\t進場日期:"+Build_B_date+"\t服務內容:"+Build_B_service
							+"\t單價:"+Build_B_unitprice+"\t折扣:"+Build_B_discount
							+"\t數量:"+Build_B_quantity+"\t總價:"+Build_B_sum
							+"\t合作專案:"+Build_B_cooperation+"\t欠款紀錄"+Build_B_arrears
							+"\t備註"+Build_B_remind);
	}
	
	public String queryA1() 
	{	
		return "專案名稱:"+getBuild_A_name()+"\t建案負責人:"+getBuild_A_man()+"\t當日進場人員:"+getBuild_A_worker()
				+"人\t進場工項:"+getBuild_A_work()+"\t勞工安檢:"+getBuild_A_safe()+"\t備註:"+getBuild_A_remind();
	}
	
	public String queryB1() 
	{	
		return "廠商名稱:"+getBuild_B_name()+"\t廠商統編:"+getBuild_B_editor()+"\t進場日期:"+getBuild_B_date()
				+"\t承包工項:"+getBuild_B_service()+"\t單價:"+getBuild_B_unitprice()+"\t數量:"+getBuild_B_quantity()
				+"\t折扣"+getBuild_B_discount()+"\t總價:"+getBuild_B_sum()+"\t合作專案:"+getBuild_B_cooperation()
				+"\t欠款紀錄:"+getBuild_B_arrears()+"\t備註:"+getBuild_B_remind()+"\n";
	}

}
