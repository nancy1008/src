package cn.hnust;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

public class DBTest {

	public static void main(String[] args) {
		try {
			DBConnection b =new DBConnection();
			String sql = "insert into tiku(id,question,a,b,c,d,answer) values('1507','Tom','hijsf','hnf','计算机','tero','湖南')";
			
			b.execute(sql);
			ResultSet rs = b.executeQuery("select * from tiku");
			
			ArrayList<Question> list = new ArrayList();
			while(rs.next()){
				String id = rs.getString(1);
				String question = rs.getString(2);
				String a = rs.getString(3);
				String B = rs.getString(4);
				String c = rs.getString(5);
				String d = rs.getString(6);
				String answer = rs.getString(7);
				
				Question t = new Question(id,question,a,B,c,d,answer);
				list.add(t);
			}
			b.close();
			Random r = new Random();
			int j=0;
			int[] ques= {-1,-1,-1,-1};
			while(j<4) {
				int randnumber = r.nextInt(list.size());
				System.out.println(randnumber);
				//if null; 
				ques[j] = randnumber;
				j++;
			}
			
			for(int k=0;k<4;k++) {
				Question s = list.get(k);
				System.out.println(s.getId());
				System.out.println(s.getquestion());
				System.out.println(s.geta());
				System.out.println(s.getb());
				System.out.println(s.getc());
				System.out.println(s.getd());
				//System.out.println(s.getanswer());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
