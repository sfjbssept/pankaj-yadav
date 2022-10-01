import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Test {
	
	public static void main(String[] args) {
		List<TestUser> oldPasList = new ArrayList<>();
		TestUser user1 = new TestUser();
		user1.setId(101);
		user1.setName("test1");
		
		TestUser user2 = new TestUser();
		user2.setId(102);
		user2.setName("test2");
		
		oldPasList.add(user1);
		oldPasList.add(user2);
		System.out.println(oldPasList);
		List<TestUser> newPasList = addStandard(12, oldPasList);
		System.out.println(newPasList);
	}
	
	public static List<TestUser> addStandard(Integer standard, List<TestUser> testUserDetail) {
		List<TestUser> passangerList = new ArrayList<>();

		ListIterator<TestUser> iterator = testUserDetail.listIterator();
		while (iterator.hasNext()) {
			TestUser t = iterator.next();
			t.setStandard(standard);
			System.out.println("ttttt   "+t);
			passangerList.add(t);
		}
		return passangerList;
		
	}

}
