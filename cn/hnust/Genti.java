package cn.hnust;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class Genti extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/plain;charset=utf-8");
		String tiku_id = request.getParameter("id");
		System.out.println("id:" + tiku_id);
		
		try {
			////////////
			// do something
			////////////
			DBConnection db = new DBConnection();
			ResultSet rs = db.executeQuery("select * from tiku where id = '" + tiku_id +"'");
			
			String id = "";
			String question = "";
			String a = "";
			String b = "";
			String c = "";
			String d = "";
			String answer = "";
			
			
			int count=0;
			ArrayList<Question>list=new ArrayList<Question>();
			
			while(rs.next()){
				count++;
				
				question=rs.getString(2);
				a=rs.getString(3);
				b=rs.getString(4);
				c=rs.getString(5);
				d=rs.getString(6);
				answer=rs.getString(7);
				Question q=new Question(id,question,a,b,c,d,answer);
				list.add(q);
			}
			db.close();
			
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			JSONObject obj = new JSONObject();
			
			JSONObject obj1 = new JSONObject();
			Question q1=list.get(0);
			obj1.put("id", q1.id);
			obj1.put("question", q1.question);
			obj1.put("a", q1.a);
			obj1.put("b", q1.b);
			obj1.put("c", q1.c);
			obj1.put("d", q1.d);
			obj1.put("answer", q1.answer);
			obj1.put("question1", obj1);
			
			JSONObject obj2 = new JSONObject();
			Question q2=list.get(1);
			obj2.put("id", q2.id);
			obj2.put("question", q2.question);
			obj2.put("a", q2.a);
			obj2.put("b", q2.b);
			obj2.put("c", q2.c);
			obj2.put("d", q2.d);
			obj2.put("answer", q2.answer);
			obj2.put("question2", obj2);
			
			JSONObject obj3 = new JSONObject();
			Question q3=list.get(2);
			obj3.put("id", q3.id);
			obj3.put("question", q3.question);
			obj3.put("a", q3.a);
			obj3.put("b", q3.b);
			obj3.put("c", q3.c);
			obj3.put("d", q3.d);
			obj3.put("answer", q3.answer);
			obj3.put("question3", obj3);
			
			JSONObject obj4 = new JSONObject();
			Question q4=list.get(0);
			obj4.put("id", q4.id);
			obj4.put("question", q4.question);
			obj4.put("a", q4.a);
			obj4.put("b", q4.b);
			obj4.put("c", q4.c);
			obj4.put("d", q4.d);
			obj4.put("answer", q4.answer);
			obj4.put("question4", obj4);
			
			System.out.println(obj.toString());
			out.print(obj.toString());
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void doSearch(String tiku_id) {
		try {
			
			DBConnection db = new DBConnection();
			ResultSet rs = db.executeQuery("select * from tiku where id = '" + tiku_id +"'");
			
			String id = "";
			String question = "";
			String a = "";
			String b = "";
			String c = "";
			String d = "";
			//String answer = "";
			
			while(rs.next()){
				question=rs.getString(1);
				a=rs.getString(2);
				b=rs.getString(3);
				c=rs.getString(4);
				d=rs.getString(4);
				//answer=rs.getString(4);
			}
			db.close();
			
			JSONObject obj = new JSONObject();
			
		
			obj.put("id", id);
			obj.put("question", question);
			obj.put("a", a);
			obj.put("b", b);
			obj.put("c", c);
			obj.put("d", d);
			//obj.put("answer", answer);
			
			System.out.println(obj.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		doSearch("t1");
		doSearch("t2");
		doSearch("t3");
		doSearch("t4");
		
	}

}
